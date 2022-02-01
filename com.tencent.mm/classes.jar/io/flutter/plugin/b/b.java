package io.flutter.plugin.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.k.a;
import io.flutter.embedding.engine.c.k.b;
import io.flutter.embedding.engine.c.k.c;
import io.flutter.embedding.engine.c.k.d;
import io.flutter.embedding.engine.c.k.e;
import io.flutter.embedding.engine.c.k.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.platform.h;

public final class b
{
  private final io.flutter.embedding.engine.c.k MCr;
  public h MCs;
  Editable MGf;
  public final InputMethodManager MGi;
  public a MGk;
  k.a MGl;
  public boolean MGm;
  public InputConnection MGn;
  final boolean MGo;
  public boolean MGp;
  public final View mView;
  
  public b(View paramView, DartExecutor paramDartExecutor, h paramh)
  {
    AppMethodBeat.i(9955);
    this.MGk = new a(b.a.a.MGs, 0);
    this.mView = paramView;
    this.MGi = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.MCr = new io.flutter.embedding.engine.c.k(paramDartExecutor);
    this.MCr.MFe = new k.e()
    {
      public final void a(int paramAnonymousInt, k.a paramAnonymousa)
      {
        AppMethodBeat.i(9939);
        b localb = b.this;
        localb.MGk = new b.a(b.a.a.MGt, paramAnonymousInt);
        localb.MGl = paramAnonymousa;
        localb.MGf = Editable.Factory.getInstance().newEditable("");
        localb.MGm = true;
        localb.MGp = false;
        AppMethodBeat.o(9939);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(9941);
        b localb = b.this;
        View localView = b.this.mView;
        if (!paramAnonymousd.text.equals(localb.MGf.toString())) {
          localb.MGf.replace(0, localb.MGf.length(), paramAnonymousd.text);
        }
        int i = paramAnonymousd.selectionStart;
        int j = paramAnonymousd.selectionEnd;
        if ((i >= 0) && (i <= localb.MGf.length()) && (j >= 0) && (j <= localb.MGf.length())) {
          Selection.setSelection(localb.MGf, i, j);
        }
        while ((!localb.MGo) && (!localb.MGm))
        {
          localb.MGi.updateSelection(localb.mView, Math.max(Selection.getSelectionStart(localb.MGf), 0), Math.max(Selection.getSelectionEnd(localb.MGf), 0), BaseInputConnection.getComposingSpanStart(localb.MGf), BaseInputConnection.getComposingSpanEnd(localb.MGf));
          AppMethodBeat.o(9941);
          return;
          Selection.removeSelection(localb.MGf);
        }
        localb.MGi.restartInput(localView);
        localb.MGm = false;
        AppMethodBeat.o(9941);
      }
      
      public final void ajc(int paramAnonymousInt)
      {
        AppMethodBeat.i(9940);
        b localb = b.this;
        localb.mView.requestFocus();
        localb.MGk = new b.a(b.a.a.MGu, paramAnonymousInt);
        localb.MGi.restartInput(localb.mView);
        localb.MGm = false;
        AppMethodBeat.o(9940);
      }
      
      public final void gfh()
      {
        AppMethodBeat.i(9942);
        b localb = b.this;
        if (localb.MGk.MGr != b.a.a.MGu)
        {
          localb.MGk = new b.a(b.a.a.MGs, 0);
          localb.MGp = false;
        }
        AppMethodBeat.o(9942);
      }
      
      public final void hide()
      {
        AppMethodBeat.i(9938);
        b.this.ht(b.this.mView);
        AppMethodBeat.o(9938);
      }
      
      public final void show()
      {
        AppMethodBeat.i(9937);
        b localb = b.this;
        View localView = b.this.mView;
        localView.requestFocus();
        localb.MGi.showSoftInput(localView, 0);
        AppMethodBeat.o(9937);
      }
    };
    this.MCr.vCn.a("TextInputClient.requestExistingInputState", null, null);
    this.MCs = paramh;
    this.MCs.MBa = this;
    if ((this.MGi.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung"))) {}
    for (boolean bool = false;; bool = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.MGo = bool;
      AppMethodBeat.o(9955);
      return;
    }
  }
  
  private static int a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, k.c paramc)
  {
    int j;
    if (paramb.MFo == k.f.MFx) {
      j = 4;
    }
    int i;
    label170:
    label203:
    do
    {
      do
      {
        return j;
        if (paramb.MFo != k.f.MFy) {
          break;
        }
        i = 2;
        if (paramb.MFp) {
          i = 4098;
        }
        j = i;
      } while (!paramb.MFq);
      return i | 0x2000;
      if (paramb.MFo == k.f.MFz) {
        return 3;
      }
      i = 1;
      if (paramb.MFo == k.f.MFA)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label170;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != k.c.MFr) {
          break label203;
        }
        return i | 0x1000;
        if (paramb.MFo == k.f.MFB)
        {
          i = 33;
          break;
        }
        if (paramb.MFo == k.f.MFC)
        {
          i = 17;
          break;
        }
        if (paramb.MFo != k.f.MFD) {
          break;
        }
        i = 145;
        break;
        j = i;
        if (paramBoolean2) {
          j = i | 0x8000;
        }
        i = j;
        if (!paramBoolean3) {
          i = j | 0x80000;
        }
      }
      if (paramc == k.c.MFs) {
        return i | 0x2000;
      }
      j = i;
    } while (paramc != k.c.MFt);
    return i | 0x4000;
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.MGk.MGr == b.a.a.MGs)
    {
      this.MGn = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.MGk.MGr == b.a.a.MGu)
    {
      if (this.MGp)
      {
        paramView = this.MGn;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.MGn = this.MCs.p(Integer.valueOf(this.MGk.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.MGn;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.MGl.MFl, this.MGl.MFh, this.MGl.MFi, this.MGl.MFj, this.MGl.MFk);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.MGl.MFm == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.MGl.MFn != null)
      {
        paramEditorInfo.actionLabel = this.MGl.MFn;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new a(paramView, this.MGk.id, this.MCr, this.MGf, paramEditorInfo);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.MGf);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.MGf);
      this.MGn = paramView;
      paramView = this.MGn;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.MGl.MFm.intValue();
    }
  }
  
  public final void ht(View paramView)
  {
    AppMethodBeat.i(9957);
    this.MGi.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  public static final class a
  {
    public b.a.a MGr;
    public int id;
    
    public a(b.a.a parama, int paramInt)
    {
      this.MGr = parama;
      this.id = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.b.b
 * JD-Core Version:    0.7.0.1
 */