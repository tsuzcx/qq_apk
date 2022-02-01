package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tv
  extends com.tencent.mm.bw.a
{
  public String DOK;
  public int EnK;
  public String EnL;
  public int EnM;
  public String EnN;
  public int EnO;
  public String EnP;
  public String EnQ;
  public String EnR;
  public String EnS;
  public int EnT;
  public String EnU;
  public int oGF;
  public String oGG;
  public String oGM;
  public String oGN;
  public String oHz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EnK);
      if (this.oHz != null) {
        paramVarArgs.d(2, this.oHz);
      }
      if (this.EnL != null) {
        paramVarArgs.d(3, this.EnL);
      }
      if (this.oGM != null) {
        paramVarArgs.d(4, this.oGM);
      }
      paramVarArgs.aR(5, this.EnM);
      if (this.EnN != null) {
        paramVarArgs.d(6, this.EnN);
      }
      paramVarArgs.aR(7, this.EnO);
      if (this.oGN != null) {
        paramVarArgs.d(8, this.oGN);
      }
      if (this.DOK != null) {
        paramVarArgs.d(9, this.DOK);
      }
      paramVarArgs.aR(10, this.oGF);
      if (this.oGG != null) {
        paramVarArgs.d(11, this.oGG);
      }
      if (this.EnP != null) {
        paramVarArgs.d(12, this.EnP);
      }
      if (this.EnQ != null) {
        paramVarArgs.d(13, this.EnQ);
      }
      if (this.EnR != null) {
        paramVarArgs.d(14, this.EnR);
      }
      if (this.EnS != null) {
        paramVarArgs.d(15, this.EnS);
      }
      paramVarArgs.aR(16, this.EnT);
      if (this.EnU != null) {
        paramVarArgs.d(17, this.EnU);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EnK) + 0;
      paramInt = i;
      if (this.oHz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oHz);
      }
      i = paramInt;
      if (this.EnL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EnL);
      }
      paramInt = i;
      if (this.oGM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGM);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EnM);
      paramInt = i;
      if (this.EnN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EnN);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.EnO);
      paramInt = i;
      if (this.oGN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oGN);
      }
      i = paramInt;
      if (this.DOK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DOK);
      }
      i += f.a.a.b.b.a.bx(10, this.oGF);
      paramInt = i;
      if (this.oGG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oGG);
      }
      i = paramInt;
      if (this.EnP != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EnP);
      }
      paramInt = i;
      if (this.EnQ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EnQ);
      }
      i = paramInt;
      if (this.EnR != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EnR);
      }
      paramInt = i;
      if (this.EnS != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EnS);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.EnT);
      paramInt = i;
      if (this.EnU != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EnU);
      }
      AppMethodBeat.o(125715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      tv localtv = (tv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localtv.EnK = locala.LVo.xF();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localtv.oHz = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localtv.EnL = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localtv.oGM = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localtv.EnM = locala.LVo.xF();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localtv.EnN = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localtv.EnO = locala.LVo.xF();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localtv.oGN = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localtv.DOK = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localtv.oGF = locala.LVo.xF();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localtv.oGG = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localtv.EnP = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localtv.EnQ = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localtv.EnR = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localtv.EnS = locala.LVo.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localtv.EnT = locala.LVo.xF();
        AppMethodBeat.o(125715);
        return 0;
      }
      localtv.EnU = locala.LVo.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */