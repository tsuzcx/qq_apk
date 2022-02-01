package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eks
  extends com.tencent.mm.bw.a
{
  public int InC;
  public String hDm;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDm == null)
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
      if (this.hDm != null) {
        paramVarArgs.d(1, this.hDm);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aS(3, this.InC);
      AppMethodBeat.o(32574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDm == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.hDm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.InC);
      AppMethodBeat.o(32574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.hDm == null)
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
        eks localeks = (eks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32574);
          return -1;
        case 1: 
          localeks.hDm = locala.OmT.readString();
          AppMethodBeat.o(32574);
          return 0;
        case 2: 
          localeks.title = locala.OmT.readString();
          AppMethodBeat.o(32574);
          return 0;
        }
        localeks.InC = locala.OmT.zc();
        AppMethodBeat.o(32574);
        return 0;
      }
      AppMethodBeat.o(32574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eks
 * JD-Core Version:    0.7.0.1
 */