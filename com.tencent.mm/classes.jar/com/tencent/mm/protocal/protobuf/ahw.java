package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahw
  extends com.tencent.mm.bw.a
{
  public int GxH;
  public int GxI;
  public int GxJ;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GxH);
      paramVarArgs.aS(2, this.GxI);
      paramVarArgs.aS(3, this.GxJ);
      paramVarArgs.aS(4, this.count);
      AppMethodBeat.o(196258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GxH);
      int i = f.a.a.b.b.a.bz(2, this.GxI);
      int j = f.a.a.b.b.a.bz(3, this.GxJ);
      int k = f.a.a.b.b.a.bz(4, this.count);
      AppMethodBeat.o(196258);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(196258);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahw localahw = (ahw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196258);
        return -1;
      case 1: 
        localahw.GxH = locala.OmT.zc();
        AppMethodBeat.o(196258);
        return 0;
      case 2: 
        localahw.GxI = locala.OmT.zc();
        AppMethodBeat.o(196258);
        return 0;
      case 3: 
        localahw.GxJ = locala.OmT.zc();
        AppMethodBeat.o(196258);
        return 0;
      }
      localahw.count = locala.OmT.zc();
      AppMethodBeat.o(196258);
      return 0;
    }
    AppMethodBeat.o(196258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahw
 * JD-Core Version:    0.7.0.1
 */