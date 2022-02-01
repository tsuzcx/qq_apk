package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  implements v
{
  public static final ab.a NLl;
  private long sze;
  private View view;
  private final CameraFrontSightView ykL;
  private final MMSightCaptureTouchView ykM;
  
  static
  {
    AppMethodBeat.i(75640);
    NLl = new ab.a((byte)0);
    AppMethodBeat.o(75640);
  }
  
  public ab(View paramView, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75639);
    this.view = paramView;
    paramView = this.view.findViewById(b.e.capture_focus_frame);
    s.s(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.ykL = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(b.e.capture_touch_view);
    s.s(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.ykM = ((MMSightCaptureTouchView)paramView);
    this.sze = Util.currentTicks();
    int i = com.tencent.mm.cd.a.fromDPToPix(this.view.getContext(), 120);
    this.ykL.jN(i, i);
    this.ykM.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void al(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(75635);
        Bundle localBundle = new Bundle();
        localBundle.putInt("PARAM_WIDTH_INT", ab.a(this.NLm).getWidth());
        localBundle.putInt("PARAM_HEIGHT_INT", ab.a(this.NLm).getHeight());
        localBundle.putFloat("PARAM_POINT_X", paramAnonymousFloat1);
        localBundle.putFloat("PARAM_POINT_Y", paramAnonymousFloat2);
        parama.a(a.c.NNL, localBundle);
        ab.b(this.NLm).aG(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(75635);
      }
      
      public final void bof()
      {
        AppMethodBeat.i(75637);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        parama.a(a.c.NNJ, localBundle);
        AppMethodBeat.o(75637);
      }
      
      public final void bog()
      {
        AppMethodBeat.i(75638);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        parama.a(a.c.NNJ, localBundle);
        AppMethodBeat.o(75638);
      }
      
      public final void bow()
      {
        AppMethodBeat.i(75636);
        if (Util.ticksToNow(ab.c(this.NLm)) < 1000L)
        {
          AppMethodBeat.o(75636);
          return;
        }
        ab.a(this.NLm, Util.currentTicks());
        a.b.a(parama, a.c.NNK);
        AppMethodBeat.o(75636);
      }
    });
    AppMethodBeat.o(75639);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280729);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280729);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280754);
    s.u(this, "this");
    AppMethodBeat.o(280754);
  }
  
  public final void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280720);
    s.u(paramRecordConfigProvider, "config");
    this.ykL.setFocusColor(paramRecordConfigProvider.NHR.lZz);
    AppMethodBeat.o(280720);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280736);
    String str = v.a.b(this);
    AppMethodBeat.o(280736);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280746);
    s.u(this, "this");
    AppMethodBeat.o(280746);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280762);
    s.u(this, "this");
    AppMethodBeat.o(280762);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280773);
    s.u(this, "this");
    AppMethodBeat.o(280773);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280783);
    s.u(this, "this");
    AppMethodBeat.o(280783);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280793);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280793);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280802);
    s.u(this, "this");
    AppMethodBeat.o(280802);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280814);
    s.u(this, "this");
    AppMethodBeat.o(280814);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280822);
    s.u(this, "this");
    AppMethodBeat.o(280822);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280831);
    s.u(this, "this");
    AppMethodBeat.o(280831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */