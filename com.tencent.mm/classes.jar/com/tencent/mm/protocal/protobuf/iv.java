package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iv
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public String jJE;
  public String wuT;
  public String wuY;
  public bdt wuZ;
  public auh wva;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10159);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      if (this.wuY != null) {
        paramVarArgs.e(2, this.wuY);
      }
      if (this.wuZ != null)
      {
        paramVarArgs.iQ(3, this.wuZ.computeSize());
        this.wuZ.writeFields(paramVarArgs);
      }
      if (this.wuT != null) {
        paramVarArgs.e(4, this.wuT);
      }
      if (this.jJE != null) {
        paramVarArgs.e(5, this.jJE);
      }
      if (this.wva != null)
      {
        paramVarArgs.iQ(6, this.wva.computeSize());
        this.wva.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(10159);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.wuY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wuY);
      }
      i = paramInt;
      if (this.wuZ != null) {
        i = paramInt + e.a.a.a.iP(3, this.wuZ.computeSize());
      }
      paramInt = i;
      if (this.wuT != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wuT);
      }
      i = paramInt;
      if (this.jJE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJE);
      }
      paramInt = i;
      if (this.wva != null) {
        paramInt = i + e.a.a.a.iP(6, this.wva.computeSize());
      }
      AppMethodBeat.o(10159);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(10159);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      iv localiv = (iv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(10159);
        return -1;
      case 1: 
        localiv.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10159);
        return 0;
      case 2: 
        localiv.wuY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10159);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdt();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localiv.wuZ = ((bdt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(10159);
        return 0;
      case 4: 
        localiv.wuT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10159);
        return 0;
      case 5: 
        localiv.jJE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10159);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new auh();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localiv.wva = ((auh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(10159);
      return 0;
    }
    AppMethodBeat.o(10159);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */