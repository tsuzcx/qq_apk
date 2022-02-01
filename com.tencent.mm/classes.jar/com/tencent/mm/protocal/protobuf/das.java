package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class das
  extends com.tencent.mm.bx.a
{
  public String IKJ;
  public String Url;
  public String aaGk;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32328);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.aaGk != null) {
        paramVarArgs.g(3, this.aaGk);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(4, this.IKJ);
      }
      AppMethodBeat.o(32328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label400;
      }
    }
    label400:
    for (int i = i.a.a.b.b.a.h(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.aaGk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaGk);
      }
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKJ);
      }
      AppMethodBeat.o(32328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32328);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        das localdas = (das)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32328);
          return -1;
        case 1: 
          localdas.Url = locala.ajGk.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 2: 
          localdas.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 3: 
          localdas.aaGk = locala.ajGk.readString();
          AppMethodBeat.o(32328);
          return 0;
        }
        localdas.IKJ = locala.ajGk.readString();
        AppMethodBeat.o(32328);
        return 0;
      }
      AppMethodBeat.o(32328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */