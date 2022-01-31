package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdq
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public int qsl;
  public String wot;
  public int xtm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5597);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wot != null) {
        paramVarArgs.e(1, this.wot);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.xtm);
      paramVarArgs.aO(4, this.qsl);
      AppMethodBeat.o(5597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wot == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = e.a.a.b.b.a.f(1, this.wot) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xtm);
      int j = e.a.a.b.b.a.bl(4, this.qsl);
      AppMethodBeat.o(5597);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5597);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(5597);
          return -1;
        case 1: 
          localbdq.wot = locala.CLY.readString();
          AppMethodBeat.o(5597);
          return 0;
        case 2: 
          localbdq.jJA = locala.CLY.readString();
          AppMethodBeat.o(5597);
          return 0;
        case 3: 
          localbdq.xtm = locala.CLY.sl();
          AppMethodBeat.o(5597);
          return 0;
        }
        localbdq.qsl = locala.CLY.sl();
        AppMethodBeat.o(5597);
        return 0;
      }
      AppMethodBeat.o(5597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdq
 * JD-Core Version:    0.7.0.1
 */