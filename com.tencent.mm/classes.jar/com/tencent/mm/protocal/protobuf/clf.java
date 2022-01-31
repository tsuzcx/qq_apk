package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clf
  extends com.tencent.mm.bv.a
{
  public String Name;
  public double wyO;
  public double wyP;
  public String xyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113792);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.wyP);
      paramVarArgs.f(2, this.wyO);
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.xyb != null) {
        paramVarArgs.e(4, this.xyb);
      }
      AppMethodBeat.o(113792);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 8 + 0 + (e.a.a.b.b.a.eW(2) + 8);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Name);
      }
      i = paramInt;
      if (this.xyb != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xyb);
      }
      AppMethodBeat.o(113792);
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
      AppMethodBeat.o(113792);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      clf localclf = (clf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113792);
        return -1;
      case 1: 
        localclf.wyP = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(113792);
        return 0;
      case 2: 
        localclf.wyO = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(113792);
        return 0;
      case 3: 
        localclf.Name = locala.CLY.readString();
        AppMethodBeat.o(113792);
        return 0;
      }
      localclf.xyb = locala.CLY.readString();
      AppMethodBeat.o(113792);
      return 0;
    }
    AppMethodBeat.o(113792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clf
 * JD-Core Version:    0.7.0.1
 */