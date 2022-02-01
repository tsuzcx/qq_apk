package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dne
  extends com.tencent.mm.bx.a
{
  public dnh aaUt;
  public int aaUu;
  public dno aaUv;
  public String aaUw;
  public int aaUx;
  public int aaUy;
  public String aaUz;
  public String aahV;
  public int commentCount;
  public int createTime;
  public String debugMessage;
  public int favCount;
  public int favFlag;
  public int forwardCount;
  public int friendLikeCount;
  public long id;
  public int likeCount;
  public int likeFlag;
  public boolean oRS;
  public int permissionFlag;
  public int privateFlag;
  public int readCount;
  public String sessionBuffer;
  public int status;
  public int urlValidDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258649);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.bS(2, this.createTime);
      if (this.aaUt != null)
      {
        paramVarArgs.qD(3, this.aaUt.computeSize());
        this.aaUt.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.forwardCount);
      paramVarArgs.bS(5, this.likeCount);
      paramVarArgs.bS(6, this.commentCount);
      paramVarArgs.bS(7, this.favCount);
      paramVarArgs.bS(8, this.friendLikeCount);
      paramVarArgs.bS(9, this.aaUu);
      if (this.aahV != null) {
        paramVarArgs.g(10, this.aahV);
      }
      paramVarArgs.di(11, this.oRS);
      paramVarArgs.bS(12, this.readCount);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(13, this.sessionBuffer);
      }
      paramVarArgs.bS(14, this.favFlag);
      paramVarArgs.bS(15, this.urlValidDuration);
      paramVarArgs.bS(16, this.privateFlag);
      if (this.debugMessage != null) {
        paramVarArgs.g(17, this.debugMessage);
      }
      paramVarArgs.bS(18, this.permissionFlag);
      if (this.aaUv != null)
      {
        paramVarArgs.qD(19, this.aaUv.computeSize());
        this.aaUv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(20, this.status);
      if (this.aaUw != null) {
        paramVarArgs.g(21, this.aaUw);
      }
      paramVarArgs.bS(22, this.aaUx);
      paramVarArgs.bS(23, this.likeFlag);
      paramVarArgs.bS(24, this.aaUy);
      if (this.aaUz != null) {
        paramVarArgs.g(25, this.aaUz);
      }
      AppMethodBeat.o(258649);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.createTime);
      paramInt = i;
      if (this.aaUt != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaUt.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.forwardCount) + i.a.a.b.b.a.cJ(5, this.likeCount) + i.a.a.b.b.a.cJ(6, this.commentCount) + i.a.a.b.b.a.cJ(7, this.favCount) + i.a.a.b.b.a.cJ(8, this.friendLikeCount) + i.a.a.b.b.a.cJ(9, this.aaUu);
      paramInt = i;
      if (this.aahV != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aahV);
      }
      i = paramInt + (i.a.a.b.b.a.ko(11) + 1) + i.a.a.b.b.a.cJ(12, this.readCount);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.sessionBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.favFlag) + i.a.a.b.b.a.cJ(15, this.urlValidDuration) + i.a.a.b.b.a.cJ(16, this.privateFlag);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.debugMessage);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.permissionFlag);
      paramInt = i;
      if (this.aaUv != null) {
        paramInt = i + i.a.a.a.qC(19, this.aaUv.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.status);
      paramInt = i;
      if (this.aaUw != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aaUw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.aaUx) + i.a.a.b.b.a.cJ(23, this.likeFlag) + i.a.a.b.b.a.cJ(24, this.aaUy);
      paramInt = i;
      if (this.aaUz != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.aaUz);
      }
      AppMethodBeat.o(258649);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258649);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dne localdne = (dne)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258649);
        return -1;
      case 1: 
        localdne.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258649);
        return 0;
      case 2: 
        localdne.createTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dnh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dnh)localObject2).parseFrom((byte[])localObject1);
          }
          localdne.aaUt = ((dnh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258649);
        return 0;
      case 4: 
        localdne.forwardCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 5: 
        localdne.likeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 6: 
        localdne.commentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 7: 
        localdne.favCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 8: 
        localdne.friendLikeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 9: 
        localdne.aaUu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 10: 
        localdne.aahV = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258649);
        return 0;
      case 11: 
        localdne.oRS = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258649);
        return 0;
      case 12: 
        localdne.readCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 13: 
        localdne.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258649);
        return 0;
      case 14: 
        localdne.favFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 15: 
        localdne.urlValidDuration = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 16: 
        localdne.privateFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 17: 
        localdne.debugMessage = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258649);
        return 0;
      case 18: 
        localdne.permissionFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dno();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dno)localObject2).parseFrom((byte[])localObject1);
          }
          localdne.aaUv = ((dno)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258649);
        return 0;
      case 20: 
        localdne.status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 21: 
        localdne.aaUw = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258649);
        return 0;
      case 22: 
        localdne.aaUx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 23: 
        localdne.likeFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      case 24: 
        localdne.aaUy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258649);
        return 0;
      }
      localdne.aaUz = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(258649);
      return 0;
    }
    AppMethodBeat.o(258649);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dne
 * JD-Core Version:    0.7.0.1
 */