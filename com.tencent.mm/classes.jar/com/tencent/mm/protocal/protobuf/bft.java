package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bft
  extends com.tencent.mm.bx.a
{
  public b DDf;
  public long dEb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.dEb);
      if (this.DDf != null) {
        paramVarArgs.c(2, this.DDf);
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.dEb) + 0;
      paramInt = i;
      if (this.DDf != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DDf);
      }
      AppMethodBeat.o(116328);
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
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bft localbft = (bft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116328);
        return -1;
      case 1: 
        localbft.dEb = locala.KhF.xT();
        AppMethodBeat.o(116328);
        return 0;
      }
      localbft.DDf = locala.KhF.fMu();
      AppMethodBeat.o(116328);
      return 0;
    }
    AppMethodBeat.o(116328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bft
 * JD-Core Version:    0.7.0.1
 */