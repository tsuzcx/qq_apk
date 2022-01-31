package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbv
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String lGH;
  public int wsK;
  public int xqT;
  public azu xqU;
  public long xqV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124325);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Scene);
      paramVarArgs.aO(2, this.xqT);
      if (this.xqU != null)
      {
        paramVarArgs.iQ(3, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wsK);
      if (this.lGH != null) {
        paramVarArgs.e(5, this.lGH);
      }
      paramVarArgs.am(6, this.xqV);
      AppMethodBeat.o(124325);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Scene) + 0 + e.a.a.b.b.a.bl(2, this.xqT);
      paramInt = i;
      if (this.xqU != null) {
        paramInt = i + e.a.a.a.iP(3, this.xqU.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wsK);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.lGH);
      }
      i = e.a.a.b.b.a.p(6, this.xqV);
      AppMethodBeat.o(124325);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124325);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bbv localbbv = (bbv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124325);
        return -1;
      case 1: 
        localbbv.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124325);
        return 0;
      case 2: 
        localbbv.xqT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124325);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbbv.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124325);
        return 0;
      case 4: 
        localbbv.wsK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124325);
        return 0;
      case 5: 
        localbbv.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124325);
        return 0;
      }
      localbbv.xqV = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(124325);
      return 0;
    }
    AppMethodBeat.o(124325);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbv
 * JD-Core Version:    0.7.0.1
 */