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
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"})
public final class z
  implements t
{
  public static final z.a BRL;
  private long mvz;
  private final CameraFrontSightView rsV;
  private final MMSightCaptureTouchView rsW;
  private View view;
  
  static
  {
    AppMethodBeat.i(75640);
    BRL = new z.a((byte)0);
    AppMethodBeat.o(75640);
  }
  
  public z(View paramView, final d paramd)
  {
    AppMethodBeat.i(75639);
    this.view = paramView;
    paramView = this.view.findViewById(2131298002);
    p.g(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.rsV = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(2131298005);
    p.g(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.rsW = ((MMSightCaptureTouchView)paramView);
    this.mvz = Util.currentTicks();
    int i = a.fromDPToPix(this.view.getContext(), 120);
    this.rsV.hd(i, i);
    this.rsW.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void I(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(75635);
        Bundle localBundle = new Bundle();
        localBundle.putFloat("PARAM_POINT_X", paramAnonymousFloat1);
        localBundle.putFloat("PARAM_POINT_Y", paramAnonymousFloat2);
        paramd.a(d.c.BUu, localBundle);
        z.a(this.BRM).aa(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(75635);
      }
      
      public final void bqQ()
      {
        AppMethodBeat.i(75637);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.BUs, localBundle);
        AppMethodBeat.o(75637);
      }
      
      public final void bqR()
      {
        AppMethodBeat.i(75638);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.BUs, localBundle);
        AppMethodBeat.o(75638);
      }
      
      public final void cJL()
      {
        AppMethodBeat.i(75636);
        if (Util.ticksToNow(z.b(this.BRM)) < 1000L)
        {
          AppMethodBeat.o(75636);
          return;
        }
        z.a(this.BRM, Util.currentTicks());
        d.b.a(paramd, d.c.BUt);
        AppMethodBeat.o(75636);
      }
    });
    AppMethodBeat.o(75639);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237347);
    p.h(paramRecordConfigProvider, "config");
    this.rsV.setFocusColor(paramRecordConfigProvider.BOn.gLS);
    AppMethodBeat.o(237347);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237348);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237348);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.z
 * JD-Core Version:    0.7.0.1
 */