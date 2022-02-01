package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class uw
  extends com.tencent.mm.bx.a
{
  public b CWN;
  public LinkedList<b> CWO;
  
  public uw()
  {
    AppMethodBeat.i(123563);
    this.CWO = new LinkedList();
    AppMethodBeat.o(123563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CWN != null) {
        paramVarArgs.c(1, this.CWN);
      }
      paramVarArgs.e(2, 6, this.CWO);
      AppMethodBeat.o(123564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CWN == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.CWN) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.CWO);
      AppMethodBeat.o(123564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CWO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        uw localuw = (uw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123564);
          return -1;
        case 1: 
          localuw.CWN = locala.KhF.fMu();
          AppMethodBeat.o(123564);
          return 0;
        }
        localuw.CWO.add(locala.KhF.fMu());
        AppMethodBeat.o(123564);
        return 0;
      }
      AppMethodBeat.o(123564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uw
 * JD-Core Version:    0.7.0.1
 */