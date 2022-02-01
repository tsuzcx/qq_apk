package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dno
  extends cld
{
  public int CNq;
  public SKBuiltinBuffer_t CRx;
  public int DdZ;
  public long Dea;
  public dme EEj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.CRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.EEj == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DdZ);
      if (this.CRx != null)
      {
        paramVarArgs.kX(4, this.CRx.computeSize());
        this.CRx.writeFields(paramVarArgs);
      }
      if (this.EEj != null)
      {
        paramVarArgs.kX(5, this.EEj.computeSize());
        this.EEj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.CNq);
      paramVarArgs.aG(8, this.Dea);
      AppMethodBeat.o(115926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(3, this.DdZ);
      paramInt = i;
      if (this.CRx != null) {
        paramInt = i + f.a.a.a.kW(4, this.CRx.computeSize());
      }
      i = paramInt;
      if (this.EEj != null) {
        i = paramInt + f.a.a.a.kW(5, this.EEj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(7, this.CNq);
      int j = f.a.a.b.b.a.q(8, this.Dea);
      AppMethodBeat.o(115926);
      return i + paramInt + j;
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
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.CRx == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.EEj == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dno localdno = (dno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        default: 
          AppMethodBeat.o(115926);
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
            localdno.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 3: 
          localdno.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115926);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdno.CRx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dme();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dme)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdno.EEj = ((dme)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 7: 
          localdno.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115926);
          return 0;
        }
        localdno.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(115926);
        return 0;
      }
      AppMethodBeat.o(115926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dno
 * JD-Core Version:    0.7.0.1
 */