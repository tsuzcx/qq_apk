package com.tencent.mm.ui.chatting;

import android.os.Looper;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

final class ae$1
  implements f.a
{
  ae$1(ae paramae, bi parambi, String paramString, HashSet paramHashSet, Object paramObject, a parama) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0)) {
      y.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(this.dUy.field_msgId), paramString, this.dlh });
    }
    for (int i = 1;; i = 0)
    {
      int j;
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
        long l = this.dUy.field_msgId;
        paramc = this.dlh;
        if (paramd != null) {
          break label154;
        }
        i = 0;
        y.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramString, paramc, Integer.valueOf(paramInt), Integer.valueOf(i) });
        j = 1;
      }
      if (j == 0) {}
      label154:
      do
      {
        return 0;
        i = paramd.field_retCode;
        break;
        this.vmk.remove(paramString);
      } while (!this.vmk.isEmpty());
      new ah(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          ae.1.this.vmn.a(ae.1.this.vml, ae.1.this.vmm);
        }
      });
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ae.1
 * JD-Core Version:    0.7.0.1
 */