package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.e;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
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
  private String HPP = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final bo parambo, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    ac.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambo.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.fre = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.frb = new g.a()
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
              ac.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambo.field_msgId), paramAnonymousString, paramString4 });
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
          l = parambo.field_msgId;
          paramAnonymousc = paramString4;
          if (paramAnonymousd != null) {
            break label179;
          }
        }
        label179:
        for (i = 0;; i = paramAnonymousd.field_retCode)
        {
          ac.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramAnonymousString, paramAnonymousc, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
          j = 1;
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(34805);
          return 0;
        }
        paramHashSet.remove(paramAnonymousString);
        if (paramHashSet.isEmpty()) {
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34804);
              ab.this.a(ab.1.this.HPR, ab.1.this.HPS);
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
    if (!com.tencent.mm.an.f.aDD().b(localg, -1)) {
      ac.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bi(bo parambo)
  {
    AppMethodBeat.i(34813);
    parambo = com.tencent.mm.av.o.aFx().qf(parambo.field_msgSvrId);
    if ((parambo.offset < parambo.hux) || (parambo.hux == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean bj(bo parambo)
  {
    AppMethodBeat.i(34814);
    parambo = u.Ej(parambo.field_imgPath);
    if ((parambo != null) && (parambo.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bk(bo parambo)
  {
    AppMethodBeat.i(34815);
    if ((!ai.aNc(parambo.field_talker)) && (!ai.aNc(bi.yl(parambo.field_content))))
    {
      AppMethodBeat.o(34815);
      return true;
    }
    if (parambo.cKN())
    {
      Object localObject = k.b.vA(parambo.field_content);
      if ((((k.b)localObject).type == 6) && (!bs.isNullOrNil(((k.b)localObject).hhL)))
      {
        localObject = m.c(parambo, ((k.b)localObject).cZa);
        if ((localObject != null) && ((!i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (i.aSp(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(34815);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = com.tencent.mm.plugin.record.b.n.aqs(((k.b)localObject).hij).hkS.iterator();
          agx localagx;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localagx = (agx)((Iterator)localObject).next();
            str = com.tencent.mm.plugin.record.b.n.c(localagx, parambo.field_msgId);
            if ((!bs.isNullOrNil(localagx.EAx)) && (!i.eA(str)))
            {
              AppMethodBeat.o(34815);
              return false;
            }
            str = com.tencent.mm.plugin.record.b.n.f(localagx, parambo.field_msgId);
          } while ((bs.isNullOrNil(localagx.hhM)) || (i.eA(str)));
          AppMethodBeat.o(34815);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
          if ((localObject == null) || (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject).hgj)) || (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject).hgl)))
          {
            ac.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(34815);
            return false;
          }
        }
      }
    }
    if ((parambo.eZm()) && (!bi(parambo)))
    {
      AppMethodBeat.o(34815);
      return false;
    }
    if (((parambo.crt()) || (parambo.crv())) && (!bj(parambo)))
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
    Object localObject1 = parama.cZc.field_msgId + " ";
    if (((String)localObject1).equals(this.HPP))
    {
      com.tencent.mm.ui.base.t.makeText(paramContext, paramContext.getString(2131758828), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.HPP = ((String)localObject1);
    if (parama.cZc.cKN())
    {
      paramContext = k.b.vA(parama.cZc.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!bs.isNullOrNil(paramContext.hhL)))
      {
        localObject1 = m.c(parama.cZc, paramContext.cZa);
        if ((localObject1 != null) && ((!i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (i.aSp(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).frb = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.HMI.field_offset = paramAnonymousc.field_finishedLength;
                ap.bEO().a(this.HMI, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.HMI.field_status = 199L;
                this.HMI.field_offset = this.HMI.field_totalLen;
                ap.bEO().a(this.HMI, new String[0]);
                parama.cZc.setStatus(3);
                az.ayM();
                com.tencent.mm.model.c.awD().a(parama.cZc.field_msgId, parama.cZc);
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ab.this.a(ab.4.this.HPR, ab.4.this.HPW);
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
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), parama.cZc.field_talker, parama.cZc.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.fQi;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.hhR;
          ((com.tencent.mm.i.g)localObject2).fre = paramContext.hhL;
          if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = m.aj(com.tencent.mm.model.c.awT(), paramContext.title, paramContext.hhG))
          {
            if (!com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject2, -1)) {
              ac.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            az.ayM();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = com.tencent.mm.plugin.record.b.n.aqs(paramContext.hij);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).hkS != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).hkS.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (agx)((Iterator)localObject1).next();
            String str1 = com.tencent.mm.plugin.record.b.n.c((agx)localObject2, parama.cZc.field_msgId);
            String str2;
            if ((!bs.isNullOrNil(((agx)localObject2).EAx)) && (!i.eA(str1)))
            {
              str2 = com.tencent.mm.plugin.record.b.n.h(((agx)localObject2).dhw, parama.cZc.field_msgId, true);
              a(paramT, parama, ((agx)localObject2).EAx, ((agx)localObject2).EAu, ((agx)localObject2).hhR, str1, str2, parama.cZc, paramContext);
            }
            str1 = com.tencent.mm.plugin.record.b.n.f((agx)localObject2, parama.cZc.field_msgId);
            if ((!bs.isNullOrNil(((agx)localObject2).hhM)) && (!i.eA(str1)))
            {
              str2 = com.tencent.mm.plugin.record.b.n.h(com.tencent.mm.plugin.record.b.n.aco(((agx)localObject2).dhw), parama.cZc.field_msgId, true);
              a(paramT, parama, ((agx)localObject2).hhM, ((agx)localObject2).hhS, ((agx)localObject2).hhR, str1, str2, parama.cZc, paramContext);
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
    if (parama.cZc.eZm())
    {
      paramContext = com.tencent.mm.av.o.aFx().qf(parama.cZc.field_msgSvrId);
      if (parama.cZc.field_isSend == 1) {
        if (paramContext.aFa())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.hux) && (paramContext.hux != 0)) {
            break label791;
          }
          ac.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.cZc.field_msgId) });
          com.tencent.mm.av.o.aFy().a(paramContext.dcd, parama.cZc.field_msgId, i, parama.cZc, 2131231564, new d.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              ac.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.cZc.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.n paramAnonymousn) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                ac.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.cZc.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ab.this.a(ab.3.this.HPR, ab.3.this.HPW);
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
        if (!paramContext.aFa())
        {
          i = 0;
          break;
        }
        localObject1 = com.tencent.mm.av.f.a(paramContext);
        if (!i.eA(com.tencent.mm.av.o.aFx().p(((e)localObject1).hGM, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label797:
    if ((parama.cZc.crt()) || (parama.cZc.crv()))
    {
      paramContext = u.Ej(parama.cZc.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.cZc.field_imgPath.equals(paramAnonymousa.fileName))
            {
              s locals = u.Ej(paramAnonymousa.fileName);
              if ((locals != null) && (locals.aJN()))
              {
                ac.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.cZc.field_msgId), paramAnonymousa.fileName });
                com.tencent.mm.modelvideo.o.aJy().a(this);
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ab.this.a(ab.2.this.HPR, ab.2.this.HPS);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              ac.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.cZc.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        com.tencent.mm.modelvideo.o.aJy().a((t.a)localObject1, Looper.getMainLooper());
        ac.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.cZc.field_msgId), parama.cZc.field_imgPath });
        if (paramContext.aJM())
        {
          ac.i("MicroMsg.FavMsgHandle", "start complete online video");
          u.Eq(parama.cZc.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label969;
        }
        AppMethodBeat.o(34816);
        return;
        ac.i("MicroMsg.FavMsgHandle", "start complete offline video");
        u.Ee(parama.cZc.field_imgPath);
        break;
      }
    }
    label969:
    this.HPP = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.HPP = "";
    Object localObject = new cs();
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject, parama.cZc);
    if ((paramT instanceof MMFragment))
    {
      ((cs)localObject).dck.fragment = ((MMFragment)paramT);
      ((cs)localObject).dck.dcq = 43;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (((cs)localObject).dcl.ret == 0)
      {
        if (!parama.cZc.cKN()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.hUE.c(parama.cZc, l.r(parama.cZc));
      }
    }
    for (;;)
    {
      if ((parama.cZc.cKN()) || (parama.cZc.eZj()))
      {
        paramT = y.xJ(parama.cZc.field_msgSvrId);
        y.b localb = y.ayq().F(paramT, true);
        localb.l("prePublishId", "msg_" + parama.cZc.field_msgSvrId);
        localb.l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.cZc, parama.qKi, parama.qKh));
        localb.l("preChatName", parama.talker);
        localb.l("preMsgIndex", Integer.valueOf(0));
        localb.l("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.ab(j.class)).a("adExtStr", localb, parama.cZc);
        ((cs)localObject).dck.sessionId = paramT;
      }
      localObject = k.b.vA(bs.aLx(parama.cZc.field_content));
      long l;
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        l = bs.aNx();
        ac.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
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
          ac.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.qKj != null) {
        parama.qKj.cqg();
      }
      a.a(a.c.HJl, a.d.HJq, parama.cZc, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cs)localObject).dck.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.hUE.P(parama.cZc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab
 * JD-Core Version:    0.7.0.1
 */