package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cji
  extends com.tencent.mm.bw.a
{
  public long HvV;
  public String url;
  public String xrF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xrF != null) {
        paramVarArgs.d(1, this.xrF);
      }
      paramVarArgs.aZ(2, this.HvV);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xrF == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.xrF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HvV);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cji localcji = (cji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localcji.xrF = locala.OmT.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localcji.HvV = locala.OmT.zd();
          AppMethodBeat.o(72541);
          return 0;
        }
        localcji.url = locala.OmT.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cji
 * JD-Core Version:    0.7.0.1
 */