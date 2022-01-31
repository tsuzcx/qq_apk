package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class se
  extends com.tencent.mm.bv.a
{
  public b wKA;
  public LinkedList<b> wKB;
  
  public se()
  {
    AppMethodBeat.i(96213);
    this.wKB = new LinkedList();
    AppMethodBeat.o(96213);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96214);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wKA != null) {
        paramVarArgs.c(1, this.wKA);
      }
      paramVarArgs.e(2, 6, this.wKB);
      AppMethodBeat.o(96214);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wKA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.b(1, this.wKA) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 6, this.wKB);
      AppMethodBeat.o(96214);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wKB.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96214);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96214);
          return -1;
        case 1: 
          localse.wKA = locala.CLY.eqS();
          AppMethodBeat.o(96214);
          return 0;
        }
        localse.wKB.add(locala.CLY.eqS());
        AppMethodBeat.o(96214);
        return 0;
      }
      AppMethodBeat.o(96214);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */