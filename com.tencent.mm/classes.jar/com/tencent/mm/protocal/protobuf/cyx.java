package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cyx
  extends dpc
{
  public String AesKey;
  public String LxW;
  public String MDU;
  public int MDY;
  public String MDZ;
  public int MEa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223890);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(223890);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MDU != null) {
        paramVarArgs.e(2, this.MDU);
      }
      if (this.LxW != null) {
        paramVarArgs.e(3, this.LxW);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(4, this.AesKey);
      }
      paramVarArgs.aM(6, this.MDY);
      if (this.MDZ != null) {
        paramVarArgs.e(8, this.MDZ);
      }
      paramVarArgs.aM(9, this.MEa);
      AppMethodBeat.o(223890);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MDU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MDU);
      }
      i = paramInt;
      if (this.LxW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LxW);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.AesKey);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MDY);
      paramInt = i;
      if (this.MDZ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MDZ);
      }
      i = g.a.a.b.b.a.bu(9, this.MEa);
      AppMethodBeat.o(223890);
      return paramInt + i;
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
          AppMethodBeat.o(223890);
          throw paramVarArgs;
        }
        AppMethodBeat.o(223890);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyx localcyx = (cyx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(223890);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(223890);
          return 0;
        case 2: 
          localcyx.MDU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223890);
          return 0;
        case 3: 
          localcyx.LxW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223890);
          return 0;
        case 4: 
          localcyx.AesKey = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223890);
          return 0;
        case 6: 
          localcyx.MDY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(223890);
          return 0;
        case 8: 
          localcyx.MDZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223890);
          return 0;
        }
        localcyx.MEa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(223890);
        return 0;
      }
      AppMethodBeat.o(223890);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyx
 * JD-Core Version:    0.7.0.1
 */