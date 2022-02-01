package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.plugin.ax.f;
import com.tencent.mm.plugin.ax.f.a;
import com.tencent.mm.plugin.ax.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.v;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "popupTarget", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;)V", "TAG", "", "popupWindow", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "close", "", "popupId", "popup", "width", "", "height", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "precreate", "CanvasPopup", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements o
{
  public static final b WkE;
  private static final int WkJ;
  private static final int WkK;
  private final String TAG;
  private final h WkF;
  private final c WkG;
  private a WkI;
  
  static
  {
    AppMethodBeat.i(261282);
    WkE = new b((byte)0);
    WkJ = 1;
    WkK = 2;
    AppMethodBeat.o(261282);
  }
  
  public g(h paramh, c paramc)
  {
    AppMethodBeat.i(369709);
    this.WkF = paramh;
    this.WkG = paramc;
    this.TAG = "MicroMsg.WebCanvasPopupContext";
    AppMethodBeat.o(369709);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261301);
    s.u(paramString1, "popupId");
    s.u(paramString2, "onDismissCallback");
    s.u(paramString3, "onOuterClickCallback");
    Object localObject = this.WkF.getView();
    if ((localObject != null) && (((View)localObject).isAttachedToWindow() == true)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w(this.TAG, s.X("skip popup when canvasView detached:", paramString1));
      c.a.a((com.tencent.mm.plugin.ax.c)this.WkG, paramString2, null, null, 6);
      AppMethodBeat.o(261301);
      return;
    }
    localObject = this.WkI;
    if (localObject != null) {
      ((a)localObject).dismiss();
    }
    paramString2 = new a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, new WeakReference(this));
    paramString2.show();
    paramString3 = ah.aiuX;
    this.WkI = paramString2;
    this.WkG.bhO(paramString1);
    AppMethodBeat.o(261301);
  }
  
  public final void bhR(String paramString)
  {
    AppMethodBeat.i(261288);
    s.u(paramString, "popupId");
    Log.i(this.TAG, s.X("precreate:", paramString));
    i locali = this.WkG.ddP();
    f.a locala = f.WlF;
    locali.a(f.a.getAppContext(), paramString, false, false);
    AppMethodBeat.o(261288);
  }
  
  public final void close(String paramString)
  {
    AppMethodBeat.i(261313);
    s.u(paramString, "popupId");
    a locala = this.WkI;
    if (locala != null) {
      if (!s.p(locala.Wkw, paramString)) {
        break label47;
      }
    }
    label47:
    for (paramString = locala;; paramString = null)
    {
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(261313);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "Landroid/view/View$OnAttachStateChangeListener;", "popupId", "", "popupWidth", "", "popupHeight", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "context", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "(Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "TAG", "getPopupId", "()Ljava/lang/String;", "dismiss", "", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "show", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends v
    implements View.OnAttachStateChangeListener
  {
    private final String TAG;
    private final int WkL;
    private final int WkM;
    private final String WkN;
    private final String WkO;
    final String Wkw;
    private final int color;
    private final WeakReference<g> context;
    private final int left;
    private final int mode;
    private final int top;
    
    public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, WeakReference<g> paramWeakReference) {}
    
    private static final void a(boolean paramBoolean, c paramc, a parama, View paramView)
    {
      AppMethodBeat.i(261153);
      Object localObject = new Object();
      b localb = new b();
      localb.fv(paramBoolean);
      localb.cH(paramc);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "$logicJsEngine");
      s.u(parama, "this$0");
      if (paramBoolean) {
        c.a.a((com.tencent.mm.plugin.ax.c)paramc, parama.WkO, null, null, 6);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261153);
        return;
        parama.dismiss();
      }
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(261177);
      Log.i(this.TAG, s.X("popup on dismiss:", this.Wkw));
      g localg = (g)this.context.get();
      if (localg != null)
      {
        View localView = g.a(localg).getView();
        if (localView != null) {
          localView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
        c.a.a((com.tencent.mm.plugin.ax.c)g.c(localg), this.WkN, null, null, 6);
        g.c(localg).bhO("none");
        g.d(localg);
      }
      super.dismiss();
      AppMethodBeat.o(261177);
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(261169);
      dismiss();
      AppMethodBeat.o(261169);
    }
    
    public final void show()
    {
      AppMethodBeat.i(261193);
      Object localObject1 = (g)this.context.get();
      int j;
      int k;
      int i;
      label190:
      boolean bool;
      label204:
      label242:
      int m;
      int n;
      int i1;
      int i2;
      label382:
      Object localObject4;
      Object localObject3;
      label419:
      Object localObject5;
      if (localObject1 == null)
      {
        localObject1 = null;
        s.checkNotNull(localObject1);
        localObject2 = d.da((View)localObject1);
        localObject2[0] += this.left;
        localObject2[1] += this.top;
        j = localObject2[0];
        k = localObject2[1];
        Log.d(this.TAG, "popup:" + this.Wkw + " start locate:[" + this.left + ", " + this.top + "] offset:[" + j + ", " + k + "] size:[" + this.WkL + ", " + this.WkM + "] mode:" + this.mode);
        if ((this.mode & g.ioC()) == 0) {
          break label746;
        }
        i = 1;
        if ((this.mode & g.ioD()) == 0) {
          break label751;
        }
        bool = true;
        if (i == 0) {
          break label757;
        }
        localObject2 = new Integer[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1) };
        m = ((Number)localObject2[0]).intValue();
        n = ((Number)localObject2[1]).intValue();
        i1 = ((Number)localObject2[2]).intValue();
        i2 = ((Number)localObject2[3]).intValue();
        Log.i(this.TAG, "popup:" + this.Wkw + " compute locate:[" + m + ", " + n + "] size:[" + i1 + ", " + i2 + ']');
        localObject2 = (g)this.context.get();
        if (localObject2 != null) {
          break label800;
        }
        localObject2 = null;
        s.checkNotNull(localObject2);
        localObject4 = ((c)localObject2).ddP();
        localObject3 = ((View)localObject1).getContext();
        if (!(localObject3 instanceof MutableContextWrapper)) {
          break label810;
        }
        localObject3 = ((MutableContextWrapper)localObject3).getBaseContext();
        s.s(localObject3, "viewContext");
        localObject4 = ((i)localObject4).a((Context)localObject3, this.Wkw, false, false);
        s.u(localObject3, "context");
        if (((a)localObject4).WjP == null)
        {
          ((a)localObject4).WjP = new l((a)localObject4, (Context)new MutableContextWrapper((Context)localObject3));
          localObject5 = ((a)localObject4).WjP;
          if (localObject5 != null) {
            ((l)localObject5).dVw();
          }
        }
        localObject5 = ((a)localObject4).apS();
        s.checkNotNull(localObject5);
        localObject4 = ((MagicBrushView)localObject5).getParent();
        if (!(localObject4 instanceof ViewGroup)) {
          break label813;
        }
        localObject4 = (ViewGroup)localObject4;
        label534:
        if (localObject4 != null) {
          ((ViewGroup)localObject4).removeView((View)localObject5);
        }
        if (i == 0) {
          break label819;
        }
        localObject3 = new RelativeLayout((Context)localObject3);
        localObject4 = new RelativeLayout.LayoutParams(this.WkL, this.WkM);
        ((RelativeLayout.LayoutParams)localObject4).setMargins(j, k + 0, 0, 0);
        ah localah = ah.aiuX;
        ((MagicBrushView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((RelativeLayout)localObject3).setOnClickListener(new g.a..ExternalSyntheticLambda0(bool, (c)localObject2, this));
        ((RelativeLayout)localObject3).setBackground((Drawable)new ColorDrawable(this.color));
        ((RelativeLayout)localObject3).setSystemUiVisibility(1284);
        ((RelativeLayout)localObject3).addView((View)localObject5);
        localObject2 = ah.aiuX;
      }
      label800:
      label810:
      label813:
      label819:
      for (Object localObject2 = (View)localObject3;; localObject2 = (View)localObject5)
      {
        setContentView((View)localObject2);
        setWidth(i1);
        setHeight(i2);
        if (i == 0) {
          setTouchable(true);
        }
        setClippingEnabled(false);
        ((View)localObject1).addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        showAtLocation((View)localObject1, 0, m, n);
        AppMethodBeat.o(261193);
        return;
        localObject1 = g.a((g)localObject1).getView();
        break;
        label746:
        i = 0;
        break label190;
        label751:
        bool = false;
        break label204;
        label757:
        localObject2 = new Integer[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.WkL), Integer.valueOf(this.WkM) };
        break label242;
        localObject2 = g.c((g)localObject2);
        break label382;
        break label419;
        localObject4 = null;
        break label534;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$Companion;", "", "()V", "MODE_MASK", "", "MODE_MASK_PERSIST", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.g
 * JD-Core Version:    0.7.0.1
 */