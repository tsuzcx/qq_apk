package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;

public final class a
  implements Application.ActivityLifecycleCallbacks, o, ICrashReporter.ICrashReportExtraMessageGetter
{
  private static a ARU;
  MultiProcessMMKV cQe;
  String mProcessName;
  volatile int mState;
  
  private a(String paramString)
  {
    AppMethodBeat.i(176886);
    this.mState = 0;
    String str = "fg_killed_state_".concat(String.valueOf(paramString));
    this.mProcessName = paramString;
    this.cQe = MultiProcessMMKV.getSingleMMKV(str);
    Log.d("MicroMsg.ForegroundKilledDetect", "MMKV stg :%s", new Object[] { str });
    AppMethodBeat.o(176886);
  }
  
  public static a aJO(String paramString)
  {
    AppMethodBeat.i(176887);
    if (ARU == null) {
      ARU = new a(paramString.replace(":", "_"));
    }
    paramString = ARU;
    AppMethodBeat.o(176887);
    return paramString;
  }
  
  private void setState(int paramInt)
  {
    this.mState |= paramInt;
  }
  
  final void Uo(int paramInt)
  {
    this.mState &= (paramInt ^ 0xFFFFFFFF);
  }
  
  final boolean eBw()
  {
    return (this.mState & 0x1) == 1;
  }
  
  final boolean eBx()
  {
    return (this.mState & 0x2) == 2;
  }
  
  final boolean eBy()
  {
    return (this.mState & 0x4) == 4;
  }
  
  final void eBz()
  {
    AppMethodBeat.i(176892);
    this.cQe.encode("state", this.mState);
    AppMethodBeat.o(176892);
  }
  
  public final String getCrashReportExtraMessage()
  {
    AppMethodBeat.i(176893);
    Log.d("MicroMsg.ForegroundKilledDetect", "%s : crash was caught! DO NOT report this case", new Object[] { this.mProcessName });
    int i = this.mState;
    if (!eBy())
    {
      setState(4);
      eBz();
    }
    Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateCrashCaught state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176893);
    return "";
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(176889);
    int i = this.mState;
    if (eBx())
    {
      Uo(2);
      eBz();
    }
    Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176889);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(176888);
    int i = this.mState;
    if (!eBx())
    {
      setState(2);
      eBz();
    }
    Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176888);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(176891);
    int i = this.mState;
    if (eBw())
    {
      Uo(1);
      eBz();
    }
    Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppBackground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176891);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(176890);
    int i = this.mState;
    if (!eBw())
    {
      setState(1);
      eBz();
    }
    Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppForeground state = %s -> %s", new Object[] { this.mProcessName, Integer.toBinaryString(i), Integer.toBinaryString(this.mState) });
    AppMethodBeat.o(176890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a
 * JD-Core Version:    0.7.0.1
 */