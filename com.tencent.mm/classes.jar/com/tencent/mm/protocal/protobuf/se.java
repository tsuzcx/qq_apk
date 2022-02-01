package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class se
  extends com.tencent.mm.cd.a
{
  public int LhN;
  public int LhO;
  public int SbA;
  public int SbB;
  public int SbC;
  public int SbD;
  public int Sbt;
  public int Sbu;
  public int Sbv;
  public int Sbw;
  public int Sbx;
  public int Sby;
  public int Sbz;
  public String aeskey;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.aeskey != null) {
        paramVarArgs.f(1, this.aeskey);
      }
      paramVarArgs.aY(2, this.Sbt);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      paramVarArgs.aY(4, this.Sbu);
      paramVarArgs.aY(5, this.Sbv);
      paramVarArgs.aY(6, this.Sbw);
      paramVarArgs.aY(7, this.LhO);
      paramVarArgs.aY(8, this.LhN);
      if (this.md5 != null) {
        paramVarArgs.f(9, this.md5);
      }
      paramVarArgs.aY(10, this.Sbx);
      paramVarArgs.aY(11, this.Sby);
      paramVarArgs.aY(12, this.Sbz);
      paramVarArgs.aY(13, this.SbA);
      paramVarArgs.aY(14, this.SbB);
      paramVarArgs.aY(15, this.SbC);
      paramVarArgs.aY(16, this.SbD);
      AppMethodBeat.o(247667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = g.a.a.b.b.a.g(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Sbt);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Sbu) + g.a.a.b.b.a.bM(5, this.Sbv) + g.a.a.b.b.a.bM(6, this.Sbw) + g.a.a.b.b.a.bM(7, this.LhO) + g.a.a.b.b.a.bM(8, this.LhN);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.md5);
      }
      i = g.a.a.b.b.a.bM(10, this.Sbx);
      int j = g.a.a.b.b.a.bM(11, this.Sby);
      int k = g.a.a.b.b.a.bM(12, this.Sbz);
      int m = g.a.a.b.b.a.bM(13, this.SbA);
      int n = g.a.a.b.b.a.bM(14, this.SbB);
      int i1 = g.a.a.b.b.a.bM(15, this.SbC);
      int i2 = g.a.a.b.b.a.bM(16, this.SbD);
      AppMethodBeat.o(247667);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(247667);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(247667);
          return -1;
        case 1: 
          localse.aeskey = locala.abFh.readString();
          AppMethodBeat.o(247667);
          return 0;
        case 2: 
          localse.Sbt = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 3: 
          localse.url = locala.abFh.readString();
          AppMethodBeat.o(247667);
          return 0;
        case 4: 
          localse.Sbu = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 5: 
          localse.Sbv = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 6: 
          localse.Sbw = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 7: 
          localse.LhO = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 8: 
          localse.LhN = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 9: 
          localse.md5 = locala.abFh.readString();
          AppMethodBeat.o(247667);
          return 0;
        case 10: 
          localse.Sbx = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 11: 
          localse.Sby = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 12: 
          localse.Sbz = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 13: 
          localse.SbA = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 14: 
          localse.SbB = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        case 15: 
          localse.SbC = locala.abFh.AK();
          AppMethodBeat.o(247667);
          return 0;
        }
        localse.SbD = locala.abFh.AK();
        AppMethodBeat.o(247667);
        return 0;
      }
      AppMethodBeat.o(247667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */