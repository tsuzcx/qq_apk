package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class diz
  extends com.tencent.mm.bx.a
{
  public int Ezh;
  public b Ezi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ezh);
      if (this.Ezi != null) {
        paramVarArgs.c(2, this.Ezi);
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ezh) + 0;
      paramInt = i;
      if (this.Ezi != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Ezi);
      }
      AppMethodBeat.o(115856);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      diz localdiz = (diz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115856);
        return -1;
      case 1: 
        localdiz.Ezh = locala.KhF.xS();
        AppMethodBeat.o(115856);
        return 0;
      }
      localdiz.Ezi = locala.KhF.fMu();
      AppMethodBeat.o(115856);
      return 0;
    }
    AppMethodBeat.o(115856);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diz
 * JD-Core Version:    0.7.0.1
 */