package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egh
  extends com.tencent.mm.bx.a
{
  public int DKL;
  public String FxN;
  public String Gdg;
  public int GsN;
  public String HRn;
  public String HRo;
  public String HRp;
  public int HRq;
  public int dJQ;
  public String dJR;
  public String iht;
  public String msW;
  public int mta;
  public int nEf;
  public int qex;
  public int yhn;
  public int yho;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.HRn != null) {
        paramVarArgs.d(3, this.HRn);
      }
      paramVarArgs.aS(4, this.yhn);
      paramVarArgs.aS(5, this.qex);
      paramVarArgs.aS(6, this.yho);
      if (this.HRo != null) {
        paramVarArgs.d(7, this.HRo);
      }
      paramVarArgs.aS(8, this.GsN);
      if (this.FxN != null) {
        paramVarArgs.d(9, this.FxN);
      }
      if (this.HRp != null) {
        paramVarArgs.d(10, this.HRp);
      }
      paramVarArgs.aS(11, this.DKL);
      paramVarArgs.aS(12, this.HRq);
      if (this.Gdg != null) {
        paramVarArgs.d(13, this.Gdg);
      }
      if (this.msW != null) {
        paramVarArgs.d(14, this.msW);
      }
      paramVarArgs.aS(15, this.dJQ);
      if (this.dJR != null) {
        paramVarArgs.d(16, this.dJR);
      }
      paramVarArgs.aS(17, this.mta);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.HRn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HRn);
      }
      i = i + f.a.a.b.b.a.bz(4, this.yhn) + f.a.a.b.b.a.bz(5, this.qex) + f.a.a.b.b.a.bz(6, this.yho);
      paramInt = i;
      if (this.HRo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HRo);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GsN);
      paramInt = i;
      if (this.FxN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FxN);
      }
      i = paramInt;
      if (this.HRp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HRp);
      }
      i = i + f.a.a.b.b.a.bz(11, this.DKL) + f.a.a.b.b.a.bz(12, this.HRq);
      paramInt = i;
      if (this.Gdg != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Gdg);
      }
      i = paramInt;
      if (this.msW != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.msW);
      }
      i += f.a.a.b.b.a.bz(15, this.dJQ);
      paramInt = i;
      if (this.dJR != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.dJR);
      }
      i = f.a.a.b.b.a.bz(17, this.mta);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      egh localegh = (egh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localegh.nEf = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localegh.iht = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localegh.HRn = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localegh.yhn = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localegh.qex = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localegh.yho = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localegh.HRo = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localegh.GsN = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localegh.FxN = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localegh.HRp = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localegh.DKL = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localegh.HRq = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localegh.Gdg = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localegh.msW = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localegh.dJQ = locala.NPN.zc();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localegh.dJR = locala.NPN.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localegh.mta = locala.NPN.zc();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egh
 * JD-Core Version:    0.7.0.1
 */