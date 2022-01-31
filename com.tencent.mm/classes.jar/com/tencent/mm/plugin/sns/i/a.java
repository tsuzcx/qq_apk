package com.tencent.mm.plugin.sns.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(xv paramxv, n paramn)
  {
    if (paramn != null) {
      a(paramxv, paramn.bGe());
    }
  }
  
  private static void a(xv paramxv, bxk parambxk)
  {
    if ((paramxv != null) && (parambxk != null) && (!bk.bl(parambxk.oPO))) {
      paramxv.XS(parambxk.oPO);
    }
  }
  
  public static boolean a(cj paramcj, n paramn)
  {
    if (paramn == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      return false;
    }
    yj localyj = new yj();
    Object localObject2 = new yp();
    bxk localbxk = paramn.bGe();
    awd localawd = (awd)localbxk.tNr.sPJ.get(0);
    if ((paramn.yr(32)) && (localbxk.tNr.sPI == 15))
    {
      localbxk.tNw.dSV = paramn.bGb().ovV;
      localbxk.tNw.dSW = localbxk.lsK;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { i.fN(paramn.field_snsId), localawd.lsK });
    ((yp)localObject2).Yq(paramn.field_userName);
    ((yp)localObject2).Yr(q.Gj());
    ((yp)localObject2).EQ(2);
    ((yp)localObject2).hl(bk.UY());
    ((yp)localObject2).Yv(paramn.bGk());
    ((yp)localObject2).Ys((String)localObject1);
    localyj.a((yp)localObject2);
    localObject2 = new xv();
    ((xv)localObject2).XM((String)localObject1);
    localObject1 = an.eJ(af.getAccSnsPath(), localawd.lsK);
    Object localObject4 = i.j(localawd);
    Object localObject3 = i.e(localawd);
    if (bk.bl(aq.a(paramn.bGE(), localawd)))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcj.bIw.bIC = i.j.favorite_fail_sns_sight;
      return false;
    }
    if (!e.bK((String)localObject1 + (String)localObject4))
    {
      y.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + e.bK(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + e.bK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcj.bIw.bIC = i.j.favorite_fail_sns_sight;
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!e.bK((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localawd.trS != null)
      {
        j = m;
        i = k;
        if (localawd.trS.tsG > 0.0F)
        {
          j = m;
          i = k;
          if (localawd.trS.tsF > 0.0F)
          {
            i = (int)localawd.trS.tsF;
            j = (int)localawd.trS.tsG;
          }
        }
      }
      localBitmap = d.ab((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        y.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + e.bK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcj.bIw.bIC = i.j.favorite_fail_sns_sight;
        return false;
      }
    }
    for (;;)
    {
      try
      {
        c.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((xv)localObject2).XI((String)localObject1 + (String)localObject4);
        ((xv)localObject2).XJ((String)localObject1 + (String)localObject3);
        if (bk.bl(localawd.tsa))
        {
          localObject1 = localbxk.tNo;
          ((xv)localObject2).Xu((String)localObject1);
          ((xv)localObject2).XT(localbxk.pjl);
          if (!bk.bl(localbxk.pjl))
          {
            localObject1 = bn.s(localbxk.pjl, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((xv)localObject2).Xu(bk.aM((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((xv)localObject2).Xv(bk.aM((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramn.yr(32)) {
            break label1223;
          }
          localObject3 = paramn.bFZ();
          localObject4 = new xy();
          if (!bk.bl(localawd.tsa)) {
            break label1193;
          }
          localObject1 = localbxk.tNo;
          ((xy)localObject4).dSR = ((String)localObject1);
          ((xy)localObject4).sWK = localawd.pkD;
          ((xy)localObject4).dSP = localawd.trW;
          ((xy)localObject4).dSV = localbxk.tNw.dSV;
          ((xy)localObject4).dSW = localbxk.tNw.dSW;
          if (bk.bl(((xy)localObject4).dSW)) {
            ((xy)localObject4).dSW = localbxk.lsK;
          }
          if (!bk.bl(localawd.trZ)) {
            break label1203;
          }
          localObject1 = localawd.trP;
          ((xy)localObject4).dSU = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).oAN == 0))
          {
            ((xy)localObject4).dST = ((com.tencent.mm.plugin.sns.storage.b)localObject3).oAP;
            ((xy)localObject4).dSS = ((com.tencent.mm.plugin.sns.storage.b)localObject3).oAO;
          }
          ((xv)localObject2).a((xy)localObject4);
          i = 16;
          j = 15;
          ((xv)localObject2).EH(j);
          localObject1 = d.MH(((xv)localObject2).sVe);
          if (localObject1 == null) {
            break label1213;
          }
          ((xv)localObject2).EG(((com.tencent.mm.plugin.sight.base.a)localObject1).bAT());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localyj.az((LinkedList)localObject1);
          paramcj.bIw.bIy = localyj;
          paramcj.bIw.type = i;
          a((xv)localObject2, paramn);
          y.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          return true;
        }
      }
      catch (Exception paramn)
      {
        y.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramn, "save bmp error %s", new Object[] { paramn.getMessage() });
        y.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + e.bK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcj.bIw.bIC = i.j.favorite_fail_sns_sight;
        return false;
      }
      localObject1 = localawd.tsa;
      continue;
      label1193:
      localObject1 = localawd.tsa;
      continue;
      label1203:
      localObject1 = localawd.trZ;
      continue;
      label1213:
      ((xv)localObject2).EG(1);
      continue;
      label1223:
      i = 4;
    }
  }
  
  public static boolean a(cj paramcj, n paramn, String paramString)
  {
    if ((paramcj == null) || (bk.bl(paramString)))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcj != null) {
        paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      }
      return false;
    }
    if (paramn == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    awd localawd = aj.a(paramn, paramString);
    if (localawd == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    String str = String.format("%s#%s", new Object[] { i.fN(paramn.field_snsId), paramString });
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    y.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramn.field_userName });
    localyp.Yq(paramn.field_userName);
    localyp.Yr(q.Gj());
    localyp.EQ(2);
    localyp.hl(paramn.field_createTime * 1000L);
    localyp.Yv(paramn.bGk());
    localyp.Ys(str);
    localxv.XM(str);
    localxv.XI(an.eJ(af.getAccSnsPath(), paramString) + i.l(localawd));
    if (paramn.bGe() != null)
    {
      localxv.XT(paramn.bGe().pjl);
      if (!bk.bl(paramn.bGe().pjl))
      {
        paramString = bn.s(paramn.bGe().pjl, "adxml");
        if (paramString.size() > 0)
        {
          localxv.Xu(bk.aM((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localxv.Xv(bk.aM((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localxv, paramn);
    paramString = an.eJ(af.getAccSnsPath(), localawd.lsK) + i.e(localawd);
    if ((!e.bK(localxv.sVe)) && (paramn.field_userName.endsWith(af.bDl())))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    if (e.bK(paramString)) {
      localxv.XJ(paramString);
    }
    for (;;)
    {
      localxv.EH(2);
      localyj.sXc.add(localxv);
      localyj.a(localyp);
      paramcj.bIw.bIy = localyj;
      paramcj.bIw.type = 2;
      return true;
      localxv.mk(true);
      localxv.XD(localawd.trP);
      paramn = new yy();
      paramn.YG(localawd.trP);
      localyj.b(paramn);
    }
  }
  
  public static boolean a(cj paramcj, String paramString, int paramInt)
  {
    if ((v.OX(paramString)) || (paramInt < 0))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      return false;
    }
    if (af.bDo())
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcj.bIw.bIC = i.j.favorite_fail_system_error;
      return false;
    }
    paramString = af.bDF().OB(paramString);
    if (paramString == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    awd localawd = aj.a(paramString, paramInt);
    if (localawd == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    return a(paramcj, paramString, localawd.lsK);
  }
  
  public static boolean a(cj paramcj, String paramString, CharSequence paramCharSequence)
  {
    if ((v.OX(paramString)) || (paramCharSequence == null))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      return false;
    }
    if (af.bDo())
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcj.bIw.bIC = i.j.favorite_fail_system_error;
      return false;
    }
    paramString = af.bDF().OB(paramString);
    if (paramString == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcj.bIw.bIC = i.j.favorite_fail;
      return false;
    }
    String str = String.format("%s#0", new Object[] { i.fN(paramString.field_snsId) });
    yj localyj = new yj();
    yp localyp = new yp();
    y.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localyp.Yq(paramString.field_userName);
    localyp.Yr(q.Gj());
    localyp.EQ(2);
    localyp.hl(paramString.field_createTime * 1000L);
    localyp.Yv(paramString.bGk());
    localyp.Ys(str);
    localyj.a(localyp);
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.desc = paramCharSequence.toString();
    paramcj.bIw.type = 1;
    return true;
  }
  
  public static boolean a(cj paramcj, String paramString1, String paramString2)
  {
    if ((paramcj == null) || (!v.OW(paramString2)) || (paramString1 == null))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcj != null) {
        paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      }
      return false;
    }
    if (af.bDo())
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcj.bIw.bIC = i.j.favorite_fail_system_error;
      return false;
    }
    Object localObject1 = h.OB(paramString2);
    if (localObject1 == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    if ((((n)localObject1).bGe().tNr != null) && (((n)localObject1).bGe().tNr.sPI == 26)) {
      return b(paramcj, paramString2);
    }
    paramString2 = "0";
    Object localObject2 = aj.a((n)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((awd)localObject2).lsK;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { i.fN(((n)localObject1).field_snsId), paramString2 });
    paramString2 = new yj();
    yp localyp = new yp();
    y.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((n)localObject1).field_userName });
    localyp.Yq(((n)localObject1).field_userName);
    localyp.Yr(q.Gj());
    localyp.EQ(2);
    localyp.hl(((n)localObject1).field_createTime * 1000L);
    localyp.Yv(((n)localObject1).bGk());
    localyp.Ys((String)localObject3);
    localyp.Yx(paramString1);
    paramString1 = new xv();
    paramString1.XM((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = an.eJ(af.getAccSnsPath(), ((awd)localObject2).lsK) + i.e((awd)localObject2);
      if (e.bK((String)localObject3)) {
        paramString1.XJ((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.EH(5);
      localObject1 = ((n)localObject1).bGe();
      paramString1.Xu(((bxk)localObject1).tNr.bGw);
      paramString1.Xv(((bxk)localObject1).tNr.kRN);
      paramString1.XT(((bxk)localObject1).pjl);
      if (!bk.bl(((bxk)localObject1).pjl))
      {
        localObject2 = bn.s(((bxk)localObject1).pjl, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.Xu(bk.aM((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.Xv(bk.aM((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (bxk)localObject1);
      paramString1.mj(true);
      paramString2.sXc.add(paramString1);
      paramString1 = new yy();
      paramString1.ES(((bxk)localObject1).dQA);
      paramString2.b(paramString1);
      paramString2.a(localyp);
      paramcj.bIw.bIy = paramString2;
      paramcj.bIw.desc = ((bxk)localObject1).tNr.bGw;
      paramcj.bIw.type = 5;
      return true;
      paramString1.mk(true);
      paramString1.XD(((awd)localObject2).trP);
      localObject3 = new yy();
      ((yy)localObject3).YG(((awd)localObject2).trP);
      paramString2.b((yy)localObject3);
      continue;
      paramString1.mk(true);
    }
  }
  
  public static boolean b(cj paramcj, String paramString)
  {
    int i = 0;
    if ((paramcj == null) || (!v.OW(paramString)))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcj != null) {
        paramcj.bIw.bIC = i.j.favorite_fail_argument_error;
      }
      return false;
    }
    if (af.bDo())
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcj.bIw.bIC = i.j.favorite_fail_system_error;
      return false;
    }
    Object localObject1 = h.OB(paramString);
    if (localObject1 == null)
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcj.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
      return false;
    }
    paramString = "0";
    Object localObject2 = aj.a((n)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((awd)localObject2).lsK;
    }
    String str = String.format("%s#%s", new Object[] { i.fN(((n)localObject1).field_snsId), paramString });
    localObject2 = new yp();
    paramString = ((n)localObject1).bGe();
    if (paramString == null)
    {
      y.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      return false;
    }
    y.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((n)localObject1).field_userName });
    ((yp)localObject2).Yq(((n)localObject1).field_userName);
    ((yp)localObject2).Yr(q.Gj());
    ((yp)localObject2).EQ(2);
    ((yp)localObject2).hl(((n)localObject1).field_createTime * 1000L);
    ((yp)localObject2).Yv(((n)localObject1).bGk());
    ((yp)localObject2).Ys(str);
    localObject1 = new gf();
    ((gf)localObject1).bNF.type = 30;
    ((gf)localObject1).bNF.bNM = 4;
    ((gf)localObject1).bNF.desc = paramString.tNr.sPL;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    ((gf)localObject1).bNF.bIy.a((yp)localObject2);
    paramcj.bIw.bIy = ((gf)localObject1).bNF.bIy;
    if (paramcj.bIw.bIy != null)
    {
      localObject1 = paramcj.bIw.bIy.sXc;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (xv)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((xv)localObject2).mj(true);
            ((xv)localObject2).mk(true);
          }
          i += 1;
        }
      }
    }
    paramcj.bIw.desc = paramString.tNr.bGw;
    paramcj.bIw.type = 18;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.a
 * JD-Core Version:    0.7.0.1
 */