package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbf
  extends com.tencent.mm.bx.a
{
  public double CJD;
  public double CJE;
  public double DXx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.CJE);
      paramVarArgs.e(2, this.CJD);
      paramVarArgs.e(3, this.DXx);
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(56258);
      return paramInt + 8 + 0 + (i + 8) + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbf localcbf = (cbf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56258);
        return -1;
      case 1: 
        localcbf.CJE = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(56258);
        return 0;
      case 2: 
        localcbf.CJD = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(56258);
        return 0;
      }
      localcbf.DXx = Double.longBitsToDouble(locala.KhF.fHy());
      AppMethodBeat.o(56258);
      return 0;
    }
    AppMethodBeat.o(56258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbf
 * JD-Core Version:    0.7.0.1
 */