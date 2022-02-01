package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "footerStub", "getFooterStub", "()Landroid/view/View;", "setFooterStub", "headerStub", "getHeaderStub", "setHeaderStub", "loadingIv", "Landroid/widget/ImageView;", "mMuteIconIv", "maskView", "multiTalkVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;", "switchCameraTv", "Landroid/widget/TextView;", "talkingAvatarLayout", "getTalkingAvatarLayout", "setTalkingAvatarLayout", "userName", "", "voiceMaskIv", "weakNetworkIv", "showMuteIcon", "", "visible", "", "plugin-multitalk_release"})
public final class b
  extends RecyclerView.v
{
  public View lRB;
  public MultiTalkVideoView tQS;
  public ImageView tQT;
  public ImageView tQU;
  public TextView tQV;
  public ImageView tQW;
  View tQX;
  View tQY;
  View tQZ;
  public ImageView tpa;
  
  public b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178966);
    View localView = paramView.findViewById(2131305664);
    k.g(localView, "itemView.findViewById(R.id.talking_avatar_layout)");
    this.tQX = localView;
    localView = paramView.findViewById(2131300727);
    k.g(localView, "itemView.findViewById(R.id.header_stub)");
    this.tQY = localView;
    localView = paramView.findViewById(2131300209);
    k.g(localView, "itemView.findViewById(R.id.footer_stub)");
    this.tQZ = localView;
    localView = paramView.findViewById(2131305671);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tQS = ((MultiTalkVideoView)localView);
    this.lRB = paramView.findViewById(2131302169);
    localView = paramView.findViewById(2131306487);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tQT = ((ImageView)localView);
    localView = paramView.findViewById(2131302597);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tQU = ((ImageView)localView);
    localView = paramView.findViewById(2131305577);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tQV = ((TextView)localView);
    localView = paramView.findViewById(2131301502);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tpa = ((ImageView)localView);
    paramView = paramView.findViewById(2131302585);
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.tQW = ((ImageView)paramView);
    AppMethodBeat.o(178966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */