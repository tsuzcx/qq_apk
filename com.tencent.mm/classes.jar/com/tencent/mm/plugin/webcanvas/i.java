package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.av.c.a;
import com.tencent.mm.plugin.av.f;
import com.tencent.mm.plugin.av.f.a;
import com.tencent.mm.plugin.av.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.r;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "popupTarget", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;)V", "TAG", "", "popupWindow", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "close", "", "popupId", "popup", "width", "", "height", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "precreate", "CanvasPopup", "Companion", "webview-sdk_release"})
public final class i
  implements o
{
  private static final int Puc = 1;
  private static final int Pud = 2;
  public static final b Pue;
  private a PtY;
  private final j PtZ;
  private final c Pua;
  private final k Pub;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(205584);
    Pue = new b((byte)0);
    Puc = 1;
    Pud = 2;
    AppMethodBeat.o(205584);
  }
  
  public i(j paramj, c paramc, k paramk)
  {
    AppMethodBeat.i(205583);
    this.PtZ = paramj;
    this.Pua = paramc;
    this.Pub = paramk;
    this.TAG = "MicroMsg.WebCanvasPopupContext";
    AppMethodBeat.o(205583);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3)
  {
    AppMethodBeat.i(205581);
    p.k(paramString1, "popupId");
    p.k(paramString2, "onDismissCallback");
    p.k(paramString3, "onOuterClickCallback");
    Object localObject1 = this.PtZ.getView();
    if ((localObject1 == null) || (((View)localObject1).isAttachedToWindow() != true))
    {
      Log.w(this.TAG, "skip popup when canvasView detached:".concat(String.valueOf(paramString1)));
      c.a.a(this.Pua, paramString2, null, null, 6);
      AppMethodBeat.o(205581);
      return;
    }
    localObject1 = this.PtY;
    if (localObject1 != null) {
      ((a)localObject1).dismiss();
    }
    a locala = new a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, new WeakReference(this));
    paramString2 = (i)locala.context.get();
    label352:
    boolean bool;
    label367:
    int i;
    label405:
    Object localObject2;
    label551:
    label584:
    label617:
    MagicBrushView localMagicBrushView;
    if (paramString2 != null)
    {
      paramString2 = paramString2.PtZ;
      if (paramString2 != null)
      {
        paramString2 = paramString2.getView();
        if (paramString2 == null) {
          p.iCn();
        }
        paramString3 = d.cF(paramString2);
        paramString3[0] += locala.left;
        paramString3[1] += locala.top;
        paramInt2 = paramString3[0];
        paramInt3 = paramString3[1];
        Log.d(locala.TAG, "popup:" + locala.PtM + " start locate:[" + locala.left + ", " + locala.top + "] offset:[" + paramInt2 + ", " + paramInt3 + "] size:[" + locala.Puf + ", " + locala.Pug + "] mode:" + locala.mode);
        if ((locala.mode & Puc) == 0) {
          break label971;
        }
        paramInt1 = 1;
        if ((locala.mode & Pud) == 0) {
          break label976;
        }
        bool = true;
        if (paramInt1 == 0) {
          break label982;
        }
        paramString3 = new Integer[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1) };
        paramInt4 = ((Number)paramString3[0]).intValue();
        paramInt5 = ((Number)paramString3[1]).intValue();
        paramInt6 = ((Number)paramString3[2]).intValue();
        i = ((Number)paramString3[3]).intValue();
        Log.i(locala.TAG, "popup:" + locala.PtM + " compute locate:[" + paramInt4 + ", " + paramInt5 + "] size:[" + paramInt6 + ", " + i + ']');
        paramString3 = (i)locala.context.get();
        if (paramString3 == null) {
          break label1028;
        }
        localObject2 = paramString3.Pub;
        if (localObject2 == null) {
          p.iCn();
        }
        paramString3 = (i)locala.context.get();
        if (paramString3 == null) {
          break label1034;
        }
        paramString3 = paramString3.Pua;
        if (paramString3 == null) {
          p.iCn();
        }
        localObject1 = paramString2.getContext();
        if (!(localObject1 instanceof MutableContextWrapper)) {
          break label1040;
        }
        localObject1 = ((MutableContextWrapper)localObject1).getBaseContext();
        p.j(localObject1, "viewContext");
        localObject2 = ((k)localObject2).a((Context)localObject1, locala.PtM, false, false);
        p.k(localObject1, "context");
        if (((a)localObject2).PsX == null)
        {
          ((a)localObject2).PsX = new n((a)localObject2, (Context)new MutableContextWrapper((Context)localObject1));
          localObject3 = ((a)localObject2).PsX;
          if (localObject3 != null) {
            ((n)localObject3).dnQ();
          }
        }
        localMagicBrushView = ((a)localObject2).PI();
        if (localMagicBrushView == null) {
          p.iCn();
        }
        Object localObject3 = localMagicBrushView.getParent();
        localObject2 = localObject3;
        if (!(localObject3 instanceof ViewGroup)) {
          localObject2 = null;
        }
        localObject2 = (ViewGroup)localObject2;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView((View)localMagicBrushView);
        }
        if (paramInt1 == 0) {
          break label1043;
        }
        localObject1 = new RelativeLayout((Context)localObject1);
        localObject2 = new RelativeLayout.LayoutParams(locala.Puf, locala.Pug);
        ((RelativeLayout.LayoutParams)localObject2).setMargins(paramInt2, paramInt3 + 0, 0, 0);
        localMagicBrushView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new i.a.a(locala, localMagicBrushView, paramInt2, paramInt3, bool, paramString3));
        ((RelativeLayout)localObject1).setBackground((Drawable)new ColorDrawable(locala.color));
        ((RelativeLayout)localObject1).setSystemUiVisibility(1284);
        ((RelativeLayout)localObject1).addView((View)localMagicBrushView);
      }
    }
    label1028:
    label1034:
    label1040:
    label1043:
    for (paramString3 = (View)localObject1;; paramString3 = (View)localMagicBrushView)
    {
      locala.setContentView(paramString3);
      locala.setWidth(paramInt6);
      locala.setHeight(i);
      if (paramInt1 == 0) {
        locala.setTouchable(true);
      }
      locala.setClippingEnabled(false);
      paramString2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)locala);
      locala.showAtLocation(paramString2, 0, paramInt4, paramInt5);
      this.PtY = locala;
      this.Pua.bid(paramString1);
      AppMethodBeat.o(205581);
      return;
      paramString2 = null;
      break;
      label971:
      paramInt1 = 0;
      break label352;
      label976:
      bool = false;
      break label367;
      label982:
      paramString3 = new Integer[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(locala.Puf), Integer.valueOf(locala.Pug) };
      break label405;
      localObject2 = null;
      break label551;
      paramString3 = null;
      break label584;
      break label617;
    }
  }
  
  public final void bif(String paramString)
  {
    AppMethodBeat.i(205580);
    p.k(paramString, "popupId");
    Log.i(this.TAG, "precreate:".concat(String.valueOf(paramString)));
    k localk = this.Pub;
    f.a locala = f.Pvm;
    localk.a(f.a.getAppContext(), paramString, false, false);
    AppMethodBeat.o(205580);
  }
  
  public final void close(String paramString)
  {
    AppMethodBeat.i(205582);
    p.k(paramString, "popupId");
    a locala = this.PtY;
    if (locala != null)
    {
      if (p.h(locala.PtM, paramString)) {}
      for (paramString = locala; paramString != null; paramString = null)
      {
        paramString.dismiss();
        AppMethodBeat.o(205582);
        return;
      }
    }
    AppMethodBeat.o(205582);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "Landroid/view/View$OnAttachStateChangeListener;", "popupId", "", "popupWidth", "", "popupHeight", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "context", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "(Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "TAG", "getPopupId", "()Ljava/lang/String;", "dismiss", "", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "show", "webview-sdk_release"})
  static final class a
    extends r
    implements View.OnAttachStateChangeListener
  {
    final String PtM;
    final int Puf;
    final int Pug;
    private final String Puh;
    private final String Pui;
    final String TAG;
    final int color;
    final WeakReference<i> context;
    final int left;
    final int mode;
    final int top;
    
    public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, WeakReference<i> paramWeakReference) {}
    
    public final void dismiss()
    {
      AppMethodBeat.i(207103);
      Log.i(this.TAG, "popup on dismiss:" + this.PtM);
      i locali = (i)this.context.get();
      if (locali != null)
      {
        View localView = i.a(locali).getView();
        if (localView != null) {
          localView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
        c.a.a(i.b(locali), this.Puh, null, null, 6);
        i.b(locali).bid("none");
        i.c(locali);
      }
      super.dismiss();
      AppMethodBeat.o(207103);
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(207102);
      dismiss();
      AppMethodBeat.o(207102);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$2$2"})
    static final class a
      implements View.OnClickListener
    {
      a(i.a parama, MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, boolean paramBoolean, c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(207714);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.Pun) {
          c.a.a(this.Puo, i.a.a(this.Puj), null, null, 6);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207714);
          return;
          this.Puj.dismiss();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$Companion;", "", "()V", "MODE_MASK", "", "MODE_MASK_PERSIST", "webview-sdk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.i
 * JD-Core Version:    0.7.0.1
 */