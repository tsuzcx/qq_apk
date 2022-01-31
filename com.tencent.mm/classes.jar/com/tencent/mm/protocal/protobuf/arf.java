package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arf
  extends buy
{
  public int Scene;
  public String npZ;
  public LinkedList<bwc> wou;
  public int xaL;
  
  public arf()
  {
    AppMethodBeat.i(28474);
    this.wou = new LinkedList();
    AppMethodBeat.o(28474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28475);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.npZ != null) {
        paramVarArgs.e(2, this.npZ);
      }
      paramVarArgs.aO(3, this.xaL);
      paramVarArgs.e(4, 8, this.wou);
      paramVarArgs.aO(5, this.Scene);
      AppMethodBeat.o(28475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npZ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npZ);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xaL);
      int j = e.a.a.a.c(4, 8, this.wou);
      int k = e.a.a.b.b.a.bl(5, this.Scene);
      AppMethodBeat.o(28475);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wou.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        arf localarf = (arf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28475);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarf.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28475);
          return 0;
        case 2: 
          localarf.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28475);
          return 0;
        case 3: 
          localarf.xaL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28475);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarf.wou.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28475);
          return 0;
        }
        localarf.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28475);
        return 0;
      }
      AppMethodBeat.o(28475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arf
 * JD-Core Version:    0.7.0.1
 */