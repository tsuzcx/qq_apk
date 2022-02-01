package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cfu
  extends com.tencent.mm.bw.a
{
  public int Lrp;
  public int MlF;
  public b MlG;
  public int MlH;
  public int MlI;
  public int oTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MlF);
      if (this.MlG != null) {
        paramVarArgs.c(2, this.MlG);
      }
      paramVarArgs.aM(3, this.MlH);
      paramVarArgs.aM(4, this.Lrp);
      paramVarArgs.aM(5, this.oTz);
      paramVarArgs.aM(6, this.MlI);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MlF) + 0;
      paramInt = i;
      if (this.MlG != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MlG);
      }
      i = g.a.a.b.b.a.bu(3, this.MlH);
      int j = g.a.a.b.b.a.bu(4, this.Lrp);
      int k = g.a.a.b.b.a.bu(5, this.oTz);
      int m = g.a.a.b.b.a.bu(6, this.MlI);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cfu localcfu = (cfu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localcfu.MlF = locala.UbS.zi();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localcfu.MlG = locala.UbS.hPo();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localcfu.MlH = locala.UbS.zi();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localcfu.Lrp = locala.UbS.zi();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localcfu.oTz = locala.UbS.zi();
        AppMethodBeat.o(143982);
        return 0;
      }
      localcfu.MlI = locala.UbS.zi();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfu
 * JD-Core Version:    0.7.0.1
 */