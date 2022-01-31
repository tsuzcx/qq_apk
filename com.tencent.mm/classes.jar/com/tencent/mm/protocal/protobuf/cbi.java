package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbi
  extends bvk
{
  public String cHo;
  public String color;
  public String kml;
  public String kmm;
  public String kmn;
  public String kmo;
  public int kmq;
  public int knS;
  public String knw;
  public int qNB;
  public String qNC;
  public String qND;
  public String qNE;
  public String qNF;
  public String qNG;
  public boolean qNH;
  public int qNy;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28641);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28641);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.knS);
      if (this.kml != null) {
        paramVarArgs.e(3, this.kml);
      }
      if (this.cHo != null) {
        paramVarArgs.e(4, this.cHo);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.kmn != null) {
        paramVarArgs.e(6, this.kmn);
      }
      if (this.kmo != null) {
        paramVarArgs.e(7, this.kmo);
      }
      if (this.knw != null) {
        paramVarArgs.e(8, this.knw);
      }
      if (this.kmm != null) {
        paramVarArgs.e(9, this.kmm);
      }
      if (this.color != null) {
        paramVarArgs.e(10, this.color);
      }
      paramVarArgs.aO(11, this.qNy);
      paramVarArgs.aO(12, this.qNB);
      if (this.qNC != null) {
        paramVarArgs.e(13, this.qNC);
      }
      if (this.qND != null) {
        paramVarArgs.e(14, this.qND);
      }
      if (this.qNE != null) {
        paramVarArgs.e(19, this.qNE);
      }
      if (this.qNF != null) {
        paramVarArgs.e(21, this.qNF);
      }
      paramVarArgs.aO(22, this.kmq);
      if (this.qNG != null) {
        paramVarArgs.e(23, this.qNG);
      }
      paramVarArgs.aS(24, this.qNH);
      AppMethodBeat.o(28641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1431;
      }
    }
    label1431:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.knS);
      paramInt = i;
      if (this.kml != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kml);
      }
      i = paramInt;
      if (this.cHo != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.cHo);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.title);
      }
      i = paramInt;
      if (this.kmn != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.kmn);
      }
      paramInt = i;
      if (this.kmo != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.kmo);
      }
      i = paramInt;
      if (this.knw != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.knw);
      }
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.kmm);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.color);
      }
      i = i + e.a.a.b.b.a.bl(11, this.qNy) + e.a.a.b.b.a.bl(12, this.qNB);
      paramInt = i;
      if (this.qNC != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.qNC);
      }
      i = paramInt;
      if (this.qND != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.qND);
      }
      paramInt = i;
      if (this.qNE != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.qNE);
      }
      i = paramInt;
      if (this.qNF != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.qNF);
      }
      i += e.a.a.b.b.a.bl(22, this.kmq);
      paramInt = i;
      if (this.qNG != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.qNG);
      }
      i = e.a.a.b.b.a.eW(24);
      AppMethodBeat.o(28641);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(28641);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbi localcbi = (cbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(28641);
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
            localcbi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28641);
          return 0;
        case 2: 
          localcbi.knS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28641);
          return 0;
        case 3: 
          localcbi.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 4: 
          localcbi.cHo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 5: 
          localcbi.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 6: 
          localcbi.kmn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 7: 
          localcbi.kmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 8: 
          localcbi.knw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 9: 
          localcbi.kmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 10: 
          localcbi.color = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 11: 
          localcbi.qNy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28641);
          return 0;
        case 12: 
          localcbi.qNB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28641);
          return 0;
        case 13: 
          localcbi.qNC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 14: 
          localcbi.qND = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 19: 
          localcbi.qNE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 21: 
          localcbi.qNF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        case 22: 
          localcbi.kmq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28641);
          return 0;
        case 23: 
          localcbi.qNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28641);
          return 0;
        }
        localcbi.qNH = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(28641);
        return 0;
      }
      AppMethodBeat.o(28641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbi
 * JD-Core Version:    0.7.0.1
 */