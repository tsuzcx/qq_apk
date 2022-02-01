package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rs
  extends com.tencent.mm.bx.a
{
  public String FNP;
  public String dDE;
  public String dEn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNP != null) {
        paramVarArgs.d(1, this.FNP);
      }
      if (this.dDE != null) {
        paramVarArgs.d(2, this.dDE);
      }
      if (this.dEn != null) {
        paramVarArgs.d(3, this.dEn);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNP == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FNP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dDE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dDE);
      }
      i = paramInt;
      if (this.dEn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEn);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localrs.FNP = locala.NPN.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localrs.dDE = locala.NPN.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localrs.dEn = locala.NPN.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */