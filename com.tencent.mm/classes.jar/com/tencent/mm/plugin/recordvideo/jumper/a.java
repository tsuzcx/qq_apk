package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static final a xyI;
  
  static
  {
    AppMethodBeat.i(101522);
    xyI = new a();
    AppMethodBeat.o(101522);
  }
  
  private static Intent a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(101520);
    if (paramInt == 0)
    {
      Boolean localBoolean;
      if ((com.tencent.mm.s.a.n(paramActivity, true)) || (com.tencent.mm.s.a.cf(paramActivity)) || (com.tencent.mm.s.a.cd(paramActivity)))
      {
        ad.i("MicroMsg.VideoCaptureJumper", "startStoryCapture, voip or multitalk running");
        localBoolean = Boolean.FALSE;
      }
      while (!localBoolean.booleanValue())
      {
        ad.i("MicroMsg.VideoCaptureJumper", "not get enough permission");
        AppMethodBeat.o(101520);
        return null;
        if ((paramActivity instanceof Activity))
        {
          if (!b.a(paramActivity, "android.permission.CAMERA", 16, "", ""))
          {
            ad.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkCamera");
            localBoolean = Boolean.FALSE;
            continue;
          }
          if (!b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "", ""))
          {
            ad.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkMicroPhone");
            localBoolean = Boolean.FALSE;
            continue;
          }
        }
        ad.i("MicroMsg.VideoCaptureJumper", "startStoryCapture %s", new Object[] { bt.flS().toString() });
        localBoolean = Boolean.TRUE;
      }
    }
    try
    {
      paramActivity = new Intent(paramActivity, Class.forName(paramString));
      AppMethodBeat.o(101520);
      return paramActivity;
    }
    catch (ClassNotFoundException paramActivity)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VideoCaptureJumper", paramActivity, "buildIntent failed!", new Object[0]);
        paramActivity = null;
      }
    }
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(101518);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
    if (localIntent == null)
    {
      AppMethodBeat.o(101518);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", 0);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", paramInt3);
    ad.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt1);
    g(paramContext, paramInt2, paramInt3);
    AppMethodBeat.o(101518);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, RecordConfigProvider paramRecordConfigProvider, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(168713);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", paramInt4);
    if (localIntent == null)
    {
      AppMethodBeat.o(168713);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", paramInt4);
    localIntent.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", paramInt5);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", paramInt3);
    ad.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt1);
    g(paramContext, paramInt2, paramInt3);
    AppMethodBeat.o(168713);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(101519);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
    if (localIntent == null)
    {
      AppMethodBeat.o(101519);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", 0);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", 2130772138);
    localIntent.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 0);
    ad.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    g(paramContext, 2130772137, 2130772138);
    AppMethodBeat.o(101519);
    return true;
  }
  
  public static boolean a(Context paramContext, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(101517);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 2);
    if (localIntent == null)
    {
      AppMethodBeat.o(101517);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", 2);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", -1);
    ad.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
    ((Activity)paramContext).startActivityForResult(localIntent, 121);
    g(paramContext, 2130772137, -1);
    AppMethodBeat.o(101517);
    return true;
  }
  
  private static void g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101521);
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      ((Activity)paramContext).overridePendingTransition(paramInt1, -1);
    }
    AppMethodBeat.o(101521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.a
 * JD-Core Version:    0.7.0.1
 */