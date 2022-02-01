package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djy
  extends com.tencent.mm.bx.a
{
  public djz HyK;
  public djz HyL;
  public long Id;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HyK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Id);
      paramVarArgs.aS(2, this.nEf);
      if (this.HyK != null)
      {
        paramVarArgs.lC(3, this.HyK.computeSize());
        this.HyK.writeFields(paramVarArgs);
      }
      if (this.HyL != null)
      {
        paramVarArgs.lC(4, this.HyL.computeSize());
        this.HyL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.bz(2, this.nEf);
      paramInt = i;
      if (this.HyK != null) {
        paramInt = i + f.a.a.a.lB(3, this.HyK.computeSize());
      }
      i = paramInt;
      if (this.HyL != null) {
        i = paramInt + f.a.a.a.lB(4, this.HyL.computeSize());
      }
      AppMethodBeat.o(118471);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HyK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      djy localdjy = (djy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localdjy.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localdjy.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjy.HyK = ((djz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new djz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((djz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdjy.HyL = ((djz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    AppMethodBeat.o(118471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djy
 * JD-Core Version:    0.7.0.1
 */