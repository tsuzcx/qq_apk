package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eic
  extends com.tencent.mm.bx.a
{
  public int HSA;
  public int HSB;
  public int HSC;
  public int HSD;
  public String HSE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HSA);
      paramVarArgs.aS(2, this.HSB);
      paramVarArgs.aS(3, this.HSC);
      paramVarArgs.aS(4, this.HSD);
      if (this.HSE != null) {
        paramVarArgs.d(5, this.HSE);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HSA) + 0 + f.a.a.b.b.a.bz(2, this.HSB) + f.a.a.b.b.a.bz(3, this.HSC) + f.a.a.b.b.a.bz(4, this.HSD);
      paramInt = i;
      if (this.HSE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HSE);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eic localeic = (eic)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localeic.HSA = locala.NPN.zc();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localeic.HSB = locala.NPN.zc();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localeic.HSC = locala.NPN.zc();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localeic.HSD = locala.NPN.zc();
        AppMethodBeat.o(153337);
        return 0;
      }
      localeic.HSE = locala.NPN.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eic
 * JD-Core Version:    0.7.0.1
 */