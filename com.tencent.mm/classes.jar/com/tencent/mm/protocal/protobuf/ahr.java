package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ahr
  extends dop
{
  public int KZk;
  public cyb Lrv;
  public int Lrw;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lrv == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(152536);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lrv != null)
      {
        paramVarArgs.ni(2, this.Lrv.computeSize());
        this.Lrv.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.KZk);
      paramVarArgs.aM(4, this.Lrw);
      paramVarArgs.aM(5, this.oUv);
      AppMethodBeat.o(152536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lrv != null) {
        i = paramInt + g.a.a.a.nh(2, this.Lrv.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.KZk);
      int j = g.a.a.b.b.a.bu(4, this.Lrw);
      int k = g.a.a.b.b.a.bu(5, this.oUv);
      AppMethodBeat.o(152536);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lrv == null)
        {
          paramVarArgs = new b("Not all required fields were included: Package");
          AppMethodBeat.o(152536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ahr localahr = (ahr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152536);
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
            localahr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localahr.Lrv = ((cyb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 3: 
          localahr.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152536);
          return 0;
        case 4: 
          localahr.Lrw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152536);
          return 0;
        }
        localahr.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152536);
        return 0;
      }
      AppMethodBeat.o(152536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahr
 * JD-Core Version:    0.7.0.1
 */