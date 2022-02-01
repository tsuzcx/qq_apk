package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvh
  extends com.tencent.mm.bx.a
{
  public String FVu;
  public String Hnp;
  public long Hnq;
  public int Hnr;
  public int Hns;
  public int Hnt;
  public int Hnu;
  public int Hnv;
  public int Hnw;
  public float Hnx;
  public float Hny;
  public float Hnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVu != null) {
        paramVarArgs.d(1, this.FVu);
      }
      if (this.Hnp != null) {
        paramVarArgs.d(2, this.Hnp);
      }
      paramVarArgs.aY(3, this.Hnq);
      paramVarArgs.aS(4, this.Hnr);
      paramVarArgs.aS(5, this.Hns);
      paramVarArgs.aS(6, this.Hnt);
      paramVarArgs.aS(7, this.Hnu);
      paramVarArgs.aS(8, this.Hnv);
      paramVarArgs.aS(9, this.Hnw);
      paramVarArgs.z(10, this.Hnx);
      paramVarArgs.z(11, this.Hny);
      paramVarArgs.z(12, this.Hnz);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVu == null) {
        break label743;
      }
    }
    label743:
    for (paramInt = f.a.a.b.b.a.e(1, this.FVu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hnp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hnp);
      }
      paramInt = f.a.a.b.b.a.p(3, this.Hnq);
      int j = f.a.a.b.b.a.bz(4, this.Hnr);
      int k = f.a.a.b.b.a.bz(5, this.Hns);
      int m = f.a.a.b.b.a.bz(6, this.Hnt);
      int n = f.a.a.b.b.a.bz(7, this.Hnu);
      int i1 = f.a.a.b.b.a.bz(8, this.Hnv);
      int i2 = f.a.a.b.b.a.bz(9, this.Hnw);
      int i3 = f.a.a.b.b.a.alU(10);
      int i4 = f.a.a.b.b.a.alU(11);
      int i5 = f.a.a.b.b.a.alU(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvh localcvh = (cvh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localcvh.FVu = locala.NPN.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localcvh.Hnp = locala.NPN.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localcvh.Hnq = locala.NPN.zd();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localcvh.Hnr = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localcvh.Hns = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localcvh.Hnt = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localcvh.Hnu = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localcvh.Hnv = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localcvh.Hnw = locala.NPN.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localcvh.Hnx = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localcvh.Hny = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(87875);
          return 0;
        }
        localcvh.Hnz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvh
 * JD-Core Version:    0.7.0.1
 */