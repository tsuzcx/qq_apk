package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.d.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cjl;

final class b$b
  extends d
{
  private cjl qRI;
  
  public b$b(b paramb, cjl paramcjl)
  {
    this.qRI = paramcjl;
  }
  
  public final void execute()
  {
    au.Dk().a(1091, this.qRH);
    a locala = new a(this.qRI.tXi, "gh_43f2581f6fd6");
    au.Dk().a(locala, 0);
  }
  
  public final String getName()
  {
    return "RegisterDeviceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.b
 * JD-Core Version:    0.7.0.1
 */