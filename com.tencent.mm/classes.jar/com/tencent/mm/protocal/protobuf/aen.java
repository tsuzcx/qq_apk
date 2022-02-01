package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aen
  extends com.tencent.mm.bx.a
{
  public int FZK;
  public int Gct;
  public int Gcu;
  public int Gcv;
  public int Gcw;
  public int Gcx;
  public int Gcy;
  public int channels;
  public int oXp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gct);
      paramVarArgs.aS(2, this.Gcu);
      paramVarArgs.aS(3, this.channels);
      paramVarArgs.aS(4, this.Gcv);
      paramVarArgs.aS(5, this.FZK);
      paramVarArgs.aS(6, this.oXp);
      paramVarArgs.aS(7, this.Gcw);
      paramVarArgs.aS(8, this.Gcx);
      paramVarArgs.aS(9, this.Gcy);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gct);
      int i = f.a.a.b.b.a.bz(2, this.Gcu);
      int j = f.a.a.b.b.a.bz(3, this.channels);
      int k = f.a.a.b.b.a.bz(4, this.Gcv);
      int m = f.a.a.b.b.a.bz(5, this.FZK);
      int n = f.a.a.b.b.a.bz(6, this.oXp);
      int i1 = f.a.a.b.b.a.bz(7, this.Gcw);
      int i2 = f.a.a.b.b.a.bz(8, this.Gcx);
      int i3 = f.a.a.b.b.a.bz(9, this.Gcy);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aen localaen = (aen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localaen.Gct = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localaen.Gcu = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localaen.channels = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localaen.Gcv = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localaen.FZK = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localaen.oXp = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localaen.Gcw = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localaen.Gcx = locala.NPN.zc();
        AppMethodBeat.o(90964);
        return 0;
      }
      localaen.Gcy = locala.NPN.zc();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aen
 * JD-Core Version:    0.7.0.1
 */