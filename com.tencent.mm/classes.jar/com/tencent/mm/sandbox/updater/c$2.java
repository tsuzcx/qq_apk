package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class c$2
  implements Runnable
{
  c$2(c paramc, bly parambly) {}
  
  public final void run()
  {
    y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.ucy;
    long l = System.currentTimeMillis();
    int i = i.g(ae.getContext(), this.ucx.SV(), this.ucx.cpF(), c.c(this.ucx));
    y.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - Long.valueOf(l).longValue()));
    if (i == 0)
    {
      y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
      localMessage.arg1 = 0;
      c.d(this.ucx).sendMessage(localMessage);
    }
    do
    {
      return;
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
      File localFile = new File(this.ucx.cpF());
      if (localFile.exists()) {
        localFile.delete();
      }
      if (i == -1)
      {
        y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
        localMessage.arg1 = 3;
        c.d(this.ucx).sendMessage(localMessage);
        return;
      }
    } while (i != -2);
    y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
    localMessage.arg1 = 4;
    c.d(this.ucx).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.2
 * JD-Core Version:    0.7.0.1
 */