package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class tm
  extends com.tencent.mm.bv.a
{
  public int wLP;
  public int wLQ;
  public int wLR;
  public LinkedList<tl> wLS;
  public b wLT;
  public auv wLU;
  
  public tm()
  {
    AppMethodBeat.i(72843);
    this.wLS = new LinkedList();
    AppMethodBeat.o(72843);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72844);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wLP);
      paramVarArgs.aO(2, this.wLQ);
      paramVarArgs.aO(3, this.wLR);
      paramVarArgs.e(4, 8, this.wLS);
      if (this.wLT != null) {
        paramVarArgs.c(5, this.wLT);
      }
      if (this.wLU != null)
      {
        paramVarArgs.iQ(6, this.wLU.computeSize());
        this.wLU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72844);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wLP) + 0 + e.a.a.b.b.a.bl(2, this.wLQ) + e.a.a.b.b.a.bl(3, this.wLR) + e.a.a.a.c(4, 8, this.wLS);
      paramInt = i;
      if (this.wLT != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.wLT);
      }
      i = paramInt;
      if (this.wLU != null) {
        i = paramInt + e.a.a.a.iP(6, this.wLU.computeSize());
      }
      AppMethodBeat.o(72844);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wLS.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72844);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      tm localtm = (tm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72844);
        return -1;
      case 1: 
        localtm.wLP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72844);
        return 0;
      case 2: 
        localtm.wLQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72844);
        return 0;
      case 3: 
        localtm.wLR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72844);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localtm.wLS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72844);
        return 0;
      case 5: 
        localtm.wLT = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(72844);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new auv();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((auv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localtm.wLU = ((auv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72844);
      return 0;
    }
    AppMethodBeat.o(72844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tm
 * JD-Core Version:    0.7.0.1
 */