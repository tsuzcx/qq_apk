package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctk
  extends com.tencent.mm.bw.a
{
  public String EfU;
  public String FFi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EfU != null) {
        paramVarArgs.d(1, this.EfU);
      }
      if (this.FFi != null) {
        paramVarArgs.d(2, this.FFi);
      }
      AppMethodBeat.o(117919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EfU == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EfU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FFi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FFi);
      }
      AppMethodBeat.o(117919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117919);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctk localctk = (ctk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117919);
          return -1;
        case 1: 
          localctk.EfU = locala.LVo.readString();
          AppMethodBeat.o(117919);
          return 0;
        }
        localctk.FFi = locala.LVo.readString();
        AppMethodBeat.o(117919);
        return 0;
      }
      AppMethodBeat.o(117919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctk
 * JD-Core Version:    0.7.0.1
 */