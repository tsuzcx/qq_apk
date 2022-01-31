package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bsy
  extends buy
{
  public int jKs;
  public int nrR;
  public String wQX;
  public cpm xGA;
  public clf xGB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113789);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xGA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(113789);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wQX != null) {
        paramVarArgs.e(2, this.wQX);
      }
      paramVarArgs.aO(3, this.jKs);
      if (this.xGA != null)
      {
        paramVarArgs.iQ(4, this.xGA.computeSize());
        this.xGA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.nrR);
      if (this.xGB != null)
      {
        paramVarArgs.iQ(6, this.xGB.computeSize());
        this.xGB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQX != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wQX);
      }
      i += e.a.a.b.b.a.bl(3, this.jKs);
      paramInt = i;
      if (this.xGA != null) {
        paramInt = i + e.a.a.a.iP(4, this.xGA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.nrR);
      paramInt = i;
      if (this.xGB != null) {
        paramInt = i + e.a.a.a.iP(6, this.xGB.computeSize());
      }
      AppMethodBeat.o(113789);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xGA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(113789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113789);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsy localbsy = (bsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113789);
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
            localbsy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113789);
          return 0;
        case 2: 
          localbsy.wQX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113789);
          return 0;
        case 3: 
          localbsy.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113789);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbsy.xGA = ((cpm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113789);
          return 0;
        case 5: 
          localbsy.nrR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113789);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbsy.xGB = ((clf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113789);
        return 0;
      }
      AppMethodBeat.o(113789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsy
 * JD-Core Version:    0.7.0.1
 */