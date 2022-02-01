package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anq
  extends com.tencent.mm.bx.a
{
  public int Zvn;
  public String Zvo;
  public String icon;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260250);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zvn);
      if (this.icon != null) {
        paramVarArgs.g(2, this.icon);
      }
      if (this.text != null) {
        paramVarArgs.g(3, this.text);
      }
      if (this.Zvo != null) {
        paramVarArgs.g(4, this.Zvo);
      }
      AppMethodBeat.o(260250);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zvn) + 0;
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.text);
      }
      paramInt = i;
      if (this.Zvo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zvo);
      }
      AppMethodBeat.o(260250);
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
      AppMethodBeat.o(260250);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      anq localanq = (anq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260250);
        return -1;
      case 1: 
        localanq.Zvn = locala.ajGk.aar();
        AppMethodBeat.o(260250);
        return 0;
      case 2: 
        localanq.icon = locala.ajGk.readString();
        AppMethodBeat.o(260250);
        return 0;
      case 3: 
        localanq.text = locala.ajGk.readString();
        AppMethodBeat.o(260250);
        return 0;
      }
      localanq.Zvo = locala.ajGk.readString();
      AppMethodBeat.o(260250);
      return 0;
    }
    AppMethodBeat.o(260250);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anq
 * JD-Core Version:    0.7.0.1
 */