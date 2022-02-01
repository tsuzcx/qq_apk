package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public int zHR;
  public long zHT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.zHT);
      paramVarArgs.aS(2, this.zHR);
      AppMethodBeat.o(96157);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.zHT);
      int i = f.a.a.b.b.a.bz(2, this.zHR);
      AppMethodBeat.o(96157);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(96157);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96157);
        return -1;
      case 1: 
        localf.zHT = locala.OmT.zd();
        AppMethodBeat.o(96157);
        return 0;
      }
      localf.zHR = locala.OmT.zc();
      AppMethodBeat.o(96157);
      return 0;
    }
    AppMethodBeat.o(96157);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.f
 * JD-Core Version:    0.7.0.1
 */