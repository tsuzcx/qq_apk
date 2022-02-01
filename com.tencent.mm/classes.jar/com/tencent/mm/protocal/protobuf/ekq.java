package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekq
  extends com.tencent.mm.bw.a
{
  public int score;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aS(2, this.score);
      AppMethodBeat.o(32572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.score);
      AppMethodBeat.o(32572);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32572);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ekq localekq = (ekq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32572);
          return -1;
        case 1: 
          localekq.title = locala.OmT.readString();
          AppMethodBeat.o(32572);
          return 0;
        }
        localekq.score = locala.OmT.zc();
        AppMethodBeat.o(32572);
        return 0;
      }
      AppMethodBeat.o(32572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekq
 * JD-Core Version:    0.7.0.1
 */