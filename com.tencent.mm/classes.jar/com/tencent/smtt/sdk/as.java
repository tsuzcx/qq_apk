package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

class as
  extends Thread
{
  as(ao paramao, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    AppMethodBeat.i(139273);
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      File localFile1;
      if (this.a == null) {
        localFile1 = new File(TbsShareManager.getHostCorePathAppDefined());
      }
      for (;;)
      {
        File localFile2 = this.c.q(this.b);
        int i = Build.VERSION.SDK_INT;
        if ((i != 19) && (i < 21)) {
          k.a(localFile1, localFile2, new at(this));
        }
        k.a(localFile1, localFile2, new au(this));
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        AppMethodBeat.o(139273);
        return;
        if (TbsShareManager.isThirdPartyApp(this.b))
        {
          if ((TbsShareManager.c(this.b) != null) && (TbsShareManager.c(this.b).contains("decouple"))) {
            localFile1 = this.c.p(this.a);
          } else {
            localFile1 = this.c.q(this.a);
          }
        }
        else {
          localFile1 = this.c.q(this.a);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.as
 * JD-Core Version:    0.7.0.1
 */