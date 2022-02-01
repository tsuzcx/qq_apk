package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjn
  extends com.tencent.mm.bw.a
{
  public String EYS;
  public String EYT;
  public String EYU;
  public String EYV;
  public String EYW;
  public String EYX;
  public String EYY;
  public String gSO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EYS != null) {
        paramVarArgs.d(1, this.EYS);
      }
      if (this.EYT != null) {
        paramVarArgs.d(2, this.EYT);
      }
      if (this.gSO != null) {
        paramVarArgs.d(3, this.gSO);
      }
      if (this.EYU != null) {
        paramVarArgs.d(4, this.EYU);
      }
      if (this.EYV != null) {
        paramVarArgs.d(5, this.EYV);
      }
      if (this.EYW != null) {
        paramVarArgs.d(6, this.EYW);
      }
      if (this.EYX != null) {
        paramVarArgs.d(7, this.EYX);
      }
      if (this.EYY != null) {
        paramVarArgs.d(8, this.EYY);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EYS == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.EYS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EYT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EYT);
      }
      i = paramInt;
      if (this.gSO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gSO);
      }
      paramInt = i;
      if (this.EYU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EYU);
      }
      i = paramInt;
      if (this.EYV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EYV);
      }
      paramInt = i;
      if (this.EYW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EYW);
      }
      i = paramInt;
      if (this.EYX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EYX);
      }
      paramInt = i;
      if (this.EYY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EYY);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjn localbjn = (bjn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localbjn.EYS = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localbjn.EYT = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localbjn.gSO = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localbjn.EYU = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localbjn.EYV = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localbjn.EYW = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localbjn.EYX = locala.LVo.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localbjn.EYY = locala.LVo.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjn
 * JD-Core Version:    0.7.0.1
 */