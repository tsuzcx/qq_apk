package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"})
public final class aa
  implements t
{
  public static final aa.a wtQ;
  private long kNS;
  private final CameraFrontSightView prN;
  private final MMSightCaptureTouchView prO;
  private View view;
  
  static
  {
    AppMethodBeat.i(75640);
    wtQ = new aa.a((byte)0);
    AppMethodBeat.o(75640);
  }
  
  public aa(View paramView, final d paramd)
  {
    AppMethodBeat.i(75639);
    this.view = paramView;
    paramView = this.view.findViewById(2131297707);
    k.g(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.prN = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(2131297709);
    k.g(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.prO = ((MMSightCaptureTouchView)paramView);
    this.kNS = bs.Gn();
    int i = a.fromDPToPix(this.view.getContext(), 120);
    this.prN.gl(i, i);
    this.prO.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void D(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(75635);
        Bundle localBundle = new Bundle();
        localBundle.putFloat("PARAM_POINT_X", paramAnonymousFloat1);
        localBundle.putFloat("PARAM_POINT_Y", paramAnonymousFloat2);
        paramd.a(d.c.wvS, localBundle);
        aa.a(this.wtR).U(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(75635);
      }
      
      public final void aSi()
      {
        AppMethodBeat.i(75637);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.wvQ, localBundle);
        AppMethodBeat.o(75637);
      }
      
      public final void aSj()
      {
        AppMethodBeat.i(75638);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.wvQ, localBundle);
        AppMethodBeat.o(75638);
      }
      
      public final void cfQ()
      {
        AppMethodBeat.i(75636);
        if (bs.aO(aa.b(this.wtR)) < 1000L)
        {
          AppMethodBeat.o(75636);
          return;
        }
        aa.a(this.wtR, bs.Gn());
        d.b.a(paramd, d.c.wvR);
        AppMethodBeat.o(75636);
      }
    });
    AppMethodBeat.o(75639);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199321);
    k.h(paramRecordConfigProvider, "config");
    this.prN.setFocusColor(paramRecordConfigProvider.wqu.fKF);
    AppMethodBeat.o(199321);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */