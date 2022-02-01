package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awe
  extends cld
{
  public LinkedList<qq> CQu;
  public int DsQ;
  public rc DsS;
  public String DsT;
  public int DsU;
  public int DsV;
  public rl DsW;
  public String DvA;
  public String DvB;
  public rc Dvz;
  public int ntx;
  public String nty;
  public int ocT;
  
  public awe()
  {
    AppMethodBeat.i(192651);
    this.CQu = new LinkedList();
    AppMethodBeat.o(192651);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(192652);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.ocT);
      paramVarArgs.aR(5, this.DsQ);
      paramVarArgs.e(6, 8, this.CQu);
      if (this.DsW != null)
      {
        paramVarArgs.kX(7, this.DsW.computeSize());
        this.DsW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DsU);
      paramVarArgs.aR(9, this.DsV);
      if (this.DsS != null)
      {
        paramVarArgs.kX(10, this.DsS.computeSize());
        this.DsS.writeFields(paramVarArgs);
      }
      if (this.DsT != null) {
        paramVarArgs.d(11, this.DsT);
      }
      if (this.Dvz != null)
      {
        paramVarArgs.kX(12, this.Dvz.computeSize());
        this.Dvz.writeFields(paramVarArgs);
      }
      if (this.DvA != null) {
        paramVarArgs.d(13, this.DvA);
      }
      if (this.DvB != null) {
        paramVarArgs.d(14, this.DvB);
      }
      AppMethodBeat.o(192652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.ocT) + f.a.a.b.b.a.bA(5, this.DsQ) + f.a.a.a.c(6, 8, this.CQu);
      paramInt = i;
      if (this.DsW != null) {
        paramInt = i + f.a.a.a.kW(7, this.DsW.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.DsU) + f.a.a.b.b.a.bA(9, this.DsV);
      paramInt = i;
      if (this.DsS != null) {
        paramInt = i + f.a.a.a.kW(10, this.DsS.computeSize());
      }
      i = paramInt;
      if (this.DsT != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DsT);
      }
      paramInt = i;
      if (this.Dvz != null) {
        paramInt = i + f.a.a.a.kW(12, this.Dvz.computeSize());
      }
      i = paramInt;
      if (this.DvA != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DvA);
      }
      paramInt = i;
      if (this.DvB != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DvB);
      }
      AppMethodBeat.o(192652);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CQu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(192652);
          throw paramVarArgs;
        }
        AppMethodBeat.o(192652);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awe localawe = (awe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192652);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192652);
          return 0;
        case 2: 
          localawe.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192652);
          return 0;
        case 3: 
          localawe.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192652);
          return 0;
        case 4: 
          localawe.ocT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192652);
          return 0;
        case 5: 
          localawe.DsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192652);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawe.CQu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192652);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawe.DsW = ((rl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192652);
          return 0;
        case 8: 
          localawe.DsU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192652);
          return 0;
        case 9: 
          localawe.DsV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192652);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawe.DsS = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192652);
          return 0;
        case 11: 
          localawe.DsT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192652);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawe.Dvz = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192652);
          return 0;
        case 13: 
          localawe.DvA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192652);
          return 0;
        }
        localawe.DvB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(192652);
        return 0;
      }
      AppMethodBeat.o(192652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awe
 * JD-Core Version:    0.7.0.1
 */