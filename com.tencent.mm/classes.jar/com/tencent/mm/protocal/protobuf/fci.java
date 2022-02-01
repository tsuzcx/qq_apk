package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fci
  extends com.tencent.mm.bx.a
{
  public String rGU;
  public String right_button_wording;
  public String wYO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.rGU != null) {
        paramVarArgs.g(1, this.rGU);
      }
      if (this.right_button_wording != null) {
        paramVarArgs.g(2, this.right_button_wording);
      }
      if (this.wYO != null) {
        paramVarArgs.g(3, this.wYO);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rGU == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.rGU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.right_button_wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.right_button_wording);
      }
      i = paramInt;
      if (this.wYO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wYO);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fci localfci = (fci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localfci.rGU = locala.ajGk.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localfci.right_button_wording = locala.ajGk.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localfci.wYO = locala.ajGk.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fci
 * JD-Core Version:    0.7.0.1
 */