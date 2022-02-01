package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdi
  extends com.tencent.mm.bw.a
{
  public String FrZ;
  public int Fsa;
  public long createTime;
  public String dng;
  public String hlO;
  public long mWU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194052);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dng != null) {
        paramVarArgs.d(1, this.dng);
      }
      if (this.FrZ != null) {
        paramVarArgs.d(2, this.FrZ);
      }
      if (this.hlO != null) {
        paramVarArgs.d(3, this.hlO);
      }
      paramVarArgs.aO(4, this.createTime);
      paramVarArgs.aR(5, this.Fsa);
      paramVarArgs.aO(6, this.mWU);
      AppMethodBeat.o(194052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dng == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.dng) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FrZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FrZ);
      }
      i = paramInt;
      if (this.hlO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hlO);
      }
      paramInt = f.a.a.b.b.a.p(4, this.createTime);
      int j = f.a.a.b.b.a.bx(5, this.Fsa);
      int k = f.a.a.b.b.a.p(6, this.mWU);
      AppMethodBeat.o(194052);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194052);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdi localcdi = (cdi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194052);
          return -1;
        case 1: 
          localcdi.dng = locala.LVo.readString();
          AppMethodBeat.o(194052);
          return 0;
        case 2: 
          localcdi.FrZ = locala.LVo.readString();
          AppMethodBeat.o(194052);
          return 0;
        case 3: 
          localcdi.hlO = locala.LVo.readString();
          AppMethodBeat.o(194052);
          return 0;
        case 4: 
          localcdi.createTime = locala.LVo.xG();
          AppMethodBeat.o(194052);
          return 0;
        case 5: 
          localcdi.Fsa = locala.LVo.xF();
          AppMethodBeat.o(194052);
          return 0;
        }
        localcdi.mWU = locala.LVo.xG();
        AppMethodBeat.o(194052);
        return 0;
      }
      AppMethodBeat.o(194052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdi
 * JD-Core Version:    0.7.0.1
 */