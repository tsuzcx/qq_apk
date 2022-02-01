package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dde
  extends com.tencent.mm.bw.a
{
  public int FMQ;
  public boolean FMR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FMQ);
      paramVarArgs.bl(2, this.FMR);
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FMQ);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(116476);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dde localdde = (dde)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116476);
        return -1;
      case 1: 
        localdde.FMQ = locala.LVo.xF();
        AppMethodBeat.o(116476);
        return 0;
      }
      localdde.FMR = locala.LVo.fZX();
      AppMethodBeat.o(116476);
      return 0;
    }
    AppMethodBeat.o(116476);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dde
 * JD-Core Version:    0.7.0.1
 */