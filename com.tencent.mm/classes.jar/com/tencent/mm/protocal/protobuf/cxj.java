package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxj
  extends com.tencent.mm.bx.a
{
  public String Zug;
  public String aaCQ;
  public String aaCR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zug != null) {
        paramVarArgs.g(1, this.Zug);
      }
      if (this.aaCQ != null) {
        paramVarArgs.g(2, this.aaCQ);
      }
      if (this.aaCR != null) {
        paramVarArgs.g(3, this.aaCR);
      }
      AppMethodBeat.o(152609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zug == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.Zug) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaCQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaCQ);
      }
      i = paramInt;
      if (this.aaCR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaCR);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cxj localcxj = (cxj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localcxj.Zug = locala.ajGk.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localcxj.aaCQ = locala.ajGk.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localcxj.aaCR = locala.ajGk.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */