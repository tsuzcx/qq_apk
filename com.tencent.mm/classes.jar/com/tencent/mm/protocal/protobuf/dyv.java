package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyv
  extends com.tencent.mm.cd.a
{
  public int QZD;
  public int TVM;
  public int UeB;
  public int Uez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TVM);
      paramVarArgs.aY(2, this.UeB);
      paramVarArgs.aY(3, this.Uez);
      paramVarArgs.aY(4, this.QZD);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TVM);
      int i = g.a.a.b.b.a.bM(2, this.UeB);
      int j = g.a.a.b.b.a.bM(3, this.Uez);
      int k = g.a.a.b.b.a.bM(4, this.QZD);
      AppMethodBeat.o(152672);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dyv localdyv = (dyv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localdyv.TVM = locala.abFh.AK();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localdyv.UeB = locala.abFh.AK();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localdyv.Uez = locala.abFh.AK();
        AppMethodBeat.o(152672);
        return 0;
      }
      localdyv.QZD = locala.abFh.AK();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyv
 * JD-Core Version:    0.7.0.1
 */