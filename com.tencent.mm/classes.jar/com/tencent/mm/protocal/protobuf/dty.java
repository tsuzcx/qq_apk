package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dty
  extends com.tencent.mm.bw.a
{
  public int DOr;
  public long GbP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.GbP);
      paramVarArgs.aR(2, this.DOr);
      AppMethodBeat.o(147802);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GbP);
      int i = f.a.a.b.b.a.bx(2, this.DOr);
      AppMethodBeat.o(147802);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(147802);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dty localdty = (dty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147802);
        return -1;
      case 1: 
        localdty.GbP = locala.LVo.xG();
        AppMethodBeat.o(147802);
        return 0;
      }
      localdty.DOr = locala.LVo.xF();
      AppMethodBeat.o(147802);
      return 0;
    }
    AppMethodBeat.o(147802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dty
 * JD-Core Version:    0.7.0.1
 */