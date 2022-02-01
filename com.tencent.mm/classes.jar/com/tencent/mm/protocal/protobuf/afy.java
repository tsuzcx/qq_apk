package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afy
  extends cqk
{
  public cma EmH;
  public int dBA;
  public int dBB;
  public int dae;
  public int dcp;
  public String oxf;
  public String uhB;
  public int uiK;
  public int uiM;
  public String uiN;
  public String uiO;
  public String uiP;
  public int uiQ;
  public String uiR;
  public String uiS;
  public String ulT;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.aR(4, this.dcp);
      if (this.uhB != null) {
        paramVarArgs.d(5, this.uhB);
      }
      paramVarArgs.aR(6, this.dBA);
      paramVarArgs.aR(7, this.dBB);
      if (this.ulT != null) {
        paramVarArgs.d(8, this.ulT);
      }
      paramVarArgs.aR(9, this.uiK);
      if (this.EmH != null)
      {
        paramVarArgs.ln(10, this.EmH.computeSize());
        this.EmH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.uiM);
      if (this.uiN != null) {
        paramVarArgs.d(12, this.uiN);
      }
      if (this.uiO != null) {
        paramVarArgs.d(13, this.uiO);
      }
      if (this.uiP != null) {
        paramVarArgs.d(14, this.uiP);
      }
      paramVarArgs.aR(15, this.uiQ);
      if (this.uiR != null) {
        paramVarArgs.d(16, this.uiR);
      }
      if (this.uiS != null) {
        paramVarArgs.d(17, this.uiS);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.dcp);
      paramInt = i;
      if (this.uhB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uhB);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.dBA) + f.a.a.b.b.a.bx(7, this.dBB);
      paramInt = i;
      if (this.ulT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ulT);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.uiK);
      paramInt = i;
      if (this.EmH != null) {
        paramInt = i + f.a.a.a.lm(10, this.EmH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.uiM);
      paramInt = i;
      if (this.uiN != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uiN);
      }
      i = paramInt;
      if (this.uiO != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uiO);
      }
      paramInt = i;
      if (this.uiP != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uiP);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.uiQ);
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.uiR);
      }
      i = paramInt;
      if (this.uiS != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.uiS);
      }
      AppMethodBeat.o(91453);
      return i;
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
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afy localafy = (afy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
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
            localafy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localafy.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localafy.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localafy.dcp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localafy.uhB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localafy.dBA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localafy.dBB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localafy.ulT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localafy.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cma();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafy.EmH = ((cma)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localafy.uiM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localafy.uiN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localafy.uiO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localafy.uiP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localafy.uiQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localafy.uiR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        localafy.uiS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afy
 * JD-Core Version:    0.7.0.1
 */