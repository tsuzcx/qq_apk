package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.m;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

final class k$1
  implements f.a
{
  k$1(bi parambi, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, com.tencent.mm.as.e parame, Context paramContext) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    Object localObject1;
    int i;
    String str1;
    String str2;
    int j;
    String str3;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    bi localbi;
    long l3;
    if ((paramd != null) && (paramd.field_exist_whencheck))
    {
      y.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramd });
      localObject1 = this.dUy;
      i = this.nkj;
      paramc = this.egy;
      str1 = this.vjd;
      paramString = this.vje;
      str2 = this.grU;
      j = this.eoK;
      str3 = o.OJ().F(((cs)localObject1).field_imgPath, true);
      localObject2 = new PString();
      localObject3 = new PInt();
      localObject4 = new PInt();
      ((PString)localObject2).value = "";
      localbi = new bi();
      localbi.setType(s.hX(paramc));
      localbi.ec(paramc);
      localbi.fA(1);
      localbi.setStatus(1);
      localbi.bg(bd.iK(localbi.field_talker));
      localbi.setContent(paramString);
      a.a.yf().c(localbi);
      l3 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
      if (l3 >= 0L)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        y.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = " + l3);
        if (j != 1) {
          break label811;
        }
      }
    }
    label811:
    for (long l1 = o.OJ().a(null, l3, true, localbi.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);; l1 = 0L)
    {
      long l2 = o.OJ().a(null, l3, false, localbi.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);
      localObject3 = bn.s(paramString, "msg");
      paramInt = bk.getInt((String)((Map)localObject3).get(".msg.img.$length"), paramd.field_thumbimgLength);
      paramString = o.OJ().b(Long.valueOf(l2));
      paramString.bV((int)l3);
      if (l2 > 0L)
      {
        localObject4 = o.OJ().b(((PString)localObject2).value, "th_", "", false);
        y.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject4 });
        com.tencent.mm.vfs.e.r(str3, (String)localObject4);
        localbi.ed(((PString)localObject2).value);
        localbi.fK(((cs)localObject1).cQG);
        localbi.fL(((cs)localObject1).cQH);
        if (l1 > 0L)
        {
          paramString.iG(1);
          paramString.iD((int)l1);
          paramInt = bk.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), paramd.field_thumbimgLength);
        }
      }
      for (;;)
      {
        o.OJ().a(Long.valueOf(l2), paramString);
        if (j == 1) {
          paramString = o.OJ().b(Long.valueOf(l1));
        }
        for (;;)
        {
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l3, localbi);
          o.OJ().a(Long.valueOf(l1), paramString);
          localObject1 = com.tencent.mm.ak.c.a("upimg", localbi.field_createTime, localbi.field_talker, localbi.field_msgId + "_" + l1 + "_" + j);
          localObject2 = new cbh();
          ((cbh)localObject2).svF = new bml().YI(str1);
          ((cbh)localObject2).svG = new bml().YI(paramc);
          ((cbh)localObject2).kSW = localbi.getType();
          ((cbh)localObject2).svK = localbi.czr;
          ((cbh)localObject2).sGT = paramString.enu;
          ((cbh)localObject2).tQp = new bml().YI((String)localObject1);
          ((cbh)localObject2).tfc = j;
          paramd.field_filemd5 = str2;
          paramd.field_thumbimgLength = ((int)com.tencent.mm.vfs.e.aeQ(str3));
          paramd.field_fileLength = paramInt;
          paramString = new m(i, (cbh)localObject2, paramString, paramd, new k.2(l2, l3));
          com.tencent.mm.kernel.g.Dk().a(paramString, 0);
          for (;;)
          {
            return 0;
            paramBoolean = false;
            break;
            y.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
            paramString = o.OJ().o(this.epf.ens, "th_", "");
            k.a(this.val$context, this.epf, this.dUy, this.nkj, this.egy, paramString);
          }
          l1 = l2;
        }
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.1
 * JD-Core Version:    0.7.0.1
 */