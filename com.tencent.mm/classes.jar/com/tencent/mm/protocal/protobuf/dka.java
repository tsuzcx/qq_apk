package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dka
  extends cqk
{
  public String DKS;
  public String DQt;
  public String FSC;
  public String FSR;
  public String FST;
  public int FSU;
  public int FSV;
  public coc FSW;
  public wo FSX;
  public cod FSY;
  public String FSZ;
  public coc FSy;
  public String djr;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.FSU);
      if (this.FSy != null)
      {
        paramVarArgs.ln(5, this.FSy.computeSize());
        this.FSy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FSV);
      if (this.FSW != null)
      {
        paramVarArgs.ln(7, this.FSW.computeSize());
        this.FSW.writeFields(paramVarArgs);
      }
      if (this.FSX != null)
      {
        paramVarArgs.ln(8, this.FSX.computeSize());
        this.FSX.writeFields(paramVarArgs);
      }
      if (this.FSY != null)
      {
        paramVarArgs.ln(9, this.FSY.computeSize());
        this.FSY.writeFields(paramVarArgs);
      }
      if (this.djr != null) {
        paramVarArgs.d(10, this.djr);
      }
      if (this.DKS != null) {
        paramVarArgs.d(11, this.DKS);
      }
      if (this.DQt != null) {
        paramVarArgs.d(12, this.DQt);
      }
      if (this.FSR != null) {
        paramVarArgs.d(13, this.FSR);
      }
      if (this.FSZ != null) {
        paramVarArgs.d(14, this.FSZ);
      }
      if (this.FST != null) {
        paramVarArgs.d(15, this.FST);
      }
      if (this.FSC != null) {
        paramVarArgs.d(16, this.FSC);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1562;
      }
    }
    label1562:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.FSU);
      paramInt = i;
      if (this.FSy != null) {
        paramInt = i + f.a.a.a.lm(5, this.FSy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FSV);
      paramInt = i;
      if (this.FSW != null) {
        paramInt = i + f.a.a.a.lm(7, this.FSW.computeSize());
      }
      i = paramInt;
      if (this.FSX != null) {
        i = paramInt + f.a.a.a.lm(8, this.FSX.computeSize());
      }
      paramInt = i;
      if (this.FSY != null) {
        paramInt = i + f.a.a.a.lm(9, this.FSY.computeSize());
      }
      i = paramInt;
      if (this.djr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.djr);
      }
      paramInt = i;
      if (this.DKS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DKS);
      }
      i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DQt);
      }
      paramInt = i;
      if (this.FSR != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FSR);
      }
      i = paramInt;
      if (this.FSZ != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FSZ);
      }
      paramInt = i;
      if (this.FST != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FST);
      }
      i = paramInt;
      if (this.FSC != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.FSC);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dka localdka = (dka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
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
            localdka.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localdka.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localdka.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localdka.FSU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdka.FSy = ((coc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localdka.FSV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdka.FSW = ((coc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdka.FSX = ((wo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdka.FSY = ((cod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localdka.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localdka.DKS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localdka.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localdka.FSR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localdka.FSZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localdka.FST = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localdka.FSC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dka
 * JD-Core Version:    0.7.0.1
 */