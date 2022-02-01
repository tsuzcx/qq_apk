package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czx
  extends com.tencent.mm.bx.a
{
  public String nDo;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      AppMethodBeat.o(32430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xbo);
      }
      AppMethodBeat.o(32430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32430);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czx localczx = (czx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32430);
          return -1;
        case 1: 
          localczx.nDo = locala.NPN.readString();
          AppMethodBeat.o(32430);
          return 0;
        }
        localczx.xbo = locala.NPN.readString();
        AppMethodBeat.o(32430);
        return 0;
      }
      AppMethodBeat.o(32430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czx
 * JD-Core Version:    0.7.0.1
 */