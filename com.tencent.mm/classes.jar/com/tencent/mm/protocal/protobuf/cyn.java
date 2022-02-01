package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyn
  extends com.tencent.mm.bx.a
{
  public long FMq;
  public btn GRt;
  public String Gxj;
  public int Hpu;
  public LinkedList<dty> Hpv;
  
  public cyn()
  {
    AppMethodBeat.i(117914);
    this.Hpv = new LinkedList();
    AppMethodBeat.o(117914);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxj == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.FMq);
      if (this.Gxj != null) {
        paramVarArgs.d(2, this.Gxj);
      }
      if (this.GRt != null)
      {
        paramVarArgs.lC(3, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Hpu);
      paramVarArgs.e(5, 8, this.Hpv);
      AppMethodBeat.o(117915);
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
      i = paramInt;
      if (this.GRt != null) {
        i = paramInt + f.a.a.a.lB(3, this.GRt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Hpu);
      int j = f.a.a.a.c(5, 8, this.Hpv);
      AppMethodBeat.o(117915);
      return i + paramInt + j;
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
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyn localcyn = (cyn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117915);
        return -1;
      case 1: 
        localcyn.FMq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117915);
        return 0;
      case 2: 
        localcyn.Gxj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117915);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyn.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117915);
        return 0;
      case 4: 
        localcyn.Hpu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117915);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dty();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcyn.Hpv.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    AppMethodBeat.o(117915);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyn
 * JD-Core Version:    0.7.0.1
 */