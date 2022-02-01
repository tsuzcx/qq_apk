package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anc
  extends com.tencent.mm.bw.a
{
  public float EGk;
  public long dig;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.dig);
      paramVarArgs.x(2, this.EGk);
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.dig);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(184208);
      return paramInt + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      anc localanc = (anc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184208);
        return -1;
      case 1: 
        localanc.dig = locala.LVo.xG();
        AppMethodBeat.o(184208);
        return 0;
      }
      localanc.EGk = Float.intBitsToFloat(locala.LVo.gaa());
      AppMethodBeat.o(184208);
      return 0;
    }
    AppMethodBeat.o(184208);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anc
 * JD-Core Version:    0.7.0.1
 */