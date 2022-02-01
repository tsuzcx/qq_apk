package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class kk
  extends com.tencent.mm.bw.a
{
  public String FVh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVh == null)
      {
        paramVarArgs = new b("Not all required fields were included: Mac");
        AppMethodBeat.o(82388);
        throw paramVarArgs;
      }
      if (this.FVh != null) {
        paramVarArgs.d(1, this.FVh);
      }
      AppMethodBeat.o(82388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVh == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.FVh) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(82388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FVh == null)
        {
          paramVarArgs = new b("Not all required fields were included: Mac");
          AppMethodBeat.o(82388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82388);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        kk localkk = (kk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82388);
          return -1;
        }
        localkk.FVh = locala.OmT.readString();
        AppMethodBeat.o(82388);
        return 0;
      }
      AppMethodBeat.o(82388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kk
 * JD-Core Version:    0.7.0.1
 */