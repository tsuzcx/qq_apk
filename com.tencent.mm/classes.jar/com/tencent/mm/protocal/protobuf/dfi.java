package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfi
  extends com.tencent.mm.bx.a
{
  public long HtO;
  public dfh HtP;
  public dfh HtQ;
  public long Id;
  public String hCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HtP == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Id);
      paramVarArgs.aY(2, this.HtO);
      if (this.HtP != null)
      {
        paramVarArgs.lC(3, this.HtP.computeSize());
        this.HtP.writeFields(paramVarArgs);
      }
      if (this.HtQ != null)
      {
        paramVarArgs.lC(4, this.HtQ.computeSize());
        this.HtQ.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(5, this.hCW);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.p(2, this.HtO);
      paramInt = i;
      if (this.HtP != null) {
        paramInt = i + f.a.a.a.lB(3, this.HtP.computeSize());
      }
      i = paramInt;
      if (this.HtQ != null) {
        i = paramInt + f.a.a.a.lB(4, this.HtQ.computeSize());
      }
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hCW);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HtP == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dfi localdfi = (dfi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localdfi.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localdfi.HtO = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfi.HtP = ((dfh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfi.HtQ = ((dfh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localdfi.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfi
 * JD-Core Version:    0.7.0.1
 */