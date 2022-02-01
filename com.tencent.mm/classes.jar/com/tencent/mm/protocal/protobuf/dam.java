package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dam
  extends com.tencent.mm.bw.a
{
  public int FJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125790);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aR(1, this.FJE);
      AppMethodBeat.o(125790);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FJE);
      AppMethodBeat.o(125790);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dam localdam = (dam)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125790);
        return -1;
      }
      localdam.FJE = locala.LVo.xF();
      AppMethodBeat.o(125790);
      return 0;
    }
    AppMethodBeat.o(125790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dam
 * JD-Core Version:    0.7.0.1
 */