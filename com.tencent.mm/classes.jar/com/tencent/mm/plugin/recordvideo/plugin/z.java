package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"})
public final class z
  implements t
{
  public static final z.a xRH;
  private long loT;
  private final CameraFrontSightView qbY;
  private final MMSightCaptureTouchView qbZ;
  private View view;
  
  static
  {
    AppMethodBeat.i(75640);
    xRH = new z.a((byte)0);
    AppMethodBeat.o(75640);
  }
  
  public z(View paramView, final d paramd)
  {
    AppMethodBeat.i(75639);
    this.view = paramView;
    paramView = this.view.findViewById(2131297707);
    p.g(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.qbY = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(2131297709);
    p.g(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.qbZ = ((MMSightCaptureTouchView)paramView);
    this.loT = bu.HQ();
    int i = a.fromDPToPix(this.view.getContext(), 120);
    this.qbY.gC(i, i);
    this.qbZ.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(75635);
        Bundle localBundle = new Bundle();
        localBundle.putFloat("PARAM_POINT_X", paramAnonymousFloat1);
        localBundle.putFloat("PARAM_POINT_Y", paramAnonymousFloat2);
        paramd.a(d.c.xTV, localBundle);
        z.a(this.xRI).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(75635);
      }
      
      public final void aVT()
      {
        AppMethodBeat.i(75637);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.xTT, localBundle);
        AppMethodBeat.o(75637);
      }
      
      public final void aVU()
      {
        AppMethodBeat.i(75638);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.xTT, localBundle);
        AppMethodBeat.o(75638);
      }
      
      public final void clJ()
      {
        AppMethodBeat.i(75636);
        if (bu.aO(z.b(this.xRI)) < 1000L)
        {
          AppMethodBeat.o(75636);
          return;
        }
        z.a(this.xRI, bu.HQ());
        d.b.a(paramd, d.c.xTU);
        AppMethodBeat.o(75636);
      }
    });
    AppMethodBeat.o(75639);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(206618);
    p.h(paramRecordConfigProvider, "config");
    this.qbY.setFocusColor(paramRecordConfigProvider.xOh.ggo);
    AppMethodBeat.o(206618);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206619);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206619);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.z
 * JD-Core Version:    0.7.0.1
 */