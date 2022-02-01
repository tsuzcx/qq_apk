package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djg
  extends com.tencent.mm.bw.a
{
  public long FSs;
  public long FiS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110913);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FiS);
      paramVarArgs.aO(2, this.FSs);
      AppMethodBeat.o(110913);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FiS);
      int i = f.a.a.b.b.a.p(2, this.FSs);
      AppMethodBeat.o(110913);
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
      AppMethodBeat.o(110913);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djg localdjg = (djg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110913);
        return -1;
      case 1: 
        localdjg.FiS = locala.LVo.xG();
        AppMethodBeat.o(110913);
        return 0;
      }
      localdjg.FSs = locala.LVo.xG();
      AppMethodBeat.o(110913);
      return 0;
    }
    AppMethodBeat.o(110913);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djg
 * JD-Core Version:    0.7.0.1
 */