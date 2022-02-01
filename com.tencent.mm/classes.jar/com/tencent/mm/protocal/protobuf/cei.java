package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cei
  extends com.tencent.mm.bw.a
{
  public String GaH;
  public int Hrb;
  public int Hrc;
  public String Hrd;
  public int Hre;
  public int Hrf;
  public long Hrg;
  public String hCp;
  public int type;
  public int uoI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GaH != null) {
        paramVarArgs.d(1, this.GaH);
      }
      paramVarArgs.aS(2, this.Hrb);
      paramVarArgs.aS(3, this.uoI);
      paramVarArgs.aS(4, this.Hrc);
      paramVarArgs.aS(5, this.type);
      if (this.hCp != null) {
        paramVarArgs.d(6, this.hCp);
      }
      if (this.Hrd != null) {
        paramVarArgs.d(7, this.Hrd);
      }
      paramVarArgs.aS(8, this.Hre);
      paramVarArgs.aS(9, this.Hrf);
      paramVarArgs.aZ(10, this.Hrg);
      AppMethodBeat.o(6412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaH == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.b.b.a.e(1, this.GaH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hrb) + f.a.a.b.b.a.bz(3, this.uoI) + f.a.a.b.b.a.bz(4, this.Hrc) + f.a.a.b.b.a.bz(5, this.type);
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hCp);
      }
      i = paramInt;
      if (this.Hrd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hrd);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Hre);
      int j = f.a.a.b.b.a.bz(9, this.Hrf);
      int k = f.a.a.b.b.a.p(10, this.Hrg);
      AppMethodBeat.o(6412);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6412);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cei localcei = (cei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6412);
          return -1;
        case 1: 
          localcei.GaH = locala.OmT.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 2: 
          localcei.Hrb = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        case 3: 
          localcei.uoI = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        case 4: 
          localcei.Hrc = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        case 5: 
          localcei.type = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        case 6: 
          localcei.hCp = locala.OmT.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 7: 
          localcei.Hrd = locala.OmT.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 8: 
          localcei.Hre = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        case 9: 
          localcei.Hrf = locala.OmT.zc();
          AppMethodBeat.o(6412);
          return 0;
        }
        localcei.Hrg = locala.OmT.zd();
        AppMethodBeat.o(6412);
        return 0;
      }
      AppMethodBeat.o(6412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cei
 * JD-Core Version:    0.7.0.1
 */