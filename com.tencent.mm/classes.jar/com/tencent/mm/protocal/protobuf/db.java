package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class db
  extends com.tencent.mm.bx.a
{
  public String Fvw;
  public long Fvx;
  public String iHA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iHA == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.Fvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.iHA != null) {
        paramVarArgs.d(1, this.iHA);
      }
      if (this.Fvw != null) {
        paramVarArgs.d(2, this.Fvw);
      }
      paramVarArgs.aY(3, this.Fvx);
      AppMethodBeat.o(152487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iHA == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.iHA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fvw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fvw);
      }
      paramInt = f.a.a.b.b.a.p(3, this.Fvx);
      AppMethodBeat.o(152487);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iHA == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        if (this.Fvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152487);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152487);
          return -1;
        case 1: 
          localdb.iHA = locala.NPN.readString();
          AppMethodBeat.o(152487);
          return 0;
        case 2: 
          localdb.Fvw = locala.NPN.readString();
          AppMethodBeat.o(152487);
          return 0;
        }
        localdb.Fvx = locala.NPN.zd();
        AppMethodBeat.o(152487);
        return 0;
      }
      AppMethodBeat.o(152487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.db
 * JD-Core Version:    0.7.0.1
 */