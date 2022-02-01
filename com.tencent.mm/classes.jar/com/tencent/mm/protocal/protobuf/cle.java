package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cle
  extends com.tencent.mm.bx.a
{
  public double FIb;
  public double FIc;
  public double Hew;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.FIc);
      paramVarArgs.e(2, this.FIb);
      paramVarArgs.e(3, this.Hew);
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alT(1);
      int i = f.a.a.b.b.a.alT(2);
      int j = f.a.a.b.b.a.alT(3);
      AppMethodBeat.o(56258);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cle localcle = (cle)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56258);
        return -1;
      case 1: 
        localcle.FIc = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(56258);
        return 0;
      case 2: 
        localcle.FIb = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(56258);
        return 0;
      }
      localcle.Hew = Double.longBitsToDouble(locala.NPN.grA());
      AppMethodBeat.o(56258);
      return 0;
    }
    AppMethodBeat.o(56258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cle
 * JD-Core Version:    0.7.0.1
 */