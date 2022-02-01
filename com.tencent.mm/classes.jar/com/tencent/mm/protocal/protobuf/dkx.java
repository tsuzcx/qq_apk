package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkx
  extends com.tencent.mm.bx.a
{
  public String GFh;
  public int GOe;
  public String HzK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GOe);
      if (this.GFh != null) {
        paramVarArgs.d(2, this.GFh);
      }
      if (this.HzK != null) {
        paramVarArgs.d(3, this.HzK);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GOe) + 0;
      paramInt = i;
      if (this.GFh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GFh);
      }
      i = paramInt;
      if (this.HzK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HzK);
      }
      AppMethodBeat.o(152708);
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
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkx localdkx = (dkx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localdkx.GOe = locala.NPN.zc();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localdkx.GFh = locala.NPN.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localdkx.HzK = locala.NPN.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkx
 * JD-Core Version:    0.7.0.1
 */