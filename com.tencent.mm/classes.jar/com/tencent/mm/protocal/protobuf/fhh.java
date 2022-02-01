package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhh
  extends com.tencent.mm.cd.a
{
  public String GHJ;
  public String jump_url;
  public int type;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207343);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.GHJ != null) {
        paramVarArgs.f(2, this.GHJ);
      }
      if (this.ufC != null) {
        paramVarArgs.f(3, this.ufC);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(4, this.jump_url);
      }
      AppMethodBeat.o(207343);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.GHJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.GHJ);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufC);
      }
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jump_url);
      }
      AppMethodBeat.o(207343);
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
      AppMethodBeat.o(207343);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fhh localfhh = (fhh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207343);
        return -1;
      case 1: 
        localfhh.type = locala.abFh.AK();
        AppMethodBeat.o(207343);
        return 0;
      case 2: 
        localfhh.GHJ = locala.abFh.readString();
        AppMethodBeat.o(207343);
        return 0;
      case 3: 
        localfhh.ufC = locala.abFh.readString();
        AppMethodBeat.o(207343);
        return 0;
      }
      localfhh.jump_url = locala.abFh.readString();
      AppMethodBeat.o(207343);
      return 0;
    }
    AppMethodBeat.o(207343);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhh
 * JD-Core Version:    0.7.0.1
 */