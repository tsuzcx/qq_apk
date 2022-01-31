package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.h.a.cj;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cj paramcj, bj parambj, int paramInt)
  {
    if ((paramcj == null) || (parambj == null))
    {
      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcj != null) {
        paramcj.bIw.bIC = a.g.favorite_fail_argument_error;
      }
      return false;
    }
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localyp.Yq("newsapp");
    localyp.Yr(com.tencent.mm.model.q.Gj());
    localyp.Yr(com.tencent.mm.model.q.Gj());
    localyp.EQ(1);
    localyp.hl(parambj.dXg);
    localyp.Yu(parambj.dXl);
    localyp.Yx(parambj.getUrl());
    localyp.Yy("newsapp");
    localxv.XM(String.valueOf(parambj.dXl));
    Object localObject;
    if (paramInt == 0)
    {
      localObject = com.tencent.mm.pluginsdk.model.q.y(parambj.Ia(), parambj.type, "@T");
      if (!e.bK((String)localObject)) {
        break label287;
      }
      localxv.XJ((String)localObject);
    }
    for (;;)
    {
      localxv.EH(5);
      localxv.Xu(parambj.getTitle());
      localxv.Xv(parambj.getDigest());
      localxv.mj(true);
      localyj.a(localyp);
      localyj.sXc.add(localxv);
      paramcj.bIw.desc = parambj.getTitle();
      paramcj.bIw.bIy = localyj;
      paramcj.bIw.type = 5;
      return true;
      localObject = com.tencent.mm.pluginsdk.model.q.y(parambj.Ia(), parambj.type, "@S");
      break;
      label287:
      localxv.mk(true);
      localxv.XD(parambj.Ia());
      localObject = new yy();
      ((yy)localObject).YG(parambj.Ia());
      localyj.b((yy)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */