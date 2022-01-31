package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyr
  extends com.tencent.mm.bv.a
{
  public String yfJ;
  public boolean yfK;
  public int yfL;
  public int yfM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63695);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yfJ != null) {
        paramVarArgs.e(1, this.yfJ);
      }
      paramVarArgs.aS(2, this.yfK);
      paramVarArgs.aO(3, this.yfL);
      paramVarArgs.aO(4, this.yfM);
      AppMethodBeat.o(63695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yfJ == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.yfJ) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.bl(3, this.yfL);
      int k = e.a.a.b.b.a.bl(4, this.yfM);
      AppMethodBeat.o(63695);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(63695);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cyr localcyr = (cyr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63695);
          return -1;
        case 1: 
          localcyr.yfJ = locala.CLY.readString();
          AppMethodBeat.o(63695);
          return 0;
        case 2: 
          localcyr.yfK = locala.CLY.emu();
          AppMethodBeat.o(63695);
          return 0;
        case 3: 
          localcyr.yfL = locala.CLY.sl();
          AppMethodBeat.o(63695);
          return 0;
        }
        localcyr.yfM = locala.CLY.sl();
        AppMethodBeat.o(63695);
        return 0;
      }
      AppMethodBeat.o(63695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyr
 * JD-Core Version:    0.7.0.1
 */