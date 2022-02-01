package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpc
  extends com.tencent.mm.bx.a
{
  public int ABS;
  public String ZFu;
  public long ZIT;
  public bqv ZXA;
  public bpf ZXB;
  public bpf ZXC;
  public bpd ZXD;
  public LinkedList<FinderContact> ZXE;
  public int ZXF;
  public int ZXG;
  public long ZXH;
  public String ZXI;
  public dhs ZXJ;
  public avc ZXK;
  public bpg ZXL;
  public String ZXy;
  public String ZXz;
  public FinderContact author_contact;
  public long commentId;
  public int createTime;
  public String description;
  public int eQp;
  public int extFlag;
  public long hKN;
  public String headUrl;
  public long id;
  public String kLn;
  public int mediaType;
  public String nickName;
  public String objectNonceId;
  public int objectType;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public bpc()
  {
    AppMethodBeat.i(258051);
    this.ZXE = new LinkedList();
    AppMethodBeat.o(258051);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169009);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.headUrl != null) {
        paramVarArgs.g(1, this.headUrl);
      }
      if (this.nickName != null) {
        paramVarArgs.g(2, this.nickName);
      }
      paramVarArgs.bS(3, this.ABS);
      if (this.ZXy != null) {
        paramVarArgs.g(4, this.ZXy);
      }
      paramVarArgs.bS(5, this.createTime);
      if (this.thumbUrl != null) {
        paramVarArgs.g(6, this.thumbUrl);
      }
      paramVarArgs.bv(7, this.id);
      paramVarArgs.bv(8, this.hKN);
      paramVarArgs.bv(9, this.commentId);
      paramVarArgs.bS(10, this.eQp);
      paramVarArgs.bS(11, this.extFlag);
      if (this.ZXz != null) {
        paramVarArgs.g(12, this.ZXz);
      }
      if (this.ZXA != null)
      {
        paramVarArgs.qD(13, this.ZXA.computeSize());
        this.ZXA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.g(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.g(16, this.replyNickname);
      }
      if (this.ZFu != null) {
        paramVarArgs.g(17, this.ZFu);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.g(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.g(19, this.username);
      }
      if (this.ZXB != null)
      {
        paramVarArgs.qD(20, this.ZXB.computeSize());
        this.ZXB.writeFields(paramVarArgs);
      }
      if (this.ZXC != null)
      {
        paramVarArgs.qD(21, this.ZXC.computeSize());
        this.ZXC.writeFields(paramVarArgs);
      }
      if (this.ZXD != null)
      {
        paramVarArgs.qD(22, this.ZXD.computeSize());
        this.ZXD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.ZXE);
      paramVarArgs.bS(24, this.ZXF);
      paramVarArgs.bS(25, this.ZXG);
      if (this.kLn != null) {
        paramVarArgs.g(26, this.kLn);
      }
      paramVarArgs.bv(27, this.ZIT);
      paramVarArgs.bS(28, this.objectType);
      paramVarArgs.bv(29, this.ZXH);
      if (this.ZXI != null) {
        paramVarArgs.g(30, this.ZXI);
      }
      if (this.ZXJ != null)
      {
        paramVarArgs.qD(31, this.ZXJ.computeSize());
        this.ZXJ.writeFields(paramVarArgs);
      }
      if (this.author_contact != null)
      {
        paramVarArgs.qD(32, this.author_contact.computeSize());
        this.author_contact.writeFields(paramVarArgs);
      }
      if (this.ZXK != null)
      {
        paramVarArgs.qD(33, this.ZXK.computeSize());
        this.ZXK.writeFields(paramVarArgs);
      }
      if (this.ZXL != null)
      {
        paramVarArgs.qD(34, this.ZXL.computeSize());
        this.ZXL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label2664;
      }
    }
    label2664:
    for (paramInt = i.a.a.b.b.a.h(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nickName);
      }
      i += i.a.a.b.b.a.cJ(3, this.ABS);
      paramInt = i;
      if (this.ZXy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZXy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.createTime);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.thumbUrl);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.id) + i.a.a.b.b.a.q(8, this.hKN) + i.a.a.b.b.a.q(9, this.commentId) + i.a.a.b.b.a.cJ(10, this.eQp) + i.a.a.b.b.a.cJ(11, this.extFlag);
      paramInt = i;
      if (this.ZXz != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZXz);
      }
      i = paramInt;
      if (this.ZXA != null) {
        i = paramInt + i.a.a.a.qC(13, this.ZXA.computeSize());
      }
      i += i.a.a.b.b.a.cJ(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.replyNickname);
      }
      paramInt = i;
      if (this.ZFu != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ZFu);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.objectNonceId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.username);
      }
      i = paramInt;
      if (this.ZXB != null) {
        i = paramInt + i.a.a.a.qC(20, this.ZXB.computeSize());
      }
      paramInt = i;
      if (this.ZXC != null) {
        paramInt = i + i.a.a.a.qC(21, this.ZXC.computeSize());
      }
      i = paramInt;
      if (this.ZXD != null) {
        i = paramInt + i.a.a.a.qC(22, this.ZXD.computeSize());
      }
      i = i + i.a.a.a.c(23, 8, this.ZXE) + i.a.a.b.b.a.cJ(24, this.ZXF) + i.a.a.b.b.a.cJ(25, this.ZXG);
      paramInt = i;
      if (this.kLn != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.kLn);
      }
      i = paramInt + i.a.a.b.b.a.q(27, this.ZIT) + i.a.a.b.b.a.cJ(28, this.objectType) + i.a.a.b.b.a.q(29, this.ZXH);
      paramInt = i;
      if (this.ZXI != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.ZXI);
      }
      i = paramInt;
      if (this.ZXJ != null) {
        i = paramInt + i.a.a.a.qC(31, this.ZXJ.computeSize());
      }
      paramInt = i;
      if (this.author_contact != null) {
        paramInt = i + i.a.a.a.qC(32, this.author_contact.computeSize());
      }
      i = paramInt;
      if (this.ZXK != null) {
        i = paramInt + i.a.a.a.qC(33, this.ZXK.computeSize());
      }
      paramInt = i;
      if (this.ZXL != null) {
        paramInt = i + i.a.a.a.qC(34, this.ZXL.computeSize());
      }
      AppMethodBeat.o(169009);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZXE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bpc localbpc = (bpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localbpc.headUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localbpc.nickName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localbpc.ABS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localbpc.ZXy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localbpc.createTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localbpc.thumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localbpc.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localbpc.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localbpc.commentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localbpc.eQp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localbpc.extFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localbpc.ZXz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqv)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXA = ((bqv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localbpc.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localbpc.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localbpc.replyNickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localbpc.ZFu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localbpc.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localbpc.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpf)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXB = ((bpf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpf)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXC = ((bpf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpd)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXD = ((bpd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 24: 
          localbpc.ZXF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 25: 
          localbpc.ZXG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 26: 
          localbpc.kLn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 27: 
          localbpc.ZIT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169009);
          return 0;
        case 28: 
          localbpc.objectType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169009);
          return 0;
        case 29: 
          localbpc.ZXH = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169009);
          return 0;
        case 30: 
          localbpc.ZXI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhs)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXJ = ((dhs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.author_contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avc)localObject2).parseFrom((byte[])localObject1);
            }
            localbpc.ZXK = ((avc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bpg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bpg)localObject2).parseFrom((byte[])localObject1);
          }
          localbpc.ZXL = ((bpg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */