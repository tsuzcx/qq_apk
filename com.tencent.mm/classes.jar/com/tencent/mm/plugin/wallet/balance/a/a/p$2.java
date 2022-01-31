package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.concurrent.locks.ReentrantLock;

final class p$2
  implements Runnable
{
  p$2(p paramp, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(45247);
    if (this.nyp != null)
    {
      p.b(this.tMC).lock();
      if (this.tMD)
      {
        if (e.cN(p.access$200())) {
          e.O(p.access$200(), true);
        }
        e.um(p.access$200());
        p.c(this.tMC);
      }
      for (;;)
      {
        p.b(this.tMC).unlock();
        try
        {
          Object localObject = System.currentTimeMillis();
          label100:
          long l;
          StringBuilder localStringBuilder;
          if (this.tMD)
          {
            str = p.access$200();
            ab.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(this.tMD) });
            l = bo.yB();
            localStringBuilder = new StringBuilder();
            if (!this.tMD) {
              break label254;
            }
          }
          label254:
          for (String str = p.access$200();; str = p.access$400())
          {
            str = str + (String)localObject;
            localObject = this.nyp;
            e.b(str, (byte[])localObject, localObject.length);
            ab.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bo.av(l)) });
            AppMethodBeat.o(45247);
            return;
            if (e.cN(p.access$400())) {
              e.O(p.access$400(), true);
            }
            e.um(p.access$400());
            p.d(this.tMC);
            break;
            str = p.access$400();
            break label100;
          }
          AppMethodBeat.o(45247);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.p.2
 * JD-Core Version:    0.7.0.1
 */