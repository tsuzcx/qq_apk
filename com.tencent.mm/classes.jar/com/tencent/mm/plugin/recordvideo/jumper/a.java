package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static final a qbG;
  
  static
  {
    AppMethodBeat.i(141881);
    qbG = new a();
    AppMethodBeat.o(141881);
  }
  
  public static void U(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(141880);
    if (paramInt != -1) {
      ((Activity)paramContext).overridePendingTransition(2131034259, -1);
    }
    AppMethodBeat.o(141880);
  }
  
  public static Intent a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(141879);
    if (paramInt == 0)
    {
      Boolean localBoolean;
      if ((com.tencent.mm.r.a.bN(paramActivity)) || (com.tencent.mm.r.a.bO(paramActivity)) || (com.tencent.mm.r.a.bM(paramActivity)))
      {
        ab.i("MicroMsg.VideoCaptureJumper", "startStoryCapture, voip or multitalk running");
        localBoolean = Boolean.FALSE;
      }
      while (!localBoolean.booleanValue())
      {
        ab.i("MicroMsg.VideoCaptureJumper", "not get enough permission");
        AppMethodBeat.o(141879);
        return null;
        if ((paramActivity instanceof Activity))
        {
          if (!b.a(paramActivity, "android.permission.CAMERA", 24, "", ""))
          {
            ab.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkCamera");
            localBoolean = Boolean.FALSE;
            continue;
          }
          if (!b.a(paramActivity, "android.permission.RECORD_AUDIO", 24, "", ""))
          {
            ab.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkMicroPhone");
            localBoolean = Boolean.FALSE;
            continue;
          }
        }
        ab.i("MicroMsg.VideoCaptureJumper", "startStoryCapture %s", new Object[] { bo.dtY().toString() });
        localBoolean = Boolean.TRUE;
      }
    }
    try
    {
      paramActivity = new Intent(paramActivity, Class.forName(paramString));
      AppMethodBeat.o(141879);
      return paramActivity;
    }
    catch (ClassNotFoundException paramActivity)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VideoCaptureJumper", paramActivity, "buildIntent failed!", new Object[0]);
        paramActivity = null;
      }
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(141877);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
    if (localIntent == null)
    {
      AppMethodBeat.o(141877);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", 2131034260);
    ab.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    U(paramContext, 2131034260);
    AppMethodBeat.o(141877);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt1, RecordConfigProvider paramRecordConfigProvider, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141876);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", paramInt2);
    if (localIntent == null)
    {
      AppMethodBeat.o(141876);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", paramInt2);
    localIntent.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", paramInt3);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", -1);
    ab.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt1);
    U(paramContext, -1);
    AppMethodBeat.o(141876);
    return true;
  }
  
  public static boolean b(Context paramContext, int paramInt, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(141878);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
    if (localIntent == null)
    {
      AppMethodBeat.o(141878);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", 2131034260);
    localIntent.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 0);
    ab.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    U(paramContext, 2131034260);
    AppMethodBeat.o(141878);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.a
 * JD-Core Version:    0.7.0.1
 */