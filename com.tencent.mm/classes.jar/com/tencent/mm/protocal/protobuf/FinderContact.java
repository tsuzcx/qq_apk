package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderContact
  extends com.tencent.mm.cd.a
{
  public FinderAuthInfo authInfo;
  public String coverImgUrl;
  public int extFlag;
  public ard extInfo;
  public int fans_count;
  public int feedCount;
  public int followFlag;
  public int followTime;
  public int foreign_user_flag;
  public int friend_follow_count;
  public String headUrl;
  public String liveCoverImgUrl;
  public int liveStatus;
  public arf live_info;
  public bbh live_notice_info;
  public String loggingout_wording;
  public arg msgInfo;
  public String nickname;
  public int originalEntranceFlag;
  public int originalFlag;
  public bgi originalInfo;
  public long seq;
  public String signature;
  public int spamStatus;
  public String username;
  public String vestNickname;
  public String wx_username_v5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168945);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.f(3, this.headUrl);
      }
      paramVarArgs.bm(4, this.seq);
      if (this.signature != null) {
        paramVarArgs.f(5, this.signature);
      }
      paramVarArgs.aY(6, this.followFlag);
      paramVarArgs.aY(7, this.followTime);
      if (this.authInfo != null)
      {
        paramVarArgs.oE(8, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.f(9, this.coverImgUrl);
      }
      paramVarArgs.aY(10, this.spamStatus);
      paramVarArgs.aY(11, this.extFlag);
      if (this.extInfo != null)
      {
        paramVarArgs.oE(12, this.extInfo.computeSize());
        this.extInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.originalFlag);
      if (this.originalInfo != null)
      {
        paramVarArgs.oE(14, this.originalInfo.computeSize());
        this.originalInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.liveStatus);
      if (this.msgInfo != null)
      {
        paramVarArgs.oE(16, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(17, this.originalEntranceFlag);
      if (this.liveCoverImgUrl != null) {
        paramVarArgs.f(18, this.liveCoverImgUrl);
      }
      paramVarArgs.aY(19, this.foreign_user_flag);
      if (this.live_notice_info != null)
      {
        paramVarArgs.oE(20, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      if (this.loggingout_wording != null) {
        paramVarArgs.f(21, this.loggingout_wording);
      }
      if (this.live_info != null)
      {
        paramVarArgs.oE(22, this.live_info.computeSize());
        this.live_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(23, this.friend_follow_count);
      paramVarArgs.aY(24, this.fans_count);
      if (this.wx_username_v5 != null) {
        paramVarArgs.f(25, this.wx_username_v5);
      }
      if (this.vestNickname != null) {
        paramVarArgs.f(26, this.vestNickname);
      }
      paramVarArgs.aY(27, this.feedCount);
      AppMethodBeat.o(168945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label2054;
      }
    }
    label2054:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.headUrl);
      }
      i += g.a.a.b.b.a.p(4, this.seq);
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.signature);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.followFlag) + g.a.a.b.b.a.bM(7, this.followTime);
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + g.a.a.a.oD(8, this.authInfo.computeSize());
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.coverImgUrl);
      }
      i = i + g.a.a.b.b.a.bM(10, this.spamStatus) + g.a.a.b.b.a.bM(11, this.extFlag);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.a.oD(12, this.extInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.originalFlag);
      paramInt = i;
      if (this.originalInfo != null) {
        paramInt = i + g.a.a.a.oD(14, this.originalInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.liveStatus);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + g.a.a.a.oD(16, this.msgInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.originalEntranceFlag);
      paramInt = i;
      if (this.liveCoverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.liveCoverImgUrl);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.foreign_user_flag);
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + g.a.a.a.oD(20, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.loggingout_wording != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.loggingout_wording);
      }
      paramInt = i;
      if (this.live_info != null) {
        paramInt = i + g.a.a.a.oD(22, this.live_info.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.friend_follow_count) + g.a.a.b.b.a.bM(24, this.fans_count);
      paramInt = i;
      if (this.wx_username_v5 != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.wx_username_v5);
      }
      i = paramInt;
      if (this.vestNickname != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.vestNickname);
      }
      paramInt = g.a.a.b.b.a.bM(27, this.feedCount);
      AppMethodBeat.o(168945);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168945);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderContact localFinderContact = (FinderContact)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168945);
          return -1;
        case 1: 
          localFinderContact.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 2: 
          localFinderContact.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 3: 
          localFinderContact.headUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 4: 
          localFinderContact.seq = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168945);
          return 0;
        case 5: 
          localFinderContact.signature = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 6: 
          localFinderContact.followFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 7: 
          localFinderContact.followTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderAuthInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderAuthInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.authInfo = ((FinderAuthInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 9: 
          localFinderContact.coverImgUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 10: 
          localFinderContact.spamStatus = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 11: 
          localFinderContact.extFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ard();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ard)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.extInfo = ((ard)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 13: 
          localFinderContact.originalFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgi)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.originalInfo = ((bgi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 15: 
          localFinderContact.liveStatus = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arg)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.msgInfo = ((arg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 17: 
          localFinderContact.originalEntranceFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 18: 
          localFinderContact.liveCoverImgUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 19: 
          localFinderContact.foreign_user_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbh)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.live_notice_info = ((bbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 21: 
          localFinderContact.loggingout_wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arf)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.live_info = ((arf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 23: 
          localFinderContact.friend_follow_count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 24: 
          localFinderContact.fans_count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168945);
          return 0;
        case 25: 
          localFinderContact.wx_username_v5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 26: 
          localFinderContact.vestNickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168945);
          return 0;
        }
        localFinderContact.feedCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168945);
        return 0;
      }
      AppMethodBeat.o(168945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderContact
 * JD-Core Version:    0.7.0.1
 */