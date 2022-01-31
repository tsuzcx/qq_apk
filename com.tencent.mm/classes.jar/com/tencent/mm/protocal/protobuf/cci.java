package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cci
  extends com.tencent.mm.bv.a
{
  public String url;
  public int xMJ;
  public int xMK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80188);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      paramVarArgs.aO(2, this.xMJ);
      paramVarArgs.aO(3, this.xMK);
      AppMethodBeat.o(80188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xMJ);
      int j = e.a.a.b.b.a.bl(3, this.xMK);
      AppMethodBeat.o(80188);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80188);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cci localcci = (cci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80188);
          return -1;
        case 1: 
          localcci.url = locala.CLY.readString();
          AppMethodBeat.o(80188);
          return 0;
        case 2: 
          localcci.xMJ = locala.CLY.sl();
          AppMethodBeat.o(80188);
          return 0;
        }
        localcci.xMK = locala.CLY.sl();
        AppMethodBeat.o(80188);
        return 0;
      }
      AppMethodBeat.o(80188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cci
 * JD-Core Version:    0.7.0.1
 */