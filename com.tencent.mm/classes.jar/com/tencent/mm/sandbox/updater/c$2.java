package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.File;

final class c$2
  implements Runnable
{
  c$2(c paramc, bvk parambvk) {}
  
  public final void run()
  {
    AppMethodBeat.i(28857);
    ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.ykN;
    long l = System.currentTimeMillis();
    int i = i.g(ah.getContext(), this.ykM.amg(), this.ykM.dru(), c.c(this.ykM));
    ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - Long.valueOf(l).longValue()));
    if (i == 0)
    {
      ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
      localMessage.arg1 = 0;
      c.d(this.ykM).sendMessage(localMessage);
      AppMethodBeat.o(28857);
      return;
    }
    ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
    File localFile = new File(this.ykM.dru());
    if (localFile.exists()) {
      localFile.delete();
    }
    if (i == -1)
    {
      ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
      localMessage.arg1 = 3;
      c.d(this.ykM).sendMessage(localMessage);
      AppMethodBeat.o(28857);
      return;
    }
    if (i == -2)
    {
      ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
      localMessage.arg1 = 4;
      c.d(this.ykM).sendMessage(localMessage);
      AppMethodBeat.o(28857);
      return;
    }
    AppMethodBeat.o(28857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.2
 * JD-Core Version:    0.7.0.1
 */