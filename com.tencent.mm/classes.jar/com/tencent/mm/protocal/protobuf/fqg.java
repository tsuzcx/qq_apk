package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqg
  extends com.tencent.mm.bx.a
{
  public long abPU;
  public long abPV;
  public long abPW;
  public double abPX;
  public double abPY;
  public double abPZ;
  public double abQa;
  public long abQb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abPU);
      paramVarArgs.bv(2, this.abPV);
      paramVarArgs.bv(3, this.abPW);
      paramVarArgs.d(4, this.abPX);
      paramVarArgs.d(5, this.abPY);
      paramVarArgs.d(6, this.abPZ);
      paramVarArgs.d(7, this.abQa);
      paramVarArgs.bv(8, this.abQb);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.abPU);
      int i = i.a.a.b.b.a.q(2, this.abPV);
      int j = i.a.a.b.b.a.q(3, this.abPW);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.ko(7);
      int i2 = i.a.a.b.b.a.q(8, this.abQb);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + (k + 8) + (m + 8) + (n + 8) + (i1 + 8) + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fqg localfqg = (fqg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localfqg.abPU = locala.ajGk.aaw();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localfqg.abPV = locala.ajGk.aaw();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localfqg.abPW = locala.ajGk.aaw();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localfqg.abPX = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localfqg.abPY = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localfqg.abPZ = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localfqg.abQa = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(110914);
        return 0;
      }
      localfqg.abQb = locala.ajGk.aaw();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqg
 * JD-Core Version:    0.7.0.1
 */