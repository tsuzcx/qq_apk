package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsg
  extends com.tencent.mm.cd.a
{
  public int SrQ;
  public int SrR;
  public String fTp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SrQ);
      paramVarArgs.aY(2, this.SrR);
      if (this.fTp != null) {
        paramVarArgs.f(3, this.fTp);
      }
      AppMethodBeat.o(125758);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SrQ) + 0 + g.a.a.b.b.a.bM(2, this.SrR);
      paramInt = i;
      if (this.fTp != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fTp);
      }
      AppMethodBeat.o(125758);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125758);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dsg localdsg = (dsg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125758);
        return -1;
      case 1: 
        localdsg.SrQ = locala.abFh.AK();
        AppMethodBeat.o(125758);
        return 0;
      case 2: 
        localdsg.SrR = locala.abFh.AK();
        AppMethodBeat.o(125758);
        return 0;
      }
      localdsg.fTp = locala.abFh.readString();
      AppMethodBeat.o(125758);
      return 0;
    }
    AppMethodBeat.o(125758);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsg
 * JD-Core Version:    0.7.0.1
 */