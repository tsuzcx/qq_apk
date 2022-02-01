package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int DhD;
  public com.tencent.mm.bw.b KAH;
  public int KAI;
  public int KAy;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KAH == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.KAy);
      if (this.KAH != null) {
        paramVarArgs.c(2, this.KAH);
      }
      paramVarArgs.aM(3, this.KAI);
      paramVarArgs.aM(4, this.DhD);
      paramVarArgs.aM(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KAy) + 0;
      paramInt = i;
      if (this.KAH != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KAH);
      }
      i = g.a.a.b.b.a.bu(3, this.KAI);
      int j = g.a.a.b.b.a.bu(4, this.DhD);
      int k = g.a.a.b.b.a.bu(5, this.count);
      AppMethodBeat.o(143943);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KAH == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.KAy = locala.UbS.zi();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.KAH = locala.UbS.hPo();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.KAI = locala.UbS.zi();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.DhD = locala.UbS.zi();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.UbS.zi();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */