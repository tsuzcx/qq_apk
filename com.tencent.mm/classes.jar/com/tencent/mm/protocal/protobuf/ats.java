package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ats
  extends com.tencent.mm.bx.a
{
  public String FDD;
  public String FXg;
  public int FqJ;
  public String FuU;
  public String GrK;
  public String GrL;
  public String GrM;
  public String nDo;
  public String nEt;
  public String ufR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32218);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuU != null) {
        paramVarArgs.d(1, this.FuU);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      if (this.ufR != null) {
        paramVarArgs.d(4, this.ufR);
      }
      if (this.GrK != null) {
        paramVarArgs.d(5, this.GrK);
      }
      if (this.GrL != null) {
        paramVarArgs.d(6, this.GrL);
      }
      if (this.FDD != null) {
        paramVarArgs.d(7, this.FDD);
      }
      if (this.FXg != null) {
        paramVarArgs.d(8, this.FXg);
      }
      if (this.GrM != null) {
        paramVarArgs.d(9, this.GrM);
      }
      paramVarArgs.aS(10, this.FqJ);
      AppMethodBeat.o(32218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuU == null) {
        break label766;
      }
    }
    label766:
    for (int i = f.a.a.b.b.a.e(1, this.FuU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      paramInt = i;
      if (this.ufR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufR);
      }
      i = paramInt;
      if (this.GrK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GrK);
      }
      paramInt = i;
      if (this.GrL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GrL);
      }
      i = paramInt;
      if (this.FDD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FDD);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FXg);
      }
      i = paramInt;
      if (this.GrM != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GrM);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FqJ);
      AppMethodBeat.o(32218);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32218);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ats localats = (ats)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32218);
          return -1;
        case 1: 
          localats.FuU = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 2: 
          localats.nEt = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 3: 
          localats.nDo = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 4: 
          localats.ufR = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 5: 
          localats.GrK = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 6: 
          localats.GrL = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 7: 
          localats.FDD = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 8: 
          localats.FXg = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 9: 
          localats.GrM = locala.NPN.readString();
          AppMethodBeat.o(32218);
          return 0;
        }
        localats.FqJ = locala.NPN.zc();
        AppMethodBeat.o(32218);
        return 0;
      }
      AppMethodBeat.o(32218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ats
 * JD-Core Version:    0.7.0.1
 */