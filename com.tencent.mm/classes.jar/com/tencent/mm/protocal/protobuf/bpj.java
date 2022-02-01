package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpj
  extends com.tencent.mm.bx.a
{
  public int GJW;
  public int GJX;
  public int GJY;
  public int GJZ;
  public int GKa;
  public int GKb;
  public int GKc;
  public int dlq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GJW);
      paramVarArgs.aS(2, this.dlq);
      paramVarArgs.aS(3, this.GJX);
      paramVarArgs.aS(4, this.GJY);
      paramVarArgs.aS(5, this.GJZ);
      paramVarArgs.aS(6, this.GKa);
      paramVarArgs.aS(7, this.GKb);
      paramVarArgs.aS(8, this.GKc);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GJW);
      int i = f.a.a.b.b.a.bz(2, this.dlq);
      int j = f.a.a.b.b.a.bz(3, this.GJX);
      int k = f.a.a.b.b.a.bz(4, this.GJY);
      int m = f.a.a.b.b.a.bz(5, this.GJZ);
      int n = f.a.a.b.b.a.bz(6, this.GKa);
      int i1 = f.a.a.b.b.a.bz(7, this.GKb);
      int i2 = f.a.a.b.b.a.bz(8, this.GKc);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpj localbpj = (bpj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localbpj.GJW = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localbpj.dlq = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localbpj.GJX = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localbpj.GJY = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localbpj.GJZ = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localbpj.GKa = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localbpj.GKb = locala.NPN.zc();
        AppMethodBeat.o(143981);
        return 0;
      }
      localbpj.GKc = locala.NPN.zc();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpj
 * JD-Core Version:    0.7.0.1
 */