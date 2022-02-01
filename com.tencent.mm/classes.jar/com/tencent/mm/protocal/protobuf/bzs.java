package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzs
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String GUK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GUK != null) {
        paramVarArgs.d(1, this.GUK);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUK == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.GUK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32349);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzs localbzs = (bzs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32349);
          return -1;
        case 1: 
          localbzs.GUK = locala.NPN.readString();
          AppMethodBeat.o(32349);
          return 0;
        }
        localbzs.Desc = locala.NPN.readString();
        AppMethodBeat.o(32349);
        return 0;
      }
      AppMethodBeat.o(32349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */