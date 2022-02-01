package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqs
  extends com.tencent.mm.bw.a
{
  public long HXA;
  public long HXB;
  public long HXC;
  public double HXD;
  public double HXE;
  public double HXF;
  public double HXG;
  public long HXH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HXA);
      paramVarArgs.aZ(2, this.HXB);
      paramVarArgs.aZ(3, this.HXC);
      paramVarArgs.e(4, this.HXD);
      paramVarArgs.e(5, this.HXE);
      paramVarArgs.e(6, this.HXF);
      paramVarArgs.e(7, this.HXG);
      paramVarArgs.aZ(8, this.HXH);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HXA);
      int i = f.a.a.b.b.a.p(2, this.HXB);
      int j = f.a.a.b.b.a.p(3, this.HXC);
      int k = f.a.a.b.b.a.amD(4);
      int m = f.a.a.b.b.a.amD(5);
      int n = f.a.a.b.b.a.amD(6);
      int i1 = f.a.a.b.b.a.amD(7);
      int i2 = f.a.a.b.b.a.p(8, this.HXH);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqs localdqs = (dqs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localdqs.HXA = locala.OmT.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localdqs.HXB = locala.OmT.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localdqs.HXC = locala.OmT.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localdqs.HXD = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localdqs.HXE = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localdqs.HXF = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localdqs.HXG = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(110914);
        return 0;
      }
      localdqs.HXH = locala.OmT.zd();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqs
 * JD-Core Version:    0.7.0.1
 */