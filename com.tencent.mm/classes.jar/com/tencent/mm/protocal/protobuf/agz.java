package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agz
  extends com.tencent.mm.bw.a
{
  public aha Gxn;
  public agy Gxo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxn == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Gxo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Gxn != null)
      {
        paramVarArgs.lJ(1, this.Gxn.computeSize());
        this.Gxn.writeFields(paramVarArgs);
      }
      if (this.Gxo != null)
      {
        paramVarArgs.lJ(2, this.Gxo.computeSize());
        this.Gxo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gxn == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.Gxn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gxo != null) {
        i = paramInt + f.a.a.a.lI(2, this.Gxo.computeSize());
      }
      AppMethodBeat.o(152539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gxn == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        if (this.Gxo == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agz localagz = (agz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aha();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagz.Gxn = ((aha)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152539);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagz.Gxo = ((agy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      AppMethodBeat.o(152539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agz
 * JD-Core Version:    0.7.0.1
 */