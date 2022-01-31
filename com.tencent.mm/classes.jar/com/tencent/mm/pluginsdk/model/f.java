package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public final class f
  implements ad
{
  public final boolean a(cj paramcj, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localxv.EH(5);
    localxv.XJ(paramString7);
    localxv.XA(paramString3);
    localxv.EG(paramInt);
    localxv.Xu(paramString1);
    localxv.Xv(paramString2);
    localxv.XS(paramString11);
    paramString2 = new xy();
    paramString2.dSR = paramString1;
    paramString2.sWK = paramInt;
    paramString2.dSP = paramString3;
    paramString2.dST = paramString5;
    paramString2.dSS = paramString4;
    paramString2.dSU = paramString6;
    paramString2.dSV = paramString9;
    paramString2.dSW = paramString10;
    localxv.a(paramString2);
    localyp.Yq(paramString8);
    localyp.Yr(q.Gj());
    localyp.EQ(0);
    localyp.hl(bk.UY());
    localyj.a(localyp);
    localyj.sXc.add(localxv);
    paramcj.bIw.title = localxv.title;
    paramcj.bIw.desc = localxv.title;
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.type = 4;
    return true;
  }
  
  public final boolean a(cj paramcj, Intent paramIntent)
  {
    return e.a(paramcj, paramIntent);
  }
  
  public final boolean a(cj paramcj, String paramString)
  {
    return e.a(paramcj, 2, paramString);
  }
  
  public final boolean a(cj paramcj, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    yj localyj = new yj();
    yp localyp = new yp();
    localyp.Yq(paramString2);
    localyp.EQ(2);
    localyp.hl(System.currentTimeMillis());
    localyp.Yv(paramString1);
    localyp.Ys(str);
    paramString1 = new xv();
    paramString1.XM(str);
    paramString1.mk(true);
    paramString1.EH(5);
    paramString1.Xu(paramString3);
    paramString1.Xv(paramString4);
    paramString1.XT(paramString5);
    paramString1.mj(true);
    localyj.sXc.add(paramString1);
    paramString1 = new yy();
    paramString1.YG(paramString6);
    paramString1.YF(paramString7);
    localyj.b(paramString1);
    localyj.a(localyp);
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.desc = paramString3;
    paramcj.bIw.type = 5;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.f
 * JD-Core Version:    0.7.0.1
 */