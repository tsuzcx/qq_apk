package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djk
  extends com.tencent.mm.bw.a
{
  public dqi MNA;
  public dqi MNB;
  public dqi MNC;
  public dqi MND;
  public dqi MNE;
  public dqi MNw;
  public dqi MNx;
  public dqi MNy;
  public dqi MNz;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MNx == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNz == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNA == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNB == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MND == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.id);
      if (this.MNw != null)
      {
        paramVarArgs.ni(2, this.MNw.computeSize());
        this.MNw.writeFields(paramVarArgs);
      }
      if (this.MNx != null)
      {
        paramVarArgs.ni(3, this.MNx.computeSize());
        this.MNx.writeFields(paramVarArgs);
      }
      if (this.MNy != null)
      {
        paramVarArgs.ni(4, this.MNy.computeSize());
        this.MNy.writeFields(paramVarArgs);
      }
      if (this.MNz != null)
      {
        paramVarArgs.ni(5, this.MNz.computeSize());
        this.MNz.writeFields(paramVarArgs);
      }
      if (this.MNA != null)
      {
        paramVarArgs.ni(6, this.MNA.computeSize());
        this.MNA.writeFields(paramVarArgs);
      }
      if (this.MNB != null)
      {
        paramVarArgs.ni(7, this.MNB.computeSize());
        this.MNB.writeFields(paramVarArgs);
      }
      if (this.MNC != null)
      {
        paramVarArgs.ni(8, this.MNC.computeSize());
        this.MNC.writeFields(paramVarArgs);
      }
      if (this.MND != null)
      {
        paramVarArgs.ni(9, this.MND.computeSize());
        this.MND.writeFields(paramVarArgs);
      }
      if (this.MNE != null)
      {
        paramVarArgs.ni(10, this.MNE.computeSize());
        this.MNE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.MNw != null) {
        paramInt = i + g.a.a.a.nh(2, this.MNw.computeSize());
      }
      i = paramInt;
      if (this.MNx != null) {
        i = paramInt + g.a.a.a.nh(3, this.MNx.computeSize());
      }
      paramInt = i;
      if (this.MNy != null) {
        paramInt = i + g.a.a.a.nh(4, this.MNy.computeSize());
      }
      i = paramInt;
      if (this.MNz != null) {
        i = paramInt + g.a.a.a.nh(5, this.MNz.computeSize());
      }
      paramInt = i;
      if (this.MNA != null) {
        paramInt = i + g.a.a.a.nh(6, this.MNA.computeSize());
      }
      i = paramInt;
      if (this.MNB != null) {
        i = paramInt + g.a.a.a.nh(7, this.MNB.computeSize());
      }
      paramInt = i;
      if (this.MNC != null) {
        paramInt = i + g.a.a.a.nh(8, this.MNC.computeSize());
      }
      i = paramInt;
      if (this.MND != null) {
        i = paramInt + g.a.a.a.nh(9, this.MND.computeSize());
      }
      paramInt = i;
      if (this.MNE != null) {
        paramInt = i + g.a.a.a.nh(10, this.MNE.computeSize());
      }
      AppMethodBeat.o(32402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MNx == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNz == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNA == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNB == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.MND == null)
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      djk localdjk = (djk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localdjk.id = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNw = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNx = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNy = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNz = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNA = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNB = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MNC = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjk.MND = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdjk.MNE = ((dqi)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djk
 * JD-Core Version:    0.7.0.1
 */