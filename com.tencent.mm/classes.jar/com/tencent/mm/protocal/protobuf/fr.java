package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fr
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Cookies");
        AppMethodBeat.o(32117);
        throw paramVarArgs;
      }
      if (this.CAs != null) {
        paramVarArgs.c(1, this.CAs);
      }
      AppMethodBeat.o(32117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CAs == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.b(1, this.CAs) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32117);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CAs == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Cookies");
          AppMethodBeat.o(32117);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32117);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32117);
          return -1;
        }
        localfr.CAs = locala.KhF.fMu();
        AppMethodBeat.o(32117);
        return 0;
      }
      AppMethodBeat.o(32117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */