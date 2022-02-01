package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a
  extends com.tencent.mm.cd.a
{
  public String RDe;
  public String RDf;
  public int actionType;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RDe == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.id);
      paramVarArgs.aY(2, this.actionType);
      if (this.RDe != null) {
        paramVarArgs.f(3, this.RDe);
      }
      if (this.RDf != null) {
        paramVarArgs.f(4, this.RDf);
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0 + g.a.a.b.b.a.bM(2, this.actionType);
      paramInt = i;
      if (this.RDe != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RDe);
      }
      i = paramInt;
      if (this.RDf != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RDf);
      }
      AppMethodBeat.o(123716);
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
      if (this.RDe == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123716);
        return -1;
      case 1: 
        locala1.id = locala.abFh.AK();
        AppMethodBeat.o(123716);
        return 0;
      case 2: 
        locala1.actionType = locala.abFh.AK();
        AppMethodBeat.o(123716);
        return 0;
      case 3: 
        locala1.RDe = locala.abFh.readString();
        AppMethodBeat.o(123716);
        return 0;
      }
      locala1.RDf = locala.abFh.readString();
      AppMethodBeat.o(123716);
      return 0;
    }
    AppMethodBeat.o(123716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */