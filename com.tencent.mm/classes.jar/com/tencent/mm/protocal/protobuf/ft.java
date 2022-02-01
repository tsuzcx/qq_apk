package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ft
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b DSO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DSO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Cookies");
        AppMethodBeat.o(32117);
        throw paramVarArgs;
      }
      if (this.DSO != null) {
        paramVarArgs.c(1, this.DSO);
      }
      AppMethodBeat.o(32117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSO == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.b(1, this.DSO) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32117);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DSO == null)
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
        ft localft = (ft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32117);
          return -1;
        }
        localft.DSO = locala.LVo.gfk();
        AppMethodBeat.o(32117);
        return 0;
      }
      AppMethodBeat.o(32117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */