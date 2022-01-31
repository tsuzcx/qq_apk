package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class k$5
  implements g.a
{
  k$5(j.b paramb, b paramb1, Context paramContext, String paramString, bi parambi, boolean paramBoolean) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      if ((!bo.isNullOrNil(this.iaj.fgC)) && (this.zyr != null))
      {
        this.zyr.field_status = 199L;
        this.zyr.field_offset = this.zyr.field_totalLen;
        al.aUJ().a(this.zyr, new String[0]);
        aw.aaz();
        paramString = com.tencent.mm.model.c.YC().kB(this.zyr.field_msgInfoId);
        paramString.setStatus(3);
        aw.aaz();
        com.tencent.mm.model.c.YC().a(paramString.field_msgId, paramString);
      }
      new ak(Looper.getMainLooper()).post(new k.5.1(this));
    }
    AppMethodBeat.o(30579);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.5
 * JD-Core Version:    0.7.0.1
 */