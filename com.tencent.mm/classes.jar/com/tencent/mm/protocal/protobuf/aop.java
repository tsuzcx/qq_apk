package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aop
  extends com.tencent.mm.bw.a
{
  public int EDe;
  public long EHG;
  public String EHH;
  public int EHI;
  public int EHJ;
  public String coverUrl;
  public String dol;
  public int followFlag;
  public int friendFollowCount;
  public int rPI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dol != null) {
        paramVarArgs.d(1, this.dol);
      }
      paramVarArgs.aO(2, this.EHG);
      paramVarArgs.aR(3, this.EDe);
      if (this.EHH != null) {
        paramVarArgs.d(4, this.EHH);
      }
      paramVarArgs.aR(5, this.rPI);
      paramVarArgs.aR(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.d(7, this.coverUrl);
      }
      paramVarArgs.aR(8, this.friendFollowCount);
      paramVarArgs.aR(9, this.EHI);
      paramVarArgs.aR(10, this.EHJ);
      AppMethodBeat.o(195120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dol == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.dol) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EHG) + f.a.a.b.b.a.bx(3, this.EDe);
      paramInt = i;
      if (this.EHH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EHH);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.rPI) + f.a.a.b.b.a.bx(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.coverUrl);
      }
      i = f.a.a.b.b.a.bx(8, this.friendFollowCount);
      int j = f.a.a.b.b.a.bx(9, this.EHI);
      int k = f.a.a.b.b.a.bx(10, this.EHJ);
      AppMethodBeat.o(195120);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195120);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aop localaop = (aop)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195120);
          return -1;
        case 1: 
          localaop.dol = locala.LVo.readString();
          AppMethodBeat.o(195120);
          return 0;
        case 2: 
          localaop.EHG = locala.LVo.xG();
          AppMethodBeat.o(195120);
          return 0;
        case 3: 
          localaop.EDe = locala.LVo.xF();
          AppMethodBeat.o(195120);
          return 0;
        case 4: 
          localaop.EHH = locala.LVo.readString();
          AppMethodBeat.o(195120);
          return 0;
        case 5: 
          localaop.rPI = locala.LVo.xF();
          AppMethodBeat.o(195120);
          return 0;
        case 6: 
          localaop.followFlag = locala.LVo.xF();
          AppMethodBeat.o(195120);
          return 0;
        case 7: 
          localaop.coverUrl = locala.LVo.readString();
          AppMethodBeat.o(195120);
          return 0;
        case 8: 
          localaop.friendFollowCount = locala.LVo.xF();
          AppMethodBeat.o(195120);
          return 0;
        case 9: 
          localaop.EHI = locala.LVo.xF();
          AppMethodBeat.o(195120);
          return 0;
        }
        localaop.EHJ = locala.LVo.xF();
        AppMethodBeat.o(195120);
        return 0;
      }
      AppMethodBeat.o(195120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aop
 * JD-Core Version:    0.7.0.1
 */