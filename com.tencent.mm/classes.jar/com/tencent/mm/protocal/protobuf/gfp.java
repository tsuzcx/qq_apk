package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfp
  extends com.tencent.mm.bx.a
{
  public String YYC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYC == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32520);
        throw paramVarArgs;
      }
      if (this.YYC != null) {
        paramVarArgs.g(1, this.YYC);
      }
      AppMethodBeat.o(32520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YYC == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = i.a.a.b.b.a.h(1, this.YYC) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YYC == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfp localgfp = (gfp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32520);
          return -1;
        }
        localgfp.YYC = locala.ajGk.readString();
        AppMethodBeat.o(32520);
        return 0;
      }
      AppMethodBeat.o(32520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfp
 * JD-Core Version:    0.7.0.1
 */