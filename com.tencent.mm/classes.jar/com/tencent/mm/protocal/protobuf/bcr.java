package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcr
  extends cqk
{
  public int ESL;
  public SKBuiltinBuffer_t ESM;
  public String ESN;
  public String ESO;
  public String ESP;
  
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
      if (this.ESM == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ESM != null)
      {
        paramVarArgs.ln(2, this.ESM.computeSize());
        this.ESM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ESL);
      if (this.ESN != null) {
        paramVarArgs.d(6, this.ESN);
      }
      if (this.ESO != null) {
        paramVarArgs.d(7, this.ESO);
      }
      if (this.ESP != null) {
        paramVarArgs.d(8, this.ESP);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ESM != null) {
        i = paramInt + f.a.a.a.lm(2, this.ESM.computeSize());
      }
      i += f.a.a.b.b.a.bx(5, this.ESL);
      paramInt = i;
      if (this.ESN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ESN);
      }
      i = paramInt;
      if (this.ESO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ESO);
      }
      paramInt = i;
      if (this.ESP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ESP);
      }
      AppMethodBeat.o(152593);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.ESM == null)
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
        bcr localbcr = (bcr)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcr.ESM = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localbcr.ESL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localbcr.ESN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localbcr.ESO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localbcr.ESP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcr
 * JD-Core Version:    0.7.0.1
 */