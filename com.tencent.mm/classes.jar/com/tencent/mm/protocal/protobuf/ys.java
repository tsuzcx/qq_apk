package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ys
  extends com.tencent.mm.bw.a
{
  public b LjS;
  public LinkedList<b> LjT;
  
  public ys()
  {
    AppMethodBeat.i(123563);
    this.LjT = new LinkedList();
    AppMethodBeat.o(123563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LjS != null) {
        paramVarArgs.c(1, this.LjS);
      }
      paramVarArgs.e(2, 6, this.LjT);
      AppMethodBeat.o(123564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LjS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.LjS) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 6, this.LjT);
      AppMethodBeat.o(123564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LjT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123564);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ys localys = (ys)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123564);
          return -1;
        case 1: 
          localys.LjS = locala.UbS.hPo();
          AppMethodBeat.o(123564);
          return 0;
        }
        localys.LjT.add(locala.UbS.hPo());
        AppMethodBeat.o(123564);
        return 0;
      }
      AppMethodBeat.o(123564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ys
 * JD-Core Version:    0.7.0.1
 */