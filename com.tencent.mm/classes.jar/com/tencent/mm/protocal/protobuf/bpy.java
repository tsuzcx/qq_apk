package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bpy
  extends dpc
{
  public int KCC;
  public SKBuiltinBuffer_t LXP;
  public int LXQ;
  public SKBuiltinBuffer_t LXR;
  public String LXS;
  public SKBuiltinBuffer_t LXT;
  public String UUID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(232374);
        throw paramVarArgs;
      }
      if (this.LXP == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(232374);
        throw paramVarArgs;
      }
      if (this.LXR == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyKey");
        AppMethodBeat.o(232374);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LXP != null)
      {
        paramVarArgs.ni(2, this.LXP.computeSize());
        this.LXP.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.e(3, this.UUID);
      }
      paramVarArgs.aM(4, this.LXQ);
      if (this.LXR != null)
      {
        paramVarArgs.ni(5, this.LXR.computeSize());
        this.LXR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.KCC);
      if (this.LXS != null) {
        paramVarArgs.e(7, this.LXS);
      }
      if (this.LXT != null)
      {
        paramVarArgs.ni(8, this.LXT.computeSize());
        this.LXT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(232374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LXP != null) {
        paramInt = i + g.a.a.a.nh(2, this.LXP.computeSize());
      }
      i = paramInt;
      if (this.UUID != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UUID);
      }
      i += g.a.a.b.b.a.bu(4, this.LXQ);
      paramInt = i;
      if (this.LXR != null) {
        paramInt = i + g.a.a.a.nh(5, this.LXR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.KCC);
      paramInt = i;
      if (this.LXS != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LXS);
      }
      i = paramInt;
      if (this.LXT != null) {
        i = paramInt + g.a.a.a.nh(8, this.LXT.computeSize());
      }
      AppMethodBeat.o(232374);
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
          AppMethodBeat.o(232374);
          throw paramVarArgs;
        }
        if (this.LXP == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(232374);
          throw paramVarArgs;
        }
        if (this.LXR == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyKey");
          AppMethodBeat.o(232374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(232374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bpy localbpy = (bpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(232374);
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
            localbpy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232374);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpy.LXP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232374);
          return 0;
        case 3: 
          localbpy.UUID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232374);
          return 0;
        case 4: 
          localbpy.LXQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(232374);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpy.LXR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232374);
          return 0;
        case 6: 
          localbpy.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(232374);
          return 0;
        case 7: 
          localbpy.LXS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232374);
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
          localbpy.LXT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232374);
        return 0;
      }
      AppMethodBeat.o(232374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpy
 * JD-Core Version:    0.7.0.1
 */