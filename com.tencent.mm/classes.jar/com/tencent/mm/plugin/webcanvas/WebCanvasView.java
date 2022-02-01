package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canvasId", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "lastCanvasId", "init", "", "type", "data", "onAttachedToWindow", "onDestroy", "onPause", "onResume", "webview-sdk_release"})
public abstract class WebCanvasView
  extends FrameLayout
  implements f
{
  private String IAQ = "none";
  private final String TAG = "MicroMsg.WebCanvasView:" + hashCode();
  private String lAN = "";
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    p.h(paramString1, "canvasId");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    this.lAN = paramString1;
    Log.i(this.TAG, "init:#".concat(String.valueOf(paramString1)));
    Object localObject = getJsEngine();
    Context localContext = getContext();
    p.g(localContext, "context");
    paramString1 = ((c)localObject).a(paramString2, paramString1, paramString3, localContext);
    paramString2 = (ViewGroup)this;
    p.h(paramString2, "view");
    paramString3 = new ArrayList();
    int i = 0;
    int j = paramString2.getChildCount();
    while (i < j)
    {
      paramString3.add(paramString2.getChildAt(i));
      i += 1;
    }
    paramString3 = ((Iterable)paramString3).iterator();
    while (paramString3.hasNext())
    {
      localObject = (View)paramString3.next();
      if ((p.j(localObject, paramString1.MQ()) ^ true)) {
        paramString2.removeView((View)localObject);
      }
    }
    paramString1.fWl().cna().eQ(paramString2.getContext());
    paramString3 = paramString1.IyU;
    if (paramString3 != null)
    {
      localObject = paramString3.MQ().getContext();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.content.MutableContextWrapper");
      }
      localObject = (MutableContextWrapper)localObject;
      Log.i(a.TAG, "reuseCanvasView:#" + paramString1.lAN + ':' + paramString3.IAR + '@' + paramString3.biJ + " sameContext:" + p.j(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext()));
      if (((p.j(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext()) ^ true)) || ((p.j(paramString3.MQ().getParent(), paramString2) ^ true))) {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a.h(paramString3, (MutableContextWrapper)localObject, paramString1, paramString2));
      }
    }
    do
    {
      return;
      paramString1.e(paramString3.MQ());
      return;
      paramString3 = new n(paramString1, (Context)new MutableContextWrapper(paramString2.getContext()));
      paramString2.addView((View)paramString3.MQ());
      paramString1.e(paramString3.MQ());
      paramString1.IyU = paramString3;
      paramString1 = paramString1.IyU;
    } while (paramString1 == null);
    paramString1.cYb();
  }
  
  public final String getCanvasId()
  {
    return this.lAN;
  }
  
  protected abstract c getJsEngine();
  
  protected void onAttachedToWindow()
  {
    Log.i(this.TAG, "onAttachedToWindow#" + this.lAN);
    Context localContext = getContext();
    Object localObject = localContext;
    if (!(localContext instanceof g)) {
      localObject = null;
    }
    localObject = (g)localObject;
    if (localObject != null) {
      ((g)localObject).a((f)this);
    }
    super.onAttachedToWindow();
  }
  
  public final void onDestroy()
  {
    if (!kotlin.n.n.aL((CharSequence)this.lAN)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.lAN;
        p.h(str, "canvasId");
        Log.i(localc.TAG, "stop #".concat(String.valueOf(str)));
        c.a(localc, "stop", str);
      }
      getJsEngine().clear();
      Log.i(this.TAG, "onDestroy");
      return;
    }
  }
  
  public final void onPause()
  {
    if (!kotlin.n.n.aL((CharSequence)this.lAN)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getJsEngine().hd(this.lAN);
      }
      return;
    }
  }
  
  public final void onResume()
  {
    if (!kotlin.n.n.aL((CharSequence)this.lAN)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getJsEngine().hc(this.lAN);
      }
      return;
    }
  }
  
  protected final void setCanvasId(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.lAN = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.WebCanvasView
 * JD-Core Version:    0.7.0.1
 */