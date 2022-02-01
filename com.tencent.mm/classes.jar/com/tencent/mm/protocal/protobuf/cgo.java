package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgo
  extends com.tencent.mm.bx.a
{
  public int GZD;
  public String GZE;
  public String IconUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50095);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GZD);
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.GZE != null) {
        paramVarArgs.d(3, this.GZE);
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GZD) + 0;
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.GZE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GZE);
      }
      AppMethodBeat.o(50095);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgo localcgo = (cgo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50095);
        return -1;
      case 1: 
        localcgo.GZD = locala.NPN.zc();
        AppMethodBeat.o(50095);
        return 0;
      case 2: 
        localcgo.IconUrl = locala.NPN.readString();
        AppMethodBeat.o(50095);
        return 0;
      }
      localcgo.GZE = locala.NPN.readString();
      AppMethodBeat.o(50095);
      return 0;
    }
    AppMethodBeat.o(50095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgo
 * JD-Core Version:    0.7.0.1
 */