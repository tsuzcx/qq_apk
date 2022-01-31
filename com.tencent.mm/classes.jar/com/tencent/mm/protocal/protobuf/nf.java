package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class nf
  extends com.tencent.mm.bv.a
{
  public long wCc;
  public b wCd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60024);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wCc);
      if (this.wCd != null) {
        paramVarArgs.c(2, this.wCd);
      }
      AppMethodBeat.o(60024);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wCc) + 0;
      paramInt = i;
      if (this.wCd != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wCd);
      }
      AppMethodBeat.o(60024);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60024);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      nf localnf = (nf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60024);
        return -1;
      case 1: 
        localnf.wCc = locala.CLY.sm();
        AppMethodBeat.o(60024);
        return 0;
      }
      localnf.wCd = locala.CLY.eqS();
      AppMethodBeat.o(60024);
      return 0;
    }
    AppMethodBeat.o(60024);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nf
 * JD-Core Version:    0.7.0.1
 */