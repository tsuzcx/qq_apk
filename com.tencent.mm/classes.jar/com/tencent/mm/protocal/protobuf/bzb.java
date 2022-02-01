package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzb
  extends com.tencent.mm.bx.a
{
  public String ZUb;
  public String ZUc;
  public String aaid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257681);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZUb != null) {
        paramVarArgs.g(1, this.ZUb);
      }
      if (this.ZUc != null) {
        paramVarArgs.g(2, this.ZUc);
      }
      if (this.aaid != null) {
        paramVarArgs.g(3, this.aaid);
      }
      AppMethodBeat.o(257681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZUb == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.ZUb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZUc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZUc);
      }
      i = paramInt;
      if (this.aaid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaid);
      }
      AppMethodBeat.o(257681);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257681);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bzb localbzb = (bzb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257681);
          return -1;
        case 1: 
          localbzb.ZUb = locala.ajGk.readString();
          AppMethodBeat.o(257681);
          return 0;
        case 2: 
          localbzb.ZUc = locala.ajGk.readString();
          AppMethodBeat.o(257681);
          return 0;
        }
        localbzb.aaid = locala.ajGk.readString();
        AppMethodBeat.o(257681);
        return 0;
      }
      AppMethodBeat.o(257681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzb
 * JD-Core Version:    0.7.0.1
 */