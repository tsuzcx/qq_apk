package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ru
  extends bvk
{
  public czj wJX;
  public boolean wJY;
  public String wJZ;
  public String wKa;
  public boolean wKb;
  public String wKc;
  public String wKd;
  public String wKe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96212);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96212);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wJX != null)
      {
        paramVarArgs.iQ(2, this.wJX.computeSize());
        this.wJX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.wJY);
      if (this.wJZ != null) {
        paramVarArgs.e(4, this.wJZ);
      }
      if (this.wKa != null) {
        paramVarArgs.e(5, this.wKa);
      }
      paramVarArgs.aS(6, this.wKb);
      if (this.wKc != null) {
        paramVarArgs.e(7, this.wKc);
      }
      if (this.wKd != null) {
        paramVarArgs.e(8, this.wKd);
      }
      if (this.wKe != null) {
        paramVarArgs.e(9, this.wKe);
      }
      AppMethodBeat.o(96212);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wJX != null) {
        i = paramInt + e.a.a.a.iP(2, this.wJX.computeSize());
      }
      i += e.a.a.b.b.a.eW(3) + 1;
      paramInt = i;
      if (this.wJZ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJZ);
      }
      i = paramInt;
      if (this.wKa != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKa);
      }
      i += e.a.a.b.b.a.eW(6) + 1;
      paramInt = i;
      if (this.wKc != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wKc);
      }
      i = paramInt;
      if (this.wKd != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wKd);
      }
      paramInt = i;
      if (this.wKe != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wKe);
      }
      AppMethodBeat.o(96212);
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
          AppMethodBeat.o(96212);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96212);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ru localru = (ru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96212);
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
            localru.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96212);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localru.wJX = ((czj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96212);
          return 0;
        case 3: 
          localru.wJY = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(96212);
          return 0;
        case 4: 
          localru.wJZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96212);
          return 0;
        case 5: 
          localru.wKa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96212);
          return 0;
        case 6: 
          localru.wKb = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(96212);
          return 0;
        case 7: 
          localru.wKc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96212);
          return 0;
        case 8: 
          localru.wKd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96212);
          return 0;
        }
        localru.wKe = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96212);
        return 0;
      }
      AppMethodBeat.o(96212);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */