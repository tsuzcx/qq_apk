package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arh
  extends com.tencent.mm.bw.a
{
  public long GIb;
  public int crashCount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GIb);
      paramVarArgs.aS(2, this.crashCount);
      AppMethodBeat.o(189391);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GIb);
      int i = f.a.a.b.b.a.bz(2, this.crashCount);
      AppMethodBeat.o(189391);
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
      AppMethodBeat.o(189391);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arh localarh = (arh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189391);
        return -1;
      case 1: 
        localarh.GIb = locala.OmT.zd();
        AppMethodBeat.o(189391);
        return 0;
      }
      localarh.crashCount = locala.OmT.zc();
      AppMethodBeat.o(189391);
      return 0;
    }
    AppMethodBeat.o(189391);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arh
 * JD-Core Version:    0.7.0.1
 */