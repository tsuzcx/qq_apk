package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

final class q$d$2
  implements g.a
{
  q$d$2(q.d paramd, aca paramaca, String paramString) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(135737);
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0)) {
      ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { this.mxT.mBq, paramString, this.fEQ });
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
        paramc = this.mxT.mBq;
        str = this.fEQ;
        if (paramd != null) {
          break label221;
        }
      }
      label221:
      for (i = 0;; i = paramd.field_retCode)
      {
        ab.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramc, paramString, str, Integer.valueOf(paramInt), Integer.valueOf(i) });
        j = 1;
        if (j != 0)
        {
          paramString = ((a)g.G(a.class)).getRecordMsgCDNStorage().XR(paramString);
          paramString.field_status = 0;
          ((a)g.G(a.class)).getRecordMsgCDNStorage().a(paramString);
          ((a)g.G(a.class)).getRecordMsgCDNService().run();
        }
        AppMethodBeat.o(135737);
        return 0;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.d.2
 * JD-Core Version:    0.7.0.1
 */