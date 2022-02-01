package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class crl
  extends com.tencent.mm.bw.a
{
  public cxn HCI;
  public cxn HCJ;
  public cxn HCK;
  public cxn HCL;
  public cxn HCM;
  public cxn HCN;
  public cxn HCO;
  public cxn HCP;
  public cxn HCQ;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCK == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCL == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCM == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCN == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCO == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCP == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.id);
      if (this.HCI != null)
      {
        paramVarArgs.lJ(2, this.HCI.computeSize());
        this.HCI.writeFields(paramVarArgs);
      }
      if (this.HCJ != null)
      {
        paramVarArgs.lJ(3, this.HCJ.computeSize());
        this.HCJ.writeFields(paramVarArgs);
      }
      if (this.HCK != null)
      {
        paramVarArgs.lJ(4, this.HCK.computeSize());
        this.HCK.writeFields(paramVarArgs);
      }
      if (this.HCL != null)
      {
        paramVarArgs.lJ(5, this.HCL.computeSize());
        this.HCL.writeFields(paramVarArgs);
      }
      if (this.HCM != null)
      {
        paramVarArgs.lJ(6, this.HCM.computeSize());
        this.HCM.writeFields(paramVarArgs);
      }
      if (this.HCN != null)
      {
        paramVarArgs.lJ(7, this.HCN.computeSize());
        this.HCN.writeFields(paramVarArgs);
      }
      if (this.HCO != null)
      {
        paramVarArgs.lJ(8, this.HCO.computeSize());
        this.HCO.writeFields(paramVarArgs);
      }
      if (this.HCP != null)
      {
        paramVarArgs.lJ(9, this.HCP.computeSize());
        this.HCP.writeFields(paramVarArgs);
      }
      if (this.HCQ != null)
      {
        paramVarArgs.lJ(10, this.HCQ.computeSize());
        this.HCQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.HCI != null) {
        paramInt = i + f.a.a.a.lI(2, this.HCI.computeSize());
      }
      i = paramInt;
      if (this.HCJ != null) {
        i = paramInt + f.a.a.a.lI(3, this.HCJ.computeSize());
      }
      paramInt = i;
      if (this.HCK != null) {
        paramInt = i + f.a.a.a.lI(4, this.HCK.computeSize());
      }
      i = paramInt;
      if (this.HCL != null) {
        i = paramInt + f.a.a.a.lI(5, this.HCL.computeSize());
      }
      paramInt = i;
      if (this.HCM != null) {
        paramInt = i + f.a.a.a.lI(6, this.HCM.computeSize());
      }
      i = paramInt;
      if (this.HCN != null) {
        i = paramInt + f.a.a.a.lI(7, this.HCN.computeSize());
      }
      paramInt = i;
      if (this.HCO != null) {
        paramInt = i + f.a.a.a.lI(8, this.HCO.computeSize());
      }
      i = paramInt;
      if (this.HCP != null) {
        i = paramInt + f.a.a.a.lI(9, this.HCP.computeSize());
      }
      paramInt = i;
      if (this.HCQ != null) {
        paramInt = i + f.a.a.a.lI(10, this.HCQ.computeSize());
      }
      AppMethodBeat.o(32402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HCJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCK == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCL == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCM == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCN == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCO == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.HCP == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      crl localcrl = (crl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localcrl.id = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCI = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCJ = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCK = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCL = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCM = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCN = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCO = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrl.HCP = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcrl.HCQ = ((cxn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crl
 * JD-Core Version:    0.7.0.1
 */