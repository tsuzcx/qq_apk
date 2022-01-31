package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class c$1
  extends ah
{
  c$1(c paramc) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((1 == paramMessage.what) && (!c.a(this.ucx)))
    {
      new File(this.ucx.SV()).delete();
      if (paramMessage.arg1 != 0) {
        break label79;
      }
      y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
      c.b(this.ucx).b(200, 0, (bly)paramMessage.obj);
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      label79:
      if (paramMessage.arg1 == 3) {
        c.b(this.ucx).b(3, -1, (bly)paramMessage.obj);
      } else if (paramMessage.arg1 == 4) {
        c.b(this.ucx).b(4, -1, (bly)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.1
 * JD-Core Version:    0.7.0.1
 */