package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtw
  extends com.tencent.mm.bw.a
{
  public String GbO;
  public String cYI;
  public String cYJ;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.cYI != null) {
        paramVarArgs.d(1, this.cYI);
      }
      if (this.cYJ != null) {
        paramVarArgs.d(2, this.cYJ);
      }
      if (this.GbO != null) {
        paramVarArgs.d(3, this.GbO);
      }
      paramVarArgs.aO(4, this.timestamp);
      AppMethodBeat.o(147800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cYI == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.cYI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cYJ);
      }
      i = paramInt;
      if (this.GbO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GbO);
      }
      paramInt = f.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(147800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147800);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147800);
          return -1;
        case 1: 
          localdtw.cYI = locala.LVo.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 2: 
          localdtw.cYJ = locala.LVo.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 3: 
          localdtw.GbO = locala.LVo.readString();
          AppMethodBeat.o(147800);
          return 0;
        }
        localdtw.timestamp = locala.LVo.xG();
        AppMethodBeat.o(147800);
        return 0;
      }
      AppMethodBeat.o(147800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */