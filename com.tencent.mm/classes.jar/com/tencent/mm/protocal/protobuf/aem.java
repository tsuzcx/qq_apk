package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aem
  extends com.tencent.mm.bx.a
{
  public String Dex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dex == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32201);
        throw paramVarArgs;
      }
      if (this.Dex != null) {
        paramVarArgs.d(1, this.Dex);
      }
      AppMethodBeat.o(32201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dex == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dex) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32201);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dex == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32201);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32201);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aem localaem = (aem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32201);
          return -1;
        }
        localaem.Dex = locala.KhF.readString();
        AppMethodBeat.o(32201);
        return 0;
      }
      AppMethodBeat.o(32201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */