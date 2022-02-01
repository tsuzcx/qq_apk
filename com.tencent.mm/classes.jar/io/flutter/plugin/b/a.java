package io.flutter.plugin.b;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

final class a
  extends BaseInputConnection
{
  private final Layout HBT;
  private final io.flutter.embedding.engine.c.k KLu;
  private final View KPg;
  private final int KPh;
  private final Editable KPi;
  private int KPj;
  private InputMethodManager KPk;
  
  public a(View paramView, int paramInt, io.flutter.embedding.engine.c.k paramk, Editable paramEditable)
  {
    super(paramView, true);
    AppMethodBeat.i(9943);
    this.KPg = paramView;
    this.KPh = paramInt;
    this.KLu = paramk;
    this.KPi = paramEditable;
    this.KPj = 0;
    this.HBT = new DynamicLayout(this.KPi, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.KPk = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(9943);
  }
  
  private static int a(int paramInt, Editable paramEditable)
  {
    AppMethodBeat.i(9952);
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      new StringBuilder("Text selection index was clamped (").append(paramInt).append("->").append(i).append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      io.flutter.a.fMF();
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private void fNJ()
  {
    AppMethodBeat.i(9944);
    if (this.KPj > 0)
    {
      AppMethodBeat.o(9944);
      return;
    }
    int i = Selection.getSelectionStart(this.KPi);
    int j = Selection.getSelectionEnd(this.KPi);
    int k = BaseInputConnection.getComposingSpanStart(this.KPi);
    int m = BaseInputConnection.getComposingSpanEnd(this.KPi);
    this.KPk.updateSelection(this.KPg, i, j, k, m);
    io.flutter.embedding.engine.c.k localk = this.KLu;
    int n = this.KPh;
    String str = this.KPi.toString();
    new StringBuilder("Sending message to update editing state: \nText: ").append(str).append("\nSelection start: ").append(i).append("\nSelection end: ").append(j).append("\nComposing start: ").append(k).append("\nComposing end: ").append(m);
    io.flutter.a.fMD();
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", str);
    localHashMap.put("selectionBase", Integer.valueOf(i));
    localHashMap.put("selectionExtent", Integer.valueOf(j));
    localHashMap.put("composingBase", Integer.valueOf(k));
    localHashMap.put("composingExtent", Integer.valueOf(m));
    localk.uzK.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(n), localHashMap }), null);
    AppMethodBeat.o(9944);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.KPj += 1;
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    fNJ();
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.KPi) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    fNJ();
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.KPj -= 1;
    fNJ();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.KPi;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    io.flutter.embedding.engine.c.k localk;
    switch (paramInt)
    {
    case 6: 
    default: 
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localk = this.KLu;
      paramInt = this.KPh;
      io.flutter.a.fMD();
      localk.uzK.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
    }
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    if (paramKeyEvent.getAction() == 0)
    {
      int j;
      if (paramKeyEvent.getKeyCode() == 67)
      {
        i = a(Selection.getSelectionStart(this.KPi), this.KPi);
        j = a(Selection.getSelectionEnd(this.KPi), this.KPi);
        if (j > i)
        {
          Selection.setSelection(this.KPi, i);
          this.KPi.delete(i, j);
          fNJ();
          AppMethodBeat.o(9953);
          return true;
        }
        if (i <= 0) {
          break label399;
        }
        if (this.HBT.isRtlCharAt(this.HBT.getLineForOffset(i))) {}
        try
        {
          Selection.extendRight(this.KPi, this.HBT);
          for (;;)
          {
            i = a(Selection.getSelectionStart(this.KPi), this.KPi);
            j = a(Selection.getSelectionEnd(this.KPi), this.KPi);
            Selection.setSelection(this.KPi, Math.min(i, j));
            this.KPi.delete(Math.min(i, j), Math.max(i, j));
            fNJ();
            AppMethodBeat.o(9953);
            return true;
            Selection.extendLeft(this.KPi, this.HBT);
          }
        }
        catch (IndexOutOfBoundsException paramKeyEvent)
        {
          for (;;)
          {
            Selection.setSelection(this.KPi, i, i - 1);
          }
        }
      }
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Math.max(Selection.getSelectionStart(this.KPi) - 1, 0);
        setSelection(i, i);
        AppMethodBeat.o(9953);
        return true;
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Math.min(Selection.getSelectionStart(this.KPi) + 1, this.KPi.length());
        setSelection(i, i);
        AppMethodBeat.o(9953);
        return true;
      }
      int i = paramKeyEvent.getUnicodeChar();
      if (i != 0)
      {
        j = Math.max(0, Selection.getSelectionStart(this.KPi));
        int k = Math.max(0, Selection.getSelectionEnd(this.KPi));
        if (k != j) {
          this.KPi.delete(j, k);
        }
        this.KPi.insert(j, String.valueOf((char)i));
        setSelection(j + 1, j + 1);
      }
      AppMethodBeat.o(9953);
      return true;
    }
    label399:
    AppMethodBeat.o(9953);
    return false;
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9949);
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    fNJ();
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      fNJ();
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    boolean bool = super.setSelection(paramInt1, paramInt2);
    fNJ();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */