package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class djw
  extends com.tencent.mm.bw.a
{
  public String zHQ;
  public int zHR;
  public String zHS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zHQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(118441);
        throw paramVarArgs;
      }
      if (this.zHQ != null) {
        paramVarArgs.d(1, this.zHQ);
      }
      paramVarArgs.aS(2, this.zHR);
      if (this.zHS != null) {
        paramVarArgs.d(3, this.zHS);
      }
      AppMethodBeat.o(118441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zHQ == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.zHQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.zHR);
      paramInt = i;
      if (this.zHS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.zHS);
      }
      AppMethodBeat.o(118441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.zHQ == null)
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
        djw localdjw = (djw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118441);
          return -1;
        case 1: 
          localdjw.zHQ = locala.OmT.readString();
          AppMethodBeat.o(118441);
          return 0;
        case 2: 
          localdjw.zHR = locala.OmT.zc();
          AppMethodBeat.o(118441);
          return 0;
        }
        localdjw.zHS = locala.OmT.readString();
        AppMethodBeat.o(118441);
        return 0;
      }
      AppMethodBeat.o(118441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djw
 * JD-Core Version:    0.7.0.1
 */