package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bly
  extends com.tencent.mm.bw.a
{
  public int DTW;
  public String Fbj;
  public String Fbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fbj != null) {
        paramVarArgs.d(1, this.Fbj);
      }
      paramVarArgs.aR(2, this.DTW);
      if (this.Fbk != null) {
        paramVarArgs.d(3, this.Fbk);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fbj == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fbj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DTW);
      paramInt = i;
      if (this.Fbk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fbk);
      }
      AppMethodBeat.o(82432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bly localbly = (bly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localbly.Fbj = locala.LVo.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localbly.DTW = locala.LVo.xF();
          AppMethodBeat.o(82432);
          return 0;
        }
        localbly.Fbk = locala.LVo.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bly
 * JD-Core Version:    0.7.0.1
 */