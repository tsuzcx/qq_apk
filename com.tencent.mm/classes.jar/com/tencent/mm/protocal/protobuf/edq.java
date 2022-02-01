package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edq
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b Fyu;
  public long HPc;
  public String Hnp;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.Fyu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      paramVarArgs.aY(2, this.HPc);
      if (this.Fyu != null) {
        paramVarArgs.c(3, this.Fyu);
      }
      paramVarArgs.aS(4, this.Scene);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hnp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HPc);
      paramInt = i;
      if (this.Fyu != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Fyu);
      }
      i = f.a.a.b.b.a.bz(4, this.Scene);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hnp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.Fyu == null)
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
        edq localedq = (edq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localedq.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localedq.HPc = locala.NPN.zd();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localedq.Fyu = locala.NPN.gxI();
          AppMethodBeat.o(32559);
          return 0;
        }
        localedq.Scene = locala.NPN.zc();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edq
 * JD-Core Version:    0.7.0.1
 */