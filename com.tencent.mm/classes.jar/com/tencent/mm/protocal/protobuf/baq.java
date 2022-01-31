package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baq
  extends com.tencent.mm.bv.a
{
  public String lGx;
  public double wyO;
  public double wyP;
  public String xpT;
  public String xpU;
  public String xpV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28541);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.wyP);
      paramVarArgs.f(2, this.wyO);
      if (this.lGx != null) {
        paramVarArgs.e(3, this.lGx);
      }
      if (this.xpT != null) {
        paramVarArgs.e(4, this.xpT);
      }
      if (this.xpU != null) {
        paramVarArgs.e(5, this.xpU);
      }
      if (this.xpV != null) {
        paramVarArgs.e(6, this.xpV);
      }
      AppMethodBeat.o(28541);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 8 + 0 + (e.a.a.b.b.a.eW(2) + 8);
      paramInt = i;
      if (this.lGx != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGx);
      }
      i = paramInt;
      if (this.xpT != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xpT);
      }
      paramInt = i;
      if (this.xpU != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xpU);
      }
      i = paramInt;
      if (this.xpV != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xpV);
      }
      AppMethodBeat.o(28541);
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
      AppMethodBeat.o(28541);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      baq localbaq = (baq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28541);
        return -1;
      case 1: 
        localbaq.wyP = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(28541);
        return 0;
      case 2: 
        localbaq.wyO = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(28541);
        return 0;
      case 3: 
        localbaq.lGx = locala.CLY.readString();
        AppMethodBeat.o(28541);
        return 0;
      case 4: 
        localbaq.xpT = locala.CLY.readString();
        AppMethodBeat.o(28541);
        return 0;
      case 5: 
        localbaq.xpU = locala.CLY.readString();
        AppMethodBeat.o(28541);
        return 0;
      }
      localbaq.xpV = locala.CLY.readString();
      AppMethodBeat.o(28541);
      return 0;
    }
    AppMethodBeat.o(28541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baq
 * JD-Core Version:    0.7.0.1
 */