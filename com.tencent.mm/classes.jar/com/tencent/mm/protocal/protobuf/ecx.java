package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecx
  extends com.tencent.mm.bx.a
{
  public long HOL;
  public String Hnp;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      paramVarArgs.aY(3, this.HOL);
      AppMethodBeat.o(32536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hnp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nEt);
      }
      paramInt = f.a.a.b.b.a.p(3, this.HOL);
      AppMethodBeat.o(32536);
      return i + paramInt;
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
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        if (this.nEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32536);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecx localecx = (ecx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32536);
          return -1;
        case 1: 
          localecx.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32536);
          return 0;
        case 2: 
          localecx.nEt = locala.NPN.readString();
          AppMethodBeat.o(32536);
          return 0;
        }
        localecx.HOL = locala.NPN.zd();
        AppMethodBeat.o(32536);
        return 0;
      }
      AppMethodBeat.o(32536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecx
 * JD-Core Version:    0.7.0.1
 */