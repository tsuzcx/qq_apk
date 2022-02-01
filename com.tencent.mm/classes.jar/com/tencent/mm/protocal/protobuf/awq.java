package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awq
  extends com.tencent.mm.bw.a
{
  public int FOE;
  public int GOm;
  public String ikm;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.FOE);
      paramVarArgs.aS(4, this.GOm);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJA);
      int j = f.a.a.b.b.a.bz(3, this.FOE);
      int k = f.a.a.b.b.a.bz(4, this.GOm);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        awq localawq = (awq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localawq.ikm = locala.OmT.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localawq.nJA = locala.OmT.zc();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localawq.FOE = locala.OmT.zc();
          AppMethodBeat.o(123572);
          return 0;
        }
        localawq.GOm = locala.OmT.zc();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awq
 * JD-Core Version:    0.7.0.1
 */