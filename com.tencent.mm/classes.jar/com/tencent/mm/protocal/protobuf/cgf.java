package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgf
  extends com.tencent.mm.bw.a
{
  public double Ecf;
  public double Ecg;
  public double Fur;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Ecg);
      paramVarArgs.e(2, this.Ecf);
      paramVarArgs.e(3, this.Fur);
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(56258);
      return paramInt + 8 + 0 + (i + 8) + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgf localcgf = (cgf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56258);
        return -1;
      case 1: 
        localcgf.Ecg = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(56258);
        return 0;
      case 2: 
        localcgf.Ecf = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(56258);
        return 0;
      }
      localcgf.Fur = Double.longBitsToDouble(locala.LVo.gab());
      AppMethodBeat.o(56258);
      return 0;
    }
    AppMethodBeat.o(56258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgf
 * JD-Core Version:    0.7.0.1
 */