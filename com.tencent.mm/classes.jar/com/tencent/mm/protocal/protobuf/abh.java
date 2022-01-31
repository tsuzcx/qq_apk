package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class abh
  extends bvk
{
  public int cMQ;
  public int cMR;
  public int cnK;
  public int cpX;
  public String kNv;
  public String ojA;
  public int okH;
  public int okJ;
  public String okK;
  public String okL;
  public String okM;
  public int okN;
  public String onN;
  public bry wIk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56785);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56785);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      paramVarArgs.aO(4, this.cpX);
      if (this.ojA != null) {
        paramVarArgs.e(5, this.ojA);
      }
      paramVarArgs.aO(6, this.cMQ);
      paramVarArgs.aO(7, this.cMR);
      if (this.onN != null) {
        paramVarArgs.e(8, this.onN);
      }
      paramVarArgs.aO(9, this.okH);
      if (this.wIk != null)
      {
        paramVarArgs.iQ(10, this.wIk.computeSize());
        this.wIk.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.okJ);
      if (this.okK != null) {
        paramVarArgs.e(12, this.okK);
      }
      if (this.okL != null) {
        paramVarArgs.e(13, this.okL);
      }
      if (this.okM != null) {
        paramVarArgs.e(14, this.okM);
      }
      paramVarArgs.aO(15, this.okN);
      AppMethodBeat.o(56785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.cpX);
      paramInt = i;
      if (this.ojA != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ojA);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.cMQ) + e.a.a.b.b.a.bl(7, this.cMR);
      paramInt = i;
      if (this.onN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.onN);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.okH);
      paramInt = i;
      if (this.wIk != null) {
        paramInt = i + e.a.a.a.iP(10, this.wIk.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.okJ);
      paramInt = i;
      if (this.okK != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.okK);
      }
      i = paramInt;
      if (this.okL != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.okL);
      }
      paramInt = i;
      if (this.okM != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.okM);
      }
      i = e.a.a.b.b.a.bl(15, this.okN);
      AppMethodBeat.o(56785);
      return paramInt + i;
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
          AppMethodBeat.o(56785);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56785);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abh localabh = (abh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56785);
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
            localabh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56785);
          return 0;
        case 2: 
          localabh.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 3: 
          localabh.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        case 4: 
          localabh.cpX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 5: 
          localabh.ojA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        case 6: 
          localabh.cMQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 7: 
          localabh.cMR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 8: 
          localabh.onN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        case 9: 
          localabh.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localabh.wIk = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56785);
          return 0;
        case 11: 
          localabh.okJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56785);
          return 0;
        case 12: 
          localabh.okK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        case 13: 
          localabh.okL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        case 14: 
          localabh.okM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56785);
          return 0;
        }
        localabh.okN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56785);
        return 0;
      }
      AppMethodBeat.o(56785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abh
 * JD-Core Version:    0.7.0.1
 */