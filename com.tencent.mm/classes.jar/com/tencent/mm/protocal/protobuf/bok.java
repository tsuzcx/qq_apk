package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bok
  extends buy
{
  public int wQP;
  public bwc xCC;
  public bwc xCD;
  public bwc xCE;
  public int xCF;
  public long xCm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28589);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xCC == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(28589);
        throw paramVarArgs;
      }
      if (this.xCD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(28589);
        throw paramVarArgs;
      }
      if (this.xCE == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(28589);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCC != null)
      {
        paramVarArgs.iQ(2, this.xCC.computeSize());
        this.xCC.writeFields(paramVarArgs);
      }
      if (this.xCD != null)
      {
        paramVarArgs.iQ(3, this.xCD.computeSize());
        this.xCD.writeFields(paramVarArgs);
      }
      if (this.xCE != null)
      {
        paramVarArgs.iQ(4, this.xCE.computeSize());
        this.xCE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.wQP);
      paramVarArgs.am(6, this.xCm);
      paramVarArgs.aO(7, this.xCF);
      AppMethodBeat.o(28589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xCC != null) {
        paramInt = i + e.a.a.a.iP(2, this.xCC.computeSize());
      }
      i = paramInt;
      if (this.xCD != null) {
        i = paramInt + e.a.a.a.iP(3, this.xCD.computeSize());
      }
      paramInt = i;
      if (this.xCE != null) {
        paramInt = i + e.a.a.a.iP(4, this.xCE.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.wQP);
      int j = e.a.a.b.b.a.p(6, this.xCm);
      int k = e.a.a.b.b.a.bl(7, this.xCF);
      AppMethodBeat.o(28589);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xCC == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(28589);
          throw paramVarArgs;
        }
        if (this.xCD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(28589);
          throw paramVarArgs;
        }
        if (this.xCE == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(28589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bok localbok = (bok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28589);
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
            localbok.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28589);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbok.xCC = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28589);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbok.xCD = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28589);
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
            localbok.xCE = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28589);
          return 0;
        case 5: 
          localbok.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28589);
          return 0;
        case 6: 
          localbok.xCm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28589);
          return 0;
        }
        localbok.xCF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28589);
        return 0;
      }
      AppMethodBeat.o(28589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bok
 * JD-Core Version:    0.7.0.1
 */