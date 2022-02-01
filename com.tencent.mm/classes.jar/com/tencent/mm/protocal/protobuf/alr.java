package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alr
  extends com.tencent.mm.bw.a
{
  public String EFk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195088);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFk != null) {
        paramVarArgs.d(1, this.EFk);
      }
      AppMethodBeat.o(195088);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFk == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EFk) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(195088);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195088);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alr localalr = (alr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195088);
          return -1;
        }
        localalr.EFk = locala.LVo.readString();
        AppMethodBeat.o(195088);
        return 0;
      }
      AppMethodBeat.o(195088);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alr
 * JD-Core Version:    0.7.0.1
 */