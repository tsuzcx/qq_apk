package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bki
  extends com.tencent.mm.bx.a
{
  public int ZTD;
  public String ZTE;
  public String ZTF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259643);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZTD);
      if (this.ZTE != null) {
        paramVarArgs.g(2, this.ZTE);
      }
      if (this.ZTF != null) {
        paramVarArgs.g(3, this.ZTF);
      }
      AppMethodBeat.o(259643);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZTD) + 0;
      paramInt = i;
      if (this.ZTE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZTE);
      }
      i = paramInt;
      if (this.ZTF != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZTF);
      }
      AppMethodBeat.o(259643);
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
      AppMethodBeat.o(259643);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bki localbki = (bki)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259643);
        return -1;
      case 1: 
        localbki.ZTD = locala.ajGk.aar();
        AppMethodBeat.o(259643);
        return 0;
      case 2: 
        localbki.ZTE = locala.ajGk.readString();
        AppMethodBeat.o(259643);
        return 0;
      }
      localbki.ZTF = locala.ajGk.readString();
      AppMethodBeat.o(259643);
      return 0;
    }
    AppMethodBeat.o(259643);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bki
 * JD-Core Version:    0.7.0.1
 */