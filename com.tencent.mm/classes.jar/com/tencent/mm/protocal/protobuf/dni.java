package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dni
  extends dop
{
  public ahd LVC;
  public LinkedList<aki> MQB;
  public long rNK;
  public long rNL;
  
  public dni()
  {
    AppMethodBeat.i(220722);
    this.MQB = new LinkedList();
    AppMethodBeat.o(220722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(220723);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.rNK);
      paramVarArgs.bb(3, this.rNL);
      paramVarArgs.e(4, 8, this.MQB);
      if (this.LVC != null)
      {
        paramVarArgs.ni(5, this.LVC.computeSize());
        this.LVC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(220723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.rNK) + g.a.a.b.b.a.r(3, this.rNL) + g.a.a.a.c(4, 8, this.MQB);
      paramInt = i;
      if (this.LVC != null) {
        paramInt = i + g.a.a.a.nh(5, this.LVC.computeSize());
      }
      AppMethodBeat.o(220723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MQB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(220723);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dni localdni = (dni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220723);
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
            localdni.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220723);
          return 0;
        case 2: 
          localdni.rNK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(220723);
          return 0;
        case 3: 
          localdni.rNL = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(220723);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aki();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aki)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdni.MQB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220723);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdni.LVC = ((ahd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220723);
        return 0;
      }
      AppMethodBeat.o(220723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dni
 * JD-Core Version:    0.7.0.1
 */