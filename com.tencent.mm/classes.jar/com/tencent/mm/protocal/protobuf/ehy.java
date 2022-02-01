package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehy
  extends com.tencent.mm.bw.a
{
  public int EcJ;
  public String FQl;
  public int GMl;
  public String GvN;
  public String Ilu;
  public String Ilv;
  public String Ilw;
  public int Ilx;
  public int dLf;
  public String dLg;
  public String ikm;
  public String mxT;
  public int mxX;
  public int nJA;
  public int qlc;
  public int yxe;
  public int yxf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.Ilu != null) {
        paramVarArgs.d(3, this.Ilu);
      }
      paramVarArgs.aS(4, this.yxe);
      paramVarArgs.aS(5, this.qlc);
      paramVarArgs.aS(6, this.yxf);
      if (this.Ilv != null) {
        paramVarArgs.d(7, this.Ilv);
      }
      paramVarArgs.aS(8, this.GMl);
      if (this.FQl != null) {
        paramVarArgs.d(9, this.FQl);
      }
      if (this.Ilw != null) {
        paramVarArgs.d(10, this.Ilw);
      }
      paramVarArgs.aS(11, this.EcJ);
      paramVarArgs.aS(12, this.Ilx);
      if (this.GvN != null) {
        paramVarArgs.d(13, this.GvN);
      }
      if (this.mxT != null) {
        paramVarArgs.d(14, this.mxT);
      }
      paramVarArgs.aS(15, this.dLf);
      if (this.dLg != null) {
        paramVarArgs.d(16, this.dLg);
      }
      paramVarArgs.aS(17, this.mxX);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.Ilu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ilu);
      }
      i = i + f.a.a.b.b.a.bz(4, this.yxe) + f.a.a.b.b.a.bz(5, this.qlc) + f.a.a.b.b.a.bz(6, this.yxf);
      paramInt = i;
      if (this.Ilv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ilv);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GMl);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FQl);
      }
      i = paramInt;
      if (this.Ilw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ilw);
      }
      i = i + f.a.a.b.b.a.bz(11, this.EcJ) + f.a.a.b.b.a.bz(12, this.Ilx);
      paramInt = i;
      if (this.GvN != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GvN);
      }
      i = paramInt;
      if (this.mxT != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.mxT);
      }
      i += f.a.a.b.b.a.bz(15, this.dLf);
      paramInt = i;
      if (this.dLg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.dLg);
      }
      i = f.a.a.b.b.a.bz(17, this.mxX);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehy localehy = (ehy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localehy.nJA = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localehy.ikm = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localehy.Ilu = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localehy.yxe = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localehy.qlc = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localehy.yxf = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localehy.Ilv = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localehy.GMl = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localehy.FQl = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localehy.Ilw = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localehy.EcJ = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localehy.Ilx = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localehy.GvN = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localehy.mxT = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localehy.dLf = locala.OmT.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localehy.dLg = locala.OmT.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localehy.mxX = locala.OmT.zc();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehy
 * JD-Core Version:    0.7.0.1
 */