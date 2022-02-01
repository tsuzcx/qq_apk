package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "cameraStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "context", "Landroid/content/Context;", "mStatusIconLayout", "muteStatusIcon", "getRootView", "()Landroid/view/View;", "setRootView", "showCameraIcon", "", "showMuteIcon", "refreshLayoutCauseDockChanged", "", "isDockerLeft", "refreshMiniView", "setDoubleIcon", "isMuteOn", "isCameraOn", "showSelfCameraIcon", "show", "showSelfMuteIcon", "plugin-multitalk_release"})
public final class h
{
  private Context context;
  View lJI;
  private View zST;
  private WeImageView zSU;
  private WeImageView zSV;
  boolean zSW;
  boolean zSX;
  
  public h(View paramView)
  {
    AppMethodBeat.i(239786);
    this.lJI = paramView;
    this.context = this.lJI.getContext();
    this.zSU = ((WeImageView)this.lJI.findViewById(2131305056));
    paramView = this.zSU;
    if (paramView != null) {
      paramView.setImageResource(2131690703);
    }
    paramView = this.zSU;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.zSU;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.zSV = ((WeImageView)this.lJI.findViewById(2131305057));
    paramView = this.zSV;
    if (paramView != null) {
      paramView.setImageResource(2131690602);
    }
    paramView = this.zSV;
    if (paramView != null)
    {
      Context localContext = this.context;
      if (localContext == null) {
        p.hyc();
      }
      paramView.setIconColor(localContext.getResources().getColor(2131099710));
    }
    paramView = this.zSV;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.zST = this.lJI.findViewById(2131302487);
    paramView = this.zST;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(239786);
      return;
    }
    AppMethodBeat.o(239786);
  }
  
  final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239785);
    Object localObject = this.zST;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.zSV;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.zSU;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    Context localContext;
    if (!paramBoolean1)
    {
      localObject = this.zSV;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(2131690602);
      }
      localObject = this.zSV;
      if (localObject != null)
      {
        localContext = this.context;
        if (localContext == null) {
          p.hyc();
        }
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099710));
      }
    }
    while (paramBoolean2)
    {
      localObject = this.zSU;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(2131690703);
      }
      localObject = this.zSU;
      if (localObject != null)
      {
        localContext = this.context;
        if (localContext == null) {
          p.hyc();
        }
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099710));
        AppMethodBeat.o(239785);
        return;
        localObject = this.zSV;
        if (localObject != null) {
          ((WeImageView)localObject).setImageResource(2131690602);
        }
        localObject = this.zSV;
        if (localObject != null)
        {
          localContext = this.context;
          if (localContext == null) {
            p.hyc();
          }
          ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099749));
        }
      }
      else
      {
        AppMethodBeat.o(239785);
        return;
      }
    }
    localObject = this.zSU;
    if (localObject != null) {
      ((WeImageView)localObject).setImageResource(2131690703);
    }
    localObject = this.zSU;
    if (localObject != null)
    {
      localContext = this.context;
      if (localContext == null) {
        p.hyc();
      }
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099749));
      AppMethodBeat.o(239785);
      return;
    }
    AppMethodBeat.o(239785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */