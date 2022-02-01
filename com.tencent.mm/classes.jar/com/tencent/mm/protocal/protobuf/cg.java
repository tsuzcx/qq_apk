package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cg
  extends com.tencent.mm.bw.a
{
  public int KGy;
  public b KGz;
  public long xvg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KGy);
      if (this.KGz != null) {
        paramVarArgs.c(2, this.KGz);
      }
      paramVarArgs.bb(3, this.xvg);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KGy) + 0;
      paramInt = i;
      if (this.KGz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KGz);
      }
      i = g.a.a.b.b.a.r(3, this.xvg);
      AppMethodBeat.o(125702);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cg localcg = (cg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localcg.KGy = locala.UbS.zi();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localcg.KGz = locala.UbS.hPo();
        AppMethodBeat.o(125702);
        return 0;
      }
      localcg.xvg = locala.UbS.zl();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */