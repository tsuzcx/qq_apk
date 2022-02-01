package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtm
  extends com.tencent.mm.bw.a
{
  public String FaF;
  public long GbC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.GbC);
      if (this.FaF != null) {
        paramVarArgs.d(2, this.FaF);
      }
      AppMethodBeat.o(147788);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GbC) + 0;
      paramInt = i;
      if (this.FaF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FaF);
      }
      AppMethodBeat.o(147788);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(147788);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtm localdtm = (dtm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147788);
        return -1;
      case 1: 
        localdtm.GbC = locala.LVo.xG();
        AppMethodBeat.o(147788);
        return 0;
      }
      localdtm.FaF = locala.LVo.readString();
      AppMethodBeat.o(147788);
      return 0;
    }
    AppMethodBeat.o(147788);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */