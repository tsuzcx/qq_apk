package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bog
  extends com.tencent.mm.bw.a
{
  public b FUB;
  public b FUz;
  public b Hbq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUB != null) {
        paramVarArgs.c(1, this.FUB);
      }
      if (this.FUz != null) {
        paramVarArgs.c(2, this.FUz);
      }
      if (this.Hbq != null) {
        paramVarArgs.c(3, this.Hbq);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUB == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.b(1, this.FUB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUz != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FUz);
      }
      i = paramInt;
      if (this.Hbq != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Hbq);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bog localbog = (bog)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localbog.FUB = locala.OmT.gCk();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localbog.FUz = locala.OmT.gCk();
          AppMethodBeat.o(32321);
          return 0;
        }
        localbog.Hbq = locala.OmT.gCk();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */