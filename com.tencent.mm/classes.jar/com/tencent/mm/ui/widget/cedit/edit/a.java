package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends BaseInputConnection
{
  private final CustomTextView afZe;
  private int afZf;
  private InputMethodManager afZg;
  
  public a(CustomTextView paramCustomTextView)
  {
    super(paramCustomTextView, true);
    this.afZe = paramCustomTextView;
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(252424);
    try
    {
      if (this.afZf >= 0)
      {
        this.afZe.beginBatchEdit();
        this.afZf += 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(252424);
    }
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(252442);
    Editable localEditable = getEditable();
    if (localEditable == null)
    {
      AppMethodBeat.o(252442);
      return false;
    }
    KeyListener localKeyListener = this.afZe.getKeyListener();
    if (localKeyListener != null) {}
    try
    {
      localKeyListener.clearMetaKeyState(this.afZe, localEditable, paramInt);
      label45:
      AppMethodBeat.o(252442);
      return true;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      break label45;
    }
  }
  
  public final void closeConnection()
  {
    AppMethodBeat.i(252435);
    super.closeConnection();
    try
    {
      while (this.afZf > 0) {
        endBatchEdit();
      }
      this.afZf = -1;
    }
    finally
    {
      AppMethodBeat.o(252435);
    }
    AppMethodBeat.o(252435);
  }
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo)
  {
    AppMethodBeat.i(252447);
    Log.v("cmEdit.EditableInputConnection", "commitCompletion ".concat(String.valueOf(paramCompletionInfo)));
    this.afZe.beginBatchEdit();
    this.afZe.endBatchEdit();
    AppMethodBeat.o(252447);
    return true;
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo)
  {
    AppMethodBeat.i(252455);
    Log.v("cmEdit.EditableInputConnection", "commitCorrection".concat(String.valueOf(paramCorrectionInfo)));
    this.afZe.beginBatchEdit();
    Object localObject = this.afZe;
    if (((CustomTextView)localObject).afYi != null)
    {
      localObject = ((CustomTextView)localObject).afYi;
      if (((b)localObject).afZr != null) {
        break label132;
      }
      ((b)localObject).afZr = new b.b((b)localObject);
    }
    for (;;)
    {
      localObject = ((b)localObject).afZr;
      ((b.b)localObject).uG = paramCorrectionInfo.getOffset();
      ((b.b)localObject).uH = (((b.b)localObject).uG + paramCorrectionInfo.getNewText().length());
      ((b.b)localObject).agaq = SystemClock.uptimeMillis();
      if ((((b.b)localObject).uG < 0) || (((b.b)localObject).uH < 0)) {
        ((b.b)localObject).stopAnimation();
      }
      this.afZe.endBatchEdit();
      AppMethodBeat.o(252455);
      return true;
      label132:
      ((b)localObject).afZr.Ns(false);
    }
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(252486);
    boolean bool;
    if (this.afZe == null)
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(252486);
      return bool;
    }
    try
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(252486);
      return bool;
    }
    finally
    {
      Log.e("cmEdit.EditableInputConnection", "commitText err:%s", new Object[] { Util.stackTraceToString(paramCharSequence) });
      com.tencent.mm.ui.widget.cedit.api.b.aEp(6);
      AppMethodBeat.o(252486);
    }
    return false;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(252431);
    try
    {
      if (this.afZf > 0)
      {
        this.afZe.endBatchEdit();
        this.afZf -= 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(252431);
    }
  }
  
  public final Editable getEditable()
  {
    AppMethodBeat.i(252420);
    Object localObject = this.afZe;
    if (localObject != null)
    {
      localObject = ((CustomTextView)localObject).getEditableText();
      AppMethodBeat.o(252420);
      return localObject;
    }
    AppMethodBeat.o(252420);
    return null;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    AppMethodBeat.i(252478);
    if (this.afZe != null)
    {
      ExtractedText localExtractedText = new ExtractedText();
      if (this.afZe.a(paramExtractedTextRequest, localExtractedText))
      {
        if ((paramInt & 0x1) != 0) {
          this.afZe.setExtracting(paramExtractedTextRequest);
        }
        AppMethodBeat.o(252478);
        return localExtractedText;
      }
    }
    AppMethodBeat.o(252478);
    return null;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(252472);
    Log.v("cmEdit.EditableInputConnection", "performContextMenuAction ".concat(String.valueOf(paramInt)));
    this.afZe.beginBatchEdit();
    this.afZe.onTextContextMenuItem(paramInt);
    this.afZe.endBatchEdit();
    AppMethodBeat.o(252472);
    return true;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(252466);
    Log.v("cmEdit.EditableInputConnection", "performEditorAction ".concat(String.valueOf(paramInt)));
    CustomTextView localCustomTextView = this.afZe;
    Object localObject;
    if (localCustomTextView.afYi == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        if ((((b.g)localObject).agba == null) || (!((b.g)localObject).agba.a(localCustomTextView, paramInt))) {
          if (paramInt == 5)
          {
            localObject = localCustomTextView.focusSearch(2);
            if ((localObject != null) && (!((View)localObject).requestFocus(2)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(252466);
              throw ((Throwable)localObject);
              localObject = localCustomTextView.afYi.afZs;
            }
          }
          else if (paramInt == 7)
          {
            localObject = localCustomTextView.focusSearch(1);
            if ((localObject != null) && (!((View)localObject).requestFocus(1)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(252466);
              throw ((Throwable)localObject);
            }
          }
          else
          {
            if (paramInt != 6) {
              break label218;
            }
            localObject = localCustomTextView.getInputMethodManager();
            if ((localObject != null) && (((InputMethodManager)localObject).isActive(localCustomTextView))) {
              ((InputMethodManager)localObject).hideSoftInputFromWindow(localCustomTextView.getWindowToken(), 0);
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(252466);
      return true;
      label218:
      localObject = new com.tencent.mm.ui.widget.cedit.util.a(localCustomTextView, "getViewRootImpl", new Class[0]).invoke(new Object[0]);
      if (localObject != null)
      {
        long l = SystemClock.uptimeMillis();
        new com.tencent.mm.ui.widget.cedit.util.a(localObject, "dispatchKeyFromIme", new Class[] { KeyEvent.class }).invoke(new Object[] { new KeyEvent(l, l, 0, 66, 0, 0, -1, 0, 22) });
        new com.tencent.mm.ui.widget.cedit.util.a(localObject, "dispatchKeyFromIme", new Class[] { KeyEvent.class }).invoke(new Object[] { new KeyEvent(SystemClock.uptimeMillis(), l, 1, 66, 0, 0, -1, 0, 22) });
      }
    }
  }
  
  public final boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    return true;
  }
  
  public final boolean requestCursorUpdates(int paramInt)
  {
    AppMethodBeat.i(252491);
    Log.v("cmEdit.EditableInputConnection", "requestUpdateCursorAnchorInfo ".concat(String.valueOf(paramInt)));
    int i = paramInt & 0xFFFFFFFC;
    if (i != 0)
    {
      Log.d("cmEdit.EditableInputConnection", "Rejecting requestUpdateCursorAnchorInfo due to unknown flags. cursorUpdateMode=" + paramInt + " unknownFlags=" + i);
      AppMethodBeat.o(252491);
      return false;
    }
    if (this.afZg == null) {
      this.afZe.getContext().getSystemService("input_method");
    }
    if (this.afZg == null)
    {
      AppMethodBeat.o(252491);
      return false;
    }
    Log.i("cmEdit.EditableInputConnection", "requestCursorUpdates");
    if (((paramInt & 0x1) != 0) && (this.afZe != null) && (!this.afZe.isInLayout())) {
      this.afZe.requestLayout();
    }
    AppMethodBeat.o(252491);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.a
 * JD-Core Version:    0.7.0.1
 */