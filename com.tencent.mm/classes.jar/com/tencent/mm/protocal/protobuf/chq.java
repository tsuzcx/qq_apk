package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class chq
  extends com.tencent.mm.bw.a
{
  public String key;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(117541);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(117541);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      AppMethodBeat.o(117541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.value);
      }
      AppMethodBeat.o(117541);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(117541);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(117541);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117541);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chq localchq = (chq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117541);
          return -1;
        case 1: 
          localchq.key = locala.OmT.readString();
          AppMethodBeat.o(117541);
          return 0;
        }
        localchq.value = locala.OmT.readString();
        AppMethodBeat.o(117541);
        return 0;
      }
      AppMethodBeat.o(117541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chq
 * JD-Core Version:    0.7.0.1
 */