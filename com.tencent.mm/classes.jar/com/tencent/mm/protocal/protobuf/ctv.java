package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class ctv
  extends com.tencent.mm.bv.a
{
  public String eAx;
  public int vA;
  public b wPX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102400);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.vA);
      if (this.eAx != null) {
        paramVarArgs.e(2, this.eAx);
      }
      if (this.wPX != null) {
        paramVarArgs.c(3, this.wPX);
      }
      AppMethodBeat.o(102400);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.vA) + 0;
      paramInt = i;
      if (this.eAx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.eAx);
      }
      i = paramInt;
      if (this.wPX != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.wPX);
      }
      AppMethodBeat.o(102400);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102400);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ctv localctv = (ctv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102400);
        return -1;
      case 1: 
        localctv.vA = locala.CLY.sl();
        AppMethodBeat.o(102400);
        return 0;
      case 2: 
        localctv.eAx = locala.CLY.readString();
        AppMethodBeat.o(102400);
        return 0;
      }
      localctv.wPX = locala.CLY.eqS();
      AppMethodBeat.o(102400);
      return 0;
    }
    AppMethodBeat.o(102400);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctv
 * JD-Core Version:    0.7.0.1
 */