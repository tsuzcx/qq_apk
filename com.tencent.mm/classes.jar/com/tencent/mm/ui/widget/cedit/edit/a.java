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
  private final CustomTextView Yhe;
  private int Yhf;
  private InputMethodManager Yhg;
  
  public a(CustomTextView paramCustomTextView)
  {
    super(paramCustomTextView, true);
    this.Yhe = paramCustomTextView;
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(197226);
    try
    {
      if (this.Yhf >= 0)
      {
        this.Yhe.ian();
        this.Yhf += 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(197226);
    }
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(197238);
    Editable localEditable = getEditable();
    if (localEditable == null)
    {
      AppMethodBeat.o(197238);
      return false;
    }
    KeyListener localKeyListener = this.Yhe.getKeyListener();
    if (localKeyListener != null) {}
    try
    {
      localKeyListener.clearMetaKeyState(this.Yhe, localEditable, paramInt);
      label45:
      AppMethodBeat.o(197238);
      return true;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      break label45;
    }
  }
  
  public final void closeConnection()
  {
    AppMethodBeat.i(197236);
    super.closeConnection();
    try
    {
      while (this.Yhf > 0) {
        endBatchEdit();
      }
      this.Yhf = -1;
    }
    finally
    {
      AppMethodBeat.o(197236);
    }
    AppMethodBeat.o(197236);
  }
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo)
  {
    AppMethodBeat.i(197241);
    Log.v("cmEdit.EditableInputConnection", "commitCompletion ".concat(String.valueOf(paramCompletionInfo)));
    this.Yhe.ian();
    this.Yhe.iao();
    AppMethodBeat.o(197241);
    return true;
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo)
  {
    AppMethodBeat.i(197248);
    Log.v("cmEdit.EditableInputConnection", "commitCorrection".concat(String.valueOf(paramCorrectionInfo)));
    this.Yhe.ian();
    Object localObject = this.Yhe;
    if (((CustomTextView)localObject).Ygi != null)
    {
      localObject = ((CustomTextView)localObject).Ygi;
      if (((b)localObject).Yhr != null) {
        break label132;
      }
      ((b)localObject).Yhr = new b.b((b)localObject);
    }
    for (;;)
    {
      localObject = ((b)localObject).Yhr;
      ((b.b)localObject).tH = paramCorrectionInfo.getOffset();
      ((b.b)localObject).tI = (((b.b)localObject).tH + paramCorrectionInfo.getNewText().length());
      ((b.b)localObject).Yiq = SystemClock.uptimeMillis();
      if ((((b.b)localObject).tH < 0) || (((b.b)localObject).tI < 0)) {
        ((b.b)localObject).stopAnimation();
      }
      this.Yhe.iao();
      AppMethodBeat.o(197248);
      return true;
      label132:
      ((b)localObject).Yhr.Hw(false);
    }
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(197265);
    boolean bool;
    if (this.Yhe == null)
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(197265);
      return bool;
    }
    try
    {
      bool = super.commitText(paramCharSequence, paramInt);
      AppMethodBeat.o(197265);
      return bool;
    }
    catch (Throwable paramCharSequence)
    {
      Log.e("cmEdit.EditableInputConnection", "commitText err:%s", new Object[] { Util.stackTraceToString(paramCharSequence) });
      com.tencent.mm.ui.widget.cedit.api.b.axG(6);
      AppMethodBeat.o(197265);
    }
    return false;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(197232);
    try
    {
      if (this.Yhf > 0)
      {
        this.Yhe.iao();
        this.Yhf -= 1;
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(197232);
    }
  }
  
  public final Editable getEditable()
  {
    AppMethodBeat.i(197223);
    Object localObject = this.Yhe;
    if (localObject != null)
    {
      localObject = ((CustomTextView)localObject).getEditableText();
      AppMethodBeat.o(197223);
      return localObject;
    }
    AppMethodBeat.o(197223);
    return null;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    AppMethodBeat.i(197262);
    if (this.Yhe != null)
    {
      ExtractedText localExtractedText = new ExtractedText();
      if (this.Yhe.a(paramExtractedTextRequest, localExtractedText))
      {
        if ((paramInt & 0x1) != 0) {
          this.Yhe.setExtracting(paramExtractedTextRequest);
        }
        AppMethodBeat.o(197262);
        return localExtractedText;
      }
    }
    AppMethodBeat.o(197262);
    return null;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(197258);
    Log.v("cmEdit.EditableInputConnection", "performContextMenuAction ".concat(String.valueOf(paramInt)));
    this.Yhe.ian();
    this.Yhe.onTextContextMenuItem(paramInt);
    this.Yhe.iao();
    AppMethodBeat.o(197258);
    return true;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(197255);
    Log.v("cmEdit.EditableInputConnection", "performEditorAction ".concat(String.valueOf(paramInt)));
    CustomTextView localCustomTextView = this.Yhe;
    Object localObject;
    if (localCustomTextView.Ygi == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        if ((((b.g)localObject).Yja == null) || (!((b.g)localObject).Yja.a(localCustomTextView, paramInt))) {
          if (paramInt == 5)
          {
            localObject = localCustomTextView.focusSearch(2);
            if ((localObject != null) && (!((View)localObject).requestFocus(2)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(197255);
              throw ((Throwable)localObject);
              localObject = localCustomTextView.Ygi.Yhs;
            }
          }
          else if (paramInt == 7)
          {
            localObject = localCustomTextView.focusSearch(1);
            if ((localObject != null) && (!((View)localObject).requestFocus(1)))
            {
              localObject = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(197255);
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
      AppMethodBeat.o(197255);
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
    AppMethodBeat.i(197268);
    Log.v("cmEdit.EditableInputConnection", "requestUpdateCursorAnchorInfo ".concat(String.valueOf(paramInt)));
    int i = paramInt & 0xFFFFFFFC;
    if (i != 0)
    {
      Log.d("cmEdit.EditableInputConnection", "Rejecting requestUpdateCursorAnchorInfo due to unknown flags. cursorUpdateMode=" + paramInt + " unknownFlags=" + i);
      AppMethodBeat.o(197268);
      return false;
    }
    if (this.Yhg == null) {
      this.Yhe.getContext().getSystemService("input_method");
    }
    if (this.Yhg == null)
    {
      AppMethodBeat.o(197268);
      return false;
    }
    Log.i("cmEdit.EditableInputConnection", "requestCursorUpdates");
    if (((paramInt & 0x1) != 0) && (this.Yhe != null) && (!this.Yhe.isInLayout())) {
      this.Yhe.requestLayout();
    }
    AppMethodBeat.o(197268);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.a
 * JD-Core Version:    0.7.0.1
 */