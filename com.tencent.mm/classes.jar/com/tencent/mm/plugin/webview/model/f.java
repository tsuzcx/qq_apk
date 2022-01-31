package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  public int rfm = 20480;
  public int rfn = 30720;
  public int rfo = 51200;
  public final List<asw> rfp = new LinkedList();
  public int rfq = 0;
  public long rfr = 0L;
  
  public static void db(List<aql> paramList)
  {
    if (bk.dk(paramList)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aql localaql = (aql)paramList.next();
      e locale = g.ccN();
      int i = localaql.tms;
      long l1 = bk.UX();
      long l2 = localaql.tmt;
      locale.rfk.n(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    g.ccN().cbF();
  }
  
  private static final class a
  {
    private static final f rfs = new f((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.f
 * JD-Core Version:    0.7.0.1
 */