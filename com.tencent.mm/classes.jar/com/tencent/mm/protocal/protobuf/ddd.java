package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddd
  extends com.tencent.mm.bw.a
{
  public int kar;
  public int oxC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oxC);
      paramVarArgs.aR(2, this.kar);
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.oxC);
      int i = f.a.a.b.b.a.bx(2, this.kar);
      AppMethodBeat.o(116817);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddd localddd = (ddd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116817);
        return -1;
      case 1: 
        localddd.oxC = locala.LVo.xF();
        AppMethodBeat.o(116817);
        return 0;
      }
      localddd.kar = locala.LVo.xF();
      AppMethodBeat.o(116817);
      return 0;
    }
    AppMethodBeat.o(116817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddd
 * JD-Core Version:    0.7.0.1
 */