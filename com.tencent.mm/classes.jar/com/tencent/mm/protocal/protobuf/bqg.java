package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bqg
  extends com.tencent.mm.bv.a
{
  public String mkE;
  public int nrS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123513);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.mkE == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(123513);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nrS);
      if (this.mkE != null) {
        paramVarArgs.e(2, this.mkE);
      }
      AppMethodBeat.o(123513);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nrS) + 0;
      paramInt = i;
      if (this.mkE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.mkE);
      }
      AppMethodBeat.o(123513);
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
      if (this.mkE == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(123513);
        throw paramVarArgs;
      }
      AppMethodBeat.o(123513);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bqg localbqg = (bqg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123513);
        return -1;
      case 1: 
        localbqg.nrS = locala.CLY.sl();
        AppMethodBeat.o(123513);
        return 0;
      }
      localbqg.mkE = locala.CLY.readString();
      AppMethodBeat.o(123513);
      return 0;
    }
    AppMethodBeat.o(123513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqg
 * JD-Core Version:    0.7.0.1
 */