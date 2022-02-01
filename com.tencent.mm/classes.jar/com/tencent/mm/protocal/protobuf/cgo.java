package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgo
  extends com.tencent.mm.bx.a
{
  public cmf Eci;
  public cmf Ecj;
  public cmf Eck;
  public cmf Ecl;
  public cmf Ecm;
  public cmf Ecn;
  public cmf Eco;
  public cmf Ecp;
  public cmf Ecq;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ecj == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Eck == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecl == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecm == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecn == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Eco == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecp == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.id);
      if (this.Eci != null)
      {
        paramVarArgs.kX(2, this.Eci.computeSize());
        this.Eci.writeFields(paramVarArgs);
      }
      if (this.Ecj != null)
      {
        paramVarArgs.kX(3, this.Ecj.computeSize());
        this.Ecj.writeFields(paramVarArgs);
      }
      if (this.Eck != null)
      {
        paramVarArgs.kX(4, this.Eck.computeSize());
        this.Eck.writeFields(paramVarArgs);
      }
      if (this.Ecl != null)
      {
        paramVarArgs.kX(5, this.Ecl.computeSize());
        this.Ecl.writeFields(paramVarArgs);
      }
      if (this.Ecm != null)
      {
        paramVarArgs.kX(6, this.Ecm.computeSize());
        this.Ecm.writeFields(paramVarArgs);
      }
      if (this.Ecn != null)
      {
        paramVarArgs.kX(7, this.Ecn.computeSize());
        this.Ecn.writeFields(paramVarArgs);
      }
      if (this.Eco != null)
      {
        paramVarArgs.kX(8, this.Eco.computeSize());
        this.Eco.writeFields(paramVarArgs);
      }
      if (this.Ecp != null)
      {
        paramVarArgs.kX(9, this.Ecp.computeSize());
        this.Ecp.writeFields(paramVarArgs);
      }
      if (this.Ecq != null)
      {
        paramVarArgs.kX(10, this.Ecq.computeSize());
        this.Ecq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.id) + 0;
      paramInt = i;
      if (this.Eci != null) {
        paramInt = i + f.a.a.a.kW(2, this.Eci.computeSize());
      }
      i = paramInt;
      if (this.Ecj != null) {
        i = paramInt + f.a.a.a.kW(3, this.Ecj.computeSize());
      }
      paramInt = i;
      if (this.Eck != null) {
        paramInt = i + f.a.a.a.kW(4, this.Eck.computeSize());
      }
      i = paramInt;
      if (this.Ecl != null) {
        i = paramInt + f.a.a.a.kW(5, this.Ecl.computeSize());
      }
      paramInt = i;
      if (this.Ecm != null) {
        paramInt = i + f.a.a.a.kW(6, this.Ecm.computeSize());
      }
      i = paramInt;
      if (this.Ecn != null) {
        i = paramInt + f.a.a.a.kW(7, this.Ecn.computeSize());
      }
      paramInt = i;
      if (this.Eco != null) {
        paramInt = i + f.a.a.a.kW(8, this.Eco.computeSize());
      }
      i = paramInt;
      if (this.Ecp != null) {
        i = paramInt + f.a.a.a.kW(9, this.Ecp.computeSize());
      }
      paramInt = i;
      if (this.Ecq != null) {
        paramInt = i + f.a.a.a.kW(10, this.Ecq.computeSize());
      }
      AppMethodBeat.o(32402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Ecj == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Eck == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecl == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecm == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecn == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Eco == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Ecp == null)
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
      cgo localcgo = (cgo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localcgo.id = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Eci = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Ecj = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Eck = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Ecl = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Ecm = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Ecn = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Eco = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgo.Ecp = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cmf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcgo.Ecq = ((cmf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgo
 * JD-Core Version:    0.7.0.1
 */