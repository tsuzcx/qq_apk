package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class la
  extends com.tencent.mm.bx.a
{
  public long FDj;
  public String FDk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FDj);
      if (this.FDk != null) {
        paramVarArgs.d(2, this.FDk);
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FDj) + 0;
      paramInt = i;
      if (this.FDk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDk);
      }
      AppMethodBeat.o(110891);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      la localla = (la)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110891);
        return -1;
      case 1: 
        localla.FDj = locala.NPN.zd();
        AppMethodBeat.o(110891);
        return 0;
      }
      localla.FDk = locala.NPN.readString();
      AppMethodBeat.o(110891);
      return 0;
    }
    AppMethodBeat.o(110891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.la
 * JD-Core Version:    0.7.0.1
 */