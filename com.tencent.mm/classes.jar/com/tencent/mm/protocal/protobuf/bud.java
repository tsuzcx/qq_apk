package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bud
  extends com.tencent.mm.bw.a
{
  public double latitude;
  public double longitude;
  public String oIf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.latitude);
      paramVarArgs.e(2, this.longitude);
      if (this.oIf != null) {
        paramVarArgs.d(3, this.oIf);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amD(1) + 0 + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.oIf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oIf);
      }
      AppMethodBeat.o(93333);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bud localbud = (bud)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localbud.latitude = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localbud.longitude = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(93333);
        return 0;
      }
      localbud.oIf = locala.OmT.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bud
 * JD-Core Version:    0.7.0.1
 */