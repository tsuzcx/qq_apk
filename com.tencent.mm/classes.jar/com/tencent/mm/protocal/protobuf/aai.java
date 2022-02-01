package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aai
  extends com.tencent.mm.bx.a
{
  public int FZh;
  public int FZi;
  public int FxD;
  public String FxE;
  public int count;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FxE != null) {
        paramVarArgs.d(1, this.FxE);
      }
      paramVarArgs.aS(2, this.FxD);
      paramVarArgs.aS(3, this.FZh);
      paramVarArgs.aS(4, this.FZi);
      paramVarArgs.aS(5, this.scene);
      paramVarArgs.aS(6, this.count);
      AppMethodBeat.o(103205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FxE == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.FxE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FxD);
      int j = f.a.a.b.b.a.bz(3, this.FZh);
      int k = f.a.a.b.b.a.bz(4, this.FZi);
      int m = f.a.a.b.b.a.bz(5, this.scene);
      int n = f.a.a.b.b.a.bz(6, this.count);
      AppMethodBeat.o(103205);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103205);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aai localaai = (aai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103205);
          return -1;
        case 1: 
          localaai.FxE = locala.NPN.readString();
          AppMethodBeat.o(103205);
          return 0;
        case 2: 
          localaai.FxD = locala.NPN.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 3: 
          localaai.FZh = locala.NPN.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 4: 
          localaai.FZi = locala.NPN.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 5: 
          localaai.scene = locala.NPN.zc();
          AppMethodBeat.o(103205);
          return 0;
        }
        localaai.count = locala.NPN.zc();
        AppMethodBeat.o(103205);
        return 0;
      }
      AppMethodBeat.o(103205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aai
 * JD-Core Version:    0.7.0.1
 */