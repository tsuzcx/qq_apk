package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnm
  extends com.tencent.mm.bx.a
{
  public long CNp;
  public String CNs;
  public int CNt;
  public ble DLE;
  public String Dtb;
  public int EhX;
  public LinkedList<dis> EhY;
  public int Scene;
  
  public cnm()
  {
    AppMethodBeat.i(117908);
    this.EhY = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dtb == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.CNp);
      if (this.Dtb != null) {
        paramVarArgs.d(2, this.Dtb);
      }
      paramVarArgs.aR(3, this.CNt);
      if (this.DLE != null)
      {
        paramVarArgs.kX(4, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EhX);
      paramVarArgs.e(6, 8, this.EhY);
      paramVarArgs.aR(7, this.Scene);
      if (this.CNs != null) {
        paramVarArgs.d(8, this.CNs);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.CNp) + 0;
      paramInt = i;
      if (this.Dtb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dtb);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CNt);
      paramInt = i;
      if (this.DLE != null) {
        paramInt = i + f.a.a.a.kW(4, this.DLE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EhX) + f.a.a.a.c(6, 8, this.EhY) + f.a.a.b.b.a.bA(7, this.Scene);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CNs);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EhY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Dtb == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnm localcnm = (cnm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localcnm.CNp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localcnm.Dtb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localcnm.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ble();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnm.DLE = ((ble)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localcnm.EhX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnm.EhY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localcnm.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117909);
        return 0;
      }
      localcnm.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnm
 * JD-Core Version:    0.7.0.1
 */