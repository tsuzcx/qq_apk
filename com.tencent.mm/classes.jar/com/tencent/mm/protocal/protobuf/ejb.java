package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ejb
  extends com.tencent.mm.bx.a
{
  public int HTv;
  public String hAy;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hAy == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32574);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(32574);
        throw paramVarArgs;
      }
      if (this.hAy != null) {
        paramVarArgs.d(1, this.hAy);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aS(3, this.HTv);
      AppMethodBeat.o(32574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAy == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.hAy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HTv);
      AppMethodBeat.o(32574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.hAy == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32574);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(32574);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32574);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ejb localejb = (ejb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32574);
          return -1;
        case 1: 
          localejb.hAy = locala.NPN.readString();
          AppMethodBeat.o(32574);
          return 0;
        case 2: 
          localejb.title = locala.NPN.readString();
          AppMethodBeat.o(32574);
          return 0;
        }
        localejb.HTv = locala.NPN.zc();
        AppMethodBeat.o(32574);
        return 0;
      }
      AppMethodBeat.o(32574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejb
 * JD-Core Version:    0.7.0.1
 */