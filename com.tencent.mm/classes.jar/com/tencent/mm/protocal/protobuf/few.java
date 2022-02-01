package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class few
  extends com.tencent.mm.cd.a
{
  public int UFA;
  public int UFB;
  public int UFC;
  public int UFy;
  public int UFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UFy);
      paramVarArgs.aY(2, this.UFz);
      paramVarArgs.aY(3, this.UFA);
      paramVarArgs.aY(4, this.UFB);
      paramVarArgs.aY(5, this.UFC);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UFy);
      int i = g.a.a.b.b.a.bM(2, this.UFz);
      int j = g.a.a.b.b.a.bM(3, this.UFA);
      int k = g.a.a.b.b.a.bM(4, this.UFB);
      int m = g.a.a.b.b.a.bM(5, this.UFC);
      AppMethodBeat.o(115910);
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
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      few localfew = (few)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localfew.UFy = locala.abFh.AK();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localfew.UFz = locala.abFh.AK();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localfew.UFA = locala.abFh.AK();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localfew.UFB = locala.abFh.AK();
        AppMethodBeat.o(115910);
        return 0;
      }
      localfew.UFC = locala.abFh.AK();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.few
 * JD-Core Version:    0.7.0.1
 */