package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fon
  extends com.tencent.mm.cd.a
{
  public int UME;
  public int UMF;
  public int UMG;
  public int UMH;
  public int UMI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UME);
      paramVarArgs.aY(2, this.UMF);
      paramVarArgs.aY(3, this.UMG);
      paramVarArgs.aY(4, this.UMH);
      paramVarArgs.aY(5, this.UMI);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UME);
      int i = g.a.a.b.b.a.bM(2, this.UMF);
      int j = g.a.a.b.b.a.bM(3, this.UMG);
      int k = g.a.a.b.b.a.bM(4, this.UMH);
      int m = g.a.a.b.b.a.bM(5, this.UMI);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fon localfon = (fon)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localfon.UME = locala.abFh.AK();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localfon.UMF = locala.abFh.AK();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localfon.UMG = locala.abFh.AK();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localfon.UMH = locala.abFh.AK();
        AppMethodBeat.o(50122);
        return 0;
      }
      localfon.UMI = locala.abFh.AK();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fon
 * JD-Core Version:    0.7.0.1
 */