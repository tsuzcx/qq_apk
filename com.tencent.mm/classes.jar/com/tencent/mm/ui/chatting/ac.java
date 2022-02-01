package com.tencent.mm.ui.chatting;

import TT;;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class ac<T>
{
  private String JYv = "";
  
  private void a(final T paramT, final com.tencent.mm.plugin.fav.b.c.a parama, String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final bv parambv, final HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(34817);
    ae.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambv.field_msgId), paramString5, paramString4 });
    paramHashSet.add(paramString5);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_FavMsgHandle_1";
    localg.field_fileType = 19;
    localg.field_authKey = paramString3;
    localg.field_aesKey = paramString2;
    localg.fLp = paramString1;
    localg.field_fullpath = paramString4;
    localg.field_mediaId = paramString5;
    localg.fLm = new g.a()
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
              ae.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[] { Long.valueOf(parambv.field_msgId), paramAnonymousString, paramString4 });
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
          l = parambv.field_msgId;
          paramAnonymousc = paramString4;
          if (paramAnonymousd != null) {
            break label179;
          }
        }
        label179:
        for (i = 0;; i = paramAnonymousd.field_retCode)
        {
          ae.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { Long.valueOf(l), paramAnonymousString, paramAnonymousc, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
          j = 1;
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(34805);
          return 0;
        }
        paramHashSet.remove(paramAnonymousString);
        if (paramHashSet.isEmpty()) {
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34804);
              ac.this.a(ac.1.this.JYx, ac.1.this.JYy);
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
    if (!f.aGZ().b(localg, -1)) {
      ae.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
    }
    AppMethodBeat.o(34817);
  }
  
  private static boolean bk(bv parambv)
  {
    AppMethodBeat.i(34813);
    parambv = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
    if ((parambv.offset < parambv.hPI) || (parambv.hPI == 0))
    {
      AppMethodBeat.o(34813);
      return false;
    }
    AppMethodBeat.o(34813);
    return true;
  }
  
  private static boolean bl(bv parambv)
  {
    AppMethodBeat.i(34814);
    parambv = u.Ia(parambv.field_imgPath);
    if ((parambv != null) && (parambv.status != 199))
    {
      AppMethodBeat.o(34814);
      return false;
    }
    AppMethodBeat.o(34814);
    return true;
  }
  
  public static boolean bm(bv parambv)
  {
    AppMethodBeat.i(34815);
    if ((parambv != null) && (parambv.cVH()))
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 40))
      {
        AppMethodBeat.o(34815);
        return false;
      }
    }
    AppMethodBeat.o(34815);
    return true;
  }
  
  public static boolean bn(bv parambv)
  {
    AppMethodBeat.i(187171);
    if (parambv == null)
    {
      AppMethodBeat.o(187171);
      return true;
    }
    if ((!an.aUq(parambv.field_talker)) && (!an.aUq(bl.BM(parambv.field_content))))
    {
      AppMethodBeat.o(187171);
      return true;
    }
    if (parambv.cVH())
    {
      Object localObject = k.b.zb(parambv.field_content);
      if (localObject == null)
      {
        AppMethodBeat.o(187171);
        return true;
      }
      if ((((k.b)localObject).type == 6) && (!bu.isNullOrNil(((k.b)localObject).hCI)))
      {
        localObject = m.c(parambv, ((k.b)localObject).dlu);
        if ((localObject != null) && ((!com.tencent.mm.vfs.o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath)) || (com.tencent.mm.vfs.o.aZR(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen)))
        {
          AppMethodBeat.o(187171);
          return false;
        }
      }
      else
      {
        if (((k.b)localObject).type == 19)
        {
          localObject = p.awG(((k.b)localObject).hDg).hFT.iterator();
          ajx localajx;
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localajx = (ajx)((Iterator)localObject).next();
            str = p.c(localajx, parambv.field_msgId);
            if ((!bu.isNullOrNil(localajx.GAS)) && (!com.tencent.mm.vfs.o.fB(str)))
            {
              AppMethodBeat.o(187171);
              return false;
            }
            str = p.f(localajx, parambv.field_msgId);
          } while ((bu.isNullOrNil(localajx.hCJ)) || (com.tencent.mm.vfs.o.fB(str)));
          AppMethodBeat.o(187171);
          return false;
        }
        if (((k.b)localObject).type == 48)
        {
          localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
          if ((localObject == null) || (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hBg)) || (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hBi)))
          {
            ae.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
            AppMethodBeat.o(187171);
            return false;
          }
        }
      }
    }
    if ((parambv.ftg()) && (!bk(parambv)))
    {
      AppMethodBeat.o(187171);
      return false;
    }
    if (((parambv.cyG()) || (parambv.cyI())) && (!bl(parambv)))
    {
      AppMethodBeat.o(187171);
      return false;
    }
    AppMethodBeat.o(187171);
    return true;
  }
  
  public final void a(final T paramT, Context paramContext, final com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34816);
    Object localObject1 = parama.dlw.field_msgId + " ";
    if (((String)localObject1).equals(this.JYv))
    {
      com.tencent.mm.ui.base.t.makeText(paramContext, paramContext.getString(2131758828), 0).show();
      AppMethodBeat.o(34816);
      return;
    }
    this.JYv = ((String)localObject1);
    if (parama.dlw.cVH())
    {
      paramContext = k.b.zb(parama.dlw.field_content);
      Object localObject2;
      if ((paramContext.type == 6) && (!bu.isNullOrNil(paramContext.hCI)))
      {
        localObject1 = m.c(parama.dlw, paramContext.dlu);
        if ((localObject1 != null) && ((!com.tencent.mm.vfs.o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.o.aZR(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
        {
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).fLl = "task_FavMsgHandle_2";
          ((com.tencent.mm.i.g)localObject2).fLm = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34812);
              if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
              {
                this.JVp.field_offset = paramAnonymousc.field_finishedLength;
                ao.bJV().a(this.JVp, new String[0]);
              }
              if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
              {
                this.JVp.field_status = 199L;
                this.JVp.field_offset = this.JVp.field_totalLen;
                ao.bJV().a(this.JVp, new String[0]);
                parama.dlw.setStatus(3);
                bc.aCg();
                com.tencent.mm.model.c.azI().a(parama.dlw.field_msgId, parama.dlw);
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34811);
                    ac.this.a(ac.4.this.JYx, ac.4.this.JYC);
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
          ((com.tencent.mm.i.g)localObject2).field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), parama.dlw.field_talker, parama.dlw.field_msgId);
          ((com.tencent.mm.i.g)localObject2).field_aesKey = paramContext.gmb;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject2).field_authKey = paramContext.hCO;
          ((com.tencent.mm.i.g)localObject2).fLp = paramContext.hCI;
          if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath))) {}
          for (((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;; ((com.tencent.mm.i.g)localObject2).field_fullpath = m.aq(com.tencent.mm.model.c.azY(), paramContext.title, paramContext.hCD))
          {
            if (!f.aGZ().b((com.tencent.mm.i.g)localObject2, -1)) {
              ae.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
            }
            AppMethodBeat.o(34816);
            return;
            bc.aCg();
          }
        }
      }
      else if (paramContext.type == 19)
      {
        localObject1 = p.awG(paramContext.hDg);
        paramContext = new HashSet();
        if ((localObject1 != null) && (((com.tencent.mm.protocal.b.a.c)localObject1).hFT != null))
        {
          localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).hFT.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ajx)((Iterator)localObject1).next();
            String str1 = p.c((ajx)localObject2, parama.dlw.field_msgId);
            String str2;
            if ((!bu.isNullOrNil(((ajx)localObject2).GAS)) && (!com.tencent.mm.vfs.o.fB(str1)))
            {
              str2 = p.g(((ajx)localObject2).dua, parama.dlw.field_msgId, true);
              a(paramT, parama, ((ajx)localObject2).GAS, ((ajx)localObject2).GAP, ((ajx)localObject2).hCO, str1, str2, parama.dlw, paramContext);
            }
            str1 = p.f((ajx)localObject2, parama.dlw.field_msgId);
            if ((!bu.isNullOrNil(((ajx)localObject2).hCJ)) && (!com.tencent.mm.vfs.o.fB(str1)))
            {
              str2 = p.g(p.aha(((ajx)localObject2).dua), parama.dlw.field_msgId, true);
              a(paramT, parama, ((ajx)localObject2).hCJ, ((ajx)localObject2).hCP, ((ajx)localObject2).hCO, str1, str2, parama.dlw, paramContext);
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
    if (parama.dlw.ftg())
    {
      paramContext = q.aIX().F(parama.dlw.field_talker, parama.dlw.field_msgSvrId);
      if (parama.dlw.field_isSend == 1) {
        if (paramContext.aIB())
        {
          i = 1;
          if ((paramContext.offset >= paramContext.hPI) && (paramContext.hPI != 0)) {
            break label806;
          }
          ae.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(parama.dlw.field_msgId) });
          q.aIY().a(paramContext.doE, parama.dlw.field_msgId, i, parama.dlw, 2131231564, new e.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              AppMethodBeat.i(34810);
              ae.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(parama.dlw.field_msgId) });
              AppMethodBeat.o(34810);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn) {}
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(34809);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (boolean bool = true;; bool = false)
              {
                ae.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(parama.dlw.field_msgId), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34808);
                    ac.this.a(ac.3.this.JYx, ac.3.this.JYC);
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
        if (!paramContext.aIB())
        {
          i = 0;
          break;
        }
        localObject1 = h.a(paramContext);
        if (!com.tencent.mm.vfs.o.fB(q.aIX().o(((com.tencent.mm.av.g)localObject1).ico, "", "")))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
    label812:
    if ((parama.dlw.cyG()) || (parama.dlw.cyI()))
    {
      paramContext = u.Ia(parama.dlw.field_imgPath);
      if ((paramContext != null) && (paramContext.status != 199))
      {
        localObject1 = new t.a()
        {
          public final void a(t.a.a paramAnonymousa)
          {
            AppMethodBeat.i(34807);
            if (parama.dlw.field_imgPath.equals(paramAnonymousa.fileName))
            {
              s locals = u.Ia(paramAnonymousa.fileName);
              if ((locals != null) && (locals.aNw()))
              {
                ae.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dlw.field_msgId), paramAnonymousa.fileName });
                com.tencent.mm.modelvideo.o.aNh().a(this);
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34806);
                    ac.this.a(ac.2.this.JYx, ac.2.this.JYy);
                    AppMethodBeat.o(34806);
                  }
                });
                AppMethodBeat.o(34807);
                return;
              }
              ae.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dlw.field_msgId), paramAnonymousa.fileName });
            }
            AppMethodBeat.o(34807);
          }
        };
        com.tencent.mm.modelvideo.o.aNh().a((t.a)localObject1, Looper.getMainLooper());
        ae.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(parama.dlw.field_msgId), parama.dlw.field_imgPath });
        if (paramContext.aNv())
        {
          ae.i("MicroMsg.FavMsgHandle", "start complete online video");
          u.Ih(parama.dlw.field_imgPath);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label984;
        }
        AppMethodBeat.o(34816);
        return;
        ae.i("MicroMsg.FavMsgHandle", "start complete offline video");
        u.HV(parama.dlw.field_imgPath);
        break;
      }
    }
    label984:
    this.JYv = "";
    a(paramT, parama);
    AppMethodBeat.o(34816);
  }
  
  final void a(T paramT, com.tencent.mm.plugin.fav.b.c.a parama)
  {
    AppMethodBeat.i(34818);
    this.JYv = "";
    Object localObject = new cw();
    com.tencent.mm.pluginsdk.model.g.e((cw)localObject, parama.dlw);
    if ((paramT instanceof MMFragment))
    {
      ((cw)localObject).doL.fragment = ((MMFragment)paramT);
      ((cw)localObject).doL.doR = 43;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (((cw)localObject).doM.ret == 0)
      {
        if (!parama.dlw.cVH()) {
          break label510;
        }
        com.tencent.mm.modelstat.b.iqT.c(parama.dlw, l.r(parama.dlw));
      }
    }
    for (;;)
    {
      if ((parama.dlw.cVH()) || (parama.dlw.fta()))
      {
        paramT = z.Br(parama.dlw.field_msgSvrId);
        z.b localb = z.aBG().F(paramT, true);
        localb.k("prePublishId", "msg_" + parama.dlw.field_msgSvrId);
        localb.k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parama.dlw, parama.rCw, parama.rCv));
        localb.k("preChatName", parama.talker);
        localb.k("preMsgIndex", Integer.valueOf(0));
        localb.k("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.ab(j.class)).a("adExtStr", localb, parama.dlw);
        ((cw)localObject).doL.sessionId = paramT;
      }
      localObject = k.b.zb(bu.aSA(parama.dlw.field_content));
      long l;
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        l = bu.aRi();
        ae.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
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
          ae.printErrStackTrace("MicroMsg.FavMsgHandle", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramT, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      if (parama.rCx != null) {
        parama.rCx.cxm();
      }
      a.a(a.c.JRS, a.d.JRX, parama.dlw, 0);
      AppMethodBeat.o(34818);
      return;
      if (!(paramT instanceof Activity)) {
        break;
      }
      ((cw)localObject).doL.activity = ((Activity)paramT);
      break;
      label510:
      com.tencent.mm.modelstat.b.iqT.S(parama.dlw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */