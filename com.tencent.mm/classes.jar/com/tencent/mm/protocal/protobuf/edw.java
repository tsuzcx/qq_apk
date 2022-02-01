package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class edw
  extends com.tencent.mm.bx.a
{
  public String FGP;
  public int FqN;
  public boolean HPk;
  public String Hnp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.FGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      if (this.FGP != null) {
        paramVarArgs.d(2, this.FGP);
      }
      paramVarArgs.bt(3, this.HPk);
      paramVarArgs.aS(4, this.FqN);
      AppMethodBeat.o(32565);
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
      int i = paramInt;
      if (this.FGP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FGP);
      }
      paramInt = f.a.a.b.b.a.alV(3);
      int j = f.a.a.b.b.a.bz(4, this.FqN);
      AppMethodBeat.o(32565);
      return i + paramInt + j;
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
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        if (this.FGP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32565);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edw localedw = (edw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32565);
          return -1;
        case 1: 
          localedw.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 2: 
          localedw.FGP = locala.NPN.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 3: 
          localedw.HPk = locala.NPN.grw();
          AppMethodBeat.o(32565);
          return 0;
        }
        localedw.FqN = locala.NPN.zc();
        AppMethodBeat.o(32565);
        return 0;
      }
      AppMethodBeat.o(32565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edw
 * JD-Core Version:    0.7.0.1
 */