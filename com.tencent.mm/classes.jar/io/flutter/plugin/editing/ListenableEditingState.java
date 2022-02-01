package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import java.util.ArrayList;
import java.util.Iterator;

class ListenableEditingState
  extends SpannableStringBuilder
{
  private static final String TAG = "ListenableEditingState";
  private int mBatchEditNestDepth;
  private int mChangeNotificationDepth;
  private int mComposingEndWhenBeginBatchEdit;
  private int mComposingStartWhenBeginBatchEdit;
  private BaseInputConnection mDummyConnection;
  private ArrayList<EditingStateWatcher> mListeners;
  private ArrayList<EditingStateWatcher> mPendingListeners;
  private int mSelectionEndWhenBeginBatchEdit;
  private int mSelectionStartWhenBeginBatchEdit;
  private String mTextWhenBeginBatchEdit;
  private String mToStringCache;
  
  public ListenableEditingState(TextInputChannel.TextEditState paramTextEditState, View paramView)
  {
    AppMethodBeat.i(189743);
    this.mBatchEditNestDepth = 0;
    this.mChangeNotificationDepth = 0;
    this.mListeners = new ArrayList();
    this.mPendingListeners = new ArrayList();
    if (paramTextEditState != null) {
      setEditingState(paramTextEditState);
    }
    this.mDummyConnection = new BaseInputConnection(paramView, true)
    {
      public Editable getEditable()
      {
        return jdField_this;
      }
    };
    AppMethodBeat.o(189743);
  }
  
  private void notifyListener(EditingStateWatcher paramEditingStateWatcher, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(189751);
    this.mChangeNotificationDepth += 1;
    paramEditingStateWatcher.didChangeEditingState(paramBoolean1, paramBoolean2, paramBoolean3);
    this.mChangeNotificationDepth -= 1;
    AppMethodBeat.o(189751);
  }
  
  private void notifyListenersIfNeeded(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(189759);
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        notifyListener((EditingStateWatcher)localIterator.next(), paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
    AppMethodBeat.o(189759);
  }
  
  public void addEditingStateListener(EditingStateWatcher paramEditingStateWatcher)
  {
    AppMethodBeat.i(189803);
    if (this.mChangeNotificationDepth > 0) {
      Log.e("ListenableEditingState", "adding a listener " + paramEditingStateWatcher.toString() + " in a listener callback");
    }
    if (this.mBatchEditNestDepth > 0)
    {
      Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
      this.mPendingListeners.add(paramEditingStateWatcher);
      AppMethodBeat.o(189803);
      return;
    }
    this.mListeners.add(paramEditingStateWatcher);
    AppMethodBeat.o(189803);
  }
  
  public void beginBatchEdit()
  {
    AppMethodBeat.i(189768);
    this.mBatchEditNestDepth += 1;
    if (this.mChangeNotificationDepth > 0) {
      Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
    }
    if ((this.mBatchEditNestDepth == 1) && (!this.mListeners.isEmpty()))
    {
      this.mTextWhenBeginBatchEdit = toString();
      this.mSelectionStartWhenBeginBatchEdit = getSelectionStart();
      this.mSelectionEndWhenBeginBatchEdit = getSelectionEnd();
      this.mComposingStartWhenBeginBatchEdit = getComposingStart();
      this.mComposingEndWhenBeginBatchEdit = getComposingEnd();
    }
    AppMethodBeat.o(189768);
  }
  
  public void endBatchEdit()
  {
    boolean bool3 = false;
    AppMethodBeat.i(189778);
    if (this.mBatchEditNestDepth == 0)
    {
      Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
      AppMethodBeat.o(189778);
      return;
    }
    boolean bool1;
    if (this.mBatchEditNestDepth == 1)
    {
      Iterator localIterator = this.mPendingListeners.iterator();
      while (localIterator.hasNext()) {
        notifyListener((EditingStateWatcher)localIterator.next(), true, true, true);
      }
      if (!this.mListeners.isEmpty())
      {
        Log.v("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.mListeners.size()) + " listener(s)");
        if (toString().equals(this.mTextWhenBeginBatchEdit)) {
          break label225;
        }
        bool1 = true;
        if ((this.mSelectionStartWhenBeginBatchEdit == getSelectionStart()) && (this.mSelectionEndWhenBeginBatchEdit == getSelectionEnd())) {
          break label230;
        }
      }
    }
    label225:
    label230:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((this.mComposingStartWhenBeginBatchEdit != getComposingStart()) || (this.mComposingEndWhenBeginBatchEdit != getComposingEnd())) {
        bool3 = true;
      }
      notifyListenersIfNeeded(bool1, bool2, bool3);
      this.mListeners.addAll(this.mPendingListeners);
      this.mPendingListeners.clear();
      this.mBatchEditNestDepth -= 1;
      AppMethodBeat.o(189778);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int getComposingEnd()
  {
    AppMethodBeat.i(189838);
    int i = BaseInputConnection.getComposingSpanEnd(this);
    AppMethodBeat.o(189838);
    return i;
  }
  
  public final int getComposingStart()
  {
    AppMethodBeat.i(189832);
    int i = BaseInputConnection.getComposingSpanStart(this);
    AppMethodBeat.o(189832);
    return i;
  }
  
  public final int getSelectionEnd()
  {
    AppMethodBeat.i(189824);
    int i = Selection.getSelectionEnd(this);
    AppMethodBeat.o(189824);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(189818);
    int i = Selection.getSelectionStart(this);
    AppMethodBeat.o(189818);
    return i;
  }
  
  public void removeEditingStateListener(EditingStateWatcher paramEditingStateWatcher)
  {
    AppMethodBeat.i(189811);
    if (this.mChangeNotificationDepth > 0) {
      Log.e("ListenableEditingState", "removing a listener " + paramEditingStateWatcher.toString() + " in a listener callback");
    }
    this.mListeners.remove(paramEditingStateWatcher);
    if (this.mBatchEditNestDepth > 0) {
      this.mPendingListeners.remove(paramEditingStateWatcher);
    }
    AppMethodBeat.o(189811);
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    boolean bool4 = false;
    AppMethodBeat.i(189815);
    if (this.mChangeNotificationDepth > 0) {
      Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
    }
    boolean bool2;
    if (paramInt2 - paramInt1 != paramInt4 - paramInt3)
    {
      bool2 = true;
      i = 0;
      label39:
      if ((i >= paramInt2 - paramInt1) || (bool2)) {
        break label105;
      }
      if (charAt(paramInt1 + i) == paramCharSequence.charAt(paramInt3 + i)) {
        break label99;
      }
    }
    label99:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 |= bool1;
      i += 1;
      break label39;
      bool2 = false;
      break;
    }
    label105:
    if (bool2) {
      this.mToStringCache = null;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = getComposingStart();
    int m = getComposingEnd();
    paramCharSequence = super.replace(paramInt1, paramInt2, paramCharSequence, paramInt3, paramInt4);
    if (this.mBatchEditNestDepth > 0)
    {
      AppMethodBeat.o(189815);
      return paramCharSequence;
    }
    if ((getSelectionStart() != i) || (getSelectionEnd() != j)) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if ((getComposingStart() != k) || (getComposingEnd() != m)) {
        bool4 = true;
      }
      notifyListenersIfNeeded(bool2, bool3, bool4);
      AppMethodBeat.o(189815);
      return paramCharSequence;
    }
  }
  
  public void setComposingRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189789);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      BaseInputConnection.removeComposingSpans(this);
      AppMethodBeat.o(189789);
      return;
    }
    this.mDummyConnection.setComposingRegion(paramInt1, paramInt2);
    AppMethodBeat.o(189789);
  }
  
  public void setEditingState(TextInputChannel.TextEditState paramTextEditState)
  {
    AppMethodBeat.i(189797);
    beginBatchEdit();
    replace(0, length(), paramTextEditState.text);
    if (paramTextEditState.selectionStart >= 0) {
      Selection.setSelection(this, paramTextEditState.selectionStart, paramTextEditState.selectionEnd);
    }
    for (;;)
    {
      setComposingRange(paramTextEditState.composingStart, paramTextEditState.composingEnd);
      endBatchEdit();
      AppMethodBeat.o(189797);
      return;
      Selection.removeSelection(this);
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(189846);
    if (this.mToStringCache != null)
    {
      str = this.mToStringCache;
      AppMethodBeat.o(189846);
      return str;
    }
    String str = super.toString();
    this.mToStringCache = str;
    AppMethodBeat.o(189846);
    return str;
  }
  
  static abstract interface EditingStateWatcher
  {
    public abstract void didChangeEditingState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.editing.ListenableEditingState
 * JD-Core Version:    0.7.0.1
 */