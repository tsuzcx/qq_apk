package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayk
  extends erp
{
  public long AAW;
  public int AAY;
  public long ABa;
  public atz CJv;
  public aur ZDQ;
  public long ZJe;
  public int ZJf;
  public String ZJg;
  public int ZJh;
  public int ZJi;
  public int ZJj;
  public bkr ZJk;
  public int direction;
  public String finderUsername;
  public long hKN;
  public b lastBuffer;
  public float latitude;
  public b likeBuffer;
  public float longitude;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.hKN);
      paramVarArgs.bv(3, this.ZJe);
      paramVarArgs.bS(4, this.ZJf);
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      paramVarArgs.bv(6, this.ABa);
      if (this.finderUsername != null) {
        paramVarArgs.g(7, this.finderUsername);
      }
      paramVarArgs.bv(8, this.AAW);
      paramVarArgs.bS(9, this.scene);
      paramVarArgs.bS(10, this.direction);
      if (this.ZJg != null) {
        paramVarArgs.g(11, this.ZJg);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.g(12, this.objectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(13, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.ZJh);
      paramVarArgs.bS(15, this.AAY);
      if (this.likeBuffer != null) {
        paramVarArgs.d(16, this.likeBuffer);
      }
      paramVarArgs.bS(17, this.ZJi);
      paramVarArgs.bS(18, this.ZJj);
      paramVarArgs.l(19, this.longitude);
      paramVarArgs.l(20, this.latitude);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(21, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.ZJk != null)
      {
        paramVarArgs.qD(22, this.ZJk.computeSize());
        this.ZJk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1572;
      }
    }
    label1572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.hKN) + i.a.a.b.b.a.q(3, this.ZJe) + i.a.a.b.b.a.cJ(4, this.ZJf);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.ABa);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.AAW) + i.a.a.b.b.a.cJ(9, this.scene) + i.a.a.b.b.a.cJ(10, this.direction);
      paramInt = i;
      if (this.ZJg != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZJg);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(13, this.CJv.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.ZJh) + i.a.a.b.b.a.cJ(15, this.AAY);
      paramInt = i;
      if (this.likeBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.likeBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.ZJi) + i.a.a.b.b.a.cJ(18, this.ZJj) + (i.a.a.b.b.a.ko(19) + 4) + (i.a.a.b.b.a.ko(20) + 4);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(21, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.ZJk != null) {
        i = paramInt + i.a.a.a.qC(22, this.ZJk.computeSize());
      }
      AppMethodBeat.o(168973);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayk localayk = (ayk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localayk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localayk.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localayk.ZJe = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localayk.ZJf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localayk.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localayk.ABa = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localayk.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localayk.AAW = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localayk.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localayk.direction = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localayk.ZJg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localayk.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localayk.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 14: 
          localayk.ZJh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 15: 
          localayk.AAY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 16: 
          localayk.likeBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168973);
          return 0;
        case 17: 
          localayk.ZJi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 18: 
          localayk.ZJj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168973);
          return 0;
        case 19: 
          localayk.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(168973);
          return 0;
        case 20: 
          localayk.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(168973);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localayk.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkr)localObject2).parseFrom((byte[])localObject1);
          }
          localayk.ZJk = ((bkr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayk
 * JD-Core Version:    0.7.0.1
 */