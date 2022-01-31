package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpb
  extends bvk
{
  public int CreateTime;
  public int fKi;
  public String nul;
  public String num;
  public int pIE;
  public long pIG;
  public int wAr;
  public int wPU;
  public String wpS;
  public int wyT;
  public int wzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116812);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116812);
        throw paramVarArgs;
      }
      if (this.num != null) {
        paramVarArgs.e(1, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(2, this.nul);
      }
      paramVarArgs.aO(3, this.wzS);
      paramVarArgs.aO(4, this.wyT);
      paramVarArgs.aO(5, this.CreateTime);
      if (this.wpS != null) {
        paramVarArgs.e(6, this.wpS);
      }
      paramVarArgs.aO(7, this.pIE);
      paramVarArgs.aO(8, this.wAr);
      paramVarArgs.aO(9, this.fKi);
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.wPU);
      paramVarArgs.am(12, this.pIG);
      AppMethodBeat.o(116812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.num == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = e.a.a.b.b.a.f(1, this.num) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nul);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wzS) + e.a.a.b.b.a.bl(4, this.wyT) + e.a.a.b.b.a.bl(5, this.CreateTime);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wpS);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.pIE) + e.a.a.b.b.a.bl(8, this.wAr) + e.a.a.b.b.a.bl(9, this.fKi);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + e.a.a.a.iP(10, this.BaseResponse.computeSize());
      }
      i = e.a.a.b.b.a.bl(11, this.wPU);
      int j = e.a.a.b.b.a.p(12, this.pIG);
      AppMethodBeat.o(116812);
      return paramInt + i + j;
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
          AppMethodBeat.o(116812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpb localcpb = (cpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116812);
          return -1;
        case 1: 
          localcpb.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116812);
          return 0;
        case 2: 
          localcpb.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116812);
          return 0;
        case 3: 
          localcpb.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 4: 
          localcpb.wyT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 5: 
          localcpb.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 6: 
          localcpb.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116812);
          return 0;
        case 7: 
          localcpb.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 8: 
          localcpb.wAr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 9: 
          localcpb.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116812);
          return 0;
        case 11: 
          localcpb.wPU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116812);
          return 0;
        }
        localcpb.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(116812);
        return 0;
      }
      AppMethodBeat.o(116812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpb
 * JD-Core Version:    0.7.0.1
 */