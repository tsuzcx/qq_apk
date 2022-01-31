package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class alx
  extends bvk
{
  public String cHo;
  public String color;
  public String kml;
  public String kmm;
  public String kmn;
  public String kmo;
  public int kmq;
  public String knw;
  public int qNB;
  public String qNC;
  public String qND;
  public String qNE;
  public String qNG;
  public boolean qNH;
  public String tXI;
  public String title;
  public String xcA;
  public int xcB;
  public String xcC;
  public int xcD;
  public boolean xcx;
  public boolean xcy;
  public String xcz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28444);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28444);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcx);
      paramVarArgs.aS(3, this.xcy);
      if (this.xcz != null) {
        paramVarArgs.e(4, this.xcz);
      }
      if (this.xcA != null) {
        paramVarArgs.e(5, this.xcA);
      }
      paramVarArgs.aO(6, this.xcB);
      if (this.xcC != null) {
        paramVarArgs.e(7, this.xcC);
      }
      paramVarArgs.aO(8, this.xcD);
      if (this.kml != null) {
        paramVarArgs.e(9, this.kml);
      }
      if (this.cHo != null) {
        paramVarArgs.e(10, this.cHo);
      }
      if (this.title != null) {
        paramVarArgs.e(11, this.title);
      }
      if (this.kmn != null) {
        paramVarArgs.e(12, this.kmn);
      }
      if (this.kmo != null) {
        paramVarArgs.e(13, this.kmo);
      }
      if (this.knw != null) {
        paramVarArgs.e(14, this.knw);
      }
      if (this.kmm != null) {
        paramVarArgs.e(15, this.kmm);
      }
      if (this.color != null) {
        paramVarArgs.e(16, this.color);
      }
      paramVarArgs.aO(17, this.qNB);
      if (this.qNC != null) {
        paramVarArgs.e(18, this.qNC);
      }
      if (this.qND != null) {
        paramVarArgs.e(19, this.qND);
      }
      if (this.qNE != null) {
        paramVarArgs.e(20, this.qNE);
      }
      paramVarArgs.aO(21, this.kmq);
      if (this.qNG != null) {
        paramVarArgs.e(22, this.qNG);
      }
      if (this.tXI != null) {
        paramVarArgs.e(23, this.tXI);
      }
      paramVarArgs.aS(24, this.qNH);
      AppMethodBeat.o(28444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1688;
      }
    }
    label1688:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1) + (e.a.a.b.b.a.eW(3) + 1);
      paramInt = i;
      if (this.xcz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xcz);
      }
      i = paramInt;
      if (this.xcA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xcA);
      }
      i += e.a.a.b.b.a.bl(6, this.xcB);
      paramInt = i;
      if (this.xcC != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xcC);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xcD);
      paramInt = i;
      if (this.kml != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.kml);
      }
      i = paramInt;
      if (this.cHo != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.cHo);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.title);
      }
      i = paramInt;
      if (this.kmn != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.kmn);
      }
      paramInt = i;
      if (this.kmo != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.kmo);
      }
      i = paramInt;
      if (this.knw != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.knw);
      }
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.kmm);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.color);
      }
      i += e.a.a.b.b.a.bl(17, this.qNB);
      paramInt = i;
      if (this.qNC != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.qNC);
      }
      i = paramInt;
      if (this.qND != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.qND);
      }
      paramInt = i;
      if (this.qNE != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.qNE);
      }
      i = paramInt + e.a.a.b.b.a.bl(21, this.kmq);
      paramInt = i;
      if (this.qNG != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.qNG);
      }
      i = paramInt;
      if (this.tXI != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.tXI);
      }
      paramInt = e.a.a.b.b.a.eW(24);
      AppMethodBeat.o(28444);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(28444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        alx localalx = (alx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28444);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28444);
          return 0;
        case 2: 
          localalx.xcx = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28444);
          return 0;
        case 3: 
          localalx.xcy = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28444);
          return 0;
        case 4: 
          localalx.xcz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 5: 
          localalx.xcA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 6: 
          localalx.xcB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28444);
          return 0;
        case 7: 
          localalx.xcC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 8: 
          localalx.xcD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28444);
          return 0;
        case 9: 
          localalx.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 10: 
          localalx.cHo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 11: 
          localalx.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 12: 
          localalx.kmn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 13: 
          localalx.kmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 14: 
          localalx.knw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 15: 
          localalx.kmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 16: 
          localalx.color = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 17: 
          localalx.qNB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28444);
          return 0;
        case 18: 
          localalx.qNC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 19: 
          localalx.qND = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 20: 
          localalx.qNE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 21: 
          localalx.kmq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28444);
          return 0;
        case 22: 
          localalx.qNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        case 23: 
          localalx.tXI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28444);
          return 0;
        }
        localalx.qNH = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(28444);
        return 0;
      }
      AppMethodBeat.o(28444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alx
 * JD-Core Version:    0.7.0.1
 */