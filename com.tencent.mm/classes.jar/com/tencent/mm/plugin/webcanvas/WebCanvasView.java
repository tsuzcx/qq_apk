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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canvasId", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "lastCanvasId", "init", "", "type", "data", "onAttachedToWindow", "onDestroy", "onPause", "onResume", "webview-sdk_release"})
public abstract class WebCanvasView
  extends FrameLayout
  implements f
{
  private String PuZ = "none";
  private final String TAG = "MicroMsg.WebCanvasView:" + hashCode();
  private String owd = "";
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void aV(String paramString1, String paramString2, String paramString3)
  {
    p.k(paramString1, "canvasId");
    p.k(paramString2, "type");
    p.k(paramString3, "data");
    this.owd = paramString1;
    Log.i(this.TAG, "init:#".concat(String.valueOf(paramString1)));
    Object localObject = getJsEngine();
    Context localContext = getContext();
    p.j(localContext, "context");
    paramString1 = ((c)localObject).a(paramString2, paramString1, paramString3, localContext);
    paramString2 = (ViewGroup)this;
    p.k(paramString2, "view");
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
      if ((p.h(localObject, paramString1.PI()) ^ true)) {
        paramString2.removeView((View)localObject);
      }
    }
    paramString1.gOU().cAI().eU(paramString2.getContext());
    paramString3 = paramString1.PsX;
    if (paramString3 != null)
    {
      localObject = paramString3.PI().getContext();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.content.MutableContextWrapper");
      }
      localObject = (MutableContextWrapper)localObject;
      Log.i(a.TAG, "reuseCanvasView:#" + paramString1.owd + ':' + paramString3.Pva + '@' + paramString3.aSn + " sameContext:" + p.h(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext()));
      if (((p.h(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext()) ^ true)) || ((p.h(paramString3.PI().getParent(), paramString2) ^ true))) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a.h(paramString3, (MutableContextWrapper)localObject, paramString1, paramString2));
      }
    }
    do
    {
      return;
      paramString1.f(paramString3.PI());
      return;
      paramString3 = new n(paramString1, (Context)new MutableContextWrapper(paramString2.getContext()));
      paramString2.addView((View)paramString3.PI());
      paramString1.f(paramString3.PI());
      paramString1.PsX = paramString3;
      paramString1 = paramString1.PsX;
    } while (paramString1 == null);
    paramString1.dnQ();
  }
  
  public final String getCanvasId()
  {
    return this.owd;
  }
  
  protected abstract c getJsEngine();
  
  protected void onAttachedToWindow()
  {
    Log.i(this.TAG, "onAttachedToWindow#" + this.owd);
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
    if (!kotlin.n.n.ba((CharSequence)this.owd)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.owd;
        p.k(str, "canvasId");
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
    if (!kotlin.n.n.ba((CharSequence)this.owd)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getJsEngine().hQ(this.owd);
      }
      return;
    }
  }
  
  public final void onResume()
  {
    if (!kotlin.n.n.ba((CharSequence)this.owd)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getJsEngine().hP(this.owd);
      }
      return;
    }
  }
  
  protected final void setCanvasId(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.owd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.WebCanvasView
 * JD-Core Version:    0.7.0.1
 */