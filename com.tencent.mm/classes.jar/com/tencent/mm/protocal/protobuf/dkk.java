package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkk
  extends com.tencent.mm.bw.a
{
  public long HRo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118458);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aZ(1, this.HRo);
      AppMethodBeat.o(118458);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HRo);
      AppMethodBeat.o(118458);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118458);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkk localdkk = (dkk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118458);
        return -1;
      }
      localdkk.HRo = locala.OmT.zd();
      AppMethodBeat.o(118458);
      return 0;
    }
    AppMethodBeat.o(118458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkk
 * JD-Core Version:    0.7.0.1
 */