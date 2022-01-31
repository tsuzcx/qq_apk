package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class i$1
  implements Runnable
{
  i$1(i parami, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.las != null)
    {
      if (!this.qfB) {
        break label182;
      }
      if (e.bK(i.access$000())) {
        e.K(i.access$000(), true);
      }
      e.nb(i.access$000());
      i.a(this.qfC);
    }
    try
    {
      Object localObject = System.currentTimeMillis();
      label75:
      long l;
      StringBuilder localStringBuilder;
      if (this.qfB)
      {
        str = i.access$000();
        y.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(this.qfB) });
        l = bk.UZ();
        localStringBuilder = new StringBuilder();
        if (!this.qfB) {
          break label224;
        }
      }
      label182:
      label224:
      for (String str = i.access$000();; str = i.BG())
      {
        str = str + (String)localObject;
        localObject = this.las;
        e.b(str, (byte[])localObject, localObject.length);
        y.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
        return;
        if (e.bK(i.BG())) {
          e.K(i.BG(), true);
        }
        e.nb(i.BG());
        i.b(this.qfC);
        break;
        str = i.BG();
        break label75;
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.i.1
 * JD-Core Version:    0.7.0.1
 */