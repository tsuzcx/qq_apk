package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aez
  extends cld
{
  public cgx CTW;
  public int dDO;
  public int dDP;
  public int dcG;
  public int deV;
  public String nTK;
  public String sZn;
  public String taA;
  public int taB;
  public String taC;
  public String taD;
  public int tav;
  public int tax;
  public String tay;
  public String taz;
  public String tdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.aR(4, this.deV);
      if (this.sZn != null) {
        paramVarArgs.d(5, this.sZn);
      }
      paramVarArgs.aR(6, this.dDO);
      paramVarArgs.aR(7, this.dDP);
      if (this.tdE != null) {
        paramVarArgs.d(8, this.tdE);
      }
      paramVarArgs.aR(9, this.tav);
      if (this.CTW != null)
      {
        paramVarArgs.kX(10, this.CTW.computeSize());
        this.CTW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.tax);
      if (this.tay != null) {
        paramVarArgs.d(12, this.tay);
      }
      if (this.taz != null) {
        paramVarArgs.d(13, this.taz);
      }
      if (this.taA != null) {
        paramVarArgs.d(14, this.taA);
      }
      paramVarArgs.aR(15, this.taB);
      if (this.taC != null) {
        paramVarArgs.d(16, this.taC);
      }
      if (this.taD != null) {
        paramVarArgs.d(17, this.taD);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1322;
      }
    }
    label1322:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.deV);
      paramInt = i;
      if (this.sZn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sZn);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.dDO) + f.a.a.b.b.a.bA(7, this.dDP);
      paramInt = i;
      if (this.tdE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tdE);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.tav);
      paramInt = i;
      if (this.CTW != null) {
        paramInt = i + f.a.a.a.kW(10, this.CTW.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.tax);
      paramInt = i;
      if (this.tay != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tay);
      }
      i = paramInt;
      if (this.taz != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.taz);
      }
      paramInt = i;
      if (this.taA != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.taA);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.taB);
      paramInt = i;
      if (this.taC != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.taC);
      }
      i = paramInt;
      if (this.taD != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.taD);
      }
      AppMethodBeat.o(91453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
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
            localaez.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localaez.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localaez.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localaez.deV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localaez.sZn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localaez.dDO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localaez.dDP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localaez.tdE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localaez.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaez.CTW = ((cgx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localaez.tax = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localaez.tay = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localaez.taz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localaez.taA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localaez.taB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localaez.taC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        localaez.taD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aez
 * JD-Core Version:    0.7.0.1
 */