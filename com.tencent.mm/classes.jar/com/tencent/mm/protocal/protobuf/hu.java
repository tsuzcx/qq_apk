package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hu
  extends com.tencent.mm.bx.a
{
  public int FAn;
  public String FAo;
  public String FAp;
  public String FuU;
  public String jdf;
  public String nDo;
  public String nEt;
  public int tqW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuU != null) {
        paramVarArgs.d(1, this.FuU);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      paramVarArgs.aS(4, this.FAn);
      if (this.FAo != null) {
        paramVarArgs.d(5, this.FAo);
      }
      if (this.jdf != null) {
        paramVarArgs.d(6, this.jdf);
      }
      if (this.FAp != null) {
        paramVarArgs.d(7, this.FAp);
      }
      paramVarArgs.aS(8, this.tqW);
      AppMethodBeat.o(32127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuU == null) {
        break label624;
      }
    }
    label624:
    for (int i = f.a.a.b.b.a.e(1, this.FuU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      i += f.a.a.b.b.a.bz(4, this.FAn);
      paramInt = i;
      if (this.FAo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FAo);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jdf);
      }
      paramInt = i;
      if (this.FAp != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FAp);
      }
      i = f.a.a.b.b.a.bz(8, this.tqW);
      AppMethodBeat.o(32127);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hu localhu = (hu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32127);
          return -1;
        case 1: 
          localhu.FuU = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 2: 
          localhu.nEt = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 3: 
          localhu.nDo = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 4: 
          localhu.FAn = locala.NPN.zc();
          AppMethodBeat.o(32127);
          return 0;
        case 5: 
          localhu.FAo = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 6: 
          localhu.jdf = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 7: 
          localhu.FAp = locala.NPN.readString();
          AppMethodBeat.o(32127);
          return 0;
        }
        localhu.tqW = locala.NPN.zc();
        AppMethodBeat.o(32127);
        return 0;
      }
      AppMethodBeat.o(32127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hu
 * JD-Core Version:    0.7.0.1
 */