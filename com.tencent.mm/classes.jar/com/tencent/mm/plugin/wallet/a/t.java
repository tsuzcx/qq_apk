package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bw.a
{
  public String BgF;
  public String BgG;
  public String BgH;
  public int BhA;
  public int BhB;
  public long BhC;
  public String BhD;
  public String BhE;
  public String BhF;
  public double BhG;
  public double BhH;
  public int BhI;
  public String BhJ;
  public String BhK;
  public LinkedList<b> BhL;
  public String vxj;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.BhL = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.BhA);
      paramVarArgs.aR(2, this.BhB);
      paramVarArgs.aO(3, this.BhC);
      if (this.BhD != null) {
        paramVarArgs.d(4, this.BhD);
      }
      if (this.BgF != null) {
        paramVarArgs.d(5, this.BgF);
      }
      if (this.BhE != null) {
        paramVarArgs.d(6, this.BhE);
      }
      if (this.BhF != null) {
        paramVarArgs.d(7, this.BhF);
      }
      if (this.BgG != null) {
        paramVarArgs.d(8, this.BgG);
      }
      if (this.BgH != null) {
        paramVarArgs.d(9, this.BgH);
      }
      paramVarArgs.e(10, this.BhG);
      paramVarArgs.e(11, this.BhH);
      paramVarArgs.aR(12, this.BhI);
      if (this.BhJ != null) {
        paramVarArgs.d(13, this.BhJ);
      }
      if (this.vxj != null) {
        paramVarArgs.d(14, this.vxj);
      }
      if (this.BhK != null) {
        paramVarArgs.d(16, this.BhK);
      }
      paramVarArgs.e(17, 6, this.BhL);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.BhA) + 0 + f.a.a.b.b.a.bx(2, this.BhB) + f.a.a.b.b.a.p(3, this.BhC);
      paramInt = i;
      if (this.BhD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BhD);
      }
      i = paramInt;
      if (this.BgF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.BgF);
      }
      paramInt = i;
      if (this.BhE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.BhE);
      }
      i = paramInt;
      if (this.BhF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.BhF);
      }
      paramInt = i;
      if (this.BgG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.BgG);
      }
      i = paramInt;
      if (this.BgH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.BgH);
      }
      i = i + (f.a.a.b.b.a.fK(10) + 8) + (f.a.a.b.b.a.fK(11) + 8) + f.a.a.b.b.a.bx(12, this.BhI);
      paramInt = i;
      if (this.BhJ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.BhJ);
      }
      i = paramInt;
      if (this.vxj != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.vxj);
      }
      paramInt = i;
      if (this.BhK != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.BhK);
      }
      i = f.a.a.a.c(17, 6, this.BhL);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BhL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      t localt = (t)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        AppMethodBeat.o(91305);
        return -1;
      case 1: 
        localt.BhA = locala.LVo.xF();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.BhB = locala.LVo.xF();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.BhC = locala.LVo.xG();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.BhD = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.BgF = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.BhE = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.BhF = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.BgG = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.BgH = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.BhG = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.BhH = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.BhI = locala.LVo.xF();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.BhJ = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.vxj = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.BhK = locala.LVo.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.BhL.add(locala.LVo.gfk());
      AppMethodBeat.o(91305);
      return 0;
    }
    AppMethodBeat.o(91305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.t
 * JD-Core Version:    0.7.0.1
 */