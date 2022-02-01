package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajr
  extends com.tencent.mm.bw.a
{
  public int Cjg;
  public String Cjh;
  public String Cji;
  public int Cjj;
  public String ixw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Cjg);
      if (this.Cjh != null) {
        paramVarArgs.e(2, this.Cjh);
      }
      if (this.Cji != null) {
        paramVarArgs.e(3, this.Cji);
      }
      paramVarArgs.aM(4, this.Cjj);
      if (this.ixw != null) {
        paramVarArgs.e(5, this.ixw);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Cjg) + 0;
      paramInt = i;
      if (this.Cjh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Cjh);
      }
      i = paramInt;
      if (this.Cji != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Cji);
      }
      i += g.a.a.b.b.a.bu(4, this.Cjj);
      paramInt = i;
      if (this.ixw != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ixw);
      }
      AppMethodBeat.o(72474);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ajr localajr = (ajr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localajr.Cjg = locala.UbS.zi();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localajr.Cjh = locala.UbS.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localajr.Cji = locala.UbS.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localajr.Cjj = locala.UbS.zi();
        AppMethodBeat.o(72474);
        return 0;
      }
      localajr.ixw = locala.UbS.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajr
 * JD-Core Version:    0.7.0.1
 */