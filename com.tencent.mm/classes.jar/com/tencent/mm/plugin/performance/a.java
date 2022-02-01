package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public final class a
  implements Application.ActivityLifecycleCallbacks, n, c.a
{
  private static a wGe;
  ax cBy;
  String mProcessName;
  volatile int mState;
  
  private a(String paramString)
  {
    AppMethodBeat.i(176886);
    this.mState = 0;
    String str = "fg_killed_state_".concat(String.valueOf(paramString));
    this.mProcessName = paramString;
    this.cBy = ax.aQA(str);
    ad.d("MicroMsg.ForegroundKilledDetect", "MMKV stg :%s", new Object[] { str });
    AppMethodBeat.o(176886);
  }
  
  public static a aum(String paramString)
  {
    AppMethodBeat.i(176887);
    if (wGe == null) {
      wGe = new a(paramString.replace(":", "_"));
    }
    paramString = wGe;
    AppMethodBeat.o(176887);
    return paramString;
  }
  
  private void setState(int paramInt)
  {
    this.mState |= paramInt;
  }
  
  final void My(int paramInt)
  {
    this.mState &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final String bev()
  {
    AppMethodBeat.i(176893);
    ad.d("MicroMsg.ForegroundKilledDetect", "%s : crash was caught! DO NOT report this case", new Object[] { this.mProcessName });
    int i = this.mState;
    if (!dyu())
    {
      setState(4);
      dyv();
    }
    ad.d("MicroMsg.ForegroundKilledDetect", "%s: setStateCrashCaught state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176893);
    return "";
  }
  
  final boolean dys()
  {
    return (this.mState & 0x1) == 1;
  }
  
  final boolean dyt()
  {
    return (this.mState & 0x2) == 2;
  }
  
  final boolean dyu()
  {
    return (this.mState & 0x4) == 4;
  }
  
  final void dyv()
  {
    AppMethodBeat.i(176892);
    this.cBy.encode("state", this.mState);
    AppMethodBeat.o(176892);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(176889);
    int i = this.mState;
    if (dyt())
    {
      My(2);
      dyv();
    }
    ad.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176889);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(176888);
    int i = this.mState;
    if (!dyt())
    {
      setState(2);
      dyv();
    }
    ad.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176888);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(176891);
    int i = this.mState;
    if (dys())
    {
      My(1);
      dyv();
    }
    ad.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176891);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(176890);
    int i = this.mState;
    if (!dys())
    {
      setState(1);
      dyv();
    }
    ad.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a
 * JD-Core Version:    0.7.0.1
 */