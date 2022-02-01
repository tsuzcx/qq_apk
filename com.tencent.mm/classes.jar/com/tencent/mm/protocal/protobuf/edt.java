package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class edt
  extends com.tencent.mm.bx.a
{
  public String HPe;
  public String HPf;
  public String HPg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HPe == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.HPf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.HPe != null) {
        paramVarArgs.d(1, this.HPe);
      }
      if (this.HPf != null) {
        paramVarArgs.d(2, this.HPf);
      }
      if (this.HPg != null) {
        paramVarArgs.d(3, this.HPg);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HPe == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.HPe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HPf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HPf);
      }
      i = paramInt;
      if (this.HPg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HPg);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HPe == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.HPf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edt localedt = (edt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localedt.HPe = locala.NPN.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localedt.HPf = locala.NPN.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localedt.HPg = locala.NPN.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edt
 * JD-Core Version:    0.7.0.1
 */