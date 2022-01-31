package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static final SimpleDateFormat nwJ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  private static yp VK(String paramString)
  {
    yp localyp = new yp();
    localyp.Yq(paramString);
    localyp.EQ(1);
    localyp.hl(bk.UY());
    localyp.Ys("");
    return localyp;
  }
  
  private static xv a(bi parambi, g.a parama, int paramInt)
  {
    xv localxv = new xv();
    localxv.XM(ad(parambi));
    localxv.XB(parama.dQU);
    localxv.XC(parama.dQV);
    localxv.XA(parama.url);
    localxv.mj(true);
    parambi = new File(bk.aM(com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true), ""));
    if (parambi.exists()) {
      localxv.XJ(parambi.getAbsolutePath());
    }
    for (;;)
    {
      localxv.Xu(parama.title);
      localxv.Xv(parama.description);
      localxv.EH(paramInt);
      localxv.XT(parama.canvasPageXml);
      return localxv;
      localxv.mk(true);
    }
  }
  
  private static xv a(bi parambi, String paramString, xw paramxw)
  {
    xv localxv = new xv();
    localxv.XM(ad(parambi));
    localxv.EH(1);
    localxv.Xv(paramString);
    localxv.mk(true);
    localxv.mj(true);
    localxv.a(paramxw);
    localxv.XP(a(paramxw.sWd));
    localxv.XQ(b(paramxw.sWd));
    if (ad.aaU(paramxw.sWd.sWB))
    {
      parambi = paramxw.sWd.sWB;
      parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
      if (!bk.bl(parambi)) {
        localxv.XY(parambi);
      }
    }
    return localxv;
  }
  
  private static String a(xx paramxx)
  {
    String str2 = paramxx.sWB;
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = paramxx.bRO;
    }
    if (com.tencent.mm.ai.a.e.lq(str1)) {
      return com.tencent.mm.ai.a.e.ls(str1);
    }
    return r.gU(str1);
  }
  
  private static boolean a(Context paramContext, cj paramcj, bi parambi, int paramInt)
  {
    xw localxw = new xw();
    localxw.c(ac(parambi));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(R.l.app_emoji);
    }
    for (;;)
    {
      paramContext = a(parambi, str, localxw);
      paramcj.bIw.bIy.sXc.add(paramContext);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(R.l.app_pay);
      } else if (paramInt == 3) {
        str = paramContext.getString(R.l.app_special);
      }
    }
  }
  
  private static boolean a(Context paramContext, cj paramcj, bi parambi, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramcj == null) || (parambi == null))
    {
      y.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      bool2 = bool1;
      if (paramcj != null)
      {
        paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
        bool2 = bool1;
      }
      return bool2;
    }
    bi localbi = bi.ak(parambi);
    if (localbi.isText())
    {
      localObject = new xw();
      ((xw)localObject).c(ac(localbi));
      parambi = new xv();
      parambi.XM(ad(localbi));
      parambi.EH(1);
      if (localbi.cvJ())
      {
        paramContext = ae.getContext().getString(R.l.room_notice_at_all, new Object[] { "@" }) + '\n';
        label152:
        if (localbi.cvB()) {
          break label353;
        }
        parambi.Xv(paramContext + localbi.field_content);
        label187:
        parambi.mk(true);
        parambi.mj(true);
        parambi.a((xw)localObject);
        parambi.XP(a(((xw)localObject).sWd));
        parambi.XQ(b(((xw)localObject).sWd));
        if (ad.aaU(((xw)localObject).sWd.sWB))
        {
          paramContext = ((xw)localObject).sWd.sWB;
          paramContext = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramContext));
          if (!bk.bl(paramContext)) {
            parambi.XY(paramContext);
          }
        }
        paramcj.bIw.bIy.sXc.add(parambi);
        paramContext = paramcj.bIw.bIz;
        paramContext.sXr += 1;
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      com.tencent.mm.plugin.fav.ui.c.a(localbi, paramcj, bool1);
      return bool1;
      paramContext = "";
      break label152;
      label353:
      parambi.Xv(paramContext + localbi.field_content + "\n\n" + localbi.field_transContent);
      break label187;
      if (localbi.ctA())
      {
        localObject = new xw();
        ((xw)localObject).c(ac(localbi));
        parambi = new xv();
        parambi.XM(ad(localbi));
        parambi.EH(3);
        if (paramBoolean)
        {
          parambi.mk(true);
          parambi.mj(true);
        }
        for (;;)
        {
          parambi.a((xw)localObject);
          parambi.XP(a(((xw)localObject).sWd));
          parambi.XQ(b(((xw)localObject).sWd));
          if (ad.aaU(((xw)localObject).sWd.sWB))
          {
            paramContext = ((xw)localObject).sWd.sWB;
            paramContext = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramContext));
            if (!bk.bl(paramContext)) {
              parambi.XY(paramContext);
            }
          }
          paramcj.bIw.bIy.sXc.add(parambi);
          paramContext = paramcj.bIw.bIz;
          paramContext.sXt += 1;
          bool1 = true;
          break;
          if (com.tencent.mm.model.s.hH(localbi.field_talker))
          {
            paramContext = localbi.field_imgPath;
            au.Hx();
            paramContext = h.b(com.tencent.mm.model.c.FJ(), "recbiz_", paramContext, ".rec", 2);
            if (bk.bl(paramContext))
            {
              paramContext = null;
              label641:
              parambi.XI(paramContext);
            }
          }
          for (;;)
          {
            parambi.mk(true);
            paramContext = com.tencent.mm.modelvoice.q.ox(localbi.field_imgPath);
            if (paramContext != null) {
              break label703;
            }
            bool1 = false;
            break;
            new File(paramContext).exists();
            break label641;
            parambi.XI(com.tencent.mm.modelvoice.q.getFullPath(localbi.field_imgPath));
          }
          label703:
          parambi.XE(e.DC(paramContext.getFormat()));
          parambi.EG((int)new n(localbi.field_content).time);
        }
      }
      if (localbi.aVM())
      {
        bool1 = b(paramcj, localbi);
      }
      else
      {
        if (!localbi.ctB()) {
          break label1368;
        }
        parambi = null;
        if (localbi.field_msgId > 0L) {
          parambi = com.tencent.mm.as.o.OJ().bY((int)localbi.field_msgId);
        }
        if (parambi != null)
        {
          paramContext = parambi;
          if (parambi.enp > 0L) {}
        }
        else
        {
          paramContext = parambi;
          if (localbi.field_msgSvrId > 0L) {
            paramContext = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
          }
        }
        if (paramContext != null) {
          break label863;
        }
        y.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
        paramcj.bIw.bIC = R.l.favorite_fail_image_not_exists;
        bool1 = bool2;
      }
    }
    label863:
    Object localObject = new xw();
    ((xw)localObject).c(ac(localbi));
    parambi = new xv();
    parambi.XM(ad(localbi));
    parambi.EH(2);
    parambi.XI(com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c(paramContext), "", ""));
    if (paramContext.Or())
    {
      com.tencent.mm.as.e locale = com.tencent.mm.as.o.OJ().iH(paramContext.enz);
      if (locale.ebK > locale.offset) {
        parambi.XI(com.tencent.mm.as.o.OJ().o("SERVERID://" + localbi.field_msgSvrId, "", ""));
      }
    }
    parambi.XJ(com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true));
    parambi.a((xw)localObject);
    parambi.XP(a(((xw)localObject).sWd));
    parambi.XQ(b(((xw)localObject).sWd));
    parambi.hh(localbi.field_msgId);
    if (ad.aaU(((xw)localObject).sWd.sWB))
    {
      localObject = ((xw)localObject).sWd.sWB;
      localObject = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject));
      if (!bk.bl((String)localObject)) {
        parambi.XY((String)localObject);
      }
    }
    if (paramBoolean)
    {
      if ((!paramContext.Or()) || (paramContext.ebK != 0)) {
        break label1935;
      }
      paramContext = com.tencent.mm.as.o.OJ().iH(paramContext.enz);
    }
    label1166:
    label1935:
    for (;;)
    {
      int i;
      if (localbi.field_isSend == 1) {
        if (paramContext.Or())
        {
          i = 1;
          localObject = bn.s(paramContext.enA, "msg");
          if (localObject == null) {
            break label1345;
          }
          if (i == 1)
          {
            parambi.Xy((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
            parambi.hf(bk.getInt((String)((Map)localObject).get(".msg.img.$length"), 0));
            parambi.Xz((String)((Map)localObject).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcj.bIw.bIy.sXc.add(parambi);
        paramContext = paramcj.bIw.bIz;
        paramContext.sXs += 1;
        bool1 = true;
        break;
        i = 0;
        break label1166;
        if (!paramContext.Or())
        {
          i = 0;
          break label1166;
        }
        localObject = com.tencent.mm.as.f.a(paramContext);
        if (!com.tencent.mm.a.e.bK(com.tencent.mm.as.o.OJ().o(((com.tencent.mm.as.e)localObject).enq, "", "")))
        {
          i = 0;
          break label1166;
        }
        i = 1;
        break label1166;
        label1345:
        y.i("MicroMsg.GetFavRecordDataSource", "parse cdnInfo failed. [%s]", new Object[] { paramContext.enA });
      }
      label1368:
      if (localbi.aRQ())
      {
        bool1 = a(paramcj, localbi, paramBoolean);
        break;
      }
      if (localbi.aRR())
      {
        bool1 = a(paramcj, localbi, paramBoolean);
        break;
      }
      if ((paramBoolean) && (localbi.getType() == 318767153)) {
        return a(paramContext, paramcj, localbi, 3);
      }
      if (localbi.ctz())
      {
        bool1 = c(paramcj, localbi);
        break;
      }
      if ((paramBoolean) && ((localbi.cvo()) || (localbi.cvp())))
      {
        bool1 = a(paramContext, paramcj, localbi, 1);
        break;
      }
      if ((paramBoolean) && (localbi.getType() == 419430449))
      {
        bool1 = a(paramContext, paramcj, localbi, 2);
        break;
      }
      if (localbi.cvn())
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.Fy().HN(localbi.field_content);
        parambi = new xw();
        parambi.c(ac(localbi));
        if ((localObject != null) && (com.tencent.mm.model.s.hI(((bi.a)localObject).qZn)))
        {
          paramContext = new xv();
          paramContext.XM(ad(localbi));
          paramContext.EH(16);
          paramContext.Xv(localbi.field_content);
          paramContext.mk(true);
          paramContext.mj(true);
          paramContext.a(parambi);
          paramContext.XP(a(parambi.sWd));
          paramContext.XQ(b(parambi.sWd));
          if (!ad.aaU(parambi.sWd.sWB)) {
            break label1932;
          }
          parambi = parambi.sWd.sWB;
          parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
          if (!bk.bl(parambi)) {
            paramContext.XY(parambi);
          }
        }
      }
      for (;;)
      {
        paramcj.bIw.bIy.sXc.add(paramContext);
        paramContext = paramcj.bIw.bIz;
        paramContext.sXF += 1;
        bool1 = true;
        break;
        if ((localObject != null) && (ad.aaU(((bi.a)localObject).pyp)))
        {
          localObject = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).a(((bi.a)localObject).uCa, "openim_card_type_name", b.a.ePI);
          if (TextUtils.isEmpty((CharSequence)localObject)) {}
          for (paramContext = paramContext.getResources().getString(R.l.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { localObject }))
          {
            paramContext = a(localbi, paramContext, parambi);
            break;
          }
        }
        paramContext = a(localbi, paramContext.getString(R.l.app_friend_card_personal), parambi);
        continue;
        if (localbi.aVK())
        {
          if (localbi.cvp())
          {
            paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
            bool1 = bool2;
            break;
          }
          bool1 = b(paramContext, paramcj, localbi, paramBoolean);
          break;
        }
        paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
        bool1 = bool2;
        if (!paramBoolean) {
          break;
        }
        bool1 = a(paramContext, paramcj, localbi, 3);
        break;
      }
    }
  }
  
  public static boolean a(Context paramContext, cj paramcj, String paramString, List<bi> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      y.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
      paramBoolean1 = false;
    }
    label599:
    do
    {
      int i;
      do
      {
        return paramBoolean1;
        Object localObject1 = paramList.iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bi)((Iterator)localObject1).next();
          if (bf.k((bi)localObject2)) {
            switch (((bi)localObject2).getType() & 0xFFFF)
            {
            default: 
              break;
            case 1: 
              ((bi)localObject2).setContent(paramContext.getString(R.l.app_text));
              break;
            case 3: 
              ((bi)localObject2).setContent(paramContext.getString(R.l.app_pic));
              ((bi)localObject2).setType(1);
              break;
            case 43: 
              ((bi)localObject2).setContent(paramContext.getString(R.l.app_video));
              ((bi)localObject2).setType(1);
              break;
            case 49: 
              ((bi)localObject2).setContent(paramContext.getString(R.l.app_unknown_msg));
              ((bi)localObject2).setType(1);
            }
          }
        }
        boolean bool = com.tencent.mm.ai.f.eW(paramString);
        if ((paramList.size() == 1) && (!paramBoolean2))
        {
          paramList = (bi)paramList.get(0);
          if (paramList.ctz())
          {
            localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(paramList.field_msgId, paramList.field_content);
            if ((((l)localObject1).dTx != null) && (((l)localObject1).dTx.size() == 1)) {
              return e.a(paramcj, paramList);
            }
            paramcj.bIw.bIy = new yj();
            paramcj.bIw.bIz = new yx();
            paramcj.bIw.bIy.a(VK(paramString));
            paramcj.bIw.type = 14;
            return a(paramContext, paramcj, paramList, paramBoolean1);
          }
          return e.a(paramcj, paramList);
        }
        paramcj.bIw.bIy = new yj();
        paramcj.bIw.bIz = new yx();
        if (paramContext != null)
        {
          if (!bool) {
            break label599;
          }
          localObject1 = com.tencent.mm.ai.a.e.bS(((bi)paramList.get(0)).field_bizChatId);
          if (com.tencent.mm.ai.a.e.lr((String)localObject1))
          {
            paramcj.bIw.bIy.Yo(paramContext.getString(R.l.record_chatroom_title));
            y.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcj.bIw.bIy.title });
          }
        }
        else
        {
          paramcj.bIw.bIy.a(VK(paramString));
          paramcj.bIw.type = 14;
          paramString = paramList.iterator();
          i = 0;
          paramBoolean2 = true;
        }
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label724;
          }
          if (a(paramContext, paramcj, (bi)paramString.next(), paramBoolean1))
          {
            i = 1;
            continue;
            localObject2 = com.tencent.mm.ai.a.e.lu(paramString);
            if (localObject2 == null) {
              break;
            }
            paramcj.bIw.bIy.Yo(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { ((com.tencent.mm.ai.a.j)localObject2).field_userName, com.tencent.mm.ai.a.e.ls((String)localObject1) }));
            break;
            if (com.tencent.mm.model.s.fn(paramString))
            {
              paramcj.bIw.bIy.Yo(paramContext.getString(R.l.record_chatroom_title));
              break;
            }
            localObject1 = bk.pm(com.tencent.mm.model.q.Gl());
            if (((String)localObject1).equals(bk.pm(r.gU(paramString))))
            {
              paramcj.bIw.bIy.Yo(paramContext.getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 }));
              break;
            }
            paramcj.bIw.bIy.Yo(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { com.tencent.mm.model.q.Gl(), r.gU(paramString) }));
            break;
          }
          paramBoolean2 = false;
        }
        paramBoolean1 = paramBoolean2;
      } while (i == 0);
      paramBoolean1 = paramBoolean2;
    } while (paramcj.bIw.bIC <= 0);
    label724:
    paramcj.bIw.bIC = 0;
    return paramBoolean2;
  }
  
  private static boolean a(cj paramcj, bi parambi, boolean paramBoolean)
  {
    Object localObject2 = new xw();
    ((xw)localObject2).c(ac(parambi));
    xv localxv = new xv();
    localxv.XM(ad(parambi));
    com.tencent.mm.modelvideo.o.Sr();
    localxv.XI(t.nS(parambi.field_imgPath));
    com.tencent.mm.modelvideo.o.Sr();
    localxv.XJ(t.nT(parambi.field_imgPath));
    localxv.XE(com.tencent.mm.a.e.bM(localxv.sVe));
    if (parambi.aRR()) {
      localxv.EH(15);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = u.oe(parambi.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      y.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcj.bIw.bIC = R.l.favorite_fail;
      return false;
      localxv.EH(4);
    }
    y.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject1).ebK) });
    if (((com.tencent.mm.modelvideo.s)localObject1).ebK > com.tencent.mm.m.b.Ai())
    {
      paramcj.bIw.bIC = R.l.favorite_too_large;
      return false;
    }
    if ((parambi.aRR()) && (u.og(((com.tencent.mm.modelvideo.s)localObject1).getFileName())))
    {
      paramcj.bIw.bIC = R.l.favorite_fail;
      return false;
    }
    localxv.EG(((com.tencent.mm.modelvideo.s)localObject1).eHH);
    localxv.a((xw)localObject2);
    localxv.XP(a(((xw)localObject2).sWd));
    localxv.XQ(b(((xw)localObject2).sWd));
    if (ad.aaU(((xw)localObject2).sWd.sWB))
    {
      localObject2 = ((xw)localObject2).sWd.sWB;
      localObject2 = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject2));
      if (!bk.bl((String)localObject2)) {
        localxv.XY((String)localObject2);
      }
    }
    localxv.hh(parambi.field_msgId);
    localxv.hf(((com.tencent.mm.modelvideo.s)localObject1).ebK);
    if (paramBoolean)
    {
      localObject1 = bn.s(((com.tencent.mm.modelvideo.s)localObject1).SD(), "msg");
      if (localObject1 == null) {
        break label549;
      }
      localxv.Xy((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localxv.Xz((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
      paramcj.bIw.bIy.sXc.add(localxv);
      paramcj = paramcj.bIw.bIz;
      paramcj.sXu += 1;
      paramcj = u.oe(parambi.field_imgPath);
      localxv.XS(paramcj.bYN);
      paramcj = paramcj.eHQ;
      if ((paramcj != null) && (!bk.bl(paramcj.dSV)))
      {
        parambi = new xy();
        parambi.dSP = paramcj.dSP;
        parambi.sWK = paramcj.sWK;
        parambi.dSS = paramcj.dSS;
        parambi.dST = paramcj.dST;
        parambi.dSR = paramcj.dSR;
        parambi.dSU = paramcj.dSU;
        parambi.dSV = paramcj.dSV;
        parambi.dSW = paramcj.dSW;
        localxv.a(parambi);
      }
      return true;
      label549:
      y.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
    }
  }
  
  private static xx ac(bi parambi)
  {
    xx localxx = new xx();
    if (parambi == null) {
      return localxx;
    }
    Object localObject;
    if (parambi.field_isSend == 0)
    {
      localxx.XZ(parambi.field_talker);
      localxx.Ya(com.tencent.mm.model.q.Gj());
      if (com.tencent.mm.model.s.fn(parambi.field_talker))
      {
        if (parambi.field_content == null) {
          break label325;
        }
        localObject = parambi.field_content.substring(0, Math.max(0, parambi.field_content.indexOf(':')));
        localxx.Yc((String)localObject);
        if ((!bk.bl(localxx.sWB)) && (!parambi.ctA()))
        {
          parambi.setContent(parambi.field_content.substring(localxx.sWB.length() + 1));
          if ((parambi.field_content.length() > 0) && ('\n' == parambi.field_content.charAt(0))) {
            parambi.setContent(parambi.field_content.substring(1));
          }
          if (parambi.cvw())
          {
            parambi.ef(parambi.field_transContent.substring(localxx.sWB.length() + 1));
            if ((parambi.field_transContent.length() > 0) && ('\n' == parambi.field_transContent.charAt(0))) {
              parambi.ef(parambi.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.ai.f.eW(parambi.field_talker))
      {
        String str = parambi.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.model.bd.iM(parambi.czr).userId;
        }
        localxx.Yc((String)localObject);
      }
      localxx.EL(1);
      localxx.hi(parambi.field_createTime);
      localxx.Yd(parambi.field_msgSvrId);
      if (parambi.field_msgSvrId > 0L) {
        localxx.Yb(parambi.field_msgSvrId);
      }
      return localxx;
      label325:
      localObject = "";
      break;
      localxx.XZ(com.tencent.mm.model.q.Gj());
      localxx.Ya(parambi.field_talker);
      if (com.tencent.mm.model.s.fn(parambi.field_talker)) {
        localxx.Yc(localxx.bRO);
      }
    }
  }
  
  private static String ad(bi parambi)
  {
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.s.fn(parambi.field_talker)) || (parambi.field_talker.equals("filehelper"))) {
        return String.format("%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
      }
      return String.format("%s#%d", new Object[] { parambi.field_talker, Long.valueOf(parambi.field_msgSvrId) });
    }
    return String.valueOf(parambi.field_msgSvrId);
  }
  
  private static String b(xx paramxx)
  {
    return nwJ.format(new Date(paramxx.createTime));
  }
  
  private static boolean b(Context paramContext, cj paramcj, bi parambi, boolean paramBoolean)
  {
    xw localxw = new xw();
    localxw.c(ac(parambi));
    Object localObject1 = parambi.field_content;
    if (localObject1 == null)
    {
      paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
      return false;
    }
    localObject1 = g.a.gp((String)localObject1);
    if (localObject1 == null)
    {
      paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
      return false;
    }
    localxw.sWd.Ye(((g.a)localObject1).appId);
    localxw.sWd.Yg(((g.a)localObject1).bYG);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, true);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).ZH()) && (paramBoolean))
    {
      paramContext = a(parambi, paramContext.getString(R.l.app_game), localxw);
      paramcj.bIw.bIy.sXc.add(paramContext);
      return true;
    }
    switch (((g.a)localObject1).type)
    {
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 34: 
    case 35: 
    default: 
      if (paramBoolean)
      {
        paramContext = a(parambi, paramContext.getString(R.l.app_special), localxw);
        paramcj.bIw.bIy.sXc.add(paramContext);
        return true;
      }
      break;
    case 1: 
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      paramContext.EH(1);
      paramContext.Xv(((g.a)localObject1).title);
      paramContext.mk(true);
      paramContext.mj(true);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXr += 1;
      return true;
    case 2: 
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
        return false;
      }
      localObject2 = ap.avh().VQ(((g.a)localObject1).bFE);
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      if (localObject2 != null) {
        paramContext.XI(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
      if (com.tencent.mm.a.e.bK((String)localObject2)) {
        paramContext.XJ((String)localObject2);
      }
      paramContext.EH(2);
      paramContext.Xu(((g.a)localObject1).title);
      paramContext.Xv(((g.a)localObject1).description);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      paramContext.hh(parambi.field_msgId);
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXs += 1;
      return true;
    case 3: 
      paramContext = a(parambi, (g.a)localObject1, 7);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXx += 1;
      return true;
    case 4: 
      paramContext = a(parambi, (g.a)localObject1, 4);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      paramContext.hh(parambi.field_msgId);
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXu += 1;
      return true;
    case 5: 
      if ((((g.a)localObject1).url != null) && (!((g.a)localObject1).url.equals("")))
      {
        localxw.sWd.Yf(((g.a)localObject1).url);
        paramContext = a(parambi, (g.a)localObject1, 5);
        paramContext.a(localxw);
        paramContext.XP(a(localxw.sWd));
        paramContext.XQ(b(localxw.sWd));
        if (ad.aaU(localxw.sWd.sWB))
        {
          parambi = localxw.sWd.sWB;
          parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
          if (!bk.bl(parambi)) {
            paramContext.XY(parambi);
          }
        }
        parambi = new yy();
        if (!bk.bl(((g.a)localObject1).title)) {
          parambi.YD(((g.a)localObject1).title);
        }
        if (!bk.bl(((g.a)localObject1).description)) {
          parambi.YE(((g.a)localObject1).description);
        }
        if (!bk.bl(((g.a)localObject1).thumburl)) {
          parambi.YG(((g.a)localObject1).thumburl);
        }
        if (!bk.bl(((g.a)localObject1).canvasPageXml)) {
          parambi.YH(((g.a)localObject1).canvasPageXml);
        }
        if (parambi.btq() > 0)
        {
          parambi.ER(1);
          localxw.a(parambi);
        }
        paramcj.bIw.bIy.sXc.add(paramContext);
        paramContext = paramcj.bIw.bIz;
        paramContext.sXv += 1;
        return true;
      }
      paramcj.bIw.bIC = R.l.favorite_fail_empty_url;
      if (paramBoolean)
      {
        paramContext = a(parambi, paramContext.getString(R.l.app_special), localxw);
        paramcj.bIw.bIy.sXc.add(paramContext);
        return true;
      }
      return false;
    case 6: 
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
        return false;
      }
      localObject2 = ap.avh().VQ(((g.a)localObject1).bFE);
      paramContext = new xv();
      if (localObject2 != null) {
        paramContext.XI(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      }
      paramContext.XM(ad(parambi));
      paramContext.EH(8);
      paramContext.XE(((g.a)localObject1).dQw);
      localObject2 = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
      if (bk.bl((String)localObject2)) {
        paramContext.mk(true);
      }
      if (com.tencent.mm.a.e.bK((String)localObject2)) {
        paramContext.XJ((String)localObject2);
      }
      paramContext.Xu(((g.a)localObject1).title);
      paramContext.Xv(((g.a)localObject1).description);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      paramContext.hh(parambi.field_msgId);
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      if (paramBoolean)
      {
        paramContext.Xy(((g.a)localObject1).dQK);
        paramContext.Xz(((g.a)localObject1).dQR);
        paramContext.XX(((g.a)localObject1).dQB);
        paramContext.XV(((g.a)localObject1).dQR);
        paramContext.XW(((g.a)localObject1).dQH);
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXy += 1;
      return true;
    case 7: 
      if ((((g.a)localObject1).bFE == null) || (((g.a)localObject1).bFE.length() == 0)) {
        paramcj.bIw.bIC = R.l.favorite_fail_attachment_not_exists;
      }
      do
      {
        paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
        return false;
        au.Hx();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
      return false;
    case 10: 
      paramContext = new yi();
      paramContext.Yj(((g.a)localObject1).title);
      paramContext.Yk(((g.a)localObject1).description);
      paramContext.EN(((g.a)localObject1).dQY);
      paramContext.Ym(((g.a)localObject1).dQZ);
      paramContext.Yl(((g.a)localObject1).thumburl);
      localxw.a(paramContext);
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      paramContext.EH(10);
      paramContext.mk(true);
      paramContext.mj(true);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXA += 1;
      return true;
    case 20: 
      paramContext = new ys();
      paramContext.Yz(((g.a)localObject1).title);
      paramContext.YA(((g.a)localObject1).description);
      paramContext.YC(((g.a)localObject1).dRc);
      paramContext.YB(((g.a)localObject1).thumburl);
      localxw.a(paramContext);
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      paramContext.EH(14);
      paramContext.mk(true);
      paramContext.mj(true);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXE += 1;
      return true;
    case 13: 
      paramContext = new yi();
      paramContext.Yj(((g.a)localObject1).title);
      paramContext.Yk(((g.a)localObject1).description);
      paramContext.EN(((g.a)localObject1).dRe);
      paramContext.Ym(((g.a)localObject1).dRf);
      paramContext.Yl(((g.a)localObject1).thumburl);
      localxw.a(paramContext);
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      paramContext.EH(11);
      paramContext.mk(true);
      paramContext.mj(true);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      paramContext = paramcj.bIw.bIz;
      paramContext.sXB += 1;
      return true;
    case 33: 
    case 36: 
      if ((((g.a)localObject1).dTa == 3) && (paramBoolean))
      {
        paramContext = a(parambi, paramContext.getString(R.l.app_not_show), localxw);
        paramcj.bIw.bIy.sXc.add(paramContext);
        return true;
      }
      paramContext = new xv();
      paramContext.XM(ad(parambi));
      paramContext.Xu(((g.a)localObject1).title);
      paramContext.Xv(((g.a)localObject1).description);
      paramContext.EH(19);
      localObject2 = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
      if (bk.bl((String)localObject2)) {
        paramContext.mk(true);
      }
      if (com.tencent.mm.a.e.bK((String)localObject2)) {
        paramContext.XJ((String)localObject2);
      }
      localObject2 = new xt();
      if (!bk.bl(((g.a)localObject1).dSY)) {
        ((xt)localObject2).username = ((g.a)localObject1).dSY;
      }
      if (!bk.bl(((g.a)localObject1).dSZ)) {
        ((xt)localObject2).appId = ((g.a)localObject1).dSZ;
      }
      if (!bk.bl(((g.a)localObject1).dTh)) {
        ((xt)localObject2).iconUrl = ((g.a)localObject1).dTh;
      }
      ((xt)localObject2).type = ((g.a)localObject1).dTa;
      ((xt)localObject2).bOa = ((g.a)localObject1).dTc;
      ((xt)localObject2).bFw = ((g.a)localObject1).dSX;
      ((xt)localObject2).sUv = ((g.a)localObject1).bYH;
      localxw.a((xt)localObject2);
      paramContext.a(localxw);
      paramContext.XP(a(localxw.sWd));
      paramContext.XQ(b(localxw.sWd));
      paramContext.hh(parambi.field_msgId);
      if (ad.aaU(localxw.sWd.sWB))
      {
        parambi = localxw.sWd.sWB;
        parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
        if (!bk.bl(parambi)) {
          paramContext.XY(parambi);
        }
      }
      paramcj.bIw.bIy.sXc.add(paramContext);
      return true;
    case 19: 
      int i;
      if ((((g.a)localObject1).dRd != null) && (((g.a)localObject1).dRd.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
      {
        localObject2 = new xv();
        ((xv)localObject2).XM(ad(parambi));
        ((xv)localObject2).EH(17);
        ((xv)localObject2).mk(true);
        ((xv)localObject2).Xu(((g.a)localObject1).title);
        ((xv)localObject2).XU(((g.a)localObject1).dRd);
        paramContext = ((g.a)localObject1).description;
        Object localObject3 = new nd();
        ((nd)localObject3).bWJ.type = 0;
        ((nd)localObject3).bWJ.bWL = ((g.a)localObject1).dRd;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((nd)localObject3).bWK.bWT;
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).dTx.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bk.bl(((xv)((Iterator)localObject3).next()).sVY))
              {
                paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label3258;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label3258:
    for (;;)
    {
      ((xv)localObject2).Xv(paramContext);
      ((xv)localObject2).a(localxw);
      ((xv)localObject2).XP(a(localxw.sWd));
      ((xv)localObject2).XQ(b(localxw.sWd));
      ((xv)localObject2).hh(parambi.field_msgId);
      if (ad.aaU(localxw.sWd.sWB))
      {
        paramContext = localxw.sWd.sWB;
        paramContext = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramContext));
        if (!bk.bl(paramContext)) {
          ((xv)localObject2).XY(paramContext);
        }
      }
      paramcj.bIw.bIy.sXc.add(localObject2);
      return true;
      if (paramBoolean)
      {
        paramContext = a(parambi, paramContext.getString(R.l.favorite_wenote_msg), localxw);
        paramcj.bIw.bIy.sXc.add(paramContext);
        return true;
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = a(parambi, paramContext.getString(R.l.app_product_card_ticket), localxw);
      paramcj.bIw.bIy.sXc.add(paramContext);
      return true;
      paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
      return false;
    }
  }
  
  private static boolean b(cj paramcj, bi parambi)
  {
    xw localxw = new xw();
    localxw.c(ac(parambi));
    Object localObject = bn.s(parambi.field_content, "msg");
    if (localObject != null) {
      try
      {
        yc localyc = new yc();
        localyc.Yh((String)((Map)localObject).get(".msg.location.$label"));
        localyc.z(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localyc.y(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localyc.EM(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localyc.Yi((String)((Map)localObject).get(".msg.location.$poiname"));
        localxw.a(localyc);
        localObject = new xv();
        ((xv)localObject).XM(ad(parambi));
        ((xv)localObject).EH(6);
        ((xv)localObject).mk(true);
        ((xv)localObject).mj(true);
        ((xv)localObject).a(localxw);
        ((xv)localObject).XP(a(localxw.sWd));
        ((xv)localObject).XQ(b(localxw.sWd));
        if (ad.aaU(localxw.sWd.sWB))
        {
          parambi = localxw.sWd.sWB;
          parambi = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi));
          if (!bk.bl(parambi)) {
            ((xv)localObject).XY(parambi);
          }
        }
        paramcj.bIw.bIy.sXc.add(localObject);
        parambi = paramcj.bIw.bIz;
        parambi.sXw += 1;
        return true;
      }
      catch (Exception parambi)
      {
        y.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambi.getStackTrace().toString() });
      }
    }
    paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
    return false;
  }
  
  private static boolean c(cj paramcj, bi parambi)
  {
    for (;;)
    {
      try
      {
        l locall = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
        localObject = locall.dTx;
        int i;
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label527;
          }
          m localm = (m)localIterator.next();
          if (i.gr(localm.dTI)) {
            continue;
          }
          xw localxw = new xw();
          localxw.c(ac(parambi));
          localxw.sWd.Yg(locall.bYG);
          localxw.sWd.Yf(localm.url);
          xv localxv = new xv();
          localxv.Xu(localm.title);
          localxv.Xv(localm.dTF);
          localxv.XM(ad(parambi));
          if (!bk.bl(localm.dTD))
          {
            String str = localm.dTD;
            int j = parambi.getType();
            if (i != 0) {
              break label545;
            }
            localObject = "@T";
            localxv.XJ(q.y(str, j, (String)localObject));
            localxv.mj(true);
            localObject = new yy();
            if (!bk.bl(localm.title)) {
              ((yy)localObject).YD(localm.title);
            }
            if (!bk.bl(localm.dTF)) {
              ((yy)localObject).YE(localm.dTF);
            }
            if (!bk.bl(localm.dTD)) {
              ((yy)localObject).YG(localm.dTD);
            }
            if (((yy)localObject).btq() > 0)
            {
              ((yy)localObject).ER(1);
              localxw.a((yy)localObject);
            }
            localxv.EH(5);
            localxv.a(localxw);
            localxv.XP(a(localxw.sWd));
            localxv.XQ(b(localxw.sWd));
            if (ad.aaU(localxw.sWd.sWB))
            {
              localObject = localxw.sWd.sWB;
              localObject = com.tencent.mm.openim.room.a.a.z(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject));
              if (!bk.bl((String)localObject)) {
                localxv.XY((String)localObject);
              }
            }
            paramcj.bIw.bIy.sXc.add(localxv);
            localObject = paramcj.bIw.bIz;
            ((yx)localObject).sXv += 1;
            i += 1;
            continue;
          }
          localxv.mk(true);
          continue;
        }
        if (i != 0) {
          break label543;
        }
      }
      catch (Exception parambi)
      {
        y.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambi, "", new Object[0]);
        y.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambi.getLocalizedMessage() });
        paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
        return false;
      }
      label527:
      paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
      return false;
      label543:
      return true;
      label545:
      Object localObject = "@S";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */