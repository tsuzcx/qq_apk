package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.concurrent.locks.ReentrantLock;

final class s$2
  implements Runnable
{
  s$2(s params, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(68460);
    if (this.uog != null)
    {
      s.b(this.Cxu).lock();
      if (this.Cxv)
      {
        if (i.fv(s.access$200())) {
          i.cZ(s.access$200(), true);
        }
        i.aYg(s.access$200());
        s.c(this.Cxu);
      }
      for (;;)
      {
        s.b(this.Cxu).unlock();
        try
        {
          Object localObject = System.currentTimeMillis();
          label100:
          long l;
          StringBuilder localStringBuilder;
          if (this.Cxv)
          {
            str = s.access$200();
            ad.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(this.Cxv) });
            l = bt.HI();
            localStringBuilder = new StringBuilder();
            if (!this.Cxv) {
              break label254;
            }
          }
          label254:
          for (String str = s.access$200();; str = s.access$400())
          {
            str = str + (String)localObject;
            localObject = this.uog;
            i.f(str, (byte[])localObject, localObject.length);
            ad.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
            AppMethodBeat.o(68460);
            return;
            if (i.fv(s.access$400())) {
              i.cZ(s.access$400(), true);
            }
            i.aYg(s.access$400());
            s.d(this.Cxu);
            break;
            str = s.access$400();
            break label100;
          }
          AppMethodBeat.o(68460);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s.2
 * JD-Core Version:    0.7.0.1
 */