package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpo
  extends bvk
{
  public String cDz;
  public int iFL;
  public String knv;
  public int koj;
  public String kok;
  public long wOy;
  public String wks;
  public ckm xaX;
  public long xkB;
  public bvv xkx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48933);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48933);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.wks != null) {
        paramVarArgs.e(4, this.wks);
      }
      paramVarArgs.am(5, this.xkB);
      paramVarArgs.am(6, this.wOy);
      if (this.xkx != null)
      {
        paramVarArgs.iQ(7, this.xkx.computeSize());
        this.xkx.writeFields(paramVarArgs);
      }
      if (this.xaX != null)
      {
        paramVarArgs.iQ(8, this.xaX.computeSize());
        this.xaX.writeFields(paramVarArgs);
      }
      if (this.knv != null) {
        paramVarArgs.e(9, this.knv);
      }
      paramVarArgs.aO(10, this.iFL);
      if (this.cDz != null) {
        paramVarArgs.e(11, this.cDz);
      }
      AppMethodBeat.o(48933);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.wks != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wks);
      }
      i = i + e.a.a.b.b.a.p(5, this.xkB) + e.a.a.b.b.a.p(6, this.wOy);
      paramInt = i;
      if (this.xkx != null) {
        paramInt = i + e.a.a.a.iP(7, this.xkx.computeSize());
      }
      i = paramInt;
      if (this.xaX != null) {
        i = paramInt + e.a.a.a.iP(8, this.xaX.computeSize());
      }
      paramInt = i;
      if (this.knv != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.knv);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.iFL);
      paramInt = i;
      if (this.cDz != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.cDz);
      }
      AppMethodBeat.o(48933);
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
          AppMethodBeat.o(48933);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48933);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpo localbpo = (bpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48933);
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
            localbpo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48933);
          return 0;
        case 2: 
          localbpo.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48933);
          return 0;
        case 3: 
          localbpo.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48933);
          return 0;
        case 4: 
          localbpo.wks = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48933);
          return 0;
        case 5: 
          localbpo.xkB = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48933);
          return 0;
        case 6: 
          localbpo.wOy = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48933);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpo.xkx = ((bvv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48933);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpo.xaX = ((ckm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48933);
          return 0;
        case 9: 
          localbpo.knv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48933);
          return 0;
        case 10: 
          localbpo.iFL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48933);
          return 0;
        }
        localbpo.cDz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48933);
        return 0;
      }
      AppMethodBeat.o(48933);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpo
 * JD-Core Version:    0.7.0.1
 */