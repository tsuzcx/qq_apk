package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkz
  extends com.tencent.mm.bw.a
{
  public int FaA;
  public int FaB;
  public int FaC;
  public int FaD;
  public int Fax;
  public int Fay;
  public int Faz;
  public int cZY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fax);
      paramVarArgs.aR(2, this.cZY);
      paramVarArgs.aR(3, this.Fay);
      paramVarArgs.aR(4, this.Faz);
      paramVarArgs.aR(5, this.FaA);
      paramVarArgs.aR(6, this.FaB);
      paramVarArgs.aR(7, this.FaC);
      paramVarArgs.aR(8, this.FaD);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fax);
      int i = f.a.a.b.b.a.bx(2, this.cZY);
      int j = f.a.a.b.b.a.bx(3, this.Fay);
      int k = f.a.a.b.b.a.bx(4, this.Faz);
      int m = f.a.a.b.b.a.bx(5, this.FaA);
      int n = f.a.a.b.b.a.bx(6, this.FaB);
      int i1 = f.a.a.b.b.a.bx(7, this.FaC);
      int i2 = f.a.a.b.b.a.bx(8, this.FaD);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkz localbkz = (bkz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localbkz.Fax = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localbkz.cZY = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localbkz.Fay = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localbkz.Faz = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localbkz.FaA = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localbkz.FaB = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localbkz.FaC = locala.LVo.xF();
        AppMethodBeat.o(143981);
        return 0;
      }
      localbkz.FaD = locala.LVo.xF();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkz
 * JD-Core Version:    0.7.0.1
 */