package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpn
  extends com.tencent.mm.bw.a
{
  public cpm MvE;
  public int MvF;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225976);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      if (this.MvE != null)
      {
        paramVarArgs.ni(2, this.MvE.computeSize());
        this.MvE.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MvF);
      AppMethodBeat.o(225976);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.MvE != null) {
        paramInt = i + g.a.a.a.nh(2, this.MvE.computeSize());
      }
      i = g.a.a.b.b.a.bu(3, this.MvF);
      AppMethodBeat.o(225976);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(225976);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cpn localcpn = (cpn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(225976);
        return -1;
      case 1: 
        localcpn.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225976);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cpm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcpn.MvE = ((cpm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225976);
        return 0;
      }
      localcpn.MvF = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(225976);
      return 0;
    }
    AppMethodBeat.o(225976);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpn
 * JD-Core Version:    0.7.0.1
 */