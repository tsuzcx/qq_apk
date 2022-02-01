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
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mCancelBtn", "Landroid/widget/TextView;", "mStopProjectAction", "Landroid/view/View;", "mStopProjectIconIv", "Landroid/widget/ImageView;", "mStopProjectTv", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "topUiLayout", "getTopUiLayout", "()Landroid/view/View;", "setTopUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "getLandScapeLayout", "viewGroup", "Landroid/widget/FrameLayout;", "getPortraitLayout", "refreshLayout", "showReaderContent", "show", "", "plugin-multitalk_release"})
public final class p
{
  Context context;
  TextView qCm;
  a zQD;
  View zXU;
  View zXV;
  TextView zXW;
  ImageView zXX;
  
  public p(Context paramContext, a parama)
  {
    AppMethodBeat.i(240056);
    this.context = paramContext;
    this.zQD = parama;
    AppMethodBeat.o(240056);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(240054);
    Object localObject;
    if (this.zXX != null)
    {
      localObject = this.zXX;
      if (localObject != null) {
        ((ImageView)localObject).setBackground(ar.m(this.context, 2131690685, Color.parseColor("#FA5151")));
      }
    }
    for (;;)
    {
      localObject = this.qCm;
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(240054);
      return;
      localObject = this.zXV;
      if (localObject != null) {
        ((View)localObject).setBackground(ar.m(this.context, 2131233005, Color.parseColor("#FA5151")));
      }
      localObject = k.zTz;
      if (k.a.gE(this.context) != 90)
      {
        localObject = k.zTz;
        if (k.a.gE(this.context) != 270) {}
      }
      else
      {
        localObject = this.zXW;
        if (localObject == null) {
          continue;
        }
        ((TextView)localObject).setText(2131765023);
        continue;
      }
      localObject = this.zXW;
      if (localObject != null) {
        ((TextView)localObject).setText(2131765014);
      }
    }
    AppMethodBeat.o(240054);
  }
  
  final void epA()
  {
    AppMethodBeat.i(240055);
    Object localObject = this.zXU;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131305801);
      this.zXV = ((View)localObject);
      localObject = this.zXU;
      if (localObject == null) {
        break label158;
      }
    }
    label158:
    for (localObject = (TextView)((View)localObject).findViewById(2131305802);; localObject = null)
    {
      this.zXW = ((TextView)localObject);
      if (this.zXX == null) {
        break label163;
      }
      localObject = this.zXX;
      if (localObject != null) {
        ((ImageView)localObject).setBackground(ar.m(this.context, 2131690685, Color.parseColor("#FA5151")));
      }
      localObject = this.qCm;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.qCm;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject = this.zXV;
      if (localObject == null) {
        break label272;
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(240055);
      return;
      localObject = null;
      break;
    }
    label163:
    localObject = this.zXV;
    if (localObject != null) {
      ((View)localObject).setBackground(ar.m(this.context, 2131233005, Color.parseColor("#FA5151")));
    }
    localObject = k.zTz;
    if (k.a.gE(this.context) != 90)
    {
      localObject = k.zTz;
      if (k.a.gE(this.context) != 270) {}
    }
    else
    {
      localObject = this.zXW;
      if (localObject != null) {
        ((TextView)localObject).setText(2131765023);
      }
    }
    for (;;)
    {
      localObject = this.zXV;
      if (localObject == null) {
        break;
      }
      ((View)localObject).requestLayout();
      break;
      localObject = this.zXW;
      if (localObject != null) {
        ((TextView)localObject).setText(2131765014);
      }
    }
    label272:
    AppMethodBeat.o(240055);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(p paramp) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240049);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.b.a(this.zXY.zQD, a.c.zVm);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240049);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(p paramp) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(240053);
      Object localObject2 = new b();
      ((b)localObject2).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).axR());
      if (this.zXY.zQD.getCurrentStatus())
      {
        localObject2 = new d.a(this.zXY.context);
        paramView = this.zXY.context.getResources();
        if (paramView != null) {}
        for (paramView = paramView.getString(2131765024);; paramView = null)
        {
          ((d.a)localObject2).boo(paramView);
          d.a locala = ((d.a)localObject2).aoV(2131765023).c((DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(240050);
              a.b.a(this.zXZ.zXY.zQD, a.c.zVm);
              ImageView localImageView = this.zXZ.zXY.zXX;
              if (localImageView != null) {
                localImageView.setBackground(ar.m(this.zXZ.zXY.context, 2131690682, Color.parseColor("#07C160")));
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(240050);
            }
          });
          Object localObject3 = this.zXY.context;
          paramView = localObject1;
          if (localObject3 != null)
          {
            localObject3 = ((Context)localObject3).getResources();
            paramView = localObject1;
            if (localObject3 != null) {
              paramView = Integer.valueOf(((Resources)localObject3).getColor(2131099818));
            }
          }
          if (paramView == null) {
            kotlin.g.b.p.hyc();
          }
          locala.aoX(paramView.intValue());
          ((d.a)localObject2).aoW(2131755761).d((DialogInterface.OnClickListener)p.b.2.zYa);
          ((d.a)localObject2).hbn().show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240053);
          return;
        }
      }
      if (this.zXY.zXX != null)
      {
        paramView = this.zXY.zXX;
        if (paramView != null) {
          paramView.setBackground(ar.m(this.zXY.context, 2131690685, Color.parseColor("#FA5151")));
        }
      }
      for (;;)
      {
        a.b.a(this.zXY.zQD, a.c.zVl);
        paramView = this.zXY.qCm;
        if (paramView == null) {
          break;
        }
        paramView.setVisibility(8);
        break;
        paramView = this.zXY.zXV;
        if (paramView != null) {
          paramView.setBackground(ar.m(this.zXY.context, 2131233005, Color.parseColor("#FA5151")));
        }
        paramView = this.zXY.zXW;
        if (paramView != null) {
          paramView.setText(2131765014);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.p
 * JD-Core Version:    0.7.0.1
 */