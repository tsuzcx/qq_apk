package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eb
  extends com.tencent.mm.bw.a
{
  public int KHY;
  public int KHZ;
  public int bDU;
  public float bDY;
  public int bHw;
  public int mCp;
  public int mCq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.bHw);
      paramVarArgs.aM(2, this.bDU);
      paramVarArgs.E(3, this.bDY);
      paramVarArgs.aM(4, this.KHY);
      paramVarArgs.aM(5, this.KHZ);
      paramVarArgs.aM(6, this.mCp);
      paramVarArgs.aM(7, this.mCq);
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.bHw);
      int i = g.a.a.b.b.a.bu(2, this.bDU);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.bu(4, this.KHY);
      int m = g.a.a.b.b.a.bu(5, this.KHZ);
      int n = g.a.a.b.b.a.bu(6, this.mCp);
      int i1 = g.a.a.b.b.a.bu(7, this.mCq);
      AppMethodBeat.o(103178);
      return paramInt + 0 + i + (j + 4) + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eb localeb = (eb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103178);
        return -1;
      case 1: 
        localeb.bHw = locala.UbS.zi();
        AppMethodBeat.o(103178);
        return 0;
      case 2: 
        localeb.bDU = locala.UbS.zi();
        AppMethodBeat.o(103178);
        return 0;
      case 3: 
        localeb.bDY = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(103178);
        return 0;
      case 4: 
        localeb.KHY = locala.UbS.zi();
        AppMethodBeat.o(103178);
        return 0;
      case 5: 
        localeb.KHZ = locala.UbS.zi();
        AppMethodBeat.o(103178);
        return 0;
      case 6: 
        localeb.mCp = locala.UbS.zi();
        AppMethodBeat.o(103178);
        return 0;
      }
      localeb.mCq = locala.UbS.zi();
      AppMethodBeat.o(103178);
      return 0;
    }
    AppMethodBeat.o(103178);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eb
 * JD-Core Version:    0.7.0.1
 */