package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbl
  extends cld
{
  public SKBuiltinBuffer_t DEv;
  public int DEw;
  public String DEx;
  public int DEy;
  public int DWF;
  public String DWG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91712);
        throw paramVarArgs;
      }
      if (this.DEv == null)
      {
        paramVarArgs = new b("Not all required fields were included: RetText");
        AppMethodBeat.o(91712);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DEv != null)
      {
        paramVarArgs.kX(2, this.DEv.computeSize());
        this.DEv.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DEw);
      if (this.DEx != null) {
        paramVarArgs.d(4, this.DEx);
      }
      paramVarArgs.aR(5, this.DEy);
      paramVarArgs.aR(6, this.DWF);
      if (this.DWG != null) {
        paramVarArgs.d(7, this.DWG);
      }
      AppMethodBeat.o(91712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DEv != null) {
        i = paramInt + f.a.a.a.kW(2, this.DEv.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.DEw);
      paramInt = i;
      if (this.DEx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DEx);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DEy) + f.a.a.b.b.a.bA(6, this.DWF);
      paramInt = i;
      if (this.DWG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DWG);
      }
      AppMethodBeat.o(91712);
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
          AppMethodBeat.o(91712);
          throw paramVarArgs;
        }
        if (this.DEv == null)
        {
          paramVarArgs = new b("Not all required fields were included: RetText");
          AppMethodBeat.o(91712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbl localdbl = (dbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91712);
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
            localdbl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91712);
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
            localdbl.DEv = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91712);
          return 0;
        case 3: 
          localdbl.DEw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91712);
          return 0;
        case 4: 
          localdbl.DEx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91712);
          return 0;
        case 5: 
          localdbl.DEy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91712);
          return 0;
        case 6: 
          localdbl.DWF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91712);
          return 0;
        }
        localdbl.DWG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91712);
        return 0;
      }
      AppMethodBeat.o(91712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbl
 * JD-Core Version:    0.7.0.1
 */