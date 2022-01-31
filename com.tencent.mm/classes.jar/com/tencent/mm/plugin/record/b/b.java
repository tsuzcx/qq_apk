package com.tencent.mm.plugin.record.b;

import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.b.a;

public final class b
{
  public static String a(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    gf localgf = new gf();
    localgf.bNF.type = 2;
    localgf.bNF.bNH = paramb.bNt;
    a.udP.m(localgf);
    return localgf.bNG.path;
  }
  
  public static String b(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    gf localgf = new gf();
    localgf.bNF.type = 2;
    localgf.bNF.bNH = paramb.bNt;
    a.udP.m(localgf);
    return localgf.bNG.thumbPath;
  }
  
  public static boolean c(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    gf localgf = new gf();
    localgf.bNF.type = 14;
    localgf.bNF.bNH = paramb.bNt;
    a.udP.m(localgf);
    return localgf.bNG.ret == 1;
  }
  
  public static com.tencent.mm.plugin.fav.a.g fu(long paramLong)
  {
    return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.b
 * JD-Core Version:    0.7.0.1
 */