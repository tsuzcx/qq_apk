package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.esz;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class m$d
  implements g.a
{
  private m$d(m paramm) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(126115);
    if ((paramc != null) && (paramc.field_toltalLength > 0L) && (this.Nap.Nan.containsKey(paramString)))
    {
      paramd = (esz)this.Nap.Nan.get(paramString);
      paramd.Uvp = paramc.field_finishedLength;
      paramd.Uvq = m.aJ(paramc.field_finishedLength, paramc.field_toltalLength);
      paramd.Uvb = paramc.field_toltalLength;
      this.Nap.Nan.put(paramString, paramd);
    }
    AppMethodBeat.o(126115);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.d
 * JD-Core Version:    0.7.0.1
 */