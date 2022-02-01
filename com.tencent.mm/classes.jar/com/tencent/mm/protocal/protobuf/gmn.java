package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gmn
  extends com.tencent.mm.bx.a
{
  public int achF;
  public int achG;
  public int achH;
  public int achI;
  public String achJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.achF);
      paramVarArgs.bS(2, this.achG);
      paramVarArgs.bS(3, this.achH);
      paramVarArgs.bS(4, this.achI);
      if (this.achJ != null) {
        paramVarArgs.g(5, this.achJ);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.achF) + 0 + i.a.a.b.b.a.cJ(2, this.achG) + i.a.a.b.b.a.cJ(3, this.achH) + i.a.a.b.b.a.cJ(4, this.achI);
      paramInt = i;
      if (this.achJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.achJ);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gmn localgmn = (gmn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localgmn.achF = locala.ajGk.aar();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localgmn.achG = locala.ajGk.aar();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localgmn.achH = locala.ajGk.aar();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localgmn.achI = locala.ajGk.aar();
        AppMethodBeat.o(153337);
        return 0;
      }
      localgmn.achJ = locala.ajGk.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmn
 * JD-Core Version:    0.7.0.1
 */