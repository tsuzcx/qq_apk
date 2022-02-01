package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahx
  extends com.tencent.mm.bx.a
{
  public int Gfk;
  public String Gfl;
  public String Gfm;
  public String Gfn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gfk);
      if (this.Gfl != null) {
        paramVarArgs.d(2, this.Gfl);
      }
      if (this.Gfm != null) {
        paramVarArgs.d(3, this.Gfm);
      }
      if (this.Gfn != null) {
        paramVarArgs.d(4, this.Gfn);
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gfk) + 0;
      paramInt = i;
      if (this.Gfl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gfl);
      }
      i = paramInt;
      if (this.Gfm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gfm);
      }
      paramInt = i;
      if (this.Gfn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gfn);
      }
      AppMethodBeat.o(32199);
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
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahx localahx = (ahx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localahx.Gfk = locala.NPN.zc();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localahx.Gfl = locala.NPN.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localahx.Gfm = locala.NPN.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localahx.Gfn = locala.NPN.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahx
 * JD-Core Version:    0.7.0.1
 */