package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brd
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String wSo;
  public String wYu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102512);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.wYu != null) {
        paramVarArgs.e(2, this.wYu);
      }
      if (this.wSo != null) {
        paramVarArgs.e(3, this.wSo);
      }
      AppMethodBeat.o(102512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wYu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wYu);
      }
      i = paramInt;
      if (this.wSo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wSo);
      }
      AppMethodBeat.o(102512);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102512);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        brd localbrd = (brd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102512);
          return -1;
        case 1: 
          localbrd.jJA = locala.CLY.readString();
          AppMethodBeat.o(102512);
          return 0;
        case 2: 
          localbrd.wYu = locala.CLY.readString();
          AppMethodBeat.o(102512);
          return 0;
        }
        localbrd.wSo = locala.CLY.readString();
        AppMethodBeat.o(102512);
        return 0;
      }
      AppMethodBeat.o(102512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brd
 * JD-Core Version:    0.7.0.1
 */