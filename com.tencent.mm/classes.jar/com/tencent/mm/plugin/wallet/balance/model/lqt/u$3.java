package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.concurrent.locks.ReentrantLock;

final class u$3
  implements Runnable
{
  u$3(u paramu, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(213850);
    if (this.xRB != null)
    {
      u.b(this.HtQ).lock();
      if (this.HtR)
      {
        if (s.YS(u.access$200())) {
          s.dy(u.access$200(), true);
        }
        s.boN(u.access$200());
        u.c(this.HtQ);
      }
      for (;;)
      {
        u.b(this.HtQ).unlock();
        try
        {
          Object localObject = System.currentTimeMillis();
          label100:
          long l;
          StringBuilder localStringBuilder;
          if (this.HtR)
          {
            str = u.access$200();
            Log.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(this.HtR) });
            l = Util.currentTicks();
            localStringBuilder = new StringBuilder();
            if (!this.HtR) {
              break label254;
            }
          }
          label254:
          for (String str = u.access$200();; str = u.access$400())
          {
            str = str + (String)localObject;
            localObject = this.xRB;
            s.f(str, (byte[])localObject, localObject.length);
            Log.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            AppMethodBeat.o(213850);
            return;
            if (s.YS(u.access$400())) {
              s.dy(u.access$400(), true);
            }
            s.boN(u.access$400());
            u.d(this.HtQ);
            break;
            str = u.access$400();
            break label100;
          }
          AppMethodBeat.o(213850);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u.3
 * JD-Core Version:    0.7.0.1
 */