package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bmn
  extends bvk
{
  public int koj;
  public String kok;
  public LinkedList<bmo> xAQ;
  public long xAR;
  public String xAS;
  public hj xAT;
  public String xAU;
  
  public bmn()
  {
    AppMethodBeat.i(56919);
    this.xAQ = new LinkedList();
    AppMethodBeat.o(56919);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56920);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56920);
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
      paramVarArgs.e(4, 8, this.xAQ);
      paramVarArgs.am(5, this.xAR);
      if (this.xAS != null) {
        paramVarArgs.e(6, this.xAS);
      }
      if (this.xAT != null)
      {
        paramVarArgs.iQ(7, this.xAT.computeSize());
        this.xAT.writeFields(paramVarArgs);
      }
      if (this.xAU != null) {
        paramVarArgs.e(8, this.xAU);
      }
      AppMethodBeat.o(56920);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.a.c(4, 8, this.xAQ) + e.a.a.b.b.a.p(5, this.xAR);
      paramInt = i;
      if (this.xAS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xAS);
      }
      i = paramInt;
      if (this.xAT != null) {
        i = paramInt + e.a.a.a.iP(7, this.xAT.computeSize());
      }
      paramInt = i;
      if (this.xAU != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xAU);
      }
      AppMethodBeat.o(56920);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xAQ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56920);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56920);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bmn localbmn = (bmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56920);
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
            localbmn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56920);
          return 0;
        case 2: 
          localbmn.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56920);
          return 0;
        case 3: 
          localbmn.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56920);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmn.xAQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56920);
          return 0;
        case 5: 
          localbmn.xAR = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56920);
          return 0;
        case 6: 
          localbmn.xAS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56920);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmn.xAT = ((hj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56920);
          return 0;
        }
        localbmn.xAU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56920);
        return 0;
      }
      AppMethodBeat.o(56920);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmn
 * JD-Core Version:    0.7.0.1
 */