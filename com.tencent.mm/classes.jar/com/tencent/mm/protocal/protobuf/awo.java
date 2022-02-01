package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class awo
  extends erp
{
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public int ZHD;
  public LinkedList<fhp> ZHE;
  public LinkedList<byg> ZHF;
  public int ZHG;
  public float latitude;
  public float longitude;
  public long object_id;
  public String object_nonce_id;
  
  public awo()
  {
    AppMethodBeat.i(260090);
    this.ZHE = new LinkedList();
    this.ZHF = new LinkedList();
    AppMethodBeat.o(260090);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260101);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bv(4, this.object_id);
      paramVarArgs.bS(5, this.ZHD);
      paramVarArgs.l(6, this.longitude);
      paramVarArgs.l(7, this.latitude);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      paramVarArgs.e(9, 8, this.ZHE);
      paramVarArgs.e(10, 8, this.ZHF);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(11, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.ZHG);
      AppMethodBeat.o(260101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1134;
      }
    }
    label1134:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i + i.a.a.b.b.a.q(4, this.object_id) + i.a.a.b.b.a.cJ(5, this.ZHD) + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = paramInt + i.a.a.a.c(9, 8, this.ZHE) + i.a.a.a.c(10, 8, this.ZHF);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(11, this.ZDQ.computeSize());
      }
      i = i.a.a.b.b.a.cJ(12, this.ZHG);
      AppMethodBeat.o(260101);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZHE.clear();
        this.ZHF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260101);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awo localawo = (awo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260101);
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
            localawo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260101);
          return 0;
        case 2: 
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
            localawo.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260101);
          return 0;
        case 3: 
          localawo.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260101);
          return 0;
        case 4: 
          localawo.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260101);
          return 0;
        case 5: 
          localawo.ZHD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260101);
          return 0;
        case 6: 
          localawo.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260101);
          return 0;
        case 7: 
          localawo.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260101);
          return 0;
        case 8: 
          localawo.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260101);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhp)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260101);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byg)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.ZHF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260101);
          return 0;
        case 11: 
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
            localawo.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260101);
          return 0;
        }
        localawo.ZHG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260101);
        return 0;
      }
      AppMethodBeat.o(260101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awo
 * JD-Core Version:    0.7.0.1
 */