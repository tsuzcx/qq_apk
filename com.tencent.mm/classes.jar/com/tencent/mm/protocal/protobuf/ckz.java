package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckz
  extends com.tencent.mm.bw.a
{
  public String Hxp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209700);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxp != null) {
        paramVarArgs.d(1, this.Hxp);
      }
      AppMethodBeat.o(209700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxp == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hxp) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209700);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(209700);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckz localckz = (ckz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209700);
          return -1;
        }
        localckz.Hxp = locala.OmT.readString();
        AppMethodBeat.o(209700);
        return 0;
      }
      AppMethodBeat.o(209700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */