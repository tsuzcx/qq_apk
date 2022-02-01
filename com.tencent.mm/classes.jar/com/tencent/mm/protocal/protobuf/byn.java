package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class byn
  extends erp
{
  public int ACR;
  public String ADE;
  public long ADo;
  public atz CJv;
  public String YIZ;
  public int ZDP;
  public aur ZDQ;
  public String ZJK;
  public String ZNN;
  public long aahl;
  public String firstPageMD5;
  public int hJx;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  public long maxId;
  public long object_id;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169070);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bv(3, this.maxId);
      if (this.firstPageMD5 != null) {
        paramVarArgs.g(4, this.firstPageMD5);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(5, this.YIZ);
      }
      paramVarArgs.bS(6, this.ZDP);
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(8, this.lastBuffer);
      }
      paramVarArgs.bS(9, this.ACR);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(10, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(11, this.ADo);
      paramVarArgs.bS(12, this.hJx);
      paramVarArgs.bv(13, this.object_id);
      if (this.ADE != null) {
        paramVarArgs.g(14, this.ADE);
      }
      paramVarArgs.l(15, this.longitude);
      paramVarArgs.l(16, this.latitude);
      paramVarArgs.bS(17, this.scene);
      paramVarArgs.bv(18, this.aahl);
      if (this.ZJK != null) {
        paramVarArgs.g(19, this.ZJK);
      }
      if (this.ZNN != null) {
        paramVarArgs.g(20, this.ZNN);
      }
      AppMethodBeat.o(169070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1430;
      }
    }
    label1430:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      i += i.a.a.b.b.a.q(3, this.maxId);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YIZ);
      }
      i += i.a.a.b.b.a.cJ(6, this.ZDP);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.lastBuffer);
      }
      i += i.a.a.b.b.a.cJ(9, this.ACR);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZDQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(11, this.ADo) + i.a.a.b.b.a.cJ(12, this.hJx) + i.a.a.b.b.a.q(13, this.object_id);
      paramInt = i;
      if (this.ADE != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ADE);
      }
      i = paramInt + (i.a.a.b.b.a.ko(15) + 4) + (i.a.a.b.b.a.ko(16) + 4) + i.a.a.b.b.a.cJ(17, this.scene) + i.a.a.b.b.a.q(18, this.aahl);
      paramInt = i;
      if (this.ZJK != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ZJK);
      }
      i = paramInt;
      if (this.ZNN != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.ZNN);
      }
      AppMethodBeat.o(169070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byn localbyn = (byn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169070);
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
            localbyn.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 2: 
          localbyn.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 3: 
          localbyn.maxId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169070);
          return 0;
        case 4: 
          localbyn.firstPageMD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 5: 
          localbyn.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 6: 
          localbyn.ZDP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169070);
          return 0;
        case 7: 
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
            localbyn.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 8: 
          localbyn.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169070);
          return 0;
        case 9: 
          localbyn.ACR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169070);
          return 0;
        case 10: 
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
            localbyn.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 11: 
          localbyn.ADo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169070);
          return 0;
        case 12: 
          localbyn.hJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169070);
          return 0;
        case 13: 
          localbyn.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169070);
          return 0;
        case 14: 
          localbyn.ADE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 15: 
          localbyn.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169070);
          return 0;
        case 16: 
          localbyn.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169070);
          return 0;
        case 17: 
          localbyn.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169070);
          return 0;
        case 18: 
          localbyn.aahl = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169070);
          return 0;
        case 19: 
          localbyn.ZJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169070);
          return 0;
        }
        localbyn.ZNN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169070);
        return 0;
      }
      AppMethodBeat.o(169070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byn
 * JD-Core Version:    0.7.0.1
 */