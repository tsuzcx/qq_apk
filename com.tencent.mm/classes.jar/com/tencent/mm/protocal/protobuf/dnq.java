package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnq
  extends com.tencent.mm.cd.a
{
  public String TUQ;
  public String TUR;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.TUQ != null) {
        paramVarArgs.f(2, this.TUQ);
      }
      if (this.TUR != null) {
        paramVarArgs.f(3, this.TUR);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.TUQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TUQ);
      }
      i = paramInt;
      if (this.TUR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TUR);
      }
      AppMethodBeat.o(153294);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dnq localdnq = (dnq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localdnq.type = locala.abFh.AK();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localdnq.TUQ = locala.abFh.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localdnq.TUR = locala.abFh.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnq
 * JD-Core Version:    0.7.0.1
 */