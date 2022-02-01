package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buq
  extends com.tencent.mm.bw.a
{
  public String v;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.v != null) {
        paramVarArgs.d(1, this.v);
      }
      AppMethodBeat.o(155441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.v == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.v) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(155441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155441);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buq localbuq = (buq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155441);
          return -1;
        }
        localbuq.v = locala.LVo.readString();
        AppMethodBeat.o(155441);
        return 0;
      }
      AppMethodBeat.o(155441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buq
 * JD-Core Version:    0.7.0.1
 */