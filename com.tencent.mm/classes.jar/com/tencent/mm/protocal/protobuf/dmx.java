package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmx
  extends com.tencent.mm.bx.a
{
  public int IcB;
  public int Idt;
  public String SessionId;
  public int aaLh;
  public int aaTi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IcB);
      paramVarArgs.bS(2, this.Idt);
      paramVarArgs.bS(3, this.aaTi);
      if (this.SessionId != null) {
        paramVarArgs.g(4, this.SessionId);
      }
      paramVarArgs.bS(5, this.aaLh);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IcB) + 0 + i.a.a.b.b.a.cJ(2, this.Idt) + i.a.a.b.b.a.cJ(3, this.aaTi);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.SessionId);
      }
      i = i.a.a.b.b.a.cJ(5, this.aaLh);
      AppMethodBeat.o(125742);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dmx localdmx = (dmx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localdmx.IcB = locala.ajGk.aar();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localdmx.Idt = locala.ajGk.aar();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localdmx.aaTi = locala.ajGk.aar();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localdmx.SessionId = locala.ajGk.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localdmx.aaLh = locala.ajGk.aar();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmx
 * JD-Core Version:    0.7.0.1
 */