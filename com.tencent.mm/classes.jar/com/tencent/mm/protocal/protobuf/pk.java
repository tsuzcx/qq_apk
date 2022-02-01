package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pk
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public LinkedList<pj> KUf;
  public long KWz;
  public String Title;
  
  public pk()
  {
    AppMethodBeat.i(212254);
    this.KUf = new LinkedList();
    AppMethodBeat.o(212254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212255);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KHa);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.KUf);
      paramVarArgs.bb(4, this.KWz);
      AppMethodBeat.o(212255);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KHa) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = g.a.a.a.c(3, 8, this.KUf);
      int j = g.a.a.b.b.a.r(4, this.KWz);
      AppMethodBeat.o(212255);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KUf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212255);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      pk localpk = (pk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212255);
        return -1;
      case 1: 
        localpk.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212255);
        return 0;
      case 2: 
        localpk.Title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212255);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localpk.KUf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212255);
        return 0;
      }
      localpk.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(212255);
      return 0;
    }
    AppMethodBeat.o(212255);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pk
 * JD-Core Version:    0.7.0.1
 */