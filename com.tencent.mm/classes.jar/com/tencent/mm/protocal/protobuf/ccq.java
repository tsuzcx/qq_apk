package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccq
  extends com.tencent.mm.bw.a
{
  public String AZI;
  public int LjQ;
  public String xJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LjQ);
      if (this.AZI != null) {
        paramVarArgs.e(2, this.AZI);
      }
      if (this.xJz != null) {
        paramVarArgs.e(3, this.xJz);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LjQ) + 0;
      paramInt = i;
      if (this.AZI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AZI);
      }
      i = paramInt;
      if (this.xJz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJz);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ccq localccq = (ccq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localccq.LjQ = locala.UbS.zi();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localccq.AZI = locala.UbS.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localccq.xJz = locala.UbS.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */