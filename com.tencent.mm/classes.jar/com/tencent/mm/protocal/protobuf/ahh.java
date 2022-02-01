package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ahh
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahi> KEQ;
  public int cSx;
  public String nHe;
  
  public ahh()
  {
    AppMethodBeat.i(212270);
    this.KEQ = new LinkedList();
    AppMethodBeat.o(212270);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KEQ);
      if (this.nHe != null) {
        paramVarArgs.e(2, this.nHe);
      }
      paramVarArgs.aM(3, this.cSx);
      AppMethodBeat.o(212271);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.KEQ) + 0;
      paramInt = i;
      if (this.nHe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nHe);
      }
      i = g.a.a.b.b.a.bu(3, this.cSx);
      AppMethodBeat.o(212271);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KEQ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212271);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahh localahh = (ahh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212271);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahh.KEQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212271);
        return 0;
      case 2: 
        localahh.nHe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212271);
        return 0;
      }
      localahh.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(212271);
      return 0;
    }
    AppMethodBeat.o(212271);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahh
 * JD-Core Version:    0.7.0.1
 */