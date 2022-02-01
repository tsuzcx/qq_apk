package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bol
  extends com.tencent.mm.bw.a
{
  public b Hbz;
  public long dPq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.dPq);
      if (this.Hbz != null) {
        paramVarArgs.c(2, this.Hbz);
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.dPq) + 0;
      paramInt = i;
      if (this.Hbz != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Hbz);
      }
      AppMethodBeat.o(116328);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bol localbol = (bol)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116328);
        return -1;
      case 1: 
        localbol.dPq = locala.OmT.zd();
        AppMethodBeat.o(116328);
        return 0;
      }
      localbol.Hbz = locala.OmT.gCk();
      AppMethodBeat.o(116328);
      return 0;
    }
    AppMethodBeat.o(116328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */