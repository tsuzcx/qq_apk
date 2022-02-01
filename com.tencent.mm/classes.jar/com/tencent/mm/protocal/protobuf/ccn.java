package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccn
  extends com.tencent.mm.bw.a
{
  public LinkedList<ccp> Miu;
  public int major;
  public String uuid;
  
  public ccn()
  {
    AppMethodBeat.i(82427);
    this.Miu = new LinkedList();
    AppMethodBeat.o(82427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.e(1, this.uuid);
      }
      paramVarArgs.aM(2, this.major);
      paramVarArgs.e(3, 8, this.Miu);
      AppMethodBeat.o(82428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.f(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.major);
      int j = g.a.a.a.c(3, 8, this.Miu);
      AppMethodBeat.o(82428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Miu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ccn localccn = (ccn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82428);
          return -1;
        case 1: 
          localccn.uuid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82428);
          return 0;
        case 2: 
          localccn.major = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82428);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localccn.Miu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      AppMethodBeat.o(82428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */