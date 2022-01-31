package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yl
  extends com.tencent.mm.bv.a
{
  public String title;
  public int type;
  public uc wCD;
  public bvz wna;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48839);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.wna != null)
      {
        paramVarArgs.iQ(3, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      if (this.wCD != null)
      {
        paramVarArgs.iQ(4, this.wCD.computeSize());
        this.wCD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48839);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.wna != null) {
        i = paramInt + e.a.a.a.iP(3, this.wna.computeSize());
      }
      paramInt = i;
      if (this.wCD != null) {
        paramInt = i + e.a.a.a.iP(4, this.wCD.computeSize());
      }
      AppMethodBeat.o(48839);
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
      AppMethodBeat.o(48839);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      yl localyl = (yl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48839);
        return -1;
      case 1: 
        localyl.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48839);
        return 0;
      case 2: 
        localyl.title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48839);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyl.wna = ((bvz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48839);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new uc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localyl.wCD = ((uc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48839);
      return 0;
    }
    AppMethodBeat.o(48839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yl
 * JD-Core Version:    0.7.0.1
 */