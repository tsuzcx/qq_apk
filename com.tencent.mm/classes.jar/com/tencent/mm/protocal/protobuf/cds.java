package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cds
  extends com.tencent.mm.bx.a
{
  public bfi DZV;
  public yq DZW;
  public od DZX;
  public int ntg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ntg);
      if (this.DZV != null)
      {
        paramVarArgs.kX(2, this.DZV.computeSize());
        this.DZV.writeFields(paramVarArgs);
      }
      if (this.DZW != null)
      {
        paramVarArgs.kX(3, this.DZW.computeSize());
        this.DZW.writeFields(paramVarArgs);
      }
      if (this.DZX != null)
      {
        paramVarArgs.kX(4, this.DZX.computeSize());
        this.DZX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.ntg) + 0;
      paramInt = i;
      if (this.DZV != null) {
        paramInt = i + f.a.a.a.kW(2, this.DZV.computeSize());
      }
      i = paramInt;
      if (this.DZW != null) {
        i = paramInt + f.a.a.a.kW(3, this.DZW.computeSize());
      }
      paramInt = i;
      if (this.DZX != null) {
        paramInt = i + f.a.a.a.kW(4, this.DZX.computeSize());
      }
      AppMethodBeat.o(195472);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(195472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cds localcds = (cds)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195472);
        return -1;
      case 1: 
        localcds.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(195472);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcds.DZV = ((bfi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195472);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcds.DZW = ((yq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195472);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new od();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((od)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcds.DZX = ((od)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(195472);
      return 0;
    }
    AppMethodBeat.o(195472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */