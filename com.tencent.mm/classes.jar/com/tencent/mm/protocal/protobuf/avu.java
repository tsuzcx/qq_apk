package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avu
  extends com.tencent.mm.bx.a
{
  public int ZFQ;
  public int ZFR;
  public int ZFS;
  public int ZFT;
  public int ZFU;
  public int ZFV;
  public int ZFW;
  public int count;
  public int fans_count;
  public int oRy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.count);
      paramVarArgs.bS(2, this.ZFQ);
      paramVarArgs.bS(3, this.ZFR);
      paramVarArgs.bS(4, this.ZFS);
      paramVarArgs.bS(5, this.ZFT);
      paramVarArgs.bS(7, this.fans_count);
      paramVarArgs.bS(8, this.ZFU);
      paramVarArgs.bS(9, this.oRy);
      paramVarArgs.bS(10, this.ZFV);
      paramVarArgs.bS(11, this.ZFW);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.count);
      int i = i.a.a.b.b.a.cJ(2, this.ZFQ);
      int j = i.a.a.b.b.a.cJ(3, this.ZFR);
      int k = i.a.a.b.b.a.cJ(4, this.ZFS);
      int m = i.a.a.b.b.a.cJ(5, this.ZFT);
      int n = i.a.a.b.b.a.cJ(7, this.fans_count);
      int i1 = i.a.a.b.b.a.cJ(8, this.ZFU);
      int i2 = i.a.a.b.b.a.cJ(9, this.oRy);
      int i3 = i.a.a.b.b.a.cJ(10, this.ZFV);
      int i4 = i.a.a.b.b.a.cJ(11, this.ZFW);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      avu localavu = (avu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localavu.count = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localavu.ZFQ = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localavu.ZFR = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localavu.ZFS = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localavu.ZFT = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localavu.fans_count = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localavu.ZFU = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localavu.oRy = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      case 10: 
        localavu.ZFV = locala.ajGk.aar();
        AppMethodBeat.o(168947);
        return 0;
      }
      localavu.ZFW = locala.ajGk.aar();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avu
 * JD-Core Version:    0.7.0.1
 */