package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alo
  extends com.tencent.mm.bw.a
{
  public int EFh;
  public String bLs;
  public String diA;
  public String hlG;
  public int likeFlag;
  public long qWK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bLs != null) {
        paramVarArgs.d(1, this.bLs);
      }
      if (this.hlG != null) {
        paramVarArgs.d(2, this.hlG);
      }
      paramVarArgs.aO(3, this.qWK);
      paramVarArgs.aR(4, this.likeFlag);
      paramVarArgs.aR(5, this.EFh);
      if (this.diA != null) {
        paramVarArgs.d(6, this.diA);
      }
      AppMethodBeat.o(195087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bLs == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.bLs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hlG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hlG);
      }
      i = i + f.a.a.b.b.a.p(3, this.qWK) + f.a.a.b.b.a.bx(4, this.likeFlag) + f.a.a.b.b.a.bx(5, this.EFh);
      paramInt = i;
      if (this.diA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.diA);
      }
      AppMethodBeat.o(195087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alo localalo = (alo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195087);
          return -1;
        case 1: 
          localalo.bLs = locala.LVo.readString();
          AppMethodBeat.o(195087);
          return 0;
        case 2: 
          localalo.hlG = locala.LVo.readString();
          AppMethodBeat.o(195087);
          return 0;
        case 3: 
          localalo.qWK = locala.LVo.xG();
          AppMethodBeat.o(195087);
          return 0;
        case 4: 
          localalo.likeFlag = locala.LVo.xF();
          AppMethodBeat.o(195087);
          return 0;
        case 5: 
          localalo.EFh = locala.LVo.xF();
          AppMethodBeat.o(195087);
          return 0;
        }
        localalo.diA = locala.LVo.readString();
        AppMethodBeat.o(195087);
        return 0;
      }
      AppMethodBeat.o(195087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alo
 * JD-Core Version:    0.7.0.1
 */