package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class m
  extends bvk
{
  public int cnK = 268513600;
  public String kNG;
  public String kNH;
  public String kNv = "请求不成功，请稍候再试";
  public int wkk;
  public int wkl;
  public int wkm;
  public long wkn;
  public long wko;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56681);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56681);
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
      paramVarArgs.aO(4, this.wkk);
      paramVarArgs.aO(5, this.wkl);
      paramVarArgs.aO(6, this.wkm);
      paramVarArgs.am(7, this.wkn);
      paramVarArgs.am(8, this.wko);
      if (this.kNG != null) {
        paramVarArgs.e(9, this.kNG);
      }
      if (this.kNH != null) {
        paramVarArgs.e(10, this.kNH);
      }
      AppMethodBeat.o(56681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wkk) + e.a.a.b.b.a.bl(5, this.wkl) + e.a.a.b.b.a.bl(6, this.wkm) + e.a.a.b.b.a.p(7, this.wkn) + e.a.a.b.b.a.p(8, this.wko);
      paramInt = i;
      if (this.kNG != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.kNG);
      }
      i = paramInt;
      if (this.kNH != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.kNH);
      }
      AppMethodBeat.o(56681);
      return i;
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
          AppMethodBeat.o(56681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56681);
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
            localm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56681);
          return 0;
        case 2: 
          localm.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56681);
          return 0;
        case 3: 
          localm.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56681);
          return 0;
        case 4: 
          localm.wkk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56681);
          return 0;
        case 5: 
          localm.wkl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56681);
          return 0;
        case 6: 
          localm.wkm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56681);
          return 0;
        case 7: 
          localm.wkn = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56681);
          return 0;
        case 8: 
          localm.wko = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56681);
          return 0;
        case 9: 
          localm.kNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56681);
          return 0;
        }
        localm.kNH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56681);
        return 0;
      }
      AppMethodBeat.o(56681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.m
 * JD-Core Version:    0.7.0.1
 */