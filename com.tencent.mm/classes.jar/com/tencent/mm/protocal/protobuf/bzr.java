package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bzr
  extends buy
{
  public int Scene;
  public String ntu;
  public azt wOE;
  public int xLs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80186);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(80186);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOE != null)
      {
        paramVarArgs.iQ(2, this.wOE.computeSize());
        this.wOE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xLs);
      paramVarArgs.aO(4, this.Scene);
      if (this.ntu != null) {
        paramVarArgs.e(5, this.ntu);
      }
      AppMethodBeat.o(80186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOE != null) {
        i = paramInt + e.a.a.a.iP(2, this.wOE.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.xLs) + e.a.a.b.b.a.bl(4, this.Scene);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ntu);
      }
      AppMethodBeat.o(80186);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(80186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bzr localbzr = (bzr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80186);
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
            localbzr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80186);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbzr.wOE = ((azt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80186);
          return 0;
        case 3: 
          localbzr.xLs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80186);
          return 0;
        case 4: 
          localbzr.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80186);
          return 0;
        }
        localbzr.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80186);
        return 0;
      }
      AppMethodBeat.o(80186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzr
 * JD-Core Version:    0.7.0.1
 */