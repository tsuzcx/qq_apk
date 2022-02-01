package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btj
  extends dpc
{
  public int KUh;
  public SKBuiltinBuffer_t LXP;
  public String LZY;
  public String LZZ;
  public String Maa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152593);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.LXP == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
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
      paramVarArgs.aM(5, this.KUh);
      if (this.LZY != null) {
        paramVarArgs.e(6, this.LZY);
      }
      if (this.LZZ != null) {
        paramVarArgs.e(7, this.LZZ);
      }
      if (this.Maa != null) {
        paramVarArgs.e(8, this.Maa);
      }
      AppMethodBeat.o(152593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LXP != null) {
        i = paramInt + g.a.a.a.nh(2, this.LXP.computeSize());
      }
      i += g.a.a.b.b.a.bu(5, this.KUh);
      paramInt = i;
      if (this.LZY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LZY);
      }
      i = paramInt;
      if (this.LZZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LZZ);
      }
      paramInt = i;
      if (this.Maa != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Maa);
      }
      AppMethodBeat.o(152593);
      return paramInt;
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
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.LXP == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btj localbtj = (btj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(152593);
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
            localbtj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
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
            localbtj.LXP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localbtj.KUh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localbtj.LZY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localbtj.LZZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localbtj.Maa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */