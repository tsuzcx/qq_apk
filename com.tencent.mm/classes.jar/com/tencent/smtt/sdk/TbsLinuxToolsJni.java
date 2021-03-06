package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static boolean a = false;
  private static boolean b = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    AppMethodBeat.i(54093);
    a(paramContext);
    AppMethodBeat.o(54093);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void a(Context paramContext)
  {
    AppMethodBeat.i(54094);
    label290:
    for (;;)
    {
      try
      {
        TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
        if (b) {
          return;
        }
        b = true;
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            continue;
          }
          localObject1 = TbsShareManager.a();
          if (localObject1 != null) {
            break label290;
          }
          localObject1 = TbsShareManager.c(paramContext);
          localObject1 = new File((String)localObject1);
          if (localObject1 != null)
          {
            Object localObject2 = localObject1;
            if (!new File(((File)localObject1).getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists())
            {
              localObject2 = localObject1;
              if (!TbsShareManager.isThirdPartyApp(paramContext)) {
                localObject2 = q.a().q(paramContext);
              }
            }
            if (localObject2 != null)
            {
              TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + ((File)localObject2).getAbsolutePath());
              System.load(((File)localObject2).getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
              a = true;
            }
          }
          ChmodInner("/checkChmodeExists", "700");
        }
        finally
        {
          Object localObject1;
          a = false;
          TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + paramContext.getMessage() + " ## " + paramContext.getCause());
          continue;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(54094);
      }
      localObject1 = q.a().r(paramContext);
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54092);
    if (!a)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      AppMethodBeat.o(54092);
      return -1;
    }
    int i = ChmodInner(paramString1, paramString2);
    AppMethodBeat.o(54092);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLinuxToolsJni
 * JD-Core Version:    0.7.0.1
 */