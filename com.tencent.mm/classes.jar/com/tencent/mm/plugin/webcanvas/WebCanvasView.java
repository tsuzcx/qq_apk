package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.ay.b;
import com.tencent.mm.plugin.ay.b.a;
import com.tencent.mm.plugin.ay.b.c;
import com.tencent.mm.plugin.webview.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canvasId", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "lastCanvasId", "init", "", "type", "data", "onAttachedToWindow", "onDestroy", "onPause", "onResume", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class WebCanvasView
  extends FrameLayout
  implements d
{
  private final String TAG = s.X("MicroMsg.WebCanvasView:", Integer.valueOf(hashCode()));
  private String Wlw = "none";
  private String rzx = "";
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void bo(String paramString1, String paramString2, String paramString3)
  {
    s.u(paramString1, "canvasId");
    s.u(paramString2, "type");
    s.u(paramString3, "data");
    this.rzx = paramString1;
    Log.i(this.TAG, s.X("init:#", paramString1));
    Object localObject = getJsEngine();
    Context localContext = getContext();
    s.s(localContext, "context");
    paramString1 = ((c)localObject).a(paramString2, paramString1, paramString3, localContext);
    paramString2 = (ViewGroup)this;
    s.u(paramString2, "view");
    paramString3 = new ArrayList();
    int i = 0;
    int k = paramString2.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      paramString3.add(paramString2.getChildAt(i));
      if (j >= k)
      {
        paramString3 = ((Iterable)paramString3).iterator();
        while (paramString3.hasNext())
        {
          localObject = (View)paramString3.next();
          if (!s.p(localObject, paramString1.apS())) {
            paramString2.removeView((View)localObject);
          }
        }
        paramString1.ioi().ddL().fR(paramString2.getContext());
        paramString3 = paramString1.WjP;
        if (paramString3 != null)
        {
          localObject = paramString3.apS().getContext();
          if (localObject == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.content.MutableContextWrapper");
          }
          localObject = (MutableContextWrapper)localObject;
          Log.i(a.TAG, "reuseCanvasView:#" + paramString1.rzx + ':' + paramString3.Wly + '@' + paramString3.cMj + " sameContext:" + s.p(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext()));
          if ((!s.p(((MutableContextWrapper)localObject).getBaseContext(), paramString2.getContext())) || (!s.p(paramString3.apS().getParent(), paramString2))) {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a.h((MutableContextWrapper)localObject, paramString2, paramString3, paramString1));
          }
        }
        do
        {
          return;
          paramString1.f(paramString3.apS());
          return;
          paramString3 = new l(paramString1, (Context)new MutableContextWrapper(paramString2.getContext()));
          paramString2.addView((View)paramString3.apS());
          paramString1.f(paramString3.apS());
          paramString2 = ah.aiuX;
          paramString1.WjP = paramString3;
          paramString1 = paramString1.WjP;
        } while (paramString1 == null);
        paramString1.dVw();
        return;
      }
      i = j;
    }
  }
  
  public final String getCanvasId()
  {
    return this.rzx;
  }
  
  protected abstract c getJsEngine();
  
  protected void onAttachedToWindow()
  {
    Log.i(this.TAG, s.X("onAttachedToWindow#", this.rzx));
    Object localObject = getContext();
    if ((localObject instanceof e)) {}
    for (localObject = (e)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((e)localObject).a((d)this);
      }
      super.onAttachedToWindow();
      return;
    }
  }
  
  public final void onDestroy()
  {
    if (!n.bp((CharSequence)this.rzx)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.rzx;
        s.u(str, "canvasId");
        Log.i(localc.TAG, s.X("stop #", str));
        c.a(localc, "stop", str);
      }
      getJsEngine().clear();
      Log.i(this.TAG, "onDestroy");
      return;
    }
  }
  
  public final void onPause()
  {
    if (!n.bp((CharSequence)this.rzx)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.rzx;
        s.u(str, "canvasId");
        Log.i(localc.TAG, s.X("pause #", str));
        c.a(localc, "pause", str);
        i.a(localc.ddP(), str);
        localc.ddP();
        s.u(str, "canvasId");
        if (!s.p(localc.Wkx, "pause"))
        {
          localc.Wkx = "pause";
          i.a(localc.ddP(), localc.Wkw);
          localc.ddP();
          s.u(localc.Wkw, "canvasId");
        }
      }
      return;
    }
  }
  
  public final void onResume()
  {
    boolean bool2 = false;
    int i;
    Object localObject1;
    String str;
    long l;
    Object localObject2;
    Object localObject3;
    b.c localc;
    if (!n.bp((CharSequence)this.rzx))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = getJsEngine();
        str = this.rzx;
        s.u(str, "canvasId");
        l = MMSlotKt.now();
        Log.i(((c)localObject1).TAG, "resume #" + str + ", " + l);
        localObject2 = ((c)localObject1).Wkt;
        i = str.hashCode();
        s.u(str, "canvasId");
        if (!((b)localObject2).Wmh.containsKey(Integer.valueOf(i)))
        {
          localObject3 = (Map)((b)localObject2).Wmh;
          b.a locala = new b.a(System.currentTimeMillis(), i, str);
          localc = (b.c)((b)localObject2).Wmg.get(str);
          if (localc != null) {
            break label370;
          }
          bool1 = false;
          label164:
          locala.Wmo = bool1;
          ((Map)localObject3).put(Integer.valueOf(i), locala);
        }
        localObject3 = (b.a)((b)localObject2).Wmh.get(Integer.valueOf(i));
        if (localObject3 != null)
        {
          if (((b.a)localObject3).Wmn) {
            ((b.a)localObject3).createTime = System.currentTimeMillis();
          }
          localObject2 = (b.c)((b)localObject2).Wmg.get(str);
          if (localObject2 != null) {
            break label379;
          }
        }
      }
    }
    label370:
    label379:
    for (boolean bool1 = bool2;; bool1 = ((b.c)localObject2).Wmo)
    {
      ((b.a)localObject3).Wmo = bool1;
      c.a((c)localObject1, "resume", str);
      ((c)localObject1).ddP().ioF();
      ((c)localObject1).ddP().a(l, str, null);
      ((c)localObject1).ddP().bhT(str);
      if (!s.p(((c)localObject1).Wkx, "resume"))
      {
        ((c)localObject1).Wkx = "resume";
        ((c)localObject1).ddP().a(l, ((c)localObject1).Wkw, null);
        ((c)localObject1).ddP().bhT(((c)localObject1).Wkw);
      }
      localObject1 = ((c)localObject1).ddP().bhV(str);
      if (localObject1 != null) {
        ((a)localObject1).resume();
      }
      return;
      i = 0;
      break;
      bool1 = localc.Wmo;
      break label164;
    }
  }
  
  protected final void setCanvasId(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.rzx = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.WebCanvasView
 * JD-Core Version:    0.7.0.1
 */