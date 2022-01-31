package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfx
  extends buy
{
  public String xQA;
  public String xQB;
  public int xQC;
  public int xQD;
  public int xQE;
  public int xQF;
  public cfv xQG;
  public cfv xQH;
  public String xQz;
  public com.tencent.mm.bv.b xpR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146151);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xpR == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(146151);
        throw paramVarArgs;
      }
      if (this.xQz == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(146151);
        throw paramVarArgs;
      }
      if (this.xQA == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(146151);
        throw paramVarArgs;
      }
      if (this.xQB == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(146151);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xpR != null) {
        paramVarArgs.c(2, this.xpR);
      }
      if (this.xQz != null) {
        paramVarArgs.e(3, this.xQz);
      }
      if (this.xQA != null) {
        paramVarArgs.e(4, this.xQA);
      }
      if (this.xQB != null) {
        paramVarArgs.e(5, this.xQB);
      }
      paramVarArgs.aO(6, this.xQC);
      paramVarArgs.aO(7, this.xQD);
      paramVarArgs.aO(8, this.xQE);
      paramVarArgs.aO(9, this.xQF);
      if (this.xQG != null)
      {
        paramVarArgs.iQ(10, this.xQG.computeSize());
        this.xQG.writeFields(paramVarArgs);
      }
      if (this.xQH != null)
      {
        paramVarArgs.iQ(11, this.xQH.computeSize());
        this.xQH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(146151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xpR != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xpR);
      }
      i = paramInt;
      if (this.xQz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xQz);
      }
      paramInt = i;
      if (this.xQA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xQA);
      }
      i = paramInt;
      if (this.xQB != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xQB);
      }
      i = i + e.a.a.b.b.a.bl(6, this.xQC) + e.a.a.b.b.a.bl(7, this.xQD) + e.a.a.b.b.a.bl(8, this.xQE) + e.a.a.b.b.a.bl(9, this.xQF);
      paramInt = i;
      if (this.xQG != null) {
        paramInt = i + e.a.a.a.iP(10, this.xQG.computeSize());
      }
      i = paramInt;
      if (this.xQH != null) {
        i = paramInt + e.a.a.a.iP(11, this.xQH.computeSize());
      }
      AppMethodBeat.o(146151);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xpR == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(146151);
          throw paramVarArgs;
        }
        if (this.xQz == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(146151);
          throw paramVarArgs;
        }
        if (this.xQA == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(146151);
          throw paramVarArgs;
        }
        if (this.xQB == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(146151);
          throw paramVarArgs;
        }
        AppMethodBeat.o(146151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfx localcfx = (cfx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(146151);
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
            localcfx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(146151);
          return 0;
        case 2: 
          localcfx.xpR = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(146151);
          return 0;
        case 3: 
          localcfx.xQz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(146151);
          return 0;
        case 4: 
          localcfx.xQA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(146151);
          return 0;
        case 5: 
          localcfx.xQB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(146151);
          return 0;
        case 6: 
          localcfx.xQC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(146151);
          return 0;
        case 7: 
          localcfx.xQD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(146151);
          return 0;
        case 8: 
          localcfx.xQE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(146151);
          return 0;
        case 9: 
          localcfx.xQF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(146151);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfx.xQG = ((cfv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(146151);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcfx.xQH = ((cfv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(146151);
        return 0;
      }
      AppMethodBeat.o(146151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfx
 * JD-Core Version:    0.7.0.1
 */