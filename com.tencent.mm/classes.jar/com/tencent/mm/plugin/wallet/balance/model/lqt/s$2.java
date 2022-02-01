package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.concurrent.locks.ReentrantLock;

final class s$2
  implements Runnable
{
  s$2(s params, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(68460);
    if (this.tpJ != null)
    {
      s.b(this.AXl).lock();
      if (this.AXm)
      {
        if (i.eA(s.access$200())) {
          i.cU(s.access$200(), true);
        }
        i.aSh(s.access$200());
        s.c(this.AXl);
      }
      for (;;)
      {
        s.b(this.AXl).unlock();
        try
        {
          Object localObject = System.currentTimeMillis();
          label100:
          long l;
          StringBuilder localStringBuilder;
          if (this.AXm)
          {
            str = s.access$200();
            ac.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(this.AXm) });
            l = bs.Gn();
            localStringBuilder = new StringBuilder();
            if (!this.AXm) {
              break label254;
            }
          }
          label254:
          for (String str = s.access$200();; str = s.access$400())
          {
            str = str + (String)localObject;
            localObject = this.tpJ;
            i.f(str, (byte[])localObject, localObject.length);
            ac.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
            AppMethodBeat.o(68460);
            return;
            if (i.eA(s.access$400())) {
              i.cU(s.access$400(), true);
            }
            i.aSh(s.access$400());
            s.d(this.AXl);
            break;
            str = s.access$400();
            break label100;
          }
          AppMethodBeat.o(68460);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s.2
 * JD-Core Version:    0.7.0.1
 */