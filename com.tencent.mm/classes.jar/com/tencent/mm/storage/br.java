package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class br
  extends com.tencent.mm.bw.a
{
  public long cSx;
  public long kby;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.msgId);
      paramVarArgs.aO(2, this.kby);
      paramVarArgs.aO(3, this.cSx);
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.msgId);
      int i = f.a.a.b.b.a.p(2, this.kby);
      int j = f.a.a.b.b.a.p(3, this.cSx);
      AppMethodBeat.o(43276);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      br localbr = (br)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43276);
        return -1;
      case 1: 
        localbr.msgId = locala.LVo.xG();
        AppMethodBeat.o(43276);
        return 0;
      case 2: 
        localbr.kby = locala.LVo.xG();
        AppMethodBeat.o(43276);
        return 0;
      }
      localbr.cSx = locala.LVo.xG();
      AppMethodBeat.o(43276);
      return 0;
    }
    AppMethodBeat.o(43276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */