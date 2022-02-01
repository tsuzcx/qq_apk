package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdq
  extends cld
{
  public int CHC;
  public bxq DAN;
  public LinkedList<bry> DAT;
  public String DAU;
  public String DAV;
  public String DAW;
  public String DAX;
  public String DAY;
  public LinkedList<dvp> DAZ;
  public int DsC;
  public String dlB;
  public String dnK;
  public String ode;
  public int ret;
  public String url;
  
  public bdq()
  {
    AppMethodBeat.i(123588);
    this.DAT = new LinkedList();
    this.DAZ = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aR(4, this.DsC);
      if (this.dnK != null) {
        paramVarArgs.d(5, this.dnK);
      }
      if (this.DAN != null)
      {
        paramVarArgs.kX(6, this.DAN.computeSize());
        this.DAN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.DAT);
      if (this.DAU != null) {
        paramVarArgs.d(8, this.DAU);
      }
      if (this.ode != null) {
        paramVarArgs.d(9, this.ode);
      }
      paramVarArgs.aR(10, this.CHC);
      if (this.dlB != null) {
        paramVarArgs.d(11, this.dlB);
      }
      if (this.DAV != null) {
        paramVarArgs.d(12, this.DAV);
      }
      if (this.DAW != null) {
        paramVarArgs.d(13, this.DAW);
      }
      if (this.DAX != null) {
        paramVarArgs.d(14, this.DAX);
      }
      if (this.DAY != null) {
        paramVarArgs.d(15, this.DAY);
      }
      paramVarArgs.e(16, 8, this.DAZ);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DsC);
      paramInt = i;
      if (this.dnK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dnK);
      }
      i = paramInt;
      if (this.DAN != null) {
        i = paramInt + f.a.a.a.kW(6, this.DAN.computeSize());
      }
      i += f.a.a.a.c(7, 8, this.DAT);
      paramInt = i;
      if (this.DAU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DAU);
      }
      i = paramInt;
      if (this.ode != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ode);
      }
      i += f.a.a.b.b.a.bA(10, this.CHC);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dlB);
      }
      i = paramInt;
      if (this.DAV != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DAV);
      }
      paramInt = i;
      if (this.DAW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DAW);
      }
      i = paramInt;
      if (this.DAX != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DAX);
      }
      paramInt = i;
      if (this.DAY != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DAY);
      }
      i = f.a.a.a.c(16, 8, this.DAZ);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DAT.clear();
        this.DAZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
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
            localbdq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localbdq.ret = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localbdq.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localbdq.DsC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localbdq.dnK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.DAN = ((bxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.DAT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localbdq.DAU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localbdq.ode = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localbdq.CHC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localbdq.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localbdq.DAV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localbdq.DAW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localbdq.DAX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localbdq.DAY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdq.DAZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdq
 * JD-Core Version:    0.7.0.1
 */