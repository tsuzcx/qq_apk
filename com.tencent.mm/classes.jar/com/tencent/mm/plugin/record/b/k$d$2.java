package com.tencent.mm.plugin.record.b;

import com.tencent.mm.j.c;
import com.tencent.mm.j.f.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class k$d$2
  implements f.a
{
  k$d$2(k.d paramd, xv paramxv, String paramString) {}
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0)) {
      y.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { this.kdj.kgC, paramString, this.eot });
    }
    for (int i = 1;; i = 0)
    {
      int j;
      String str;
      if (paramInt == 0)
      {
        j = i;
        if (paramd != null)
        {
          j = i;
          if (paramd.field_retCode == 0) {}
        }
      }
      else
      {
        paramc = this.kdj.kgC;
        str = this.eot;
        if (paramd != null) {
          break label179;
        }
      }
      label179:
      for (i = 0;; i = paramd.field_retCode)
      {
        y.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramc, paramString, str, Integer.valueOf(paramInt), Integer.valueOf(i) });
        j = 1;
        if (j != 0)
        {
          paramString = n.getRecordMsgCDNStorage().LG(paramString);
          paramString.field_status = 0;
          n.getRecordMsgCDNStorage().a(paramString);
          n.bvB().run();
        }
        return 0;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.d.2
 * JD-Core Version:    0.7.0.1
 */