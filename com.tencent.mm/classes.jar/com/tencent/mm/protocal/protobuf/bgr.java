package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgr
  extends bvk
{
  public String fhP;
  public String wqy;
  public LinkedList<bgv> xvT;
  public String xvU;
  public boolean xvV;
  public boolean xvW;
  public boolean xvX;
  
  public bgr()
  {
    AppMethodBeat.i(10224);
    this.xvT = new LinkedList();
    AppMethodBeat.o(10224);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10225);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10225);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xvT);
      if (this.fhP != null) {
        paramVarArgs.e(4, this.fhP);
      }
      if (this.xvU != null) {
        paramVarArgs.e(5, this.xvU);
      }
      if (this.wqy != null) {
        paramVarArgs.e(6, this.wqy);
      }
      paramVarArgs.aS(8, this.xvV);
      paramVarArgs.aS(9, this.xvW);
      paramVarArgs.aS(10, this.xvX);
      AppMethodBeat.o(10225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label840;
      }
    }
    label840:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(3, 8, this.xvT);
      paramInt = i;
      if (this.fhP != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fhP);
      }
      i = paramInt;
      if (this.xvU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xvU);
      }
      paramInt = i;
      if (this.wqy != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wqy);
      }
      i = e.a.a.b.b.a.eW(8);
      int j = e.a.a.b.b.a.eW(9);
      int k = e.a.a.b.b.a.eW(10);
      AppMethodBeat.o(10225);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xvT.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(10225);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgr localbgr = (bgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(10225);
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
            localbgr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10225);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgr.xvT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10225);
          return 0;
        case 4: 
          localbgr.fhP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10225);
          return 0;
        case 5: 
          localbgr.xvU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10225);
          return 0;
        case 6: 
          localbgr.wqy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10225);
          return 0;
        case 8: 
          localbgr.xvV = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(10225);
          return 0;
        case 9: 
          localbgr.xvW = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(10225);
          return 0;
        }
        localbgr.xvX = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(10225);
        return 0;
      }
      AppMethodBeat.o(10225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgr
 * JD-Core Version:    0.7.0.1
 */