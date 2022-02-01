package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class pp
  extends com.tencent.mm.bw.a
{
  public long EfY;
  public b EfZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EfY);
      if (this.EfZ != null) {
        paramVarArgs.c(2, this.EfZ);
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.EfY) + 0;
      paramInt = i;
      if (this.EfZ != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EfZ);
      }
      AppMethodBeat.o(43084);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pp localpp = (pp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43084);
        return -1;
      case 1: 
        localpp.EfY = locala.LVo.xG();
        AppMethodBeat.o(43084);
        return 0;
      }
      localpp.EfZ = locala.LVo.gfk();
      AppMethodBeat.o(43084);
      return 0;
    }
    AppMethodBeat.o(43084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pp
 * JD-Core Version:    0.7.0.1
 */