package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public int Dxd = 0;
  a Dxe;
  public int id = 0;
  public String md5 = "";
  public String talker = "";
  
  protected final Object clone()
  {
    AppMethodBeat.i(30012);
    f localf = new f();
    localf.id = this.id;
    localf.talker = this.talker;
    localf.md5 = this.md5;
    localf.Dxd = this.Dxd;
    localf.Dxe = this.Dxe;
    AppMethodBeat.o(30012);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30013);
    String str = "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.md5 + ", ignoreInWatch=" + this.Dxd + ", status=" + this.Dxe + "]";
    AppMethodBeat.o(30013);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(30011);
      Dxf = new a("INIT", 0);
      Dxg = new a("SHOWING", 1);
      Dxh = new a("IGNORE", 2);
      Dxi = new a("REPLY", 3);
      Dxj = new a[] { Dxf, Dxg, Dxh, Dxi };
      AppMethodBeat.o(30011);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f
 * JD-Core Version:    0.7.0.1
 */