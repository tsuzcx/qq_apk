package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cys
  extends com.tencent.mm.bw.a
{
  public String oxl;
  public String unW;
  public String unX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.unW != null) {
        paramVarArgs.d(1, this.unW);
      }
      if (this.unX != null) {
        paramVarArgs.d(2, this.unX);
      }
      if (this.oxl != null) {
        paramVarArgs.d(3, this.oxl);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.unW == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.unW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.unX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.unX);
      }
      i = paramInt;
      if (this.oxl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oxl);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cys localcys = (cys)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localcys.unW = locala.LVo.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localcys.unX = locala.LVo.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localcys.oxl = locala.LVo.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cys
 * JD-Core Version:    0.7.0.1
 */