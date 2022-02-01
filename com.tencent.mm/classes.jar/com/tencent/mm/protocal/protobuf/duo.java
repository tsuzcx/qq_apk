package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duo
  extends com.tencent.mm.bw.a
{
  public String scope;
  public int state;
  public String yTx;
  public int yTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.yTx != null) {
        paramVarArgs.d(2, this.yTx);
      }
      paramVarArgs.aS(3, this.state);
      paramVarArgs.aS(4, this.yTy);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yTx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yTx);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.state);
      int j = f.a.a.b.b.a.bz(4, this.yTy);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duo localduo = (duo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localduo.scope = locala.OmT.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localduo.yTx = locala.OmT.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localduo.state = locala.OmT.zc();
          AppMethodBeat.o(74674);
          return 0;
        }
        localduo.yTy = locala.OmT.zc();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duo
 * JD-Core Version:    0.7.0.1
 */