package com.tencent.mm.plugin.sns.ui.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.alphavideo.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/widget/SnsAdBreakFrameVideoView$startPrepare$1", "Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AlphaPlayerListener;", "onError", "", "playerView", "Landroid/view/View;", "reason", "", "onOpenGLInit", "onPlayerStateChange", "preState", "", "curState", "onRelease", "onStatusChanged", "status", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAdBreakFrameVideoView$d
  implements a
{
  SnsAdBreakFrameVideoView$d(SnsAdBreakFrameVideoView paramSnsAdBreakFrameVideoView) {}
  
  public final void ajV(int paramInt)
  {
    AppMethodBeat.i(309240);
    Log.d("SnsAdCoverVideoView", s.X("onStatusChanged ", Integer.valueOf(paramInt)));
    if (paramInt == 5) {
      this.RVN.get_completionFlow().jc(Boolean.TRUE);
    }
    AppMethodBeat.o(309240);
  }
  
  public final void j(View paramView, String paramString)
  {
    AppMethodBeat.i(309238);
    s.u(paramView, "playerView");
    s.u(paramString, "reason");
    Log.d("SnsAdCoverVideoView", "onError() called with: playerView = " + paramView + ", reason = " + paramString);
    AppMethodBeat.o(309238);
  }
  
  public final void jn(View paramView)
  {
    AppMethodBeat.i(309243);
    s.u(paramView, "playerView");
    Log.d("SnsAdCoverVideoView", s.X("onRelease() called with: playerView = ", paramView));
    AppMethodBeat.o(309243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView.d
 * JD-Core Version:    0.7.0.1
 */