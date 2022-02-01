package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cko
  extends com.tencent.mm.bx.a
{
  public int CyY;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aR(2, this.CyY);
      paramVarArgs.aR(3, this.Scene);
      AppMethodBeat.o(6427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CyY);
      int j = f.a.a.b.b.a.bA(3, this.Scene);
      AppMethodBeat.o(6427);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6427);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cko localcko = (cko)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6427);
          return -1;
        case 1: 
          localcko.Url = locala.KhF.readString();
          AppMethodBeat.o(6427);
          return 0;
        case 2: 
          localcko.CyY = locala.KhF.xS();
          AppMethodBeat.o(6427);
          return 0;
        }
        localcko.Scene = locala.KhF.xS();
        AppMethodBeat.o(6427);
        return 0;
      }
      AppMethodBeat.o(6427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cko
 * JD-Core Version:    0.7.0.1
 */