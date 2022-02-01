package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderContact
  extends com.tencent.mm.bx.a
{
  public bc achievement_info;
  public FinderAuthInfo authInfo;
  public LinkedList<auc> bind_info;
  public int coverEntranceFlag;
  public String coverImgUrl;
  public String coverUrl;
  public int extFlag;
  public avl extInfo;
  public int fans_count;
  public int feedCount;
  public int followFlag;
  public int followTime;
  public int foreign_user_flag;
  public int friend_follow_count;
  public bbl guest_info;
  public String headUrl;
  public String liveCoverImgUrl;
  public int liveStatus;
  public avn live_info;
  public bkk live_notice_info;
  public String loggingout_wording;
  public LinkedList<FinderJumpInfo> menu;
  public avo msgInfo;
  public String nickname;
  public int one_time_flag;
  public int originalEntranceFlag;
  public int originalFlag;
  public bry originalInfo;
  public long seq;
  public String signature;
  public int spamStatus;
  public int user_flag;
  public int user_mode;
  public String username;
  public String vestNickname;
  public String wx_username_v5;
  
  public FinderContact()
  {
    AppMethodBeat.i(257621);
    this.bind_info = new LinkedList();
    this.menu = new LinkedList();
    AppMethodBeat.o(257621);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168945);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.g(3, this.headUrl);
      }
      paramVarArgs.bv(4, this.seq);
      if (this.signature != null) {
        paramVarArgs.g(5, this.signature);
      }
      paramVarArgs.bS(6, this.followFlag);
      paramVarArgs.bS(7, this.followTime);
      if (this.authInfo != null)
      {
        paramVarArgs.qD(8, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.g(9, this.coverImgUrl);
      }
      paramVarArgs.bS(10, this.spamStatus);
      paramVarArgs.bS(11, this.extFlag);
      if (this.extInfo != null)
      {
        paramVarArgs.qD(12, this.extInfo.computeSize());
        this.extInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.originalFlag);
      if (this.originalInfo != null)
      {
        paramVarArgs.qD(14, this.originalInfo.computeSize());
        this.originalInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.liveStatus);
      if (this.msgInfo != null)
      {
        paramVarArgs.qD(16, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.originalEntranceFlag);
      if (this.liveCoverImgUrl != null) {
        paramVarArgs.g(18, this.liveCoverImgUrl);
      }
      paramVarArgs.bS(19, this.foreign_user_flag);
      if (this.live_notice_info != null)
      {
        paramVarArgs.qD(20, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      if (this.loggingout_wording != null) {
        paramVarArgs.g(21, this.loggingout_wording);
      }
      if (this.live_info != null)
      {
        paramVarArgs.qD(22, this.live_info.computeSize());
        this.live_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.friend_follow_count);
      paramVarArgs.bS(24, this.fans_count);
      if (this.wx_username_v5 != null) {
        paramVarArgs.g(25, this.wx_username_v5);
      }
      if (this.vestNickname != null) {
        paramVarArgs.g(26, this.vestNickname);
      }
      paramVarArgs.bS(27, this.feedCount);
      paramVarArgs.bS(28, this.user_mode);
      if (this.guest_info != null)
      {
        paramVarArgs.qD(29, this.guest_info.computeSize());
        this.guest_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(30, 8, this.bind_info);
      if (this.coverUrl != null) {
        paramVarArgs.g(31, this.coverUrl);
      }
      paramVarArgs.bS(32, this.coverEntranceFlag);
      if (this.achievement_info != null)
      {
        paramVarArgs.qD(33, this.achievement_info.computeSize());
        this.achievement_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(34, 8, this.menu);
      paramVarArgs.bS(35, this.user_flag);
      paramVarArgs.bS(36, this.one_time_flag);
      AppMethodBeat.o(168945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label2806;
      }
    }
    label2806:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.headUrl);
      }
      i += i.a.a.b.b.a.q(4, this.seq);
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.signature);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.followFlag) + i.a.a.b.b.a.cJ(7, this.followTime);
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + i.a.a.a.qC(8, this.authInfo.computeSize());
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.coverImgUrl);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.spamStatus) + i.a.a.b.b.a.cJ(11, this.extFlag);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + i.a.a.a.qC(12, this.extInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.originalFlag);
      paramInt = i;
      if (this.originalInfo != null) {
        paramInt = i + i.a.a.a.qC(14, this.originalInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.liveStatus);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + i.a.a.a.qC(16, this.msgInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.originalEntranceFlag);
      paramInt = i;
      if (this.liveCoverImgUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.liveCoverImgUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.foreign_user_flag);
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + i.a.a.a.qC(20, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.loggingout_wording != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.loggingout_wording);
      }
      paramInt = i;
      if (this.live_info != null) {
        paramInt = i + i.a.a.a.qC(22, this.live_info.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.friend_follow_count) + i.a.a.b.b.a.cJ(24, this.fans_count);
      paramInt = i;
      if (this.wx_username_v5 != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.wx_username_v5);
      }
      i = paramInt;
      if (this.vestNickname != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.vestNickname);
      }
      i = i + i.a.a.b.b.a.cJ(27, this.feedCount) + i.a.a.b.b.a.cJ(28, this.user_mode);
      paramInt = i;
      if (this.guest_info != null) {
        paramInt = i + i.a.a.a.qC(29, this.guest_info.computeSize());
      }
      i = paramInt + i.a.a.a.c(30, 8, this.bind_info);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.coverUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.coverEntranceFlag);
      paramInt = i;
      if (this.achievement_info != null) {
        paramInt = i + i.a.a.a.qC(33, this.achievement_info.computeSize());
      }
      i = i.a.a.a.c(34, 8, this.menu);
      int j = i.a.a.b.b.a.cJ(35, this.user_flag);
      int k = i.a.a.b.b.a.cJ(36, this.one_time_flag);
      AppMethodBeat.o(168945);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.bind_info.clear();
        this.menu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168945);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderContact localFinderContact = (FinderContact)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168945);
          return -1;
        case 1: 
          localFinderContact.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 2: 
          localFinderContact.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 3: 
          localFinderContact.headUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 4: 
          localFinderContact.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168945);
          return 0;
        case 5: 
          localFinderContact.signature = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 6: 
          localFinderContact.followFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 7: 
          localFinderContact.followTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          localFinderContact.coverImgUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 10: 
          localFinderContact.spamStatus = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 11: 
          localFinderContact.extFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avl)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.extInfo = ((avl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 13: 
          localFinderContact.originalFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bry();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bry)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.originalInfo = ((bry)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 15: 
          localFinderContact.liveStatus = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avo)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.msgInfo = ((avo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 17: 
          localFinderContact.originalEntranceFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 18: 
          localFinderContact.liveCoverImgUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 19: 
          localFinderContact.foreign_user_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkk)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.live_notice_info = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 21: 
          localFinderContact.loggingout_wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avn)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.live_info = ((avn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 23: 
          localFinderContact.friend_follow_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 24: 
          localFinderContact.fans_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 25: 
          localFinderContact.wx_username_v5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 26: 
          localFinderContact.vestNickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 27: 
          localFinderContact.feedCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 28: 
          localFinderContact.user_mode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbl)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.guest_info = ((bbl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auc)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.bind_info.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 31: 
          localFinderContact.coverUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 32: 
          localFinderContact.coverEntranceFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bc)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.achievement_info = ((bc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderJumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderContact.menu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 35: 
          localFinderContact.user_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168945);
          return 0;
        }
        localFinderContact.one_time_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
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