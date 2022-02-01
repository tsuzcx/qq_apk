package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cha
  extends com.tencent.mm.bw.a
{
  public int HsT;
  public int HsU;
  public String dJb;
  public String oGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb != null) {
        paramVarArgs.d(1, this.dJb);
      }
      if (this.oGg != null) {
        paramVarArgs.d(2, this.oGg);
      }
      paramVarArgs.aS(3, this.HsT);
      paramVarArgs.aS(4, this.HsU);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dJb == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.dJb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oGg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oGg);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HsT);
      int j = f.a.a.b.b.a.bz(4, this.HsU);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cha localcha = (cha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localcha.dJb = locala.OmT.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localcha.oGg = locala.OmT.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localcha.HsT = locala.OmT.zc();
          AppMethodBeat.o(114046);
          return 0;
        }
        localcha.HsU = locala.OmT.zc();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */