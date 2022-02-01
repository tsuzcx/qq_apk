package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public final String Itr;
  public final long LGb;
  public final long LGc;
  public final boolean LGd;
  final FileSystem.b LGe;
  public final String name;
  public final long size;
  
  public c(FileSystem.b paramb, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.LGe = paramb;
    this.Itr = paramString1;
    this.name = paramString2;
    this.size = paramLong1;
    this.LGb = paramLong2;
    this.LGc = paramLong3;
    this.LGd = paramBoolean;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(193368);
    if (this.LGd)
    {
      bool = this.LGe.dd(this.Itr, false);
      AppMethodBeat.o(193368);
      return bool;
    }
    boolean bool = this.LGe.Dc(this.Itr);
    AppMethodBeat.o(193368);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193369);
    String str = this.Itr + " -> " + this.LGe.fSK().toString();
    if (this.LGd)
    {
      str = "[DIR] ".concat(String.valueOf(str));
      AppMethodBeat.o(193369);
      return str;
    }
    AppMethodBeat.o(193369);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.c
 * JD-Core Version:    0.7.0.1
 */