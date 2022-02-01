package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehz
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> UjW;
  public LinkedList<String> UjX;
  public LinkedList<Integer> UjY;
  public LinkedList<Integer> UjZ;
  
  public ehz()
  {
    AppMethodBeat.i(114079);
    this.UjW = new LinkedList();
    this.UjX = new LinkedList();
    this.UjY = new LinkedList();
    this.UjZ = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.UjW);
      paramVarArgs.e(2, 1, this.UjX);
      paramVarArgs.e(3, 2, this.UjY);
      paramVarArgs.e(4, 2, this.UjZ);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.UjW);
      int i = g.a.a.a.c(2, 1, this.UjX);
      int j = g.a.a.a.c(3, 2, this.UjY);
      int k = g.a.a.a.c(4, 2, this.UjZ);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UjW.clear();
      this.UjX.clear();
      this.UjY.clear();
      this.UjZ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ehz localehz = (ehz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localehz.UjW.add(locala.abFh.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localehz.UjX.add(locala.abFh.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localehz.UjY.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localehz.UjZ.add(Integer.valueOf(locala.abFh.AK()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehz
 * JD-Core Version:    0.7.0.1
 */