package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cly
  extends com.tencent.mm.bv.a
{
  public int xVX;
  public int xVY;
  public String xVZ;
  public b xWa;
  public int xWb;
  public int xWc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10245);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xVX);
      paramVarArgs.aO(2, this.xVY);
      if (this.xVZ != null) {
        paramVarArgs.e(3, this.xVZ);
      }
      if (this.xWa != null) {
        paramVarArgs.c(4, this.xWa);
      }
      paramVarArgs.aO(5, this.xWb);
      paramVarArgs.aO(6, this.xWc);
      AppMethodBeat.o(10245);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xVX) + 0 + e.a.a.b.b.a.bl(2, this.xVY);
      paramInt = i;
      if (this.xVZ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xVZ);
      }
      i = paramInt;
      if (this.xWa != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.xWa);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xWb);
      int j = e.a.a.b.b.a.bl(6, this.xWc);
      AppMethodBeat.o(10245);
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
      AppMethodBeat.o(10245);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cly localcly = (cly)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(10245);
        return -1;
      case 1: 
        localcly.xVX = locala.CLY.sl();
        AppMethodBeat.o(10245);
        return 0;
      case 2: 
        localcly.xVY = locala.CLY.sl();
        AppMethodBeat.o(10245);
        return 0;
      case 3: 
        localcly.xVZ = locala.CLY.readString();
        AppMethodBeat.o(10245);
        return 0;
      case 4: 
        localcly.xWa = locala.CLY.eqS();
        AppMethodBeat.o(10245);
        return 0;
      case 5: 
        localcly.xWb = locala.CLY.sl();
        AppMethodBeat.o(10245);
        return 0;
      }
      localcly.xWc = locala.CLY.sl();
      AppMethodBeat.o(10245);
      return 0;
    }
    AppMethodBeat.o(10245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cly
 * JD-Core Version:    0.7.0.1
 */