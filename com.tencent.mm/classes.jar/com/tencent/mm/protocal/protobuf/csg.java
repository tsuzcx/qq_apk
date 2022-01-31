package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csg
  extends buy
{
  public String nul;
  public int wQP;
  public long wQQ;
  public String xCG;
  public int xCk;
  public cti yaW;
  public int yaX;
  public long yab;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5234);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yaW == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(5234);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCG != null) {
        paramVarArgs.e(2, this.xCG);
      }
      paramVarArgs.aO(3, this.wQP);
      paramVarArgs.am(4, this.wQQ);
      if (this.nul != null) {
        paramVarArgs.e(6, this.nul);
      }
      if (this.yaW != null)
      {
        paramVarArgs.iQ(8, this.yaW.computeSize());
        this.yaW.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.yaX);
      paramVarArgs.am(10, this.yab);
      paramVarArgs.aO(11, this.xCk);
      AppMethodBeat.o(5234);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label889;
      }
    }
    label889:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xCG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xCG);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wQP) + e.a.a.b.b.a.p(4, this.wQQ);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nul);
      }
      i = paramInt;
      if (this.yaW != null) {
        i = paramInt + e.a.a.a.iP(8, this.yaW.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(9, this.yaX);
      int j = e.a.a.b.b.a.p(10, this.yab);
      int k = e.a.a.b.b.a.bl(11, this.xCk);
      AppMethodBeat.o(5234);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.yaW == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(5234);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5234);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csg localcsg = (csg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(5234);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5234);
          return 0;
        case 2: 
          localcsg.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5234);
          return 0;
        case 3: 
          localcsg.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5234);
          return 0;
        case 4: 
          localcsg.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5234);
          return 0;
        case 6: 
          localcsg.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5234);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsg.yaW = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5234);
          return 0;
        case 9: 
          localcsg.yaX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5234);
          return 0;
        case 10: 
          localcsg.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5234);
          return 0;
        }
        localcsg.xCk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5234);
        return 0;
      }
      AppMethodBeat.o(5234);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csg
 * JD-Core Version:    0.7.0.1
 */