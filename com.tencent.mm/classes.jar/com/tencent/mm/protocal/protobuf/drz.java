package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drz
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CAF;
  public long EGK;
  public String Egc;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.CAF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      paramVarArgs.aG(2, this.EGK);
      if (this.CAF != null) {
        paramVarArgs.c(3, this.CAF);
      }
      paramVarArgs.aR(4, this.Scene);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.Egc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.EGK);
      paramInt = i;
      if (this.CAF != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.CAF);
      }
      i = f.a.a.b.b.a.bA(4, this.Scene);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Egc == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.CAF == null)
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
        drz localdrz = (drz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localdrz.Egc = locala.KhF.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localdrz.EGK = locala.KhF.xT();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localdrz.CAF = locala.KhF.fMu();
          AppMethodBeat.o(32559);
          return 0;
        }
        localdrz.Scene = locala.KhF.xS();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drz
 * JD-Core Version:    0.7.0.1
 */