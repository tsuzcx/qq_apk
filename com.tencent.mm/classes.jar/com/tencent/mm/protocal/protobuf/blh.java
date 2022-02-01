package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blh
  extends com.tencent.mm.bw.a
{
  public long FaP;
  public int FaQ;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.key);
      paramVarArgs.aO(2, this.FaP);
      paramVarArgs.aR(3, this.length);
      paramVarArgs.aR(4, this.FaQ);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.key);
      int i = f.a.a.b.b.a.p(2, this.FaP);
      int j = f.a.a.b.b.a.bx(3, this.length);
      int k = f.a.a.b.b.a.bx(4, this.FaQ);
      AppMethodBeat.o(111786);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      blh localblh = (blh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localblh.key = locala.LVo.xF();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localblh.FaP = locala.LVo.xG();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localblh.length = locala.LVo.xF();
        AppMethodBeat.o(111786);
        return 0;
      }
      localblh.FaQ = locala.LVo.xF();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blh
 * JD-Core Version:    0.7.0.1
 */