package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dzt
  extends dpc
{
  public int BsF;
  public int BsG;
  public SKBuiltinBuffer_t KMS;
  public String MZo;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125783);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.KMS != null)
      {
        paramVarArgs.ni(4, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      if (this.MZo != null) {
        paramVarArgs.e(5, this.MZo);
      }
      paramVarArgs.aM(6, this.oUv);
      AppMethodBeat.o(125783);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(4, this.KMS.computeSize());
      }
      i = paramInt;
      if (this.MZo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MZo);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.oUv);
      AppMethodBeat.o(125783);
      return i + paramInt;
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
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        if (this.KMS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125783);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzt localdzt = (dzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125783);
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
            localdzt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 2: 
          localdzt.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125783);
          return 0;
        case 3: 
          localdzt.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125783);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzt.KMS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 5: 
          localdzt.MZo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125783);
          return 0;
        }
        localdzt.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125783);
        return 0;
      }
      AppMethodBeat.o(125783);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzt
 * JD-Core Version:    0.7.0.1
 */