package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csx
  extends com.tencent.mm.bv.a
{
  public String gFE;
  public String userName;
  public int ybW;
  public int ybX;
  public int ybY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5258);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ybW);
      paramVarArgs.aO(2, this.ybX);
      paramVarArgs.aO(3, this.ybY);
      if (this.userName != null) {
        paramVarArgs.e(4, this.userName);
      }
      if (this.gFE != null) {
        paramVarArgs.e(5, this.gFE);
      }
      AppMethodBeat.o(5258);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.ybW) + 0 + e.a.a.b.b.a.bl(2, this.ybX) + e.a.a.b.b.a.bl(3, this.ybY);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.userName);
      }
      i = paramInt;
      if (this.gFE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gFE);
      }
      AppMethodBeat.o(5258);
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
      AppMethodBeat.o(5258);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      csx localcsx = (csx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5258);
        return -1;
      case 1: 
        localcsx.ybW = locala.CLY.sl();
        AppMethodBeat.o(5258);
        return 0;
      case 2: 
        localcsx.ybX = locala.CLY.sl();
        AppMethodBeat.o(5258);
        return 0;
      case 3: 
        localcsx.ybY = locala.CLY.sl();
        AppMethodBeat.o(5258);
        return 0;
      case 4: 
        localcsx.userName = locala.CLY.readString();
        AppMethodBeat.o(5258);
        return 0;
      }
      localcsx.gFE = locala.CLY.readString();
      AppMethodBeat.o(5258);
      return 0;
    }
    AppMethodBeat.o(5258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csx
 * JD-Core Version:    0.7.0.1
 */