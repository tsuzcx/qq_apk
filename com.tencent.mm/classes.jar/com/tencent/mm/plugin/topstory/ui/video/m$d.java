package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.protocal.c.byh;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class m$d
  implements f.a
{
  private m$d(m paramm) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if ((paramc != null) && (paramc.field_toltalLength > 0) && (this.pFV.pFS.containsKey(paramString)))
    {
      paramd = (byh)this.pFV.pFS.get(paramString);
      paramd.tOL = paramc.field_finishedLength;
      paramd.tOM = m.N(paramc.field_finishedLength, paramc.field_toltalLength);
      paramd.tOF = paramc.field_toltalLength;
      this.pFV.pFS.put(paramString, paramd);
    }
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