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
  private final CustomTextView QIo;
  private int QIp;
  private InputMethodManager QIq;
  
  public a(CustomTextView paramCustomTextView)
  {
    super(paramCustomTextView, true);
    this.QIo = paramCustomTextView;
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(205865);
    try
    {
      if (this.QIp >= 0)
      {
        this.QIo.beginBatchEdit();
        this.QIp += 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(205865);
    }
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(205868);
    Editable localEditable = getEditable();
    if (localEditable == null)
    {
      AppMethodBeat.o(205868);
      return false;
    }
    KeyListener localKeyListener = this.QIo.getKeyListener();
    if (localKeyListener != null) {}
    try
    {
      localKeyListener.clearMetaKeyState(this.QIo, localEditable, paramInt);
      label45:
      AppMethodBeat.o(205868);
      return true;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      break label45;
    }
  }
  
  public final void closeConnection()
  {
    AppMethodBeat.i(205867);
    super.closeConnection();
    try
    {
      while (this.QIp > 0) {
        endBatchEdit();
      }
      this.QIp = -1;
    }
    finally
    {
      AppMethodBeat.o(205867);
    }
    AppMethodBeat.o(205867);
  }
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo)
  {
    AppMethodBeat.i(205869);
    Log.v("cmEdit.EditableInputConnection", "commitCompletion ".concat(String.valueOf(paramCompletionInfo)));
    this.QIo.beginBatchEdit();
    this.QIo.endBatchEdit();
    AppMethodBeat.o(205869);
    return true;
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo)
  {
    AppMethodBeat.i(205870);
    Log.v("cmEdit.EditableInputConnection", "commitCorrection".concat(String.valueOf(paramCorrectionInfo)));
    this.QIo.beginBatchEdit();
    Object localObject = this.QIo;
    if (((CustomTextView)localObject).QHs != null)
    {
      localObject = ((CustomTextView)localObject).QHs;
      if (((b)localObject).QIB != null) {
        break label132;
      }
      ((b)localObject).QIB = new b.b((b)localObject);
    }
    for (;;)
    {
      localObject = ((b)localObject).QIB;
      ((b.b)localObject).avh = paramCorrectionInfo.getOffset();
      ((b.b)localObject).Pc = (((b.b)localObject).avh + paramCorrectionInfo.getNewText().length());
      ((b.b)localObject).QJA = SystemClock.uptimeMillis();
      if ((((b.b)localObject).avh < 0) || (((b.b)localObject).Pc < 0)) {
        ((b.b)localObject).stopAnimation();
      }
      this.QIo.endBatchEdit();
      AppMethodBeat.o(205870);
      return true;
      label132:
      ((b)localObject).QIB.Da(false);
    }
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(205874);
    boolean bool;
    if (this.QIo == null)
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(205874);
      return bool;
    }
    try
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(205874);
      return bool;
    }
    catch (Throwable paramCharSequence)
    {
      Log.e("cmEdit.EditableInputConnection", "commitText err:%s", new Object[] { Util.stackTraceToString(paramCharSequence) });
      com.tencent.mm.ui.widget.cedit.api.b.aow(6);
      AppMethodBeat.o(205874);
    }
    return false;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(205866);
    try
    {
      if (this.QIp > 0)
      {
        this.QIo.endBatchEdit();
        this.QIp -= 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(205866);
    }
  }
  
  public final Editable getEditable()
  {
    AppMethodBeat.i(205864);
    Object localObject = this.QIo;
    if (localObject != null)
    {
      localObject = ((CustomTextView)localObject).getEditableText();
      AppMethodBeat.o(205864);
      return localObject;
    }
    AppMethodBeat.o(205864);
    return null;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    AppMethodBeat.i(205873);
    if (this.QIo != null)
    {
      ExtractedText localExtractedText = new ExtractedText();
      if (this.QIo.extractText(paramExtractedTextRequest, localExtractedText))
      {
        if ((paramInt & 0x1) != 0) {
          this.QIo.setExtracting(paramExtractedTextRequest);
        }
        AppMethodBeat.o(205873);
        return localExtractedText;
      }
    }
    AppMethodBeat.o(205873);
    return null;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(205872);
    Log.v("cmEdit.EditableInputConnection", "performContextMenuAction ".concat(String.valueOf(paramInt)));
    this.QIo.beginBatchEdit();
    this.QIo.onTextContextMenuItem(paramInt);
    this.QIo.endBatchEdit();
    AppMethodBeat.o(205872);
    return true;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(205871);
    Log.v("cmEdit.EditableInputConnection", "performEditorAction ".concat(String.valueOf(paramInt)));
    CustomTextView localCustomTextView = this.QIo;
    Object localObject;
    if (localCustomTextView.QHs == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        if ((((b.g)localObject).QKi == null) || (!((b.g)localObject).QKi.a(localCustomTextView, paramInt))) {
          if (paramInt == 5)
          {
            localObject = localCustomTextView.focusSearch(2);
            if ((localObject != null) && (!((View)localObject).requestFocus(2)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(205871);
              throw ((Throwable)localObject);
              localObject = localCustomTextView.QHs.QIC;
            }
          }
          else if (paramInt == 7)
          {
            localObject = localCustomTextView.focusSearch(1);
            if ((localObject != null) && (!((View)localObject).requestFocus(1)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(205871);
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
      AppMethodBeat.o(205871);
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
    AppMethodBeat.i(205875);
    Log.v("cmEdit.EditableInputConnection", "requestUpdateCursorAnchorInfo ".concat(String.valueOf(paramInt)));
    int i = paramInt & 0xFFFFFFFC;
    if (i != 0)
    {
      Log.d("cmEdit.EditableInputConnection", "Rejecting requestUpdateCursorAnchorInfo due to unknown flags. cursorUpdateMode=" + paramInt + " unknownFlags=" + i);
      AppMethodBeat.o(205875);
      return false;
    }
    if (this.QIq == null) {
      this.QIo.getContext().getSystemService("input_method");
    }
    if (this.QIq == null)
    {
      AppMethodBeat.o(205875);
      return false;
    }
    Log.i("cmEdit.EditableInputConnection", "requestCursorUpdates");
    if (((paramInt & 0x1) != 0) && (this.QIo != null) && (!this.QIo.isInLayout())) {
      this.QIo.requestLayout();
    }
    AppMethodBeat.o(205875);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.a
 * JD-Core Version:    0.7.0.1
 */