package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxx
  extends com.tencent.mm.bv.a
{
  public String czF;
  public String xKw;
  public int xKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80180);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xKw != null) {
        paramVarArgs.e(1, this.xKw);
      }
      if (this.czF != null) {
        paramVarArgs.e(2, this.czF);
      }
      paramVarArgs.aO(3, this.xKx);
      AppMethodBeat.o(80180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKw == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.xKw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.czF != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.czF);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xKx);
      AppMethodBeat.o(80180);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80180);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bxx localbxx = (bxx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80180);
          return -1;
        case 1: 
          localbxx.xKw = locala.CLY.readString();
          AppMethodBeat.o(80180);
          return 0;
        case 2: 
          localbxx.czF = locala.CLY.readString();
          AppMethodBeat.o(80180);
          return 0;
        }
        localbxx.xKx = locala.CLY.sl();
        AppMethodBeat.o(80180);
        return 0;
      }
      AppMethodBeat.o(80180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */