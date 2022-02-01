package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderUserPageResponse
  extends esc
{
  public String acct_detail_entrance;
  public auh biz_info;
  public FinderContact contact;
  public int continueFlag;
  public dzk entranceInfo;
  public LinkedList<awt> eventInfoList;
  public int fansCount;
  public int feedsCount;
  public String firstPageMD5;
  public int friendFollowCount;
  public LinkedList<FinderJumpInfo> jump_info;
  public bci just_watch;
  public com.tencent.mm.bx.b lastBuffer;
  public bkk liveNoticeInfo;
  public LinkedList<FinderObject> liveObjects;
  public bkl live_notice_list_info;
  public String loggingout_wording;
  public int logout_lock;
  public String logout_url;
  public LinkedList<FinderObject> object;
  public int originalEntranceFlag;
  public byk poi_info;
  public btc preloadInfo;
  public int privateLock;
  public LinkedList<String> userTags;
  public LinkedList<bxv> usualTopics;
  public bqt verifyInfo;
  public bzd wxaShopInfo;
  
  public FinderUserPageResponse()
  {
    AppMethodBeat.i(169071);
    this.object = new LinkedList();
    this.userTags = new LinkedList();
    this.liveObjects = new LinkedList();
    this.usualTopics = new LinkedList();
    this.eventInfoList = new LinkedList();
    this.jump_info = new LinkedList();
    AppMethodBeat.o(169071);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169072);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169072);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.firstPageMD5 != null) {
        paramVarArgs.g(3, this.firstPageMD5);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.feedsCount);
      paramVarArgs.bS(7, this.continueFlag);
      if (this.verifyInfo != null)
      {
        paramVarArgs.qD(8, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.fansCount);
      if (this.lastBuffer != null) {
        paramVarArgs.d(10, this.lastBuffer);
      }
      paramVarArgs.bS(11, this.friendFollowCount);
      paramVarArgs.e(12, 1, this.userTags);
      paramVarArgs.bS(13, this.originalEntranceFlag);
      if (this.entranceInfo != null)
      {
        paramVarArgs.qD(14, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.qD(15, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.liveObjects);
      paramVarArgs.bS(17, this.privateLock);
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.qD(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      if (this.liveNoticeInfo != null)
      {
        paramVarArgs.qD(19, this.liveNoticeInfo.computeSize());
        this.liveNoticeInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(20, 8, this.usualTopics);
      paramVarArgs.bS(22, this.logout_lock);
      if (this.acct_detail_entrance != null) {
        paramVarArgs.g(23, this.acct_detail_entrance);
      }
      if (this.loggingout_wording != null) {
        paramVarArgs.g(24, this.loggingout_wording);
      }
      if (this.poi_info != null)
      {
        paramVarArgs.qD(25, this.poi_info.computeSize());
        this.poi_info.writeFields(paramVarArgs);
      }
      if (this.logout_url != null) {
        paramVarArgs.g(26, this.logout_url);
      }
      if (this.biz_info != null)
      {
        paramVarArgs.qD(27, this.biz_info.computeSize());
        this.biz_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(28, 8, this.eventInfoList);
      if (this.just_watch != null)
      {
        paramVarArgs.qD(29, this.just_watch.computeSize());
        this.just_watch.writeFields(paramVarArgs);
      }
      if (this.live_notice_list_info != null)
      {
        paramVarArgs.qD(30, this.live_notice_list_info.computeSize());
        this.live_notice_list_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(31, 8, this.jump_info);
      AppMethodBeat.o(169072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2954;
      }
    }
    label2954:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.firstPageMD5);
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(5, this.contact.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(6, this.feedsCount) + i.a.a.b.b.a.cJ(7, this.continueFlag);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + i.a.a.a.qC(8, this.verifyInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.fansCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.friendFollowCount) + i.a.a.a.c(12, 1, this.userTags) + i.a.a.b.b.a.cJ(13, this.originalEntranceFlag);
      paramInt = i;
      if (this.entranceInfo != null) {
        paramInt = i + i.a.a.a.qC(14, this.entranceInfo.computeSize());
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + i.a.a.a.qC(15, this.preloadInfo.computeSize());
      }
      i = i + i.a.a.a.c(16, 8, this.liveObjects) + i.a.a.b.b.a.cJ(17, this.privateLock);
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + i.a.a.a.qC(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt;
      if (this.liveNoticeInfo != null) {
        i = paramInt + i.a.a.a.qC(19, this.liveNoticeInfo.computeSize());
      }
      i = i + i.a.a.a.c(20, 8, this.usualTopics) + i.a.a.b.b.a.cJ(22, this.logout_lock);
      paramInt = i;
      if (this.acct_detail_entrance != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.acct_detail_entrance);
      }
      i = paramInt;
      if (this.loggingout_wording != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.loggingout_wording);
      }
      paramInt = i;
      if (this.poi_info != null) {
        paramInt = i + i.a.a.a.qC(25, this.poi_info.computeSize());
      }
      i = paramInt;
      if (this.logout_url != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.logout_url);
      }
      paramInt = i;
      if (this.biz_info != null) {
        paramInt = i + i.a.a.a.qC(27, this.biz_info.computeSize());
      }
      i = paramInt + i.a.a.a.c(28, 8, this.eventInfoList);
      paramInt = i;
      if (this.just_watch != null) {
        paramInt = i + i.a.a.a.qC(29, this.just_watch.computeSize());
      }
      i = paramInt;
      if (this.live_notice_list_info != null) {
        i = paramInt + i.a.a.a.qC(30, this.live_notice_list_info.computeSize());
      }
      paramInt = i.a.a.a.c(31, 8, this.jump_info);
      AppMethodBeat.o(169072);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.userTags.clear();
        this.liveObjects.clear();
        this.usualTopics.clear();
        this.eventInfoList.clear();
        this.jump_info.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169072);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169072);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderUserPageResponse localFinderUserPageResponse = (FinderUserPageResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 21: 
        default: 
          AppMethodBeat.o(169072);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 3: 
          localFinderUserPageResponse.firstPageMD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 5: 
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
            localFinderUserPageResponse.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 6: 
          localFinderUserPageResponse.feedsCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 7: 
          localFinderUserPageResponse.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqt)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.verifyInfo = ((bqt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 9: 
          localFinderUserPageResponse.fansCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 10: 
          localFinderUserPageResponse.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169072);
          return 0;
        case 11: 
          localFinderUserPageResponse.friendFollowCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 12: 
          localFinderUserPageResponse.userTags.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(169072);
          return 0;
        case 13: 
          localFinderUserPageResponse.originalEntranceFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzk)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.entranceInfo = ((dzk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btc)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.preloadInfo = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.liveObjects.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 17: 
          localFinderUserPageResponse.privateLock = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.wxaShopInfo = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 19: 
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
            localFinderUserPageResponse.liveNoticeInfo = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxv)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.usualTopics.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 22: 
          localFinderUserPageResponse.logout_lock = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169072);
          return 0;
        case 23: 
          localFinderUserPageResponse.acct_detail_entrance = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 24: 
          localFinderUserPageResponse.loggingout_wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byk)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.poi_info = ((byk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 26: 
          localFinderUserPageResponse.logout_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auh)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.biz_info = ((auh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awt)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.eventInfoList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bci)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.just_watch = ((bci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkl)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.live_notice_list_info = ((bkl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        }
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
          localFinderUserPageResponse.jump_info.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169072);
        return 0;
      }
      AppMethodBeat.o(169072);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderUserPageResponse
 * JD-Core Version:    0.7.0.1
 */