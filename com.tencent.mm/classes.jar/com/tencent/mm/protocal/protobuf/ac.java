package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends com.tencent.mm.cd.a
{
  public String EBN;
  public String EBO;
  public int REc;
  public String oDJ;
  public String oDK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.REc);
      if (this.EBN != null) {
        paramVarArgs.f(2, this.EBN);
      }
      if (this.oDJ != null) {
        paramVarArgs.f(3, this.oDJ);
      }
      if (this.oDK != null) {
        paramVarArgs.f(4, this.oDK);
      }
      if (this.EBO != null) {
        paramVarArgs.f(5, this.EBO);
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.REc) + 0;
      paramInt = i;
      if (this.EBN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.EBN);
      }
      i = paramInt;
      if (this.oDJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.oDJ);
      }
      paramInt = i;
      if (this.oDK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.oDK);
      }
      i = paramInt;
      if (this.EBO != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.EBO);
      }
      AppMethodBeat.o(91339);
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
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91339);
        return -1;
      case 1: 
        localac.REc = locala.abFh.AK();
        AppMethodBeat.o(91339);
        return 0;
      case 2: 
        localac.EBN = locala.abFh.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 3: 
        localac.oDJ = locala.abFh.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 4: 
        localac.oDK = locala.abFh.readString();
        AppMethodBeat.o(91339);
        return 0;
      }
      localac.EBO = locala.abFh.readString();
      AppMethodBeat.o(91339);
      return 0;
    }
    AppMethodBeat.o(91339);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */