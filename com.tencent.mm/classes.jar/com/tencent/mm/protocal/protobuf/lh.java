package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lh
  extends cqk
{
  public int DNg;
  public cyu DTK;
  public String DTL;
  public int DTP;
  public bxk DYC;
  public String DYD;
  public int DYE;
  public String DYF;
  public bkh DYG;
  public oq DYH;
  public bxl DYI;
  public String DYJ;
  public int DYK;
  public crp DYL;
  public String DYM;
  public String DYN;
  public String DYO;
  public String DYP;
  public int DYQ;
  public int DYx;
  public String DYy;
  public String Username;
  public String ddJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(2, this.ddJ);
      }
      if (this.DYD != null) {
        paramVarArgs.d(3, this.DYD);
      }
      paramVarArgs.aR(4, this.DYE);
      if (this.DYF != null) {
        paramVarArgs.d(5, this.DYF);
      }
      if (this.Username != null) {
        paramVarArgs.d(6, this.Username);
      }
      if (this.DYG != null)
      {
        paramVarArgs.ln(7, this.DYG.computeSize());
        this.DYG.writeFields(paramVarArgs);
      }
      if (this.DYH != null)
      {
        paramVarArgs.ln(8, this.DYH.computeSize());
        this.DYH.writeFields(paramVarArgs);
      }
      if (this.DYI != null)
      {
        paramVarArgs.ln(9, this.DYI.computeSize());
        this.DYI.writeFields(paramVarArgs);
      }
      if (this.DTL != null) {
        paramVarArgs.d(10, this.DTL);
      }
      paramVarArgs.aR(11, this.DNg);
      if (this.DYJ != null) {
        paramVarArgs.d(12, this.DYJ);
      }
      paramVarArgs.aR(13, this.DYK);
      if (this.DYL != null)
      {
        paramVarArgs.ln(14, this.DYL.computeSize());
        this.DYL.writeFields(paramVarArgs);
      }
      if (this.DYM != null) {
        paramVarArgs.d(15, this.DYM);
      }
      if (this.DYN != null) {
        paramVarArgs.d(16, this.DYN);
      }
      if (this.DTK != null)
      {
        paramVarArgs.ln(17, this.DTK.computeSize());
        this.DTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(18, this.DTP);
      if (this.DYO != null) {
        paramVarArgs.d(19, this.DYO);
      }
      if (this.DYP != null) {
        paramVarArgs.d(20, this.DYP);
      }
      paramVarArgs.aR(21, this.DYx);
      if (this.DYy != null) {
        paramVarArgs.d(22, this.DYy);
      }
      paramVarArgs.aR(23, this.DYQ);
      if (this.DYC != null)
      {
        paramVarArgs.ln(24, this.DYC.computeSize());
        this.DYC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ddJ);
      }
      i = paramInt;
      if (this.DYD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYD);
      }
      i += f.a.a.b.b.a.bx(4, this.DYE);
      paramInt = i;
      if (this.DYF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DYF);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Username);
      }
      paramInt = i;
      if (this.DYG != null) {
        paramInt = i + f.a.a.a.lm(7, this.DYG.computeSize());
      }
      i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.a.lm(8, this.DYH.computeSize());
      }
      paramInt = i;
      if (this.DYI != null) {
        paramInt = i + f.a.a.a.lm(9, this.DYI.computeSize());
      }
      i = paramInt;
      if (this.DTL != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DTL);
      }
      i += f.a.a.b.b.a.bx(11, this.DNg);
      paramInt = i;
      if (this.DYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DYJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.DYK);
      paramInt = i;
      if (this.DYL != null) {
        paramInt = i + f.a.a.a.lm(14, this.DYL.computeSize());
      }
      i = paramInt;
      if (this.DYM != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DYM);
      }
      paramInt = i;
      if (this.DYN != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DYN);
      }
      i = paramInt;
      if (this.DTK != null) {
        i = paramInt + f.a.a.a.lm(17, this.DTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(18, this.DTP);
      paramInt = i;
      if (this.DYO != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DYO);
      }
      i = paramInt;
      if (this.DYP != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DYP);
      }
      i += f.a.a.b.b.a.bx(21, this.DYx);
      paramInt = i;
      if (this.DYy != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DYy);
      }
      i = paramInt + f.a.a.b.b.a.bx(23, this.DYQ);
      paramInt = i;
      if (this.DYC != null) {
        paramInt = i + f.a.a.a.lm(24, this.DYC.computeSize());
      }
      AppMethodBeat.o(134244);
      return paramInt;
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
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lh locallh = (lh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
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
            locallh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          locallh.ddJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          locallh.DYD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          locallh.DYE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          locallh.DYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          locallh.Username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.DYG = ((bkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.DYH = ((oq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.DYI = ((bxl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          locallh.DTL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          locallh.DNg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          locallh.DYJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          locallh.DYK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.DYL = ((crp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          locallh.DYM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          locallh.DYN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.DTK = ((cyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          locallh.DTP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          locallh.DYO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          locallh.DYP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          locallh.DYx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          locallh.DYy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          locallh.DYQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134244);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallh.DYC = ((bxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lh
 * JD-Core Version:    0.7.0.1
 */