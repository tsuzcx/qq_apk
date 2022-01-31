package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bvf
  extends com.tencent.mm.bv.a
{
  public int xIV;
  public String xIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80163);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xIW == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(80163);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xIV);
      if (this.xIW != null) {
        paramVarArgs.e(2, this.xIW);
      }
      AppMethodBeat.o(80163);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xIV) + 0;
      paramInt = i;
      if (this.xIW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xIW);
      }
      AppMethodBeat.o(80163);
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
      if (this.xIW == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(80163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(80163);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bvf localbvf = (bvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80163);
        return -1;
      case 1: 
        localbvf.xIV = locala.CLY.sl();
        AppMethodBeat.o(80163);
        return 0;
      }
      localbvf.xIW = locala.CLY.readString();
      AppMethodBeat.o(80163);
      return 0;
    }
    AppMethodBeat.o(80163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvf
 * JD-Core Version:    0.7.0.1
 */