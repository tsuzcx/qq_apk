package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mk
  extends com.tencent.mm.bv.a
{
  public LinkedList<adh> wAS;
  public LinkedList<adg> wAT;
  public String wAU;
  public String wAV;
  public String wAW;
  
  public mk()
  {
    AppMethodBeat.i(56718);
    this.wAS = new LinkedList();
    this.wAT = new LinkedList();
    AppMethodBeat.o(56718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56719);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wAS);
      paramVarArgs.e(2, 8, this.wAT);
      if (this.wAU != null) {
        paramVarArgs.e(3, this.wAU);
      }
      if (this.wAV != null) {
        paramVarArgs.e(4, this.wAV);
      }
      if (this.wAW != null) {
        paramVarArgs.e(5, this.wAW);
      }
      AppMethodBeat.o(56719);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.wAS) + 0 + e.a.a.a.c(2, 8, this.wAT);
      paramInt = i;
      if (this.wAU != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wAU);
      }
      i = paramInt;
      if (this.wAV != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wAV);
      }
      paramInt = i;
      if (this.wAW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wAW);
      }
      AppMethodBeat.o(56719);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wAS.clear();
      this.wAT.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56719);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      mk localmk = (mk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56719);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localmk.wAS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56719);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localmk.wAT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56719);
        return 0;
      case 3: 
        localmk.wAU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56719);
        return 0;
      case 4: 
        localmk.wAV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56719);
        return 0;
      }
      localmk.wAW = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56719);
      return 0;
    }
    AppMethodBeat.o(56719);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */