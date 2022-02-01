package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecg
  extends com.tencent.mm.bw.a
{
  public String GhN;
  public String GhO;
  public String djj;
  public int lTR;
  public int lVs;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.GhN != null) {
        paramVarArgs.d(3, this.GhN);
      }
      if (this.GhO != null) {
        paramVarArgs.d(4, this.GhO);
      }
      paramVarArgs.aR(5, this.lTR);
      paramVarArgs.aR(6, this.lVs);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.GhN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GhN);
      }
      paramInt = i;
      if (this.GhO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GhO);
      }
      i = f.a.a.b.b.a.bx(5, this.lTR);
      int j = f.a.a.b.b.a.bx(6, this.lVs);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecg localecg = (ecg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localecg.type = locala.LVo.xF();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localecg.djj = locala.LVo.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localecg.GhN = locala.LVo.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localecg.GhO = locala.LVo.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localecg.lTR = locala.LVo.xF();
        AppMethodBeat.o(123710);
        return 0;
      }
      localecg.lVs = locala.LVo.xF();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecg
 * JD-Core Version:    0.7.0.1
 */