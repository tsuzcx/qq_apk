package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diq
  extends com.tencent.mm.bw.a
{
  public int GqB;
  public int Gxq;
  public int HPZ;
  public int HQa;
  public int HQb;
  public int HQc;
  public int HQd;
  public LinkedList<Integer> HQe;
  public int HQf;
  public int HQg;
  public LinkedList<Integer> HQh;
  public int HQi;
  public int HQj;
  
  public diq()
  {
    AppMethodBeat.i(115853);
    this.HQe = new LinkedList();
    this.HQh = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gxq);
      paramVarArgs.aS(2, this.HPZ);
      paramVarArgs.aS(3, this.GqB);
      paramVarArgs.aS(4, this.HQa);
      paramVarArgs.aS(5, this.HQb);
      paramVarArgs.aS(6, this.HQc);
      paramVarArgs.aS(7, this.HQd);
      paramVarArgs.e(8, 2, this.HQe);
      paramVarArgs.aS(9, this.HQf);
      paramVarArgs.aS(10, this.HQg);
      paramVarArgs.e(11, 2, this.HQh);
      paramVarArgs.aS(12, this.HQi);
      paramVarArgs.aS(13, this.HQj);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gxq);
      int i = f.a.a.b.b.a.bz(2, this.HPZ);
      int j = f.a.a.b.b.a.bz(3, this.GqB);
      int k = f.a.a.b.b.a.bz(4, this.HQa);
      int m = f.a.a.b.b.a.bz(5, this.HQb);
      int n = f.a.a.b.b.a.bz(6, this.HQc);
      int i1 = f.a.a.b.b.a.bz(7, this.HQd);
      int i2 = f.a.a.a.c(8, 2, this.HQe);
      int i3 = f.a.a.b.b.a.bz(9, this.HQf);
      int i4 = f.a.a.b.b.a.bz(10, this.HQg);
      int i5 = f.a.a.a.c(11, 2, this.HQh);
      int i6 = f.a.a.b.b.a.bz(12, this.HQi);
      int i7 = f.a.a.b.b.a.bz(13, this.HQj);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HQe.clear();
      this.HQh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      diq localdiq = (diq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localdiq.Gxq = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localdiq.HPZ = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localdiq.GqB = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localdiq.HQa = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localdiq.HQb = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localdiq.HQc = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localdiq.HQd = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localdiq.HQe.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localdiq.HQf = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localdiq.HQg = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localdiq.HQh.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localdiq.HQi = locala.OmT.zc();
        AppMethodBeat.o(115854);
        return 0;
      }
      localdiq.HQj = locala.OmT.zc();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diq
 * JD-Core Version:    0.7.0.1
 */