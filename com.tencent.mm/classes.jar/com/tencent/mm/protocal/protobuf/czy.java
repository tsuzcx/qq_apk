package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class czy
  extends com.tencent.mm.bx.a
{
  public String Fvw;
  public long Fvx;
  public String Hqs;
  public String iHA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iHA == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.Hqs == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.Fvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.iHA != null) {
        paramVarArgs.d(1, this.iHA);
      }
      if (this.Hqs != null) {
        paramVarArgs.d(2, this.Hqs);
      }
      if (this.Fvw != null) {
        paramVarArgs.d(3, this.Fvw);
      }
      paramVarArgs.aY(4, this.Fvx);
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iHA == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.iHA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hqs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hqs);
      }
      i = paramInt;
      if (this.Fvw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fvw);
      }
      paramInt = f.a.a.b.b.a.p(4, this.Fvx);
      AppMethodBeat.o(152690);
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
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.Hqs == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.Fvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152690);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czy localczy = (czy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localczy.iHA = locala.NPN.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localczy.Hqs = locala.NPN.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 3: 
          localczy.Fvw = locala.NPN.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localczy.Fvx = locala.NPN.zd();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czy
 * JD-Core Version:    0.7.0.1
 */