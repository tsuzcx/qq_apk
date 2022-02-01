package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvh
  extends com.tencent.mm.bx.a
{
  public int DSA;
  public String DSB;
  public String DSC;
  public String DSD;
  public int DSE;
  public int DSF;
  public int DSG;
  public long DSH;
  public String DSy;
  public String DSz;
  public String bjG;
  public String dqA;
  public String nvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bjG != null) {
        paramVarArgs.d(1, this.bjG);
      }
      if (this.DSy != null) {
        paramVarArgs.d(2, this.DSy);
      }
      if (this.DSz != null) {
        paramVarArgs.d(3, this.DSz);
      }
      paramVarArgs.aR(4, this.DSA);
      if (this.dqA != null) {
        paramVarArgs.d(5, this.dqA);
      }
      if (this.DSB != null) {
        paramVarArgs.d(6, this.DSB);
      }
      if (this.DSC != null) {
        paramVarArgs.d(7, this.DSC);
      }
      if (this.nvx != null) {
        paramVarArgs.d(8, this.nvx);
      }
      if (this.DSD != null) {
        paramVarArgs.d(9, this.DSD);
      }
      paramVarArgs.aR(10, this.DSE);
      paramVarArgs.aR(11, this.DSF);
      paramVarArgs.aR(12, this.DSG);
      paramVarArgs.aG(13, this.DSH);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bjG == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.b.b.a.e(1, this.bjG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DSy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DSy);
      }
      i = paramInt;
      if (this.DSz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSz);
      }
      i += f.a.a.b.b.a.bA(4, this.DSA);
      paramInt = i;
      if (this.dqA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dqA);
      }
      i = paramInt;
      if (this.DSB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DSB);
      }
      paramInt = i;
      if (this.DSC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DSC);
      }
      i = paramInt;
      if (this.nvx != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nvx);
      }
      paramInt = i;
      if (this.DSD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DSD);
      }
      i = f.a.a.b.b.a.bA(10, this.DSE);
      int j = f.a.a.b.b.a.bA(11, this.DSF);
      int k = f.a.a.b.b.a.bA(12, this.DSG);
      int m = f.a.a.b.b.a.q(13, this.DSH);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvh localbvh = (bvh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localbvh.bjG = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localbvh.DSy = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localbvh.DSz = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localbvh.DSA = locala.KhF.xS();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localbvh.dqA = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localbvh.DSB = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localbvh.DSC = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localbvh.nvx = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localbvh.DSD = locala.KhF.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localbvh.DSE = locala.KhF.xS();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localbvh.DSF = locala.KhF.xS();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localbvh.DSG = locala.KhF.xS();
          AppMethodBeat.o(152632);
          return 0;
        }
        localbvh.DSH = locala.KhF.xT();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvh
 * JD-Core Version:    0.7.0.1
 */