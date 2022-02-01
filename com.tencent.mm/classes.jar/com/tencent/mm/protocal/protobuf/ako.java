package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ako
  extends com.tencent.mm.bx.a
{
  public int Dmf;
  public int Dmg;
  public float Dmh;
  public int Dmi;
  public int Lya;
  public int wAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dmf);
      paramVarArgs.aR(2, this.wAk);
      paramVarArgs.aR(3, this.Dmg);
      paramVarArgs.x(4, this.Dmh);
      paramVarArgs.aR(5, this.Dmi);
      paramVarArgs.aR(6, this.Lya);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Dmf);
      int i = f.a.a.b.b.a.bA(2, this.wAk);
      int j = f.a.a.b.b.a.bA(3, this.Dmg);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.bA(5, this.Dmi);
      int n = f.a.a.b.b.a.bA(6, this.Lya);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + (k + 4) + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ako localako = (ako)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localako.Dmf = locala.KhF.xS();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localako.wAk = locala.KhF.xS();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localako.Dmg = locala.KhF.xS();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localako.Dmh = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localako.Dmi = locala.KhF.xS();
        AppMethodBeat.o(184205);
        return 0;
      }
      localako.Lya = locala.KhF.xS();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ako
 * JD-Core Version:    0.7.0.1
 */