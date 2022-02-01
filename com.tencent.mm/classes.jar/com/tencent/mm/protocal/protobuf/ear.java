package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ear
  extends com.tencent.mm.bw.a
{
  public int MSm;
  public int Nae;
  public LinkedList<dzx> Naf;
  public int Nag;
  public int Nah;
  
  public ear()
  {
    AppMethodBeat.i(125810);
    this.Naf = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nae);
      paramVarArgs.e(2, 8, this.Naf);
      paramVarArgs.aM(3, this.Nag);
      paramVarArgs.aM(4, this.MSm);
      paramVarArgs.aM(5, this.Nah);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Nae);
      i = g.a.a.a.c(2, 8, this.Naf);
      int j = g.a.a.b.b.a.bu(3, this.Nag);
      int k = g.a.a.b.b.a.bu(4, this.MSm);
      int m = g.a.a.b.b.a.bu(5, this.Nah);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Naf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ear localear = (ear)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localear.Nae = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dzx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localear.Naf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localear.Nag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localear.MSm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125811);
        return 0;
      }
      localear.Nah = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ear
 * JD-Core Version:    0.7.0.1
 */