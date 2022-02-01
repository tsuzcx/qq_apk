package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayz
  extends cld
{
  public int Dxp;
  public SKBuiltinBuffer_t Dxq;
  public String Dxr;
  public String Dxs;
  public String Dxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152593);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.Dxq == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dxq != null)
      {
        paramVarArgs.kX(2, this.Dxq.computeSize());
        this.Dxq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Dxp);
      if (this.Dxr != null) {
        paramVarArgs.d(6, this.Dxr);
      }
      if (this.Dxs != null) {
        paramVarArgs.d(7, this.Dxs);
      }
      if (this.Dxt != null) {
        paramVarArgs.d(8, this.Dxt);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dxq != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dxq.computeSize());
      }
      i += f.a.a.b.b.a.bA(5, this.Dxp);
      paramInt = i;
      if (this.Dxr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dxr);
      }
      i = paramInt;
      if (this.Dxs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Dxs);
      }
      paramInt = i;
      if (this.Dxt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dxt);
      }
      AppMethodBeat.o(152593);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.Dxq == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayz localayz = (ayz)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayz.Dxq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localayz.Dxp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localayz.Dxr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localayz.Dxs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localayz.Dxt = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayz
 * JD-Core Version:    0.7.0.1
 */