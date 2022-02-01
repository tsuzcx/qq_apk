package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bid
  extends com.tencent.mm.cd.a
{
  public long BmO;
  public String BmP;
  public int BmQ;
  public int BmR;
  public String BmS;
  public boolean BmT;
  public String extraInfo;
  public int fEH;
  public int fGo;
  public String sessionId;
  public String wmC;
  public String wmL;
  public String wmz;
  public int xkX;
  public int zZD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199145);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      if (this.wmL != null) {
        paramVarArgs.f(2, this.wmL);
      }
      if (this.wmz != null) {
        paramVarArgs.f(3, this.wmz);
      }
      if (this.BmP != null) {
        paramVarArgs.f(4, this.BmP);
      }
      paramVarArgs.aY(5, this.zZD);
      paramVarArgs.aY(6, this.xkX);
      paramVarArgs.bm(7, this.BmO);
      paramVarArgs.aY(8, this.fGo);
      paramVarArgs.aY(9, this.BmQ);
      if (this.BmS != null) {
        paramVarArgs.f(10, this.BmS);
      }
      paramVarArgs.aY(11, this.BmR);
      if (this.extraInfo != null) {
        paramVarArgs.f(12, this.extraInfo);
      }
      if (this.wmC != null) {
        paramVarArgs.f(13, this.wmC);
      }
      paramVarArgs.co(14, this.BmT);
      paramVarArgs.aY(15, this.fEH);
      AppMethodBeat.o(199145);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label938;
      }
    }
    label938:
    for (int i = g.a.a.b.b.a.g(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wmL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wmL);
      }
      i = paramInt;
      if (this.wmz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.wmz);
      }
      paramInt = i;
      if (this.BmP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.BmP);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.zZD) + g.a.a.b.b.a.bM(6, this.xkX) + g.a.a.b.b.a.p(7, this.BmO) + g.a.a.b.b.a.bM(8, this.fGo) + g.a.a.b.b.a.bM(9, this.BmQ);
      paramInt = i;
      if (this.BmS != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.BmS);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.BmR);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.extraInfo);
      }
      i = paramInt;
      if (this.wmC != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.wmC);
      }
      paramInt = g.a.a.b.b.a.gL(14);
      int j = g.a.a.b.b.a.bM(15, this.fEH);
      AppMethodBeat.o(199145);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199145);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bid localbid = (bid)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199145);
          return -1;
        case 1: 
          localbid.sessionId = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 2: 
          localbid.wmL = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 3: 
          localbid.wmz = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 4: 
          localbid.BmP = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 5: 
          localbid.zZD = locala.abFh.AK();
          AppMethodBeat.o(199145);
          return 0;
        case 6: 
          localbid.xkX = locala.abFh.AK();
          AppMethodBeat.o(199145);
          return 0;
        case 7: 
          localbid.BmO = locala.abFh.AN();
          AppMethodBeat.o(199145);
          return 0;
        case 8: 
          localbid.fGo = locala.abFh.AK();
          AppMethodBeat.o(199145);
          return 0;
        case 9: 
          localbid.BmQ = locala.abFh.AK();
          AppMethodBeat.o(199145);
          return 0;
        case 10: 
          localbid.BmS = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 11: 
          localbid.BmR = locala.abFh.AK();
          AppMethodBeat.o(199145);
          return 0;
        case 12: 
          localbid.extraInfo = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 13: 
          localbid.wmC = locala.abFh.readString();
          AppMethodBeat.o(199145);
          return 0;
        case 14: 
          localbid.BmT = locala.abFh.AB();
          AppMethodBeat.o(199145);
          return 0;
        }
        localbid.fEH = locala.abFh.AK();
        AppMethodBeat.o(199145);
        return 0;
      }
      AppMethodBeat.o(199145);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bid
 * JD-Core Version:    0.7.0.1
 */