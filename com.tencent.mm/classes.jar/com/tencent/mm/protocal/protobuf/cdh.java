package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdh
  extends com.tencent.mm.bx.a
{
  public int NlS;
  public int aanD;
  public int aanE;
  public String aanF;
  public String aanG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257646);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aanD);
      paramVarArgs.bS(2, this.NlS);
      paramVarArgs.bS(3, this.aanE);
      if (this.aanF != null) {
        paramVarArgs.g(4, this.aanF);
      }
      if (this.aanG != null) {
        paramVarArgs.g(5, this.aanG);
      }
      AppMethodBeat.o(257646);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aanD) + 0 + i.a.a.b.b.a.cJ(2, this.NlS) + i.a.a.b.b.a.cJ(3, this.aanE);
      paramInt = i;
      if (this.aanF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aanF);
      }
      i = paramInt;
      if (this.aanG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aanG);
      }
      AppMethodBeat.o(257646);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257646);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cdh localcdh = (cdh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257646);
        return -1;
      case 1: 
        localcdh.aanD = locala.ajGk.aar();
        AppMethodBeat.o(257646);
        return 0;
      case 2: 
        localcdh.NlS = locala.ajGk.aar();
        AppMethodBeat.o(257646);
        return 0;
      case 3: 
        localcdh.aanE = locala.ajGk.aar();
        AppMethodBeat.o(257646);
        return 0;
      case 4: 
        localcdh.aanF = locala.ajGk.readString();
        AppMethodBeat.o(257646);
        return 0;
      }
      localcdh.aanG = locala.ajGk.readString();
      AppMethodBeat.o(257646);
      return 0;
    }
    AppMethodBeat.o(257646);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */