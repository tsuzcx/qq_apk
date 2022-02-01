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
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ab.c.a;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ab.f.a;
import com.tencent.mm.plugin.ab.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "popupTarget", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;)V", "TAG", "", "popupWindow", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "close", "", "popupId", "popup", "width", "", "height", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "precreate", "CanvasPopup", "Companion", "webview-sdk_release"})
public final class i
  implements o
{
  private static final int IAa = 2;
  public static final i.b IAb;
  private static final int IzZ = 1;
  private a IzV;
  private final j IzW;
  private final c IzX;
  private final k IzY;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(224653);
    IAb = new i.b((byte)0);
    IzZ = 1;
    IAa = 2;
    AppMethodBeat.o(224653);
  }
  
  public i(j paramj, c paramc, k paramk)
  {
    AppMethodBeat.i(224652);
    this.IzW = paramj;
    this.IzX = paramc;
    this.IzY = paramk;
    this.TAG = "MicroMsg.WebCanvasPopupContext";
    AppMethodBeat.o(224652);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224650);
    kotlin.g.b.p.h(paramString1, "popupId");
    kotlin.g.b.p.h(paramString2, "onDismissCallback");
    kotlin.g.b.p.h(paramString3, "onOuterClickCallback");
    Object localObject1 = this.IzW.getView();
    if ((localObject1 == null) || (((View)localObject1).isAttachedToWindow() != true))
    {
      Log.w(this.TAG, "skip popup when canvasView detached:".concat(String.valueOf(paramString1)));
      c.a.a(this.IzX, paramString2, null, null, 6);
      AppMethodBeat.o(224650);
      return;
    }
    localObject1 = this.IzV;
    if (localObject1 != null) {
      ((a)localObject1).dismiss();
    }
    a locala = new a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, new WeakReference(this));
    paramString2 = (i)locala.lAM.get();
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
      paramString2 = paramString2.IzW;
      if (paramString2 != null)
      {
        paramString2 = paramString2.getView();
        if (paramString2 == null) {
          kotlin.g.b.p.hyc();
        }
        paramString3 = d.cm(paramString2);
        paramString3[0] += locala.left;
        paramString3[1] += locala.top;
        paramInt2 = paramString3[0];
        paramInt3 = paramString3[1];
        Log.d(locala.TAG, "popup:" + locala.IzJ + " start locate:[" + locala.left + ", " + locala.top + "] offset:[" + paramInt2 + ", " + paramInt3 + "] size:[" + locala.IAc + ", " + locala.IAd + "] mode:" + locala.mode);
        if ((locala.mode & IzZ) == 0) {
          break label971;
        }
        paramInt1 = 1;
        if ((locala.mode & IAa) == 0) {
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
        Log.i(locala.TAG, "popup:" + locala.IzJ + " compute locate:[" + paramInt4 + ", " + paramInt5 + "] size:[" + paramInt6 + ", " + i + ']');
        paramString3 = (i)locala.lAM.get();
        if (paramString3 == null) {
          break label1028;
        }
        localObject2 = paramString3.IzY;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        paramString3 = (i)locala.lAM.get();
        if (paramString3 == null) {
          break label1034;
        }
        paramString3 = paramString3.IzX;
        if (paramString3 == null) {
          kotlin.g.b.p.hyc();
        }
        localObject1 = paramString2.getContext();
        if (!(localObject1 instanceof MutableContextWrapper)) {
          break label1040;
        }
        localObject1 = ((MutableContextWrapper)localObject1).getBaseContext();
        kotlin.g.b.p.g(localObject1, "viewContext");
        localObject2 = ((k)localObject2).a((Context)localObject1, locala.IzJ, false, false);
        kotlin.g.b.p.h(localObject1, "context");
        if (((a)localObject2).IyU == null)
        {
          ((a)localObject2).IyU = new n((a)localObject2, (Context)new MutableContextWrapper((Context)localObject1));
          localObject3 = ((a)localObject2).IyU;
          if (localObject3 != null) {
            ((n)localObject3).cYb();
          }
        }
        localMagicBrushView = ((a)localObject2).MQ();
        if (localMagicBrushView == null) {
          kotlin.g.b.p.hyc();
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
        localObject2 = new RelativeLayout.LayoutParams(locala.IAc, locala.IAd);
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
      this.IzV = locala;
      this.IzX.aWw(paramString1);
      AppMethodBeat.o(224650);
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
      paramString3 = new Integer[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(locala.IAc), Integer.valueOf(locala.IAd) };
      break label405;
      localObject2 = null;
      break label551;
      paramString3 = null;
      break label584;
      break label617;
    }
  }
  
  public final void aWy(String paramString)
  {
    AppMethodBeat.i(224649);
    kotlin.g.b.p.h(paramString, "popupId");
    Log.i(this.TAG, "precreate:".concat(String.valueOf(paramString)));
    k localk = this.IzY;
    f.a locala = f.IBd;
    localk.a(f.a.getAppContext(), paramString, false, false);
    AppMethodBeat.o(224649);
  }
  
  public final void close(String paramString)
  {
    AppMethodBeat.i(224651);
    kotlin.g.b.p.h(paramString, "popupId");
    a locala = this.IzV;
    if (locala != null)
    {
      if (kotlin.g.b.p.j(locala.IzJ, paramString)) {}
      for (paramString = locala; paramString != null; paramString = null)
      {
        paramString.dismiss();
        AppMethodBeat.o(224651);
        return;
      }
    }
    AppMethodBeat.o(224651);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "Landroid/view/View$OnAttachStateChangeListener;", "popupId", "", "popupWidth", "", "popupHeight", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "context", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "(Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "TAG", "getPopupId", "()Ljava/lang/String;", "dismiss", "", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "show", "webview-sdk_release"})
  static final class a
    extends com.tencent.mm.ui.base.p
    implements View.OnAttachStateChangeListener
  {
    final int IAc;
    final int IAd;
    private final String IAe;
    private final String IAf;
    final String IzJ;
    final String TAG;
    final int color;
    final WeakReference<i> lAM;
    final int left;
    final int mode;
    final int top;
    
    public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, WeakReference<i> paramWeakReference) {}
    
    public final void dismiss()
    {
      AppMethodBeat.i(224647);
      Log.i(this.TAG, "popup on dismiss:" + this.IzJ);
      i locali = (i)this.lAM.get();
      if (locali != null)
      {
        View localView = i.a(locali).getView();
        if (localView != null) {
          localView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
        c.a.a(i.b(locali), this.IAe, null, null, 6);
        i.b(locali).aWw("none");
        i.c(locali);
      }
      super.dismiss();
      AppMethodBeat.o(224647);
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(224646);
      dismiss();
      AppMethodBeat.o(224646);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$2$2"})
    static final class a
      implements View.OnClickListener
    {
      a(i.a parama, MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, boolean paramBoolean, c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(224645);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.IAk) {
          c.a.a(this.IAl, i.a.a(this.IAg), null, null, 6);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(224645);
          return;
          this.IAg.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.i
 * JD-Core Version:    0.7.0.1
 */