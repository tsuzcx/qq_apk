package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmd
  extends com.tencent.mm.bx.a
{
  public String rGU;
  public String right_button_wording;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.rGU != null) {
        paramVarArgs.g(2, this.rGU);
      }
      if (this.right_button_wording != null) {
        paramVarArgs.g(4, this.right_button_wording);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label334;
      }
    }
    label334:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.rGU);
      }
      i = paramInt;
      if (this.right_button_wording != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.right_button_wording);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dmd localdmd = (dmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localdmd.wording = locala.ajGk.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localdmd.rGU = locala.ajGk.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localdmd.right_button_wording = locala.ajGk.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmd
 * JD-Core Version:    0.7.0.1
 */