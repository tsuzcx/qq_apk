package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.f;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.fav.model.b.a.a;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae<T>
{
  private String aekN = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.model.b.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final cc paramcc, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_FavMsgHandle_1";
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.lwO = paramString1;
    localg.field_fullpath = y.n(paramString4, false);
    localg.field_mediaId = paramString5;
    localg.lwL = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramAnonymousString, paramString4 });
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
          l = paramcc.field_msgId;
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
              ae.this.a(ae.1.this.aekP, ae.1.this.aekQ);
              AppMethodBeat.o(34804);
            }
          });
        }
        AppMethodBeat.o(34805);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    if (!k.bHW().b(localg, -1)) {
      Log.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean ch(cc paramcc)
  {
    AppMethodBeat.i(34813);
    paramcc = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
    if ((paramcc.offset < paramcc.osy) || (paramcc.osy == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean ci(cc paramcc)
  {
    AppMethodBeat.i(34814);
    paramcc = ab.Qo(paramcc.field_imgPath);
    if ((paramcc != null) && (paramcc.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean cj(cc paramcc)
  {
    AppMethodBeat.i(34815);
    if ((paramcc != null) && (paramcc.fxR()))
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 40))
      {
        AppMethodBeat.o(34815);
        return false;
      }
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public static boolean ck(cc paramcc)
  {
    AppMethodBeat.i(253795);
    if (paramcc == null)
    {
      AppMethodBeat.o(253795);
      return true;
    }
    if ((!au.bwO(paramcc.field_talker)) && (!au.bwO(br.JJ(paramcc.field_content))))
    {
      AppMethodBeat.o(253795);
      return true;
    }
    if ((paramcc.fxR()) || (paramcc.jbO()))
    {
      Object localObject = k.b.Hf(paramcc.field_content);
      if (localObject == null)
      {
        AppMethodBeat.o(253795);
        return true;
      }
      if (((k.b)localObject).type == 74)
      {
        AppMethodBeat.o(253795);
        return false;
      }
      if ((((k.b)localObject).type == 6) && (!Util.isNullOrNil(((k.b)localObject).tpurl)))
      {
        localObject = n.g(paramcc, ((k.b)localObject).hzM);
        if ((localObject != null) && ((!y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (y.bEl(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(253795);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = q.aSH(((k.b)localObject).nRF).nUC.iterator();
          arf localarf;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localarf = (arf)((Iterator)localObject).next();
            str = q.c(localarf, paramcc.field_msgId);
            if ((!Util.isNullOrNil(localarf.ZzW)) && (!y.ZC(str)))
            {
              AppMethodBeat.o(253795);
              return false;
            }
            str = q.f(localarf, paramcc.field_msgId);
          } while ((Util.isNullOrNil(localarf.nRi)) || (y.ZC(str)));
          AppMethodBeat.o(253795);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.message.a)((k.b)localObject).aK(com.tencent.mm.message.a.class);
          if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nPh)) || (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nPj)))
          {
            Log.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(253795);
            return false;
          }
        }
      }
    }
    if ((paramcc.iYk()) && (!ch(paramcc)))
    {
      AppMethodBeat.o(253795);
      return false;
    }
    if (((paramcc.dSH()) || (paramcc.dSJ())) && (!ci(paramcc)))
    {
      AppMethodBeat.o(253795);
      return false;
    }
    AppMethodBeat.o(253795);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.model.b.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.hzO.field_msgId + " ";
    if (((String)localObject1).equals(this.aekN))
    {
      com.tencent.mm.ui.base.aa.makeText(paramContext, paramContext.getString(R.l.fav_doing_error_toast), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.aekN = ((String)localObject1);
    if (parama.hzO.fxR())
    {
      paramContext = k.b.Hf(parama.hzO.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!Util.isNullOrNil(paramContext.tpurl)))
      {
        localObject1 = n.g(parama.hzO, paramContext.hzM);
        if ((localObject1 != null) && ((!y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (y.bEl(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.g.g();
          ((com.tencent.mm.g.g)localObject2).taskName = "task_FavMsgHandle_2";
          ((com.tencent.mm.g.g)localObject2).lwL = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.aehp.field_offset = paramAnonymousc.field_finishedLength;
                as.cWJ().a(this.aehp, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.aehp.field_status = 199L;
                this.aehp.field_offset = this.aehp.field_totalLen;
                as.cWJ().a(this.aehp, new String[0]);
                parama.hzO.setStatus(3);
                bh.bCz();
                com.tencent.mm.model.c.bzD().a(parama.hzO.field_msgId, parama.hzO);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ae.this.a(ae.4.this.aekP, ae.4.this.aekU);
                    AppMethodBeat.o(34811);
                  }
                });
              }
              AppMethodBeat.o(34812);
              return 0;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          ((com.tencent.mm.g.g)localObject2).field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), parama.hzO.field_talker, parama.hzO.field_msgId);
          ((com.tencent.mm.g.g)localObject2).field_aesKey = paramContext.aesKey;
          ((com.tencent.mm.g.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.g.g)localObject2).field_authKey = paramContext.nRn;
          ((com.tencent.mm.g.g)localObject2).lwO = paramContext.tpurl;
          if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.g.g)localObject2).field_fullpath = y.n(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, false);; ((com.tencent.mm.g.g)localObject2).field_fullpath = y.n(n.aK(com.tencent.mm.model.c.bzT(), paramContext.title, paramContext.nRe), false))
          {
            if (!k.bHW().b((com.tencent.mm.g.g)localObject2, -1)) {
              Log.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            bh.bCz();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = q.aSH(paramContext.nRF);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).nUC != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).nUC.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (arf)((Iterator)localObject1).next();
            String str1 = q.c((arf)localObject2, parama.hzO.field_msgId);
            String str2;
            if ((!Util.isNullOrNil(((arf)localObject2).ZzW)) && (!y.ZC(str1)))
            {
              str2 = q.f(((arf)localObject2).hIQ, parama.hzO.field_msgId, true);
              a(paramT, parama, ((arf)localObject2).ZzW, ((arf)localObject2).ZzT, ((arf)localObject2).nRn, str1, str2, parama.hzO, paramContext);
            }
            str1 = q.f((arf)localObject2, parama.hzO.field_msgId);
            if ((!Util.isNullOrNil(((arf)localObject2).nRi)) && (!y.ZC(str1)))
            {
              str2 = q.f(q.atP(((arf)localObject2).hIQ), parama.hzO.field_msgId, true);
              a(paramT, parama, ((arf)localObject2).nRi, ((arf)localObject2).nRo, ((arf)localObject2).nRn, str1, str2, parama.hzO, paramContext);
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
    if (parama.hzO.iYk())
    {
      paramContext = r.bKa().G(parama.hzO.field_talker, parama.hzO.field_msgSvrId);
      if (parama.hzO.field_isSend == 1) {
        if (paramContext.bJE())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.osy) && (paramContext.osy != 0)) {
            break label814;
          }
          Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.hzO.field_msgId) });
          r.bKb().a(paramContext.localId, parama.hzO.field_msgId, i, parama.hzO, R.g.chat_img_template, new f.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.hzO.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, p paramAnonymousp) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.hzO.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ae.this.a(ae.3.this.aekP, ae.3.this.aekU);
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
        if (!paramContext.bJE())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.modelimage.i.a(paramContext);
        if (!y.ZC(r.bKa().v(((com.tencent.mm.modelimage.h)localObject1).oGr, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label820:
    if ((parama.hzO.dSH()) || (parama.hzO.dSJ()))
    {
      paramContext = ab.Qo(parama.hzO.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new aa.a()
        {
          public final void a(aa.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.hzO.field_imgPath.equals(paramAnonymousa.fileName))
            {
              z localz = ab.Qo(paramAnonymousa.fileName);
              if ((localz != null) && (localz.bOx()))
              {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.hzO.field_msgId), paramAnonymousa.fileName });
                v.bOh().a(this);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ae.this.a(ae.2.this.aekP, ae.2.this.aekQ);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.hzO.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        v.bOh().a((aa.a)localObject1, Looper.getMainLooper());
        Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.hzO.field_msgId), parama.hzO.field_imgPath });
        if (paramContext.bOw())
        {
          Log.i("MicroMsg.FavMsgHandle", "start complete online video");
          ab.Qu(parama.hzO.field_imgPath);
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
        ab.Qj(parama.hzO.field_imgPath);
        break;
      }
    }
    label992:
    this.aekN = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.model.b.a parama)
  {
    AppMethodBeat.i(34818);
    this.aekN = "";
    Object localObject = new dn();
    com.tencent.mm.pluginsdk.model.l.d((dn)localObject, parama.hzO);
    if ((paramT instanceof MMFragment))
    {
      ((dn)localObject).hDr.fragment = ((MMFragment)paramT);
      ((dn)localObject).hDr.hDy = 43;
      ((dn)localObject).publish();
      if (((dn)localObject).hDs.ret == 0)
      {
        if (!parama.hzO.fxR()) {
          break label507;
        }
        b.oUZ.e(parama.hzO, com.tencent.mm.message.l.v(parama.hzO));
      }
    }
    for (;;)
    {
      if ((parama.hzO.fxR()) || (parama.hzO.iYe()))
      {
        paramT = ad.Jo(parama.hzO.field_msgSvrId);
        ad.b localb = ad.bCb().M(paramT, true);
        localb.q("prePublishId", "msg_" + parama.hzO.field_msgSvrId);
        localb.q("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(parama.hzO, parama.Aeu, parama.Aet));
        localb.q("preChatName", parama.talker);
        localb.q("preMsgIndex", Integer.valueOf(0));
        localb.q("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).a("adExtStr", localb, parama.hzO);
        ((dn)localObject).hDr.sessionId = paramT;
      }
      localObject = k.b.Hf(Util.processXml(parama.hzO.field_content));
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
      com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.Aev != null) {
        parama.Aev.dRi();
      }
      a.a(a.c.aedy, a.d.aedD, parama.hzO, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((dn)localObject).hDr.activity = ((Activity)paramT);
      break;
      label507:
      b.oUZ.ao(parama.hzO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ae
 * JD-Core Version:    0.7.0.1
 */