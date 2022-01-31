package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nx
  extends com.tencent.mm.bv.a
{
  public String wDA;
  public LinkedList<String> wDB;
  
  public nx()
  {
    AppMethodBeat.i(48787);
    this.wDB = new LinkedList();
    AppMethodBeat.o(48787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48788);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wDA != null) {
        paramVarArgs.e(1, this.wDA);
      }
      paramVarArgs.e(2, 1, this.wDB);
      AppMethodBeat.o(48788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.wDA) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 1, this.wDB);
      AppMethodBeat.o(48788);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wDB.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48788);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        nx localnx = (nx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48788);
          return -1;
        case 1: 
          localnx.wDA = locala.CLY.readString();
          AppMethodBeat.o(48788);
          return 0;
        }
        localnx.wDB.add(locala.CLY.readString());
        AppMethodBeat.o(48788);
        return 0;
      }
      AppMethodBeat.o(48788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */