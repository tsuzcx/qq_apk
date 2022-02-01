package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class edn
  extends com.tencent.mm.bx.a
{
  public String FME;
  public String Hnp;
  public String MD5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.FME == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      if (this.FME != null) {
        paramVarArgs.d(3, this.FME);
      }
      paramVarArgs.aS(4, this.Scene);
      AppMethodBeat.o(32556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.Hnp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = paramInt;
      if (this.FME != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FME);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Scene);
      AppMethodBeat.o(32556);
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
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.FME == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edn localedn = (edn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localedn.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localedn.MD5 = locala.NPN.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localedn.FME = locala.NPN.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localedn.Scene = locala.NPN.zc();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edn
 * JD-Core Version:    0.7.0.1
 */