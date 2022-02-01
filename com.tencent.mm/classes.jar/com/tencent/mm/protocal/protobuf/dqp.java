package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqp
  extends com.tencent.mm.bw.a
{
  public int DTc;
  public int DTd;
  public int DTe;
  public int DTf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DTc);
      paramVarArgs.aR(2, this.DTd);
      paramVarArgs.aR(3, this.DTe);
      paramVarArgs.aR(4, this.DTf);
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DTc);
      int i = f.a.a.b.b.a.bx(2, this.DTd);
      int j = f.a.a.b.b.a.bx(3, this.DTe);
      int k = f.a.a.b.b.a.bx(4, this.DTf);
      AppMethodBeat.o(32498);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqp localdqp = (dqp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32498);
        return -1;
      case 1: 
        localdqp.DTc = locala.LVo.xF();
        AppMethodBeat.o(32498);
        return 0;
      case 2: 
        localdqp.DTd = locala.LVo.xF();
        AppMethodBeat.o(32498);
        return 0;
      case 3: 
        localdqp.DTe = locala.LVo.xF();
        AppMethodBeat.o(32498);
        return 0;
      }
      localdqp.DTf = locala.LVo.xF();
      AppMethodBeat.o(32498);
      return 0;
    }
    AppMethodBeat.o(32498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqp
 * JD-Core Version:    0.7.0.1
 */