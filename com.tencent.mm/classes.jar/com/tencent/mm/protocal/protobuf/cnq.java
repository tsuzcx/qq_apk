package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnq
  extends com.tencent.mm.bw.a
{
  public String FAL;
  public String FAM;
  public String FAN;
  public String FkJ;
  public String ndW;
  public String pAC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndW != null) {
        paramVarArgs.d(1, this.ndW);
      }
      if (this.FAL != null) {
        paramVarArgs.d(2, this.FAL);
      }
      if (this.FkJ != null) {
        paramVarArgs.d(3, this.FkJ);
      }
      if (this.FAM != null) {
        paramVarArgs.d(4, this.FAM);
      }
      if (this.pAC != null) {
        paramVarArgs.d(5, this.pAC);
      }
      if (this.FAN != null) {
        paramVarArgs.d(6, this.FAN);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndW == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.ndW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FAL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FAL);
      }
      i = paramInt;
      if (this.FkJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FkJ);
      }
      paramInt = i;
      if (this.FAM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FAM);
      }
      i = paramInt;
      if (this.pAC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pAC);
      }
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FAN);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnq localcnq = (cnq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localcnq.ndW = locala.LVo.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localcnq.FAL = locala.LVo.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localcnq.FkJ = locala.LVo.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localcnq.FAM = locala.LVo.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localcnq.pAC = locala.LVo.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localcnq.FAN = locala.LVo.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnq
 * JD-Core Version:    0.7.0.1
 */