package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

public final class a
  implements Application.ActivityLifecycleCallbacks, n, c.a
{
  private static a vzU;
  aw cqB;
  String mProcessName;
  volatile int mState;
  
  private a(String paramString)
  {
    AppMethodBeat.i(176886);
    this.mState = 0;
    String str = "fg_killed_state_".concat(String.valueOf(paramString));
    this.mProcessName = paramString;
    this.cqB = aw.aKU(str);
    ac.d("MicroMsg.ForegroundKilledDetect", "MMKV stg :%s", new Object[] { str });
    AppMethodBeat.o(176886);
  }
  
  public static a aph(String paramString)
  {
    AppMethodBeat.i(176887);
    if (vzU == null) {
      vzU = new a(paramString.replace(":", "_"));
    }
    paramString = vzU;
    AppMethodBeat.o(176887);
    return paramString;
  }
  
  private void setState(int paramInt)
  {
    this.mState |= paramInt;
  }
  
  final void KW(int paramInt)
  {
    this.mState &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final String baV()
  {
    AppMethodBeat.i(176893);
    ac.d("MicroMsg.ForegroundKilledDetect", "%s : crash was caught! DO NOT report this case", new Object[] { this.mProcessName });
    int i = this.mState;
    if (!dnY())
    {
      setState(4);
      dnZ();
    }
    ac.d("MicroMsg.ForegroundKilledDetect", "%s: setStateCrashCaught state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176893);
    return "";
  }
  
  final boolean dnW()
  {
    return (this.mState & 0x1) == 1;
  }
  
  final boolean dnX()
  {
    return (this.mState & 0x2) == 2;
  }
  
  final boolean dnY()
  {
    return (this.mState & 0x4) == 4;
  }
  
  final void dnZ()
  {
    AppMethodBeat.i(176892);
    this.cqB.encode("state", this.mState);
    AppMethodBeat.o(176892);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(176889);
    int i = this.mState;
    if (dnX())
    {
      KW(2);
      dnZ();
    }
    ac.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176889);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(176888);
    int i = this.mState;
    if (!dnX())
    {
      setState(2);
      dnZ();
    }
    ac.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176888);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(176891);
    int i = this.mState;
    if (dnW())
    {
      KW(1);
      dnZ();
    }
    ac.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176891);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(176890);
    int i = this.mState;
    if (!dnW())
    {
      setState(1);
      dnZ();
    }
    ac.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a
 * JD-Core Version:    0.7.0.1
 */