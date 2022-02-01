package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bia
  extends com.tencent.mm.bw.a
{
  public String EXn;
  public int EXo;
  public int EXp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXn != null) {
        paramVarArgs.d(1, this.EXn);
      }
      paramVarArgs.aR(2, this.EXo);
      paramVarArgs.aR(3, this.EXp);
      AppMethodBeat.o(43097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EXn == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.EXn) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EXo);
      int j = f.a.a.b.b.a.bx(3, this.EXp);
      AppMethodBeat.o(43097);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43097);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bia localbia = (bia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43097);
          return -1;
        case 1: 
          localbia.EXn = locala.LVo.readString();
          AppMethodBeat.o(43097);
          return 0;
        case 2: 
          localbia.EXo = locala.LVo.xF();
          AppMethodBeat.o(43097);
          return 0;
        }
        localbia.EXp = locala.LVo.xF();
        AppMethodBeat.o(43097);
        return 0;
      }
      AppMethodBeat.o(43097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bia
 * JD-Core Version:    0.7.0.1
 */