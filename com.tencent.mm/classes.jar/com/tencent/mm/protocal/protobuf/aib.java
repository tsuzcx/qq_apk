package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aib
  extends com.tencent.mm.bw.a
{
  public int EBY;
  public int EBZ;
  public int ECa;
  public int ECb;
  public int ECc;
  public int ECd;
  public int ECe;
  public int ECf;
  public int ECg;
  public int ECh;
  public int ECi;
  public int ECj;
  public int ECk;
  public int fileCount;
  public int sKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EBY);
      paramVarArgs.aR(2, this.EBZ);
      paramVarArgs.aR(3, this.ECa);
      paramVarArgs.aR(4, this.sKb);
      paramVarArgs.aR(5, this.ECb);
      paramVarArgs.aR(6, this.ECc);
      paramVarArgs.aR(7, this.ECd);
      paramVarArgs.aR(8, this.fileCount);
      paramVarArgs.aR(9, this.ECe);
      paramVarArgs.aR(10, this.ECf);
      paramVarArgs.aR(11, this.ECg);
      paramVarArgs.aR(12, this.ECh);
      paramVarArgs.aR(13, this.ECi);
      paramVarArgs.aR(14, this.ECj);
      paramVarArgs.aR(15, this.ECk);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EBY);
      int i = f.a.a.b.b.a.bx(2, this.EBZ);
      int j = f.a.a.b.b.a.bx(3, this.ECa);
      int k = f.a.a.b.b.a.bx(4, this.sKb);
      int m = f.a.a.b.b.a.bx(5, this.ECb);
      int n = f.a.a.b.b.a.bx(6, this.ECc);
      int i1 = f.a.a.b.b.a.bx(7, this.ECd);
      int i2 = f.a.a.b.b.a.bx(8, this.fileCount);
      int i3 = f.a.a.b.b.a.bx(9, this.ECe);
      int i4 = f.a.a.b.b.a.bx(10, this.ECf);
      int i5 = f.a.a.b.b.a.bx(11, this.ECg);
      int i6 = f.a.a.b.b.a.bx(12, this.ECh);
      int i7 = f.a.a.b.b.a.bx(13, this.ECi);
      int i8 = f.a.a.b.b.a.bx(14, this.ECj);
      int i9 = f.a.a.b.b.a.bx(15, this.ECk);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aib localaib = (aib)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localaib.EBY = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localaib.EBZ = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localaib.ECa = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localaib.sKb = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localaib.ECb = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localaib.ECc = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localaib.ECd = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localaib.fileCount = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localaib.ECe = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localaib.ECf = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localaib.ECg = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localaib.ECh = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localaib.ECi = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localaib.ECj = locala.LVo.xF();
        AppMethodBeat.o(127492);
        return 0;
      }
      localaib.ECk = locala.LVo.xF();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aib
 * JD-Core Version:    0.7.0.1
 */