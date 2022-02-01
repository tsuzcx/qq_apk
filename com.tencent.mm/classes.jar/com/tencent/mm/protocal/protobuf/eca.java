package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eca
  extends com.tencent.mm.bw.a
{
  public int Llx;
  public int LsZ;
  public int NbR;
  public int NbS;
  public int NbT;
  public int NbU;
  public int NbV;
  public LinkedList<Integer> NbW;
  public int NbX;
  public int NbY;
  public LinkedList<Integer> NbZ;
  public int Nca;
  public int Ncb;
  
  public eca()
  {
    AppMethodBeat.i(115853);
    this.NbW = new LinkedList();
    this.NbZ = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LsZ);
      paramVarArgs.aM(2, this.NbR);
      paramVarArgs.aM(3, this.Llx);
      paramVarArgs.aM(4, this.NbS);
      paramVarArgs.aM(5, this.NbT);
      paramVarArgs.aM(6, this.NbU);
      paramVarArgs.aM(7, this.NbV);
      paramVarArgs.e(8, 2, this.NbW);
      paramVarArgs.aM(9, this.NbX);
      paramVarArgs.aM(10, this.NbY);
      paramVarArgs.e(11, 2, this.NbZ);
      paramVarArgs.aM(12, this.Nca);
      paramVarArgs.aM(13, this.Ncb);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LsZ);
      int i = g.a.a.b.b.a.bu(2, this.NbR);
      int j = g.a.a.b.b.a.bu(3, this.Llx);
      int k = g.a.a.b.b.a.bu(4, this.NbS);
      int m = g.a.a.b.b.a.bu(5, this.NbT);
      int n = g.a.a.b.b.a.bu(6, this.NbU);
      int i1 = g.a.a.b.b.a.bu(7, this.NbV);
      int i2 = g.a.a.a.c(8, 2, this.NbW);
      int i3 = g.a.a.b.b.a.bu(9, this.NbX);
      int i4 = g.a.a.b.b.a.bu(10, this.NbY);
      int i5 = g.a.a.a.c(11, 2, this.NbZ);
      int i6 = g.a.a.b.b.a.bu(12, this.Nca);
      int i7 = g.a.a.b.b.a.bu(13, this.Ncb);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NbW.clear();
      this.NbZ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eca localeca = (eca)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localeca.LsZ = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localeca.NbR = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localeca.Llx = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localeca.NbS = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localeca.NbT = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localeca.NbU = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localeca.NbV = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localeca.NbW.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localeca.NbX = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localeca.NbY = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localeca.NbZ.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localeca.Nca = locala.UbS.zi();
        AppMethodBeat.o(115854);
        return 0;
      }
      localeca.Ncb = locala.UbS.zi();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eca
 * JD-Core Version:    0.7.0.1
 */