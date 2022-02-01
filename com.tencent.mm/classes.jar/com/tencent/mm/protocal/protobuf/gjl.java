package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjl
  extends com.tencent.mm.bx.a
{
  public int acfG;
  public String acfH;
  public String acfI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acfG);
      if (this.acfH != null) {
        paramVarArgs.g(2, this.acfH);
      }
      if (this.acfI != null) {
        paramVarArgs.g(3, this.acfI);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.acfG) + 0;
      paramInt = i;
      if (this.acfH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acfH);
      }
      i = paramInt;
      if (this.acfI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acfI);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gjl localgjl = (gjl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localgjl.acfG = locala.ajGk.aar();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localgjl.acfH = locala.ajGk.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localgjl.acfI = locala.ajGk.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjl
 * JD-Core Version:    0.7.0.1
 */