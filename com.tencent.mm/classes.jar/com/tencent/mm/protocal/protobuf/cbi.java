package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbi
  extends com.tencent.mm.bw.a
{
  public int Mha;
  public LinkedList<crd> Mhb;
  public int Mhc;
  
  public cbi()
  {
    AppMethodBeat.i(143977);
    this.Mhb = new LinkedList();
    AppMethodBeat.o(143977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143978);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mha);
      paramVarArgs.e(2, 8, this.Mhb);
      paramVarArgs.aM(3, this.Mhc);
      AppMethodBeat.o(143978);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Mha);
      i = g.a.a.a.c(2, 8, this.Mhb);
      int j = g.a.a.b.b.a.bu(3, this.Mhc);
      AppMethodBeat.o(143978);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mhb.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143978);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cbi localcbi = (cbi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143978);
        return -1;
      case 1: 
        localcbi.Mha = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143978);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbi.Mhb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143978);
        return 0;
      }
      localcbi.Mhc = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(143978);
      return 0;
    }
    AppMethodBeat.o(143978);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbi
 * JD-Core Version:    0.7.0.1
 */