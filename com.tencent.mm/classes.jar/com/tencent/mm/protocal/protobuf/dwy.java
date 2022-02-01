package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwy
  extends com.tencent.mm.bw.a
{
  public long DUK;
  public boolean GdI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DUK);
      paramVarArgs.bl(2, this.GdI);
      AppMethodBeat.o(32537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.DUK);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(32537);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwy localdwy = (dwy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32537);
        return -1;
      case 1: 
        localdwy.DUK = locala.LVo.xG();
        AppMethodBeat.o(32537);
        return 0;
      }
      localdwy.GdI = locala.LVo.fZX();
      AppMethodBeat.o(32537);
      return 0;
    }
    AppMethodBeat.o(32537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */