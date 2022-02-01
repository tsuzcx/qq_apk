package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class edb
  extends com.tencent.mm.bx.a
{
  public boolean HOR;
  public long HfW;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32540);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aY(2, this.HfW);
      paramVarArgs.bt(3, this.HOR);
      AppMethodBeat.o(32540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label359;
      }
    }
    label359:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HfW);
      int j = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(32540);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edb localedb = (edb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32540);
          return -1;
        case 1: 
          localedb.Username = locala.NPN.readString();
          AppMethodBeat.o(32540);
          return 0;
        case 2: 
          localedb.HfW = locala.NPN.zd();
          AppMethodBeat.o(32540);
          return 0;
        }
        localedb.HOR = locala.NPN.grw();
        AppMethodBeat.o(32540);
        return 0;
      }
      AppMethodBeat.o(32540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edb
 * JD-Core Version:    0.7.0.1
 */