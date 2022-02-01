package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dge
  extends com.tencent.mm.bw.a
{
  public String Url;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125774);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aS(2, this.nJA);
      AppMethodBeat.o(125774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJA);
      AppMethodBeat.o(125774);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125774);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dge localdge = (dge)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125774);
          return -1;
        case 1: 
          localdge.Url = locala.OmT.readString();
          AppMethodBeat.o(125774);
          return 0;
        }
        localdge.nJA = locala.OmT.zc();
        AppMethodBeat.o(125774);
        return 0;
      }
      AppMethodBeat.o(125774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dge
 * JD-Core Version:    0.7.0.1
 */