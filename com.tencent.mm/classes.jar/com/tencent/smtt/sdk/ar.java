package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class ar
  extends Handler
{
  ar(ao paramao, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(139272);
    QbSdk.setTBSInstallingStatus(true);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(139272);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
      paramMessage = (Object[])paramMessage.obj;
      ao.a(this.a, (Context)paramMessage[0], (String)paramMessage[1], ((Integer)paramMessage[2]).intValue());
      AppMethodBeat.o(139272);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
      paramMessage = (Object[])paramMessage.obj;
      ao.a(this.a, (Context)paramMessage[0], (Context)paramMessage[1], ((Integer)paramMessage[2]).intValue());
      AppMethodBeat.o(139272);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
      paramMessage = (Object[])paramMessage.obj;
      this.a.b((Context)paramMessage[0], (Bundle)paramMessage[1]);
      AppMethodBeat.o(139272);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      this.a.a((Context)arrayOfObject[0], (File)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
      QbSdk.setTBSInstallingStatus(false);
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ar
 * JD-Core Version:    0.7.0.1
 */