package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awa
  extends com.tencent.mm.bw.a
{
  public double Ecf;
  public double Ecg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32236);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Ecf);
      paramVarArgs.e(2, this.Ecg);
      AppMethodBeat.o(32236);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(32236);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32236);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      awa localawa = (awa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32236);
        return -1;
      case 1: 
        localawa.Ecf = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(32236);
        return 0;
      }
      localawa.Ecg = Double.longBitsToDouble(locala.LVo.gab());
      AppMethodBeat.o(32236);
      return 0;
    }
    AppMethodBeat.o(32236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awa
 * JD-Core Version:    0.7.0.1
 */