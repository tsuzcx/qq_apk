package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dmw
  extends com.tencent.mm.bx.a
{
  public String md5;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169218);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(169218);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.g(1, this.md5);
      }
      if (this.uuid != null) {
        paramVarArgs.g(2, this.uuid);
      }
      AppMethodBeat.o(169218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.uuid);
      }
      AppMethodBeat.o(169218);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(169218);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169218);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dmw localdmw = (dmw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169218);
          return -1;
        case 1: 
          localdmw.md5 = locala.ajGk.readString();
          AppMethodBeat.o(169218);
          return 0;
        }
        localdmw.uuid = locala.ajGk.readString();
        AppMethodBeat.o(169218);
        return 0;
      }
      AppMethodBeat.o(169218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmw
 * JD-Core Version:    0.7.0.1
 */