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
  private final io.flutter.embedding.engine.c.k MZw;
  public h MZx;
  Editable Ndk;
  public final InputMethodManager Ndn;
  public a Ndp;
  k.a Ndq;
  public boolean Ndr;
  public InputConnection Nds;
  final boolean Ndt;
  public boolean Ndu;
  public final View mView;
  
  public b(View paramView, DartExecutor paramDartExecutor, h paramh)
  {
    AppMethodBeat.i(9955);
    this.Ndp = new a(b.a.a.Ndx, 0);
    this.mView = paramView;
    this.Ndn = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.MZw = new io.flutter.embedding.engine.c.k(paramDartExecutor);
    this.MZw.Nck = new k.e()
    {
      public final void a(int paramAnonymousInt, k.a paramAnonymousa)
      {
        AppMethodBeat.i(9939);
        b localb = b.this;
        localb.Ndp = new b.a(b.a.a.Ndy, paramAnonymousInt);
        localb.Ndq = paramAnonymousa;
        localb.Ndk = Editable.Factory.getInstance().newEditable("");
        localb.Ndr = true;
        localb.Ndu = false;
        AppMethodBeat.o(9939);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(9941);
        b localb = b.this;
        View localView = b.this.mView;
        if (!paramAnonymousd.text.equals(localb.Ndk.toString())) {
          localb.Ndk.replace(0, localb.Ndk.length(), paramAnonymousd.text);
        }
        int i = paramAnonymousd.selectionStart;
        int j = paramAnonymousd.selectionEnd;
        if ((i >= 0) && (i <= localb.Ndk.length()) && (j >= 0) && (j <= localb.Ndk.length())) {
          Selection.setSelection(localb.Ndk, i, j);
        }
        while ((!localb.Ndt) && (!localb.Ndr))
        {
          localb.Ndn.updateSelection(localb.mView, Math.max(Selection.getSelectionStart(localb.Ndk), 0), Math.max(Selection.getSelectionEnd(localb.Ndk), 0), BaseInputConnection.getComposingSpanStart(localb.Ndk), BaseInputConnection.getComposingSpanEnd(localb.Ndk));
          AppMethodBeat.o(9941);
          return;
          Selection.removeSelection(localb.Ndk);
        }
        localb.Ndn.restartInput(localView);
        localb.Ndr = false;
        AppMethodBeat.o(9941);
      }
      
      public final void ajM(int paramAnonymousInt)
      {
        AppMethodBeat.i(9940);
        b localb = b.this;
        localb.mView.requestFocus();
        localb.Ndp = new b.a(b.a.a.Ndz, paramAnonymousInt);
        localb.Ndn.restartInput(localb.mView);
        localb.Ndr = false;
        AppMethodBeat.o(9940);
      }
      
      public final void gjJ()
      {
        AppMethodBeat.i(9942);
        b localb = b.this;
        if (localb.Ndp.Ndw != b.a.a.Ndz)
        {
          localb.Ndp = new b.a(b.a.a.Ndx, 0);
          localb.Ndu = false;
        }
        AppMethodBeat.o(9942);
      }
      
      public final void hide()
      {
        AppMethodBeat.i(9938);
        b.this.hy(b.this.mView);
        AppMethodBeat.o(9938);
      }
      
      public final void show()
      {
        AppMethodBeat.i(9937);
        b localb = b.this;
        View localView = b.this.mView;
        localView.requestFocus();
        localb.Ndn.showSoftInput(localView, 0);
        AppMethodBeat.o(9937);
      }
    };
    this.MZw.vOr.a("TextInputClient.requestExistingInputState", null, null);
    this.MZx = paramh;
    this.MZx.MYf = this;
    if ((this.Ndn.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung"))) {}
    for (boolean bool = false;; bool = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.Ndt = bool;
      AppMethodBeat.o(9955);
      return;
    }
  }
  
  private static int a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, k.c paramc)
  {
    int j;
    if (paramb.Ncu == k.f.NcD) {
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
        if (paramb.Ncu != k.f.NcE) {
          break;
        }
        i = 2;
        if (paramb.Ncv) {
          i = 4098;
        }
        j = i;
      } while (!paramb.Ncw);
      return i | 0x2000;
      if (paramb.Ncu == k.f.NcF) {
        return 3;
      }
      i = 1;
      if (paramb.Ncu == k.f.NcG)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label170;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != k.c.Ncx) {
          break label203;
        }
        return i | 0x1000;
        if (paramb.Ncu == k.f.NcH)
        {
          i = 33;
          break;
        }
        if (paramb.Ncu == k.f.NcI)
        {
          i = 17;
          break;
        }
        if (paramb.Ncu != k.f.NcJ) {
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
      if (paramc == k.c.Ncy) {
        return i | 0x2000;
      }
      j = i;
    } while (paramc != k.c.Ncz);
    return i | 0x4000;
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.Ndp.Ndw == b.a.a.Ndx)
    {
      this.Nds = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.Ndp.Ndw == b.a.a.Ndz)
    {
      if (this.Ndu)
      {
        paramView = this.Nds;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.Nds = this.MZx.q(Integer.valueOf(this.Ndp.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.Nds;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.Ndq.Ncr, this.Ndq.Ncn, this.Ndq.Nco, this.Ndq.Ncp, this.Ndq.Ncq);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.Ndq.Ncs == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.Ndq.Nct != null)
      {
        paramEditorInfo.actionLabel = this.Ndq.Nct;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new a(paramView, this.Ndp.id, this.MZw, this.Ndk, paramEditorInfo);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.Ndk);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.Ndk);
      this.Nds = paramView;
      paramView = this.Nds;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.Ndq.Ncs.intValue();
    }
  }
  
  public final void hy(View paramView)
  {
    AppMethodBeat.i(9957);
    this.Ndn.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  public static final class a
  {
    public a Ndw;
    public int id;
    
    public a(a parama, int paramInt)
    {
      this.Ndw = parama;
      this.id = paramInt;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(9936);
        Ndx = new a("NO_TARGET", 0);
        Ndy = new a("FRAMEWORK_CLIENT", 1);
        Ndz = new a("PLATFORM_VIEW", 2);
        NdA = new a[] { Ndx, Ndy, Ndz };
        AppMethodBeat.o(9936);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.b.b
 * JD-Core Version:    0.7.0.1
 */