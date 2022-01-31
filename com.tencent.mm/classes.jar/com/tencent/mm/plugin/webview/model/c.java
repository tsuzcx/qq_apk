package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cj paramcj, c.a parama)
  {
    if (!bk.bl(parama.url)) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcj.bIw.bIC = R.l.favorite_fail_argument_error;
      return false;
    }
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localxv.XA(parama.url);
    localxv.Xu(parama.title);
    localxv.Xv(parama.desc);
    localxv.XD(parama.thumbUrl);
    localxv.XS(parama.bYN);
    localxv.mj(true);
    localxv.mk(true);
    localxv.EH(5);
    yy localyy = new yy();
    localyy.YG(parama.thumbUrl);
    localyj.b(localyy);
    localyp.Yq(q.Gj());
    localyp.Yr(q.Gj());
    localyp.EQ(3);
    localyp.hl(bk.UY());
    localyp.Yw(parama.bOL);
    localyp.Yx(parama.url);
    paramcj.bIw.title = localxv.title;
    paramcj.bIw.bIy = localyj;
    paramcj.bIw.type = 5;
    localyj.a(localyp);
    localyj.sXc.add(localxv);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */