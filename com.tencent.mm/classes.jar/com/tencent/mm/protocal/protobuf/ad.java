package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ad
  extends cqk
{
  public String DLG;
  public int DLH;
  public int DLI;
  public String DLJ;
  public cyw DLK;
  public cnp DLL;
  public cyw DLM;
  public cjv DLN;
  public apy DLO;
  public hn DLP;
  public String DLQ;
  public String DLR;
  public int DLS;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32097);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DLG != null) {
        paramVarArgs.d(2, this.DLG);
      }
      paramVarArgs.aR(3, this.DLH);
      paramVarArgs.aR(4, this.DLI);
      if (this.DLJ != null) {
        paramVarArgs.d(5, this.DLJ);
      }
      if (this.DLK != null)
      {
        paramVarArgs.ln(6, this.DLK.computeSize());
        this.DLK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.OpCode);
      if (this.DLL != null)
      {
        paramVarArgs.ln(8, this.DLL.computeSize());
        this.DLL.writeFields(paramVarArgs);
      }
      if (this.DLM != null)
      {
        paramVarArgs.ln(9, this.DLM.computeSize());
        this.DLM.writeFields(paramVarArgs);
      }
      if (this.DLN != null)
      {
        paramVarArgs.ln(10, this.DLN.computeSize());
        this.DLN.writeFields(paramVarArgs);
      }
      if (this.DLO != null)
      {
        paramVarArgs.ln(11, this.DLO.computeSize());
        this.DLO.writeFields(paramVarArgs);
      }
      if (this.DLP != null)
      {
        paramVarArgs.ln(12, this.DLP.computeSize());
        this.DLP.writeFields(paramVarArgs);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(13, this.DLQ);
      }
      if (this.DLR != null) {
        paramVarArgs.d(14, this.DLR);
      }
      paramVarArgs.aR(15, this.DLS);
      AppMethodBeat.o(32097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DLG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DLG);
      }
      i = i + f.a.a.b.b.a.bx(3, this.DLH) + f.a.a.b.b.a.bx(4, this.DLI);
      paramInt = i;
      if (this.DLJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLJ);
      }
      i = paramInt;
      if (this.DLK != null) {
        i = paramInt + f.a.a.a.lm(6, this.DLK.computeSize());
      }
      i += f.a.a.b.b.a.bx(7, this.OpCode);
      paramInt = i;
      if (this.DLL != null) {
        paramInt = i + f.a.a.a.lm(8, this.DLL.computeSize());
      }
      i = paramInt;
      if (this.DLM != null) {
        i = paramInt + f.a.a.a.lm(9, this.DLM.computeSize());
      }
      paramInt = i;
      if (this.DLN != null) {
        paramInt = i + f.a.a.a.lm(10, this.DLN.computeSize());
      }
      i = paramInt;
      if (this.DLO != null) {
        i = paramInt + f.a.a.a.lm(11, this.DLO.computeSize());
      }
      paramInt = i;
      if (this.DLP != null) {
        paramInt = i + f.a.a.a.lm(12, this.DLP.computeSize());
      }
      i = paramInt;
      if (this.DLQ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DLQ);
      }
      paramInt = i;
      if (this.DLR != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DLR);
      }
      i = f.a.a.b.b.a.bx(15, this.DLS);
      AppMethodBeat.o(32097);
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
          AppMethodBeat.o(32097);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32097);
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
            localad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 2: 
          localad.DLG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 3: 
          localad.DLH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32097);
          return 0;
        case 4: 
          localad.DLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32097);
          return 0;
        case 5: 
          localad.DLJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLK = ((cyw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 7: 
          localad.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32097);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLL = ((cnp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLM = ((cyw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLN = ((cjv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLO = ((apy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.DLP = ((hn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 13: 
          localad.DLQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 14: 
          localad.DLR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32097);
          return 0;
        }
        localad.DLS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32097);
        return 0;
      }
      AppMethodBeat.o(32097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */