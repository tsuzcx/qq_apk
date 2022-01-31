package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

final class j$1
  implements g.a
{
  j$1(bi parambi, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, com.tencent.mm.at.e parame, Context paramContext) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(30532);
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
    if (paramd != null)
    {
      if (!paramd.field_exist_whencheck) {
        break label753;
      }
      ab.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramd });
      localObject1 = this.fkH;
      i = this.jWF;
      paramc = this.fwC;
      str1 = this.zyd;
      paramString = this.zye;
      str2 = this.iiy;
      j = this.fFh;
      str3 = o.ahC().J(((dd)localObject1).field_imgPath, true);
      localObject2 = new PString();
      localObject3 = new PInt();
      localObject4 = new PInt();
      ((PString)localObject2).value = "";
      localbi = new bi();
      localbi.setType(t.oG(paramc));
      localbi.kj(paramc);
      localbi.hL(1);
      localbi.setStatus(1);
      localbi.fQ(bf.py(localbi.field_talker));
      localbi.setContent(paramString);
      a.a.Ky().g(localbi);
      l3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
      if (l3 < 0L) {
        break label747;
      }
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      ab.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
      if (j != 1) {
        break label816;
      }
    }
    label816:
    for (long l1 = o.ahC().a(null, l3, true, localbi.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);; l1 = 0L)
    {
      long l2 = o.ahC().a(null, l3, false, localbi.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);
      localObject3 = br.F(paramString, "msg");
      paramInt = bo.getInt((String)((Map)localObject3).get(".msg.img.$length"), paramd.field_thumbimgLength);
      paramString = o.ahC().b(Long.valueOf(l2));
      paramString.gQ((int)l3);
      if (l2 > 0L)
      {
        localObject4 = o.ahC().a(((PString)localObject2).value, "th_", "", false);
        ab.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject4 });
        com.tencent.mm.vfs.e.C(str3, (String)localObject4);
        localbi.kk(((PString)localObject2).value);
        localbi.hW(((dd)localObject1).dGS);
        localbi.hX(((dd)localObject1).dGT);
        if (l1 > 0L)
        {
          paramString.lu(1);
          paramString.lr((int)l1);
          paramInt = bo.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), paramd.field_thumbimgLength);
        }
      }
      for (;;)
      {
        o.ahC().a(Long.valueOf(l2), paramString);
        if (j == 1) {
          paramString = o.ahC().b(Long.valueOf(l1));
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(l3, localbi);
          o.ahC().a(Long.valueOf(l1), paramString);
          localObject1 = com.tencent.mm.al.c.a("upimg", localbi.field_createTime, localbi.field_talker, localbi.field_msgId + "_" + l1 + "_" + j);
          localObject2 = new con();
          ((con)localObject2).woP = new bwc().aoF(str1);
          ((con)localObject2).woQ = new bwc().aoF(paramc);
          ((con)localObject2).nqW = localbi.getType();
          ((con)localObject2).woU = localbi.dns;
          ((con)localObject2).wDr = paramString.fDQ;
          ((con)localObject2).xXk = new bwc().aoF((String)localObject1);
          ((con)localObject2).xdn = j;
          paramd.field_filemd5 = str2;
          paramd.field_thumbimgLength = ((int)com.tencent.mm.vfs.e.avI(str3));
          paramd.field_fileLength = paramInt;
          paramString = new m(i, (con)localObject2, paramString, paramd, new j.2(l2, l3));
          com.tencent.mm.kernel.g.Rc().a(paramString, 0);
          for (;;)
          {
            AppMethodBeat.o(30532);
            return 0;
            label747:
            paramBoolean = false;
            break;
            label753:
            ab.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
            paramString = o.ahC().q(this.fFD.fDO, "th_", "");
            j.a(this.val$context, this.fFD, this.fkH, this.jWF, this.fwC, paramString);
          }
          l1 = l2;
        }
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.1
 * JD-Core Version:    0.7.0.1
 */