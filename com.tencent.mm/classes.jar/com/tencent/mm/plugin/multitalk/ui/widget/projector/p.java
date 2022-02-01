package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mCancelBtn", "Landroid/widget/TextView;", "mStopProjectAction", "Landroid/view/View;", "mStopProjectIconIv", "Landroid/widget/ImageView;", "mStopProjectTv", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "topUiLayout", "getTopUiLayout", "()Landroid/view/View;", "setTopUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "getLandScapeLayout", "viewGroup", "Landroid/widget/FrameLayout;", "getPortraitLayout", "refreshLayout", "showReaderContent", "show", "", "plugin-multitalk_release"})
public final class p
{
  View FDG;
  View FDH;
  TextView FDI;
  ImageView FDJ;
  a Fwg;
  Context context;
  TextView ubm;
  
  public p(Context paramContext, a parama)
  {
    AppMethodBeat.i(196240);
    this.context = paramContext;
    this.Fwg = parama;
    AppMethodBeat.o(196240);
  }
  
  final void eZo()
  {
    AppMethodBeat.i(196238);
    Object localObject = this.FDG;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(a.e.pause_project_iv);
      this.FDH = ((View)localObject);
      localObject = this.FDG;
      if (localObject == null) {
        break label161;
      }
    }
    label161:
    for (localObject = (TextView)((View)localObject).findViewById(a.e.pause_project_tv);; localObject = null)
    {
      this.FDI = ((TextView)localObject);
      if (this.FDJ == null) {
        break label166;
      }
      localObject = this.FDJ;
      if (localObject != null) {
        ((ImageView)localObject).setBackground(au.o(this.context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
      }
      localObject = this.ubm;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.ubm;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject = this.FDH;
      if (localObject == null) {
        break label278;
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(196238);
      return;
      localObject = null;
      break;
    }
    label166:
    localObject = this.FDH;
    if (localObject != null) {
      ((View)localObject).setBackground(au.o(this.context, a.d.green_rect_link, Color.parseColor("#FA5151")));
    }
    localObject = k.Fzb;
    if (k.a.hB(this.context) != 90)
    {
      localObject = k.Fzb;
      if (k.a.hB(this.context) != 270) {}
    }
    else
    {
      localObject = this.FDI;
      if (localObject != null) {
        ((TextView)localObject).setText(a.h.screen_projector_pause_btn);
      }
    }
    for (;;)
    {
      localObject = this.FDH;
      if (localObject == null) {
        break;
      }
      ((View)localObject).requestLayout();
      break;
      localObject = this.FDI;
      if (localObject != null) {
        ((TextView)localObject).setText(a.h.screen_project_pause);
      }
    }
    label278:
    AppMethodBeat.o(196238);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(p paramp) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197410);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.b.a(this.FDK.Fwg, a.c.FAW);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197410);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(p paramp) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(200116);
      Object localObject2 = new b();
      ((b)localObject2).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).aFi());
      if (this.FDK.Fwg.getCurrentStatus())
      {
        localObject2 = new d.a(this.FDK.context);
        paramView = this.FDK.context.getResources();
        if (paramView != null) {}
        for (paramView = paramView.getString(a.h.screen_projector_stop_tip);; paramView = null)
        {
          ((d.a)localObject2).bBd(paramView);
          d.a locala = ((d.a)localObject2).ayj(a.h.screen_projector_pause_btn).c((DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(196074);
              a.b.a(this.FDL.FDK.Fwg, a.c.FAW);
              ImageView localImageView = p.a(this.FDL.FDK);
              if (localImageView != null) {
                localImageView.setBackground(au.o(this.FDL.FDK.context, a.g.icons_filled_start, Color.parseColor("#07C160")));
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(196074);
            }
          });
          Object localObject3 = this.FDK.context;
          paramView = localObject1;
          if (localObject3 != null)
          {
            localObject3 = ((Context)localObject3).getResources();
            paramView = localObject1;
            if (localObject3 != null) {
              paramView = Integer.valueOf(((Resources)localObject3).getColor(com.tencent.mm.plugin.multitalk.a.b.Red));
            }
          }
          if (paramView == null) {
            kotlin.g.b.p.iCn();
          }
          locala.ayl(paramView.intValue());
          ((d.a)localObject2).ayk(a.h.app_cancel).d((DialogInterface.OnClickListener)p.b.2.FDM);
          ((d.a)localObject2).icu().show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200116);
          return;
        }
      }
      if (p.a(this.FDK) != null)
      {
        paramView = p.a(this.FDK);
        if (paramView != null) {
          paramView.setBackground(au.o(this.FDK.context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
        }
      }
      for (;;)
      {
        a.b.a(this.FDK.Fwg, a.c.FAV);
        paramView = p.d(this.FDK);
        if (paramView == null) {
          break;
        }
        paramView.setVisibility(8);
        break;
        paramView = p.b(this.FDK);
        if (paramView != null) {
          paramView.setBackground(au.o(this.FDK.context, a.d.green_rect_link, Color.parseColor("#FA5151")));
        }
        paramView = p.c(this.FDK);
        if (paramView != null) {
          paramView.setText(a.h.screen_project_pause);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.p
 * JD-Core Version:    0.7.0.1
 */