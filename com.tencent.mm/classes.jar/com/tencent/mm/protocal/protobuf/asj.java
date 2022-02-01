package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asj
  extends com.tencent.mm.bw.a
{
  public long GJA;
  public String GJz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GJz != null) {
        paramVarArgs.d(1, this.GJz);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.aZ(3, this.GJA);
      AppMethodBeat.o(169059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GJz == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.GJz) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.type);
      int j = f.a.a.b.b.a.p(3, this.GJA);
      AppMethodBeat.o(169059);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169059);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        asj localasj = (asj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169059);
          return -1;
        case 1: 
          localasj.GJz = locala.OmT.readString();
          AppMethodBeat.o(169059);
          return 0;
        case 2: 
          localasj.type = locala.OmT.zc();
          AppMethodBeat.o(169059);
          return 0;
        }
        localasj.GJA = locala.OmT.zd();
        AppMethodBeat.o(169059);
        return 0;
      }
      AppMethodBeat.o(169059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asj
 * JD-Core Version:    0.7.0.1
 */