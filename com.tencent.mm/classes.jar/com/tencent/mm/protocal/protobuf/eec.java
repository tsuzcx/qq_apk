package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eec
  extends com.tencent.mm.bw.a
{
  public String Gfd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32520);
        throw paramVarArgs;
      }
      if (this.Gfd != null) {
        paramVarArgs.d(1, this.Gfd);
      }
      AppMethodBeat.o(32520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfd == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gfd) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gfd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32520);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32520);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eec localeec = (eec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32520);
          return -1;
        }
        localeec.Gfd = locala.OmT.readString();
        AppMethodBeat.o(32520);
        return 0;
      }
      AppMethodBeat.o(32520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eec
 * JD-Core Version:    0.7.0.1
 */