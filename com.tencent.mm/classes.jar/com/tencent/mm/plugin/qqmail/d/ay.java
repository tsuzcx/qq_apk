package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bx.a
{
  public long xdr;
  public String xds;
  public String xdt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215241);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.xdr);
      if (this.xds != null) {
        paramVarArgs.d(2, this.xds);
      }
      if (this.xdt != null) {
        paramVarArgs.d(3, this.xdt);
      }
      AppMethodBeat.o(215241);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.xdr) + 0;
      paramInt = i;
      if (this.xds != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xds);
      }
      i = paramInt;
      if (this.xdt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xdt);
      }
      AppMethodBeat.o(215241);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215241);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215241);
        return -1;
      case 1: 
        localay.xdr = locala.NPN.zd();
        AppMethodBeat.o(215241);
        return 0;
      case 2: 
        localay.xds = locala.NPN.readString();
        AppMethodBeat.o(215241);
        return 0;
      }
      localay.xdt = locala.NPN.readString();
      AppMethodBeat.o(215241);
      return 0;
    }
    AppMethodBeat.o(215241);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ay
 * JD-Core Version:    0.7.0.1
 */