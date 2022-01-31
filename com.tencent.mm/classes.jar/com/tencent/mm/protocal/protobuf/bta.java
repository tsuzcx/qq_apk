package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bta
  extends com.tencent.mm.bv.a
{
  public String lGx;
  public String wuT;
  public int xEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28614);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lGx != null) {
        paramVarArgs.e(1, this.lGx);
      }
      if (this.wuT != null) {
        paramVarArgs.e(2, this.wuT);
      }
      paramVarArgs.aO(3, this.xEp);
      AppMethodBeat.o(28614);
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
      int i = paramInt;
      if (this.wuT != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wuT);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xEp);
      AppMethodBeat.o(28614);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28614);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bta localbta = (bta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28614);
          return -1;
        case 1: 
          localbta.lGx = locala.CLY.readString();
          AppMethodBeat.o(28614);
          return 0;
        case 2: 
          localbta.wuT = locala.CLY.readString();
          AppMethodBeat.o(28614);
          return 0;
        }
        localbta.xEp = locala.CLY.sl();
        AppMethodBeat.o(28614);
        return 0;
      }
      AppMethodBeat.o(28614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bta
 * JD-Core Version:    0.7.0.1
 */