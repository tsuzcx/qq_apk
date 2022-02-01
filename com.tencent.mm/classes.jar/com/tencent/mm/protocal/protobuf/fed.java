package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fed
  extends com.tencent.mm.bx.a
{
  public int BqU;
  public int RCV;
  public LinkedList<asq> abDM;
  public long abDN;
  public double abDO;
  public double abDP;
  public int commentCount;
  public int dyP;
  public long endTime;
  public String feedId;
  public boolean fhR;
  public int height;
  public boolean isAd;
  public int likeCount;
  public String nickName;
  public int pvg;
  public long startTime;
  public String userName;
  public int virtualKeyHeight;
  public int vpn;
  public int y;
  
  public fed()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.pvg = -1;
    this.virtualKeyHeight = 0;
    this.vpn = -1;
    this.BqU = -1;
    this.dyP = 0;
    this.RCV = 0;
    this.fhR = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.abDM = new LinkedList();
    this.abDN = 0L;
    this.abDO = 0.0D;
    this.abDP = 0.0D;
    this.isAd = false;
    AppMethodBeat.o(122546);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122547);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.g(1, this.feedId);
      }
      paramVarArgs.bS(2, this.y);
      paramVarArgs.bS(3, this.height);
      paramVarArgs.bS(4, this.pvg);
      paramVarArgs.bS(5, this.virtualKeyHeight);
      paramVarArgs.bS(6, this.vpn);
      paramVarArgs.bS(7, this.BqU);
      paramVarArgs.bS(8, this.dyP);
      paramVarArgs.bS(9, this.RCV);
      paramVarArgs.di(10, this.fhR);
      paramVarArgs.bv(11, this.startTime);
      paramVarArgs.bv(12, this.endTime);
      paramVarArgs.e(13, 8, this.abDM);
      paramVarArgs.bv(14, this.abDN);
      paramVarArgs.d(15, this.abDO);
      paramVarArgs.d(16, this.abDP);
      paramVarArgs.bS(17, this.commentCount);
      paramVarArgs.bS(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.g(19, this.userName);
      }
      paramVarArgs.di(20, this.isAd);
      if (this.nickName != null) {
        paramVarArgs.g(21, this.nickName);
      }
      AppMethodBeat.o(122547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1202;
      }
    }
    label1202:
    for (paramInt = i.a.a.b.b.a.h(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.y) + i.a.a.b.b.a.cJ(3, this.height) + i.a.a.b.b.a.cJ(4, this.pvg) + i.a.a.b.b.a.cJ(5, this.virtualKeyHeight) + i.a.a.b.b.a.cJ(6, this.vpn) + i.a.a.b.b.a.cJ(7, this.BqU) + i.a.a.b.b.a.cJ(8, this.dyP) + i.a.a.b.b.a.cJ(9, this.RCV) + (i.a.a.b.b.a.ko(10) + 1) + i.a.a.b.b.a.q(11, this.startTime) + i.a.a.b.b.a.q(12, this.endTime) + i.a.a.a.c(13, 8, this.abDM) + i.a.a.b.b.a.q(14, this.abDN) + (i.a.a.b.b.a.ko(15) + 8) + (i.a.a.b.b.a.ko(16) + 8) + i.a.a.b.b.a.cJ(17, this.commentCount) + i.a.a.b.b.a.cJ(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.userName);
      }
      i = paramInt + (i.a.a.b.b.a.ko(20) + 1);
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.nickName);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abDM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fed localfed = (fed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localfed.feedId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localfed.y = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localfed.height = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localfed.pvg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localfed.virtualKeyHeight = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localfed.vpn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localfed.BqU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localfed.dyP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localfed.RCV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localfed.fhR = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localfed.startTime = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localfed.endTime = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            asq localasq = new asq();
            if ((localObject != null) && (localObject.length > 0)) {
              localasq.parseFrom((byte[])localObject);
            }
            localfed.abDM.add(localasq);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localfed.abDN = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localfed.abDO = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localfed.abDP = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localfed.commentCount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localfed.likeCount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localfed.userName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localfed.isAd = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122547);
          return 0;
        }
        localfed.nickName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fed
 * JD-Core Version:    0.7.0.1
 */