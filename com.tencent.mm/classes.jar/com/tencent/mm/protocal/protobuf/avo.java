package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avo
  extends com.tencent.mm.bw.a
{
  public long ELn;
  public int EfV;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      paramVarArgs.aR(2, this.EfV);
      paramVarArgs.aO(3, this.ELn);
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ndI);
      int i = f.a.a.b.b.a.bx(2, this.EfV);
      int j = f.a.a.b.b.a.p(3, this.ELn);
      AppMethodBeat.o(117868);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      avo localavo = (avo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117868);
        return -1;
      case 1: 
        localavo.ndI = locala.LVo.xF();
        AppMethodBeat.o(117868);
        return 0;
      case 2: 
        localavo.EfV = locala.LVo.xF();
        AppMethodBeat.o(117868);
        return 0;
      }
      localavo.ELn = locala.LVo.xG();
      AppMethodBeat.o(117868);
      return 0;
    }
    AppMethodBeat.o(117868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avo
 * JD-Core Version:    0.7.0.1
 */