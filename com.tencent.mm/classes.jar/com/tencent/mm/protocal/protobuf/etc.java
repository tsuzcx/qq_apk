package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class etc
  extends com.tencent.mm.bw.a
{
  public long Lta;
  public long NeG;
  public int NqC;
  public int NqD;
  public int NqE;
  public int NqF;
  public b NqG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NeG);
      paramVarArgs.bb(2, this.Lta);
      paramVarArgs.aM(3, this.NqC);
      paramVarArgs.aM(4, this.NqD);
      paramVarArgs.aM(5, this.NqE);
      paramVarArgs.aM(6, this.NqF);
      if (this.NqG != null) {
        paramVarArgs.c(7, this.NqG);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.NeG) + 0 + g.a.a.b.b.a.r(2, this.Lta) + g.a.a.b.b.a.bu(3, this.NqC) + g.a.a.b.b.a.bu(4, this.NqD) + g.a.a.b.b.a.bu(5, this.NqE) + g.a.a.b.b.a.bu(6, this.NqF);
      paramInt = i;
      if (this.NqG != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.NqG);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      etc localetc = (etc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localetc.NeG = locala.UbS.zl();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localetc.Lta = locala.UbS.zl();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localetc.NqC = locala.UbS.zi();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localetc.NqD = locala.UbS.zi();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localetc.NqE = locala.UbS.zi();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localetc.NqF = locala.UbS.zi();
        AppMethodBeat.o(125501);
        return 0;
      }
      localetc.NqG = locala.UbS.hPo();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etc
 * JD-Core Version:    0.7.0.1
 */