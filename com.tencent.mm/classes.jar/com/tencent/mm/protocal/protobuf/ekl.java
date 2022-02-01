package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekl
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public int Umk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125803);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIs);
      paramVarArgs.aY(2, this.Umk);
      AppMethodBeat.o(125803);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RIs);
      int i = g.a.a.b.b.a.bM(2, this.Umk);
      AppMethodBeat.o(125803);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125803);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ekl localekl = (ekl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125803);
        return -1;
      case 1: 
        localekl.RIs = locala.abFh.AK();
        AppMethodBeat.o(125803);
        return 0;
      }
      localekl.Umk = locala.abFh.AK();
      AppMethodBeat.o(125803);
      return 0;
    }
    AppMethodBeat.o(125803);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekl
 * JD-Core Version:    0.7.0.1
 */