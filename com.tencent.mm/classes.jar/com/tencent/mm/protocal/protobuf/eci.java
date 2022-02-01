package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eci
  extends com.tencent.mm.bx.a
{
  public String nDo;
  public int nEf;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      paramVarArgs.aS(3, this.nEf);
      AppMethodBeat.o(32517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nEt);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.nEf);
      AppMethodBeat.o(32517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDo == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        if (this.nEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32517);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eci localeci = (eci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32517);
          return -1;
        case 1: 
          localeci.nDo = locala.NPN.readString();
          AppMethodBeat.o(32517);
          return 0;
        case 2: 
          localeci.nEt = locala.NPN.readString();
          AppMethodBeat.o(32517);
          return 0;
        }
        localeci.nEf = locala.NPN.zc();
        AppMethodBeat.o(32517);
        return 0;
      }
      AppMethodBeat.o(32517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eci
 * JD-Core Version:    0.7.0.1
 */