package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class djb
  extends com.tencent.mm.bx.a
{
  public String zqB;
  public int zqC;
  public String zqD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zqB == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(118441);
        throw paramVarArgs;
      }
      if (this.zqB != null) {
        paramVarArgs.d(1, this.zqB);
      }
      paramVarArgs.aS(2, this.zqC);
      if (this.zqD != null) {
        paramVarArgs.d(3, this.zqD);
      }
      AppMethodBeat.o(118441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zqB == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.zqB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.zqC);
      paramInt = i;
      if (this.zqD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.zqD);
      }
      AppMethodBeat.o(118441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.zqB == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(118441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118441);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djb localdjb = (djb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118441);
          return -1;
        case 1: 
          localdjb.zqB = locala.NPN.readString();
          AppMethodBeat.o(118441);
          return 0;
        case 2: 
          localdjb.zqC = locala.NPN.zc();
          AppMethodBeat.o(118441);
          return 0;
        }
        localdjb.zqD = locala.NPN.readString();
        AppMethodBeat.o(118441);
        return 0;
      }
      AppMethodBeat.o(118441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djb
 * JD-Core Version:    0.7.0.1
 */