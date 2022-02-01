package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecl
  extends com.tencent.mm.bx.a
{
  public String FME;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FME == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32520);
        throw paramVarArgs;
      }
      if (this.FME != null) {
        paramVarArgs.d(1, this.FME);
      }
      AppMethodBeat.o(32520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FME == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.e(1, this.FME) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FME == null)
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
        ecl localecl = (ecl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32520);
          return -1;
        }
        localecl.FME = locala.NPN.readString();
        AppMethodBeat.o(32520);
        return 0;
      }
      AppMethodBeat.o(32520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecl
 * JD-Core Version:    0.7.0.1
 */