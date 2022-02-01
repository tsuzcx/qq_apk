package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fax
  extends com.tencent.mm.cd.a
{
  public boolean UAN;
  public String UAO;
  public String UAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.UAN);
      if (this.UAO != null) {
        paramVarArgs.f(2, this.UAO);
      }
      if (this.UAP != null) {
        paramVarArgs.f(3, this.UAP);
      }
      AppMethodBeat.o(230411);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.UAO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UAO);
      }
      i = paramInt;
      if (this.UAP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UAP);
      }
      AppMethodBeat.o(230411);
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
      AppMethodBeat.o(230411);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fax localfax = (fax)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230411);
        return -1;
      case 1: 
        localfax.UAN = locala.abFh.AB();
        AppMethodBeat.o(230411);
        return 0;
      case 2: 
        localfax.UAO = locala.abFh.readString();
        AppMethodBeat.o(230411);
        return 0;
      }
      localfax.UAP = locala.abFh.readString();
      AppMethodBeat.o(230411);
      return 0;
    }
    AppMethodBeat.o(230411);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fax
 * JD-Core Version:    0.7.0.1
 */