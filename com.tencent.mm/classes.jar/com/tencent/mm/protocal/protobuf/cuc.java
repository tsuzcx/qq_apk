package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuc
  extends com.tencent.mm.cd.a
{
  public String Dmt;
  public String Dmu;
  public int Dmv;
  public String SMN;
  public String TBM;
  public int TBN;
  public long TBO;
  public int TBP;
  public String TBQ;
  public int TBR;
  public int TBS;
  public String content;
  public String ilo;
  public int msgType;
  public String ySp;
  public String yru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msgType);
      if (this.TBM != null) {
        paramVarArgs.f(2, this.TBM);
      }
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      paramVarArgs.aY(4, this.TBN);
      paramVarArgs.bm(5, this.TBO);
      if (this.ilo != null) {
        paramVarArgs.f(6, this.ilo);
      }
      if (this.SMN != null) {
        paramVarArgs.f(7, this.SMN);
      }
      paramVarArgs.aY(8, this.Dmv);
      paramVarArgs.aY(9, this.TBP);
      if (this.TBQ != null) {
        paramVarArgs.f(10, this.TBQ);
      }
      if (this.Dmt != null) {
        paramVarArgs.f(11, this.Dmt);
      }
      paramVarArgs.aY(12, this.TBR);
      if (this.Dmu != null) {
        paramVarArgs.f(13, this.Dmu);
      }
      if (this.ySp != null) {
        paramVarArgs.f(14, this.ySp);
      }
      if (this.yru != null) {
        paramVarArgs.f(15, this.yru);
      }
      paramVarArgs.aY(16, this.TBS);
      AppMethodBeat.o(230506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.msgType) + 0;
      paramInt = i;
      if (this.TBM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TBM);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.content);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TBN) + g.a.a.b.b.a.p(5, this.TBO);
      paramInt = i;
      if (this.ilo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ilo);
      }
      i = paramInt;
      if (this.SMN != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SMN);
      }
      i = i + g.a.a.b.b.a.bM(8, this.Dmv) + g.a.a.b.b.a.bM(9, this.TBP);
      paramInt = i;
      if (this.TBQ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TBQ);
      }
      i = paramInt;
      if (this.Dmt != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Dmt);
      }
      i += g.a.a.b.b.a.bM(12, this.TBR);
      paramInt = i;
      if (this.Dmu != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Dmu);
      }
      i = paramInt;
      if (this.ySp != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.ySp);
      }
      paramInt = i;
      if (this.yru != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.yru);
      }
      i = g.a.a.b.b.a.bM(16, this.TBS);
      AppMethodBeat.o(230506);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230506);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cuc localcuc = (cuc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230506);
        return -1;
      case 1: 
        localcuc.msgType = locala.abFh.AK();
        AppMethodBeat.o(230506);
        return 0;
      case 2: 
        localcuc.TBM = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 3: 
        localcuc.content = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 4: 
        localcuc.TBN = locala.abFh.AK();
        AppMethodBeat.o(230506);
        return 0;
      case 5: 
        localcuc.TBO = locala.abFh.AN();
        AppMethodBeat.o(230506);
        return 0;
      case 6: 
        localcuc.ilo = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 7: 
        localcuc.SMN = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 8: 
        localcuc.Dmv = locala.abFh.AK();
        AppMethodBeat.o(230506);
        return 0;
      case 9: 
        localcuc.TBP = locala.abFh.AK();
        AppMethodBeat.o(230506);
        return 0;
      case 10: 
        localcuc.TBQ = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 11: 
        localcuc.Dmt = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 12: 
        localcuc.TBR = locala.abFh.AK();
        AppMethodBeat.o(230506);
        return 0;
      case 13: 
        localcuc.Dmu = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 14: 
        localcuc.ySp = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      case 15: 
        localcuc.yru = locala.abFh.readString();
        AppMethodBeat.o(230506);
        return 0;
      }
      localcuc.TBS = locala.abFh.AK();
      AppMethodBeat.o(230506);
      return 0;
    }
    AppMethodBeat.o(230506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuc
 * JD-Core Version:    0.7.0.1
 */