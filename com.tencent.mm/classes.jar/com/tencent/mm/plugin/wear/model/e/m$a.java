package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.bv.b;
import com.tencent.mm.f.b.g.a;
import com.tencent.mm.f.b.i;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cki;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

final class m$a
  extends d
{
  private cki qSC;
  
  public m$a(cki paramcki)
  {
    this.qSC = paramcki;
  }
  
  protected final void execute()
  {
    String str = q.oz(this.qSC.tXp);
    y.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
    Object localObject = q.R(str, false);
    y.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.qSC.sxO.toByteArray());
    com.tencent.mm.f.c.c localc = new com.tencent.mm.f.c.c(8000, 16000);
    localc.cG((String)localObject);
    localObject = new byte[320];
    int i = 0;
    for (;;)
    {
      try
      {
        int j = localByteArrayInputStream.read((byte[])localObject, 0, 320);
        i = j;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (i <= 0) {
        continue;
      }
      localc.a(new g.a((byte[])localObject, i), 0, false);
    }
    localc.uE();
    y.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
    q.Z(str, (int)this.qSC.tXK);
    m.Ti().run();
    y.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.qSC.tXp);
  }
  
  public final String getName()
  {
    return "SendVioceMsgTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m.a
 * JD-Core Version:    0.7.0.1
 */