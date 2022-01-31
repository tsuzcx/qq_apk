package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.avj;
import com.tencent.mm.protocal.c.cik;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class b$g
{
  public String bOE = "";
  public long dFf = 0L;
  public long qZl = 0L;
  public int scene = 0;
  
  public b$g() {}
  
  public b$g(cik paramcik)
  {
    this.scene = 201;
    this.bOE = paramcik.bOE;
    this.dFf = paramcik.dDr;
    this.qZl = (System.currentTimeMillis() / 1000L);
  }
  
  static String BO(int paramInt)
  {
    String str = x.fB(ae.getContext());
    return "SearchGuide_" + paramInt + "-" + str;
  }
  
  public static g caA()
  {
    au.Hx();
    Object localObject1 = new File(c.FJ(), BO(201));
    localObject2 = e.c(((File)localObject1).getAbsolutePath(), 0, (int)((File)localObject1).length());
    try
    {
      localObject1 = new avj();
      ((avj)localObject1).aH((byte[])localObject2);
      localObject2 = new g();
      return localObject2;
    }
    catch (Exception localException1)
    {
      try
      {
        ((g)localObject2).scene = ((avj)localObject1).pyo;
        ((g)localObject2).bOE = ((avj)localObject1).sEb;
        ((g)localObject2).dFf = ((avj)localObject1).tqR;
        ((g)localObject2).qZl = ((avj)localObject1).tqQ;
        return localObject2;
      }
      catch (Exception localException2) {}
      localException1 = localException1;
      return null;
    }
  }
  
  public final boolean caB()
  {
    return this.qZl + this.dFf <= System.currentTimeMillis() / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.g
 * JD-Core Version:    0.7.0.1
 */