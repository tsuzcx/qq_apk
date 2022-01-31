package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class axy
  extends buy
{
  public String fKw;
  public b jJh;
  public int xmP;
  public int xmQ;
  public dam xmR;
  public String xnc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96266);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.jJh != null) {
        paramVarArgs.c(3, this.jJh);
      }
      if (this.xnc != null) {
        paramVarArgs.e(4, this.xnc);
      }
      paramVarArgs.aO(5, this.xmP);
      paramVarArgs.aO(6, this.xmQ);
      if (this.xmR != null)
      {
        paramVarArgs.iQ(7, this.xmR.computeSize());
        this.xmR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96266);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.jJh);
      }
      paramInt = i;
      if (this.xnc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xnc);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xmP) + e.a.a.b.b.a.bl(6, this.xmQ);
      paramInt = i;
      if (this.xmR != null) {
        paramInt = i + e.a.a.a.iP(7, this.xmR.computeSize());
      }
      AppMethodBeat.o(96266);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96266);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axy localaxy = (axy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96266);
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
            localaxy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96266);
          return 0;
        case 2: 
          localaxy.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96266);
          return 0;
        case 3: 
          localaxy.jJh = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(96266);
          return 0;
        case 4: 
          localaxy.xnc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96266);
          return 0;
        case 5: 
          localaxy.xmP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96266);
          return 0;
        case 6: 
          localaxy.xmQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96266);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dam();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dam)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaxy.xmR = ((dam)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96266);
        return 0;
      }
      AppMethodBeat.o(96266);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axy
 * JD-Core Version:    0.7.0.1
 */