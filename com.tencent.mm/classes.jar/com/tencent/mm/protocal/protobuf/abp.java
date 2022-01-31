package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class abp
  extends bvk
{
  public int mha;
  public String mhb;
  public LinkedList<azd> wID;
  public bnw wRT;
  public String wRU;
  public String wRV;
  public String wRW;
  public String wRX;
  public float wRY;
  public String wRZ;
  
  public abp()
  {
    AppMethodBeat.i(839);
    this.wID = new LinkedList();
    AppMethodBeat.o(839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(840);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(840);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wID);
      if (this.wRT != null)
      {
        paramVarArgs.iQ(3, this.wRT.computeSize());
        this.wRT.writeFields(paramVarArgs);
      }
      if (this.wRU != null) {
        paramVarArgs.e(4, this.wRU);
      }
      if (this.wRV != null) {
        paramVarArgs.e(5, this.wRV);
      }
      if (this.wRW != null) {
        paramVarArgs.e(6, this.wRW);
      }
      if (this.wRX != null) {
        paramVarArgs.e(7, this.wRX);
      }
      paramVarArgs.q(8, this.wRY);
      paramVarArgs.aO(9, this.mha);
      if (this.mhb != null) {
        paramVarArgs.e(10, this.mhb);
      }
      if (this.wRZ != null) {
        paramVarArgs.e(11, this.wRZ);
      }
      AppMethodBeat.o(840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wID);
      paramInt = i;
      if (this.wRT != null) {
        paramInt = i + e.a.a.a.iP(3, this.wRT.computeSize());
      }
      i = paramInt;
      if (this.wRU != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wRU);
      }
      paramInt = i;
      if (this.wRV != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wRV);
      }
      i = paramInt;
      if (this.wRW != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wRW);
      }
      paramInt = i;
      if (this.wRX != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wRX);
      }
      i = paramInt + (e.a.a.b.b.a.eW(8) + 4) + e.a.a.b.b.a.bl(9, this.mha);
      paramInt = i;
      if (this.mhb != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.mhb);
      }
      i = paramInt;
      if (this.wRZ != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wRZ);
      }
      AppMethodBeat.o(840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wID.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(840);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abp localabp = (abp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(840);
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
            localabp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(840);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localabp.wID.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(840);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localabp.wRT = ((bnw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(840);
          return 0;
        case 4: 
          localabp.wRU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(840);
          return 0;
        case 5: 
          localabp.wRV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(840);
          return 0;
        case 6: 
          localabp.wRW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(840);
          return 0;
        case 7: 
          localabp.wRX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(840);
          return 0;
        case 8: 
          localabp.wRY = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(840);
          return 0;
        case 9: 
          localabp.mha = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(840);
          return 0;
        case 10: 
          localabp.mhb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(840);
          return 0;
        }
        localabp.wRZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(840);
        return 0;
      }
      AppMethodBeat.o(840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abp
 * JD-Core Version:    0.7.0.1
 */