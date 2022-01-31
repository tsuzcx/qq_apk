package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bux
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String Url;
  public int wqj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14745);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.aO(2, this.wqj);
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(14745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = e.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wqj);
      int j = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(14745);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14745);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bux localbux = (bux)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14745);
          return -1;
        case 1: 
          localbux.Url = locala.CLY.readString();
          AppMethodBeat.o(14745);
          return 0;
        case 2: 
          localbux.wqj = locala.CLY.sl();
          AppMethodBeat.o(14745);
          return 0;
        }
        localbux.Scene = locala.CLY.sl();
        AppMethodBeat.o(14745);
        return 0;
      }
      AppMethodBeat.o(14745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bux
 * JD-Core Version:    0.7.0.1
 */