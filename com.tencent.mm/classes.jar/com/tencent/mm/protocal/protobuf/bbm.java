package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbm
  extends com.tencent.mm.bv.a
{
  public String Title;
  public int woE;
  public String xqI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11786);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xqI != null) {
        paramVarArgs.e(1, this.xqI);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.aO(3, this.woE);
      AppMethodBeat.o(11786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xqI == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.xqI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Title);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.woE);
      AppMethodBeat.o(11786);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11786);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bbm localbbm = (bbm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11786);
          return -1;
        case 1: 
          localbbm.xqI = locala.CLY.readString();
          AppMethodBeat.o(11786);
          return 0;
        case 2: 
          localbbm.Title = locala.CLY.readString();
          AppMethodBeat.o(11786);
          return 0;
        }
        localbbm.woE = locala.CLY.sl();
        AppMethodBeat.o(11786);
        return 0;
      }
      AppMethodBeat.o(11786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbm
 * JD-Core Version:    0.7.0.1
 */