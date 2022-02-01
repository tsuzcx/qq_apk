package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dqr
  extends com.tencent.mm.bw.a
{
  public long duration;
  public String path;
  public long yeZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(212481);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aZ(2, this.yeZ);
      paramVarArgs.aZ(3, this.duration);
      AppMethodBeat.o(212481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.yeZ);
      int j = f.a.a.b.b.a.p(3, this.duration);
      AppMethodBeat.o(212481);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(212481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212481);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqr localdqr = (dqr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212481);
          return -1;
        case 1: 
          localdqr.path = locala.OmT.readString();
          AppMethodBeat.o(212481);
          return 0;
        case 2: 
          localdqr.yeZ = locala.OmT.zd();
          AppMethodBeat.o(212481);
          return 0;
        }
        localdqr.duration = locala.OmT.zd();
        AppMethodBeat.o(212481);
        return 0;
      }
      AppMethodBeat.o(212481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqr
 * JD-Core Version:    0.7.0.1
 */