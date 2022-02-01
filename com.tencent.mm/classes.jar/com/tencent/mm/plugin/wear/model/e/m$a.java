package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.protobuf.ezp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

final class m$a
  extends d
{
  private ezp Iyw;
  
  public m$a(ezp paramezp)
  {
    this.Iyw = paramezp;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(30093);
    String str = s.Rh(this.Iyw.MRZ);
    Log.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
    Object localObject = s.Y(str, false);
    Log.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.Iyw.KKz.toByteArray());
    com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
    localc.hz((String)localObject);
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
    localc.abP();
    Log.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
    s.aB(str, (int)this.Iyw.NvN);
    o.bid().run();
    Log.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
    bg.aVF();
    com.tencent.mm.model.c.aST().bka(this.Iyw.MRZ);
    AppMethodBeat.o(30093);
  }
  
  public final String getName()
  {
    return "SendVioceMsgTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m.a
 * JD-Core Version:    0.7.0.1
 */