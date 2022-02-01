package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfw
  extends com.tencent.mm.bw.a
{
  public int MKG;
  public int MKH;
  public int MKI;
  public int rBL;
  public String rBM;
  public int ypM;
  public String ypN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MKH);
      paramVarArgs.aM(2, this.MKI);
      paramVarArgs.aM(3, this.MKG);
      paramVarArgs.aM(4, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(5, this.rBM);
      }
      paramVarArgs.aM(6, this.ypM);
      if (this.ypN != null) {
        paramVarArgs.e(7, this.ypN);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MKH) + 0 + g.a.a.b.b.a.bu(2, this.MKI) + g.a.a.b.b.a.bu(3, this.MKG) + g.a.a.b.b.a.bu(4, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.rBM);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.ypM);
      paramInt = i;
      if (this.ypN != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.ypN);
      }
      AppMethodBeat.o(32392);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dfw localdfw = (dfw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localdfw.MKH = locala.UbS.zi();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localdfw.MKI = locala.UbS.zi();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localdfw.MKG = locala.UbS.zi();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localdfw.rBL = locala.UbS.zi();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localdfw.rBM = locala.UbS.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localdfw.ypM = locala.UbS.zi();
        AppMethodBeat.o(32392);
        return 0;
      }
      localdfw.ypN = locala.UbS.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfw
 * JD-Core Version:    0.7.0.1
 */