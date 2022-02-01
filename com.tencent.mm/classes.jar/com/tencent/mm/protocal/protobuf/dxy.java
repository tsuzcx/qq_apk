package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxy
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> MXB;
  public LinkedList<String> MXC;
  public LinkedList<Integer> MXD;
  public LinkedList<Integer> MXE;
  
  public dxy()
  {
    AppMethodBeat.i(114079);
    this.MXB = new LinkedList();
    this.MXC = new LinkedList();
    this.MXD = new LinkedList();
    this.MXE = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.MXB);
      paramVarArgs.e(2, 1, this.MXC);
      paramVarArgs.e(3, 2, this.MXD);
      paramVarArgs.e(4, 2, this.MXE);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.MXB);
      int i = g.a.a.a.c(2, 1, this.MXC);
      int j = g.a.a.a.c(3, 2, this.MXD);
      int k = g.a.a.a.c(4, 2, this.MXE);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MXB.clear();
      this.MXC.clear();
      this.MXD.clear();
      this.MXE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dxy localdxy = (dxy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localdxy.MXB.add(locala.UbS.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localdxy.MXC.add(locala.UbS.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localdxy.MXD.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localdxy.MXE.add(Integer.valueOf(locala.UbS.zi()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxy
 * JD-Core Version:    0.7.0.1
 */