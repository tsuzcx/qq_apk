package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bsw
  extends erp
{
  public atz CJv;
  public int EUp;
  public long aaaA;
  public LinkedList<String> aaaB;
  public b aaaC;
  public String aaaD;
  public int aaaE;
  public int aaao;
  public int aaar;
  public float aaas;
  public float aaat;
  public int aaau;
  public FinderObjectDesc aaay;
  public long aaaz;
  public atr attachmentList;
  public String clientId;
  public String groupId;
  public float latitude;
  public float longitude;
  public long ocD;
  public int originalFlag;
  public String refObjectNonceId;
  public LinkedList<String> topics;
  public String username;
  
  public bsw()
  {
    AppMethodBeat.i(169036);
    this.topics = new LinkedList();
    this.aaaB = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
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
      if (this.aaay != null)
      {
        paramVarArgs.qD(3, this.aaay.computeSize());
        this.aaay.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.g(4, this.clientId);
      }
      paramVarArgs.bv(5, this.aaaz);
      if (this.refObjectNonceId != null) {
        paramVarArgs.g(6, this.refObjectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.l(8, this.longitude);
      paramVarArgs.l(9, this.latitude);
      paramVarArgs.l(10, this.aaas);
      paramVarArgs.l(11, this.aaat);
      paramVarArgs.bS(12, this.aaau);
      paramVarArgs.e(13, 1, this.topics);
      paramVarArgs.bS(14, this.originalFlag);
      paramVarArgs.bv(15, this.aaaA);
      paramVarArgs.e(16, 1, this.aaaB);
      if (this.aaaC != null) {
        paramVarArgs.d(17, this.aaaC);
      }
      if (this.groupId != null) {
        paramVarArgs.g(18, this.groupId);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.qD(20, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      if (this.aaaD != null) {
        paramVarArgs.g(21, this.aaaD);
      }
      paramVarArgs.bS(22, this.aaaE);
      paramVarArgs.bS(23, this.aaao);
      paramVarArgs.bv(24, this.ocD);
      paramVarArgs.bS(25, this.EUp);
      paramVarArgs.bS(26, this.aaar);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1770;
      }
    }
    label1770:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.aaay != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaay.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.clientId);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.aaaz);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(8) + 4) + (i.a.a.b.b.a.ko(9) + 4) + (i.a.a.b.b.a.ko(10) + 4) + (i.a.a.b.b.a.ko(11) + 4) + i.a.a.b.b.a.cJ(12, this.aaau) + i.a.a.a.c(13, 1, this.topics) + i.a.a.b.b.a.cJ(14, this.originalFlag) + i.a.a.b.b.a.q(15, this.aaaA) + i.a.a.a.c(16, 1, this.aaaB);
      paramInt = i;
      if (this.aaaC != null) {
        paramInt = i + i.a.a.b.b.a.c(17, this.aaaC);
      }
      i = paramInt;
      if (this.groupId != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.groupId);
      }
      paramInt = i;
      if (this.attachmentList != null) {
        paramInt = i + i.a.a.a.qC(20, this.attachmentList.computeSize());
      }
      i = paramInt;
      if (this.aaaD != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.aaaD);
      }
      paramInt = i.a.a.b.b.a.cJ(22, this.aaaE);
      int j = i.a.a.b.b.a.cJ(23, this.aaao);
      int k = i.a.a.b.b.a.q(24, this.ocD);
      int m = i.a.a.b.b.a.cJ(25, this.EUp);
      int n = i.a.a.b.b.a.cJ(26, this.aaar);
      AppMethodBeat.o(169037);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.topics.clear();
        this.aaaB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bsw localbsw = (bsw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 19: 
        default: 
          AppMethodBeat.o(169037);
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
            localbsw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localbsw.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localbsw.aaay = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localbsw.clientId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localbsw.aaaz = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localbsw.refObjectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169037);
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
            localbsw.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localbsw.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localbsw.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localbsw.aaas = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localbsw.aaat = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localbsw.aaau = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localbsw.topics.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 14: 
          localbsw.originalFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169037);
          return 0;
        case 15: 
          localbsw.aaaA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169037);
          return 0;
        case 16: 
          localbsw.aaaB.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 17: 
          localbsw.aaaC = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169037);
          return 0;
        case 18: 
          localbsw.groupId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atr)localObject2).parseFrom((byte[])localObject1);
            }
            localbsw.attachmentList = ((atr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 21: 
          localbsw.aaaD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 22: 
          localbsw.aaaE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169037);
          return 0;
        case 23: 
          localbsw.aaao = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169037);
          return 0;
        case 24: 
          localbsw.ocD = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169037);
          return 0;
        case 25: 
          localbsw.EUp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169037);
          return 0;
        }
        localbsw.aaar = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsw
 * JD-Core Version:    0.7.0.1
 */