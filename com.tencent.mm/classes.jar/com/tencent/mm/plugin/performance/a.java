package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;

public final class a
  implements Application.ActivityLifecycleCallbacks, o, c.a
{
  private static a wVR;
  ay cCf;
  String mProcessName;
  volatile int mState;
  
  private a(String paramString)
  {
    AppMethodBeat.i(176886);
    this.mState = 0;
    String str = "fg_killed_state_".concat(String.valueOf(paramString));
    this.mProcessName = paramString;
    this.cCf = ay.aRX(str);
    ae.d("MicroMsg.ForegroundKilledDetect", "MMKV stg :%s", new Object[] { str });
    AppMethodBeat.o(176886);
  }
  
  public static a avB(String paramString)
  {
    AppMethodBeat.i(176887);
    if (wVR == null) {
      wVR = new a(paramString.replace(":", "_"));
    }
    paramString = wVR;
    AppMethodBeat.o(176887);
    return paramString;
  }
  
  private void setState(int paramInt)
  {
    this.mState |= paramInt;
  }
  
  final void Ne(int paramInt)
  {
    this.mState &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final String bfd()
  {
    AppMethodBeat.i(176893);
    ae.d("MicroMsg.ForegroundKilledDetect", "%s : crash was caught! DO NOT report this case", new Object[] { this.mProcessName });
    int i = this.mState;
    if (!dBK())
    {
      setState(4);
      dBL();
    }
    ae.d("MicroMsg.ForegroundKilledDetect", "%s: setStateCrashCaught state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176893);
    return "";
  }
  
  final boolean dBI()
  {
    return (this.mState & 0x1) == 1;
  }
  
  final boolean dBJ()
  {
    return (this.mState & 0x2) == 2;
  }
  
  final boolean dBK()
  {
    return (this.mState & 0x4) == 4;
  }
  
  final void dBL()
  {
    AppMethodBeat.i(176892);
    this.cCf.encode("state", this.mState);
    AppMethodBeat.o(176892);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(176889);
    int i = this.mState;
    if (dBJ())
    {
      Ne(2);
      dBL();
    }
    ae.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176889);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(176888);
    int i = this.mState;
    if (!dBJ())
    {
      setState(2);
      dBL();
    }
    ae.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176888);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(176891);
    int i = this.mState;
    if (dBI())
    {
      Ne(1);
      dBL();
    }
    ae.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176891);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(176890);
    int i = this.mState;
    if (!dBI())
    {
      setState(1);
      dBL();
    }
    ae.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a
 * JD-Core Version:    0.7.0.1
 */