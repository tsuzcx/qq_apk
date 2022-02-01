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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "cameraStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "context", "Landroid/content/Context;", "mStatusIconLayout", "muteStatusIcon", "getRootView", "()Landroid/view/View;", "setRootView", "showCameraIcon", "", "getShowCameraIcon", "()Z", "setShowCameraIcon", "(Z)V", "showMuteIcon", "getShowMuteIcon", "setShowMuteIcon", "refreshLayoutCauseDockChanged", "", "isDockerLeft", "refreshMiniView", "setDoubleIcon", "isMuteOn", "isCameraOn", "showSelfCameraIcon", "show", "showSelfMuteIcon", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private View LuH;
  private WeImageView LuI;
  private WeImageView LuJ;
  boolean LuK;
  boolean LuL;
  private Context context;
  View rootView;
  
  public h(View paramView)
  {
    AppMethodBeat.i(285413);
    this.rootView = paramView;
    this.context = this.rootView.getContext();
    this.LuI = ((WeImageView)this.rootView.findViewById(a.e.multitalk_small_status_iv_camera));
    paramView = this.LuI;
    if (paramView != null) {
      paramView.setImageResource(a.g.icons_filled_video_call);
    }
    paramView = this.LuI;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.LuI;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.LuJ = ((WeImageView)this.rootView.findViewById(a.e.multitalk_small_status_iv_mute));
    paramView = this.LuJ;
    if (paramView != null) {
      paramView.setImageResource(a.g.icons_filled_mike);
    }
    paramView = this.LuJ;
    if (paramView != null)
    {
      Context localContext = this.context;
      s.checkNotNull(localContext);
      paramView.setIconColor(localContext.getResources().getColor(a.b.Brand));
    }
    paramView = this.LuJ;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.LuH = this.rootView.findViewById(a.e.icon_content_double);
    paramView = this.LuH;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(285413);
  }
  
  final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(285418);
    Object localObject = this.LuH;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.LuJ;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.LuI;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    Context localContext;
    if (!paramBoolean1)
    {
      localObject = this.LuJ;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(a.g.icons_filled_mike);
      }
      localObject = this.LuJ;
      if (localObject != null)
      {
        localContext = this.context;
        s.checkNotNull(localContext);
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.Brand));
      }
    }
    while (paramBoolean2)
    {
      localObject = this.LuI;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(a.g.icons_filled_video_call);
      }
      localObject = this.LuI;
      if (localObject == null) {
        break label268;
      }
      localContext = this.context;
      s.checkNotNull(localContext);
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.Brand));
      AppMethodBeat.o(285418);
      return;
      localObject = this.LuJ;
      if (localObject != null) {
        ((WeImageView)localObject).setImageResource(a.g.icons_filled_mike);
      }
      localObject = this.LuJ;
      if (localObject != null)
      {
        localContext = this.context;
        s.checkNotNull(localContext);
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.FG_2));
      }
    }
    localObject = this.LuI;
    if (localObject != null) {
      ((WeImageView)localObject).setImageResource(a.g.icons_filled_video_call);
    }
    localObject = this.LuI;
    if (localObject != null)
    {
      localContext = this.context;
      s.checkNotNull(localContext);
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(a.b.FG_2));
    }
    label268:
    AppMethodBeat.o(285418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */