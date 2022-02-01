package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public int IxY = 0;
  a IxZ;
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
    localf.IxY = this.IxY;
    localf.IxZ = this.IxZ;
    AppMethodBeat.o(30012);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30013);
    String str = "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.md5 + ", ignoreInWatch=" + this.IxY + ", status=" + this.IxZ + "]";
    AppMethodBeat.o(30013);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(30011);
      Iya = new a("INIT", 0);
      Iyb = new a("SHOWING", 1);
      Iyc = new a("IGNORE", 2);
      Iyd = new a("REPLY", 3);
      Iye = new a[] { Iya, Iyb, Iyc, Iyd };
      AppMethodBeat.o(30011);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f
 * JD-Core Version:    0.7.0.1
 */