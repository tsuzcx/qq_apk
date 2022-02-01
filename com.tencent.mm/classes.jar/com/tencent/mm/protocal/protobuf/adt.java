package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class adt
  extends com.tencent.mm.bw.a
{
  public String iKt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKt == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152535);
        throw paramVarArgs;
      }
      if (this.iKt != null) {
        paramVarArgs.d(1, this.iKt);
      }
      AppMethodBeat.o(152535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKt == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.iKt) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152535);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.iKt == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152535);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152535);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        adt localadt = (adt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152535);
          return -1;
        }
        localadt.iKt = locala.OmT.readString();
        AppMethodBeat.o(152535);
        return 0;
      }
      AppMethodBeat.o(152535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adt
 * JD-Core Version:    0.7.0.1
 */