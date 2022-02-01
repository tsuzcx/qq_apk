package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcw
  extends com.tencent.mm.bw.a
{
  public int LLE;
  public int LMd;
  public String dQx;
  public long uOx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209685);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LMd);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      paramVarArgs.aM(3, this.LLE);
      paramVarArgs.bb(4, this.uOx);
      AppMethodBeat.o(209685);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LMd) + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = g.a.a.b.b.a.bu(3, this.LLE);
      int j = g.a.a.b.b.a.r(4, this.uOx);
      AppMethodBeat.o(209685);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209685);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bcw localbcw = (bcw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209685);
        return -1;
      case 1: 
        localbcw.LMd = locala.UbS.zi();
        AppMethodBeat.o(209685);
        return 0;
      case 2: 
        localbcw.dQx = locala.UbS.readString();
        AppMethodBeat.o(209685);
        return 0;
      case 3: 
        localbcw.LLE = locala.UbS.zi();
        AppMethodBeat.o(209685);
        return 0;
      }
      localbcw.uOx = locala.UbS.zl();
      AppMethodBeat.o(209685);
      return 0;
    }
    AppMethodBeat.o(209685);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcw
 * JD-Core Version:    0.7.0.1
 */