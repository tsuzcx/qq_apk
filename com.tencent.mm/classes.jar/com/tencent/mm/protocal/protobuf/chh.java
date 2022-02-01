package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chh
  extends com.tencent.mm.bw.a
{
  public long EcL;
  public long Fvw;
  public int nYl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.nYl);
      paramVarArgs.aO(2, this.EcL);
      paramVarArgs.aO(3, this.Fvw);
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.nYl);
      int i = f.a.a.b.b.a.p(2, this.EcL);
      int j = f.a.a.b.b.a.p(3, this.Fvw);
      AppMethodBeat.o(104829);
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
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      chh localchh = (chh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104829);
        return -1;
      case 1: 
        localchh.nYl = locala.LVo.xF();
        AppMethodBeat.o(104829);
        return 0;
      case 2: 
        localchh.EcL = locala.LVo.xG();
        AppMethodBeat.o(104829);
        return 0;
      }
      localchh.Fvw = locala.LVo.xG();
      AppMethodBeat.o(104829);
      return 0;
    }
    AppMethodBeat.o(104829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chh
 * JD-Core Version:    0.7.0.1
 */