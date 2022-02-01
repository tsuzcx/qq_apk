package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ft
  extends com.tencent.mm.bw.a
{
  public int ReqType;
  public String Url;
  public String hFO;
  public int hFR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hFO != null) {
        paramVarArgs.d(1, this.hFO);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aS(3, this.ReqType);
      paramVarArgs.aS(4, this.hFR);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hFO == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.hFO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Url);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.ReqType);
      int j = f.a.a.b.b.a.bz(4, this.hFR);
      AppMethodBeat.o(124391);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ft localft = (ft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localft.hFO = locala.OmT.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localft.Url = locala.OmT.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localft.ReqType = locala.OmT.zc();
          AppMethodBeat.o(124391);
          return 0;
        }
        localft.hFR = locala.OmT.zc();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */