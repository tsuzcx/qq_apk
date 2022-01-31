package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ccl
  extends bvk
{
  public String crs;
  public String fhP;
  public String title;
  public fy xLn;
  public int xMQ;
  public fx xMR;
  public String xMS;
  public LinkedList<fz> xMT;
  public String xMU;
  public String xMV;
  public ga xMW;
  public LinkedList<ga> xMX;
  public cqr xMY;
  public boolean xMZ;
  public String xNa;
  public String xvU;
  
  public ccl()
  {
    AppMethodBeat.i(96292);
    this.xMT = new LinkedList();
    this.xMX = new LinkedList();
    AppMethodBeat.o(96292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96293);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96293);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xLn != null)
      {
        paramVarArgs.iQ(2, this.xLn.computeSize());
        this.xLn.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xMQ);
      if (this.xMR != null)
      {
        paramVarArgs.iQ(4, this.xMR.computeSize());
        this.xMR.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.xvU != null) {
        paramVarArgs.e(6, this.xvU);
      }
      if (this.fhP != null) {
        paramVarArgs.e(7, this.fhP);
      }
      if (this.xMS != null) {
        paramVarArgs.e(8, this.xMS);
      }
      paramVarArgs.e(9, 8, this.xMT);
      if (this.xMU != null) {
        paramVarArgs.e(10, this.xMU);
      }
      if (this.xMV != null) {
        paramVarArgs.e(11, this.xMV);
      }
      if (this.xMW != null)
      {
        paramVarArgs.iQ(12, this.xMW.computeSize());
        this.xMW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.xMX);
      if (this.crs != null) {
        paramVarArgs.e(14, this.crs);
      }
      if (this.xMY != null)
      {
        paramVarArgs.iQ(15, this.xMY.computeSize());
        this.xMY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.xMZ);
      if (this.xNa != null) {
        paramVarArgs.e(17, this.xNa);
      }
      AppMethodBeat.o(96293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1846;
      }
    }
    label1846:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xLn != null) {
        i = paramInt + e.a.a.a.iP(2, this.xLn.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.xMQ);
      paramInt = i;
      if (this.xMR != null) {
        paramInt = i + e.a.a.a.iP(4, this.xMR.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.title);
      }
      paramInt = i;
      if (this.xvU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xvU);
      }
      i = paramInt;
      if (this.fhP != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.fhP);
      }
      paramInt = i;
      if (this.xMS != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xMS);
      }
      i = paramInt + e.a.a.a.c(9, 8, this.xMT);
      paramInt = i;
      if (this.xMU != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xMU);
      }
      i = paramInt;
      if (this.xMV != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xMV);
      }
      paramInt = i;
      if (this.xMW != null) {
        paramInt = i + e.a.a.a.iP(12, this.xMW.computeSize());
      }
      i = paramInt + e.a.a.a.c(13, 8, this.xMX);
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.crs);
      }
      i = paramInt;
      if (this.xMY != null) {
        i = paramInt + e.a.a.a.iP(15, this.xMY.computeSize());
      }
      i += e.a.a.b.b.a.eW(16) + 1;
      paramInt = i;
      if (this.xNa != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xNa);
      }
      AppMethodBeat.o(96293);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xMT.clear();
        this.xMX.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96293);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ccl localccl = (ccl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96293);
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
            localccl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xLn = ((fy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 3: 
          localccl.xMQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96293);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xMR = ((fx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 5: 
          localccl.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 6: 
          localccl.xvU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 7: 
          localccl.fhP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 8: 
          localccl.xMS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xMT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 10: 
          localccl.xMU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 11: 
          localccl.xMV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ga();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xMW = ((ga)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ga();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xMX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 14: 
          localccl.crs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96293);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccl.xMY = ((cqr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96293);
          return 0;
        case 16: 
          localccl.xMZ = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(96293);
          return 0;
        }
        localccl.xNa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96293);
        return 0;
      }
      AppMethodBeat.o(96293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccl
 * JD-Core Version:    0.7.0.1
 */