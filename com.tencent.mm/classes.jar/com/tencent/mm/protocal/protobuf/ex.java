package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ex
  extends com.tencent.mm.bw.a
{
  public boolean DRC;
  public boolean DRD;
  public int DRE;
  public int DRF;
  public int DRG;
  public int DRH;
  public int DRI;
  public boolean DRJ;
  public boolean DRK;
  public boolean DRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.DRC);
      paramVarArgs.bl(2, this.DRD);
      paramVarArgs.aR(3, this.DRE);
      paramVarArgs.aR(4, this.DRF);
      paramVarArgs.aR(5, this.DRG);
      paramVarArgs.aR(6, this.DRH);
      paramVarArgs.aR(7, this.DRI);
      paramVarArgs.bl(8, this.DRJ);
      paramVarArgs.bl(9, this.DRK);
      paramVarArgs.bl(10, this.DRL);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.bx(3, this.DRE);
      int k = f.a.a.b.b.a.bx(4, this.DRF);
      int m = f.a.a.b.b.a.bx(5, this.DRG);
      int n = f.a.a.b.b.a.bx(6, this.DRH);
      int i1 = f.a.a.b.b.a.bx(7, this.DRI);
      int i2 = f.a.a.b.b.a.fK(8);
      int i3 = f.a.a.b.b.a.fK(9);
      int i4 = f.a.a.b.b.a.fK(10);
      AppMethodBeat.o(124386);
      return paramInt + 1 + 0 + (i + 1) + j + k + m + n + i1 + (i2 + 1) + (i3 + 1) + (i4 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ex localex = (ex)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localex.DRC = locala.LVo.fZX();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localex.DRD = locala.LVo.fZX();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localex.DRE = locala.LVo.xF();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localex.DRF = locala.LVo.xF();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localex.DRG = locala.LVo.xF();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localex.DRH = locala.LVo.xF();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localex.DRI = locala.LVo.xF();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localex.DRJ = locala.LVo.fZX();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localex.DRK = locala.LVo.fZX();
        AppMethodBeat.o(124386);
        return 0;
      }
      localex.DRL = locala.LVo.fZX();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ex
 * JD-Core Version:    0.7.0.1
 */