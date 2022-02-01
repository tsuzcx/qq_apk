package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderUserPageResponse
  extends dpc
{
  public aoy biz_info;
  public FinderContact contact;
  public int continueFlag;
  public cxs entranceInfo;
  public int fansCount;
  public int feedsCount;
  public String firstPageMD5;
  public int friendFollowCount;
  public com.tencent.mm.bw.b lastBuffer;
  public awt liveNoticeInfo;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public int originalEntranceFlag;
  public baw preloadInfo;
  public int privateLock;
  public LinkedList<String> userTags;
  public LinkedList<bds> usualTopics;
  public azn verifyInfo;
  public bel wxaShopInfo;
  
  public FinderUserPageResponse()
  {
    AppMethodBeat.i(169071);
    this.object = new LinkedList();
    this.userTags = new LinkedList();
    this.liveObjects = new LinkedList();
    this.usualTopics = new LinkedList();
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
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.firstPageMD5 != null) {
        paramVarArgs.e(3, this.firstPageMD5);
      }
      if (this.contact != null)
      {
        paramVarArgs.ni(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.feedsCount);
      paramVarArgs.aM(7, this.continueFlag);
      if (this.verifyInfo != null)
      {
        paramVarArgs.ni(8, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.fansCount);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aM(11, this.friendFollowCount);
      paramVarArgs.e(12, 1, this.userTags);
      paramVarArgs.aM(13, this.originalEntranceFlag);
      if (this.entranceInfo != null)
      {
        paramVarArgs.ni(14, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.ni(15, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.liveObjects);
      paramVarArgs.aM(17, this.privateLock);
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.ni(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      if (this.liveNoticeInfo != null)
      {
        paramVarArgs.ni(19, this.liveNoticeInfo.computeSize());
        this.liveNoticeInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(20, 8, this.usualTopics);
      if (this.biz_info != null)
      {
        paramVarArgs.ni(27, this.biz_info.computeSize());
        this.biz_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2350;
      }
    }
    label2350:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.firstPageMD5);
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.nh(5, this.contact.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(6, this.feedsCount) + g.a.a.b.b.a.bu(7, this.continueFlag);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + g.a.a.a.nh(8, this.verifyInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.fansCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.friendFollowCount) + g.a.a.a.c(12, 1, this.userTags) + g.a.a.b.b.a.bu(13, this.originalEntranceFlag);
      paramInt = i;
      if (this.entranceInfo != null) {
        paramInt = i + g.a.a.a.nh(14, this.entranceInfo.computeSize());
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + g.a.a.a.nh(15, this.preloadInfo.computeSize());
      }
      i = i + g.a.a.a.c(16, 8, this.liveObjects) + g.a.a.b.b.a.bu(17, this.privateLock);
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + g.a.a.a.nh(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt;
      if (this.liveNoticeInfo != null) {
        i = paramInt + g.a.a.a.nh(19, this.liveNoticeInfo.computeSize());
      }
      i += g.a.a.a.c(20, 8, this.usualTopics);
      paramInt = i;
      if (this.biz_info != null) {
        paramInt = i + g.a.a.a.nh(27, this.biz_info.computeSize());
      }
      AppMethodBeat.o(169072);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.userTags.clear();
        this.liveObjects.clear();
        this.usualTopics.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        default: 
          AppMethodBeat.o(169072);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 3: 
          localFinderUserPageResponse.firstPageMD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 6: 
          localFinderUserPageResponse.feedsCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 7: 
          localFinderUserPageResponse.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.verifyInfo = ((azn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 9: 
          localFinderUserPageResponse.fansCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 10: 
          localFinderUserPageResponse.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169072);
          return 0;
        case 11: 
          localFinderUserPageResponse.friendFollowCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 12: 
          localFinderUserPageResponse.userTags.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(169072);
          return 0;
        case 13: 
          localFinderUserPageResponse.originalEntranceFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.entranceInfo = ((cxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.preloadInfo = ((baw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.liveObjects.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 17: 
          localFinderUserPageResponse.privateLock = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169072);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bel();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bel)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.wxaShopInfo = ((bel)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.liveNoticeInfo = ((awt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.usualTopics.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderUserPageResponse.biz_info = ((aoy)localObject1);
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