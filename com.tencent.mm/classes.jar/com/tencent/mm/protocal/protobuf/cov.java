package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cov
  extends com.tencent.mm.bx.a
{
  public String Ggv;
  public int Hij;
  public String qdY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qdY != null) {
        paramVarArgs.d(1, this.qdY);
      }
      paramVarArgs.aS(2, this.Hij);
      if (this.Ggv != null) {
        paramVarArgs.d(3, this.Ggv);
      }
      AppMethodBeat.o(32394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qdY == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.qdY) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hij);
      paramInt = i;
      if (this.Ggv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ggv);
      }
      AppMethodBeat.o(32394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32394);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cov localcov = (cov)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32394);
          return -1;
        case 1: 
          localcov.qdY = locala.NPN.readString();
          AppMethodBeat.o(32394);
          return 0;
        case 2: 
          localcov.Hij = locala.NPN.zc();
          AppMethodBeat.o(32394);
          return 0;
        }
        localcov.Ggv = locala.NPN.readString();
        AppMethodBeat.o(32394);
        return 0;
      }
      AppMethodBeat.o(32394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cov
 * JD-Core Version:    0.7.0.1
 */