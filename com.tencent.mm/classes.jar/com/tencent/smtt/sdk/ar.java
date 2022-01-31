package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.File;

class ar
  extends Thread
{
  ar(an paraman, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      File localFile1;
      if (this.a == null) {
        localFile1 = new File(TbsShareManager.getHostCorePathAppDefined());
      }
      for (;;)
      {
        File localFile2 = this.c.r(this.b);
        int i = Build.VERSION.SDK_INT;
        if ((i != 19) && (i < 21)) {
          j.a(localFile1, localFile2, new as(this));
        }
        j.a(localFile1, localFile2, new at(this));
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        return;
        if (TbsShareManager.isThirdPartyApp(this.b))
        {
          if ((TbsShareManager.c(this.b) != null) && (TbsShareManager.c(this.b).contains("decouple"))) {
            localFile1 = this.c.q(this.a);
          } else {
            localFile1 = this.c.r(this.a);
          }
        }
        else {
          localFile1 = this.c.r(this.a);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.ar
 * JD-Core Version:    0.7.0.1
 */