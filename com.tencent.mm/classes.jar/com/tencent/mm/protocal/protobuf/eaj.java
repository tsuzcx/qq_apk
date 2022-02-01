package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaj
  extends com.tencent.mm.bx.a
{
  public int ID;
  public String hDa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ID);
      if (this.hDa != null) {
        paramVarArgs.d(2, this.hDa);
      }
      AppMethodBeat.o(32505);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ID) + 0;
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hDa);
      }
      AppMethodBeat.o(32505);
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
      AppMethodBeat.o(32505);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaj localeaj = (eaj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32505);
        return -1;
      case 1: 
        localeaj.ID = locala.NPN.zc();
        AppMethodBeat.o(32505);
        return 0;
      }
      localeaj.hDa = locala.NPN.readString();
      AppMethodBeat.o(32505);
      return 0;
    }
    AppMethodBeat.o(32505);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */