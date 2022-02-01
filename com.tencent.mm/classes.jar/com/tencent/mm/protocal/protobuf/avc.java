package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class avc
  extends com.tencent.mm.bx.a
{
  public b ZFt;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257618);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZFt != null) {
        paramVarArgs.d(1, this.ZFt);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      AppMethodBeat.o(257618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZFt == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.c(1, this.ZFt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      AppMethodBeat.o(257618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257618);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        avc localavc = (avc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257618);
          return -1;
        case 1: 
          localavc.ZFt = locala.ajGk.kFX();
          AppMethodBeat.o(257618);
          return 0;
        }
        localavc.username = locala.ajGk.readString();
        AppMethodBeat.o(257618);
        return 0;
      }
      AppMethodBeat.o(257618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avc
 * JD-Core Version:    0.7.0.1
 */