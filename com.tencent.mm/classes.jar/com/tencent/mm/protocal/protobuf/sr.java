package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sr
  extends cqk
{
  public String BsL;
  public LinkedList<buh> EmA;
  public buh EmB;
  public String EmC;
  public boolean EmD;
  public String EmE;
  public int EmF;
  public buo EmG;
  public cma EmH;
  public String EmI;
  public String EmJ;
  public String EmK;
  public civ EmL;
  public civ EmM;
  public civ EmN;
  public com.tencent.mm.bw.b EmO;
  public int Emt;
  public int dae;
  public String iAx;
  public String iAy;
  public String url;
  public int wLq;
  public String wLr;
  public String wLs;
  
  public sr()
  {
    AppMethodBeat.i(91406);
    this.EmA = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(3, 8, this.EmA);
      if (this.EmB != null)
      {
        paramVarArgs.ln(4, this.EmB.computeSize());
        this.EmB.writeFields(paramVarArgs);
      }
      if (this.BsL != null) {
        paramVarArgs.d(5, this.BsL);
      }
      if (this.EmC != null) {
        paramVarArgs.d(6, this.EmC);
      }
      paramVarArgs.bl(7, this.EmD);
      paramVarArgs.aR(8, this.wLq);
      if (this.EmE != null) {
        paramVarArgs.d(9, this.EmE);
      }
      if (this.wLr != null) {
        paramVarArgs.d(10, this.wLr);
      }
      if (this.wLs != null) {
        paramVarArgs.d(11, this.wLs);
      }
      paramVarArgs.aR(12, this.EmF);
      if (this.EmG != null)
      {
        paramVarArgs.ln(13, this.EmG.computeSize());
        this.EmG.writeFields(paramVarArgs);
      }
      if (this.EmH != null)
      {
        paramVarArgs.ln(14, this.EmH.computeSize());
        this.EmH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.dae);
      paramVarArgs.aR(16, this.Emt);
      if (this.iAx != null) {
        paramVarArgs.d(17, this.iAx);
      }
      if (this.iAy != null) {
        paramVarArgs.d(18, this.iAy);
      }
      if (this.EmI != null) {
        paramVarArgs.d(19, this.EmI);
      }
      if (this.EmJ != null) {
        paramVarArgs.d(20, this.EmJ);
      }
      if (this.EmK != null) {
        paramVarArgs.d(21, this.EmK);
      }
      if (this.EmL != null)
      {
        paramVarArgs.ln(22, this.EmL.computeSize());
        this.EmL.writeFields(paramVarArgs);
      }
      if (this.EmM != null)
      {
        paramVarArgs.ln(23, this.EmM.computeSize());
        this.EmM.writeFields(paramVarArgs);
      }
      if (this.EmN != null)
      {
        paramVarArgs.ln(24, this.EmN.computeSize());
        this.EmN.writeFields(paramVarArgs);
      }
      if (this.EmO != null) {
        paramVarArgs.c(25, this.EmO);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2398;
      }
    }
    label2398:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(3, 8, this.EmA);
      paramInt = i;
      if (this.EmB != null) {
        paramInt = i + f.a.a.a.lm(4, this.EmB.computeSize());
      }
      i = paramInt;
      if (this.BsL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.BsL);
      }
      paramInt = i;
      if (this.EmC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EmC);
      }
      i = paramInt + (f.a.a.b.b.a.fK(7) + 1) + f.a.a.b.b.a.bx(8, this.wLq);
      paramInt = i;
      if (this.EmE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EmE);
      }
      i = paramInt;
      if (this.wLr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.wLr);
      }
      paramInt = i;
      if (this.wLs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.wLs);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.EmF);
      paramInt = i;
      if (this.EmG != null) {
        paramInt = i + f.a.a.a.lm(13, this.EmG.computeSize());
      }
      i = paramInt;
      if (this.EmH != null) {
        i = paramInt + f.a.a.a.lm(14, this.EmH.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(15, this.dae) + f.a.a.b.b.a.bx(16, this.Emt);
      paramInt = i;
      if (this.iAx != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.iAx);
      }
      i = paramInt;
      if (this.iAy != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.iAy);
      }
      paramInt = i;
      if (this.EmI != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EmI);
      }
      i = paramInt;
      if (this.EmJ != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.EmJ);
      }
      paramInt = i;
      if (this.EmK != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.EmK);
      }
      i = paramInt;
      if (this.EmL != null) {
        i = paramInt + f.a.a.a.lm(22, this.EmL.computeSize());
      }
      paramInt = i;
      if (this.EmM != null) {
        paramInt = i + f.a.a.a.lm(23, this.EmM.computeSize());
      }
      i = paramInt;
      if (this.EmN != null) {
        i = paramInt + f.a.a.a.lm(24, this.EmN.computeSize());
      }
      paramInt = i;
      if (this.EmO != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.EmO);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sr localsr = (sr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
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
            localsr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localsr.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmB = ((buh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localsr.BsL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localsr.EmC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localsr.EmD = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localsr.wLq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localsr.EmE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localsr.wLr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localsr.wLs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localsr.EmF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmG = ((buo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cma();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmH = ((cma)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localsr.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localsr.Emt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localsr.iAx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localsr.iAy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localsr.EmI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localsr.EmJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localsr.EmK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmL = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmM = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsr.EmN = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localsr.EmO = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sr
 * JD-Core Version:    0.7.0.1
 */