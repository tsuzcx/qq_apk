package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class nh
  extends com.tencent.mm.bx.a
{
  public String hHZ;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207222);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(207222);
        throw paramVarArgs;
      }
      if (this.hHZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(207222);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.hHZ != null) {
        paramVarArgs.d(2, this.hHZ);
      }
      AppMethodBeat.o(207222);
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
      if (this.hHZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hHZ);
      }
      AppMethodBeat.o(207222);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(207222);
          throw paramVarArgs;
        }
        if (this.hHZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: val");
          AppMethodBeat.o(207222);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207222);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207222);
          return -1;
        case 1: 
          localnh.key = locala.NPN.readString();
          AppMethodBeat.o(207222);
          return 0;
        }
        localnh.hHZ = locala.NPN.readString();
        AppMethodBeat.o(207222);
        return 0;
      }
      AppMethodBeat.o(207222);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nh
 * JD-Core Version:    0.7.0.1
 */