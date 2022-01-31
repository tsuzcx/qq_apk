package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.n;
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
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e
{
  public static String DC(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static xv a(xv paramxv, int paramInt)
  {
    xv localxv = p(paramxv);
    localxv.EH(paramInt);
    if ((paramxv.sVA != null) && (paramxv.sVA.sWj != null))
    {
      yi localyi = new yi();
      localyi.Yj(paramxv.sVA.sWj.title);
      localyi.Yk(paramxv.sVA.sWj.desc);
      localyi.EN(paramxv.sVA.sWj.type);
      localyi.Ym(paramxv.sVA.sWj.info);
      localyi.Yl(paramxv.sVA.sWj.thumbUrl);
      localxv.sVA.a(localyi);
    }
    return localxv;
  }
  
  private static xv a(bi parambi, g.a parama, int paramInt)
  {
    xv localxv = new xv();
    a(localxv, parambi);
    localxv.XB(parama.dQU);
    localxv.XC(parama.dQV);
    localxv.XA(parama.url);
    localxv.mj(true);
    parambi = new com.tencent.mm.vfs.b(bk.aM(com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true), ""));
    if (parambi.exists()) {
      localxv.XJ(com.tencent.mm.vfs.j.n(parambi.cLr()));
    }
    for (;;)
    {
      localxv.Xu(parama.title);
      localxv.Xv(parama.description);
      localxv.XT(parama.canvasPageXml);
      localxv.EH(paramInt);
      localxv.XS(parama.bYN);
      return localxv;
      localxv.mk(true);
    }
  }
  
  private static void a(xv paramxv1, xv paramxv2)
  {
    paramxv1.XB(paramxv2.sUP);
    paramxv1.XC(paramxv2.sUR);
    paramxv1.XA(paramxv2.sUN);
    paramxv1.Xu(paramxv2.title);
    paramxv1.Xv(paramxv2.desc);
  }
  
  private static void a(xv paramxv, bi parambi)
  {
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.s.fn(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
      {
        paramxv.XM(String.valueOf(parambi.field_msgSvrId));
        return;
      }
      paramxv.XM(parambi.field_talker + "#" + String.valueOf(parambi.field_msgSvrId));
      return;
    }
    paramxv.XM(String.valueOf(parambi.field_msgSvrId));
  }
  
  public static boolean a(cj paramcj, int paramInt, String paramString)
  {
    if ((paramcj == null) || (bk.bl(paramString)))
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcj != null) {
        paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
      }
      return false;
    }
    y.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localxv.EH(2);
    localxv.XI(paramString);
    localxv.XH(com.tencent.mm.a.g.o((localxv.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gf();
    ((gf)localObject).bNF.type = 27;
    ((gf)localObject).bNF.bNH = localxv;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gf)localObject).bNG.thumbPath;
    com.tencent.mm.sdk.platformtools.c.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localxv.XJ((String)localObject);
    localyp.Yq(com.tencent.mm.model.q.Gj());
    localyp.Yr(com.tencent.mm.model.q.Gj());
    localyp.EQ(paramInt);
    localyp.hl(bk.UY());
    localyj.a(localyp);
    localyj.sXc.add(localxv);
    paramcj.bIw.title = localxv.title;
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.type = 2;
    return true;
  }
  
  public static boolean a(cj paramcj, long paramLong)
  {
    return a(paramcj, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(paramLong));
  }
  
  public static boolean a(cj paramcj, Intent paramIntent)
  {
    if (paramcj == null)
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bk.aM(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new yc();
    paramIntent.Yh((String)localObject1);
    paramIntent.z(d1);
    paramIntent.y(d2);
    paramIntent.EM(i);
    paramIntent.Yi((String)localObject2);
    localObject1 = new yj();
    localObject2 = new yp();
    String str = com.tencent.mm.model.q.Gj();
    ((yp)localObject2).Yq(str);
    ((yp)localObject2).Yr(str);
    ((yp)localObject2).EQ(6);
    ((yp)localObject2).hl(bk.UY());
    ((yj)localObject1).b(paramIntent);
    ((yj)localObject1).a((yp)localObject2);
    paramcj.bIw.bIy = ((yj)localObject1);
    paramcj.bIw.type = 6;
    return true;
  }
  
  private static boolean a(cj paramcj, g.a parama, yj paramyj, bi parambi)
  {
    Object localObject1 = new nd();
    ((nd)localObject1).bWJ.type = 0;
    ((nd)localObject1).bWJ.bWL = parama.dRd;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((nd)localObject1).bWK.bWT;
    if (localc == null)
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
      return false;
    }
    paramyj.Yo(localc.title);
    Iterator localIterator = localc.dTx.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = (xv)localIterator.next();
      switch (((xv)localObject1).aYU)
      {
      case 9: 
      case 13: 
      case 18: 
      default: 
        parama = null;
        label222:
        if (parama != null) {
          if (parambi.field_isSend == 1) {
            if ((com.tencent.mm.model.s.fn(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
            {
              localObject1 = String.format("%d$%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(i) });
              parama.XM((String)localObject1);
              paramyj.sXc.add(parama);
              i += 1;
            }
          }
        }
        label286:
        break;
      }
    }
    for (;;)
    {
      break;
      long l = parambi.field_msgId;
      parama = p((xv)localObject1);
      parama.EH(3);
      if (!bk.bl(((xv)localObject1).sVI))
      {
        localObject2 = new nd();
        ((nd)localObject2).bWJ.type = 1;
        ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
        ((nd)localObject2).bWJ.bIt = l;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
          y.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        parama.XI(((nd)localObject2).bWK.dataPath);
        parama.EG(((xv)localObject1).duration);
        parama.mk(true);
        parama.mj(false);
        parama.XE(((xv)localObject1).sUV);
      }
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXt += 1;
      break label222;
      parama = p((xv)localObject1);
      parama.EH(1);
      parama.Xv(((xv)localObject1).desc);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXr += 1;
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      parama.EH(2);
      Object localObject2 = new nd();
      ((nd)localObject2).bWJ.type = 1;
      ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
      ((nd)localObject2).bWJ.bIt = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
        y.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      parama.XI(((nd)localObject2).bWK.dataPath);
      parama.XJ(((nd)localObject2).bWK.thumbPath);
      parama.mk(false);
      parama.mj(false);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXs += 1;
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      a(parama, (xv)localObject1);
      parama.EH(5);
      localObject2 = new nd();
      ((nd)localObject2).bWJ.type = 1;
      ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
      ((nd)localObject2).bWJ.bIt = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
        y.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      parama.XJ(((nd)localObject2).bWK.thumbPath);
      parama.mk(false);
      if ((((xv)localObject1).sVA != null) && (((xv)localObject1).sVA.sWh != null))
      {
        localObject2 = new yy();
        ((yy)localObject2).YD(((xv)localObject1).sVA.sWh.title);
        ((yy)localObject2).YE(((xv)localObject1).sVA.sWh.desc);
        ((yy)localObject2).YG(((xv)localObject1).sVA.sWh.thumbUrl);
        ((yy)localObject2).ER(((xv)localObject1).sVA.sWh.sXI);
        ((yy)localObject2).YF(((xv)localObject1).sVA.sWh.sXG);
        parama.sVA.a((yy)localObject2);
      }
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXv += 1;
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      a(parama, (xv)localObject1);
      if (((xv)localObject1).aYU == 15) {
        parama.EH(15);
      }
      for (;;)
      {
        localObject2 = new nd();
        ((nd)localObject2).bWJ.type = 1;
        ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
        ((nd)localObject2).bWJ.bIt = l;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
          y.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        parama.mj(false);
        parama.XI(((nd)localObject2).bWK.dataPath);
        parama.mk(false);
        parama.XJ(((nd)localObject2).bWK.thumbPath);
        parama.EG(((xv)localObject1).duration);
        localObject1 = paramcj.bIw.bIz;
        ((yx)localObject1).sXu += 1;
        break;
        parama.EH(4);
      }
      parama = p((xv)localObject1);
      parama.EH(6);
      if ((((xv)localObject1).sVA != null) && (((xv)localObject1).sVA.sWf != null))
      {
        localObject2 = new yc();
        ((yc)localObject2).Yh(((xv)localObject1).sVA.sWf.label);
        ((yc)localObject2).z(((xv)localObject1).sVA.sWf.lat);
        ((yc)localObject2).y(((xv)localObject1).sVA.sWf.lng);
        ((yc)localObject2).EM(((xv)localObject1).sVA.sWf.bRv);
        ((yc)localObject2).Yi(((xv)localObject1).sVA.sWf.bVA);
        parama.sVA.a((yc)localObject2);
      }
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXw += 1;
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      a(parama, (xv)localObject1);
      parama.EH(7);
      localObject2 = new nd();
      ((nd)localObject2).bWJ.type = 1;
      ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
      ((nd)localObject2).bWJ.bIt = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
        y.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      parama.XJ(((nd)localObject2).bWK.thumbPath);
      parama.mk(false);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXx += 1;
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      a(parama, (xv)localObject1);
      parama.EH(8);
      localObject2 = new nd();
      ((nd)localObject2).bWJ.type = 1;
      ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
      ((nd)localObject2).bWJ.bIt = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bk.bl(((nd)localObject2).bWK.dataPath)) && (bk.bl(((nd)localObject2).bWK.thumbPath))) {
        y.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      parama.XI(((nd)localObject2).bWK.dataPath);
      parama.XJ(((nd)localObject2).bWK.thumbPath);
      parama.mj(false);
      parama.XE(((xv)localObject1).sUV);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXy += 1;
      break label222;
      parama = a((xv)localObject1, ((xv)localObject1).aYU);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXA += 1;
      break label222;
      parama = a((xv)localObject1, ((xv)localObject1).aYU);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXB += 1;
      break label222;
      parama = p((xv)localObject1);
      parama.EH(14);
      if ((((xv)localObject1).sVA != null) && (((xv)localObject1).sVA.sWl != null))
      {
        localObject2 = new ys();
        ((ys)localObject2).Yz(((xv)localObject1).sVA.sWl.title);
        ((ys)localObject2).YA(((xv)localObject1).sVA.sWl.desc);
        ((ys)localObject2).YC(((xv)localObject1).sVA.sWl.info);
        ((ys)localObject2).YB(((xv)localObject1).sVA.sWl.thumbUrl);
        parama.sVA.a((ys)localObject2);
      }
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXE += 1;
      break label222;
      parama = p((xv)localObject1);
      parama.EH(16);
      parama.Xv(((xv)localObject1).desc);
      localObject1 = paramcj.bIw.bIz;
      ((yx)localObject1).sXF += 1;
      break label222;
      parama = p((xv)localObject1);
      parama.Xu(((xv)localObject1).title);
      parama.Xv(((xv)localObject1).desc);
      parama.EH(17);
      parama.XU(((xv)localObject1).sVQ);
      break label222;
      l = parambi.field_msgId;
      parama = p((xv)localObject1);
      parama.Xu(((xv)localObject1).title);
      parama.Xv(((xv)localObject1).desc);
      parama.EH(19);
      localObject2 = new nd();
      ((nd)localObject2).bWJ.type = 1;
      ((nd)localObject2).bWJ.bNt = ((xv)localObject1);
      ((nd)localObject2).bWJ.bIt = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if (bk.bl(((nd)localObject2).bWK.thumbPath)) {
        y.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((((xv)localObject1).sVA != null) && (((xv)localObject1).sVA.sWu != null))
        {
          localObject2 = new xt();
          ((xt)localObject2).username = ((xv)localObject1).sVA.sWu.username;
          ((xt)localObject2).appId = ((xv)localObject1).sVA.sWu.appId;
          ((xt)localObject2).bOa = ((xv)localObject1).sVA.sWu.bOa;
          ((xt)localObject2).iconUrl = ((xv)localObject1).sVA.sWu.iconUrl;
          ((xt)localObject2).type = ((xv)localObject1).sVA.sWu.type;
          ((xt)localObject2).bFw = ((xv)localObject1).sVA.sWu.bFw;
          ((xt)localObject2).sUv = ((xv)localObject1).sVA.sWu.sUv;
          parama.sVA.a((xt)localObject2);
        }
        break;
        parama.mk(false);
        parama.XJ(((nd)localObject2).bWK.thumbPath);
      }
      parama = p((xv)localObject1);
      parama.EH(20);
      parama.EG(((xv)localObject1).duration);
      break label222;
      localObject1 = String.format("%s#%d$%d", new Object[] { parambi.field_talker, Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(i) });
      break label286;
      localObject1 = String.format("%d$%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(i) });
      break label286;
      if ((!bk.bl(((xv)localc.dTx.get(0)).sUV)) && (((xv)localc.dTx.get(0)).sUV.equals(".htm"))) {}
      for (paramcj.bIw.type = 18;; paramcj.bIw.type = 14) {
        return true;
      }
    }
  }
  
  public static boolean a(cj paramcj, bi parambi)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    if ((paramcj == null) || (parambi == null))
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
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
      parambi = new yj();
      parambi.a(ab(localbi));
      paramcj.bIw.bIy = parambi;
      paramcj.bIw.desc = localbi.field_content;
      paramcj.bIw.type = 1;
      if (com.tencent.mm.ui.tools.f.aek(paramcj.bIw.desc) > com.tencent.mm.m.b.Ae())
      {
        paramcj.bIw.bIC = R.l.favorite_text_length_over_limit;
        bool1 = bool3;
      }
    }
    Object localObject2;
    label260:
    Object localObject3;
    for (;;)
    {
      paramcj.bIw.bIm = localbi.field_content;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramcj.bIw.bIC != 0) {
          break;
        }
      }
      com.tencent.mm.plugin.fav.ui.c.a(localbi, paramcj, bool1);
      return bool1;
      bool1 = true;
      continue;
      if (localbi.ctA())
      {
        localObject1 = new yj();
        ((yj)localObject1).a(ab(localbi));
        localObject2 = new xv();
        a((xv)localObject2, localbi);
        if (com.tencent.mm.model.s.hH(localbi.field_talker))
        {
          parambi = localbi.field_imgPath;
          parambi = com.tencent.mm.sdk.platformtools.h.b(com.tencent.mm.plugin.record.b.FJ(), "recbiz_", parambi, ".rec", 2);
          if (bk.bl(parambi))
          {
            parambi = null;
            ((xv)localObject2).XI(parambi);
          }
        }
        for (;;)
        {
          ((xv)localObject2).EH(3);
          ((xv)localObject2).mk(true);
          parambi = com.tencent.mm.modelvoice.q.ox(localbi.field_imgPath);
          bool1 = bool3;
          if (parambi == null) {
            break;
          }
          ((xv)localObject2).XE(DC(parambi.getFormat()));
          ((xv)localObject2).EG((int)new n(localbi.field_content).time);
          parambi = new LinkedList();
          parambi.add(localObject2);
          ((yj)localObject1).az(parambi);
          paramcj.bIw.bIy = ((yj)localObject1);
          paramcj.bIw.type = 3;
          bool1 = true;
          break;
          new com.tencent.mm.vfs.b(parambi).exists();
          break label260;
          ((xv)localObject2).XI(com.tencent.mm.modelvoice.q.getFullPath(localbi.field_imgPath));
        }
      }
      if (localbi.aVM())
      {
        bool1 = b(paramcj, localbi);
      }
      else if (localbi.ctB())
      {
        parambi = null;
        if (localbi.field_msgId > 0L) {
          parambi = com.tencent.mm.as.o.OJ().bY(localbi.field_msgId);
        }
        if (parambi != null)
        {
          localObject1 = parambi;
          if (parambi.enp > 0L) {}
        }
        else
        {
          localObject1 = parambi;
          if (localbi.field_msgSvrId > 0L) {
            localObject1 = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
          }
        }
        if (localObject1 == null)
        {
          y.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
          paramcj.bIw.bIC = R.l.favorite_fail_image_not_exists;
          bool1 = bool3;
        }
        else
        {
          parambi = new yj();
          parambi.a(ab(localbi));
          localObject2 = new xv();
          a((xv)localObject2, localbi);
          ((xv)localObject2).EH(2);
          ((xv)localObject2).XI(com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c((com.tencent.mm.as.e)localObject1), "", ""));
          if (((com.tencent.mm.as.e)localObject1).Or())
          {
            localObject1 = com.tencent.mm.as.o.OJ().iH(((com.tencent.mm.as.e)localObject1).enz);
            if (((com.tencent.mm.as.e)localObject1).ebK > ((com.tencent.mm.as.e)localObject1).offset) {
              ((xv)localObject2).XI(com.tencent.mm.as.o.OJ().o("SERVERID://" + localbi.field_msgSvrId, "", ""));
            }
          }
          ((xv)localObject2).XJ(com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true));
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          parambi.az((LinkedList)localObject1);
          paramcj.bIw.bIy = parambi;
          paramcj.bIw.type = 2;
          bool1 = true;
        }
      }
      else if ((localbi.aRQ()) || (localbi.aRR()))
      {
        localObject1 = new yj();
        ((yj)localObject1).a(ab(localbi));
        parambi = new xv();
        a(parambi, localbi);
        com.tencent.mm.modelvideo.o.Sr();
        parambi.XJ(t.nT(localbi.field_imgPath));
        parambi.XE(com.tencent.mm.vfs.e.bM(parambi.sVe));
        localObject2 = u.oe(localbi.field_imgPath);
        if (localObject2 == null)
        {
          y.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
          paramcj.bIw.bIC = R.l.favorite_fail;
          bool1 = bool3;
        }
        else
        {
          y.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject2).ebK) });
          if (((com.tencent.mm.modelvideo.s)localObject2).ebK > com.tencent.mm.m.b.Ai())
          {
            paramcj.bIw.bIC = R.l.favorite_too_large;
            bool1 = bool3;
          }
          else if ((localbi.aRR()) && (u.og(((com.tencent.mm.modelvideo.s)localObject2).getFileName())))
          {
            paramcj.bIw.bIC = R.l.favorite_fail;
            bool1 = bool3;
          }
          else
          {
            if (((com.tencent.mm.modelvideo.s)localObject2).SG())
            {
              com.tencent.mm.modelvideo.o.Sr();
              localObject3 = t.nS(localbi.field_imgPath);
              y.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { localObject3 });
              parambi.XI((String)localObject3);
              label976:
              parambi.EG(((com.tencent.mm.modelvideo.s)localObject2).eHH);
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(parambi);
              ((yj)localObject1).az((LinkedList)localObject2);
              paramcj.bIw.bIy = ((yj)localObject1);
              if (!localbi.aRR()) {
                break label1205;
              }
              paramcj.bIw.type = 16;
              parambi.EH(15);
            }
            for (;;)
            {
              localObject1 = u.oe(localbi.field_imgPath);
              parambi.XS(((com.tencent.mm.modelvideo.s)localObject1).bYN);
              localObject1 = ((com.tencent.mm.modelvideo.s)localObject1).eHQ;
              if ((localObject1 != null) && (!bk.bl(((bwa)localObject1).dSV)))
              {
                localObject2 = new xy();
                ((xy)localObject2).dSP = ((bwa)localObject1).dSP;
                ((xy)localObject2).sWK = ((bwa)localObject1).sWK;
                ((xy)localObject2).dSS = ((bwa)localObject1).dSS;
                ((xy)localObject2).dST = ((bwa)localObject1).dST;
                ((xy)localObject2).dSR = ((bwa)localObject1).dSR;
                ((xy)localObject2).dSU = ((bwa)localObject1).dSU;
                ((xy)localObject2).dSV = ((bwa)localObject1).dSV;
                ((xy)localObject2).dSW = ((bwa)localObject1).dSW;
                parambi.a((xy)localObject2);
              }
              bool1 = true;
              break;
              y.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
              parambi.XI("");
              break label976;
              label1205:
              paramcj.bIw.type = 4;
              parambi.EH(4);
            }
          }
        }
      }
      else
      {
        if (!localbi.ctz()) {
          break label1240;
        }
        bool1 = c(paramcj, localbi);
      }
    }
    label1240:
    if (localbi.cvn()) {}
    while ((!localbi.aVK()) || (localbi.cvp()))
    {
      paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
      bool1 = bool3;
      break;
    }
    parambi = new yj();
    parambi.a(ab(localbi));
    Object localObject1 = localbi.field_content;
    if (localObject1 == null)
    {
      paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
      bool1 = false;
    }
    for (;;)
    {
      break;
      localObject1 = g.a.gp((String)localObject1);
      if (localObject1 == null)
      {
        paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
        bool1 = false;
      }
      else
      {
        paramcj.bIw.bIy = parambi;
        localObject2 = parambi.sXa;
        ((yp)localObject2).Yw(((g.a)localObject1).appId);
        ((yp)localObject2).Yy(((g.a)localObject1).bYG);
        switch (((g.a)localObject1).type)
        {
        default: 
          paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
          bool1 = false;
          break;
        case 1: 
          paramcj.bIw.bIy = parambi;
          paramcj.bIw.desc = ((g.a)localObject1).title;
          paramcj.bIw.type = 1;
          bool1 = bool2;
          break;
        case 2: 
          if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
          {
            paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
            bool1 = false;
          }
          else
          {
            localObject3 = com.tencent.mm.plugin.z.a.avh().VQ(((g.a)localObject1).bFE);
            localObject2 = new xv();
            a((xv)localObject2, localbi);
            if (localObject3 != null) {
              ((xv)localObject2).XI(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
            }
            localObject3 = com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true);
            if (com.tencent.mm.vfs.e.bK((String)localObject3)) {
              ((xv)localObject2).XJ((String)localObject3);
            }
            ((xv)localObject2).EH(2);
            ((xv)localObject2).Xu(((g.a)localObject1).title);
            ((xv)localObject2).Xv(((g.a)localObject1).description);
            parambi.sXc.add(localObject2);
            paramcj.bIw.type = 2;
            bool1 = bool2;
          }
          break;
        case 3: 
          localObject1 = a(localbi, (g.a)localObject1, 7);
          parambi.sXc.add(localObject1);
          paramcj.bIw.type = 7;
          bool1 = bool2;
          break;
        case 4: 
          localObject1 = a(localbi, (g.a)localObject1, 4);
          parambi.Yo(((xv)localObject1).title);
          parambi.Yp(((xv)localObject1).desc);
          parambi.sXc.add(localObject1);
          paramcj.bIw.type = 4;
          bool1 = bool2;
          break;
        case 5: 
          if ((((g.a)localObject1).url != null) && (!((g.a)localObject1).url.equals("")))
          {
            parambi.sXa.Yx(((g.a)localObject1).url);
            localObject1 = a(localbi, (g.a)localObject1, 5);
            parambi.sXc.add(localObject1);
            parambi.Yo(((xv)localObject1).title);
            parambi.Yp(((xv)localObject1).desc);
            paramcj.bIw.type = 5;
            bool1 = bool2;
          }
          else
          {
            paramcj.bIw.bIC = R.l.favorite_fail_empty_url;
            bool1 = false;
          }
          break;
        case 6: 
          if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
          {
            paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
            bool1 = false;
          }
          else
          {
            localObject3 = com.tencent.mm.plugin.z.a.avh().VQ(((g.a)localObject1).bFE);
            localObject2 = new xv();
            if (localObject3 != null) {
              ((xv)localObject2).XI(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
            }
            a((xv)localObject2, localbi);
            ((xv)localObject2).EH(8);
            ((xv)localObject2).XE(((g.a)localObject1).dQw);
            localObject3 = com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true);
            if (bk.bl((String)localObject3)) {
              ((xv)localObject2).mk(true);
            }
            if (com.tencent.mm.vfs.e.bK((String)localObject3)) {
              ((xv)localObject2).XJ((String)localObject3);
            }
            ((xv)localObject2).Xu(((g.a)localObject1).title);
            ((xv)localObject2).Xv(((g.a)localObject1).description);
            parambi.sXc.add(localObject2);
            paramcj.bIw.desc = ((g.a)localObject1).title;
            paramcj.bIw.type = 8;
            bool1 = bool2;
          }
          break;
        case 7: 
          if ((((g.a)localObject1).bFE == null) || (((g.a)localObject1).bFE.length() == 0)) {
            paramcj.bIw.bIC = R.l.favorite_fail_attachment_not_exists;
          }
          while (com.tencent.mm.kernel.g.DP().isSDCardAvailable())
          {
            paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
            bool1 = false;
            break;
          }
          paramcj.bIw.bIC = R.l.favorite_fail_sdcard_not_available;
          bool1 = false;
          break;
        case 10: 
          localObject2 = new yi();
          ((yi)localObject2).Yj(((g.a)localObject1).title);
          ((yi)localObject2).Yk(((g.a)localObject1).description);
          ((yi)localObject2).EN(((g.a)localObject1).dQY);
          ((yi)localObject2).Ym(((g.a)localObject1).dQZ);
          ((yi)localObject2).Yl(((g.a)localObject1).thumburl);
          paramcj.bIw.title = ((g.a)localObject1).title;
          paramcj.bIw.desc = ((g.a)localObject1).description;
          paramcj.bIw.type = 10;
          parambi.b((yi)localObject2);
          bool1 = bool2;
          break;
        case 20: 
          localObject2 = new ys();
          ((ys)localObject2).Yz(((g.a)localObject1).title);
          ((ys)localObject2).YA(((g.a)localObject1).description);
          ((ys)localObject2).YC(((g.a)localObject1).dRc);
          ((ys)localObject2).YB(((g.a)localObject1).thumburl);
          paramcj.bIw.title = ((g.a)localObject1).title;
          paramcj.bIw.desc = ((g.a)localObject1).description;
          paramcj.bIw.type = 15;
          parambi.b((ys)localObject2);
          bool1 = bool2;
          break;
        case 13: 
          localObject2 = new yi();
          ((yi)localObject2).Yj(((g.a)localObject1).title);
          ((yi)localObject2).Yk(((g.a)localObject1).description);
          ((yi)localObject2).EN(((g.a)localObject1).dRe);
          ((yi)localObject2).Ym(((g.a)localObject1).dRf);
          ((yi)localObject2).Yl(((g.a)localObject1).thumburl);
          paramcj.bIw.title = ((g.a)localObject1).title;
          paramcj.bIw.desc = ((g.a)localObject1).description;
          paramcj.bIw.type = 11;
          parambi.b((yi)localObject2);
          bool1 = bool2;
          break;
        case 19: 
        case 24: 
          paramcj.bIw.bIz = new yx();
          bool1 = a(paramcj, (g.a)localObject1, parambi, localbi);
          break;
        case 33: 
        case 36: 
          localObject2 = new xt();
          ((xt)localObject2).username = ((g.a)localObject1).dSY;
          ((xt)localObject2).appId = ((g.a)localObject1).dSZ;
          ((xt)localObject2).bOa = ((g.a)localObject1).dTc;
          ((xt)localObject2).iconUrl = ((g.a)localObject1).dTh;
          ((xt)localObject2).bFw = ((g.a)localObject1).dSX;
          ((xt)localObject2).sUv = ((g.a)localObject1).bYH;
          localObject3 = new xv();
          a((xv)localObject3, localbi);
          ((xv)localObject3).EH(19);
          String str = com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true);
          if (bk.bl(str)) {
            ((xv)localObject3).mk(true);
          }
          if (com.tencent.mm.vfs.e.bK(str)) {
            ((xv)localObject3).XJ(str);
          }
          ((xv)localObject3).Xu(((g.a)localObject1).title);
          ((xv)localObject3).Xv(((g.a)localObject1).description);
          parambi.sXc.add(localObject3);
          paramcj.bIw.title = ((g.a)localObject1).title;
          paramcj.bIw.desc = ((g.a)localObject1).description;
          paramcj.bIw.type = 19;
          parambi.sWu = ((xt)localObject2);
          parambi.sWv = true;
          bool1 = bool2;
        }
      }
    }
  }
  
  public static boolean a(cj paramcj, String paramString1, String paramString2, String paramString3)
  {
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
      return false;
    }
    y.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new com.tencent.mm.vfs.b(paramString1).length() > com.tencent.mm.m.b.Ai())
    {
      paramcj.bIw.bIC = R.l.favorite_too_large;
      return false;
    }
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localxv.XI(paramString1);
    localxv.EH(8);
    localxv.XE(com.tencent.mm.vfs.e.bM(paramString1));
    localxv.mk(true);
    localxv.Xu(paramString2);
    localxv.Xv(paramString3);
    localyp.Yq(com.tencent.mm.model.q.Gj());
    localyp.Yr(com.tencent.mm.model.q.Gj());
    localyp.EQ(13);
    localyp.hl(bk.UY());
    localyj.a(localyp);
    localyj.sXc.add(localxv);
    paramcj.bIw.title = localxv.title;
    paramcj.bIw.desc = localxv.title;
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.type = 8;
    return true;
  }
  
  private static yp ab(bi parambi)
  {
    yp localyp = new yp();
    if (parambi.field_isSend == 1)
    {
      localyp.Yq(com.tencent.mm.model.q.Gj());
      localyp.Yr(parambi.field_talker);
      if (com.tencent.mm.model.s.fn(parambi.field_talker)) {
        localyp.Yt(localyp.bRO);
      }
    }
    do
    {
      localyp.EQ(1);
      localyp.hl(parambi.field_createTime);
      localyp.Yu(parambi.field_msgSvrId);
      if (parambi.field_msgSvrId > 0L) {
        localyp.Ys(parambi.field_msgSvrId);
      }
      return localyp;
      localyp.Yq(parambi.field_talker);
      localyp.Yr(com.tencent.mm.model.q.Gj());
    } while (!com.tencent.mm.model.s.fn(parambi.field_talker));
    if (parambi.field_content != null) {}
    for (String str = parambi.field_content.substring(0, Math.max(0, parambi.field_content.indexOf(':')));; str = "")
    {
      localyp.Yt(str);
      if ((bk.bl(localyp.sWB)) || (parambi.ctA())) {
        break;
      }
      parambi.setContent(parambi.field_content.substring(localyp.sWB.length() + 1));
      if ((parambi.field_content.length() > 0) && ('\n' == parambi.field_content.charAt(0))) {
        parambi.setContent(parambi.field_content.substring(1));
      }
      if (!parambi.cvw()) {
        break;
      }
      parambi.ef(parambi.field_transContent.substring(localyp.sWB.length() + 1));
      if ((parambi.field_transContent.length() <= 0) || ('\n' != parambi.field_transContent.charAt(0))) {
        break;
      }
      parambi.ef(parambi.field_transContent.substring(1));
      break;
    }
  }
  
  private static boolean b(cj paramcj, bi parambi)
  {
    yj localyj = new yj();
    localyj.a(ab(parambi));
    parambi = bn.s(parambi.field_content, "msg");
    if (parambi != null) {
      try
      {
        yc localyc = new yc();
        localyc.Yh((String)parambi.get(".msg.location.$label"));
        localyc.z(Double.parseDouble((String)parambi.get(".msg.location.$x")));
        localyc.y(Double.parseDouble((String)parambi.get(".msg.location.$y")));
        localyc.EM(Integer.valueOf((String)parambi.get(".msg.location.$scale")).intValue());
        localyc.Yi((String)parambi.get(".msg.location.$poiname"));
        localyj.b(localyc);
        paramcj.bIw.type = 6;
        paramcj.bIw.bIy = localyj;
        return true;
      }
      catch (Exception parambi)
      {
        y.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambi.getStackTrace().toString() });
      }
    }
    paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
    return false;
  }
  
  public static boolean b(cj paramcj, String paramString, int paramInt)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
      return false;
    }
    y.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    yj localyj = new yj();
    yp localyp = new yp();
    localyp.Yq(com.tencent.mm.model.q.Gj());
    localyp.Yr(com.tencent.mm.model.q.Gj());
    localyp.EQ(paramInt);
    localyp.hl(bk.UY());
    localyj.a(localyp);
    paramcj.bIw.desc = paramString;
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.type = 1;
    return true;
  }
  
  private static boolean c(cj paramcj, bi parambi)
  {
    yj localyj = new yj();
    Object localObject1 = ab(parambi);
    localyj.a((yp)localObject1);
    for (;;)
    {
      try
      {
        Object localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
        Object localObject3 = ((l)localObject2).dTx;
        ((yp)localObject1).Yy(((l)localObject2).bYG);
        if ((localObject3 != null) && (((List)localObject3).size() > paramcj.bIw.bIA))
        {
          y.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcj.bIw.bIA) });
          localObject2 = (m)((List)localObject3).get(paramcj.bIw.bIA);
          if (com.tencent.mm.ae.i.gr(((m)localObject2).dTI))
          {
            paramcj.bIw.bIC = R.l.favorite_fail_nonsupport;
            return false;
          }
          ((yp)localObject1).Yx(((m)localObject2).url);
          if (paramcj.bIw.bIA > 0) {
            ((yp)localObject1).Ys("");
          }
          localObject3 = new xv();
          ((xv)localObject3).Xu(((m)localObject2).title);
          ((xv)localObject3).Xv(((m)localObject2).dTF);
          a((xv)localObject3, parambi);
          localObject1 = ((m)localObject2).dTD;
          if (!bk.bl((String)localObject1)) {
            break label463;
          }
          com.tencent.mm.ag.h localh = com.tencent.mm.ag.o.Kh().kp(parambi.field_talker);
          if (localh == null) {
            break label463;
          }
          localObject1 = localh.JX();
          if (!bk.bl((String)localObject1))
          {
            int i = parambi.getType();
            if (paramcj.bIw.bIA <= 0) {
              break label466;
            }
            parambi = "@S";
            ((xv)localObject3).XJ(q.y((String)localObject1, i, parambi));
            ((xv)localObject3).mk(false);
            if ((bk.bl(((xv)localObject3).sVg)) || (!com.tencent.mm.vfs.e.bK(((xv)localObject3).sVg)))
            {
              ((xv)localObject3).XD((String)localObject1);
              ((xv)localObject3).mk(true);
              parambi = new yy();
              parambi.YG((String)localObject1);
              localyj.b(parambi);
            }
            ((xv)localObject3).mj(true);
            ((xv)localObject3).EH(5);
            localyj.sXc.add(localObject3);
            paramcj.bIw.bIy = localyj;
            paramcj.bIw.desc = ((m)localObject2).title;
            paramcj.bIw.type = 5;
            return true;
          }
          ((xv)localObject3).mk(true);
          continue;
        }
        continue;
      }
      catch (Exception parambi)
      {
        y.printErrStackTrace("MicroMsg.GetFavDataSource", parambi, "", new Object[0]);
        y.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambi.getLocalizedMessage() });
        paramcj.bIw.bIC = R.l.favorite_fail_parse_error;
        return false;
      }
      label463:
      label466:
      parambi = "@T";
    }
  }
  
  private static xv p(xv paramxv)
  {
    xv localxv = new xv();
    xw localxw = new xw();
    xx localxx1 = new xx();
    xx localxx2 = paramxv.sVA.sWd;
    if (localxx2.sWx) {
      localxx1.XZ(localxx2.bRO);
    }
    if (localxx2.sWy) {
      localxx1.Ya(localxx2.toUser);
    }
    if (localxx2.sWC) {
      localxx1.Yc(localxx2.sWB);
    }
    localxx1.EL(1);
    localxx1.hi(bk.UY());
    localxw.c(localxx1);
    localxv.a(localxw);
    localxv.XP(paramxv.sVC);
    localxv.XQ(paramxv.sVE);
    localxv.XY(paramxv.sWb);
    localxv.mk(true);
    localxv.mj(true);
    localxv.XR(paramxv.sVI);
    localxv.EJ(paramxv.sVO);
    localxv.XF(paramxv.sUX);
    localxv.XG(paramxv.sUZ);
    localxv.hf(paramxv.sVb);
    localxv.XK(paramxv.sVi);
    localxv.XL(paramxv.sVk);
    localxv.hg(paramxv.sVm);
    return localxv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */