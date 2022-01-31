package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crx
  extends bvk
{
  public int nNk;
  public int nNq;
  public int nNr;
  public int nNv;
  public long wQQ;
  public LinkedList<crr> wtb;
  public com.tencent.mm.bv.b xCz;
  public int xRC;
  public long xSP;
  public int yaL;
  public int yaM;
  public int yaN;
  public LinkedList<crr> yaO;
  
  public crx()
  {
    AppMethodBeat.i(135448);
    this.wtb = new LinkedList();
    this.yaO = new LinkedList();
    AppMethodBeat.o(135448);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135449);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(135449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.xSP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.e(4, 8, this.wtb);
      paramVarArgs.aO(5, this.xRC);
      paramVarArgs.aO(6, this.nNq);
      paramVarArgs.aO(7, this.nNr);
      paramVarArgs.aO(8, this.nNk);
      paramVarArgs.aO(9, this.nNv);
      paramVarArgs.aO(10, this.yaL);
      paramVarArgs.aO(11, this.yaM);
      if (this.xCz != null) {
        paramVarArgs.c(12, this.xCz);
      }
      paramVarArgs.aO(13, this.yaN);
      paramVarArgs.e(14, 8, this.yaO);
      AppMethodBeat.o(135449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xSP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.a.c(4, 8, this.wtb) + e.a.a.b.b.a.bl(5, this.xRC) + e.a.a.b.b.a.bl(6, this.nNq) + e.a.a.b.b.a.bl(7, this.nNr) + e.a.a.b.b.a.bl(8, this.nNk) + e.a.a.b.b.a.bl(9, this.nNv) + e.a.a.b.b.a.bl(10, this.yaL) + e.a.a.b.b.a.bl(11, this.yaM);
      paramInt = i;
      if (this.xCz != null) {
        paramInt = i + e.a.a.b.b.a.b(12, this.xCz);
      }
      i = e.a.a.b.b.a.bl(13, this.yaN);
      int j = e.a.a.a.c(14, 8, this.yaO);
      AppMethodBeat.o(135449);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wtb.clear();
        this.yaO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(135449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(135449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crx localcrx = (crx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135449);
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
            localcrx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135449);
          return 0;
        case 2: 
          localcrx.xSP = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135449);
          return 0;
        case 3: 
          localcrx.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135449);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrx.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135449);
          return 0;
        case 5: 
          localcrx.xRC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 6: 
          localcrx.nNq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 7: 
          localcrx.nNr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 8: 
          localcrx.nNk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 9: 
          localcrx.nNv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 10: 
          localcrx.yaL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 11: 
          localcrx.yaM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        case 12: 
          localcrx.xCz = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(135449);
          return 0;
        case 13: 
          localcrx.yaN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135449);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crr();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcrx.yaO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(135449);
        return 0;
      }
      AppMethodBeat.o(135449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crx
 * JD-Core Version:    0.7.0.1
 */