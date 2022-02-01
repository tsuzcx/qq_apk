package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caa
  extends com.tencent.mm.bw.a
{
  public int HnI;
  public String ySW;
  public int ySX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ySW != null) {
        paramVarArgs.d(1, this.ySW);
      }
      paramVarArgs.aS(2, this.ySX);
      paramVarArgs.aS(3, this.HnI);
      AppMethodBeat.o(147773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ySW == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.ySW) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.ySX);
      int j = f.a.a.b.b.a.bz(3, this.HnI);
      AppMethodBeat.o(147773);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        caa localcaa = (caa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147773);
          return -1;
        case 1: 
          localcaa.ySW = locala.OmT.readString();
          AppMethodBeat.o(147773);
          return 0;
        case 2: 
          localcaa.ySX = locala.OmT.zc();
          AppMethodBeat.o(147773);
          return 0;
        }
        localcaa.HnI = locala.OmT.zc();
        AppMethodBeat.o(147773);
        return 0;
      }
      AppMethodBeat.o(147773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caa
 * JD-Core Version:    0.7.0.1
 */