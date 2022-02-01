package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnr
  extends com.tencent.mm.bw.a
{
  public long HUO;
  public long HUP;
  public int HUQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HUO);
      paramVarArgs.aZ(2, this.HUP);
      paramVarArgs.aS(3, this.HUQ);
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HUO);
      int i = f.a.a.b.b.a.p(2, this.HUP);
      int j = f.a.a.b.b.a.bz(3, this.HUQ);
      AppMethodBeat.o(125848);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnr localdnr = (dnr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125848);
        return -1;
      case 1: 
        localdnr.HUO = locala.OmT.zd();
        AppMethodBeat.o(125848);
        return 0;
      case 2: 
        localdnr.HUP = locala.OmT.zd();
        AppMethodBeat.o(125848);
        return 0;
      }
      localdnr.HUQ = locala.OmT.zc();
      AppMethodBeat.o(125848);
      return 0;
    }
    AppMethodBeat.o(125848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnr
 * JD-Core Version:    0.7.0.1
 */