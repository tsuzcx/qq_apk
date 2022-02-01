package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dxl
  extends com.tencent.mm.bx.a
{
  public b LwG;
  public long LwH;
  public long LwI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LwG != null) {
        paramVarArgs.c(1, this.LwG);
      }
      paramVarArgs.aG(2, this.LwH);
      paramVarArgs.aG(3, this.LwI);
      AppMethodBeat.o(200805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LwG == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.b(1, this.LwG) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.LwH);
      int j = f.a.a.b.b.a.q(3, this.LwI);
      AppMethodBeat.o(200805);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(200805);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxl localdxl = (dxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200805);
          return -1;
        case 1: 
          localdxl.LwG = locala.KhF.fMu();
          AppMethodBeat.o(200805);
          return 0;
        case 2: 
          localdxl.LwH = locala.KhF.xT();
          AppMethodBeat.o(200805);
          return 0;
        }
        localdxl.LwI = locala.KhF.xT();
        AppMethodBeat.o(200805);
        return 0;
      }
      AppMethodBeat.o(200805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxl
 * JD-Core Version:    0.7.0.1
 */