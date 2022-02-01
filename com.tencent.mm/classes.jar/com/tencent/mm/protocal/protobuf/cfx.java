package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfx
  extends com.tencent.mm.bw.a
{
  public String Fug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195130);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fug != null) {
        paramVarArgs.d(1, this.Fug);
      }
      AppMethodBeat.o(195130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fug == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fug) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(195130);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195130);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfx localcfx = (cfx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195130);
          return -1;
        }
        localcfx.Fug = locala.LVo.readString();
        AppMethodBeat.o(195130);
        return 0;
      }
      AppMethodBeat.o(195130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfx
 * JD-Core Version:    0.7.0.1
 */