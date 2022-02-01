package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderUserPageResponse
  extends dyy
{
  public String acct_detail_entrance;
  public aqh biz_info;
  public FinderContact contact;
  public int continueFlag;
  public dhc entranceInfo;
  public LinkedList<asg> eventInfoList;
  public int fansCount;
  public int feedsCount;
  public String firstPageMD5;
  public int friendFollowCount;
  public com.tencent.mm.cd.b lastBuffer;
  public bbh liveNoticeInfo;
  public LinkedList<FinderObject> liveObjects;
  public String loggingout_wording;
  public int logout_lock;
  public String logout_url;
  public LinkedList<FinderObject> object;
  public int originalEntranceFlag;
  public bky poi_info;
  public bhh preloadInfo;
  public int privateLock;
  public LinkedList<String> userTags;
  public LinkedList<bkr> usualTopics;
  public bfm verifyInfo;
  public bln wxaShopInfo;
  
  public FinderUserPageResponse()
  {
    AppMethodBeat.i(169071);
    this.object = new LinkedList();
    this.userTags = new LinkedList();
    this.liveObjects = new LinkedList();
    this.usualTopics = new LinkedList();
    this.eventInfoList = new LinkedList();
    AppMethodBeat.o(169071);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169072);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169072);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.firstPageMD5 != null) {
        paramVarArgs.f(3, this.firstPageMD5);
      }
      if (this.contact != null)
      {
        paramVarArgs.oE(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.feedsCount);
      paramVarArgs.aY(7, this.continueFlag);
      if (this.verifyInfo != null)
      {
        paramVarArgs.oE(8, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.fansCount);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aY(11, this.friendFollowCount);
      paramVarArgs.e(12, 1, this.userTags);
      paramVarArgs.aY(13, this.originalEntranceFlag);
      if (this.entranceInfo != null)
      {
        paramVarArgs.oE(14, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.oE(15, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.liveObjects);
      paramVarArgs.aY(17, this.privateLock);
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.oE(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      if (this.liveNoticeInfo != null)
      {
        paramVarArgs.oE(19, this.liveNoticeInfo.computeSize());
        this.liveNoticeInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(20, 8, this.usualTopics);
      paramVarArgs.aY(22, this.logout_lock);
      if (this.acct_detail_entrance != null) {
        paramVarArgs.f(23, this.acct_detail_entrance);
      }
      if (this.loggingout_wording != null) {
        paramVarArgs.f(24, this.loggingout_wording);
      }
      if (this.poi_info != null)
      {
        paramVarArgs.oE(25, this.poi_info.computeSize());
        this.poi_info.writeFields(paramVarArgs);
      }
      if (this.logout_url != null) {
        paramVarArgs.f(26, this.logout_url);
      }
      if (this.biz_info != null)
      {
        paramVarArgs.oE(27, this.biz_info.computeSize());
        this.biz_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(28, 8, this.eventInfoList);
      AppMethodBeat.o(169072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2568;
      }
    }
    label2568:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.firstPageMD5);
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.oD(5, this.contact.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(6, this.feedsCount) + g.a.a.b.b.a.bM(7, this.continueFlag);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + g.a.a.a.oD(8, this.verifyInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.fansCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.friendFollowCount) + g.a.a.a.c(12, 1, this.userTags) + g.a.a.b.b.a.bM(13, this.originalEntranceFlag);
      paramInt = i;
      if (this.entranceInfo != null) {
        paramInt = i + g.a.a.a.oD(14, this.entranceInfo.computeSize());
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + g.a.a.a.oD(15, this.preloadInfo.computeSize());
      }
      i = i + g.a.a.a.c(16, 8, this.liveObjects) + g.a.a.b.b.a.bM(17, this.privateLock);
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + g.a.a.a.oD(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt;
      if (this.liveNoticeInfo != null) {
        i = paramInt + g.a.a.a.oD(19, this.liveNoticeInfo.computeSize());
      }
      i = i + g.a.a.a.c(20, 8, this.usualTopics) + g.a.a.b.b.a.bM(22, this.logout_lock);
      paramInt = i;
      if (this.acct_detail_entrance != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.acct_detail_entrance);
      }
      i = paramInt;
      if (this.loggingout_wording != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.loggingout_wording);
      }
      paramInt = i;
      if (this.poi_info != null) {
        paramInt = i + g.a.a.a.oD(25, this.poi_info.computeSize());
      }
      i = paramInt;
      if (this.logout_url != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.logout_url);
      }
      paramInt = i;
      if (this.biz_info != null) {
        paramInt = i + g.a.a.a.oD(27, this.biz_info.computeSize());
      }
      i = g.a.a.a.c(28, 8, this.eventInfoList);
      AppMethodBeat.o(169072);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.userTags.clear();
        this.liveObjects.clear();
        this.usualTopics.clear();
        this.eventInfoList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169072);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169072);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          localFinderUserPageResponse.firstPageMD5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          localFinderUserPageResponse.feedsCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 7: 
          localFinderUserPageResponse.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfm)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.verifyInfo = ((bfm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 9: 
          localFinderUserPageResponse.fansCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 10: 
          localFinderUserPageResponse.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169072);
          return 0;
        case 11: 
          localFinderUserPageResponse.friendFollowCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 12: 
          localFinderUserPageResponse.userTags.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(169072);
          return 0;
        case 13: 
          localFinderUserPageResponse.originalEntranceFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhc)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.entranceInfo = ((dhc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhh)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.preloadInfo = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          localFinderUserPageResponse.privateLock = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.wxaShopInfo = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 19: 
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
            localFinderUserPageResponse.liveNoticeInfo = ((bbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkr)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.usualTopics.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 22: 
          localFinderUserPageResponse.logout_lock = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169072);
          return 0;
        case 23: 
          localFinderUserPageResponse.acct_detail_entrance = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 24: 
          localFinderUserPageResponse.loggingout_wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bky();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bky)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.poi_info = ((bky)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 26: 
          localFinderUserPageResponse.logout_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqh)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderUserPageResponse.biz_info = ((aqh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asg)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderUserPageResponse.eventInfoList.add(localObject2);
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