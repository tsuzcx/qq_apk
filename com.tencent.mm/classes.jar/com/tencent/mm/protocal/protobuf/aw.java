package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bw.a
{
  public int FKD;
  public String FKE;
  public String FKF;
  public int FKG;
  public int FKH;
  public String FKI;
  public int FKJ;
  public String FKK;
  public String FKL;
  public int FKM;
  public String FKN;
  public String jga;
  public String nIJ;
  public String nJO;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      paramVarArgs.aS(3, this.FKD);
      if (this.FKE != null) {
        paramVarArgs.d(4, this.FKE);
      }
      if (this.FKF != null) {
        paramVarArgs.d(5, this.FKF);
      }
      if (this.jga != null) {
        paramVarArgs.d(6, this.jga);
      }
      paramVarArgs.aS(8, this.nJb);
      paramVarArgs.aS(9, this.FKG);
      paramVarArgs.aS(10, this.FKH);
      if (this.FKI != null) {
        paramVarArgs.d(11, this.FKI);
      }
      paramVarArgs.aS(12, this.FKJ);
      if (this.FKK != null) {
        paramVarArgs.d(13, this.FKK);
      }
      if (this.FKL != null) {
        paramVarArgs.d(14, this.FKL);
      }
      paramVarArgs.aS(15, this.FKM);
      if (this.FKN != null) {
        paramVarArgs.d(16, this.FKN);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nJO);
      }
      i += f.a.a.b.b.a.bz(3, this.FKD);
      paramInt = i;
      if (this.FKE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FKE);
      }
      i = paramInt;
      if (this.FKF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FKF);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jga);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.nJb) + f.a.a.b.b.a.bz(9, this.FKG) + f.a.a.b.b.a.bz(10, this.FKH);
      paramInt = i;
      if (this.FKI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FKI);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FKJ);
      paramInt = i;
      if (this.FKK != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FKK);
      }
      i = paramInt;
      if (this.FKL != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FKL);
      }
      i += f.a.a.b.b.a.bz(15, this.FKM);
      paramInt = i;
      if (this.FKN != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FKN);
      }
      AppMethodBeat.o(133142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localaw.nIJ = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localaw.nJO = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localaw.FKD = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localaw.FKE = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localaw.FKF = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localaw.jga = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localaw.nJb = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localaw.FKG = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localaw.FKH = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localaw.FKI = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localaw.FKJ = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localaw.FKK = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localaw.FKL = locala.OmT.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localaw.FKM = locala.OmT.zc();
          AppMethodBeat.o(133142);
          return 0;
        }
        localaw.FKN = locala.OmT.readString();
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */