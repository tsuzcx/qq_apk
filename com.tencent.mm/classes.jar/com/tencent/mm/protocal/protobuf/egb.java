package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class egb
  extends com.tencent.mm.bx.a
{
  public int ablw;
  public int ablx;
  public String ably;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ablw);
      paramVarArgs.bS(2, this.ablx);
      if (this.ably != null) {
        paramVarArgs.g(3, this.ably);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ablw) + 0 + i.a.a.b.b.a.cJ(2, this.ablx);
      paramInt = i;
      if (this.ably != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ably);
      }
      AppMethodBeat.o(125754);
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
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      egb localegb = (egb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localegb.ablw = locala.ajGk.aar();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localegb.ablx = locala.ajGk.aar();
        AppMethodBeat.o(125754);
        return 0;
      }
      localegb.ably = locala.ajGk.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egb
 * JD-Core Version:    0.7.0.1
 */