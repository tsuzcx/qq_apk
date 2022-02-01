package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab<T>
{
  private String GpX = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final bl parambl, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    ad.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.fnK = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.fnH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(34805);
        int j = 0;
        int i = j;
        if (paramAnonymousInt == 0)
        {
          i = j;
          if (paramAnonymousd != null)
          {
            i = j;
            if (paramAnonymousd.field_retCode == 0)
            {
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramAnonymousString, paramString4 });
              i = 1;
            }
          }
        }
        long l;
        if (paramAnonymousInt == 0)
        {
          j = i;
          if (paramAnonymousd != null)
          {
            j = i;
            if (paramAnonymousd.field_retCode == 0) {}
          }
        }
        else
        {
          l = parambl.field_msgId;
          paramAnonymousc = paramString4;
          if (paramAnonymousd != null) {
            break label179;
          }
        }
        label179:
        for (i = 0;; i = paramAnonymousd.field_retCode)
        {
          ad.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramAnonymousString, paramAnonymousc, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
          j = 1;
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(34805);
          return 0;
        }
        paramHashSet.remove(paramAnonymousString);
        if (paramHashSet.isEmpty()) {
          new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34804);
              ab.this.a(ab.1.this.GpZ, ab.1.this.Gqa);
              AppMethodBeat.o(34804);
            }
          });
        }
        AppMethodBeat.o(34805);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    if (!com.tencent.mm.ao.f.awL().b(localg, -1)) {
      ad.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bg(bl parambl)
  {
    AppMethodBeat.i(34813);
    parambl = com.tencent.mm.aw.o.ayF().mr(parambl.field_msgSvrId);
    if ((parambl.offset < parambl.gTY) || (parambl.gTY == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean bh(bl parambl)
  {
    AppMethodBeat.i(34814);
    parambl = u.Ae(parambl.field_imgPath);
    if ((parambl != null) && (parambl.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bi(bl parambl)
  {
    AppMethodBeat.i(34815);
    if ((!af.aHH(parambl.field_talker)) && (!af.aHH(bi.uf(parambl.field_content))))
    {
      AppMethodBeat.o(34815);
      return true;
    }
    if (parambl.cxB())
    {
      Object localObject = k.b.rx(parambl.field_content);
      if ((((k.b)localObject).type == 6) && (!bt.isNullOrNil(((k.b)localObject).gHk)))
      {
        localObject = m.c(parambl, ((k.b)localObject).dbA);
        if ((localObject != null) && ((!i.eK(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (i.aMN(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(34815);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = com.tencent.mm.plugin.record.b.n.alt(((k.b)localObject).gHI).gKs.iterator();
          afy localafy;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localafy = (afy)((Iterator)localObject).next();
            str = com.tencent.mm.plugin.record.b.n.c(localafy, parambl.field_msgId);
            if ((!bt.isNullOrNil(localafy.Dhr)) && (!i.eK(str)))
            {
              AppMethodBeat.o(34815);
              return false;
            }
            str = com.tencent.mm.plugin.record.b.n.f(localafy, parambl.field_msgId);
          } while ((bt.isNullOrNil(localafy.gHl)) || (i.eK(str)));
          AppMethodBeat.o(34815);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
          if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).gFI)) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).gFK)))
          {
            ad.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(34815);
            return false;
          }
        }
      }
    }
    if ((parambl.eJO()) && (!bg(parambl)))
    {
      AppMethodBeat.o(34815);
      return false;
    }
    if (((parambl.cjM()) || (parambl.cjO())) && (!bh(parambl)))
    {
      AppMethodBeat.o(34815);
      return false;
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.dbD.field_msgId + " ";
    if (((String)localObject1).equals(this.GpX))
    {
      com.tencent.mm.ui.base.t.makeText(paramContext, paramContext.getString(2131758828), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.GpX = ((String)localObject1);
    if (parama.dbD.cxB())
    {
      paramContext = k.b.rx(parama.dbD.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!bt.isNullOrNil(paramContext.gHk)))
      {
        localObject1 = m.c(parama.dbD, paramContext.dbA);
        if ((localObject1 != null) && ((!i.eK(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (i.aMN(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).fnH = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.GmS.field_offset = paramAnonymousc.field_finishedLength;
                com.tencent.mm.pluginsdk.model.app.ap.bxS().a(this.GmS, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.GmS.field_status = 199L;
                this.GmS.field_offset = this.GmS.field_totalLen;
                com.tencent.mm.pluginsdk.model.app.ap.bxS().a(this.GmS, new String[0]);
                parama.dbD.setStatus(3);
                az.arV();
                com.tencent.mm.model.c.apO().a(parama.dbD.field_msgId, parama.dbD);
                new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ab.this.a(ab.4.this.GpZ, ab.4.this.Gqe);
                    AppMethodBeat.o(34811);
                  }
                });
              }
              AppMethodBeat.o(34812);
              return 0;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.eGO(), parama.dbD.field_talker, parama.dbD.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.fMw;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.gHq;
          ((com.tencent.mm.i.g)localObject2).fnK = paramContext.gHk;
          if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = m.ai(com.tencent.mm.model.c.aqe(), paramContext.title, paramContext.gHf))
          {
            if (!com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject2, -1)) {
              ad.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            az.arV();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = com.tencent.mm.plugin.record.b.n.alt(paramContext.gHI);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).gKs != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).gKs.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (afy)((Iterator)localObject1).next();
            String str1 = com.tencent.mm.plugin.record.b.n.c((afy)localObject2, parama.dbD.field_msgId);
            String str2;
            if ((!bt.isNullOrNil(((afy)localObject2).Dhr)) && (!i.eK(str1)))
            {
              str2 = com.tencent.mm.plugin.record.b.n.h(((afy)localObject2).dkb, parama.dbD.field_msgId, true);
              a(paramT, parama, ((afy)localObject2).Dhr, ((afy)localObject2).Dho, ((afy)localObject2).gHq, str1, str2, parama.dbD, paramContext);
            }
            str1 = com.tencent.mm.plugin.record.b.n.f((afy)localObject2, parama.dbD.field_msgId);
            if ((!bt.isNullOrNil(((afy)localObject2).gHl)) && (!i.eK(str1)))
            {
              str2 = com.tencent.mm.plugin.record.b.n.h(com.tencent.mm.plugin.record.b.n.XS(((afy)localObject2).dkb), parama.dbD.field_msgId, true);
              a(paramT, parama, ((afy)localObject2).gHl, ((afy)localObject2).gHr, ((afy)localObject2).gHq, str1, str2, parama.dbD, paramContext);
            }
          }
        }
        if (!paramContext.isEmpty())
        {
          AppMethodBeat.o(34816);
          return;
        }
      }
    }
    int i;
    if (parama.dbD.eJO())
    {
      paramContext = com.tencent.mm.aw.o.ayF().mr(parama.dbD.field_msgSvrId);
      if (parama.dbD.field_isSend == 1) {
        if (paramContext.ayi())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.gTY) && (paramContext.gTY != 0)) {
            break label791;
          }
          ad.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.dbD.field_msgId) });
          com.tencent.mm.aw.o.ayG().a(paramContext.deI, parama.dbD.field_msgId, i, parama.dbD, 2131231564, new d.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.dbD.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.al.n paramAnonymousn) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.dbD.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ab.this.a(ab.3.this.GpZ, ab.3.this.Gqe);
                    AppMethodBeat.o(34808);
                  }
                });
                AppMethodBeat.o(34809);
                return;
              }
            }
          });
        }
      }
      label791:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label797;
        }
        AppMethodBeat.o(34816);
        return;
        i = 0;
        break;
        if (!paramContext.ayi())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.aw.f.a(paramContext);
        if (!i.eK(com.tencent.mm.aw.o.ayF().p(((e)localObject1).hgj, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label797:
    if ((parama.dbD.cjM()) || (parama.dbD.cjO()))
    {
      paramContext = u.Ae(parama.dbD.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.dbD.field_imgPath.equals(paramAnonymousa.fileName))
            {
              s locals = u.Ae(paramAnonymousa.fileName);
              if ((locals != null) && (locals.aCW()))
              {
                ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dbD.field_msgId), paramAnonymousa.fileName });
                com.tencent.mm.modelvideo.o.aCI().a(this);
                new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ab.this.a(ab.2.this.GpZ, ab.2.this.Gqa);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dbD.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        com.tencent.mm.modelvideo.o.aCI().a((t.a)localObject1, Looper.getMainLooper());
        ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dbD.field_msgId), parama.dbD.field_imgPath });
        if (paramContext.aCV())
        {
          ad.i("MicroMsg.FavMsgHandle", "start complete online video");
          u.Al(parama.dbD.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label969;
        }
        AppMethodBeat.o(34816);
        return;
        ad.i("MicroMsg.FavMsgHandle", "start complete offline video");
        u.zZ(parama.dbD.field_imgPath);
        break;
      }
    }
    label969:
    this.GpX = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.GpX = "";
    Object localObject = new cs();
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject, parama.dbD);
    if ((paramT instanceof MMFragment))
    {
      ((cs)localObject).deQ.fragment = ((MMFragment)paramT);
      ((cs)localObject).deQ.deW = 43;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((cs)localObject).deR.ret == 0)
      {
        if (!parama.dbD.cxB()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.huc.c(parama.dbD, l.r(parama.dbD));
      }
    }
    for (;;)
    {
      if ((parama.dbD.cxB()) || (parama.dbD.eJL()))
      {
        paramT = y.tD(parama.dbD.field_msgSvrId);
        y.b localb = y.arz().E(paramT, true);
        localb.m("prePublishId", "msg_" + parama.dbD.field_msgSvrId);
        localb.m("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.dbD, parama.qbC, parama.qbB));
        localb.m("preChatName", parama.talker);
        localb.m("preMsgIndex", Integer.valueOf(0));
        localb.m("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.ab(j.class)).a("adExtStr", localb, parama.dbD);
        ((cs)localObject).deQ.sessionId = paramT;
      }
      localObject = k.b.rx(bt.aGg(parama.dbD.field_content));
      long l;
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        l = bt.aGK();
        ad.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
        paramT = "";
      }
      try
      {
        localObject = URLEncoder.encode(((k.b)localObject).url, "UTF-8");
        paramT = (TT)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.qbD != null) {
        parama.qbD.ciz();
      }
      a.a(a.c.Gjw, a.d.GjB, parama.dbD, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cs)localObject).deQ.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.huc.P(parama.dbD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab
 * JD-Core Version:    0.7.0.1
 */