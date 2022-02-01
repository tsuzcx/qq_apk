package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvi
  extends com.tencent.mm.bw.a
{
  public long Hib;
  public long Hic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Hib);
      paramVarArgs.aZ(2, this.Hic);
      AppMethodBeat.o(215578);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Hib);
      int i = f.a.a.b.b.a.p(2, this.Hic);
      AppMethodBeat.o(215578);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(215578);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvi localbvi = (bvi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215578);
        return -1;
      case 1: 
        localbvi.Hib = locala.OmT.zd();
        AppMethodBeat.o(215578);
        return 0;
      }
      localbvi.Hic = locala.OmT.zd();
      AppMethodBeat.o(215578);
      return 0;
    }
    AppMethodBeat.o(215578);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvi
 * JD-Core Version:    0.7.0.1
 */