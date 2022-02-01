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
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"})
public final class z
  implements t
{
  public static final z.a xBM;
  private long lkv;
  private final CameraFrontSightView pVt;
  private final MMSightCaptureTouchView pVu;
  private View view;
  
  static
  {
    AppMethodBeat.i(75640);
    xBM = new z.a((byte)0);
    AppMethodBeat.o(75640);
  }
  
  public z(View paramView, final d paramd)
  {
    AppMethodBeat.i(75639);
    this.view = paramView;
    paramView = this.view.findViewById(2131297707);
    p.g(paramView, "view.findViewById(R.id.capture_focus_frame)");
    this.pVt = ((CameraFrontSightView)paramView);
    paramView = this.view.findViewById(2131297709);
    p.g(paramView, "view.findViewById(R.id.capture_touch_view)");
    this.pVu = ((MMSightCaptureTouchView)paramView);
    this.lkv = bt.HI();
    int i = a.fromDPToPix(this.view.getContext(), 120);
    this.pVt.gC(i, i);
    this.pVu.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(75635);
        Bundle localBundle = new Bundle();
        localBundle.putFloat("PARAM_POINT_X", paramAnonymousFloat1);
        localBundle.putFloat("PARAM_POINT_Y", paramAnonymousFloat2);
        paramd.a(d.c.xEa, localBundle);
        z.a(this.xBN).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(75635);
      }
      
      public final void aVu()
      {
        AppMethodBeat.i(75637);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.xDY, localBundle);
        AppMethodBeat.o(75637);
      }
      
      public final void aVv()
      {
        AppMethodBeat.i(75638);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
        localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
        localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
        paramd.a(d.c.xDY, localBundle);
        AppMethodBeat.o(75638);
      }
      
      public final void ckt()
      {
        AppMethodBeat.i(75636);
        if (bt.aO(z.b(this.xBN)) < 1000L)
        {
          AppMethodBeat.o(75636);
          return;
        }
        z.a(this.xBN, bt.HI());
        d.b.a(paramd, d.c.xDZ);
        AppMethodBeat.o(75636);
      }
    });
    AppMethodBeat.o(75639);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(200357);
    p.h(paramRecordConfigProvider, "config");
    this.pVt.setFocusColor(paramRecordConfigProvider.xyk.geg);
    AppMethodBeat.o(200357);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200358);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200358);
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