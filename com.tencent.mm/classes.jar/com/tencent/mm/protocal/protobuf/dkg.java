package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkg
  extends com.tencent.mm.bw.a
{
  public int GXH;
  public float HSb;
  public String HmA;
  public String HmB;
  public int HmC;
  public String HmD;
  public String HmE;
  public String Hmj;
  public int Hmk;
  public int Hmv;
  public long Hmw;
  public String Hmx;
  public String Hmy;
  public int Hmz;
  public String Id;
  public String Url;
  public int dKr;
  public String md5;
  public int nJA;
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
      paramVarArgs.aS(2, this.nJA);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.GXH);
      if (this.Hmj != null) {
        paramVarArgs.d(5, this.Hmj);
      }
      paramVarArgs.aS(6, this.Hmk);
      paramVarArgs.aS(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(8, this.md5);
      }
      if (this.HmE != null) {
        paramVarArgs.d(9, this.HmE);
      }
      paramVarArgs.aS(10, this.dKr);
      paramVarArgs.aS(11, this.Hmv);
      paramVarArgs.aZ(12, this.Hmw);
      if (this.Hmx != null) {
        paramVarArgs.d(13, this.Hmx);
      }
      if (this.Hmy != null) {
        paramVarArgs.d(14, this.Hmy);
      }
      paramVarArgs.aS(15, this.Hmz);
      if (this.HmA != null) {
        paramVarArgs.d(16, this.HmA);
      }
      if (this.HmB != null) {
        paramVarArgs.d(17, this.HmB);
      }
      paramVarArgs.aS(18, this.HmC);
      if (this.HmD != null) {
        paramVarArgs.d(19, this.HmD);
      }
      paramVarArgs.y(20, this.HSb);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GXH);
      paramInt = i;
      if (this.Hmj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hmj);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Hmk) + f.a.a.b.b.a.bz(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.md5);
      }
      i = paramInt;
      if (this.HmE != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HmE);
      }
      i = i + f.a.a.b.b.a.bz(10, this.dKr) + f.a.a.b.b.a.bz(11, this.Hmv) + f.a.a.b.b.a.p(12, this.Hmw);
      paramInt = i;
      if (this.Hmx != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Hmx);
      }
      i = paramInt;
      if (this.Hmy != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hmy);
      }
      i += f.a.a.b.b.a.bz(15, this.Hmz);
      paramInt = i;
      if (this.HmA != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HmA);
      }
      i = paramInt;
      if (this.HmB != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HmB);
      }
      i += f.a.a.b.b.a.bz(18, this.HmC);
      paramInt = i;
      if (this.HmD != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.HmD);
      }
      i = paramInt + f.a.a.b.b.a.amE(20);
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
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkg localdkg = (dkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localdkg.Id = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localdkg.nJA = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localdkg.Url = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localdkg.GXH = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localdkg.Hmj = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localdkg.Hmk = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localdkg.subType = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localdkg.md5 = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localdkg.HmE = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localdkg.dKr = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localdkg.Hmv = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localdkg.Hmw = locala.OmT.zd();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localdkg.Hmx = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localdkg.Hmy = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localdkg.Hmz = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localdkg.HmA = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localdkg.HmB = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localdkg.HmC = locala.OmT.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localdkg.HmD = locala.OmT.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localdkg.HSb = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(118454);
          return 0;
        }
        localdkg.taskId = locala.OmT.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */