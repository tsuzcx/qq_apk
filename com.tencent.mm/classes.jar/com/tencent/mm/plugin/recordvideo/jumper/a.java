package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static final a NIr;
  
  static
  {
    AppMethodBeat.i(101522);
    NIr = new a();
    AppMethodBeat.o(101522);
  }
  
  public static Intent a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(101520);
    if (paramInt == 0)
    {
      Boolean localBoolean;
      if ((com.tencent.mm.n.a.p(paramActivity, true)) || (com.tencent.mm.n.a.dm(paramActivity)) || (com.tencent.mm.n.a.dl(paramActivity)))
      {
        Log.i("MicroMsg.VideoCaptureJumper", "startStoryCapture, voip or multitalk running");
        localBoolean = Boolean.FALSE;
      }
      while (!localBoolean.booleanValue())
      {
        Log.i("MicroMsg.VideoCaptureJumper", "not get enough permission");
        AppMethodBeat.o(101520);
        return null;
        if (((paramActivity instanceof Activity)) && (!b.a(paramActivity, "android.permission.CAMERA", 16, "")))
        {
          Log.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkCamera");
          localBoolean = Boolean.FALSE;
        }
        else
        {
          Log.i("MicroMsg.VideoCaptureJumper", "startStoryCapture %s", new Object[] { Util.getStack().toString() });
          localBoolean = Boolean.TRUE;
        }
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
        Log.printErrStackTrace("MicroMsg.VideoCaptureJumper", paramActivity, "buildIntent failed!", new Object[0]);
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
    Log.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/recordvideo/jumper/VideoCaptureJumper", "jumpToCaptureViewForResult", "(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    l(paramContext, paramInt2, paramInt3);
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
    Log.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/recordvideo/jumper/VideoCaptureJumper", "jumpToEditViewForResult", "(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;II)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    l(paramContext, paramInt2, paramInt3);
    AppMethodBeat.o(168713);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279619);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 2);
    if (localIntent == null)
    {
      AppMethodBeat.o(279619);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", 2);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", -1);
    Log.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(121, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/recordvideo/jumper/VideoCaptureJumper", "jumpToEditViewForResult", "(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    l(paramContext, paramInt, -1);
    AppMethodBeat.o(279619);
    return true;
  }
  
  public static boolean b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279626);
    Intent localIntent = a((Activity)paramContext, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
    if (localIntent == null)
    {
      AppMethodBeat.o(279626);
      return false;
    }
    localIntent.putExtra("KEY_PARAMS_CONFIG", paramRecordConfigProvider);
    localIntent.putExtra("KEY_PARAMS_TO_WHERE", 0);
    localIntent.putExtra("KEY_PARAMS_EXIT_ANIM", paramInt3);
    localIntent.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 0);
    Log.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramRecordConfigProvider });
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/recordvideo/jumper/VideoCaptureJumper", "jumpToCaptureViewForResult", "(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    l(paramContext, paramInt2, paramInt3);
    AppMethodBeat.o(279626);
    return true;
  }
  
  public static void l(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101521);
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      ((Activity)paramContext).overridePendingTransition(paramInt1, -1);
    }
    AppMethodBeat.o(101521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.a
 * JD-Core Version:    0.7.0.1
 */