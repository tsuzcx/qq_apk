package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.h;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab<T>
{
  private String JDE = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final bu parambu, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    ad.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_FavMsgHandle_1";
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.fJm = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.fJj = new g.a()
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
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramAnonymousString, paramString4 });
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
          l = parambu.field_msgId;
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
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34804);
              ab.this.a(ab.1.this.JDG, ab.1.this.JDH);
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
    if (!f.aGI().b(localg, -1)) {
      ad.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bl(bu parambu)
  {
    AppMethodBeat.i(34813);
    parambu = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
    if ((parambu.offset < parambu.hMP) || (parambu.hMP == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean bm(bu parambu)
  {
    AppMethodBeat.i(34814);
    parambu = u.Hy(parambu.field_imgPath);
    if ((parambu != null) && (parambu.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bn(bu parambu)
  {
    AppMethodBeat.i(34815);
    if ((parambu != null) && (parambu.cTc()))
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 40))
      {
        AppMethodBeat.o(34815);
        return false;
      }
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public static boolean bo(bu parambu)
  {
    AppMethodBeat.i(193865);
    if (parambu == null)
    {
      AppMethodBeat.o(193865);
      return true;
    }
    if ((!am.aSQ(parambu.field_talker)) && (!am.aSQ(bj.Bk(parambu.field_content))))
    {
      AppMethodBeat.o(193865);
      return true;
    }
    if (parambu.cTc())
    {
      Object localObject = k.b.yr(parambu.field_content);
      if (localObject == null)
      {
        AppMethodBeat.o(193865);
        return true;
      }
      if ((((k.b)localObject).type == 6) && (!bt.isNullOrNil(((k.b)localObject).hzU)))
      {
        localObject = m.c(parambu, ((k.b)localObject).dks);
        if ((localObject != null) && ((!com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (com.tencent.mm.vfs.i.aYo(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(193865);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = p.avr(((k.b)localObject).hAs).hDb.iterator();
          ajn localajn;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localajn = (ajn)((Iterator)localObject).next();
            str = p.c(localajn, parambu.field_msgId);
            if ((!bt.isNullOrNil(localajn.Gij)) && (!com.tencent.mm.vfs.i.fv(str)))
            {
              AppMethodBeat.o(193865);
              return false;
            }
            str = p.f(localajn, parambu.field_msgId);
          } while ((bt.isNullOrNil(localajn.hzV)) || (com.tencent.mm.vfs.i.fv(str)));
          AppMethodBeat.o(193865);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
          if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).hys)) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).hyu)))
          {
            ad.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(193865);
            return false;
          }
        }
      }
    }
    if ((parambu.fpi()) && (!bl(parambu)))
    {
      AppMethodBeat.o(193865);
      return false;
    }
    if (((parambu.cxf()) || (parambu.cxh())) && (!bm(parambu)))
    {
      AppMethodBeat.o(193865);
      return false;
    }
    AppMethodBeat.o(193865);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.dku.field_msgId + " ";
    if (((String)localObject1).equals(this.JDE))
    {
      com.tencent.mm.ui.base.t.makeText(paramContext, paramContext.getString(2131758828), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.JDE = ((String)localObject1);
    if (parama.dku.cTc())
    {
      paramContext = k.b.yr(parama.dku.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!bt.isNullOrNil(paramContext.hzU)))
      {
        localObject1 = m.c(parama.dku, paramContext.dks);
        if ((localObject1 != null) && ((!com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.i.aYo(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).fJi = "task_FavMsgHandle_2";
          ((com.tencent.mm.i.g)localObject2).fJj = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.JAy.field_offset = paramAnonymousc.field_finishedLength;
                ao.bIX().a(this.JAy, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.JAy.field_status = 199L;
                this.JAy.field_offset = this.JAy.field_totalLen;
                ao.bIX().a(this.JAy, new String[0]);
                parama.dku.setStatus(3);
                ba.aBQ();
                com.tencent.mm.model.c.azs().a(parama.dku.field_msgId, parama.dku);
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ab.this.a(ab.4.this.JDG, ab.4.this.JDL);
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
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), parama.dku.field_talker, parama.dku.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.gjI;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.hAa;
          ((com.tencent.mm.i.g)localObject2).fJm = paramContext.hzU;
          if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = m.aq(com.tencent.mm.model.c.azI(), paramContext.title, paramContext.hzP))
          {
            if (!f.aGI().b((com.tencent.mm.i.g)localObject2, -1)) {
              ad.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            ba.aBQ();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = p.avr(paramContext.hAs);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).hDb != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).hDb.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ajn)((Iterator)localObject1).next();
            String str1 = p.c((ajn)localObject2, parama.dku.field_msgId);
            String str2;
            if ((!bt.isNullOrNil(((ajn)localObject2).Gij)) && (!com.tencent.mm.vfs.i.fv(str1)))
            {
              str2 = p.g(((ajn)localObject2).dsU, parama.dku.field_msgId, true);
              a(paramT, parama, ((ajn)localObject2).Gij, ((ajn)localObject2).Gig, ((ajn)localObject2).hAa, str1, str2, parama.dku, paramContext);
            }
            str1 = p.f((ajn)localObject2, parama.dku.field_msgId);
            if ((!bt.isNullOrNil(((ajn)localObject2).hzV)) && (!com.tencent.mm.vfs.i.fv(str1)))
            {
              str2 = p.g(p.agd(((ajn)localObject2).dsU), parama.dku.field_msgId, true);
              a(paramT, parama, ((ajn)localObject2).hzV, ((ajn)localObject2).hAb, ((ajn)localObject2).hAa, str1, str2, parama.dku, paramContext);
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
    if (parama.dku.fpi())
    {
      paramContext = q.aIF().F(parama.dku.field_talker, parama.dku.field_msgSvrId);
      if (parama.dku.field_isSend == 1) {
        if (paramContext.aIj())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.hMP) && (paramContext.hMP != 0)) {
            break label806;
          }
          ad.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.dku.field_msgId) });
          q.aIG().a(paramContext.dnz, parama.dku.field_msgId, i, parama.dku, 2131231564, new e.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.dku.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.dku.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ab.this.a(ab.3.this.JDG, ab.3.this.JDL);
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
      label806:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label812;
        }
        AppMethodBeat.o(34816);
        return;
        i = 0;
        break;
        if (!paramContext.aIj())
        {
          i = 0;
          break;
        }
        localObject1 = h.a(paramContext);
        if (!com.tencent.mm.vfs.i.fv(q.aIF().o(((com.tencent.mm.aw.g)localObject1).hZw, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label812:
    if ((parama.dku.cxf()) || (parama.dku.cxh()))
    {
      paramContext = u.Hy(parama.dku.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.dku.field_imgPath.equals(paramAnonymousa.fileName))
            {
              s locals = u.Hy(paramAnonymousa.fileName);
              if ((locals != null) && (locals.aMY()))
              {
                ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dku.field_msgId), paramAnonymousa.fileName });
                o.aMJ().a(this);
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ab.this.a(ab.2.this.JDG, ab.2.this.JDH);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dku.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        o.aMJ().a((t.a)localObject1, Looper.getMainLooper());
        ad.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dku.field_msgId), parama.dku.field_imgPath });
        if (paramContext.aMX())
        {
          ad.i("MicroMsg.FavMsgHandle", "start complete online video");
          u.HF(parama.dku.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label984;
        }
        AppMethodBeat.o(34816);
        return;
        ad.i("MicroMsg.FavMsgHandle", "start complete offline video");
        u.Ht(parama.dku.field_imgPath);
        break;
      }
    }
    label984:
    this.JDE = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.JDE = "";
    Object localObject = new cv();
    com.tencent.mm.pluginsdk.model.g.e((cv)localObject, parama.dku);
    if ((paramT instanceof MMFragment))
    {
      ((cv)localObject).dnG.fragment = ((MMFragment)paramT);
      ((cv)localObject).dnG.dnM = 43;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((cv)localObject).dnH.ret == 0)
      {
        if (!parama.dku.cTc()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.inZ.c(parama.dku, l.r(parama.dku));
      }
    }
    for (;;)
    {
      if ((parama.dku.cTc()) || (parama.dku.fpd()))
      {
        paramT = y.AH(parama.dku.field_msgSvrId);
        y.b localb = y.aBq().F(paramT, true);
        localb.k("prePublishId", "msg_" + parama.dku.field_msgSvrId);
        localb.k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.dku, parama.ruk, parama.ruj));
        localb.k("preChatName", parama.talker);
        localb.k("preMsgIndex", Integer.valueOf(0));
        localb.k("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.ab(j.class)).a("adExtStr", localb, parama.dku);
        ((cv)localObject).dnG.sessionId = paramT;
      }
      localObject = k.b.yr(bt.aRd(parama.dku.field_content));
      long l;
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        l = bt.aQJ();
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
      com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.rul != null) {
        parama.rul.cvL();
      }
      a.a(a.c.Jxc, a.d.Jxh, parama.dku, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cv)localObject).dnG.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.inZ.S(parama.dku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab
 * JD-Core Version:    0.7.0.1
 */