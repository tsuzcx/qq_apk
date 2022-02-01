package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "cameraStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "context", "Landroid/content/Context;", "mStatusIconLayout", "muteStatusIcon", "getRootView", "()Landroid/view/View;", "setRootView", "showCameraIcon", "", "showMuteIcon", "refreshLayoutCauseDockChanged", "", "isDockerLeft", "refreshMiniView", "setDoubleIcon", "isMuteOn", "isCameraOn", "showSelfCameraIcon", "show", "showSelfMuteIcon", "plugin-multitalk_release"})
public final class h
{
  private View Fyv;
  private WeImageView Fyw;
  private WeImageView Fyx;
  boolean Fyy;
  boolean Fyz;
  private Context context;
  View oFW;
  
  public h(View paramView)
  {
    AppMethodBeat.i(199564);
    this.oFW = paramView;
    this.context = this.oFW.getContext();
    this.Fyw = ((WeImageView)this.oFW.findViewById(a.e.multitalk_small_status_iv_camera));
    paramView = this.Fyw;
    if (paramView != null) {
      paramView.setImageResource(a.g.icons_filled_video_call);
    }
    paramView = this.Fyw;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.Fyw;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.Fyx = ((WeImageView)this.oFW.findViewById(a.e.multitalk_small_status_iv_mute));
    paramView = this.Fyx;
    if (paramView != null) {
      paramView.setImageResource(a.g.icons_filled_mike);
    }
    paramView = this.Fyx;
    if (paramView != null)
    {
      Context localContext = this.context;
      if (localContext == null) {
        p.iCn();
      }
      paramView.setIconColor(localContext.getResources().getColor(a.b.Brand));
    }
    paramView = this.Fyx;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.Fyv = this.oFW.findViewById(a.e.icon_content_double);
    paramView = this.Fyv;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(199564);
      return;
    }
    AppMethodBeat.o(199564);
  }
  
  final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199559);
    Object localObject = this.Fyv;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.Fyx;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.Fyw;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    Context localContext;
    if (!paramBoolean1)
    {
      localObject = this.Fyx;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(a.g.icons_filled_mike);
      }
      localObject = this.Fyx;
      if (localObject != null)
      {
        localContext = this.context;
        if (localContext == null) {
          p.iCn();
        }
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.Brand));
      }
    }
    while (paramBoolean2)
    {
      localObject = this.Fyw;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(a.g.icons_filled_video_call);
      }
      localObject = this.Fyw;
      if (localObject != null)
      {
        localContext = this.context;
        if (localContext == null) {
          p.iCn();
        }
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.Brand));
        AppMethodBeat.o(199559);
        return;
        localObject = this.Fyx;
        if (localObject != null) {
          ((WeImageView)localObject).setImageResource(a.g.icons_filled_mike);
        }
        localObject = this.Fyx;
        if (localObject != null)
        {
          localContext = this.context;
          if (localContext == null) {
            p.iCn();
          }
          ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.FG_2));
        }
      }
      else
      {
        AppMethodBeat.o(199559);
        return;
      }
    }
    localObject = this.Fyw;
    if (localObject != null) {
      ((WeImageView)localObject).setImageResource(a.g.icons_filled_video_call);
    }
    localObject = this.Fyw;
    if (localObject != null)
    {
      localContext = this.context;
      if (localContext == null) {
        p.iCn();
      }
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.FG_2));
      AppMethodBeat.o(199559);
      return;
    }
    AppMethodBeat.o(199559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */