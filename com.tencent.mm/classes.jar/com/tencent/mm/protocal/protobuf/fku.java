package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fku
  extends com.tencent.mm.bx.a
{
  public int abLt;
  public String abLu;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.abLt);
      if (this.abLu != null) {
        paramVarArgs.g(4, this.abLu);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhJ) + 0 + i.a.a.b.b.a.cJ(3, this.abLt);
      paramInt = i;
      if (this.abLu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abLu);
      }
      AppMethodBeat.o(153305);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fku localfku = (fku)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localfku.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localfku.abLt = locala.ajGk.aar();
        AppMethodBeat.o(153305);
        return 0;
      }
      localfku.abLu = locala.ajGk.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fku
 * JD-Core Version:    0.7.0.1
 */