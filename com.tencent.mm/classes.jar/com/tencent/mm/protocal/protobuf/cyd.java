package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyd
  extends com.tencent.mm.bx.a
{
  public long FMq;
  public String FMt;
  public int FMu;
  public btn GRt;
  public String Gxj;
  public int Hpu;
  public LinkedList<dty> Hpv;
  public int Scene;
  
  public cyd()
  {
    AppMethodBeat.i(117908);
    this.Hpv = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxj == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.FMq);
      if (this.Gxj != null) {
        paramVarArgs.d(2, this.Gxj);
      }
      paramVarArgs.aS(3, this.FMu);
      if (this.GRt != null)
      {
        paramVarArgs.lC(4, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hpu);
      paramVarArgs.e(6, 8, this.Hpv);
      paramVarArgs.aS(7, this.Scene);
      if (this.FMt != null) {
        paramVarArgs.d(8, this.FMt);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FMq) + 0;
      paramInt = i;
      if (this.Gxj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gxj);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FMu);
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.a.lB(4, this.GRt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hpu) + f.a.a.a.c(6, 8, this.Hpv) + f.a.a.b.b.a.bz(7, this.Scene);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FMt);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hpv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Gxj == null)
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
      cyd localcyd = (cyd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localcyd.FMq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localcyd.Gxj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localcyd.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyd.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localcyd.Hpu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dty();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyd.Hpv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localcyd.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117909);
        return 0;
      }
      localcyd.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyd
 * JD-Core Version:    0.7.0.1
 */