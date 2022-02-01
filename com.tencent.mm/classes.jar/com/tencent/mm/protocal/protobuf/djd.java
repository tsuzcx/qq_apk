package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djd
  extends com.tencent.mm.bw.a
{
  public String AWP;
  public String hiu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.AWP != null) {
        paramVarArgs.d(1, this.AWP);
      }
      if (this.hiu != null) {
        paramVarArgs.d(2, this.hiu);
      }
      AppMethodBeat.o(91719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AWP == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.AWP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hiu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hiu);
      }
      AppMethodBeat.o(91719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91719);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djd localdjd = (djd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91719);
          return -1;
        case 1: 
          localdjd.AWP = locala.LVo.readString();
          AppMethodBeat.o(91719);
          return 0;
        }
        localdjd.hiu = locala.LVo.readString();
        AppMethodBeat.o(91719);
        return 0;
      }
      AppMethodBeat.o(91719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djd
 * JD-Core Version:    0.7.0.1
 */