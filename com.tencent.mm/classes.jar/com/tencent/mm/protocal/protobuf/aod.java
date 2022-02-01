package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aod
  extends cpx
{
  public aiu EDL;
  public aix EEW;
  public LinkedList<btm> EFn;
  public LinkedList<dcw> EGL;
  public int EHc;
  public long EHd;
  public String EHe;
  public long EHf;
  public int diw;
  public float dmL;
  public float doB;
  public b lastBuffer;
  public int pullType;
  public String rfC;
  public String sessionId;
  
  public aod()
  {
    AppMethodBeat.i(184211);
    this.EFn = new LinkedList();
    this.EGL = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.rfC != null) {
        paramVarArgs.d(4, this.rfC);
      }
      paramVarArgs.aR(5, this.pullType);
      if (this.EDL != null)
      {
        paramVarArgs.ln(6, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      paramVarArgs.x(7, this.doB);
      paramVarArgs.x(8, this.dmL);
      if (this.sessionId != null) {
        paramVarArgs.d(9, this.sessionId);
      }
      if (this.EEW != null)
      {
        paramVarArgs.ln(10, this.EEW.computeSize());
        this.EEW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.EFn);
      paramVarArgs.aR(12, this.EHc);
      paramVarArgs.aR(13, this.diw);
      paramVarArgs.aO(14, this.EHd);
      if (this.EHe != null) {
        paramVarArgs.d(15, this.EHe);
      }
      paramVarArgs.e(16, 8, this.EGL);
      paramVarArgs.aO(17, this.EHf);
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1472;
      }
    }
    label1472:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.rfC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rfC);
      }
      i += f.a.a.b.b.a.bx(5, this.pullType);
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(6, this.EDL.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fK(7) + 4) + (f.a.a.b.b.a.fK(8) + 4);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionId);
      }
      i = paramInt;
      if (this.EEW != null) {
        i = paramInt + f.a.a.a.lm(10, this.EEW.computeSize());
      }
      i = i + f.a.a.a.c(11, 8, this.EFn) + f.a.a.b.b.a.bx(12, this.EHc) + f.a.a.b.b.a.bx(13, this.diw) + f.a.a.b.b.a.p(14, this.EHd);
      paramInt = i;
      if (this.EHe != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EHe);
      }
      i = f.a.a.a.c(16, 8, this.EGL);
      int j = f.a.a.b.b.a.p(17, this.EHf);
      AppMethodBeat.o(169056);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EFn.clear();
        this.EGL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localaod.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localaod.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localaod.pullType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localaod.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localaod.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localaod.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.EEW = ((aix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.EFn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localaod.EHc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localaod.diw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localaod.EHd = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localaod.EHe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.EGL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        }
        localaod.EHf = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */