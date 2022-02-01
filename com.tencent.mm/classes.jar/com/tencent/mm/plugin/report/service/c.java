package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class c
  extends com.tencent.mm.bx.a
{
  public int fVA;
  public int mBH;
  public boolean vJB;
  public String vJI;
  public boolean vJJ;
  public boolean vJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vJI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.fVA);
      if (this.vJI != null) {
        paramVarArgs.d(2, this.vJI);
      }
      paramVarArgs.bg(3, this.vJJ);
      paramVarArgs.bg(4, this.vJB);
      paramVarArgs.aR(5, this.mBH);
      paramVarArgs.bg(6, this.vJK);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.fVA) + 0;
      paramInt = i;
      if (this.vJI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vJI);
      }
      i = f.a.a.b.b.a.fY(3);
      int j = f.a.a.b.b.a.fY(4);
      int k = f.a.a.b.b.a.bA(5, this.mBH);
      int m = f.a.a.b.b.a.fY(6);
      AppMethodBeat.o(143831);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.vJI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143831);
        return -1;
      case 1: 
        localc.fVA = locala.KhF.xS();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        localc.vJI = locala.KhF.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        localc.vJJ = locala.KhF.fHu();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        localc.vJB = locala.KhF.fHu();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        localc.mBH = locala.KhF.xS();
        AppMethodBeat.o(143831);
        return 0;
      }
      localc.vJK = locala.KhF.fHu();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */