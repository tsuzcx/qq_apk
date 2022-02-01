package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwb
  extends com.tencent.mm.bw.a
{
  public String GnT;
  public String HGP;
  public long HGQ;
  public int HGR;
  public int HGS;
  public int HGT;
  public int HGU;
  public int HGV;
  public int HGW;
  public float HGX;
  public float HGY;
  public float HGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GnT != null) {
        paramVarArgs.d(1, this.GnT);
      }
      if (this.HGP != null) {
        paramVarArgs.d(2, this.HGP);
      }
      paramVarArgs.aZ(3, this.HGQ);
      paramVarArgs.aS(4, this.HGR);
      paramVarArgs.aS(5, this.HGS);
      paramVarArgs.aS(6, this.HGT);
      paramVarArgs.aS(7, this.HGU);
      paramVarArgs.aS(8, this.HGV);
      paramVarArgs.aS(9, this.HGW);
      paramVarArgs.y(10, this.HGX);
      paramVarArgs.y(11, this.HGY);
      paramVarArgs.y(12, this.HGZ);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GnT == null) {
        break label743;
      }
    }
    label743:
    for (paramInt = f.a.a.b.b.a.e(1, this.GnT) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HGP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HGP);
      }
      paramInt = f.a.a.b.b.a.p(3, this.HGQ);
      int j = f.a.a.b.b.a.bz(4, this.HGR);
      int k = f.a.a.b.b.a.bz(5, this.HGS);
      int m = f.a.a.b.b.a.bz(6, this.HGT);
      int n = f.a.a.b.b.a.bz(7, this.HGU);
      int i1 = f.a.a.b.b.a.bz(8, this.HGV);
      int i2 = f.a.a.b.b.a.bz(9, this.HGW);
      int i3 = f.a.a.b.b.a.amE(10);
      int i4 = f.a.a.b.b.a.amE(11);
      int i5 = f.a.a.b.b.a.amE(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwb localcwb = (cwb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localcwb.GnT = locala.OmT.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localcwb.HGP = locala.OmT.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localcwb.HGQ = locala.OmT.zd();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localcwb.HGR = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localcwb.HGS = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localcwb.HGT = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localcwb.HGU = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localcwb.HGV = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localcwb.HGW = locala.OmT.zc();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localcwb.HGX = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localcwb.HGY = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(87875);
          return 0;
        }
        localcwb.HGZ = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwb
 * JD-Core Version:    0.7.0.1
 */