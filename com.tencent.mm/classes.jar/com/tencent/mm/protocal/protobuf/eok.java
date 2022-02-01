package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eok
  extends com.tencent.mm.bx.a
{
  public int ablG;
  public String absL;
  public String absM;
  public int absN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ablG);
      if (this.absL != null) {
        paramVarArgs.g(2, this.absL);
      }
      if (this.absM != null) {
        paramVarArgs.g(3, this.absM);
      }
      paramVarArgs.bS(4, this.absN);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ablG) + 0;
      paramInt = i;
      if (this.absL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.absL);
      }
      i = paramInt;
      if (this.absM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.absM);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.absN);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eok localeok = (eok)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localeok.ablG = locala.ajGk.aar();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localeok.absL = locala.ajGk.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localeok.absM = locala.ajGk.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localeok.absN = locala.ajGk.aar();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eok
 * JD-Core Version:    0.7.0.1
 */