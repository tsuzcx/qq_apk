package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dge
  extends dpc
{
  public int KCC;
  public int LXQ;
  public SKBuiltinBuffer_t LXR;
  public String LXS;
  public SKBuiltinBuffer_t LXT;
  public String UUID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232381);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(232381);
        throw paramVarArgs;
      }
      if (this.LXR == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyKey");
        AppMethodBeat.o(232381);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.e(2, this.UUID);
      }
      if (this.LXR != null)
      {
        paramVarArgs.ni(3, this.LXR.computeSize());
        this.LXR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LXQ);
      paramVarArgs.aM(5, this.KCC);
      if (this.LXS != null) {
        paramVarArgs.e(6, this.LXS);
      }
      if (this.LXT != null)
      {
        paramVarArgs.ni(7, this.LXT.computeSize());
        this.LXT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(232381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UUID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UUID);
      }
      i = paramInt;
      if (this.LXR != null) {
        i = paramInt + g.a.a.a.nh(3, this.LXR.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(4, this.LXQ) + g.a.a.b.b.a.bu(5, this.KCC);
      paramInt = i;
      if (this.LXS != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LXS);
      }
      i = paramInt;
      if (this.LXT != null) {
        i = paramInt + g.a.a.a.nh(7, this.LXT.computeSize());
      }
      AppMethodBeat.o(232381);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(232381);
          throw paramVarArgs;
        }
        if (this.LXR == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyKey");
          AppMethodBeat.o(232381);
          throw paramVarArgs;
        }
        AppMethodBeat.o(232381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dge localdge = (dge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(232381);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdge.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232381);
          return 0;
        case 2: 
          localdge.UUID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232381);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdge.LXR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232381);
          return 0;
        case 4: 
          localdge.LXQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(232381);
          return 0;
        case 5: 
          localdge.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(232381);
          return 0;
        case 6: 
          localdge.LXS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232381);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdge.LXT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232381);
        return 0;
      }
      AppMethodBeat.o(232381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dge
 * JD-Core Version:    0.7.0.1
 */