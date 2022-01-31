package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class rh
  extends bvk
{
  public int cnK;
  public String kNv;
  public String qgu;
  public String qgv;
  public String qgw;
  public String wry;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48815);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48815);
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
      if (this.qgu != null) {
        paramVarArgs.e(4, this.qgu);
      }
      if (this.qgv != null) {
        paramVarArgs.e(5, this.qgv);
      }
      if (this.qgw != null) {
        paramVarArgs.e(6, this.qgw);
      }
      if (this.wry != null) {
        paramVarArgs.e(7, this.wry);
      }
      AppMethodBeat.o(48815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.qgu != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.qgu);
      }
      paramInt = i;
      if (this.qgv != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.qgv);
      }
      i = paramInt;
      if (this.qgw != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qgw);
      }
      paramInt = i;
      if (this.wry != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wry);
      }
      AppMethodBeat.o(48815);
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
          AppMethodBeat.o(48815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rh localrh = (rh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48815);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localrh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48815);
          return 0;
        case 2: 
          localrh.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48815);
          return 0;
        case 3: 
          localrh.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48815);
          return 0;
        case 4: 
          localrh.qgu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48815);
          return 0;
        case 5: 
          localrh.qgv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48815);
          return 0;
        case 6: 
          localrh.qgw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48815);
          return 0;
        }
        localrh.wry = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48815);
        return 0;
      }
      AppMethodBeat.o(48815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */