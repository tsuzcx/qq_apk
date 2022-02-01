package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bbi
  extends com.tencent.mm.bw.a
{
  public LinkedList<bdo> GaM;
  public b LKL;
  public String LKM;
  public long LKN;
  public long feedId;
  public int pRN;
  public int priority;
  public int type;
  
  public bbi()
  {
    AppMethodBeat.i(184209);
    this.GaM = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.priority);
      paramVarArgs.aM(2, this.type);
      if (this.LKL != null) {
        paramVarArgs.c(3, this.LKL);
      }
      paramVarArgs.e(4, 8, this.GaM);
      if (this.LKM != null) {
        paramVarArgs.e(5, this.LKM);
      }
      paramVarArgs.aM(6, this.pRN);
      paramVarArgs.bb(100, this.feedId);
      paramVarArgs.bb(101, this.LKN);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.priority) + 0 + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.LKL != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LKL);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.GaM);
      paramInt = i;
      if (this.LKM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LKM);
      }
      i = g.a.a.b.b.a.bu(6, this.pRN);
      int j = g.a.a.b.b.a.r(100, this.feedId);
      int k = g.a.a.b.b.a.r(101, this.LKN);
      AppMethodBeat.o(184210);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GaM.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bbi localbbi = (bbi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localbbi.priority = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localbbi.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localbbi.LKL = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bdo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbbi.GaM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localbbi.LKM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 6: 
        localbbi.pRN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localbbi.feedId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(184210);
        return 0;
      }
      localbbi.LKN = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbi
 * JD-Core Version:    0.7.0.1
 */