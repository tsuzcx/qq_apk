package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bjw
  extends com.tencent.mm.bv.a
{
  public String key;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(90701);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(90701);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      AppMethodBeat.o(90701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.value);
      }
      AppMethodBeat.o(90701);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(90701);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(90701);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90701);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bjw localbjw = (bjw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(90701);
          return -1;
        case 1: 
          localbjw.key = locala.CLY.readString();
          AppMethodBeat.o(90701);
          return 0;
        }
        localbjw.value = locala.CLY.readString();
        AppMethodBeat.o(90701);
        return 0;
      }
      AppMethodBeat.o(90701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjw
 * JD-Core Version:    0.7.0.1
 */