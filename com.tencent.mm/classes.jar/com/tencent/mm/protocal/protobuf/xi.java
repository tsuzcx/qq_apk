package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class xi
  extends com.tencent.mm.bw.a
{
  public b Gph;
  public LinkedList<b> Gpi;
  
  public xi()
  {
    AppMethodBeat.i(123563);
    this.Gpi = new LinkedList();
    AppMethodBeat.o(123563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gph != null) {
        paramVarArgs.c(1, this.Gph);
      }
      paramVarArgs.e(2, 6, this.Gpi);
      AppMethodBeat.o(123564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gph == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.Gph) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.Gpi);
      AppMethodBeat.o(123564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gpi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xi localxi = (xi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123564);
          return -1;
        case 1: 
          localxi.Gph = locala.OmT.gCk();
          AppMethodBeat.o(123564);
          return 0;
        }
        localxi.Gpi.add(locala.OmT.gCk());
        AppMethodBeat.o(123564);
        return 0;
      }
      AppMethodBeat.o(123564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xi
 * JD-Core Version:    0.7.0.1
 */