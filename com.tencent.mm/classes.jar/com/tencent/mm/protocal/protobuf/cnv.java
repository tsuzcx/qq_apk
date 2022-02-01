package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnv
  extends com.tencent.mm.bx.a
{
  public bni HgV;
  public abl HgW;
  public pp HgX;
  public int ozA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ozA);
      if (this.HgV != null)
      {
        paramVarArgs.lC(2, this.HgV.computeSize());
        this.HgV.writeFields(paramVarArgs);
      }
      if (this.HgW != null)
      {
        paramVarArgs.lC(3, this.HgW.computeSize());
        this.HgW.writeFields(paramVarArgs);
      }
      if (this.HgX != null)
      {
        paramVarArgs.lC(4, this.HgX.computeSize());
        this.HgX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209413);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ozA) + 0;
      paramInt = i;
      if (this.HgV != null) {
        paramInt = i + f.a.a.a.lB(2, this.HgV.computeSize());
      }
      i = paramInt;
      if (this.HgW != null) {
        i = paramInt + f.a.a.a.lB(3, this.HgW.computeSize());
      }
      paramInt = i;
      if (this.HgX != null) {
        paramInt = i + f.a.a.a.lB(4, this.HgX.computeSize());
      }
      AppMethodBeat.o(209413);
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
      AppMethodBeat.o(209413);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnv localcnv = (cnv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209413);
        return -1;
      case 1: 
        localcnv.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209413);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bni();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnv.HgV = ((bni)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209413);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnv.HgW = ((abl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209413);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcnv.HgX = ((pp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209413);
      return 0;
    }
    AppMethodBeat.o(209413);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnv
 * JD-Core Version:    0.7.0.1
 */