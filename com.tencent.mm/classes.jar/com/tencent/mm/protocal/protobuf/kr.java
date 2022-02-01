package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kr
  extends com.tencent.mm.bw.a
{
  public long DXN;
  public String DXO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXN);
      if (this.DXO != null) {
        paramVarArgs.d(2, this.DXO);
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DXN) + 0;
      paramInt = i;
      if (this.DXO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXO);
      }
      AppMethodBeat.o(110891);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      kr localkr = (kr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110891);
        return -1;
      case 1: 
        localkr.DXN = locala.LVo.xG();
        AppMethodBeat.o(110891);
        return 0;
      }
      localkr.DXO = locala.LVo.readString();
      AppMethodBeat.o(110891);
      return 0;
    }
    AppMethodBeat.o(110891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kr
 * JD-Core Version:    0.7.0.1
 */