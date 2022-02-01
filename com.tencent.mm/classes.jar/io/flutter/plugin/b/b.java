package io.flutter.plugin.b;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.m;
import io.flutter.plugin.a.k;
import java.io.Serializable;
import java.util.Arrays;

final class b
  extends BaseInputConnection
{
  private final Layout OVt;
  private final m SOi;
  private final boolean SSA;
  boolean SSB;
  private a SSC;
  private final int SSu;
  private final Editable SSv;
  private final EditorInfo SSw;
  private int SSx;
  private InputMethodManager SSy;
  private a SSz;
  private final View yFg;
  
  public b(View paramView, int paramInt, m paramm, Editable paramEditable, EditorInfo paramEditorInfo)
  {
    this(paramView, paramInt, paramm, paramEditable, paramEditorInfo, new FlutterJNI());
    AppMethodBeat.i(214892);
    AppMethodBeat.o(214892);
  }
  
  private b(View paramView, int paramInt, m paramm, Editable paramEditable, EditorInfo paramEditorInfo, FlutterJNI paramFlutterJNI)
  {
    super(paramView, true);
    AppMethodBeat.i(214891);
    this.SSB = false;
    this.yFg = paramView;
    this.SSu = paramInt;
    this.SOi = paramm;
    this.SSv = paramEditable;
    this.SSw = paramEditorInfo;
    this.SSx = 0;
    this.SSz = new a(paramFlutterJNI);
    this.OVt = new DynamicLayout(this.SSv, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.SSy = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    boolean bool1 = bool2;
    if (this.SSy.getCurrentInputMethodSubtype() != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        if (Build.MANUFACTURER.equals("samsung")) {
          break label163;
        }
      }
    }
    label163:
    for (bool1 = bool2;; bool1 = Settings.Secure.getString(this.yFg.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.SSA = bool1;
      AppMethodBeat.o(214891);
      return;
    }
  }
  
  private static int a(int paramInt, Editable paramEditable)
  {
    AppMethodBeat.i(9952);
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      new StringBuilder("Text selection index was clamped (").append(paramInt).append("->").append(i).append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      io.flutter.a.hwe();
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private void hxm()
  {
    AppMethodBeat.i(9944);
    if (this.SSx > 0)
    {
      AppMethodBeat.o(9944);
      return;
    }
    a locala = new a(this.SSv);
    if ((this.SSB) && (locala.equals(this.SSC)))
    {
      AppMethodBeat.o(9944);
      return;
    }
    this.SSy.updateSelection(this.yFg, locala.selectionStart, locala.selectionEnd, locala.SSD, locala.SSE);
    m localm = this.SOi;
    int i = this.SSu;
    Object localObject = locala.text;
    int j = locala.selectionStart;
    int k = locala.selectionEnd;
    int m = locala.SSD;
    int n = locala.SSE;
    new StringBuilder("Sending message to update editing state: \nText: ").append((String)localObject).append("\nSelection start: ").append(j).append("\nSelection end: ").append(k).append("\nComposing start: ").append(m).append("\nComposing end: ").append(n);
    io.flutter.a.hwd();
    localObject = m.g((String)localObject, j, k, m, n);
    localm.bbv.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(i), localObject }), null);
    this.SSB = true;
    this.SSC = locala;
    AppMethodBeat.o(9944);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.SSx += 1;
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(214896);
    boolean bool = super.clearMetaKeyStates(paramInt);
    this.SSB = false;
    AppMethodBeat.o(214896);
    return bool;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    this.SSB = false;
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.SSv) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    this.SSB = false;
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214893);
    boolean bool = super.deleteSurroundingTextInCodePoints(paramInt1, paramInt2);
    this.SSB = false;
    AppMethodBeat.o(214893);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.SSx -= 1;
    hxm();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(214894);
    boolean bool = super.finishComposingText();
    if ((this.SSA) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject = new CursorAnchorInfo.Builder();
      ((CursorAnchorInfo.Builder)localObject).setComposingText(-1, "");
      localObject = ((CursorAnchorInfo.Builder)localObject).build();
      this.SSy.updateCursorAnchorInfo(this.yFg, (CursorAnchorInfo)localObject);
    }
    this.SSB = false;
    AppMethodBeat.o(214894);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.SSv;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    AppMethodBeat.i(214895);
    paramExtractedTextRequest = new ExtractedText();
    paramExtractedTextRequest.selectionStart = Selection.getSelectionStart(this.SSv);
    paramExtractedTextRequest.selectionEnd = Selection.getSelectionEnd(this.SSv);
    paramExtractedTextRequest.text = this.SSv.toString();
    AppMethodBeat.o(214895);
    return paramExtractedTextRequest;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(214897);
    this.SSB = false;
    if (paramInt == 16908319)
    {
      setSelection(0, this.SSv.length());
      AppMethodBeat.o(214897);
      return true;
    }
    int i;
    int j;
    Object localObject;
    if (paramInt == 16908320)
    {
      i = Selection.getSelectionStart(this.SSv);
      j = Selection.getSelectionEnd(this.SSv);
      if (i != j)
      {
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        localObject = this.SSv.subSequence(paramInt, i);
        ((ClipboardManager)this.yFg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
        this.SSv.delete(paramInt, i);
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(214897);
      return true;
    }
    if (paramInt == 16908321)
    {
      paramInt = Selection.getSelectionStart(this.SSv);
      i = Selection.getSelectionEnd(this.SSv);
      if (paramInt != i)
      {
        localObject = this.SSv.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
        ((ClipboardManager)this.yFg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
      }
      AppMethodBeat.o(214897);
      return true;
    }
    if (paramInt == 16908322)
    {
      localObject = ((ClipboardManager)this.yFg.getContext().getSystemService("clipboard")).getPrimaryClip();
      if (localObject != null)
      {
        localObject = ((ClipData)localObject).getItemAt(0).coerceToText(this.yFg.getContext());
        i = Math.max(0, Selection.getSelectionStart(this.SSv));
        j = Math.max(0, Selection.getSelectionEnd(this.SSv));
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        if (paramInt != i) {
          this.SSv.delete(paramInt, i);
        }
        this.SSv.insert(paramInt, (CharSequence)localObject);
        paramInt = ((CharSequence)localObject).length() + paramInt;
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(214897);
      return true;
    }
    AppMethodBeat.o(214897);
    return false;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    this.SSB = false;
    m localm;
    switch (paramInt)
    {
    case 6: 
    default: 
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localm = this.SOi;
      paramInt = this.SSu;
      io.flutter.a.hwd();
      localm.bbv.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
    }
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    this.SSB = false;
    int i3;
    int i6;
    Editable localEditable;
    int i;
    if (paramKeyEvent.getAction() == 0) {
      if (paramKeyEvent.getKeyCode() == 67)
      {
        i3 = a(Selection.getSelectionStart(this.SSv), this.SSv);
        i6 = a(Selection.getSelectionEnd(this.SSv), this.SSv);
        if ((i3 != i6) || (i3 <= 0)) {
          break label1545;
        }
        paramKeyEvent = this.SSz;
        localEditable = this.SSv;
        if (i3 <= 1) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      int i1;
      int m;
      int j;
      int k;
      int n;
      label497:
      int i2;
      label621:
      int i4;
      if (i6 > i)
      {
        Selection.setSelection(this.SSv, i);
        this.SSv.delete(i, i6);
        hxm();
        AppMethodBeat.o(9953);
        return true;
        i1 = Character.codePointBefore(localEditable, i3);
        i = Character.charCount(i1);
        m = i3 - i;
        if (m == 0)
        {
          i = 0;
          continue;
        }
        if (i1 == 10)
        {
          j = i;
          if (Character.codePointBefore(localEditable, m) == 13) {
            j = i + 1;
          }
          i = i3 - j;
          continue;
        }
        if (paramKeyEvent.atz(i1))
        {
          k = Character.codePointBefore(localEditable, m);
          n = m - Character.charCount(k);
          j = 1;
          m = k;
          k = n;
          while ((k > 0) && (paramKeyEvent.atz(m)))
          {
            m = Character.codePointBefore(localEditable, k);
            k -= Character.charCount(m);
            j += 1;
          }
          k = i;
          if (j % 2 == 0) {
            k = i + 2;
          }
          i = i3 - k;
          continue;
        }
        if (i1 == 8419)
        {
          k = Character.codePointBefore(localEditable, m);
          j = m - Character.charCount(k);
          if ((j > 0) && (paramKeyEvent.aty(k)))
          {
            m = Character.codePointBefore(localEditable, j);
            j = i;
            if (a.atA(m))
            {
              j = Character.charCount(k);
              j = i + (Character.charCount(m) + j);
            }
          }
          for (;;)
          {
            i = i3 - j;
            break;
            j = i;
            if (a.atA(k)) {
              j = i + Character.charCount(k);
            }
          }
        }
        j = i;
        k = m;
        n = i1;
        if (i1 == 917631)
        {
          n = Character.codePointBefore(localEditable, m);
          k = m - Character.charCount(n);
          if (k > 0)
          {
            if ((917536 <= n) && (n <= 917630)) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label497;
              }
              j = Character.charCount(n);
              n = Character.codePointBefore(localEditable, k);
              k -= Character.charCount(n);
              i = j + i;
              break;
            }
          }
          if (!paramKeyEvent.atx(n))
          {
            i = i3 - 2;
            continue;
          }
          j = Character.charCount(n) + i;
        }
        i = j;
        i1 = k;
        m = n;
        if (paramKeyEvent.aty(n))
        {
          m = Character.codePointBefore(localEditable, k);
          n = j;
          if (!paramKeyEvent.atx(m)) {
            break label1538;
          }
          i = j + Character.charCount(m);
          i1 = k - i;
        }
        n = i;
        if (!paramKeyEvent.atx(m)) {
          break label1538;
        }
        j = 0;
        k = 0;
        n = m;
        i2 = i1;
        if (j == 0) {
          break label1532;
        }
        i += Character.charCount(n) + k + 1;
        k = 0;
        i4 = 0;
        if (paramKeyEvent.SNV.nativeFlutterTextUtilsIsEmojiModifier(n))
        {
          m = Character.codePointBefore(localEditable, i2);
          j = i2 - Character.charCount(m);
          if ((j <= 0) || (!paramKeyEvent.aty(m))) {
            break label1527;
          }
          m = Character.codePointBefore(localEditable, j);
          k = i;
          if (paramKeyEvent.atx(m))
          {
            j = Character.charCount(m);
            Character.charCount(m);
            label699:
            k = i;
            if (paramKeyEvent.SNV.nativeFlutterTextUtilsIsEmojiModifierBase(m)) {
              k = i + (j + Character.charCount(m));
            }
          }
        }
      }
      for (;;)
      {
        label725:
        i = i3 - k;
        break;
        j = k;
        i1 = i4;
        m = i2;
        if (i2 > 0)
        {
          i1 = Character.codePointBefore(localEditable, i2);
          n = i2 - Character.charCount(i1);
          j = k;
          m = n;
          k = i1;
          if (i1 != 8205) {
            break label1516;
          }
          int i5 = 1;
          i2 = 1;
          i1 = Character.codePointBefore(localEditable, n);
          n -= Character.charCount(i1);
          j = i5;
          m = n;
          k = i1;
          if (n <= 0) {
            break label1516;
          }
          j = i5;
          m = n;
          k = i1;
          if (!paramKeyEvent.aty(i1)) {
            break label1516;
          }
          j = Character.codePointBefore(localEditable, n);
          i1 = Character.charCount(j);
          m = n - Character.charCount(j);
          n = j;
          j = i2;
        }
        for (;;)
        {
          k = i;
          if (m == 0) {
            break label725;
          }
          k = i;
          if (j == 0) {
            break label725;
          }
          k = i;
          if (!paramKeyEvent.atx(n)) {
            break label725;
          }
          i2 = m;
          k = i1;
          break;
          AppMethodBeat.o(9953);
          return false;
          if (paramKeyEvent.getKeyCode() == 21)
          {
            i = Selection.getSelectionStart(this.SSv);
            j = Selection.getSelectionEnd(this.SSv);
            if ((i == j) && (!paramKeyEvent.isShiftPressed()))
            {
              i = Math.max(i - 1, 0);
              setSelection(i, i);
            }
            for (;;)
            {
              AppMethodBeat.o(9953);
              return true;
              setSelection(i, Math.max(j - 1, 0));
            }
          }
          if (paramKeyEvent.getKeyCode() == 22)
          {
            i = Selection.getSelectionStart(this.SSv);
            j = Selection.getSelectionEnd(this.SSv);
            if ((i == j) && (!paramKeyEvent.isShiftPressed()))
            {
              i = Math.min(i + 1, this.SSv.length());
              setSelection(i, i);
            }
            for (;;)
            {
              AppMethodBeat.o(9953);
              return true;
              setSelection(i, Math.min(j + 1, this.SSv.length()));
            }
          }
          if (paramKeyEvent.getKeyCode() == 19)
          {
            if ((Selection.getSelectionStart(this.SSv) == Selection.getSelectionEnd(this.SSv)) && (!paramKeyEvent.isShiftPressed()))
            {
              Selection.moveUp(this.SSv, this.OVt);
              i = Selection.getSelectionStart(this.SSv);
              setSelection(i, i);
            }
            for (;;)
            {
              AppMethodBeat.o(9953);
              return true;
              Selection.extendUp(this.SSv, this.OVt);
              setSelection(Selection.getSelectionStart(this.SSv), Selection.getSelectionEnd(this.SSv));
            }
          }
          if (paramKeyEvent.getKeyCode() == 20)
          {
            if ((Selection.getSelectionStart(this.SSv) == Selection.getSelectionEnd(this.SSv)) && (!paramKeyEvent.isShiftPressed()))
            {
              Selection.moveDown(this.SSv, this.OVt);
              i = Selection.getSelectionStart(this.SSv);
              setSelection(i, i);
            }
            for (;;)
            {
              AppMethodBeat.o(9953);
              return true;
              Selection.extendDown(this.SSv, this.OVt);
              setSelection(Selection.getSelectionStart(this.SSv), Selection.getSelectionEnd(this.SSv));
            }
          }
          if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.SSw.inputType) == 0))
          {
            performEditorAction(this.SSw.imeOptions & 0xFF);
            AppMethodBeat.o(9953);
            return true;
          }
          i = paramKeyEvent.getUnicodeChar();
          if (i != 0)
          {
            k = Math.max(0, Selection.getSelectionStart(this.SSv));
            m = Math.max(0, Selection.getSelectionEnd(this.SSv));
            j = Math.min(k, m);
            k = Math.max(k, m);
            if (j != k) {
              this.SSv.delete(j, k);
            }
            this.SSv.insert(j, String.valueOf((char)i));
            setSelection(j + 1, j + 1);
          }
          AppMethodBeat.o(9953);
          return true;
          if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
          {
            i = Selection.getSelectionEnd(this.SSv);
            setSelection(i, i);
            AppMethodBeat.o(9953);
            return true;
          }
          AppMethodBeat.o(9953);
          return false;
          label1516:
          i1 = i4;
          n = k;
        }
        label1527:
        j = 0;
        break label699;
        label1532:
        k = j;
        break label621;
        label1538:
        k = n;
      }
      label1545:
      i = i3;
    }
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9949);
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    this.SSB = false;
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      this.SSB = false;
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    boolean bool = super.setSelection(paramInt1, paramInt2);
    this.SSB = false;
    hxm();
    AppMethodBeat.o(9951);
    return bool;
  }
  
  final class a
  {
    public int SSD;
    public int SSE;
    public int selectionEnd;
    public int selectionStart;
    public String text;
    
    public a(Editable paramEditable)
    {
      AppMethodBeat.i(214898);
      this.selectionStart = Selection.getSelectionStart(paramEditable);
      this.selectionEnd = Selection.getSelectionEnd(paramEditable);
      this.SSD = BaseInputConnection.getComposingSpanStart(paramEditable);
      this.SSE = BaseInputConnection.getComposingSpanEnd(paramEditable);
      this.text = paramEditable.toString();
      AppMethodBeat.o(214898);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214899);
      if (paramObject == this)
      {
        AppMethodBeat.o(214899);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(214899);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.selectionStart == paramObject.selectionStart) && (this.selectionEnd == paramObject.selectionEnd) && (this.SSD == paramObject.SSD) && (this.SSE == paramObject.SSE) && (this.text.equals(paramObject.text)))
      {
        AppMethodBeat.o(214899);
        return true;
      }
      AppMethodBeat.o(214899);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214900);
      int i = this.selectionStart;
      int j = this.selectionEnd;
      int k = this.SSD;
      int m = this.SSE;
      int n = this.text.hashCode();
      AppMethodBeat.o(214900);
      return ((((i + 31) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.b.b
 * JD-Core Version:    0.7.0.1
 */