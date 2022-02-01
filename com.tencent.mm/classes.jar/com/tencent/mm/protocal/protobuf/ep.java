package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ep
  extends com.tencent.mm.bx.a
{
  public int eQp;
  public String rGU;
  public String right_button_wording;
  public String wYO;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.eQp);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.rGU != null) {
        paramVarArgs.g(3, this.rGU);
      }
      if (this.right_button_wording != null) {
        paramVarArgs.g(4, this.right_button_wording);
      }
      if (this.wYO != null) {
        paramVarArgs.g(5, this.wYO);
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.eQp) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.rGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rGU);
      }
      paramInt = i;
      if (this.right_button_wording != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.right_button_wording);
      }
      i = paramInt;
      if (this.wYO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wYO);
      }
      AppMethodBeat.o(72416);
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
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ep localep = (ep)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72416);
        return -1;
      case 1: 
        localep.eQp = locala.ajGk.aar();
        AppMethodBeat.o(72416);
        return 0;
      case 2: 
        localep.wording = locala.ajGk.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 3: 
        localep.rGU = locala.ajGk.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 4: 
        localep.right_button_wording = locala.ajGk.readString();
        AppMethodBeat.o(72416);
        return 0;
      }
      localep.wYO = locala.ajGk.readString();
      AppMethodBeat.o(72416);
      return 0;
    }
    AppMethodBeat.o(72416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ep
 * JD-Core Version:    0.7.0.1
 */