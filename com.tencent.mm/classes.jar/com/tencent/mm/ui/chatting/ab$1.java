package com.tencent.mm.ui.chatting;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

final class ab$1
  implements g.a
{
  ab$1(ab paramab, bi parambi, String paramString, HashSet paramHashSet, Object paramObject, a parama) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(30926);
    int j = 0;
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (paramd != null)
      {
        i = j;
        if (paramd.field_retCode == 0)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(this.fkH.field_msgId), paramString, this.val$path });
          i = 1;
        }
      }
    }
    long l;
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
      l = this.fkH.field_msgId;
      paramc = this.val$path;
      if (paramd != null) {
        break label181;
      }
    }
    label181:
    for (i = 0;; i = paramd.field_retCode)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramString, paramc, Integer.valueOf(paramInt), Integer.valueOf(i) });
      j = 1;
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(30926);
      return 0;
    }
    this.zBI.remove(paramString);
    if (this.zBI.isEmpty()) {
      new ak(Looper.getMainLooper()).post(new ab.1.1(this));
    }
    AppMethodBeat.o(30926);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab.1
 * JD-Core Version:    0.7.0.1
 */