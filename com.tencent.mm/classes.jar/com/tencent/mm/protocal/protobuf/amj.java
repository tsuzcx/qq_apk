package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amj
  extends com.tencent.mm.bw.a
{
  public int EDP;
  public int EDQ;
  public int EDR;
  public int EEd;
  public int EEe;
  public int EFG;
  public String country;
  public String coverImgUrl;
  public int exL;
  public String exV;
  public String exW;
  public String hlG;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.d(1, this.nickname);
      }
      if (this.signature != null) {
        paramVarArgs.d(2, this.signature);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.d(3, this.coverImgUrl);
      }
      if (this.hlG != null) {
        paramVarArgs.d(4, this.hlG);
      }
      if (this.country != null) {
        paramVarArgs.d(5, this.country);
      }
      if (this.exV != null) {
        paramVarArgs.d(6, this.exV);
      }
      if (this.exW != null) {
        paramVarArgs.d(7, this.exW);
      }
      paramVarArgs.aR(8, this.exL);
      paramVarArgs.aR(9, this.EDP);
      paramVarArgs.aR(10, this.EDQ);
      paramVarArgs.aR(11, this.EDR);
      paramVarArgs.aR(12, this.EEd);
      paramVarArgs.aR(13, this.EEe);
      paramVarArgs.aR(14, this.EFG);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.b.b.a.e(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.signature);
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.coverImgUrl);
      }
      paramInt = i;
      if (this.hlG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hlG);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.country);
      }
      paramInt = i;
      if (this.exV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.exV);
      }
      i = paramInt;
      if (this.exW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.exW);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.exL);
      int j = f.a.a.b.b.a.bx(9, this.EDP);
      int k = f.a.a.b.b.a.bx(10, this.EDQ);
      int m = f.a.a.b.b.a.bx(11, this.EDR);
      int n = f.a.a.b.b.a.bx(12, this.EEd);
      int i1 = f.a.a.b.b.a.bx(13, this.EEe);
      int i2 = f.a.a.b.b.a.bx(14, this.EFG);
      AppMethodBeat.o(169015);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amj localamj = (amj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localamj.nickname = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localamj.signature = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localamj.coverImgUrl = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localamj.hlG = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localamj.country = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localamj.exV = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localamj.exW = locala.LVo.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localamj.exL = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localamj.EDP = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localamj.EDQ = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localamj.EDR = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localamj.EEd = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localamj.EEe = locala.LVo.xF();
          AppMethodBeat.o(169015);
          return 0;
        }
        localamj.EFG = locala.LVo.xF();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amj
 * JD-Core Version:    0.7.0.1
 */