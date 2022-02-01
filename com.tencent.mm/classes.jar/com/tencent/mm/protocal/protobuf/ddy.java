package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddy
  extends com.tencent.mm.bw.a
{
  public int EUH;
  public float FNF;
  public int FjA;
  public String FjB;
  public String FjC;
  public String Fjh;
  public int Fji;
  public int Fjt;
  public long Fju;
  public String Fjv;
  public String Fjw;
  public int Fjx;
  public String Fjy;
  public String Fjz;
  public String Id;
  public String Url;
  public int dwR;
  public String md5;
  public int ndI;
  public int subType;
  public String taskId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aR(2, this.ndI);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.EUH);
      if (this.Fjh != null) {
        paramVarArgs.d(5, this.Fjh);
      }
      paramVarArgs.aR(6, this.Fji);
      paramVarArgs.aR(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(8, this.md5);
      }
      if (this.FjC != null) {
        paramVarArgs.d(9, this.FjC);
      }
      paramVarArgs.aR(10, this.dwR);
      paramVarArgs.aR(11, this.Fjt);
      paramVarArgs.aO(12, this.Fju);
      if (this.Fjv != null) {
        paramVarArgs.d(13, this.Fjv);
      }
      if (this.Fjw != null) {
        paramVarArgs.d(14, this.Fjw);
      }
      paramVarArgs.aR(15, this.Fjx);
      if (this.Fjy != null) {
        paramVarArgs.d(16, this.Fjy);
      }
      if (this.Fjz != null) {
        paramVarArgs.d(17, this.Fjz);
      }
      paramVarArgs.aR(18, this.FjA);
      if (this.FjB != null) {
        paramVarArgs.d(19, this.FjB);
      }
      paramVarArgs.x(20, this.FNF);
      if (this.taskId != null) {
        paramVarArgs.d(21, this.taskId);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EUH);
      paramInt = i;
      if (this.Fjh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fjh);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.Fji) + f.a.a.b.b.a.bx(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.md5);
      }
      i = paramInt;
      if (this.FjC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FjC);
      }
      i = i + f.a.a.b.b.a.bx(10, this.dwR) + f.a.a.b.b.a.bx(11, this.Fjt) + f.a.a.b.b.a.p(12, this.Fju);
      paramInt = i;
      if (this.Fjv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fjv);
      }
      i = paramInt;
      if (this.Fjw != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Fjw);
      }
      i += f.a.a.b.b.a.bx(15, this.Fjx);
      paramInt = i;
      if (this.Fjy != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Fjy);
      }
      i = paramInt;
      if (this.Fjz != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Fjz);
      }
      i += f.a.a.b.b.a.bx(18, this.FjA);
      paramInt = i;
      if (this.FjB != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FjB);
      }
      i = paramInt + (f.a.a.b.b.a.fK(20) + 4);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddy localddy = (ddy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localddy.Id = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localddy.ndI = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localddy.Url = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localddy.EUH = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localddy.Fjh = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localddy.Fji = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localddy.subType = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localddy.md5 = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localddy.FjC = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localddy.dwR = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localddy.Fjt = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localddy.Fju = locala.LVo.xG();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localddy.Fjv = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localddy.Fjw = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localddy.Fjx = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localddy.Fjy = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localddy.Fjz = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localddy.FjA = locala.LVo.xF();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localddy.FjB = locala.LVo.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localddy.FNF = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(118454);
          return 0;
        }
        localddy.taskId = locala.LVo.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddy
 * JD-Core Version:    0.7.0.1
 */