package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdw
  extends com.tencent.mm.bw.a
{
  public int KLv;
  public String Mjs;
  public String Mjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mjs != null) {
        paramVarArgs.e(1, this.Mjs);
      }
      paramVarArgs.aM(2, this.KLv);
      if (this.Mjt != null) {
        paramVarArgs.e(3, this.Mjt);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mjs == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mjs) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KLv);
      paramInt = i;
      if (this.Mjt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Mjt);
      }
      AppMethodBeat.o(82432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cdw localcdw = (cdw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localcdw.Mjs = locala.UbS.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localcdw.KLv = locala.UbS.zi();
          AppMethodBeat.o(82432);
          return 0;
        }
        localcdw.Mjt = locala.UbS.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdw
 * JD-Core Version:    0.7.0.1
 */