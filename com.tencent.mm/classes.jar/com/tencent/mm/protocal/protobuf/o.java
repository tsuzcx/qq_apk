package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class o
  extends bvk
{
  public String cEg;
  public int cnK = 268513600;
  public String kNv = "请求不成功，请稍候再试";
  public String opy;
  public String qjK;
  public String wjY;
  public a wkq;
  public String wkr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56683);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56683);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.opy != null) {
        paramVarArgs.e(4, this.opy);
      }
      if (this.cEg != null) {
        paramVarArgs.e(5, this.cEg);
      }
      if (this.qjK != null) {
        paramVarArgs.e(7, this.qjK);
      }
      if (this.wjY != null) {
        paramVarArgs.e(8, this.wjY);
      }
      if (this.wkq != null)
      {
        paramVarArgs.iQ(9, this.wkq.computeSize());
        this.wkq.writeFields(paramVarArgs);
      }
      if (this.wkr != null) {
        paramVarArgs.e(10, this.wkr);
      }
      AppMethodBeat.o(56683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.opy != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.opy);
      }
      paramInt = i;
      if (this.cEg != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cEg);
      }
      i = paramInt;
      if (this.qjK != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.qjK);
      }
      paramInt = i;
      if (this.wjY != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wjY);
      }
      i = paramInt;
      if (this.wkq != null) {
        i = paramInt + e.a.a.a.iP(9, this.wkq.computeSize());
      }
      paramInt = i;
      if (this.wkr != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wkr);
      }
      AppMethodBeat.o(56683);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56683);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(56683);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56683);
          return 0;
        case 2: 
          localo.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56683);
          return 0;
        case 3: 
          localo.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56683);
          return 0;
        case 4: 
          localo.opy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56683);
          return 0;
        case 5: 
          localo.cEg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56683);
          return 0;
        case 7: 
          localo.qjK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56683);
          return 0;
        case 8: 
          localo.wjY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56683);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localo.wkq = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56683);
          return 0;
        }
        localo.wkr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56683);
        return 0;
      }
      AppMethodBeat.o(56683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.o
 * JD-Core Version:    0.7.0.1
 */