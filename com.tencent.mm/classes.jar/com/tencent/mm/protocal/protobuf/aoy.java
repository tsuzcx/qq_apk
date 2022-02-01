package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoy
  extends cqk
{
  public FinderContact EDv;
  public int EHN;
  public String EHO;
  public String EHP;
  public String EHQ;
  public int EHR;
  public int EHS;
  public aah EHT;
  public int actionType;
  public int rGs;
  public int rGt;
  public amm verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.ln(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.EDv != null)
      {
        paramVarArgs.ln(4, this.EDv.computeSize());
        this.EDv.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EHN);
      if (this.EHO != null) {
        paramVarArgs.d(6, this.EHO);
      }
      if (this.EHP != null) {
        paramVarArgs.d(7, this.EHP);
      }
      if (this.EHQ != null) {
        paramVarArgs.d(8, this.EHQ);
      }
      paramVarArgs.aR(9, this.EHR);
      paramVarArgs.aR(10, this.rGt);
      paramVarArgs.aR(11, this.EHS);
      paramVarArgs.aR(12, this.rGs);
      if (this.EHT != null)
      {
        paramVarArgs.ln(13, this.EHT.computeSize());
        this.EHT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1226;
      }
    }
    label1226:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + f.a.a.a.lm(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.EDv != null) {
        i = paramInt + f.a.a.a.lm(4, this.EDv.computeSize());
      }
      i += f.a.a.b.b.a.bx(5, this.EHN);
      paramInt = i;
      if (this.EHO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EHO);
      }
      i = paramInt;
      if (this.EHP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EHP);
      }
      paramInt = i;
      if (this.EHQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EHQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.EHR) + f.a.a.b.b.a.bx(10, this.rGt) + f.a.a.b.b.a.bx(11, this.EHS) + f.a.a.b.b.a.bx(12, this.rGs);
      paramInt = i;
      if (this.EHT != null) {
        paramInt = i + f.a.a.a.lm(13, this.EHT.computeSize());
      }
      AppMethodBeat.o(169074);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoy localaoy = (aoy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169074);
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
            localaoy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localaoy.actionType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoy.verifyInfo = ((amm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoy.EDv = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localaoy.EHN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localaoy.EHO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localaoy.EHP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localaoy.EHQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localaoy.EHR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localaoy.rGt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localaoy.EHS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localaoy.rGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169074);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aah();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoy.EHT = ((aah)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoy
 * JD-Core Version:    0.7.0.1
 */