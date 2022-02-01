package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gn
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKm == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Cookies");
        AppMethodBeat.o(32117);
        throw paramVarArgs;
      }
      if (this.KKm != null) {
        paramVarArgs.c(1, this.KKm);
      }
      AppMethodBeat.o(32117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KKm == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = g.a.a.b.b.a.b(1, this.KKm) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32117);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKm == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Cookies");
          AppMethodBeat.o(32117);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        gn localgn = (gn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32117);
          return -1;
        }
        localgn.KKm = locala.UbS.hPo();
        AppMethodBeat.o(32117);
        return 0;
      }
      AppMethodBeat.o(32117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gn
 * JD-Core Version:    0.7.0.1
 */