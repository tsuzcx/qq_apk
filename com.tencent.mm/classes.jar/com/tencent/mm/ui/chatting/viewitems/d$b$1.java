package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.io.ByteArrayOutputStream;

final class d$b$1
  implements f.a
{
  d$b$1(a parama, Intent paramIntent, bi parambi, b paramb) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    boolean bool1;
    if (paramc != null)
    {
      bool1 = true;
      if (paramd == null) {
        break label104;
      }
    }
    label104:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (paramd != null)
      {
        if (!paramd.field_exist_whencheck) {
          break label110;
        }
        this.vBl.startActivity(this.val$intent);
      }
      return 0;
      bool1 = false;
      break;
    }
    label110:
    if ((this.dUy.cvx()) || ((this.vjs != null) && (d.b.e(this.dUy, this.vjs.field_fileFullPath))))
    {
      y.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
      h.a(this.vBl.vtz.getContext(), this.vBl.vtz.getContext().getString(R.l.file_fail_or_clean), this.vBl.vtz.getContext().getString(R.l.app_tip), new d.b.1.1(this));
      return 0;
    }
    h.b(this.vBl.vtz.getContext(), this.vBl.vtz.getMMResources().getString(R.l.contain_undownload_msg), "", true);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.b.1
 * JD-Core Version:    0.7.0.1
 */