package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkt
  extends com.tencent.mm.bw.a
{
  public dku HSv;
  public dku HSw;
  public long Id;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.Id);
      paramVarArgs.aS(2, this.nJA);
      if (this.HSv != null)
      {
        paramVarArgs.lJ(3, this.HSv.computeSize());
        this.HSv.writeFields(paramVarArgs);
      }
      if (this.HSw != null)
      {
        paramVarArgs.lJ(4, this.HSw.computeSize());
        this.HSw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.HSv != null) {
        paramInt = i + f.a.a.a.lI(3, this.HSv.computeSize());
      }
      i = paramInt;
      if (this.HSw != null) {
        i = paramInt + f.a.a.a.lI(4, this.HSw.computeSize());
      }
      AppMethodBeat.o(118471);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HSv == null)
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
      dkt localdkt = (dkt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localdkt.Id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localdkt.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dku();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkt.HSv = ((dku)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dku();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkt.HSw = ((dku)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkt
 * JD-Core Version:    0.7.0.1
 */