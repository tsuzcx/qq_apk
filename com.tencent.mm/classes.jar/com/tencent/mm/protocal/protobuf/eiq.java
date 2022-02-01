package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiq
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GLq;
  public int HTf;
  public int HTg;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLq);
      paramVarArgs.aS(2, this.FFN);
      paramVarArgs.aS(3, this.HTf);
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(10, this.HTg);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GLq);
      int i = f.a.a.b.b.a.bz(2, this.FFN);
      int j = f.a.a.b.b.a.bz(3, this.HTf);
      int k = f.a.a.b.b.a.bz(4, this.Scene);
      int m = f.a.a.b.b.a.bz(10, this.HTg);
      AppMethodBeat.o(123712);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eiq localeiq = (eiq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localeiq.GLq = locala.NPN.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localeiq.FFN = locala.NPN.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localeiq.HTf = locala.NPN.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localeiq.Scene = locala.NPN.zc();
        AppMethodBeat.o(123712);
        return 0;
      }
      localeiq.HTg = locala.NPN.zc();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiq
 * JD-Core Version:    0.7.0.1
 */