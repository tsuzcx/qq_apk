package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bla
  extends com.tencent.mm.bx.a
{
  public double latitude;
  public double longitude;
  public String nvj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.latitude);
      paramVarArgs.e(2, this.longitude);
      if (this.nvj != null) {
        paramVarArgs.d(3, this.nvj);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 8 + 0 + (f.a.a.b.b.a.fY(2) + 8);
      paramInt = i;
      if (this.nvj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nvj);
      }
      AppMethodBeat.o(93333);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bla localbla = (bla)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localbla.latitude = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localbla.longitude = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(93333);
        return 0;
      }
      localbla.nvj = locala.KhF.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */