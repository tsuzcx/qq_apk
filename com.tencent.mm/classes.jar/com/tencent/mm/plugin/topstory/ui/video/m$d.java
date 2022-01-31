package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.cky;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class m$d
  implements g.a
{
  private m$d(m paramm) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(1750);
    if ((paramc != null) && (paramc.field_toltalLength > 0) && (this.tjs.tjq.containsKey(paramString)))
    {
      paramd = (cky)this.tjs.tjq.get(paramString);
      paramd.xVt = paramc.field_finishedLength;
      paramd.xVu = m.ac(paramc.field_finishedLength, paramc.field_toltalLength);
      paramd.xVi = paramc.field_toltalLength;
      this.tjs.tjq.put(paramString, paramd);
    }
    AppMethodBeat.o(1750);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.d
 * JD-Core Version:    0.7.0.1
 */