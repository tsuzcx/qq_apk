package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clp
  extends com.tencent.mm.cd.a
{
  public int Ttf;
  public int Ttg;
  public int Tth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ttf);
      paramVarArgs.aY(2, this.Ttg);
      paramVarArgs.aY(3, this.Tth);
      AppMethodBeat.o(209712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Ttf);
      int i = g.a.a.b.b.a.bM(2, this.Ttg);
      int j = g.a.a.b.b.a.bM(3, this.Tth);
      AppMethodBeat.o(209712);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209712);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clp localclp = (clp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209712);
        return -1;
      case 1: 
        localclp.Ttf = locala.abFh.AK();
        AppMethodBeat.o(209712);
        return 0;
      case 2: 
        localclp.Ttg = locala.abFh.AK();
        AppMethodBeat.o(209712);
        return 0;
      }
      localclp.Tth = locala.abFh.AK();
      AppMethodBeat.o(209712);
      return 0;
    }
    AppMethodBeat.o(209712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */