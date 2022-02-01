package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnj
  extends cqk
{
  public int CreateTime;
  public crm DPT;
  public crm DPU;
  public String DPY;
  public String DUJ;
  public String EhA;
  public int EhF;
  public crm FUT;
  public int vTH;
  public int vTI;
  public int vTJ;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152720);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.FUT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTO);
      if (this.FUT != null)
      {
        paramVarArgs.ln(3, this.FUT.computeSize());
        this.FUT.writeFields(paramVarArgs);
      }
      if (this.DPT != null)
      {
        paramVarArgs.ln(4, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(5, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.vTH);
      paramVarArgs.aR(7, this.vTI);
      paramVarArgs.aR(8, this.vTJ);
      paramVarArgs.aR(9, this.CreateTime);
      paramVarArgs.aO(10, this.vTQ);
      if (this.EhA != null) {
        paramVarArgs.d(11, this.EhA);
      }
      if (this.DUJ != null) {
        paramVarArgs.d(12, this.DUJ);
      }
      if (this.DPY != null) {
        paramVarArgs.d(13, this.DPY);
      }
      paramVarArgs.aR(14, this.EhF);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1462;
      }
    }
    label1462:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTO);
      paramInt = i;
      if (this.FUT != null) {
        paramInt = i + f.a.a.a.lm(3, this.FUT.computeSize());
      }
      i = paramInt;
      if (this.DPT != null) {
        i = paramInt + f.a.a.a.lm(4, this.DPT.computeSize());
      }
      paramInt = i;
      if (this.DPU != null) {
        paramInt = i + f.a.a.a.lm(5, this.DPU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.vTH) + f.a.a.b.b.a.bx(7, this.vTI) + f.a.a.b.b.a.bx(8, this.vTJ) + f.a.a.b.b.a.bx(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.vTQ);
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EhA);
      }
      i = paramInt;
      if (this.DUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DUJ);
      }
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DPY);
      }
      i = f.a.a.b.b.a.bx(14, this.EhF);
      AppMethodBeat.o(152720);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.FUT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.DPT == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.DPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnj localdnj = (dnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
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
            localdnj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localdnj.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnj.FUT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnj.DPT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnj.DPU = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localdnj.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localdnj.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localdnj.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localdnj.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localdnj.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localdnj.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localdnj.DUJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localdnj.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localdnj.EhF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */