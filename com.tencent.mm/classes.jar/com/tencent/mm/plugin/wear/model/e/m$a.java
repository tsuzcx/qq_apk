package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.bv.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.be;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

final class m$a
  extends d
{
  private cxv uHJ;
  
  public m$a(cxv paramcxv)
  {
    this.uHJ = paramcxv;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(26411);
    String str = s.vM(this.uHJ.xlH);
    ab.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
    Object localObject = s.V(str, false);
    ab.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.uHJ.wrr.toByteArray());
    com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
    localc.eN((String)localObject);
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
    localc.Fb();
    ab.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
    s.ah(str, (int)this.uHJ.yfa);
    o.amu().run();
    ab.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
    aw.aaz();
    com.tencent.mm.model.c.YF().arJ(this.uHJ.xlH);
    AppMethodBeat.o(26411);
  }
  
  public final String getName()
  {
    return "SendVioceMsgTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m.a
 * JD-Core Version:    0.7.0.1
 */