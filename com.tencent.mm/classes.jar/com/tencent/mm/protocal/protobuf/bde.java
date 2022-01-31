package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bde
  extends com.tencent.mm.bv.a
{
  public String cfP;
  public LinkedList<String> xtg;
  
  public bde()
  {
    AppMethodBeat.i(2544);
    this.xtg = new LinkedList();
    AppMethodBeat.o(2544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2545);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cfP != null) {
        paramVarArgs.e(1, this.cfP);
      }
      paramVarArgs.e(2, 1, this.xtg);
      AppMethodBeat.o(2545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cfP == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.cfP) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 1, this.xtg);
      AppMethodBeat.o(2545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xtg.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2545);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bde localbde = (bde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(2545);
          return -1;
        case 1: 
          localbde.cfP = locala.CLY.readString();
          AppMethodBeat.o(2545);
          return 0;
        }
        localbde.xtg.add(locala.CLY.readString());
        AppMethodBeat.o(2545);
        return 0;
      }
      AppMethodBeat.o(2545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bde
 * JD-Core Version:    0.7.0.1
 */