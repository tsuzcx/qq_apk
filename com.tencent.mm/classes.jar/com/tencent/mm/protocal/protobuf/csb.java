package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csb
  extends cpx
{
  public cge FEC;
  public float FED;
  public float FEE;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152679);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FEC == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPos");
        AppMethodBeat.o(152679);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FEC != null)
      {
        paramVarArgs.ln(2, this.FEC.computeSize());
        this.FEC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.x(4, this.FED);
      paramVarArgs.x(5, this.FEE);
      AppMethodBeat.o(152679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FEC != null) {
        i = paramInt + f.a.a.a.lm(2, this.FEC.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Scene);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(152679);
      return i + paramInt + (j + 4) + (k + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FEC == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csb localcsb = (csb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152679);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cge();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cge)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.FEC = ((cge)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 3: 
          localcsb.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152679);
          return 0;
        case 4: 
          localcsb.FED = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(152679);
          return 0;
        }
        localcsb.FEE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
        AppMethodBeat.o(152679);
        return 0;
      }
      AppMethodBeat.o(152679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csb
 * JD-Core Version:    0.7.0.1
 */