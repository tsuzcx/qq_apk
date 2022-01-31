package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bth
  extends bvk
{
  public int xGN;
  public int xGQ;
  public int xGR;
  public cre xGS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28616);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28616);
        throw paramVarArgs;
      }
      if (this.xGS == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(28616);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xGQ);
      paramVarArgs.aO(3, this.xGR);
      if (this.xGS != null)
      {
        paramVarArgs.iQ(4, this.xGS.computeSize());
        this.xGS.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xGN);
      AppMethodBeat.o(28616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xGQ) + e.a.a.b.b.a.bl(3, this.xGR);
      paramInt = i;
      if (this.xGS != null) {
        paramInt = i + e.a.a.a.iP(4, this.xGS.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xGN);
      AppMethodBeat.o(28616);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28616);
          throw paramVarArgs;
        }
        if (this.xGS == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(28616);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bth localbth = (bth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28616);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbth.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28616);
          return 0;
        case 2: 
          localbth.xGQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28616);
          return 0;
        case 3: 
          localbth.xGR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28616);
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
            for (bool = true; bool; bool = ((cre)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbth.xGS = ((cre)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28616);
          return 0;
        }
        localbth.xGN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28616);
        return 0;
      }
      AppMethodBeat.o(28616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bth
 * JD-Core Version:    0.7.0.1
 */