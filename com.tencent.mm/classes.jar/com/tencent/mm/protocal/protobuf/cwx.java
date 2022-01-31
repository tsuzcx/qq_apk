package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwx
  extends com.tencent.mm.bv.a
{
  public int nuk;
  public String yaU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28731);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yaU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28731);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nuk);
      if (this.yaU != null) {
        paramVarArgs.e(2, this.yaU);
      }
      AppMethodBeat.o(28731);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nuk) + 0;
      paramInt = i;
      if (this.yaU != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yaU);
      }
      AppMethodBeat.o(28731);
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
      if (this.yaU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28731);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28731);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cwx localcwx = (cwx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28731);
        return -1;
      case 1: 
        localcwx.nuk = locala.CLY.sl();
        AppMethodBeat.o(28731);
        return 0;
      }
      localcwx.yaU = locala.CLY.readString();
      AppMethodBeat.o(28731);
      return 0;
    }
    AppMethodBeat.o(28731);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */