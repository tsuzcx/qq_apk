package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eha
  extends dop
{
  public SKBuiltinBuffer_t MGc;
  public int MhQ;
  public int MhR;
  public SKBuiltinBuffer_t MhS;
  public String NgK;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MhS == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MhQ);
      paramVarArgs.aM(3, this.MhR);
      if (this.MhS != null)
      {
        paramVarArgs.ni(4, this.MhS.computeSize());
        this.MhS.writeFields(paramVarArgs);
      }
      if (this.MGc != null)
      {
        paramVarArgs.ni(5, this.MGc.computeSize());
        this.MGc.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.e(6, this.sign);
      }
      if (this.NgK != null) {
        paramVarArgs.e(7, this.NgK);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MhQ) + g.a.a.b.b.a.bu(3, this.MhR);
      paramInt = i;
      if (this.MhS != null) {
        paramInt = i + g.a.a.a.nh(4, this.MhS.computeSize());
      }
      i = paramInt;
      if (this.MGc != null) {
        i = paramInt + g.a.a.a.nh(5, this.MGc.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.sign);
      }
      i = paramInt;
      if (this.NgK != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.NgK);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MhS == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eha localeha = (eha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
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
            localeha.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localeha.MhQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localeha.MhR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91711);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeha.MhS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeha.MGc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localeha.sign = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localeha.NgK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eha
 * JD-Core Version:    0.7.0.1
 */