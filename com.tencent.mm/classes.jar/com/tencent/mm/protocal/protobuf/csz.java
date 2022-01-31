package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csz
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int xCv;
  public LinkedList<crm> yaO;
  public int ycd;
  public LinkedList<crm> yce;
  public int ycf;
  public LinkedList<crm> ycg;
  public int ych;
  public int yci;
  public int ycj;
  
  public csz()
  {
    AppMethodBeat.i(5261);
    this.yce = new LinkedList();
    this.ycg = new LinkedList();
    this.yaO = new LinkedList();
    AppMethodBeat.o(5261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5262);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5262);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.aO(3, this.ycd);
      paramVarArgs.e(4, 8, this.yce);
      paramVarArgs.aO(5, this.ycf);
      paramVarArgs.e(6, 8, this.ycg);
      paramVarArgs.am(7, this.wQQ);
      paramVarArgs.aO(8, this.xCv);
      paramVarArgs.aO(9, this.ych);
      paramVarArgs.e(10, 8, this.yaO);
      paramVarArgs.aO(11, this.yci);
      paramVarArgs.aO(12, this.ycj);
      AppMethodBeat.o(5262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1184;
      }
    }
    label1184:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.bl(3, this.ycd);
      int k = e.a.a.a.c(4, 8, this.yce);
      int m = e.a.a.b.b.a.bl(5, this.ycf);
      int n = e.a.a.a.c(6, 8, this.ycg);
      int i1 = e.a.a.b.b.a.p(7, this.wQQ);
      int i2 = e.a.a.b.b.a.bl(8, this.xCv);
      int i3 = e.a.a.b.b.a.bl(9, this.ych);
      int i4 = e.a.a.a.c(10, 8, this.yaO);
      int i5 = e.a.a.b.b.a.bl(11, this.yci);
      int i6 = e.a.a.b.b.a.bl(12, this.ycj);
      AppMethodBeat.o(5262);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.yce.clear();
        this.ycg.clear();
        this.yaO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5262);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csz localcsz = (csz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5262);
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
            localcsz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5262);
          return 0;
        case 2: 
          localcsz.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        case 3: 
          localcsz.ycd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsz.yce.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5262);
          return 0;
        case 5: 
          localcsz.ycf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsz.ycg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5262);
          return 0;
        case 7: 
          localcsz.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5262);
          return 0;
        case 8: 
          localcsz.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        case 9: 
          localcsz.ych = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsz.yaO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5262);
          return 0;
        case 11: 
          localcsz.yci = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5262);
          return 0;
        }
        localcsz.ycj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5262);
        return 0;
      }
      AppMethodBeat.o(5262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csz
 * JD-Core Version:    0.7.0.1
 */