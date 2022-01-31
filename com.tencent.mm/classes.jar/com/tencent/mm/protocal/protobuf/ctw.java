package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class ctw
  extends com.tencent.mm.bv.a
{
  public int afm;
  public String category;
  public int fQD;
  public b wPX;
  public int xKQ;
  public int ycK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102401);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.fQD);
      paramVarArgs.aO(2, this.afm);
      if (this.category != null) {
        paramVarArgs.e(3, this.category);
      }
      if (this.wPX != null) {
        paramVarArgs.c(4, this.wPX);
      }
      paramVarArgs.aO(5, this.xKQ);
      paramVarArgs.aO(6, this.ycK);
      AppMethodBeat.o(102401);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.fQD) + 0 + e.a.a.b.b.a.bl(2, this.afm);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.category);
      }
      i = paramInt;
      if (this.wPX != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.wPX);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xKQ);
      int j = e.a.a.b.b.a.bl(6, this.ycK);
      AppMethodBeat.o(102401);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102401);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ctw localctw = (ctw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102401);
        return -1;
      case 1: 
        localctw.fQD = locala.CLY.sl();
        AppMethodBeat.o(102401);
        return 0;
      case 2: 
        localctw.afm = locala.CLY.sl();
        AppMethodBeat.o(102401);
        return 0;
      case 3: 
        localctw.category = locala.CLY.readString();
        AppMethodBeat.o(102401);
        return 0;
      case 4: 
        localctw.wPX = locala.CLY.eqS();
        AppMethodBeat.o(102401);
        return 0;
      case 5: 
        localctw.xKQ = locala.CLY.sl();
        AppMethodBeat.o(102401);
        return 0;
      }
      localctw.ycK = locala.CLY.sl();
      AppMethodBeat.o(102401);
      return 0;
    }
    AppMethodBeat.o(102401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctw
 * JD-Core Version:    0.7.0.1
 */