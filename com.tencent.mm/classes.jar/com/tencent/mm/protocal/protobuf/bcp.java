package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcp
  extends com.tencent.mm.bv.a
{
  public String Url;
  public int jKs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94537);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.aO(2, this.jKs);
      AppMethodBeat.o(94537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jKs);
      AppMethodBeat.o(94537);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94537);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bcp localbcp = (bcp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94537);
          return -1;
        case 1: 
          localbcp.Url = locala.CLY.readString();
          AppMethodBeat.o(94537);
          return 0;
        }
        localbcp.jKs = locala.CLY.sl();
        AppMethodBeat.o(94537);
        return 0;
      }
      AppMethodBeat.o(94537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcp
 * JD-Core Version:    0.7.0.1
 */