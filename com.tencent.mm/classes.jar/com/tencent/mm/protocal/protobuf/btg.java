package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class btg
  extends buy
{
  public int jKr;
  public int xGN;
  public cre xGO;
  public int xGP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28615);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xGO == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(28615);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jKr);
      paramVarArgs.aO(3, this.xGN);
      if (this.xGO != null)
      {
        paramVarArgs.iQ(4, this.xGO.computeSize());
        this.xGO.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xGP);
      AppMethodBeat.o(28615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label657;
      }
    }
    label657:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKr) + e.a.a.b.b.a.bl(3, this.xGN);
      paramInt = i;
      if (this.xGO != null) {
        paramInt = i + e.a.a.a.iP(4, this.xGO.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xGP);
      AppMethodBeat.o(28615);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xGO == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(28615);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28615);
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
            localbtg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28615);
          return 0;
        case 2: 
          localbtg.jKr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28615);
          return 0;
        case 3: 
          localbtg.xGN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28615);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cre();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cre)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbtg.xGO = ((cre)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28615);
          return 0;
        }
        localbtg.xGP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28615);
        return 0;
      }
      AppMethodBeat.o(28615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */