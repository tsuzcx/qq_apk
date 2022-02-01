package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byq
  extends com.tencent.mm.bx.a
{
  public int aahm;
  public int aahn;
  public int aaho;
  public int aahp;
  public String aahq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257900);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aahm);
      paramVarArgs.bS(2, this.aahn);
      paramVarArgs.bS(3, this.aaho);
      paramVarArgs.bS(4, this.aahp);
      if (this.aahq != null) {
        paramVarArgs.g(5, this.aahq);
      }
      AppMethodBeat.o(257900);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aahm) + 0 + i.a.a.b.b.a.cJ(2, this.aahn) + i.a.a.b.b.a.cJ(3, this.aaho) + i.a.a.b.b.a.cJ(4, this.aahp);
      paramInt = i;
      if (this.aahq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aahq);
      }
      AppMethodBeat.o(257900);
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
      AppMethodBeat.o(257900);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      byq localbyq = (byq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257900);
        return -1;
      case 1: 
        localbyq.aahm = locala.ajGk.aar();
        AppMethodBeat.o(257900);
        return 0;
      case 2: 
        localbyq.aahn = locala.ajGk.aar();
        AppMethodBeat.o(257900);
        return 0;
      case 3: 
        localbyq.aaho = locala.ajGk.aar();
        AppMethodBeat.o(257900);
        return 0;
      case 4: 
        localbyq.aahp = locala.ajGk.aar();
        AppMethodBeat.o(257900);
        return 0;
      }
      localbyq.aahq = locala.ajGk.readString();
      AppMethodBeat.o(257900);
      return 0;
    }
    AppMethodBeat.o(257900);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byq
 * JD-Core Version:    0.7.0.1
 */