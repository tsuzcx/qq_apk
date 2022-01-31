package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.k;
import com.tencent.mm.at.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab<T>
{
  private String zBH = "";
  
  private void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, bi parambi, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(30938);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.eds = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.edp = new ab.1(this, parambi, paramString4, paramHashSet, paramT, parama);
    if (!com.tencent.mm.al.f.afO().b(localg, -1)) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(30938);
  }
  
  private static boolean aN(bi parambi)
  {
    AppMethodBeat.i(30934);
    parambi = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
    if ((parambi.offset < parambi.fsd) || (parambi.fsd == 0))
    {
      AppMethodBeat.o(30934);
      return false;
    }
    AppMethodBeat.o(30934);
    return true;
  }
  
  private static boolean aO(bi parambi)
  {
    AppMethodBeat.i(30935);
    parambi = u.vr(parambi.field_imgPath);
    if ((parambi != null) && (parambi.status != 199))
    {
      AppMethodBeat.o(30935);
      return false;
    }
    AppMethodBeat.o(30935);
    return true;
  }
  
  public static boolean aP(bi parambi)
  {
    AppMethodBeat.i(30936);
    if ((!ad.arf(parambi.field_talker)) && (!ad.arf(bf.pu(parambi.field_content))))
    {
      AppMethodBeat.o(30936);
      return true;
    }
    if (parambi.bCn())
    {
      Object localObject = j.b.mY(parambi.field_content);
      if ((((j.b)localObject).type == 6) && (!bo.isNullOrNil(((j.b)localObject).fgC)))
      {
        localObject = l.d(parambi, ((j.b)localObject).cmN);
        if ((localObject != null) && ((!com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath)) || (com.tencent.mm.vfs.e.avI(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_totalLen)))
        {
          AppMethodBeat.o(30936);
          return false;
        }
      }
      else
      {
        if (((j.b)localObject).type == 19)
        {
          localObject = n.XS(((j.b)localObject).fhc).fjy.iterator();
          aca localaca;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localaca = (aca)((Iterator)localObject).next();
            str = n.c(localaca, parambi.field_msgId);
            if ((!bo.isNullOrNil(localaca.wTU)) && (!com.tencent.mm.vfs.e.cN(str)))
            {
              AppMethodBeat.o(30936);
              return false;
            }
            str = n.f(localaca, parambi.field_msgId);
          } while ((bo.isNullOrNil(localaca.fgD)) || (com.tencent.mm.vfs.e.cN(str)));
          AppMethodBeat.o(30936);
          return false;
        }
        if (((j.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.af.a)((j.b)localObject).R(com.tencent.mm.af.a.class);
          if ((localObject == null) || (bo.isNullOrNil(((com.tencent.mm.af.a)localObject).ffv)) || (bo.isNullOrNil(((com.tencent.mm.af.a)localObject).ffx)))
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(30936);
            return false;
          }
        }
      }
    }
    if ((parambi.dvX()) && (!aN(parambi)))
    {
      AppMethodBeat.o(30936);
      return false;
    }
    if (((parambi.byj()) || (parambi.byk())) && (!aO(parambi)))
    {
      AppMethodBeat.o(30936);
      return false;
    }
    AppMethodBeat.o(30936);
    return true;
  }
  
  public final void a(T paramT, Context paramContext, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(30937);
    Object localObject1 = parama.cmQ.field_msgId + " ";
    if (((String)localObject1).equals(this.zBH))
    {
      com.tencent.mm.ui.base.t.makeText(paramContext, paramContext.getString(2131299669), 0).show();
      AppMethodBeat.o(30937);
      return;
    }
    this.zBH = ((String)localObject1);
    if (parama.cmQ.bCn())
    {
      paramContext = j.b.mY(parama.cmQ.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!bo.isNullOrNil(paramContext.fgC)))
      {
        localObject1 = l.d(parama.cmQ, paramContext.cmN);
        if ((localObject1 != null) && ((!com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.e.avI(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).edp = new ab.4(this, (com.tencent.mm.pluginsdk.model.app.b)localObject1, parama, paramT);
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), parama.cmQ.field_talker, parama.cmQ.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.ewj;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.fgI;
          ((com.tencent.mm.i.g)localObject2).eds = paramContext.fgC;
          if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = l.Z(com.tencent.mm.model.c.YS(), paramContext.title, paramContext.fgx))
          {
            if (!com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject2, -1)) {
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(30937);
            return;
            aw.aaz();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = n.XS(paramContext.fhc);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).fjy != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).fjy.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aca)((Iterator)localObject1).next();
            String str1 = n.c((aca)localObject2, parama.cmQ.field_msgId);
            String str2;
            if ((!bo.isNullOrNil(((aca)localObject2).wTU)) && (!com.tencent.mm.vfs.e.cN(str1)))
            {
              str2 = n.h(((aca)localObject2).mBq, parama.cmQ.field_msgId, true);
              a(paramT, parama, ((aca)localObject2).wTU, ((aca)localObject2).wTR, ((aca)localObject2).fgI, str1, str2, parama.cmQ, paramContext);
            }
            str1 = n.f((aca)localObject2, parama.cmQ.field_msgId);
            if ((!bo.isNullOrNil(((aca)localObject2).fgD)) && (!com.tencent.mm.vfs.e.cN(str1)))
            {
              str2 = n.h(n.Ny(((aca)localObject2).mBq), parama.cmQ.field_msgId, true);
              a(paramT, parama, ((aca)localObject2).fgD, ((aca)localObject2).fgJ, ((aca)localObject2).fgI, str1, str2, parama.cmQ, paramContext);
            }
          }
        }
        if (!paramContext.isEmpty())
        {
          AppMethodBeat.o(30937);
          return;
        }
      }
    }
    int i;
    if (parama.cmQ.dvX())
    {
      paramContext = com.tencent.mm.at.o.ahC().gS(parama.cmQ.field_msgSvrId);
      if (parama.cmQ.field_isSend == 1) {
        if (paramContext.ahh())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.fsd) && (paramContext.fsd != 0)) {
            break label791;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.cmQ.field_msgId) });
          com.tencent.mm.at.o.ahD().a(paramContext.fDL, parama.cmQ.field_msgId, i, parama.cmQ, 2130838228, new ab.3(this, parama, paramT));
        }
      }
      label791:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label797;
        }
        AppMethodBeat.o(30937);
        return;
        i = 0;
        break;
        if (!paramContext.ahh())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.at.f.a(paramContext);
        if (!com.tencent.mm.vfs.e.cN(com.tencent.mm.at.o.ahC().q(((com.tencent.mm.at.e)localObject1).fDM, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label797:
    if ((parama.cmQ.byj()) || (parama.cmQ.byk()))
    {
      paramContext = u.vr(parama.cmQ.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new ab.2(this, parama, paramT);
        com.tencent.mm.modelvideo.o.alE().a((t.a)localObject1, Looper.getMainLooper());
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.cmQ.field_msgId), parama.cmQ.field_imgPath });
        if (paramContext.alR())
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "start complete online video");
          u.vy(parama.cmQ.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label969;
        }
        AppMethodBeat.o(30937);
        return;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "start complete offline video");
        u.vn(parama.cmQ.field_imgPath);
        break;
      }
    }
    label969:
    this.zBH = "";
    a(paramT, parama);
    AppMethodBeat.o(30937);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(30939);
    this.zBH = "";
    Object localObject = new cm();
    com.tencent.mm.pluginsdk.model.e.d((cm)localObject, parama.cmQ);
    if ((paramT instanceof MMFragment))
    {
      ((cm)localObject).cpR.fragment = ((MMFragment)paramT);
      ((cm)localObject).cpR.cpY = 43;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (((cm)localObject).cpS.ret == 0)
      {
        if (!parama.cmQ.bCn()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.fRu.b(parama.cmQ, k.k(parama.cmQ));
      }
    }
    for (;;)
    {
      if ((parama.cmQ.bCn()) || (parama.cmQ.dvV()))
      {
        paramT = v.oQ(parama.cmQ.field_msgSvrId);
        v.b localb = v.aae().z(paramT, true);
        localb.i("prePublishId", "msg_" + parama.cmQ.field_msgSvrId);
        localb.i("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.cmQ, parama.muU, parama.muT));
        localb.i("preChatName", parama.talker);
        localb.i("preMsgIndex", Integer.valueOf(0));
        localb.i("sendAppMsgScene", Integer.valueOf(1));
        ((i)com.tencent.mm.kernel.g.E(i.class)).a("adExtStr", localb, parama.cmQ);
        ((cm)localObject).cpR.cpW = paramT;
      }
      localObject = j.b.mY(bo.apU(parama.cmQ.field_content));
      long l;
      if ((localObject != null) && (((j.b)localObject).type == 5) && (((j.b)localObject).url != null))
      {
        l = bo.aox();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((j.b)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
        paramT = "";
      }
      try
      {
        localObject = URLEncoder.encode(((j.b)localObject).url, "UTF-8");
        paramT = (TT)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      h.qsU.e(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.muV != null) {
        parama.muV.bxj();
      }
      a.a(a.c.zvl, a.d.zvq, parama.cmQ, 0);
      AppMethodBeat.o(30939);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cm)localObject).cpR.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.fRu.D(parama.cmQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab
 * JD-Core Version:    0.7.0.1
 */