package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cpc
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public b xXQ;
  public int xXR;
  public long xXS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124371);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xXQ != null) {
        paramVarArgs.c(1, this.xXQ);
      }
      paramVarArgs.aO(2, this.xXR);
      paramVarArgs.am(3, this.xXS);
      paramVarArgs.aO(4, this.Width);
      paramVarArgs.aO(5, this.Height);
      AppMethodBeat.o(124371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xXQ == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = e.a.a.b.b.a.b(1, this.xXQ) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xXR);
      int j = e.a.a.b.b.a.p(3, this.xXS);
      int k = e.a.a.b.b.a.bl(4, this.Width);
      int m = e.a.a.b.b.a.bl(5, this.Height);
      AppMethodBeat.o(124371);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124371);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpc localcpc = (cpc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124371);
          return -1;
        case 1: 
          localcpc.xXQ = locala.CLY.eqS();
          AppMethodBeat.o(124371);
          return 0;
        case 2: 
          localcpc.xXR = locala.CLY.sl();
          AppMethodBeat.o(124371);
          return 0;
        case 3: 
          localcpc.xXS = locala.CLY.sm();
          AppMethodBeat.o(124371);
          return 0;
        case 4: 
          localcpc.Width = locala.CLY.sl();
          AppMethodBeat.o(124371);
          return 0;
        }
        localcpc.Height = locala.CLY.sl();
        AppMethodBeat.o(124371);
        return 0;
      }
      AppMethodBeat.o(124371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpc
 * JD-Core Version:    0.7.0.1
 */