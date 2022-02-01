package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class etc
  extends com.tencent.mm.cd.a
{
  public b RZO;
  public int RZP;
  public int Uvs;
  public int Uvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(7, this.Uvs);
      if (this.RZO != null) {
        paramVarArgs.c(8, this.RZO);
      }
      paramVarArgs.aY(9, this.RZP);
      paramVarArgs.aY(10, this.Uvt);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(7, this.Uvs) + 0;
      paramInt = i;
      if (this.RZO != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.RZO);
      }
      i = g.a.a.b.b.a.bM(9, this.RZP);
      int j = g.a.a.b.b.a.bM(10, this.Uvt);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      etc localetc = (etc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localetc.Uvs = locala.abFh.AK();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localetc.RZO = locala.abFh.iUw();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localetc.RZP = locala.abFh.AK();
        AppMethodBeat.o(91718);
        return 0;
      }
      localetc.Uvt = locala.abFh.AK();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etc
 * JD-Core Version:    0.7.0.1
 */