package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqx
  extends dop
{
  public ddi MTE;
  public float MTF;
  public float MTG;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152679);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MTE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPos");
        AppMethodBeat.o(152679);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MTE != null)
      {
        paramVarArgs.ni(2, this.MTE.computeSize());
        this.MTE.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Scene);
      paramVarArgs.E(4, this.MTF);
      paramVarArgs.E(5, this.MTG);
      AppMethodBeat.o(152679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MTE != null) {
        i = paramInt + g.a.a.a.nh(2, this.MTE.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Scene);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(152679);
      return i + paramInt + (j + 4) + (k + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MTE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPos");
          AppMethodBeat.o(152679);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqx localdqx = (dqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152679);
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
            localdqx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdqx.MTE = ((ddi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 3: 
          localdqx.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152679);
          return 0;
        case 4: 
          localdqx.MTF = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(152679);
          return 0;
        }
        localdqx.MTG = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(152679);
        return 0;
      }
      AppMethodBeat.o(152679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqx
 * JD-Core Version:    0.7.0.1
 */