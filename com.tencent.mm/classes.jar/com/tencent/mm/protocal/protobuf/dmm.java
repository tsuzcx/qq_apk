package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmm
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FNv;
  public String FYD;
  public int FYE;
  public int FYF;
  public int FYG;
  public String FYq;
  public String FYs;
  public String FYu;
  public String FYv;
  public String FYw;
  public long Gcl;
  public String Gco;
  public int Gcp;
  public String Title;
  public int hFR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNv);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.FYq != null) {
        paramVarArgs.d(3, this.FYq);
      }
      if (this.FYs != null) {
        paramVarArgs.d(6, this.FYs);
      }
      if (this.FYu != null) {
        paramVarArgs.d(8, this.FYu);
      }
      if (this.FYv != null) {
        paramVarArgs.d(9, this.FYv);
      }
      if (this.FYw != null) {
        paramVarArgs.d(10, this.FYw);
      }
      paramVarArgs.aS(11, this.hFR);
      if (this.FYD != null) {
        paramVarArgs.d(15, this.FYD);
      }
      paramVarArgs.aS(16, this.FYE);
      paramVarArgs.aS(17, this.FYF);
      paramVarArgs.aS(18, this.FYG);
      paramVarArgs.aS(19, this.CreateTime);
      paramVarArgs.aZ(20, this.Gcl);
      if (this.Gco != null) {
        paramVarArgs.d(21, this.Gco);
      }
      paramVarArgs.aS(22, this.Gcp);
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FNv) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.FYq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FYq);
      }
      paramInt = i;
      if (this.FYs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FYs);
      }
      i = paramInt;
      if (this.FYu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FYu);
      }
      paramInt = i;
      if (this.FYv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FYv);
      }
      i = paramInt;
      if (this.FYw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FYw);
      }
      i += f.a.a.b.b.a.bz(11, this.hFR);
      paramInt = i;
      if (this.FYD != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FYD);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FYE) + f.a.a.b.b.a.bz(17, this.FYF) + f.a.a.b.b.a.bz(18, this.FYG) + f.a.a.b.b.a.bz(19, this.CreateTime) + f.a.a.b.b.a.p(20, this.Gcl);
      paramInt = i;
      if (this.Gco != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Gco);
      }
      i = f.a.a.b.b.a.bz(22, this.Gcp);
      AppMethodBeat.o(124558);
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
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmm localdmm = (dmm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localdmm.FNv = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localdmm.Title = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localdmm.FYq = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localdmm.FYs = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localdmm.FYu = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localdmm.FYv = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localdmm.FYw = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localdmm.hFR = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localdmm.FYD = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localdmm.FYE = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localdmm.FYF = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localdmm.FYG = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localdmm.CreateTime = locala.OmT.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localdmm.Gcl = locala.OmT.zd();
        AppMethodBeat.o(124558);
        return 0;
      case 21: 
        localdmm.Gco = locala.OmT.readString();
        AppMethodBeat.o(124558);
        return 0;
      }
      localdmm.Gcp = locala.OmT.zc();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmm
 * JD-Core Version:    0.7.0.1
 */