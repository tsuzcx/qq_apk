package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dao
  extends com.tencent.mm.bv.a
{
  public int xqO;
  public int ygN;
  public long ygU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xqO);
      paramVarArgs.am(2, this.ygU);
      paramVarArgs.aO(3, this.ygN);
      AppMethodBeat.o(143701);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xqO);
      int i = e.a.a.b.b.a.p(2, this.ygU);
      int j = e.a.a.b.b.a.bl(3, this.ygN);
      AppMethodBeat.o(143701);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(143701);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dao localdao = (dao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143701);
        return -1;
      case 1: 
        localdao.xqO = locala.CLY.sl();
        AppMethodBeat.o(143701);
        return 0;
      case 2: 
        localdao.ygU = locala.CLY.sm();
        AppMethodBeat.o(143701);
        return 0;
      }
      localdao.ygN = locala.CLY.sl();
      AppMethodBeat.o(143701);
      return 0;
    }
    AppMethodBeat.o(143701);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dao
 * JD-Core Version:    0.7.0.1
 */