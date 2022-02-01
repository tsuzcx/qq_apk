package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.l;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ac<T>
{
  private String PjI = "";
  
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
    localg.gqB = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.gqy = new g.a()
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
              ac.this.a(ac.1.this.PjK, ac.1.this.PjL);
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
    if (!f.baQ().b(localg, -1)) {
      Log.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bA(ca paramca)
  {
    AppMethodBeat.i(34814);
    paramca = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    if ((paramca != null) && (paramca.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bB(ca paramca)
  {
    AppMethodBeat.i(34815);
    if ((paramca != null) && (paramca.dOQ()))
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 40))
      {
        AppMethodBeat.o(34815);
        return false;
      }
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public static boolean bC(ca paramca)
  {
    AppMethodBeat.i(232911);
    if (paramca == null)
    {
      AppMethodBeat.o(232911);
      return true;
    }
    if ((!as.bjp(paramca.field_talker)) && (!as.bjp(bp.Ks(paramca.field_content))))
    {
      AppMethodBeat.o(232911);
      return true;
    }
    if (paramca.dOQ())
    {
      Object localObject = k.b.HD(paramca.field_content);
      if (localObject == null)
      {
        AppMethodBeat.o(232911);
        return true;
      }
      if ((((k.b)localObject).type == 6) && (!Util.isNullOrNil(((k.b)localObject).iwN)))
      {
        localObject = m.c(paramca, ((k.b)localObject).dCK);
        if ((localObject != null) && ((!com.tencent.mm.vfs.s.YS(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (com.tencent.mm.vfs.s.boW(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(232911);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = p.aKY(((k.b)localObject).ixl).iAd.iterator();
          aml localaml;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localaml = (aml)((Iterator)localObject).next();
            str = p.c(localaml, paramca.field_msgId);
            if ((!Util.isNullOrNil(localaml.LwF)) && (!com.tencent.mm.vfs.s.YS(str)))
            {
              AppMethodBeat.o(232911);
              return false;
            }
            str = p.f(localaml, paramca.field_msgId);
          } while ((Util.isNullOrNil(localaml.iwO)) || (com.tencent.mm.vfs.s.YS(str)));
          AppMethodBeat.o(232911);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.ag.a)((k.b)localObject).as(com.tencent.mm.ag.a.class);
          if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivm)) || (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivo)))
          {
            Log.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(232911);
            return false;
          }
        }
      }
    }
    if ((paramca.gAz()) && (!bz(paramca)))
    {
      AppMethodBeat.o(232911);
      return false;
    }
    if (((paramca.cWJ()) || (paramca.cWL())) && (!bA(paramca)))
    {
      AppMethodBeat.o(232911);
      return false;
    }
    AppMethodBeat.o(232911);
    return true;
  }
  
  private static boolean bz(ca paramca)
  {
    AppMethodBeat.i(34813);
    paramca = com.tencent.mm.av.q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
    if ((paramca.offset < paramca.iKP) || (paramca.iKP == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.dCM.field_msgId + " ";
    if (((String)localObject1).equals(this.PjI))
    {
      com.tencent.mm.ui.base.u.makeText(paramContext, paramContext.getString(2131759151), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.PjI = ((String)localObject1);
    if (parama.dCM.dOQ())
    {
      paramContext = k.b.HD(parama.dCM.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!Util.isNullOrNil(paramContext.iwN)))
      {
        localObject1 = m.c(parama.dCM, paramContext.dCK);
        if ((localObject1 != null) && ((!com.tencent.mm.vfs.s.YS(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.s.boW(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).taskName = "task_FavMsgHandle_2";
          ((com.tencent.mm.i.g)localObject2).gqy = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.PgB.field_offset = paramAnonymousc.field_finishedLength;
                ao.cgO().a(this.PgB, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.PgB.field_status = 199L;
                this.PgB.field_offset = this.PgB.field_totalLen;
                ao.cgO().a(this.PgB, new String[0]);
                parama.dCM.setStatus(3);
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(parama.dCM.field_msgId, parama.dCM);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ac.this.a(ac.4.this.PjK, ac.4.this.PjP);
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
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), parama.dCM.field_talker, parama.dCM.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.aesKey;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.iwT;
          ((com.tencent.mm.i.g)localObject2).gqB = paramContext.iwN;
          if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = m.aB(com.tencent.mm.model.c.aTg(), paramContext.title, paramContext.iwJ))
          {
            if (!f.baQ().b((com.tencent.mm.i.g)localObject2, -1)) {
              Log.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            bg.aVF();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = p.aKY(paramContext.ixl);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).iAd != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).iAd.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aml)((Iterator)localObject1).next();
            String str1 = p.c((aml)localObject2, parama.dCM.field_msgId);
            String str2;
            if ((!Util.isNullOrNil(((aml)localObject2).LwF)) && (!com.tencent.mm.vfs.s.YS(str1)))
            {
              str2 = p.g(((aml)localObject2).dLl, parama.dCM.field_msgId, true);
              a(paramT, parama, ((aml)localObject2).LwF, ((aml)localObject2).LwC, ((aml)localObject2).iwT, str1, str2, parama.dCM, paramContext);
            }
            str1 = p.f((aml)localObject2, parama.dCM.field_msgId);
            if ((!Util.isNullOrNil(((aml)localObject2).iwO)) && (!com.tencent.mm.vfs.s.YS(str1)))
            {
              str2 = p.g(p.arI(((aml)localObject2).dLl), parama.dCM.field_msgId, true);
              a(paramT, parama, ((aml)localObject2).iwO, ((aml)localObject2).iwU, ((aml)localObject2).iwT, str1, str2, parama.dCM, paramContext);
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
    if (parama.dCM.gAz())
    {
      paramContext = com.tencent.mm.av.q.bcR().G(parama.dCM.field_talker, parama.dCM.field_msgSvrId);
      if (parama.dCM.field_isSend == 1) {
        if (paramContext.bcv())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.iKP) && (paramContext.iKP != 0)) {
            break label806;
          }
          Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.dCM.field_msgId) });
          com.tencent.mm.av.q.bcS().a(paramContext.localId, parama.dCM.field_msgId, i, parama.dCM, 2131231628, new e.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.dCM.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.q paramAnonymousq) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.dCM.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ac.this.a(ac.3.this.PjK, ac.3.this.PjP);
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
        if (!paramContext.bcv())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.av.h.a(paramContext);
        if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.av.q.bcR().o(((com.tencent.mm.av.g)localObject1).iXm, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label812:
    if ((parama.dCM.cWJ()) || (parama.dCM.cWL()))
    {
      paramContext = com.tencent.mm.modelvideo.u.QN(parama.dCM.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.dCM.field_imgPath.equals(paramAnonymousa.fileName))
            {
              com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramAnonymousa.fileName);
              if ((locals != null) && (locals.bhy()))
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dCM.field_msgId), paramAnonymousa.fileName });
                o.bhj().a(this);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ac.this.a(ac.2.this.PjK, ac.2.this.PjL);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dCM.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        o.bhj().a((t.a)localObject1, Looper.getMainLooper());
        Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dCM.field_msgId), parama.dCM.field_imgPath });
        if (paramContext.bhx())
        {
          Log.i("MicroMsg.FavMsgHandle", "start complete online video");
          com.tencent.mm.modelvideo.u.QT(parama.dCM.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label984;
        }
        AppMethodBeat.o(34816);
        return;
        Log.i("MicroMsg.FavMsgHandle", "start complete offline video");
        com.tencent.mm.modelvideo.u.QI(parama.dCM.field_imgPath);
        break;
      }
    }
    label984:
    this.PjI = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.PjI = "";
    Object localObject = new cz();
    com.tencent.mm.pluginsdk.model.h.d((cz)localObject, parama.dCM);
    if ((paramT instanceof MMFragment))
    {
      ((cz)localObject).dFZ.fragment = ((MMFragment)paramT);
      ((cz)localObject).dFZ.dGf = 43;
      EventCenter.instance.publish((IEvent)localObject);
      if (((cz)localObject).dGa.ret == 0)
      {
        if (!parama.dCM.dOQ()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.jmd.c(parama.dCM, l.t(parama.dCM));
      }
    }
    for (;;)
    {
      if ((parama.dCM.dOQ()) || (parama.dCM.gAt()))
      {
        paramT = ad.JX(parama.dCM.field_msgSvrId);
        ad.b localb = ad.aVe().G(paramT, true);
        localb.l("prePublishId", "msg_" + parama.dCM.field_msgSvrId);
        localb.l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.dCM, parama.tcb, parama.tca));
        localb.l("preChatName", parama.talker);
        localb.l("preMsgIndex", Integer.valueOf(0));
        localb.l("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", localb, parama.dCM);
        ((cz)localObject).dFZ.sessionId = paramT;
      }
      localObject = k.b.HD(Util.processXml(parama.dCM.field_content));
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
      com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.tcc != null) {
        parama.tcc.cVq();
      }
      a.a(a.c.PcW, a.d.Pdb, parama.dCM, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cz)localObject).dFZ.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.jmd.ac(parama.dCM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */