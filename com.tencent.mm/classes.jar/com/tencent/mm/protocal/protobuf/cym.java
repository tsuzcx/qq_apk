package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cym
  extends com.tencent.mm.bx.a
{
  public String DMQ;
  public int DMR;
  public int DNc;
  public long DNd;
  public String DNe;
  public String DNf;
  public int DNg;
  public String DNh;
  public String DNi;
  public int DNj;
  public String DNk;
  public String DNl;
  public int Dzl;
  public float EqD;
  public String Id;
  public String Url;
  public int dzf;
  public int mBH;
  public String md5;
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
      paramVarArgs.aR(2, this.mBH);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.Dzl);
      if (this.DMQ != null) {
        paramVarArgs.d(5, this.DMQ);
      }
      paramVarArgs.aR(6, this.DMR);
      paramVarArgs.aR(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(8, this.md5);
      }
      if (this.DNl != null) {
        paramVarArgs.d(9, this.DNl);
      }
      paramVarArgs.aR(10, this.dzf);
      paramVarArgs.aR(11, this.DNc);
      paramVarArgs.aG(12, this.DNd);
      if (this.DNe != null) {
        paramVarArgs.d(13, this.DNe);
      }
      if (this.DNf != null) {
        paramVarArgs.d(14, this.DNf);
      }
      paramVarArgs.aR(15, this.DNg);
      if (this.DNh != null) {
        paramVarArgs.d(16, this.DNh);
      }
      if (this.DNi != null) {
        paramVarArgs.d(17, this.DNi);
      }
      paramVarArgs.aR(18, this.DNj);
      if (this.DNk != null) {
        paramVarArgs.d(19, this.DNk);
      }
      paramVarArgs.x(20, this.EqD);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Dzl);
      paramInt = i;
      if (this.DMQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DMQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.DMR) + f.a.a.b.b.a.bA(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.md5);
      }
      i = paramInt;
      if (this.DNl != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DNl);
      }
      i = i + f.a.a.b.b.a.bA(10, this.dzf) + f.a.a.b.b.a.bA(11, this.DNc) + f.a.a.b.b.a.q(12, this.DNd);
      paramInt = i;
      if (this.DNe != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DNe);
      }
      i = paramInt;
      if (this.DNf != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DNf);
      }
      i += f.a.a.b.b.a.bA(15, this.DNg);
      paramInt = i;
      if (this.DNh != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DNh);
      }
      i = paramInt;
      if (this.DNi != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DNi);
      }
      i += f.a.a.b.b.a.bA(18, this.DNj);
      paramInt = i;
      if (this.DNk != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DNk);
      }
      i = paramInt + (f.a.a.b.b.a.fY(20) + 4);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cym localcym = (cym)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localcym.Id = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localcym.mBH = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localcym.Url = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localcym.Dzl = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localcym.DMQ = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localcym.DMR = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localcym.subType = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localcym.md5 = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localcym.DNl = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localcym.dzf = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localcym.DNc = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localcym.DNd = locala.KhF.xT();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localcym.DNe = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localcym.DNf = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localcym.DNg = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localcym.DNh = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localcym.DNi = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localcym.DNj = locala.KhF.xS();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localcym.DNk = locala.KhF.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localcym.EqD = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(118454);
          return 0;
        }
        localcym.taskId = locala.KhF.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */