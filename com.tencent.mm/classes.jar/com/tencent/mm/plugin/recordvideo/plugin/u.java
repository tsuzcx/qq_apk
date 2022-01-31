package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onBackPress", "", "onPause", "", "onResume", "release", "Companion", "plugin-recordvideo_release"})
public final class u
  implements q
{
  public static final u.a qcX;
  private final CameraFrontSightView lyh;
  private final MMSightCaptureTouchView lyi;
  private long startTimeStamp;
  private View view;
  
  static
  {
    AppMethodBeat.i(150721);
    qcX = new u.a((byte)0);
    AppMethodBeat.o(150721);
  }
  
  public u(View paramView, d paramd)
  {
    AppMethodBeat.i(150720);
    this.view = paramView;
    paramView = this.view.findViewById(2131823535);
    j.p(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.lyh = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(2131823536);
    j.p(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.lyi = ((MMSightCaptureTouchView)paramView);
    this.startTimeStamp = bo.yB();
    int i = a.fromDPToPix(this.view.getContext(), 120);
    this.lyh.eI(i, i);
    this.lyi.setTouchCallback((MMSightCaptureTouchView.a)new u.1(this, paramd));
    AppMethodBeat.o(150720);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.u
 * JD-Core Version:    0.7.0.1
 */