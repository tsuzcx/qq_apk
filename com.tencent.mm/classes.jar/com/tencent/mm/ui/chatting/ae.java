package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.x;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae<T>
{
  public String vmj = "";
  
  private void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, bi parambi, HashSet<String> paramHashSet)
  {
    y.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.field_fileType = 19;
    localf.field_authKey = paramString3;
    localf.field_aesKey = paramString2;
    localf.dlQ = paramString1;
    localf.field_fullpath = paramString4;
    localf.field_mediaId = paramString5;
    localf.dlP = new ae.1(this, parambi, paramString4, paramHashSet, paramT, parama);
    if (!com.tencent.mm.ak.f.Nd().b(localf, -1)) {
      y.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
  }
  
  public static boolean aF(bi parambi)
  {
    if ((!ad.aaU(parambi.field_talker)) && (!ad.aaU(bd.iI(parambi.field_content)))) {
      return true;
    }
    Object localObject;
    if (parambi.aVK())
    {
      localObject = g.a.gp(parambi.field_content);
      if ((((g.a)localObject).type == 6) && (!bk.bl(((g.a)localObject).dQB)))
      {
        localObject = l.d(parambi, ((g.a)localObject).bFE);
        if ((localObject != null) && ((!com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath)) || (com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_totalLen))) {
          return false;
        }
      }
      else if (((g.a)localObject).type == 19)
      {
        localObject = com.tencent.mm.plugin.record.b.h.LH(((g.a)localObject).dRd).dTx.iterator();
        while (((Iterator)localObject).hasNext())
        {
          xv localxv = (xv)((Iterator)localObject).next();
          String str = com.tencent.mm.plugin.record.b.h.c(localxv, parambi.field_msgId);
          if ((!bk.bl(localxv.sVY)) && (!com.tencent.mm.vfs.e.bK(str))) {
            return false;
          }
          str = com.tencent.mm.plugin.record.b.h.f(localxv, parambi.field_msgId);
          if ((!bk.bl(localxv.dQC)) && (!com.tencent.mm.vfs.e.bK(str))) {
            return false;
          }
        }
      }
    }
    int i;
    if (parambi.ctB())
    {
      localObject = com.tencent.mm.as.o.OJ().bX(parambi.field_msgSvrId);
      if ((((com.tencent.mm.as.e)localObject).offset < ((com.tencent.mm.as.e)localObject).ebK) || (((com.tencent.mm.as.e)localObject).ebK == 0)) {}
      for (i = 0; i == 0; i = 1) {
        return false;
      }
    }
    if ((parambi.aRQ()) || (parambi.aRR()))
    {
      parambi = com.tencent.mm.modelvideo.u.oe(parambi.field_imgPath);
      if ((parambi != null) && (parambi.status != 199)) {}
      for (i = 0; i == 0; i = 1) {
        return false;
      }
    }
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    Object localObject1 = parama.bFH.field_msgId + " ";
    if (((String)localObject1).equals(this.vmj)) {
      com.tencent.mm.ui.base.s.makeText(paramContext, paramContext.getString(R.l.fav_doing_error_toast), 0).show();
    }
    label909:
    label913:
    label915:
    label937:
    label941:
    for (;;)
    {
      return;
      this.vmj = ((String)localObject1);
      if (parama.bFH.aVK())
      {
        paramContext = g.a.gp(parama.bFH.field_content);
        Object localObject2;
        if ((paramContext.type == 6) && (!bk.bl(paramContext.dQB)))
        {
          localObject1 = l.d(parama.bFH, paramContext.bFE);
          if ((localObject1 != null) && ((!com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen)))
          {
            localObject2 = new com.tencent.mm.j.f();
            ((com.tencent.mm.j.f)localObject2).dlP = new f.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.j.c paramAnonymousc, com.tencent.mm.j.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
                {
                  this.vjs.field_offset = paramAnonymousc.field_finishedLength;
                  ap.avh().c(this.vjs, new String[0]);
                }
                if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
                {
                  this.vjs.field_status = 199L;
                  this.vjs.field_offset = this.vjs.field_totalLen;
                  ap.avh().c(this.vjs, new String[0]);
                  parama.bFH.setStatus(3);
                  au.Hx();
                  com.tencent.mm.model.c.Fy().a(parama.bFH.field_msgId, parama.bFH);
                  new ah(Looper.getMainLooper()).post(new ae.4.1(this));
                }
                return 0;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.j.f)localObject2).field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), parama.bFH.field_talker, parama.bFH.field_msgId);
            ((com.tencent.mm.j.f)localObject2).field_aesKey = paramContext.dQR;
            ((com.tencent.mm.j.f)localObject2).field_fileType = 19;
            ((com.tencent.mm.j.f)localObject2).field_authKey = paramContext.dQH;
            ((com.tencent.mm.j.f)localObject2).dlQ = paramContext.dQB;
            if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath))) {}
            for (((com.tencent.mm.j.f)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath; !com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject2, -1); ((com.tencent.mm.j.f)localObject2).field_fullpath = l.aj(com.tencent.mm.model.c.FO(), paramContext.title, paramContext.dQw))
            {
              y.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
              return;
              au.Hx();
            }
          }
        }
        else if (paramContext.type == 19)
        {
          localObject1 = com.tencent.mm.plugin.record.b.h.LH(paramContext.dRd);
          paramContext = new HashSet();
          if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).dTx != null))
          {
            localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).dTx.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (xv)((Iterator)localObject1).next();
              String str1 = com.tencent.mm.plugin.record.b.h.c((xv)localObject2, parama.bFH.field_msgId);
              String str2;
              if ((!bk.bl(((xv)localObject2).sVY)) && (!com.tencent.mm.vfs.e.bK(str1)))
              {
                str2 = com.tencent.mm.plugin.record.b.h.h(((xv)localObject2).kgC, parama.bFH.field_msgId, true);
                a(paramT, parama, ((xv)localObject2).sVY, ((xv)localObject2).sVV, ((xv)localObject2).dQH, str1, str2, parama.bFH, paramContext);
              }
              str1 = com.tencent.mm.plugin.record.b.h.f((xv)localObject2, parama.bFH.field_msgId);
              if ((!bk.bl(((xv)localObject2).dQC)) && (!com.tencent.mm.vfs.e.bK(str1)))
              {
                str2 = com.tencent.mm.plugin.record.b.h.h(com.tencent.mm.plugin.record.b.h.Cw(((xv)localObject2).kgC), parama.bFH.field_msgId, true);
                a(paramT, parama, ((xv)localObject2).dQC, ((xv)localObject2).dQI, ((xv)localObject2).dQH, str1, str2, parama.bFH, paramContext);
              }
            }
          }
          if (!paramContext.isEmpty()) {
            continue;
          }
        }
      }
      if (parama.bFH.ctB())
      {
        paramContext = com.tencent.mm.as.o.OJ().bX(parama.bFH.field_msgSvrId);
        if (parama.bFH.field_isSend != 1) {
          break label857;
        }
        if (paramContext.Or())
        {
          i = 1;
          label613:
          if ((paramContext.offset >= paramContext.ebK) && (paramContext.ebK != 0)) {
            break label909;
          }
          y.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.bFH.field_msgId) });
          com.tencent.mm.as.o.OK().a(paramContext.enp, parama.bFH.field_msgId, i, parama.bFH, R.g.chat_img_template, new ae.3(this, parama, paramT));
          i = 1;
          label696:
          if (i != 0) {
            break label913;
          }
        }
      }
      else if ((parama.bFH.aRQ()) || (parama.bFH.aRR()))
      {
        paramContext = com.tencent.mm.modelvideo.u.oe(parama.bFH.field_imgPath);
        if ((paramContext == null) || (paramContext.status == 199)) {
          break label937;
        }
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            if (parama.bFH.field_imgPath.equals(paramAnonymousa.fileName))
            {
              com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.oe(paramAnonymousa.fileName);
              if ((locals != null) && (locals.SG()))
              {
                y.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.bFH.field_msgId), paramAnonymousa.fileName });
                com.tencent.mm.modelvideo.o.Sr().a(this);
                new ah(Looper.getMainLooper()).post(new ae.2.1(this));
              }
            }
            else
            {
              return;
            }
            y.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.bFH.field_msgId), paramAnonymousa.fileName });
          }
        };
        com.tencent.mm.modelvideo.o.Sr().a((t.a)localObject1, Looper.getMainLooper());
        y.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.bFH.field_msgId), parama.bFH.field_imgPath });
        if (!paramContext.SF()) {
          break label915;
        }
        y.i("MicroMsg.FavMsgHandle", "start complete online video");
        com.tencent.mm.modelvideo.u.oj(parama.bFH.field_imgPath);
      }
      label830:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label941;
        }
        this.vmj = "";
        a(paramT, parama);
        return;
        i = 0;
        break label613;
        label857:
        if (!paramContext.Or())
        {
          i = 0;
          break label613;
        }
        localObject1 = com.tencent.mm.as.f.a(paramContext);
        if (!com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(((com.tencent.mm.as.e)localObject1).enq, "", "")))
        {
          i = 0;
          break label613;
        }
        i = 1;
        break label613;
        i = 0;
        break label696;
        break;
        y.i("MicroMsg.FavMsgHandle", "start complete offline video");
        com.tencent.mm.modelvideo.u.oa(parama.bFH.field_imgPath);
        break label830;
      }
    }
  }
  
  public final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    this.vmj = "";
    Object localObject = new cj();
    com.tencent.mm.pluginsdk.model.e.a((cj)localObject, parama.bFH);
    if ((paramT instanceof x))
    {
      ((cj)localObject).bIw.uD = ((x)paramT);
      ((cj)localObject).bIw.bID = 43;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (((cj)localObject).bIx.ret == 0)
      {
        if (!parama.bFH.aVK()) {
          break label498;
        }
        com.tencent.mm.modelstat.b.eBD.b(parama.bFH, com.tencent.mm.ae.h.g(parama.bFH));
      }
    }
    for (;;)
    {
      if ((parama.bFH.aVK()) || (parama.bFH.ctz()))
      {
        paramT = com.tencent.mm.model.u.ij(parama.bFH.field_msgSvrId);
        u.b localb = com.tencent.mm.model.u.Hc().v(paramT, true);
        localb.h("prePublishId", "msg_" + parama.bFH.field_msgSvrId);
        localb.h("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.bFH, parama.kay, parama.kax));
        localb.h("preChatName", parama.talker);
        localb.h("preMsgIndex", Integer.valueOf(0));
        localb.h("sendAppMsgScene", Integer.valueOf(1));
        ((i)com.tencent.mm.kernel.g.r(i.class)).a("adExtStr", localb, parama.bFH);
        ((cj)localObject).bIw.bIB = paramT;
      }
      localObject = g.a.gp(bk.ZQ(parama.bFH.field_content));
      long l;
      if ((localObject != null) && (((g.a)localObject).type == 5) && (((g.a)localObject).url != null))
      {
        l = bk.UX();
        y.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((g.a)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
        paramT = "";
      }
      try
      {
        localObject = URLEncoder.encode(((g.a)localObject).url, "UTF-8");
        paramT = (TT)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.kaz != null) {
        parama.kaz.aQU();
      }
      a.a(a.c.vgo, a.d.vgt, parama.bFH, 0);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cj)localObject).bIw.activity = ((Activity)paramT);
      break;
      label498:
      com.tencent.mm.modelstat.b.eBD.x(parama.bFH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ae
 * JD-Core Version:    0.7.0.1
 */