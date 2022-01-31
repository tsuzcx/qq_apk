package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpx
  extends com.tencent.mm.bv.a
{
  public String lGx;
  public String wSj;
  public int xEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28597);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lGx != null) {
        paramVarArgs.e(1, this.lGx);
      }
      paramVarArgs.aO(2, this.xEp);
      if (this.wSj != null) {
        paramVarArgs.e(3, this.wSj);
      }
      AppMethodBeat.o(28597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lGx == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.lGx) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xEp);
      paramInt = i;
      if (this.wSj != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wSj);
      }
      AppMethodBeat.o(28597);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28597);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bpx localbpx = (bpx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28597);
          return -1;
        case 1: 
          localbpx.lGx = locala.CLY.readString();
          AppMethodBeat.o(28597);
          return 0;
        case 2: 
          localbpx.xEp = locala.CLY.sl();
          AppMethodBeat.o(28597);
          return 0;
        }
        localbpx.wSj = locala.CLY.readString();
        AppMethodBeat.o(28597);
        return 0;
      }
      AppMethodBeat.o(28597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpx
 * JD-Core Version:    0.7.0.1
 */