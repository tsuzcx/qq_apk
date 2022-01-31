package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cif
  extends bvk
{
  public int wlc;
  public String xOk;
  public int xPz;
  public long xRS;
  public int xSQ;
  public LinkedList<chs> xSR;
  public int xSS;
  public int xST;
  
  public cif()
  {
    AppMethodBeat.i(56549);
    this.xSR = new LinkedList();
    AppMethodBeat.o(56549);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56550);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56550);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.aO(3, this.xSQ);
      paramVarArgs.e(4, 8, this.xSR);
      paramVarArgs.aO(5, this.xSS);
      paramVarArgs.aO(6, this.xST);
      paramVarArgs.aO(7, this.xPz);
      paramVarArgs.am(8, this.xRS);
      paramVarArgs.aO(9, this.wlc);
      AppMethodBeat.o(56550);
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
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xSQ);
      int j = e.a.a.a.c(4, 8, this.xSR);
      int k = e.a.a.b.b.a.bl(5, this.xSS);
      int m = e.a.a.b.b.a.bl(6, this.xST);
      int n = e.a.a.b.b.a.bl(7, this.xPz);
      int i1 = e.a.a.b.b.a.p(8, this.xRS);
      int i2 = e.a.a.b.b.a.bl(9, this.wlc);
      AppMethodBeat.o(56550);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xSR.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56550);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cif localcif = (cif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56550);
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
            localcif.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56550);
          return 0;
        case 2: 
          localcif.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56550);
          return 0;
        case 3: 
          localcif.xSQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56550);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcif.xSR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56550);
          return 0;
        case 5: 
          localcif.xSS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56550);
          return 0;
        case 6: 
          localcif.xST = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56550);
          return 0;
        case 7: 
          localcif.xPz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56550);
          return 0;
        case 8: 
          localcif.xRS = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56550);
          return 0;
        }
        localcif.wlc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56550);
        return 0;
      }
      AppMethodBeat.o(56550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cif
 * JD-Core Version:    0.7.0.1
 */