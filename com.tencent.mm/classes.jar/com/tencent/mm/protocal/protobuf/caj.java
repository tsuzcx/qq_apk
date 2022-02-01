package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caj
  extends com.tencent.mm.bx.a
{
  public int gsV;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43109);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gsV);
      if (this.yhw != null) {
        paramVarArgs.d(2, this.yhw);
      }
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.gsV) + 0;
      paramInt = i;
      if (this.yhw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yhw);
      }
      AppMethodBeat.o(43109);
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
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      caj localcaj = (caj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43109);
        return -1;
      case 1: 
        localcaj.gsV = locala.NPN.zc();
        AppMethodBeat.o(43109);
        return 0;
      }
      localcaj.yhw = locala.NPN.readString();
      AppMethodBeat.o(43109);
      return 0;
    }
    AppMethodBeat.o(43109);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */