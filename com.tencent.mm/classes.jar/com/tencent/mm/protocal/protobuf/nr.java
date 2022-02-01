package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nr
  extends com.tencent.mm.bw.a
{
  public String KQV;
  public LinkedList<nq> KTe;
  public int KTf;
  
  public nr()
  {
    AppMethodBeat.i(124413);
    this.KTe = new LinkedList();
    AppMethodBeat.o(124413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KTe);
      paramVarArgs.aM(2, this.KTf);
      if (this.KQV != null) {
        paramVarArgs.e(3, this.KQV);
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.KTe) + 0 + g.a.a.b.b.a.bu(2, this.KTf);
      paramInt = i;
      if (this.KQV != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KQV);
      }
      AppMethodBeat.o(124414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KTe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      nr localnr = (nr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124414);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((nq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localnr.KTe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124414);
        return 0;
      case 2: 
        localnr.KTf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124414);
        return 0;
      }
      localnr.KQV = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(124414);
      return 0;
    }
    AppMethodBeat.o(124414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nr
 * JD-Core Version:    0.7.0.1
 */