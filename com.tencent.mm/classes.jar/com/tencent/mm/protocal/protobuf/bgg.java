package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgg
  extends bvk
{
  public String jJA;
  public int jJS;
  public int lGw;
  public String lGy;
  public String wkY;
  public String wmA;
  public String wmr;
  public int wmu;
  public String wmx;
  public String wmy;
  public int wmz;
  public String wrS;
  public cco wrV;
  public int wsa;
  public avk wvX;
  public mg wvY;
  public bft wvZ;
  public nr wwA;
  public nr wwy;
  public nr wwz;
  public String xfI;
  public SKBuiltinBuffer_t xfL;
  public String xvq;
  public int xvr;
  public String xvs;
  public int xvt;
  public bms xvu;
  public int xvv;
  public String xvw;
  public String xvx;
  public byj xvy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58921);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(58921);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lGw);
      if (this.wkY != null) {
        paramVarArgs.e(3, this.wkY);
      }
      if (this.wmx != null) {
        paramVarArgs.e(4, this.wmx);
      }
      if (this.wmy != null) {
        paramVarArgs.e(5, this.wmy);
      }
      if (this.xvq != null) {
        paramVarArgs.e(6, this.xvq);
      }
      if (this.wmr != null) {
        paramVarArgs.e(7, this.wmr);
      }
      paramVarArgs.aO(8, this.wmz);
      paramVarArgs.aO(9, this.xvr);
      if (this.xvs != null) {
        paramVarArgs.e(10, this.xvs);
      }
      if (this.wvY != null)
      {
        paramVarArgs.iQ(14, this.wvY.computeSize());
        this.wvY.writeFields(paramVarArgs);
      }
      if (this.wmA != null) {
        paramVarArgs.e(15, this.wmA);
      }
      if (this.jJA != null) {
        paramVarArgs.e(16, this.jJA);
      }
      paramVarArgs.aO(17, this.jJS);
      if (this.wvZ != null)
      {
        paramVarArgs.iQ(18, this.wvZ.computeSize());
        this.wvZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(19, this.xvt);
      paramVarArgs.aO(20, this.wmu);
      if (this.wrS != null) {
        paramVarArgs.e(21, this.wrS);
      }
      if (this.xvu != null)
      {
        paramVarArgs.iQ(22, this.xvu.computeSize());
        this.xvu.writeFields(paramVarArgs);
      }
      if (this.lGy != null) {
        paramVarArgs.e(23, this.lGy);
      }
      paramVarArgs.aO(24, this.xvv);
      if (this.wvX != null)
      {
        paramVarArgs.iQ(25, this.wvX.computeSize());
        this.wvX.writeFields(paramVarArgs);
      }
      if (this.xvw != null) {
        paramVarArgs.e(26, this.xvw);
      }
      if (this.wwy != null)
      {
        paramVarArgs.iQ(27, this.wwy.computeSize());
        this.wwy.writeFields(paramVarArgs);
      }
      if (this.xvx != null) {
        paramVarArgs.e(28, this.xvx);
      }
      if (this.xfI != null) {
        paramVarArgs.e(29, this.xfI);
      }
      if (this.xfL != null)
      {
        paramVarArgs.iQ(30, this.xfL.computeSize());
        this.xfL.writeFields(paramVarArgs);
      }
      if (this.wrV != null)
      {
        paramVarArgs.iQ(31, this.wrV.computeSize());
        this.wrV.writeFields(paramVarArgs);
      }
      if (this.wwz != null)
      {
        paramVarArgs.iQ(32, this.wwz.computeSize());
        this.wwz.writeFields(paramVarArgs);
      }
      if (this.wwA != null)
      {
        paramVarArgs.iQ(33, this.wwA.computeSize());
        this.wwA.writeFields(paramVarArgs);
      }
      if (this.xvy != null)
      {
        paramVarArgs.iQ(34, this.xvy.computeSize());
        this.xvy.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(35, this.wsa);
      AppMethodBeat.o(58921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3094;
      }
    }
    label3094:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.lGw);
      paramInt = i;
      if (this.wkY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wkY);
      }
      i = paramInt;
      if (this.wmx != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wmx);
      }
      paramInt = i;
      if (this.wmy != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wmy);
      }
      i = paramInt;
      if (this.xvq != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xvq);
      }
      paramInt = i;
      if (this.wmr != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wmr);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.wmz) + e.a.a.b.b.a.bl(9, this.xvr);
      paramInt = i;
      if (this.xvs != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xvs);
      }
      i = paramInt;
      if (this.wvY != null) {
        i = paramInt + e.a.a.a.iP(14, this.wvY.computeSize());
      }
      paramInt = i;
      if (this.wmA != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.wmA);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.jJA);
      }
      i += e.a.a.b.b.a.bl(17, this.jJS);
      paramInt = i;
      if (this.wvZ != null) {
        paramInt = i + e.a.a.a.iP(18, this.wvZ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(19, this.xvt) + e.a.a.b.b.a.bl(20, this.wmu);
      paramInt = i;
      if (this.wrS != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wrS);
      }
      i = paramInt;
      if (this.xvu != null) {
        i = paramInt + e.a.a.a.iP(22, this.xvu.computeSize());
      }
      paramInt = i;
      if (this.lGy != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.lGy);
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.xvv);
      paramInt = i;
      if (this.wvX != null) {
        paramInt = i + e.a.a.a.iP(25, this.wvX.computeSize());
      }
      i = paramInt;
      if (this.xvw != null) {
        i = paramInt + e.a.a.b.b.a.f(26, this.xvw);
      }
      paramInt = i;
      if (this.wwy != null) {
        paramInt = i + e.a.a.a.iP(27, this.wwy.computeSize());
      }
      i = paramInt;
      if (this.xvx != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.xvx);
      }
      paramInt = i;
      if (this.xfI != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.xfI);
      }
      i = paramInt;
      if (this.xfL != null) {
        i = paramInt + e.a.a.a.iP(30, this.xfL.computeSize());
      }
      paramInt = i;
      if (this.wrV != null) {
        paramInt = i + e.a.a.a.iP(31, this.wrV.computeSize());
      }
      i = paramInt;
      if (this.wwz != null) {
        i = paramInt + e.a.a.a.iP(32, this.wwz.computeSize());
      }
      paramInt = i;
      if (this.wwA != null) {
        paramInt = i + e.a.a.a.iP(33, this.wwA.computeSize());
      }
      i = paramInt;
      if (this.xvy != null) {
        i = paramInt + e.a.a.a.iP(34, this.xvy.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(35, this.wsa);
      AppMethodBeat.o(58921);
      return i + paramInt;
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
          AppMethodBeat.o(58921);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(58921);
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
            localbgg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 2: 
          localbgg.lGw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 3: 
          localbgg.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 4: 
          localbgg.wmx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 5: 
          localbgg.wmy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 6: 
          localbgg.xvq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 7: 
          localbgg.wmr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 8: 
          localbgg.wmz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 9: 
          localbgg.xvr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 10: 
          localbgg.xvs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wvY = ((mg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 15: 
          localbgg.wmA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 16: 
          localbgg.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 17: 
          localbgg.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 18: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bft();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bft)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wvZ = ((bft)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 19: 
          localbgg.xvt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 20: 
          localbgg.wmu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 21: 
          localbgg.wrS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bms();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bms)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.xvu = ((bms)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 23: 
          localbgg.lGy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 24: 
          localbgg.xvv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58921);
          return 0;
        case 25: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wvX = ((avk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 26: 
          localbgg.xvw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 27: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wwy = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 28: 
          localbgg.xvx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 29: 
          localbgg.xfI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58921);
          return 0;
        case 30: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.xfL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 31: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cco();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wrV = ((cco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 32: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wwz = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 33: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.wwA = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        case 34: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgg.xvy = ((byj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58921);
          return 0;
        }
        localbgg.wsa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58921);
        return 0;
      }
      AppMethodBeat.o(58921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */