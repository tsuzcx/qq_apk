package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fww
  extends com.tencent.mm.bx.a
{
  public int abUI;
  public String abUJ;
  public String abUK;
  public String abUL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258322);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abUI);
      if (this.abUJ != null) {
        paramVarArgs.g(2, this.abUJ);
      }
      if (this.abUK != null) {
        paramVarArgs.g(3, this.abUK);
      }
      if (this.abUL != null) {
        paramVarArgs.g(4, this.abUL);
      }
      AppMethodBeat.o(258322);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abUI) + 0;
      paramInt = i;
      if (this.abUJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abUJ);
      }
      i = paramInt;
      if (this.abUK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abUK);
      }
      paramInt = i;
      if (this.abUL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abUL);
      }
      AppMethodBeat.o(258322);
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
      AppMethodBeat.o(258322);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fww localfww = (fww)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258322);
        return -1;
      case 1: 
        localfww.abUI = locala.ajGk.aar();
        AppMethodBeat.o(258322);
        return 0;
      case 2: 
        localfww.abUJ = locala.ajGk.readString();
        AppMethodBeat.o(258322);
        return 0;
      case 3: 
        localfww.abUK = locala.ajGk.readString();
        AppMethodBeat.o(258322);
        return 0;
      }
      localfww.abUL = locala.ajGk.readString();
      AppMethodBeat.o(258322);
      return 0;
    }
    AppMethodBeat.o(258322);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fww
 * JD-Core Version:    0.7.0.1
 */