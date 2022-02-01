package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class enu
  extends com.tencent.mm.cd.a
{
  public String Id;
  public String TDF;
  public int TDG;
  public int TDQ;
  public long TDR;
  public String TDS;
  public int TDT;
  public String TDU;
  public String TDV;
  public int TDW;
  public String TDX;
  public String TDY;
  public int TlV;
  public float UqC;
  public String Url;
  public int fWh;
  public String md5;
  public int rWu;
  public int subType;
  public String taskId;
  public String zZu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118454);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      paramVarArgs.aY(2, this.rWu);
      if (this.Url != null) {
        paramVarArgs.f(3, this.Url);
      }
      paramVarArgs.aY(4, this.TlV);
      if (this.TDF != null) {
        paramVarArgs.f(5, this.TDF);
      }
      paramVarArgs.aY(6, this.TDG);
      paramVarArgs.aY(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.f(8, this.md5);
      }
      if (this.TDY != null) {
        paramVarArgs.f(9, this.TDY);
      }
      paramVarArgs.aY(10, this.fWh);
      paramVarArgs.aY(11, this.TDQ);
      paramVarArgs.bm(12, this.TDR);
      if (this.TDS != null) {
        paramVarArgs.f(13, this.TDS);
      }
      if (this.zZu != null) {
        paramVarArgs.f(14, this.zZu);
      }
      paramVarArgs.aY(15, this.TDT);
      if (this.TDU != null) {
        paramVarArgs.f(16, this.TDU);
      }
      if (this.TDV != null) {
        paramVarArgs.f(17, this.TDV);
      }
      paramVarArgs.aY(18, this.TDW);
      if (this.TDX != null) {
        paramVarArgs.f(19, this.TDX);
      }
      paramVarArgs.i(20, this.UqC);
      if (this.taskId != null) {
        paramVarArgs.f(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label1281;
      }
    }
    label1281:
    for (paramInt = g.a.a.b.b.a.g(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TlV);
      paramInt = i;
      if (this.TDF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TDF);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TDG) + g.a.a.b.b.a.bM(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.md5);
      }
      i = paramInt;
      if (this.TDY != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TDY);
      }
      i = i + g.a.a.b.b.a.bM(10, this.fWh) + g.a.a.b.b.a.bM(11, this.TDQ) + g.a.a.b.b.a.p(12, this.TDR);
      paramInt = i;
      if (this.TDS != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TDS);
      }
      i = paramInt;
      if (this.zZu != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.zZu);
      }
      i += g.a.a.b.b.a.bM(15, this.TDT);
      paramInt = i;
      if (this.TDU != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TDU);
      }
      i = paramInt;
      if (this.TDV != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.TDV);
      }
      i += g.a.a.b.b.a.bM(18, this.TDW);
      paramInt = i;
      if (this.TDX != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.TDX);
      }
      i = paramInt + (g.a.a.b.b.a.gL(20) + 4);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        enu localenu = (enu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localenu.Id = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localenu.rWu = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localenu.Url = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localenu.TlV = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localenu.TDF = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localenu.TDG = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localenu.subType = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localenu.md5 = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localenu.TDY = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localenu.fWh = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localenu.TDQ = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localenu.TDR = locala.abFh.AN();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localenu.TDS = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localenu.zZu = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localenu.TDT = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localenu.TDU = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localenu.TDV = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localenu.TDW = locala.abFh.AK();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localenu.TDX = locala.abFh.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localenu.UqC = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(118454);
          return 0;
        }
        localenu.taskId = locala.abFh.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enu
 * JD-Core Version:    0.7.0.1
 */