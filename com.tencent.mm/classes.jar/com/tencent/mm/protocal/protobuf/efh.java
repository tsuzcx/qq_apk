package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efh
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FQS;
  public String HGP;
  public long Ijj;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.FQS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      paramVarArgs.aZ(2, this.Ijj);
      if (this.FQS != null) {
        paramVarArgs.c(3, this.FQS);
      }
      paramVarArgs.aS(4, this.Scene);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Ijj);
      paramInt = i;
      if (this.FQS != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FQS);
      }
      i = f.a.a.b.b.a.bz(4, this.Scene);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.FQS == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efh localefh = (efh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localefh.HGP = locala.OmT.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localefh.Ijj = locala.OmT.zd();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localefh.FQS = locala.OmT.gCk();
          AppMethodBeat.o(32559);
          return 0;
        }
        localefh.Scene = locala.OmT.zc();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efh
 * JD-Core Version:    0.7.0.1
 */