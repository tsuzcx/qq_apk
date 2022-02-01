package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pz
  extends com.tencent.mm.bw.a
{
  public int KWQ;
  public int KWR;
  public LinkedList<qa> KWS;
  public int type;
  public int uin;
  public int version;
  
  public pz()
  {
    AppMethodBeat.i(124455);
    this.KWS = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uin);
      paramVarArgs.aM(2, this.KWQ);
      paramVarArgs.aM(3, this.KWR);
      paramVarArgs.e(4, 8, this.KWS);
      paramVarArgs.aM(5, this.version);
      paramVarArgs.aM(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.uin);
      i = g.a.a.b.b.a.bu(2, this.KWQ);
      int j = g.a.a.b.b.a.bu(3, this.KWR);
      int k = g.a.a.a.c(4, 8, this.KWS);
      int m = g.a.a.b.b.a.bu(5, this.version);
      int n = g.a.a.b.b.a.bu(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KWS.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      pz localpz = (pz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localpz.uin = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localpz.KWQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localpz.KWR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qa();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localpz.KWS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localpz.version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124456);
        return 0;
      }
      localpz.type = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */