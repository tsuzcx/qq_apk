package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnj
  extends com.tencent.mm.bw.a
{
  public String FAD;
  public String FAE;
  public int FAF;
  public int FuV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FuV);
      if (this.FAD != null) {
        paramVarArgs.d(2, this.FAD);
      }
      if (this.FAE != null) {
        paramVarArgs.d(3, this.FAE);
      }
      paramVarArgs.aR(4, this.FAF);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FuV) + 0;
      paramInt = i;
      if (this.FAD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FAD);
      }
      i = paramInt;
      if (this.FAE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAE);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.FAF);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnj localcnj = (cnj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localcnj.FuV = locala.LVo.xF();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localcnj.FAD = locala.LVo.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localcnj.FAE = locala.LVo.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localcnj.FAF = locala.LVo.xF();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnj
 * JD-Core Version:    0.7.0.1
 */