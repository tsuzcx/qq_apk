package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbo
  extends com.tencent.mm.bx.a
{
  public String MD5;
  public String URL;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.g(1, this.URL);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label339;
      }
    }
    label339:
    for (int i = i.a.a.b.b.a.h(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32453);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbo localfbo = (fbo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32453);
          return -1;
        case 1: 
          localfbo.URL = locala.ajGk.readString();
          AppMethodBeat.o(32453);
          return 0;
        case 2: 
          localfbo.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32453);
          return 0;
        }
        localfbo.MD5 = locala.ajGk.readString();
        AppMethodBeat.o(32453);
        return 0;
      }
      AppMethodBeat.o(32453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbo
 * JD-Core Version:    0.7.0.1
 */