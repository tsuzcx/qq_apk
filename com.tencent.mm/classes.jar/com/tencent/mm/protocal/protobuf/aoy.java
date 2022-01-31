package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aoy
  extends bvk
{
  public int cnK;
  public String kNv;
  public boolean ubw;
  public String xeG;
  public String xeH;
  public String xeI;
  public String xeJ;
  public String xeK;
  public boolean xeL;
  public String xeM;
  public long xeN;
  public boolean xeO;
  public boolean xeP;
  public boolean xeQ;
  public String xeR;
  public String xeS;
  public String xeT;
  public String xeU;
  public boolean xeV;
  public LinkedList<String> xeW;
  public aym xeX;
  public boolean xeY;
  public boolean xeZ;
  
  public aoy()
  {
    AppMethodBeat.i(56834);
    this.xeW = new LinkedList();
    AppMethodBeat.o(56834);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56835);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56835);
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
      if (this.xeG != null) {
        paramVarArgs.e(4, this.xeG);
      }
      if (this.xeH != null) {
        paramVarArgs.e(5, this.xeH);
      }
      if (this.xeI != null) {
        paramVarArgs.e(6, this.xeI);
      }
      if (this.xeJ != null) {
        paramVarArgs.e(7, this.xeJ);
      }
      if (this.xeK != null) {
        paramVarArgs.e(8, this.xeK);
      }
      paramVarArgs.aS(9, this.xeL);
      if (this.xeM != null) {
        paramVarArgs.e(10, this.xeM);
      }
      paramVarArgs.am(11, this.xeN);
      paramVarArgs.aS(12, this.xeO);
      paramVarArgs.aS(13, this.xeP);
      paramVarArgs.aS(14, this.xeQ);
      if (this.xeR != null) {
        paramVarArgs.e(15, this.xeR);
      }
      if (this.xeS != null) {
        paramVarArgs.e(16, this.xeS);
      }
      if (this.xeT != null) {
        paramVarArgs.e(17, this.xeT);
      }
      if (this.xeU != null) {
        paramVarArgs.e(18, this.xeU);
      }
      paramVarArgs.aS(19, this.xeV);
      paramVarArgs.e(20, 1, this.xeW);
      paramVarArgs.aS(21, this.ubw);
      if (this.xeX != null)
      {
        paramVarArgs.iQ(22, this.xeX.computeSize());
        this.xeX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.xeY);
      paramVarArgs.aS(26, this.xeZ);
      AppMethodBeat.o(56835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1694;
      }
    }
    label1694:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.xeG != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xeG);
      }
      paramInt = i;
      if (this.xeH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xeH);
      }
      i = paramInt;
      if (this.xeI != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xeI);
      }
      paramInt = i;
      if (this.xeJ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xeJ);
      }
      i = paramInt;
      if (this.xeK != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xeK);
      }
      i += e.a.a.b.b.a.eW(9) + 1;
      paramInt = i;
      if (this.xeM != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xeM);
      }
      i = paramInt + e.a.a.b.b.a.p(11, this.xeN) + (e.a.a.b.b.a.eW(12) + 1) + (e.a.a.b.b.a.eW(13) + 1) + (e.a.a.b.b.a.eW(14) + 1);
      paramInt = i;
      if (this.xeR != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.xeR);
      }
      i = paramInt;
      if (this.xeS != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.xeS);
      }
      paramInt = i;
      if (this.xeT != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xeT);
      }
      i = paramInt;
      if (this.xeU != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.xeU);
      }
      i = i + (e.a.a.b.b.a.eW(19) + 1) + e.a.a.a.c(20, 1, this.xeW) + (e.a.a.b.b.a.eW(21) + 1);
      paramInt = i;
      if (this.xeX != null) {
        paramInt = i + e.a.a.a.iP(22, this.xeX.computeSize());
      }
      i = e.a.a.b.b.a.eW(23);
      int j = e.a.a.b.b.a.eW(26);
      AppMethodBeat.o(56835);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xeW.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aoy localaoy = (aoy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(56835);
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
            localaoy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56835);
          return 0;
        case 2: 
          localaoy.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56835);
          return 0;
        case 3: 
          localaoy.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 4: 
          localaoy.xeG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 5: 
          localaoy.xeH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 6: 
          localaoy.xeI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 7: 
          localaoy.xeJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 8: 
          localaoy.xeK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 9: 
          localaoy.xeL = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 10: 
          localaoy.xeM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 11: 
          localaoy.xeN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56835);
          return 0;
        case 12: 
          localaoy.xeO = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 13: 
          localaoy.xeP = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 14: 
          localaoy.xeQ = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 15: 
          localaoy.xeR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 16: 
          localaoy.xeS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 17: 
          localaoy.xeT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 18: 
          localaoy.xeU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56835);
          return 0;
        case 19: 
          localaoy.xeV = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 20: 
          localaoy.xeW.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56835);
          return 0;
        case 21: 
          localaoy.ubw = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aym();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aym)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaoy.xeX = ((aym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56835);
          return 0;
        case 23: 
          localaoy.xeY = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56835);
          return 0;
        }
        localaoy.xeZ = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(56835);
        return 0;
      }
      AppMethodBeat.o(56835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoy
 * JD-Core Version:    0.7.0.1
 */