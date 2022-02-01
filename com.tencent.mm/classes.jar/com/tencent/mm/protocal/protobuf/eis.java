package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eis
  extends com.tencent.mm.bw.a
{
  public boolean IlU;
  public int IlV;
  public double IlW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.IlU);
      paramVarArgs.aS(2, this.IlV);
      paramVarArgs.e(3, this.IlW);
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.bz(2, this.IlV);
      int j = f.a.a.b.b.a.amD(3);
      AppMethodBeat.o(50121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eis localeis = (eis)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50121);
        return -1;
      case 1: 
        localeis.IlU = locala.OmT.gvY();
        AppMethodBeat.o(50121);
        return 0;
      case 2: 
        localeis.IlV = locala.OmT.zc();
        AppMethodBeat.o(50121);
        return 0;
      }
      localeis.IlW = Double.longBitsToDouble(locala.OmT.gwc());
      AppMethodBeat.o(50121);
      return 0;
    }
    AppMethodBeat.o(50121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eis
 * JD-Core Version:    0.7.0.1
 */