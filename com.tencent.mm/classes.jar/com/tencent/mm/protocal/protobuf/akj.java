package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class akj
  extends dop
{
  public int Cya;
  public int Scene;
  public String iAc;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220700);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iAc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(220700);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.Scene);
      paramVarArgs.aM(4, this.Cya);
      if (this.iAc != null) {
        paramVarArgs.e(5, this.iAc);
      }
      AppMethodBeat.o(220700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.Scene) + g.a.a.b.b.a.bu(4, this.Cya);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iAc);
      }
      AppMethodBeat.o(220700);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.iAc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(220700);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220700);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        akj localakj = (akj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220700);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localakj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220700);
          return 0;
        case 2: 
          localakj.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220700);
          return 0;
        case 3: 
          localakj.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220700);
          return 0;
        case 4: 
          localakj.Cya = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220700);
          return 0;
        }
        localakj.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(220700);
        return 0;
      }
      AppMethodBeat.o(220700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akj
 * JD-Core Version:    0.7.0.1
 */