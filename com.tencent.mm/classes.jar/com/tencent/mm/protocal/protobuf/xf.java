package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class xf
  extends com.tencent.mm.bx.a
{
  public b FWI;
  public LinkedList<b> FWJ;
  
  public xf()
  {
    AppMethodBeat.i(123563);
    this.FWJ = new LinkedList();
    AppMethodBeat.o(123563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWI != null) {
        paramVarArgs.c(1, this.FWI);
      }
      paramVarArgs.e(2, 6, this.FWJ);
      AppMethodBeat.o(123564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWI == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.FWI) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.FWJ);
      AppMethodBeat.o(123564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FWJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xf localxf = (xf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123564);
          return -1;
        case 1: 
          localxf.FWI = locala.NPN.gxI();
          AppMethodBeat.o(123564);
          return 0;
        }
        localxf.FWJ.add(locala.NPN.gxI());
        AppMethodBeat.o(123564);
        return 0;
      }
      AppMethodBeat.o(123564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xf
 * JD-Core Version:    0.7.0.1
 */