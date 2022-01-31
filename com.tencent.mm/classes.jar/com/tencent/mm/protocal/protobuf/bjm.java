package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bjm
  extends bvk
{
  public int cnK;
  public String kNG;
  public String kNH;
  public String kNv;
  public int xxS;
  public int xxT;
  public String xxU;
  public String xxV;
  public int xxW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48912);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48912);
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
      paramVarArgs.aO(4, this.xxS);
      paramVarArgs.aO(5, this.xxT);
      if (this.kNG != null) {
        paramVarArgs.e(6, this.kNG);
      }
      if (this.kNH != null) {
        paramVarArgs.e(7, this.kNH);
      }
      if (this.xxU != null) {
        paramVarArgs.e(8, this.xxU);
      }
      if (this.xxV != null) {
        paramVarArgs.e(9, this.xxV);
      }
      paramVarArgs.aO(10, this.xxW);
      AppMethodBeat.o(48912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xxS) + e.a.a.b.b.a.bl(5, this.xxT);
      paramInt = i;
      if (this.kNG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.kNG);
      }
      i = paramInt;
      if (this.kNH != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.kNH);
      }
      paramInt = i;
      if (this.xxU != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xxU);
      }
      i = paramInt;
      if (this.xxV != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xxV);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.xxW);
      AppMethodBeat.o(48912);
      return i + paramInt;
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
          AppMethodBeat.o(48912);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bjm localbjm = (bjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48912);
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
            localbjm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48912);
          return 0;
        case 2: 
          localbjm.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48912);
          return 0;
        case 3: 
          localbjm.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48912);
          return 0;
        case 4: 
          localbjm.xxS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48912);
          return 0;
        case 5: 
          localbjm.xxT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48912);
          return 0;
        case 6: 
          localbjm.kNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48912);
          return 0;
        case 7: 
          localbjm.kNH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48912);
          return 0;
        case 8: 
          localbjm.xxU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48912);
          return 0;
        case 9: 
          localbjm.xxV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48912);
          return 0;
        }
        localbjm.xxW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48912);
        return 0;
      }
      AppMethodBeat.o(48912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjm
 * JD-Core Version:    0.7.0.1
 */