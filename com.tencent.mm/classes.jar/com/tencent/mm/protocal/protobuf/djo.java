package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djo
  extends cld
{
  public SKBuiltinBuffer_t CBe;
  public String CBj;
  public SKBuiltinBuffer_t CBk;
  public cmf CGw;
  public SKBuiltinBuffer_t CGx;
  public SKBuiltinBuffer_t CxB;
  public String Ddo;
  public cmf DzX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.DzX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DzX != null)
      {
        paramVarArgs.kX(2, this.DzX.computeSize());
        this.DzX.writeFields(paramVarArgs);
      }
      if (this.CxB != null)
      {
        paramVarArgs.kX(3, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(4, this.Ddo);
      }
      if (this.CGw != null)
      {
        paramVarArgs.kX(5, this.CGw.computeSize());
        this.CGw.writeFields(paramVarArgs);
      }
      if (this.CBk != null)
      {
        paramVarArgs.kX(6, this.CBk.computeSize());
        this.CBk.writeFields(paramVarArgs);
      }
      if (this.CGx != null)
      {
        paramVarArgs.kX(7, this.CGx.computeSize());
        this.CGx.writeFields(paramVarArgs);
      }
      if (this.CBj != null) {
        paramVarArgs.d(8, this.CBj);
      }
      if (this.CBe != null)
      {
        paramVarArgs.kX(9, this.CBe.computeSize());
        this.CBe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DzX != null) {
        paramInt = i + f.a.a.a.kW(2, this.DzX.computeSize());
      }
      i = paramInt;
      if (this.CxB != null) {
        i = paramInt + f.a.a.a.kW(3, this.CxB.computeSize());
      }
      paramInt = i;
      if (this.Ddo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ddo);
      }
      i = paramInt;
      if (this.CGw != null) {
        i = paramInt + f.a.a.a.kW(5, this.CGw.computeSize());
      }
      paramInt = i;
      if (this.CBk != null) {
        paramInt = i + f.a.a.a.kW(6, this.CBk.computeSize());
      }
      i = paramInt;
      if (this.CGx != null) {
        i = paramInt + f.a.a.a.kW(7, this.CGx.computeSize());
      }
      paramInt = i;
      if (this.CBj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CBj);
      }
      i = paramInt;
      if (this.CBe != null) {
        i = paramInt + f.a.a.a.kW(9, this.CBe.computeSize());
      }
      AppMethodBeat.o(43134);
      return i;
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
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.DzX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djo localdjo = (djo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43134);
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
            localdjo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjo.DzX = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjo.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 4: 
          localdjo.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43134);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjo.CGw = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjo.CBk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjo.CGx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 8: 
          localdjo.CBj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43134);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjo.CBe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      AppMethodBeat.o(43134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djo
 * JD-Core Version:    0.7.0.1
 */