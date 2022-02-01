package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhj
  extends cqk
{
  public String DWv;
  public int EWA;
  public String EWB;
  public String EWC;
  public int EWD;
  public String EWE;
  public int EWF;
  public int EWG;
  public bxj EWH;
  public String EWw;
  public int EWx;
  public String EWy;
  public LinkedList<bxj> EWz;
  public String EfG;
  public dzq EoS;
  public String dlQ;
  public int mUg;
  
  public bhj()
  {
    AppMethodBeat.i(123591);
    this.EWz = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EoS != null)
      {
        paramVarArgs.ln(2, this.EoS.computeSize());
        this.EoS.writeFields(paramVarArgs);
      }
      if (this.EWw != null) {
        paramVarArgs.d(3, this.EWw);
      }
      paramVarArgs.aR(4, this.EWx);
      paramVarArgs.aR(5, this.mUg);
      if (this.EWy != null) {
        paramVarArgs.d(6, this.EWy);
      }
      paramVarArgs.e(7, 8, this.EWz);
      paramVarArgs.aR(8, this.EWA);
      if (this.EWB != null) {
        paramVarArgs.d(9, this.EWB);
      }
      if (this.EWC != null) {
        paramVarArgs.d(10, this.EWC);
      }
      paramVarArgs.aR(11, this.EWD);
      if (this.dlQ != null) {
        paramVarArgs.d(12, this.dlQ);
      }
      if (this.DWv != null) {
        paramVarArgs.d(13, this.DWv);
      }
      if (this.EfG != null) {
        paramVarArgs.d(14, this.EfG);
      }
      if (this.EWE != null) {
        paramVarArgs.d(15, this.EWE);
      }
      paramVarArgs.aR(16, this.EWF);
      paramVarArgs.aR(17, this.EWG);
      if (this.EWH != null)
      {
        paramVarArgs.ln(18, this.EWH.computeSize());
        this.EWH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EoS != null) {
        paramInt = i + f.a.a.a.lm(2, this.EoS.computeSize());
      }
      i = paramInt;
      if (this.EWw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EWw);
      }
      i = i + f.a.a.b.b.a.bx(4, this.EWx) + f.a.a.b.b.a.bx(5, this.mUg);
      paramInt = i;
      if (this.EWy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EWy);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.EWz) + f.a.a.b.b.a.bx(8, this.EWA);
      paramInt = i;
      if (this.EWB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EWB);
      }
      i = paramInt;
      if (this.EWC != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EWC);
      }
      i += f.a.a.b.b.a.bx(11, this.EWD);
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dlQ);
      }
      i = paramInt;
      if (this.DWv != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DWv);
      }
      paramInt = i;
      if (this.EfG != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EfG);
      }
      i = paramInt;
      if (this.EWE != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.EWE);
      }
      i = i + f.a.a.b.b.a.bx(16, this.EWF) + f.a.a.b.b.a.bx(17, this.EWG);
      paramInt = i;
      if (this.EWH != null) {
        paramInt = i + f.a.a.a.lm(18, this.EWH.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EWz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhj localbhj = (bhj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhj.EoS = ((dzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localbhj.EWw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localbhj.EWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localbhj.mUg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localbhj.EWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhj.EWz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localbhj.EWA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localbhj.EWB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localbhj.EWC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localbhj.EWD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localbhj.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localbhj.DWv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localbhj.EfG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localbhj.EWE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localbhj.EWF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localbhj.EWG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhj.EWH = ((bxj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhj
 * JD-Core Version:    0.7.0.1
 */