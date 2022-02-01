package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgq
  extends com.tencent.mm.bw.a
{
  public int FPR;
  public String FPS;
  public int FvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FPR);
      paramVarArgs.aR(2, this.FvP);
      if (this.FPS != null) {
        paramVarArgs.d(3, this.FPS);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FPR) + 0 + f.a.a.b.b.a.bx(2, this.FvP);
      paramInt = i;
      if (this.FPS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FPS);
      }
      AppMethodBeat.o(32466);
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
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dgq localdgq = (dgq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localdgq.FPR = locala.LVo.xF();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localdgq.FvP = locala.LVo.xF();
        AppMethodBeat.o(32466);
        return 0;
      }
      localdgq.FPS = locala.LVo.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgq
 * JD-Core Version:    0.7.0.1
 */