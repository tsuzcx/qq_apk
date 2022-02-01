package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtu
  extends com.tencent.mm.cd.a
{
  public int TZU;
  public int TZV;
  public LinkedList<String> TZW;
  public int TZX;
  public int Tei;
  
  public dtu()
  {
    AppMethodBeat.i(117893);
    this.TZW = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TZU);
      paramVarArgs.aY(2, this.TZV);
      paramVarArgs.aY(3, this.Tei);
      paramVarArgs.e(4, 1, this.TZW);
      paramVarArgs.aY(5, this.TZX);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TZU);
      int i = g.a.a.b.b.a.bM(2, this.TZV);
      int j = g.a.a.b.b.a.bM(3, this.Tei);
      int k = g.a.a.a.c(4, 1, this.TZW);
      int m = g.a.a.b.b.a.bM(5, this.TZX);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TZW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dtu localdtu = (dtu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localdtu.TZU = locala.abFh.AK();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localdtu.TZV = locala.abFh.AK();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localdtu.Tei = locala.abFh.AK();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localdtu.TZW.add(locala.abFh.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localdtu.TZX = locala.abFh.AK();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtu
 * JD-Core Version:    0.7.0.1
 */