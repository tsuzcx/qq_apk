package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adc
  extends com.tencent.mm.bw.a
{
  public long Lnv;
  public long Lnw;
  public int Loj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186803);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnv);
      paramVarArgs.bb(2, this.Lnw);
      paramVarArgs.aM(3, this.Loj);
      AppMethodBeat.o(186803);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Lnv);
      int i = g.a.a.b.b.a.r(2, this.Lnw);
      int j = g.a.a.b.b.a.bu(3, this.Loj);
      AppMethodBeat.o(186803);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(186803);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adc localadc = (adc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(186803);
        return -1;
      case 1: 
        localadc.Lnv = locala.UbS.zl();
        AppMethodBeat.o(186803);
        return 0;
      case 2: 
        localadc.Lnw = locala.UbS.zl();
        AppMethodBeat.o(186803);
        return 0;
      }
      localadc.Loj = locala.UbS.zi();
      AppMethodBeat.o(186803);
      return 0;
    }
    AppMethodBeat.o(186803);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adc
 * JD-Core Version:    0.7.0.1
 */