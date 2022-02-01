package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btg
  extends dop
{
  public SKBuiltinBuffer_t LZR;
  public int LZS;
  public int LZT;
  public SKBuiltinBuffer_t LZU;
  public int jfk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63273);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LZR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(63273);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.jfk);
      if (this.LZR != null)
      {
        paramVarArgs.ni(3, this.LZR.computeSize());
        this.LZR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LZS);
      paramVarArgs.aM(5, this.LZT);
      if (this.LZU != null)
      {
        paramVarArgs.ni(6, this.LZU.computeSize());
        this.LZU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.jfk);
      paramInt = i;
      if (this.LZR != null) {
        paramInt = i + g.a.a.a.nh(3, this.LZR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LZS) + g.a.a.b.b.a.bu(5, this.LZT);
      paramInt = i;
      if (this.LZU != null) {
        paramInt = i + g.a.a.a.nh(6, this.LZU.computeSize());
      }
      AppMethodBeat.o(63273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LZR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(63273);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63273);
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
            localbtg.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 2: 
          localbtg.jfk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(63273);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtg.LZR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 4: 
          localbtg.LZS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(63273);
          return 0;
        case 5: 
          localbtg.LZT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(63273);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbtg.LZU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      AppMethodBeat.o(63273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */