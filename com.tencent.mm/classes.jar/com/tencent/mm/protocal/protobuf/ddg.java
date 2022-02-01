package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddg
  extends com.tencent.mm.bw.a
{
  public long FMS;
  public int FMT;
  public int FMU;
  public String ThumbUrl;
  public String ncR;
  public String tjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aO(2, this.FMS);
      paramVarArgs.aR(3, this.FMT);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(4, this.ThumbUrl);
      }
      paramVarArgs.aR(5, this.FMU);
      if (this.tjt != null) {
        paramVarArgs.d(6, this.tjt);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FMS) + f.a.a.b.b.a.bx(3, this.FMT);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ThumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FMU);
      paramInt = i;
      if (this.tjt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tjt);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddg localddg = (ddg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localddg.ncR = locala.LVo.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localddg.FMS = locala.LVo.xG();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localddg.FMT = locala.LVo.xF();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localddg.ThumbUrl = locala.LVo.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localddg.FMU = locala.LVo.xF();
          AppMethodBeat.o(118434);
          return 0;
        }
        localddg.tjt = locala.LVo.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddg
 * JD-Core Version:    0.7.0.1
 */