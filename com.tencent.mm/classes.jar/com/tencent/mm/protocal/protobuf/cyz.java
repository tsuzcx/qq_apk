package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyz
  extends com.tencent.mm.bx.a
{
  public cza EqX;
  public cza EqY;
  public long Id;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.Id);
      paramVarArgs.aR(2, this.mBH);
      if (this.EqX != null)
      {
        paramVarArgs.kX(3, this.EqX.computeSize());
        this.EqX.writeFields(paramVarArgs);
      }
      if (this.EqY != null)
      {
        paramVarArgs.kX(4, this.EqY.computeSize());
        this.EqY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0 + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.EqX != null) {
        paramInt = i + f.a.a.a.kW(3, this.EqX.computeSize());
      }
      i = paramInt;
      if (this.EqY != null) {
        i = paramInt + f.a.a.a.kW(4, this.EqY.computeSize());
      }
      AppMethodBeat.o(118471);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.EqX == null)
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
      cyz localcyz = (cyz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localcyz.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localcyz.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cza();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyz.EqX = ((cza)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cza();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcyz.EqY = ((cza)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    AppMethodBeat.o(118471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyz
 * JD-Core Version:    0.7.0.1
 */