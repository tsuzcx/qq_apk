package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfq
  extends dop
{
  public int LsZ;
  public dqi MKA;
  public int MKB;
  public long MKi;
  public dqi MKy;
  public dqi MKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MKy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.MKz == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.MKA == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKy != null)
      {
        paramVarArgs.ni(2, this.MKy.computeSize());
        this.MKy.writeFields(paramVarArgs);
      }
      if (this.MKz != null)
      {
        paramVarArgs.ni(3, this.MKz.computeSize());
        this.MKz.writeFields(paramVarArgs);
      }
      if (this.MKA != null)
      {
        paramVarArgs.ni(4, this.MKA.computeSize());
        this.MKA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.LsZ);
      paramVarArgs.bb(6, this.MKi);
      paramVarArgs.aM(7, this.MKB);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MKy != null) {
        paramInt = i + g.a.a.a.nh(2, this.MKy.computeSize());
      }
      i = paramInt;
      if (this.MKz != null) {
        i = paramInt + g.a.a.a.nh(3, this.MKz.computeSize());
      }
      paramInt = i;
      if (this.MKA != null) {
        paramInt = i + g.a.a.a.nh(4, this.MKA.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.LsZ);
      int j = g.a.a.b.b.a.r(6, this.MKi);
      int k = g.a.a.b.b.a.bu(7, this.MKB);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MKy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.MKz == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.MKA == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfq localdfq = (dfq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
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
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfq.MKy = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
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
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfq.MKz = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
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
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfq.MKA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localdfq.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localdfq.MKi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32386);
          return 0;
        }
        localdfq.MKB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfq
 * JD-Core Version:    0.7.0.1
 */