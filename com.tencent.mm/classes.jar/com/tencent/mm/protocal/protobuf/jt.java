package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class jt
  extends bvk
{
  public String Username;
  public String crs;
  public int wmw;
  public cco wrV;
  public String wrW;
  public int wsa;
  public int wvQ;
  public String wvR;
  public String wvU;
  public int wvV;
  public String wvW;
  public avk wvX;
  public mg wvY;
  public bft wvZ;
  public String wwa;
  public int wwb;
  public bwf wwc;
  public String wwd;
  public String wwe;
  public String wwf;
  public String wwg;
  public int wwh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123507);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123507);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.crs != null) {
        paramVarArgs.e(2, this.crs);
      }
      if (this.wvU != null) {
        paramVarArgs.e(3, this.wvU);
      }
      paramVarArgs.aO(4, this.wvV);
      if (this.wvW != null) {
        paramVarArgs.e(5, this.wvW);
      }
      if (this.Username != null) {
        paramVarArgs.e(6, this.Username);
      }
      if (this.wvX != null)
      {
        paramVarArgs.iQ(7, this.wvX.computeSize());
        this.wvX.writeFields(paramVarArgs);
      }
      if (this.wvY != null)
      {
        paramVarArgs.iQ(8, this.wvY.computeSize());
        this.wvY.writeFields(paramVarArgs);
      }
      if (this.wvZ != null)
      {
        paramVarArgs.iQ(9, this.wvZ.computeSize());
        this.wvZ.writeFields(paramVarArgs);
      }
      if (this.wrW != null) {
        paramVarArgs.e(10, this.wrW);
      }
      paramVarArgs.aO(11, this.wmw);
      if (this.wwa != null) {
        paramVarArgs.e(12, this.wwa);
      }
      paramVarArgs.aO(13, this.wwb);
      if (this.wwc != null)
      {
        paramVarArgs.iQ(14, this.wwc.computeSize());
        this.wwc.writeFields(paramVarArgs);
      }
      if (this.wwd != null) {
        paramVarArgs.e(15, this.wwd);
      }
      if (this.wwe != null) {
        paramVarArgs.e(16, this.wwe);
      }
      if (this.wrV != null)
      {
        paramVarArgs.iQ(17, this.wrV.computeSize());
        this.wrV.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(18, this.wsa);
      if (this.wwf != null) {
        paramVarArgs.e(19, this.wwf);
      }
      if (this.wwg != null) {
        paramVarArgs.e(20, this.wwg);
      }
      paramVarArgs.aO(21, this.wvQ);
      if (this.wvR != null) {
        paramVarArgs.e(22, this.wvR);
      }
      paramVarArgs.aO(23, this.wwh);
      AppMethodBeat.o(123507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2090;
      }
    }
    label2090:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.crs);
      }
      i = paramInt;
      if (this.wvU != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvU);
      }
      i += e.a.a.b.b.a.bl(4, this.wvV);
      paramInt = i;
      if (this.wvW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wvW);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.Username);
      }
      paramInt = i;
      if (this.wvX != null) {
        paramInt = i + e.a.a.a.iP(7, this.wvX.computeSize());
      }
      i = paramInt;
      if (this.wvY != null) {
        i = paramInt + e.a.a.a.iP(8, this.wvY.computeSize());
      }
      paramInt = i;
      if (this.wvZ != null) {
        paramInt = i + e.a.a.a.iP(9, this.wvZ.computeSize());
      }
      i = paramInt;
      if (this.wrW != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wrW);
      }
      i += e.a.a.b.b.a.bl(11, this.wmw);
      paramInt = i;
      if (this.wwa != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wwa);
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.wwb);
      paramInt = i;
      if (this.wwc != null) {
        paramInt = i + e.a.a.a.iP(14, this.wwc.computeSize());
      }
      i = paramInt;
      if (this.wwd != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.wwd);
      }
      paramInt = i;
      if (this.wwe != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wwe);
      }
      i = paramInt;
      if (this.wrV != null) {
        i = paramInt + e.a.a.a.iP(17, this.wrV.computeSize());
      }
      i += e.a.a.b.b.a.bl(18, this.wsa);
      paramInt = i;
      if (this.wwf != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.wwf);
      }
      i = paramInt;
      if (this.wwg != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.wwg);
      }
      i += e.a.a.b.b.a.bl(21, this.wvQ);
      paramInt = i;
      if (this.wvR != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.wvR);
      }
      i = e.a.a.b.b.a.bl(23, this.wwh);
      AppMethodBeat.o(123507);
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
          AppMethodBeat.o(123507);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jt localjt = (jt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123507);
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
            localjt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 2: 
          localjt.crs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 3: 
          localjt.wvU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 4: 
          localjt.wvV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123507);
          return 0;
        case 5: 
          localjt.wvW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 6: 
          localjt.Username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjt.wvX = ((avk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjt.wvY = ((mg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bft();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bft)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjt.wvZ = ((bft)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 10: 
          localjt.wrW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 11: 
          localjt.wmw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123507);
          return 0;
        case 12: 
          localjt.wwa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 13: 
          localjt.wwb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123507);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjt.wwc = ((bwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 15: 
          localjt.wwd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 16: 
          localjt.wwe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cco();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjt.wrV = ((cco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123507);
          return 0;
        case 18: 
          localjt.wsa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123507);
          return 0;
        case 19: 
          localjt.wwf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 20: 
          localjt.wwg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        case 21: 
          localjt.wvQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123507);
          return 0;
        case 22: 
          localjt.wvR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123507);
          return 0;
        }
        localjt.wwh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(123507);
        return 0;
      }
      AppMethodBeat.o(123507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jt
 * JD-Core Version:    0.7.0.1
 */