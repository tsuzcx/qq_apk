package io.flutter.a.c;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Proxy;

@TargetApi(17)
final class h
  extends Presentation
{
  private final a Jcd;
  private final d Jcm;
  private final View.OnFocusChangeListener Jcn;
  private Object Jco;
  private h.a Jcp;
  private d Jcq;
  private boolean Jcr;
  private int dpo;
  private FrameLayout jTz;
  
  public h(Context paramContext, Display paramDisplay, a parama, d paramd, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(paramContext, paramDisplay);
    AppMethodBeat.i(9919);
    this.Jcr = false;
    this.Jcd = parama;
    this.Jcm = null;
    this.Jcq = paramd;
    this.Jcn = paramOnFocusChangeListener;
    getWindow().setFlags(8, 8);
    this.Jcr = paramBoolean;
    AppMethodBeat.o(9919);
  }
  
  public h(Context paramContext, Display paramDisplay, d paramd, a parama, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(paramContext, paramDisplay);
    AppMethodBeat.i(9918);
    this.Jcr = false;
    this.Jcm = paramd;
    this.Jcd = parama;
    this.dpo = paramInt;
    this.Jco = paramObject;
    this.Jcn = paramOnFocusChangeListener;
    this.Jcq = new d();
    getWindow().setFlags(8, 8);
    AppMethodBeat.o(9918);
  }
  
  public final d fvj()
  {
    AppMethodBeat.i(9921);
    this.jTz.removeAllViews();
    this.Jcp.removeAllViews();
    d locald = this.Jcq;
    AppMethodBeat.o(9921);
    return locald;
  }
  
  public final c fvk()
  {
    if (this.Jcq.Jcv == null) {
      return null;
    }
    return this.Jcq.Jcv;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.Jcq.Jcw == null) {
      this.Jcq.Jcw = new h.b(getContext());
    }
    if (this.Jcq.Jcu == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      this.Jcq.Jcu = new h.e(paramBundle, this.Jcq.Jcw);
    }
    this.jTz = new FrameLayout(getContext());
    new c(getContext(), this.Jcq.Jcu);
    if (this.Jcq.Jcv == null) {
      this.Jcq.Jcv = this.Jcm.fvf();
    }
    paramBundle = this.Jcq.Jcv.getView();
    this.jTz.addView(paramBundle);
    this.Jcp = new h.a(getContext(), this.Jcd, paramBundle);
    this.Jcp.addView(this.jTz);
    this.Jcp.addView(this.Jcq.Jcw);
    paramBundle.setOnFocusChangeListener(this.Jcn);
    this.Jcp.setFocusableInTouchMode(true);
    if (this.Jcr) {
      paramBundle.requestFocus();
    }
    for (;;)
    {
      setContentView(this.Jcp);
      AppMethodBeat.o(9920);
      return;
      this.Jcp.requestFocus();
    }
  }
  
  static final class c
    extends ContextWrapper
  {
    private final h.e Jcu;
    private WindowManager windowManager;
    
    c(Context paramContext, h.e parame)
    {
      super();
      this.Jcu = parame;
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(9933);
      if ("window".equals(paramString))
      {
        if (this.windowManager == null)
        {
          paramString = this.Jcu;
          this.windowManager = ((WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, paramString));
        }
        paramString = this.windowManager;
        AppMethodBeat.o(9933);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(9933);
      return paramString;
    }
  }
  
  static final class d
  {
    h.e Jcu;
    c Jcv;
    h.b Jcw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.c.h
 * JD-Core Version:    0.7.0.1
 */