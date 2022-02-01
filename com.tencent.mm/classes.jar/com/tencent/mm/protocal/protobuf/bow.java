package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bow
  extends com.tencent.mm.bw.a
{
  public double latitude;
  public double longitude;
  public String nYj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.latitude);
      paramVarArgs.e(2, this.longitude);
      if (this.nYj != null) {
        paramVarArgs.d(3, this.nYj);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 8 + 0 + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.nYj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nYj);
      }
      AppMethodBeat.o(93333);
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
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bow localbow = (bow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localbow.latitude = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localbow.longitude = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(93333);
        return 0;
      }
      localbow.nYj = locala.LVo.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */