package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cgy
  extends buy
{
  public String pIw;
  public String wqN;
  public cgw xRL;
  public cgw xRM;
  public int xRN;
  public int xRO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56504);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xRL == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(56504);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(2, this.pIw);
      }
      if (this.xRL != null)
      {
        paramVarArgs.iQ(3, this.xRL.computeSize());
        this.xRL.writeFields(paramVarArgs);
      }
      if (this.xRM != null)
      {
        paramVarArgs.iQ(6, this.xRM.computeSize());
        this.xRM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xRN);
      paramVarArgs.aO(5, this.xRO);
      if (this.wqN != null) {
        paramVarArgs.e(7, this.wqN);
      }
      AppMethodBeat.o(56504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pIw);
      }
      i = paramInt;
      if (this.xRL != null) {
        i = paramInt + e.a.a.a.iP(3, this.xRL.computeSize());
      }
      paramInt = i;
      if (this.xRM != null) {
        paramInt = i + e.a.a.a.iP(6, this.xRM.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xRN) + e.a.a.b.b.a.bl(5, this.xRO);
      paramInt = i;
      if (this.wqN != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wqN);
      }
      AppMethodBeat.o(56504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xRL == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(56504);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56504);
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
            localcgy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56504);
          return 0;
        case 2: 
          localcgy.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56504);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgy.xRL = ((cgw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56504);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgy.xRM = ((cgw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56504);
          return 0;
        case 4: 
          localcgy.xRN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56504);
          return 0;
        case 5: 
          localcgy.xRO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56504);
          return 0;
        }
        localcgy.wqN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56504);
        return 0;
      }
      AppMethodBeat.o(56504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */