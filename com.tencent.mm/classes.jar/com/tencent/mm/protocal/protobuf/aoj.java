package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aoj
  extends cld
{
  public String Cth;
  public int Ctr;
  public String DpD;
  public String DpE;
  public SKBuiltinBuffer_t DpV;
  public String DpW;
  public String DpX;
  public bio DpY;
  public ant DpZ;
  public String Dqa;
  public int Dqb;
  public LinkedList<nm> Dqc;
  public String Dqd;
  public zn Dqe;
  public SKBuiltinBuffer_t Dqf;
  public int Dqg;
  public LinkedList<bgq> Dqh;
  public SKBuiltinBuffer_t Dqi;
  public SKBuiltinBuffer_t Dqj;
  public String SSID;
  public String Title;
  public String gKr;
  public String mAQ;
  public String sDZ;
  
  public aoj()
  {
    AppMethodBeat.i(152553);
    this.Dqc = new LinkedList();
    this.Dqh = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DpW != null) {
        paramVarArgs.d(2, this.DpW);
      }
      if (this.DpX != null) {
        paramVarArgs.d(3, this.DpX);
      }
      paramVarArgs.aR(4, this.Ctr);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.gKr != null) {
        paramVarArgs.d(6, this.gKr);
      }
      if (this.DpY != null)
      {
        paramVarArgs.kX(7, this.DpY.computeSize());
        this.DpY.writeFields(paramVarArgs);
      }
      if (this.DpZ != null)
      {
        paramVarArgs.kX(8, this.DpZ.computeSize());
        this.DpZ.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(9, this.mAQ);
      }
      if (this.Dqa != null) {
        paramVarArgs.d(15, this.Dqa);
      }
      paramVarArgs.aR(16, this.Dqb);
      paramVarArgs.e(17, 8, this.Dqc);
      if (this.Dqd != null) {
        paramVarArgs.d(18, this.Dqd);
      }
      if (this.SSID != null) {
        paramVarArgs.d(20, this.SSID);
      }
      if (this.Cth != null) {
        paramVarArgs.d(21, this.Cth);
      }
      if (this.Dqe != null)
      {
        paramVarArgs.kX(22, this.Dqe.computeSize());
        this.Dqe.writeFields(paramVarArgs);
      }
      if (this.Dqf != null)
      {
        paramVarArgs.kX(23, this.Dqf.computeSize());
        this.Dqf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.Dqg);
      paramVarArgs.e(25, 8, this.Dqh);
      if (this.sDZ != null) {
        paramVarArgs.d(26, this.sDZ);
      }
      if (this.DpD != null) {
        paramVarArgs.d(27, this.DpD);
      }
      if (this.DpV != null)
      {
        paramVarArgs.kX(28, this.DpV.computeSize());
        this.DpV.writeFields(paramVarArgs);
      }
      if (this.DpE != null) {
        paramVarArgs.d(29, this.DpE);
      }
      if (this.Dqi != null)
      {
        paramVarArgs.kX(30, this.Dqi.computeSize());
        this.Dqi.writeFields(paramVarArgs);
      }
      if (this.Dqj != null)
      {
        paramVarArgs.kX(31, this.Dqj.computeSize());
        this.Dqj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2630;
      }
    }
    label2630:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DpW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DpW);
      }
      i = paramInt;
      if (this.DpX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DpX);
      }
      i += f.a.a.b.b.a.bA(4, this.Ctr);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gKr);
      }
      paramInt = i;
      if (this.DpY != null) {
        paramInt = i + f.a.a.a.kW(7, this.DpY.computeSize());
      }
      i = paramInt;
      if (this.DpZ != null) {
        i = paramInt + f.a.a.a.kW(8, this.DpZ.computeSize());
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.mAQ);
      }
      i = paramInt;
      if (this.Dqa != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Dqa);
      }
      i = i + f.a.a.b.b.a.bA(16, this.Dqb) + f.a.a.a.c(17, 8, this.Dqc);
      paramInt = i;
      if (this.Dqd != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Dqd);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.SSID);
      }
      paramInt = i;
      if (this.Cth != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Cth);
      }
      i = paramInt;
      if (this.Dqe != null) {
        i = paramInt + f.a.a.a.kW(22, this.Dqe.computeSize());
      }
      paramInt = i;
      if (this.Dqf != null) {
        paramInt = i + f.a.a.a.kW(23, this.Dqf.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.Dqg) + f.a.a.a.c(25, 8, this.Dqh);
      paramInt = i;
      if (this.sDZ != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.sDZ);
      }
      i = paramInt;
      if (this.DpD != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.DpD);
      }
      paramInt = i;
      if (this.DpV != null) {
        paramInt = i + f.a.a.a.kW(28, this.DpV.computeSize());
      }
      i = paramInt;
      if (this.DpE != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.DpE);
      }
      paramInt = i;
      if (this.Dqi != null) {
        paramInt = i + f.a.a.a.kW(30, this.Dqi.computeSize());
      }
      i = paramInt;
      if (this.Dqj != null) {
        i = paramInt + f.a.a.a.kW(31, this.Dqj.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dqc.clear();
        this.Dqh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoj localaoj = (aoj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
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
            localaoj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localaoj.DpW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localaoj.DpX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localaoj.Ctr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localaoj.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localaoj.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.DpY = ((bio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ant();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ant)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.DpZ = ((ant)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localaoj.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localaoj.Dqa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localaoj.Dqb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Dqc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localaoj.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localaoj.SSID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localaoj.Cth = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Dqe = ((zn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Dqf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localaoj.Dqg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Dqh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localaoj.sDZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localaoj.DpD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.DpV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localaoj.DpE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Dqi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoj.Dqj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoj
 * JD-Core Version:    0.7.0.1
 */