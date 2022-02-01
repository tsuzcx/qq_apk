package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aaj
  extends com.tencent.mm.bx.a
{
  public int FHr;
  public int FZj;
  public String FZk;
  public int FZl;
  public int FZm;
  public int FZn;
  public int FZo;
  public String FxE;
  public int FxG;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.FxE != null) {
        paramVarArgs.d(3, this.FxE);
      }
      paramVarArgs.aS(4, this.FHr);
      paramVarArgs.aS(5, this.FxG);
      paramVarArgs.aS(6, this.FZj);
      if (this.FZk != null) {
        paramVarArgs.d(7, this.FZk);
      }
      paramVarArgs.aS(8, this.FZl);
      paramVarArgs.aS(9, this.FZm);
      paramVarArgs.aS(10, this.FZn);
      paramVarArgs.aS(11, this.FZo);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.b.b.a.e(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FxE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FxE);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FHr) + f.a.a.b.b.a.bz(5, this.FxG) + f.a.a.b.b.a.bz(6, this.FZj);
      paramInt = i;
      if (this.FZk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FZk);
      }
      i = f.a.a.b.b.a.bz(8, this.FZl);
      int j = f.a.a.b.b.a.bz(9, this.FZm);
      int k = f.a.a.b.b.a.bz(10, this.FZn);
      int m = f.a.a.b.b.a.bz(11, this.FZo);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aaj localaaj = (aaj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localaaj.content = locala.NPN.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localaaj.FxE = locala.NPN.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localaaj.FHr = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localaaj.FxG = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localaaj.FZj = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localaaj.FZk = locala.NPN.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localaaj.FZl = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localaaj.FZm = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localaaj.FZn = locala.NPN.zc();
          AppMethodBeat.o(103206);
          return 0;
        }
        localaaj.FZo = locala.NPN.zc();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaj
 * JD-Core Version:    0.7.0.1
 */