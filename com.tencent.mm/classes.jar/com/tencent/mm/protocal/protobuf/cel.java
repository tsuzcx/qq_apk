package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cel
  extends com.tencent.mm.bw.a
{
  public String GaH;
  public int Hrb;
  public int Hrc;
  public String Hrd;
  public int Hre;
  public int Hrf;
  public long Hrg;
  public int Hrk;
  public String hCp;
  public int oDa;
  public int type;
  public int uoI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GaH != null) {
        paramVarArgs.d(1, this.GaH);
      }
      paramVarArgs.aS(2, this.Hrb);
      paramVarArgs.aS(3, this.uoI);
      paramVarArgs.aS(4, this.Hrc);
      paramVarArgs.aS(5, this.oDa);
      paramVarArgs.aS(6, this.type);
      if (this.hCp != null) {
        paramVarArgs.d(7, this.hCp);
      }
      if (this.Hrd != null) {
        paramVarArgs.d(8, this.Hrd);
      }
      paramVarArgs.aS(9, this.Hre);
      paramVarArgs.aS(10, this.Hrf);
      paramVarArgs.aS(11, this.Hrk);
      paramVarArgs.aZ(12, this.Hrg);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaH == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = f.a.a.b.b.a.e(1, this.GaH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hrb) + f.a.a.b.b.a.bz(3, this.uoI) + f.a.a.b.b.a.bz(4, this.Hrc) + f.a.a.b.b.a.bz(5, this.oDa) + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hCp);
      }
      i = paramInt;
      if (this.Hrd != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hrd);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.Hre);
      int j = f.a.a.b.b.a.bz(10, this.Hrf);
      int k = f.a.a.b.b.a.bz(11, this.Hrk);
      int m = f.a.a.b.b.a.p(12, this.Hrg);
      AppMethodBeat.o(6416);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cel localcel = (cel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localcel.GaH = locala.OmT.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localcel.Hrb = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localcel.uoI = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localcel.Hrc = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localcel.oDa = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localcel.type = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localcel.hCp = locala.OmT.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localcel.Hrd = locala.OmT.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 9: 
          localcel.Hre = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 10: 
          localcel.Hrf = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 11: 
          localcel.Hrk = locala.OmT.zc();
          AppMethodBeat.o(6416);
          return 0;
        }
        localcel.Hrg = locala.OmT.zd();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cel
 * JD-Core Version:    0.7.0.1
 */