package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordOrientationPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "getCallback", "()Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "setCallback", "(Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;)V", "getContext", "()Landroid/content/Context;", "setContext", "<set-?>", "", "currentDegree", "getCurrentDegree", "()I", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "getOrientation", "isLandscape", "", "onOrientationChange", "", "orientation", "onPause", "onResume", "release", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  implements d.a, v
{
  public d.a KUU;
  public int NLn;
  private Context context;
  private d orientationEventListener;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(280701);
    this.context = paramContext;
    this.orientationEventListener = new d(this.context, (byte)0);
    this.orientationEventListener.KUU = ((d.a)this);
    AppMethodBeat.o(280701);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280733);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280733);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280759);
    s.u(this, "this");
    AppMethodBeat.o(280759);
  }
  
  public final boolean isLandscape()
  {
    return (this.NLn + 360) % 180 != 0;
  }
  
  public final String name()
  {
    AppMethodBeat.i(280743);
    String str = v.a.b(this);
    AppMethodBeat.o(280743);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280750);
    s.u(this, "this");
    AppMethodBeat.o(280750);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280770);
    s.u(this, "this");
    AppMethodBeat.o(280770);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280781);
    s.u(this, "this");
    AppMethodBeat.o(280781);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    int j = 90;
    AppMethodBeat.i(280727);
    if (paramInt < 0)
    {
      AppMethodBeat.o(280727);
      return;
    }
    int i;
    switch (((Activity)this.context).getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
      i = (i + paramInt + 360) % 360;
      switch (i)
      {
      default: 
        paramInt = i;
      }
      break;
    }
    for (;;)
    {
      if (paramInt != this.NLn)
      {
        this.NLn = paramInt;
        d.a locala = this.KUU;
        if (locala != null) {
          locala.onOrientationChange(this.NLn);
        }
      }
      AppMethodBeat.o(280727);
      return;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
      paramInt = j;
      if (i != 270) {
        paramInt = -90;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280711);
    s.u((v)this, "this");
    this.orientationEventListener.disable();
    AppMethodBeat.o(280711);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280790);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280790);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280706);
    s.u((v)this, "this");
    this.orientationEventListener.enable();
    AppMethodBeat.o(280706);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280716);
    s.u((v)this, "this");
    this.orientationEventListener.KUU = null;
    this.orientationEventListener.disable();
    AppMethodBeat.o(280716);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280800);
    s.u(this, "this");
    AppMethodBeat.o(280800);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280811);
    s.u(this, "this");
    AppMethodBeat.o(280811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ac
 * JD-Core Version:    0.7.0.1
 */