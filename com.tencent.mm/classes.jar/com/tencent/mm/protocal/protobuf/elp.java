package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class elp
  extends com.tencent.mm.cd.a
{
  public int SrQ;
  public int TwX;
  public int UnJ;
  public int UnK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SrQ);
      paramVarArgs.aY(2, this.TwX);
      paramVarArgs.aY(3, this.UnJ);
      paramVarArgs.aY(4, this.UnK);
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SrQ);
      int i = g.a.a.b.b.a.bM(2, this.TwX);
      int j = g.a.a.b.b.a.bM(3, this.UnJ);
      int k = g.a.a.b.b.a.bM(4, this.UnK);
      AppMethodBeat.o(125840);
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
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      elp localelp = (elp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125840);
        return -1;
      case 1: 
        localelp.SrQ = locala.abFh.AK();
        AppMethodBeat.o(125840);
        return 0;
      case 2: 
        localelp.TwX = locala.abFh.AK();
        AppMethodBeat.o(125840);
        return 0;
      case 3: 
        localelp.UnJ = locala.abFh.AK();
        AppMethodBeat.o(125840);
        return 0;
      }
      localelp.UnK = locala.abFh.AK();
      AppMethodBeat.o(125840);
      return 0;
    }
    AppMethodBeat.o(125840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elp
 * JD-Core Version:    0.7.0.1
 */