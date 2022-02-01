package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adu
  extends com.tencent.mm.bw.a
{
  public String Lpm;
  public LinkedList<ua> iAd;
  
  public adu()
  {
    AppMethodBeat.i(201328);
    this.iAd = new LinkedList();
    AppMethodBeat.o(201328);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201329);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpm != null) {
        paramVarArgs.e(1, this.Lpm);
      }
      paramVarArgs.e(2, 8, this.iAd);
      AppMethodBeat.o(201329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lpm == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lpm) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.iAd);
      AppMethodBeat.o(201329);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iAd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201329);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201329);
          return -1;
        case 1: 
          localadu.Lpm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201329);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ua();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadu.iAd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201329);
        return 0;
      }
      AppMethodBeat.o(201329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */