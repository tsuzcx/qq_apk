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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MODE_MASK", "MODE_MASK_PERSIST", "TAG", "", "canvasId", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "lastCanvasId", "lastHeight", "getLastHeight", "()I", "setLastHeight", "(I)V", "lastWidth", "getLastWidth", "setLastWidth", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "setMagicBrushView", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "measured", "", "getMeasured", "()Z", "setMeasured", "(Z)V", "popupCloseListener", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/webcanvas/PopupCloseListener;", "popupListener", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView$PopupListenerWrapper;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "resizeListener", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/webcanvas/ResizeListener;", "weakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakReference", "()Ljava/lang/ref/WeakReference;", "setWeakReference", "(Ljava/lang/ref/WeakReference;)V", "init", "type", "data", "parent", "Landroid/view/View;", "onAttachedToWindow", "onDestroy", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "popup", "popupMagicBrushView", "width", "height", "left", "top", "mode", "color", "onOuterClick", "Lkotlin/Function0;", "onDismiss", "PopupListenerWrapper", "webview-sdk_release"})
public abstract class WebCanvasView
  extends FrameLayout
  implements d, f
{
  protected MagicBrushView DQS;
  private String DQT = "none";
  private boolean DQU;
  private PopupWindow DQV;
  private final ViewTreeObserver.OnGlobalLayoutListener DQW;
  private final d.g.a.q<String, Integer, Integer, z> DQX;
  private final d.g.a.b<String, z> DQZ;
  private final int DRa;
  private final int DRb;
  private final f Jid;
  private final String TAG = "MicroMsg.WebCanvasView" + hashCode();
  private WeakReference<Context> cyH;
  private String kwD = "";
  private int nmb;
  private int nmc;
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WebCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.cyH = new WeakReference(paramContext);
    this.DQW = ((ViewTreeObserver.OnGlobalLayoutListener)new b(this));
    this.DQX = ((d.g.a.q)new g(this));
    paramContext = new f();
    p.h(this, "view");
    paramContext.cyH = new WeakReference(this);
    this.Jid = paramContext;
    this.DQZ = ((d.g.a.b)new e(this));
    this.DRa = 1;
    this.DRb = 2;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final View paramView)
  {
    p.h(paramString1, "canvasId");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    p.h(paramView, "parent");
    this.kwD = paramString1;
    Object localObject = getJsEngine();
    int i = getMeasuredWidth();
    p.h(paramString1, "canvasId");
    localObject = ((c)localObject).aGR(c.fA(paramString1, i));
    if (localObject != null) {
      if ((((c.k)localObject).width == 0) || (((c.k)localObject).height == 0) || (getWidth() == ((c.k)localObject).width) || (getHeight() == ((c.k)localObject).height)) {
        break label243;
      }
    }
    label243:
    for (i = 1;; i = 0)
    {
      if (i == 1)
      {
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.width = ((c.k)localObject).width;
        localLayoutParams.height = ((c.k)localObject).height;
        ae.i(this.TAG, "resume:" + localLayoutParams.width + ", " + localLayoutParams.height);
        setLayoutParams(localLayoutParams);
      }
      ae.i(this.TAG, "init:" + paramString1 + ", inited=" + this.DQT);
      if (!p.i(this.DQT, paramString1)) {
        break;
      }
      return;
    }
    if ((p.i(this.DQT, "none") ^ true))
    {
      localObject = this.DQS;
      if (localObject == null) {
        p.bdF("magicBrushView");
      }
      removeView((View)localObject);
    }
    this.DQT = paramString1;
    paramString1 = getJsEngine().a(paramString2, paramString1, paramString3, getContext(), (a)new a(this, paramView));
    if (paramString1 == null) {
      p.gkB();
    }
    this.DQS = paramString1;
    paramString1 = this.DQS;
    if (paramString1 == null) {
      p.bdF("magicBrushView");
    }
    addView((View)paramString1);
  }
  
  public final void bZK()
  {
    c localc = getJsEngine();
    String str = this.kwD;
    p.h(str, "canvasId");
    ae.i(localc.TAG, "onScreenShot ".concat(String.valueOf(str)));
    c.a(localc, "onScreenShot", str, 0, null, 12);
  }
  
  public final void eOU()
  {
    PopupWindow localPopupWindow = this.DQV;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  public final void eOV()
  {
    Object localObject = getJsEngine();
    String str = this.kwD;
    p.h(str, "canvasId");
    c.a((c)localObject, "scroll", str, 0, null, 12);
    localObject = this.DQV;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
  }
  
  protected abstract c getJsEngine();
  
  public final int getLastHeight()
  {
    return this.nmc;
  }
  
  public final int getLastWidth()
  {
    return this.nmb;
  }
  
  protected final MagicBrushView getMagicBrushView()
  {
    MagicBrushView localMagicBrushView = this.DQS;
    if (localMagicBrushView == null) {
      p.bdF("magicBrushView");
    }
    return localMagicBrushView;
  }
  
  protected final boolean getMeasured()
  {
    return this.DQU;
  }
  
  protected final PopupWindow getPopupWindow()
  {
    return this.DQV;
  }
  
  public final WeakReference<Context> getWeakReference()
  {
    return this.cyH;
  }
  
  protected void onAttachedToWindow()
  {
    ae.i(this.TAG, "onAttachedToWindow#" + this.kwD + ' ' + getMeasuredWidth());
    if (getMeasuredWidth() == 0) {
      this.DQU = false;
    }
    for (;;)
    {
      Object localObject1 = getJsEngine();
      Object localObject2 = this.DQX;
      p.h(localObject2, "listener");
      if (!((c)localObject1).DPG.contains(localObject2)) {
        ((c)localObject1).DPG.add(localObject2);
      }
      localObject1 = getJsEngine();
      localObject2 = (d.g.a.c)this.Jid;
      p.h(localObject2, "listener");
      if (!((c)localObject1).DPH.contains(localObject2)) {
        ((c)localObject1).DPH.add(localObject2);
      }
      localObject1 = getJsEngine();
      localObject2 = this.DQZ;
      p.h(localObject2, "listener");
      if (!((c)localObject1).DPI.contains(localObject2)) {
        ((c)localObject1).DPI.add(localObject2);
      }
      getViewTreeObserver().addOnGlobalLayoutListener(this.DQW);
      localObject2 = getContext();
      localObject1 = localObject2;
      if (!(localObject2 instanceof e)) {
        localObject1 = null;
      }
      localObject1 = (e)localObject1;
      if (localObject1 != null) {
        ((e)localObject1).a((f)this);
      }
      localObject2 = getContext();
      localObject1 = localObject2;
      if (!(localObject2 instanceof e)) {
        localObject1 = null;
      }
      localObject1 = (e)localObject1;
      if (localObject1 != null) {
        ((e)localObject1).a((d)this);
      }
      localObject1 = this.DQV;
      if (localObject1 != null) {
        ((PopupWindow)localObject1).dismiss();
      }
      super.onAttachedToWindow();
      return;
      this.DQU = true;
      localObject1 = getJsEngine();
      localObject2 = this.kwD;
      MagicBrushView localMagicBrushView = this.DQS;
      if (localMagicBrushView == null) {
        p.bdF("magicBrushView");
      }
      ((c)localObject1).fB((String)localObject2, localMagicBrushView.getVirtualElementId());
    }
  }
  
  public final void onDestroy()
  {
    Object localObject1 = this.DQV;
    if (localObject1 != null) {
      ((PopupWindow)localObject1).dismiss();
    }
    localObject1 = getJsEngine();
    for (;;)
    {
      Object localObject5;
      synchronized (((c)localObject1).DPT)
      {
        localObject4 = ((Map)((c)localObject1).DPT).entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        localObject6 = (String)((Map.Entry)localObject5).getKey();
        int i = ((c.f)((Map.Entry)localObject5).getValue()).id;
        p.h(localObject6, "canvasId");
        ae.i(((c)localObject1).TAG, "unbind #" + (String)localObject6 + ':' + i);
        ((c)localObject1).DPS.remove(localObject6);
        ((c)localObject1).evaluateJavascript("WeixinCore.unbind(" + i + ')', null);
        c.a((c)localObject1, "unbind", (String)localObject6, i, null, 8);
        localObject5 = ((c)localObject1).nvp.cxr.find(i);
        if (!com.tencent.magicbrush.utils.f.HP()) {
          throw ((Throwable)new IllegalStateException("Check failed.".toString()));
        }
      }
      c.c.i("MagicBrushView", "dlview: destroy this MagicBrushView %s", new Object[] { localObject5 });
      Object localObject6 = ((MagicBrushView)localObject5).cAM.getSurface();
      if (localObject6 != null) {
        ((MagicBrushView)localObject5).cAS.b(localObject6, false);
      }
      ((MagicBrushView)localObject5).cAM.setSurfaceListener(null);
      localObject6 = ((MagicBrushView)localObject5).cip;
      if (localObject6 == null) {
        p.bdF("magicbrush");
      }
      ((com.tencent.magicbrush.d)localObject6).cxr.remove$lib_magicbrush_nano_release((MagicBrushView)localObject5);
    }
    localObject2.DPT.clear();
    Object localObject4 = z.Nhr;
    ??? = localObject2.DPM;
    if (??? != null)
    {
      localObject4 = ak.getContext();
      p.g(localObject4, "MMApplicationContext.getContext()");
      ((g)???).setContext((Context)localObject4);
    }
    localObject2.DPH.clear();
    ae.i(this.TAG, "onDestroy");
  }
  
  protected void onDetachedFromWindow()
  {
    this.DQU = false;
    ae.i(this.TAG, "onDetachedFromWindow#" + this.kwD + ':' + getMeasuredWidth());
    super.onDetachedFromWindow();
    Object localObject1 = getJsEngine();
    Object localObject2 = this.DQX;
    p.h(localObject2, "listener");
    ((c)localObject1).DPG.remove(localObject2);
    localObject1 = getJsEngine();
    localObject2 = (d.g.a.c)this.Jid;
    p.h(localObject2, "listener");
    ((c)localObject1).DPH.remove(localObject2);
    localObject1 = getJsEngine();
    localObject2 = this.DQZ;
    p.h(localObject2, "listener");
    ((c)localObject1).DPI.remove(localObject2);
    localObject1 = getJsEngine();
    localObject2 = this.kwD;
    MagicBrushView localMagicBrushView = this.DQS;
    if (localMagicBrushView == null) {
      p.bdF("magicBrushView");
    }
    int i = localMagicBrushView.getVirtualElementId();
    p.h(localObject2, "canvasId");
    ae.i(((c)localObject1).TAG, "detach #".concat(String.valueOf(localObject2)));
    c.a((c)localObject1, "detach", (String)localObject2, i, null, 8);
    getViewTreeObserver().removeOnGlobalLayoutListener(this.DQW);
    localObject2 = getContext();
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject1 = (e)localObject1;
    if (localObject1 != null) {
      ((e)localObject1).b((f)this);
    }
    localObject1 = this.DQV;
    if (localObject1 != null) {
      ((PopupWindow)localObject1).dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.DQU)
    {
      this.DQU = true;
      c localc = getJsEngine();
      String str = this.kwD;
      MagicBrushView localMagicBrushView = this.DQS;
      if (localMagicBrushView == null) {
        p.bdF("magicBrushView");
      }
      localc.fB(str, localMagicBrushView.getVirtualElementId());
    }
    ae.i(this.TAG, "onMeasure#" + this.kwD + ' ' + getMeasuredWidth());
  }
  
  public final void onPause()
  {
    if (!n.aD((CharSequence)this.kwD)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.kwD;
        MagicBrushView localMagicBrushView = this.DQS;
        if (localMagicBrushView == null) {
          p.bdF("magicBrushView");
        }
        i = localMagicBrushView.getVirtualElementId();
        p.h(str, "canvasId");
        ae.i(localc.TAG, "pause #" + str + ':' + i);
        c.a(localc, "pause", str, i, null, 8);
      }
      return;
    }
  }
  
  public final void onResume()
  {
    if (!n.aD((CharSequence)this.kwD)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c localc = getJsEngine();
        String str = this.kwD;
        MagicBrushView localMagicBrushView = this.DQS;
        if (localMagicBrushView == null) {
          p.bdF("magicBrushView");
        }
        i = localMagicBrushView.getVirtualElementId();
        p.h(str, "canvasId");
        ae.i(localc.TAG, "resume #" + str + ':' + i);
        localc.DPL.fF(str, i);
        c.a(localc, "resume", str, i, null, 8);
      }
      return;
    }
  }
  
  public final void setLastHeight(int paramInt)
  {
    this.nmc = paramInt;
  }
  
  public final void setLastWidth(int paramInt)
  {
    this.nmb = paramInt;
  }
  
  protected final void setMagicBrushView(MagicBrushView paramMagicBrushView)
  {
    p.h(paramMagicBrushView, "<set-?>");
    this.DQS = paramMagicBrushView;
  }
  
  protected final void setMeasured(boolean paramBoolean)
  {
    this.DQU = paramBoolean;
  }
  
  protected final void setPopupWindow(PopupWindow paramPopupWindow)
  {
    this.DQV = paramPopupWindow;
  }
  
  public final void setWeakReference(WeakReference<Context> paramWeakReference)
  {
    p.h(paramWeakReference, "<set-?>");
    this.cyH = paramWeakReference;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasView$init$3", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasDimension;", "height", "", "getHeight", "()I", "offsetHeight", "getOffsetHeight", "offsetTop", "getOffsetTop", "width", "getWidth", "webview-sdk_release"})
  public static final class a
    implements a
  {
    a(View paramView) {}
    
    public final int eOB()
    {
      AppMethodBeat.i(213983);
      int i = com.tencent.mm.ac.c.cw(this.DRc)[1];
      int j = com.tencent.mm.ac.c.cw(paramView)[1];
      AppMethodBeat.o(213983);
      return i - j;
    }
    
    public final int eOC()
    {
      AppMethodBeat.i(213984);
      int i = paramView.getMeasuredHeight();
      AppMethodBeat.o(213984);
      return i;
    }
    
    public final int getHeight()
    {
      AppMethodBeat.i(213982);
      int i = this.DRc.getMeasuredHeight();
      AppMethodBeat.o(213982);
      return i;
    }
    
    public final int getWidth()
    {
      AppMethodBeat.i(213981);
      int i = this.DRc.getMeasuredWidth();
      AppMethodBeat.o(213981);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onGlobalLayout"})
  static final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b(WebCanvasView paramWebCanvasView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(213985);
      ae.i(WebCanvasView.a(this.DRc), "OnGlobalLayout:#" + WebCanvasView.b(this.DRc) + ", " + this.DRc.getWidth() + ", " + this.DRc.getHeight());
      if ((this.DRc.getLastHeight() != this.DRc.getHeight()) || (this.DRc.getLastWidth() != this.DRc.getWidth())) {
        this.DRc.getJsEngine().fC(WebCanvasView.b(this.DRc), this.DRc.getMagicBrushView().getVirtualElementId());
      }
      this.DRc.setLastHeight(this.DRc.getHeight());
      this.DRc.setLastWidth(this.DRc.getWidth());
      AppMethodBeat.o(213985);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$3$1"})
  static final class c
    implements PopupWindow.OnDismissListener
  {
    c(WebCanvasView paramWebCanvasView, boolean paramBoolean, d.g.a.a parama, int paramInt1, int paramInt2) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(213986);
      ae.i(WebCanvasView.a(this.DRc), "popup on dismiss");
      this.DRe.invoke();
      AppMethodBeat.o(213986);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$2$1$2", "com/tencent/mm/plugin/webcanvas/WebCanvasView$$special$$inlined$apply$lambda$1"})
  static final class d
    implements View.OnClickListener
  {
    d(MagicBrushView paramMagicBrushView, WebCanvasView paramWebCanvasView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, d.g.a.a parama, int paramInt5) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213987);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (this.DRk) {
        this.DRl.invoke();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webcanvas/WebCanvasView$popup$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213987);
        return;
        paramView = this.DRc.getPopupWindow();
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "anchorId", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    e(WebCanvasView paramWebCanvasView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView$PopupListenerWrapper;", "Lkotlin/Function10;", "", "", "Lkotlin/Function0;", "", "Lcom/tencent/mm/plugin/webcanvas/PopupListener;", "()V", "weakReference", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "getWeakReference", "()Ljava/lang/ref/WeakReference;", "setWeakReference", "(Ljava/lang/ref/WeakReference;)V", "invoke", "popupCanvasId", "anchorId", "width", "height", "left", "top", "mode", "color", "onOuterClick", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;IIIIIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "setWebCanvasView", "view", "webview-sdk_release"})
  public static final class f
    implements d.g.a.c<String, String, Integer, Integer, Integer, Integer, Integer, Integer, d.g.a.a<? extends z>, d.g.a.a<? extends z>, Integer>
  {
    WeakReference<WebCanvasView> cyH;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resizeCanvasId", "", "width", "", "height", "invoke"})
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