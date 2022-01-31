package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public final class e$a
  implements b
{
  ReflectMethod BGe;
  private ReflectMethod BGf;
  private ReflectMethod BGg;
  private ReflectMethod BGh;
  private Object BGi;
  private ReflectMethod hasEnteredFullscreenMethod;
  private ReflectMethod onHideCustomViewMethod;
  
  public e$a(Object paramObject)
  {
    AppMethodBeat.i(84632);
    this.BGi = paramObject;
    this.BGe = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
    this.BGf = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
    this.BGg = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
    this.onHideCustomViewMethod = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
    this.hasEnteredFullscreenMethod = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
    this.BGh = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
    AppMethodBeat.o(84632);
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(84633);
    this.BGf.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(84633);
  }
  
  public final void da(Object paramObject)
  {
    AppMethodBeat.i(84634);
    this.BGh.invoke(new Object[] { paramObject });
    AppMethodBeat.o(84634);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(84637);
    boolean bool = ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
    AppMethodBeat.o(84637);
    return bool;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(84636);
    this.onHideCustomViewMethod.invoke(new Object[0]);
    AppMethodBeat.o(84636);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(84635);
    this.BGg.invoke(new Object[] { paramView, paramCustomViewCallback });
    AppMethodBeat.o(84635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.a
 * JD-Core Version:    0.7.0.1
 */