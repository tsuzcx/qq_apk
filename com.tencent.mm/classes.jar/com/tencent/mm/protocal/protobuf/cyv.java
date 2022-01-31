package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cyv
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String wxa;
  public int yfN;
  public int yfO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63699);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(63699);
        throw paramVarArgs;
      }
      if (this.wxa == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(63699);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.wxa != null) {
        paramVarArgs.e(2, this.wxa);
      }
      paramVarArgs.aO(3, this.yfN);
      paramVarArgs.aO(4, this.yfO);
      AppMethodBeat.o(63699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxa != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wxa);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.yfN);
      int j = e.a.a.b.b.a.bl(4, this.yfO);
      AppMethodBeat.o(63699);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(63699);
          throw paramVarArgs;
        }
        if (this.wxa == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(63699);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63699);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cyv localcyv = (cyv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63699);
          return -1;
        case 1: 
          localcyv.Md5 = locala.CLY.readString();
          AppMethodBeat.o(63699);
          return 0;
        case 2: 
          localcyv.wxa = locala.CLY.readString();
          AppMethodBeat.o(63699);
          return 0;
        case 3: 
          localcyv.yfN = locala.CLY.sl();
          AppMethodBeat.o(63699);
          return 0;
        }
        localcyv.yfO = locala.CLY.sl();
        AppMethodBeat.o(63699);
        return 0;
      }
      AppMethodBeat.o(63699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyv
 * JD-Core Version:    0.7.0.1
 */