package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.l;
import com.tencent.mm.aq.f;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ac<T>
{
  private String WDm = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final ca paramca, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_FavMsgHandle_1";
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.iUJ = paramString1;
    localg.field_fullpath = u.n(paramString4, false);
    localg.field_mediaId = paramString5;
    localg.iUG = new g.a()
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
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramAnonymousString, paramString4 });
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
          l = paramca.field_msgId;
          paramAnonymousc = paramString4;
          if (paramAnonymousd != null) {
            break label179;
          }
        }
        label179:
        for (i = 0;; i = paramAnonymousd.field_retCode)
        {
          Log.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramAnonymousString, paramAnonymousc, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
          j = 1;
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(34805);
          return 0;
        }
        paramHashSet.remove(paramAnonymousString);
        if (paramHashSet.isEmpty()) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34804);
              ac.this.a(ac.1.this.WDo, ac.1.this.WDp);
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
    if (!f.bkg().b(localg, -1)) {
      Log.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bT(ca paramca)
  {
    AppMethodBeat.i(34813);
    paramca = com.tencent.mm.ay.q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
    if ((paramca.offset < paramca.lAW) || (paramca.lAW == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean bU(ca paramca)
  {
    AppMethodBeat.i(34814);
    paramca = y.Yk(paramca.field_imgPath);
    if ((paramca != null) && (paramca.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bV(ca paramca)
  {
    AppMethodBeat.i(34815);
    if ((paramca != null) && (paramca.erk()))
    {
      paramca = k.b.OQ(paramca.field_content);
      if ((paramca != null) && (paramca.type == 40))
      {
        AppMethodBeat.o(34815);
        return false;
      }
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public static boolean bW(ca paramca)
  {
    AppMethodBeat.i(272972);
    if (paramca == null)
    {
      AppMethodBeat.o(272972);
      return true;
    }
    if ((!as.bvK(paramca.field_talker)) && (!as.bvK(bq.RL(paramca.field_content))))
    {
      AppMethodBeat.o(272972);
      return true;
    }
    if ((paramca.erk()) || (paramca.hzJ()))
    {
      Object localObject = k.b.OQ(paramca.field_content);
      if (localObject == null)
      {
        AppMethodBeat.o(272972);
        return true;
      }
      if (((k.b)localObject).type == 74)
      {
        AppMethodBeat.o(272972);
        return false;
      }
      if ((((k.b)localObject).type == 6) && (!Util.isNullOrNil(((k.b)localObject).lmc)))
      {
        localObject = m.e(paramca, ((k.b)localObject).fvr);
        if ((localObject != null) && ((!u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (u.bBQ(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(272972);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = p.aVz(((k.b)localObject).lmA).lpz.iterator();
          anm localanm;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localanm = (anm)((Iterator)localObject).next();
            str = p.c(localanm, paramca.field_msgId);
            if ((!Util.isNullOrNil(localanm.Sze)) && (!u.agG(str)))
            {
              AppMethodBeat.o(272972);
              return false;
            }
            str = p.f(localanm, paramca.field_msgId);
          } while ((Util.isNullOrNil(localanm.lmd)) || (u.agG(str)));
          AppMethodBeat.o(272972);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.aj.a)((k.b)localObject).ar(com.tencent.mm.aj.a.class);
          if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkv)) || (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkx)))
          {
            Log.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(272972);
            return false;
          }
        }
      }
    }
    if ((paramca.hwG()) && (!bT(paramca)))
    {
      AppMethodBeat.o(272972);
      return false;
    }
    if (((paramca.dlR()) || (paramca.dlT())) && (!bU(paramca)))
    {
      AppMethodBeat.o(272972);
      return false;
    }
    AppMethodBeat.o(272972);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.fvt.field_msgId + " ";
    if (((String)localObject1).equals(this.WDm))
    {
      com.tencent.mm.ui.base.w.makeText(paramContext, paramContext.getString(R.l.fav_doing_error_toast), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.WDm = ((String)localObject1);
    if (parama.fvt.erk())
    {
      paramContext = k.b.OQ(parama.fvt.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!Util.isNullOrNil(paramContext.lmc)))
      {
        localObject1 = m.e(parama.fvt, paramContext.fvr);
        if ((localObject1 != null) && ((!u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (u.bBQ(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).taskName = "task_FavMsgHandle_2";
          ((com.tencent.mm.i.g)localObject2).iUG = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.WzU.field_offset = paramAnonymousc.field_finishedLength;
                ao.ctZ().a(this.WzU, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.WzU.field_status = 199L;
                this.WzU.field_offset = this.WzU.field_totalLen;
                ao.ctZ().a(this.WzU, new String[0]);
                parama.fvt.setStatus(3);
                bh.beI();
                com.tencent.mm.model.c.bbO().a(parama.fvt.field_msgId, parama.fvt);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ac.this.a(ac.4.this.WDo, ac.4.this.WDt);
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
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), parama.fvt.field_talker, parama.fvt.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.aesKey;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.lmi;
          ((com.tencent.mm.i.g)localObject2).iUJ = paramContext.lmc;
          if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = u.n(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, false);; ((com.tencent.mm.i.g)localObject2).field_fullpath = u.n(m.aw(com.tencent.mm.model.c.bce(), paramContext.title, paramContext.llY), false))
          {
            if (!f.bkg().b((com.tencent.mm.i.g)localObject2, -1)) {
              Log.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            bh.beI();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = p.aVz(paramContext.lmA);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).lpz != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).lpz.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (anm)((Iterator)localObject1).next();
            String str1 = p.c((anm)localObject2, parama.fvt.field_msgId);
            String str2;
            if ((!Util.isNullOrNil(((anm)localObject2).Sze)) && (!u.agG(str1)))
            {
              str2 = p.f(((anm)localObject2).fEa, parama.fvt.field_msgId, true);
              a(paramT, parama, ((anm)localObject2).Sze, ((anm)localObject2).Szb, ((anm)localObject2).lmi, str1, str2, parama.fvt, paramContext);
            }
            str1 = p.f((anm)localObject2, parama.fvt.field_msgId);
            if ((!Util.isNullOrNil(((anm)localObject2).lmd)) && (!u.agG(str1)))
            {
              str2 = p.f(p.azJ(((anm)localObject2).fEa), parama.fvt.field_msgId, true);
              a(paramT, parama, ((anm)localObject2).lmd, ((anm)localObject2).lmj, ((anm)localObject2).lmi, str1, str2, parama.fvt, paramContext);
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
    if (parama.fvt.hwG())
    {
      paramContext = com.tencent.mm.ay.q.bmh().C(parama.fvt.field_talker, parama.fvt.field_msgSvrId);
      if (parama.fvt.field_isSend == 1) {
        if (paramContext.blK())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.lAW) && (paramContext.lAW != 0)) {
            break label814;
          }
          Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.fvt.field_msgId) });
          com.tencent.mm.ay.q.bmi().a(paramContext.localId, parama.fvt.field_msgId, i, parama.fvt, R.g.chat_img_template, new e.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.fvt.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.an.q paramAnonymousq) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.fvt.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ac.this.a(ac.3.this.WDo, ac.3.this.WDt);
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
      label814:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label820;
        }
        AppMethodBeat.o(34816);
        return;
        i = 0;
        break;
        if (!paramContext.blK())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.ay.h.a(paramContext);
        if (!u.agG(com.tencent.mm.ay.q.bmh().r(((com.tencent.mm.ay.g)localObject1).lNH, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label820:
    if ((parama.fvt.dlR()) || (parama.fvt.dlT()))
    {
      paramContext = y.Yk(parama.fvt.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new x.a()
        {
          public final void a(x.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.fvt.field_imgPath.equals(paramAnonymousa.fileName))
            {
              com.tencent.mm.modelvideo.w localw = y.Yk(paramAnonymousa.fileName);
              if ((localw != null) && (localw.bqS()))
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.fvt.field_msgId), paramAnonymousa.fileName });
                s.bqB().a(this);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ac.this.a(ac.2.this.WDo, ac.2.this.WDp);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.fvt.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        s.bqB().a((x.a)localObject1, Looper.getMainLooper());
        Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.fvt.field_msgId), parama.fvt.field_imgPath });
        if (paramContext.bqR())
        {
          Log.i("MicroMsg.FavMsgHandle", "start complete online video");
          y.Yq(parama.fvt.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label992;
        }
        AppMethodBeat.o(34816);
        return;
        Log.i("MicroMsg.FavMsgHandle", "start complete offline video");
        y.Yf(parama.fvt.field_imgPath);
        break;
      }
    }
    label992:
    this.WDm = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.WDm = "";
    Object localObject = new dd();
    j.d((dd)localObject, parama.fvt);
    if ((paramT instanceof MMFragment))
    {
      ((dd)localObject).fyI.fragment = ((MMFragment)paramT);
      ((dd)localObject).fyI.fyP = 43;
      EventCenter.instance.publish((IEvent)localObject);
      if (((dd)localObject).fyJ.ret == 0)
      {
        if (!parama.fvt.erk()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.mcf.e(parama.fvt, l.v(parama.fvt));
      }
    }
    for (;;)
    {
      if ((parama.fvt.erk()) || (parama.fvt.hwA()))
      {
        paramT = ad.Rp(parama.fvt.field_msgSvrId);
        ad.b localb = ad.beh().I(paramT, true);
        localb.k("prePublishId", "msg_" + parama.fvt.field_msgSvrId);
        localb.k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(parama.fvt, parama.wIg, parama.wIf));
        localb.k("preChatName", parama.talker);
        localb.k("preMsgIndex", Integer.valueOf(0));
        localb.k("sendAppMsgScene", Integer.valueOf(1));
        ((k)com.tencent.mm.kernel.h.ae(k.class)).a("adExtStr", localb, parama.fvt);
        ((dd)localObject).fyI.sessionId = paramT;
      }
      localObject = k.b.OQ(Util.processXml(parama.fvt.field_content));
      long l;
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        l = Util.nowSecond();
        Log.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
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
          Log.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.wIh != null) {
        parama.wIh.dkw();
      }
      a.a(a.c.Wwh, a.d.Wwm, parama.fvt, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((dd)localObject).fyI.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.mcf.aj(parama.fvt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */