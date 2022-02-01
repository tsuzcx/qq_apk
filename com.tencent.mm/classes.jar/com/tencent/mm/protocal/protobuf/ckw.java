package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckw
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int HwR;
  public String Hxf;
  public String Hxg;
  public String uuo;
  public String wSZ;
  public String wTb;
  public String wTc;
  public int wTd;
  public String wTe;
  public int wTf;
  public int wTg;
  public String wTi;
  public String wTj;
  public String wTk;
  public String wTl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wSZ != null) {
        paramVarArgs.d(1, this.wSZ);
      }
      paramVarArgs.aS(2, this.HwR);
      if (this.wTb != null) {
        paramVarArgs.d(3, this.wTb);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.wTc != null) {
        paramVarArgs.d(5, this.wTc);
      }
      paramVarArgs.aS(6, this.wTd);
      if (this.wTe != null) {
        paramVarArgs.d(7, this.wTe);
      }
      paramVarArgs.aS(8, this.wTf);
      paramVarArgs.aS(9, this.wTg);
      if (this.uuo != null) {
        paramVarArgs.d(11, this.uuo);
      }
      if (this.wTi != null) {
        paramVarArgs.d(12, this.wTi);
      }
      if (this.wTj != null) {
        paramVarArgs.d(13, this.wTj);
      }
      if (this.wTk != null) {
        paramVarArgs.d(14, this.wTk);
      }
      if (this.wTl != null) {
        paramVarArgs.d(15, this.wTl);
      }
      if (this.Hxf != null) {
        paramVarArgs.d(18, this.Hxf);
      }
      if (this.Hxg != null) {
        paramVarArgs.d(19, this.Hxg);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wSZ == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.wSZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HwR);
      paramInt = i;
      if (this.wTb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wTb);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.wTc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wTc);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.wTd);
      paramInt = i;
      if (this.wTe != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wTe);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.wTf) + f.a.a.b.b.a.bz(9, this.wTg);
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.uuo);
      }
      i = paramInt;
      if (this.wTi != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.wTi);
      }
      paramInt = i;
      if (this.wTj != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.wTj);
      }
      i = paramInt;
      if (this.wTk != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.wTk);
      }
      paramInt = i;
      if (this.wTl != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.wTl);
      }
      i = paramInt;
      if (this.Hxf != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Hxf);
      }
      paramInt = i;
      if (this.Hxg != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Hxg);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckw localckw = (ckw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localckw.wSZ = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localckw.HwR = locala.OmT.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localckw.wTb = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localckw.CreateTime = locala.OmT.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localckw.wTc = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localckw.wTd = locala.OmT.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localckw.wTe = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localckw.wTf = locala.OmT.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localckw.wTg = locala.OmT.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localckw.uuo = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localckw.wTi = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localckw.wTj = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localckw.wTk = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localckw.wTl = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localckw.Hxf = locala.OmT.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localckw.Hxg = locala.OmT.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */