package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class alh
  extends bvk
{
  public int cnK;
  public String kNv;
  public String tXI;
  public boolean tXJ;
  public String tXK;
  public String tXL;
  public String tXM;
  public String tXN;
  public String tXO;
  public String tXP;
  public boolean tXR;
  public LinkedList<auu> xce;
  
  public alh()
  {
    AppMethodBeat.i(142607);
    this.cnK = 0;
    this.kNv = "ok";
    this.xce = new LinkedList();
    AppMethodBeat.o(142607);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(142608);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(142608);
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
      if (this.tXI != null) {
        paramVarArgs.e(4, this.tXI);
      }
      paramVarArgs.aS(6, this.tXJ);
      if (this.tXK != null) {
        paramVarArgs.e(7, this.tXK);
      }
      if (this.tXL != null) {
        paramVarArgs.e(8, this.tXL);
      }
      if (this.tXM != null) {
        paramVarArgs.e(9, this.tXM);
      }
      if (this.tXN != null) {
        paramVarArgs.e(10, this.tXN);
      }
      if (this.tXO != null) {
        paramVarArgs.e(11, this.tXO);
      }
      if (this.tXP != null) {
        paramVarArgs.e(12, this.tXP);
      }
      paramVarArgs.e(13, 8, this.xce);
      paramVarArgs.aS(14, this.tXR);
      AppMethodBeat.o(142608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.tXI != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.tXI);
      }
      i += e.a.a.b.b.a.eW(6) + 1;
      paramInt = i;
      if (this.tXK != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.tXK);
      }
      i = paramInt;
      if (this.tXL != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.tXL);
      }
      paramInt = i;
      if (this.tXM != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.tXM);
      }
      i = paramInt;
      if (this.tXN != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.tXN);
      }
      paramInt = i;
      if (this.tXO != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.tXO);
      }
      i = paramInt;
      if (this.tXP != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.tXP);
      }
      paramInt = e.a.a.a.c(13, 8, this.xce);
      int j = e.a.a.b.b.a.eW(14);
      AppMethodBeat.o(142608);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xce.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(142608);
          throw paramVarArgs;
        }
        AppMethodBeat.o(142608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        alh localalh = (alh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(142608);
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
            localalh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(142608);
          return 0;
        case 2: 
          localalh.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(142608);
          return 0;
        case 3: 
          localalh.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 4: 
          localalh.tXI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 6: 
          localalh.tXJ = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(142608);
          return 0;
        case 7: 
          localalh.tXK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 8: 
          localalh.tXL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 9: 
          localalh.tXM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 10: 
          localalh.tXN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 11: 
          localalh.tXO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 12: 
          localalh.tXP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(142608);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalh.xce.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(142608);
          return 0;
        }
        localalh.tXR = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(142608);
        return 0;
      }
      AppMethodBeat.o(142608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alh
 * JD-Core Version:    0.7.0.1
 */