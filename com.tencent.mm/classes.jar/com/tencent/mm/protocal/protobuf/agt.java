package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agt
  extends com.tencent.mm.bx.a
{
  public String VBL;
  public String VBP;
  public String VJr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.VBL != null) {
        paramVarArgs.g(1, this.VBL);
      }
      if (this.VJr != null) {
        paramVarArgs.g(2, this.VJr);
      }
      if (this.VBP != null) {
        paramVarArgs.g(3, this.VBP);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VBL == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.VBL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VJr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VJr);
      }
      i = paramInt;
      if (this.VBP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VBP);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        agt localagt = (agt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localagt.VBL = locala.ajGk.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localagt.VJr = locala.ajGk.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localagt.VBP = locala.ajGk.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agt
 * JD-Core Version:    0.7.0.1
 */