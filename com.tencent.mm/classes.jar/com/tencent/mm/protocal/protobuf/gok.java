package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gok
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int ZtX;
  public String ZuK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104828);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZtX);
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.ZuK != null) {
        paramVarArgs.g(3, this.ZuK);
      }
      AppMethodBeat.o(104828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZtX) + 0;
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.ZuK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZuK);
      }
      AppMethodBeat.o(104828);
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
      AppMethodBeat.o(104828);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gok localgok = (gok)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104828);
        return -1;
      case 1: 
        localgok.ZtX = locala.ajGk.aar();
        AppMethodBeat.o(104828);
        return 0;
      case 2: 
        localgok.IGU = locala.ajGk.readString();
        AppMethodBeat.o(104828);
        return 0;
      }
      localgok.ZuK = locala.ajGk.readString();
      AppMethodBeat.o(104828);
      return 0;
    }
    AppMethodBeat.o(104828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gok
 * JD-Core Version:    0.7.0.1
 */