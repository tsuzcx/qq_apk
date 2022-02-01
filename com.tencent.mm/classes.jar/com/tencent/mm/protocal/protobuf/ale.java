package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ale
  extends cpx
{
  public aiu EDu;
  public String EET;
  public String EEU;
  public aiv EEV;
  public aix EEW;
  public ald EEX;
  public int diw;
  public float dmL;
  public float doB;
  public String dvw;
  public b lastBuffer;
  public String objectNonceId;
  public long qXP;
  public anu qYj;
  public b qZd;
  public int scene;
  public String zTO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195081);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EDu != null)
      {
        paramVarArgs.ln(2, this.EDu.computeSize());
        this.EDu.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aO(4, this.qXP);
      paramVarArgs.aR(5, this.diw);
      paramVarArgs.x(6, this.doB);
      paramVarArgs.x(7, this.dmL);
      if (this.objectNonceId != null) {
        paramVarArgs.d(8, this.objectNonceId);
      }
      if (this.EET != null) {
        paramVarArgs.d(9, this.EET);
      }
      paramVarArgs.aR(10, this.scene);
      if (this.EEU != null) {
        paramVarArgs.d(11, this.EEU);
      }
      if (this.qYj != null)
      {
        paramVarArgs.ln(12, this.qYj.computeSize());
        this.qYj.writeFields(paramVarArgs);
      }
      if (this.EEV != null)
      {
        paramVarArgs.ln(13, this.EEV.computeSize());
        this.EEV.writeFields(paramVarArgs);
      }
      if (this.qZd != null) {
        paramVarArgs.c(14, this.qZd);
      }
      if (this.EEW != null)
      {
        paramVarArgs.ln(15, this.EEW.computeSize());
        this.EEW.writeFields(paramVarArgs);
      }
      if (this.zTO != null) {
        paramVarArgs.d(16, this.zTO);
      }
      if (this.dvw != null) {
        paramVarArgs.d(17, this.dvw);
      }
      if (this.EEX != null)
      {
        paramVarArgs.ln(18, this.EEX.computeSize());
        this.EEX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195081);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1744;
      }
    }
    label1744:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EDu != null) {
        paramInt = i + f.a.a.a.lm(2, this.EDu.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + f.a.a.b.b.a.p(4, this.qXP) + f.a.a.b.b.a.bx(5, this.diw) + (f.a.a.b.b.a.fK(6) + 4) + (f.a.a.b.b.a.fK(7) + 4);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.EET != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EET);
      }
      i += f.a.a.b.b.a.bx(10, this.scene);
      paramInt = i;
      if (this.EEU != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EEU);
      }
      i = paramInt;
      if (this.qYj != null) {
        i = paramInt + f.a.a.a.lm(12, this.qYj.computeSize());
      }
      paramInt = i;
      if (this.EEV != null) {
        paramInt = i + f.a.a.a.lm(13, this.EEV.computeSize());
      }
      i = paramInt;
      if (this.qZd != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.qZd);
      }
      paramInt = i;
      if (this.EEW != null) {
        paramInt = i + f.a.a.a.lm(15, this.EEW.computeSize());
      }
      i = paramInt;
      if (this.zTO != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.zTO);
      }
      paramInt = i;
      if (this.dvw != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.dvw);
      }
      i = paramInt;
      if (this.EEX != null) {
        i = paramInt + f.a.a.a.lm(18, this.EEX.computeSize());
      }
      AppMethodBeat.o(195081);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195081);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ale localale = (ale)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195081);
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
            localale.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195081);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localale.EDu = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195081);
          return 0;
        case 3: 
          localale.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(195081);
          return 0;
        case 4: 
          localale.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(195081);
          return 0;
        case 5: 
          localale.diw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195081);
          return 0;
        case 6: 
          localale.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(195081);
          return 0;
        case 7: 
          localale.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(195081);
          return 0;
        case 8: 
          localale.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195081);
          return 0;
        case 9: 
          localale.EET = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195081);
          return 0;
        case 10: 
          localale.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195081);
          return 0;
        case 11: 
          localale.EEU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195081);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localale.qYj = ((anu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195081);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localale.EEV = ((aiv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195081);
          return 0;
        case 14: 
          localale.qZd = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(195081);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localale.EEW = ((aix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195081);
          return 0;
        case 16: 
          localale.zTO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195081);
          return 0;
        case 17: 
          localale.dvw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195081);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ald();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localale.EEX = ((ald)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195081);
        return 0;
      }
      AppMethodBeat.o(195081);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ale
 * JD-Core Version:    0.7.0.1
 */