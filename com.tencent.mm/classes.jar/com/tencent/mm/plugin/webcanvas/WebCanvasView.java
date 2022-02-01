package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.j;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MODE_MASK", "MODE_MASK_PERSIST", "TAG", "", "canvasId", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "setJsEngine", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;)V", "lastCanvasId", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "setMagicBrushView", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "measured", "", "getMeasured", "()Z", "setMeasured", "(Z)V", "popupCloseListener", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/webcanvas/PopupCloseListener;", "popupListener", "Lkotlin/Function10;", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/webcanvas/PopupListener;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "resizeListener", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/webcanvas/ResizeListener;", "init", "type", "data", "parent", "Landroid/view/View;", "onAttachedToWindow", "onDestroy", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "popup", "popupMagicBrushView", "width", "height", "left", "top", "mode", "color", "onOuterClick", "onDismiss", "webview-sdk_release"})
public class WebCanvasView
  extends FrameLayout
  implements c, e
{
  protected MagicBrushView Dzj;
  protected b Dzk;
  private String Dzl;
  private boolean Dzm;
  private PopupWindow Dzn;
  private final ViewTreeObserver.OnGlobalLayoutListener Dzo;
  private final d.g.a.q<String, Integer, Integer, z> Dzp;
  private final d.g.a.c<String, String, Integer, Integer, Integer, Integer, Integer, Integer, d.g.a.a<z>, d.g.a.a<z>, Integer> Dzq;
  private final d.g.a.b<String, z> Dzr;
  private final int Dzs;
  private final int Dzt;
  private final String TAG;
  private String ktn;
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WebCanvasView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214165);
    this.TAG = "MicroMsg.WebCanvasView";
    this.ktn = "";
    this.Dzl = "none";
    this.Dzo = ((ViewTreeObserver.OnGlobalLayoutListener)new b(this));
    this.Dzp = ((d.g.a.q)new g(this));
    this.Dzq = ((d.g.a.c)new f(this, paramContext));
    this.Dzr = ((d.g.a.b)new e(this));
    this.Dzs = 1;
    this.Dzt = 2;
    AppMethodBeat.o(214165);
  }
  
  public final void a(String paramString1, b paramb, String paramString2, String paramString3, final View paramView)
  {
    AppMethodBeat.i(214158);
    p.h(paramString1, "canvasId");
    p.h(paramb, "jsEngine");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    p.h(paramView, "parent");
    this.ktn = paramString1;
    this.Dzk = paramb;
    int i = getMeasuredWidth();
    p.h(paramString1, "canvasId");
    Object localObject = paramb.aFx(b.fr(paramString1, i));
    if (localObject != null) {
      if ((((b.k)localObject).width == 0) || (((b.k)localObject).height == 0) || (getWidth() == ((b.k)localObject).width) || (getHeight() == ((b.k)localObject).height)) {
        break label261;
      }
    }
    label261:
    for (i = 1;; i = 0)
    {
      if (i == 1)
      {
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.width = ((b.k)localObject).width;
        localLayoutParams.height = ((b.k)localObject).height;
        ad.i(this.TAG, "resume:" + localLayoutParams.width + ", " + localLayoutParams.height);
        setLayoutParams(localLayoutParams);
      }
      ad.i(this.TAG, "init:" + paramString1 + ", inited=" + this.Dzl);
      if (!p.i(this.Dzl, paramString1)) {
        break;
      }
      AppMethodBeat.o(214158);
      return;
    }
    if ((p.i(this.Dzl, "none") ^ true))
    {
      localObject = this.Dzj;
      if (localObject == null) {
        p.bcb("magicBrushView");
      }
      removeView((View)localObject);
    }
    this.Dzl = paramString1;
    localObject = getContext();
    p.g(localObject, "context");
    this.Dzj = paramb.bw((Context)localObject, paramString1);
    localObject = this.Dzj;
    if (localObject == null) {
      p.bcb("magicBrushView");
    }
    paramb.a(paramString2, paramString1, paramString3, ((MagicBrushView)localObject).getVirtualElementId(), (a)new a(this, paramView));
    paramString1 = this.Dzj;
    if (paramString1 == null) {
      p.bcb("magicBrushView");
    }
    addView((View)paramString1);
    AppMethodBeat.o(214158);
  }
  
  public final void bYv()
  {
    AppMethodBeat.i(214161);
    b localb = this.Dzk;
    if (localb == null) {
      p.bcb("jsEngine");
    }
    String str = this.ktn;
    p.h(str, "canvasId");
    ad.i(localb.TAG, "onScreenShot ".concat(String.valueOf(str)));
    b.a(localb, "onScreenShot", str, 0, null, 12);
    AppMethodBeat.o(214161);
  }
  
  public final void eLm()
  {
    AppMethodBeat.i(214160);
    PopupWindow localPopupWindow = this.Dzn;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      AppMethodBeat.o(214160);
      return;
    }
    AppMethodBeat.o(214160);
  }
  
  public final void eLn()
  {
    AppMethodBeat.i(214159);
    Object localObject = this.Dzk;
    if (localObject == null) {
      p.bcb("jsEngine");
    }
    String str = this.ktn;
    p.h(str, "canvasId");
    b.a((b)localObject, "scroll", str, 0, null, 12);
    localObject = this.Dzn;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      AppMethodBeat.o(214159);
      return;
    }
    AppMethodBeat.o(214159);
  }
  
  protected final b getJsEngine()
  {
    AppMethodBeat.i(214153);
    b localb = this.Dzk;
    if (localb == null) {
      p.bcb("jsEngine");
    }
    AppMethodBeat.o(214153);
    return localb;
  }
  
  protected final MagicBrushView getMagicBrushView()
  {
    AppMethodBeat.i(214151);
    MagicBrushView localMagicBrushView = this.Dzj;
    if (localMagicBrushView == null) {
      p.bcb("magicBrushView");
    }
    AppMethodBeat.o(214151);
    return localMagicBrushView;
  }
  
  protected final boolean getMeasured()
  {
    return this.Dzm;
  }
  
  protected final PopupWindow getPopupWindow()
  {
    return this.Dzn;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(214156);
    ad.i(this.TAG, "onAttachedToWindow#" + this.ktn + ' ' + getMeasuredWidth());
    if (getMeasuredWidth() == 0) {
      this.Dzm = false;
    }
    for (;;)
    {
      Object localObject1 = this.Dzk;
      if (localObject1 == null) {
        p.bcb("jsEngine");
      }
      Object localObject2 = this.Dzp;
      p.h(localObject2, "listener");
      if (!((b)localObject1).DxZ.contains(localObject2)) {
        ((b)localObject1).DxZ.add(localObject2);
      }
      localObject1 = this.Dzk;
      if (localObject1 == null) {
        p.bcb("jsEngine");
      }
      localObject2 = this.Dzq;
      p.h(localObject2, "listener");
      if (!((b)localObject1).Dya.contains(localObject2)) {
        ((b)localObject1).Dya.add(localObject2);
      }
      localObject1 = this.Dzk;
      if (localObject1 == null) {
        p.bcb("jsEngine");
      }
      localObject2 = this.Dzr;
      p.h(localObject2, "listener");
      if (!((b)localObject1).Dyb.contains(localObject2)) {
        ((b)localObject1).Dyb.add(localObject2);
      }
      getViewTreeObserver().addOnGlobalLayoutListener(this.Dzo);
      localObject2 = getContext();
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if (localObject1 != null) {
        ((d)localObject1).a((e)this);
      }
      localObject2 = getContext();
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if (localObject1 != null) {
        ((d)localObject1).a((c)this);
      }
      localObject1 = this.Dzn;
      if (localObject1 != null) {
        ((PopupWindow)localObject1).dismiss();
      }
      super.onAttachedToWindow();
      AppMethodBeat.o(214156);
      return;
      this.Dzm = true;
      localObject1 = this.Dzk;
      if (localObject1 == null) {
        p.bcb("jsEngine");
      }
      localObject2 = this.ktn;
      MagicBrushView localMagicBrushView = this.Dzj;
      if (localMagicBrushView == null) {
        p.bcb("magicBrushView");
      }
      ((b)localObject1).fs((String)localObject2, localMagicBrushView.getVirtualElementId());
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(214162);
    ??? = this.Dzn;
    if (??? != null) {
      ((PopupWindow)???).dismiss();
    }
    Object localObject2 = this.Dzk;
    if (localObject2 == null) {
      p.bcb("jsEngine");
    }
    for (;;)
    {
      Object localObject5;
      synchronized (((b)localObject2).Dym)
      {
        localObject4 = ((Map)((b)localObject2).Dym).entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        localObject6 = (String)((Map.Entry)localObject5).getKey();
        int i = ((b.f)((Map.Entry)localObject5).getValue()).id;
        p.h(localObject6, "canvasId");
        ad.i(((b)localObject2).TAG, "unbind #" + (String)localObject6 + ':' + i);
        ((b)localObject2).Dyl.remove(localObject6);
        ((b)localObject2).evaluateJavascript("WeixinCore.unbind(" + i + ')', null);
        b.a((b)localObject2, "unbind", (String)localObject6, i, null, 8);
        localObject5 = ((b)localObject2).Dyi.cwM.find(i);
        if (!f.HH())
        {
          localObject2 = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(214162);
          throw ((Throwable)localObject2);
        }
      }
      c.c.i("MagicBrushView", "dlview: destroy this MagicBrushView %s", new Object[] { localObject5 });
      Object localObject6 = ((MagicBrushView)localObject5).cAf.getSurface();
      if (localObject6 != null) {
        ((MagicBrushView)localObject5).cAl.b(localObject6, false);
      }
      ((MagicBrushView)localObject5).cAf.setSurfaceListener(null);
      localObject6 = ((MagicBrushView)localObject5).cin;
      if (localObject6 == null) {
        p.bcb("magicbrush");
      }
      ((com.tencent.magicbrush.d)localObject6).cwM.remove$lib_magicbrush_nano_release((MagicBrushView)localObject5);
    }
    localObject3.Dym.clear();
    Object localObject4 = z.MKo;
    ??? = localObject3.OdU;
    if (??? != null)
    {
      Context localContext = aj.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      ((com.tencent.mm.plugin.ac.e)???).setContext(localContext);
    }
    ad.i(this.TAG, "onDestroy");
    AppMethodBeat.o(214162);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(214157);
    this.Dzm = false;
    ad.i(this.TAG, "onDetachedFromWindow#" + this.ktn + ':' + getMeasuredWidth());
    super.onDetachedFromWindow();
    Object localObject1 = this.Dzk;
    if (localObject1 == null) {
      p.bcb("jsEngine");
    }
    Object localObject2 = this.Dzp;
    p.h(localObject2, "listener");
    ((b)localObject1).DxZ.remove(localObject2);
    localObject1 = this.Dzk;
    if (localObject1 == null) {
      p.bcb("jsEngine");
    }
    localObject2 = this.Dzq;
    p.h(localObject2, "listener");
    ((b)localObject1).Dya.remove(localObject2);
    localObject1 = this.Dzk;
    if (localObject1 == null) {
      p.bcb("jsEngine");
    }
    localObject2 = this.Dzr;
    p.h(localObject2, "listener");
    ((b)localObject1).Dyb.remove(localObject2);
    localObject1 = this.Dzk;
    if (localObject1 == null) {
      p.bcb("jsEngine");
    }
    localObject2 = this.ktn;
    MagicBrushView localMagicBrushView = this.Dzj;
    if (localMagicBrushView == null) {
      p.bcb("magicBrushView");
    }
    int i = localMagicBrushView.getVirtualElementId();
    p.h(localObject2, "canvasId");
    ad.i(((b)localObject1).TAG, "detach #".concat(String.valueOf(localObject2)));
    b.a((b)localObject1, "detach", (String)localObject2, i, null, 8);
    getViewTreeObserver().removeOnGlobalLayoutListener(this.Dzo);
    localObject2 = getContext();
    localObject1 = localObject2;
    if (!(localObject2 instanceof d)) {
      localObject1 = null;
    }
    localObject1 = (d)localObject1;
    if (localObject1 != null) {
      ((d)localObject1).b((e)this);
    }
    localObject1 = this.Dzn;
    if (localObject1 != null)
    {
      ((PopupWindow)localObject1).dismiss();
      AppMethodBeat.o(214157);
      return;
    }
    AppMethodBeat.o(214157);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214155);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.Dzm)
    {
      this.Dzm = true;
      b localb = this.Dzk;
      if (localb == null) {
        p.bcb("jsEngine");
      }
      String str = this.ktn;
      MagicBrushView localMagicBrushView = this.Dzj;
      if (localMagicBrushView == null) {
        p.bcb("magicBrushView");
      }
      localb.fs(str, localMagicBrushView.getVirtualElementId());
    }
    ad.i(this.TAG, "onMeasure#" + this.ktn + ' ' + getMeasuredWidth());
    AppMethodBeat.o(214155);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(214163);
    if (!n.aE((CharSequence)this.ktn)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        b localb = this.Dzk;
        if (localb == null) {
          p.bcb("jsEngine");
        }
        String str = this.ktn;
        MagicBrushView localMagicBrushView = this.Dzj;
        if (localMagicBrushView == null) {
          p.bcb("magicBrushView");
        }
        i = localMagicBrushView.getVirtualElementId();
        p.h(str, "canvasId");
        ad.i(localb.TAG, "pause #" + str + ':' + i);
        b.a(localb, "pause", str, i, null, 8);
      }
      AppMethodBeat.o(214163);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(214164);
    if (!n.aE((CharSequence)this.ktn)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        b localb = this.Dzk;
        if (localb == null) {
          p.bcb("jsEngine");
        }
        String str = this.ktn;
        MagicBrushView localMagicBrushView = this.Dzj;
        if (localMagicBrushView == null) {
          p.bcb("magicBrushView");
        }
        i = localMagicBrushView.getVirtualElementId();
        p.h(str, "canvasId");
        ad.i(localb.TAG, "resume #" + str + ':' + i);
        b.a(localb, "resume", str, i, null, 8);
      }
      AppMethodBeat.o(214164);
      return;
    }
  }
  
  protected final void setJsEngine(b paramb)
  {
    AppMethodBeat.i(214154);
    p.h(paramb, "<set-?>");
    this.Dzk = paramb;
    AppMethodBeat.o(214154);
  }
  
  protected final void setMagicBrushView(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(214152);
    p.h(paramMagicBrushView, "<set-?>");
    this.Dzj = paramMagicBrushView;
    AppMethodBeat.o(214152);
  }
  
  protected final void setMeasured(boolean paramBoolean)
  {
    this.Dzm = paramBoolean;
  }
  
  protected final void setPopupWindow(PopupWindow paramPopupWindow)
  {
    this.Dzn = paramPopupWindow;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasView$init$3", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasDimension;", "height", "", "getHeight", "()I", "offsetHeight", "getOffsetHeight", "offsetTop", "getOffsetTop", "width", "getWidth", "webview-sdk_release"})
  public static final class a
    implements a
  {
    a(View paramView) {}
    
    public final int eKT()
    {
      AppMethodBeat.i(214140);
      int i = com.tencent.mm.ad.c.cw(this.Dzu)[1];
      int j = com.tencent.mm.ad.c.cw(paramView)[1];
      AppMethodBeat.o(214140);
      return i - j;
    }
    
    public final int eKU()
    {
      AppMethodBeat.i(214141);
      int i = paramView.getMeasuredHeight();
      AppMethodBeat.o(214141);
      return i;
    }
    
    public final int getHeight()
    {
      AppMethodBeat.i(214139);
      int i = this.Dzu.getMeasuredHeight();
      AppMethodBeat.o(214139);
      return i;
    }
    
    public final int getWidth()
    {
      AppMethodBeat.i(214138);
      int i = this.Dzu.getMeasuredWidth();
      AppMethodBeat.o(214138);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onGlobalLayout"})
  static final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b(WebCanvasView paramWebCanvasView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(214142);
      this.Dzu.getJsEngine().ft(WebCanvasView.b(this.Dzu), this.Dzu.getMagicBrushView().getVirtualElementId());
      AppMethodBeat.o(214142);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$3$1"})
  static final class c
    implements PopupWindow.OnDismissListener
  {
    c(WebCanvasView paramWebCanvasView, boolean paramBoolean, d.g.a.a parama, int paramInt1, int paramInt2) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(214143);
      ad.i(WebCanvasView.a(this.Dzu), "popup on dismiss");
      this.Dzw.invoke();
      AppMethodBeat.o(214143);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$2$1$2", "com/tencent/mm/plugin/webcanvas/WebCanvasView$$special$$inlined$apply$lambda$1"})
  static final class d
    implements View.OnClickListener
  {
    d(MagicBrushView paramMagicBrushView, WebCanvasView paramWebCanvasView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, d.g.a.a parama, int paramInt5) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(214144);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (this.DzC) {
        this.DzD.invoke();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214144);
        return;
        paramView = this.Dzu.getPopupWindow();
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "anchorId", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    e(WebCanvasView paramWebCanvasView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "popupCanvasId", "", "anchorId", "width", "height", "left", "top", "mode", "color", "onOuterClick", "Lkotlin/Function0;", "", "onDismiss", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.c<String, String, Integer, Integer, Integer, Integer, Integer, Integer, d.g.a.a<? extends z>, d.g.a.a<? extends z>, Integer>
  {
    f(WebCanvasView paramWebCanvasView, Context paramContext)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resizeCanvasId", "", "width", "", "height", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.q<String, Integer, Integer, z>
  {
    g(WebCanvasView paramWebCanvasView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.WebCanvasView
 * JD-Core Version:    0.7.0.1
 */