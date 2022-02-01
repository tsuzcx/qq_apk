package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ys
  extends com.tencent.mm.bw.a
{
  public int EsA;
  public int Esx;
  public int Esy;
  public int Esz;
  public int otQ;
  public int otR;
  public int otS;
  public int otT;
  public int otU;
  public int otV;
  public int otW;
  public int otX;
  public int otY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.otQ);
      paramVarArgs.aR(2, this.Esx);
      paramVarArgs.aR(3, this.otR);
      paramVarArgs.aR(4, this.otS);
      paramVarArgs.aR(5, this.otT);
      paramVarArgs.aR(6, this.Esy);
      paramVarArgs.aR(7, this.otU);
      paramVarArgs.aR(8, this.otV);
      paramVarArgs.aR(9, this.Esz);
      paramVarArgs.aR(10, this.EsA);
      paramVarArgs.aR(11, this.otW);
      paramVarArgs.aR(12, this.otX);
      paramVarArgs.aR(13, this.otY);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.otQ);
      int i = f.a.a.b.b.a.bx(2, this.Esx);
      int j = f.a.a.b.b.a.bx(3, this.otR);
      int k = f.a.a.b.b.a.bx(4, this.otS);
      int m = f.a.a.b.b.a.bx(5, this.otT);
      int n = f.a.a.b.b.a.bx(6, this.Esy);
      int i1 = f.a.a.b.b.a.bx(7, this.otU);
      int i2 = f.a.a.b.b.a.bx(8, this.otV);
      int i3 = f.a.a.b.b.a.bx(9, this.Esz);
      int i4 = f.a.a.b.b.a.bx(10, this.EsA);
      int i5 = f.a.a.b.b.a.bx(11, this.otW);
      int i6 = f.a.a.b.b.a.bx(12, this.otX);
      int i7 = f.a.a.b.b.a.bx(13, this.otY);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ys localys = (ys)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localys.otQ = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localys.Esx = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localys.otR = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localys.otS = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localys.otT = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localys.Esy = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localys.otU = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localys.otV = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localys.Esz = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localys.EsA = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localys.otW = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localys.otX = locala.LVo.xF();
        AppMethodBeat.o(90959);
        return 0;
      }
      localys.otY = locala.LVo.xF();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ys
 * JD-Core Version:    0.7.0.1
 */