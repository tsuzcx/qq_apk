package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ame
  extends com.tencent.mm.bx.a
{
  public int GlJ;
  public int GlK;
  public int GlL;
  public int GlM;
  public int GlN;
  public int GlO;
  public int GlP;
  public int count;
  public int ijP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.count);
      paramVarArgs.aS(2, this.GlJ);
      paramVarArgs.aS(3, this.GlK);
      paramVarArgs.aS(4, this.GlL);
      paramVarArgs.aS(5, this.GlM);
      paramVarArgs.aS(7, this.GlN);
      paramVarArgs.aS(8, this.GlO);
      paramVarArgs.aS(9, this.ijP);
      paramVarArgs.aS(10, this.GlP);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.count);
      int i = f.a.a.b.b.a.bz(2, this.GlJ);
      int j = f.a.a.b.b.a.bz(3, this.GlK);
      int k = f.a.a.b.b.a.bz(4, this.GlL);
      int m = f.a.a.b.b.a.bz(5, this.GlM);
      int n = f.a.a.b.b.a.bz(7, this.GlN);
      int i1 = f.a.a.b.b.a.bz(8, this.GlO);
      int i2 = f.a.a.b.b.a.bz(9, this.ijP);
      int i3 = f.a.a.b.b.a.bz(10, this.GlP);
      AppMethodBeat.o(168947);
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
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ame localame = (ame)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localame.count = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localame.GlJ = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localame.GlK = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localame.GlL = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localame.GlM = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localame.GlN = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localame.GlO = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localame.ijP = locala.NPN.zc();
        AppMethodBeat.o(168947);
        return 0;
      }
      localame.GlP = locala.NPN.zc();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ame
 * JD-Core Version:    0.7.0.1
 */