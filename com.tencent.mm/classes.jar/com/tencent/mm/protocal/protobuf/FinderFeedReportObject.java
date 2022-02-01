package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderFeedReportObject
  extends com.tencent.mm.bx.a
{
  public String actionTrace;
  public String activeInfo;
  public String beforeCutMediaPath;
  public long cdnEndTime;
  public int cgiErrorCode;
  public int cgiErrorType;
  public String clickId;
  public int clickMentionCount;
  public int clickRepostCount;
  public int clickSucMentionCount;
  public int descCount;
  public int descEmojiCount;
  public int draft;
  public int draftId;
  public int draftType;
  public int dumpCgiErrorCode;
  public int dumpCgiErrorType;
  public String editId;
  public int enterScene;
  public long enterTakePhotoTime;
  public long enterVideoEditTime;
  public int existDesc;
  public int existLocation;
  public int exitPageId;
  public String flowId;
  public String followSoundTrackId;
  public String forwardingAppId;
  public int fromDraft;
  public int isBeauty;
  public int isDurationCut;
  public int isMultiShot;
  public int lbsFlag;
  public String link;
  public int longVideoSizeInvalid;
  public LinkedList<FinderMediaReportObject> mediaList;
  public int mediaProcessCost;
  public int megaCgiErrorCode;
  public int megaCgiErrorType;
  public int mentionCount;
  public int mentionRepeatCount;
  public int mpError;
  public int multiShotChangeCnt;
  public int multiShotClickCnt;
  public int multiShotSuccessCnt;
  public int multiShotVideoCnt;
  public String musicFeedId;
  public int musicType;
  public String originColorSpace;
  public String postId;
  public int postStage;
  public int postTaskCost;
  public long remuxEndTime;
  public int remuxType;
  public int retryCount;
  public int sdkShareType;
  public boi selectLocation;
  public long sendOrExitButtonTime;
  public String sessionId;
  public int soundTrackType;
  public String topicActivityId;
  public int topicActivityType;
  public int uploadCost;
  public int uploadLogicError;
  public long uploadMediaTotalSize;
  public int videoEmojiCount;
  public String videoMediaInfo;
  public String videoMusicId;
  public int videoMusicIndex;
  public int videoMusicSearch;
  public int videoPostType;
  public long videoRecordTime;
  public int videoSource;
  public int videoSubType;
  public int videoWordingCount;
  public int waitingPostCount;
  
  public FinderFeedReportObject()
  {
    AppMethodBeat.i(168956);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(168956);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168957);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      paramVarArgs.bS(2, this.enterScene);
      paramVarArgs.bS(3, this.exitPageId);
      paramVarArgs.bv(4, this.enterTakePhotoTime);
      paramVarArgs.bv(5, this.enterVideoEditTime);
      paramVarArgs.bv(6, this.sendOrExitButtonTime);
      paramVarArgs.bv(7, this.videoRecordTime);
      paramVarArgs.bS(8, this.videoSource);
      paramVarArgs.bS(9, this.videoEmojiCount);
      paramVarArgs.bS(10, this.videoWordingCount);
      if (this.videoMusicId != null) {
        paramVarArgs.g(11, this.videoMusicId);
      }
      paramVarArgs.bS(12, this.videoMusicIndex);
      paramVarArgs.bS(13, this.videoMusicSearch);
      paramVarArgs.bS(14, this.videoPostType);
      if (this.videoMediaInfo != null) {
        paramVarArgs.g(15, this.videoMediaInfo);
      }
      paramVarArgs.bS(16, this.existDesc);
      paramVarArgs.bS(17, this.descCount);
      paramVarArgs.bS(18, this.descEmojiCount);
      if (this.actionTrace != null) {
        paramVarArgs.g(19, this.actionTrace);
      }
      paramVarArgs.bS(20, this.existLocation);
      if (this.link != null) {
        paramVarArgs.g(21, this.link);
      }
      paramVarArgs.bS(22, this.draft);
      paramVarArgs.bv(23, this.cdnEndTime);
      paramVarArgs.bv(24, this.remuxEndTime);
      paramVarArgs.e(25, 8, this.mediaList);
      paramVarArgs.bS(26, this.retryCount);
      paramVarArgs.bS(27, this.isBeauty);
      paramVarArgs.bS(28, this.isDurationCut);
      if (this.beforeCutMediaPath != null) {
        paramVarArgs.g(29, this.beforeCutMediaPath);
      }
      paramVarArgs.bS(30, this.isMultiShot);
      paramVarArgs.bS(31, this.multiShotChangeCnt);
      paramVarArgs.bS(32, this.multiShotClickCnt);
      paramVarArgs.bS(33, this.multiShotSuccessCnt);
      paramVarArgs.bS(35, this.multiShotVideoCnt);
      paramVarArgs.bS(36, this.videoSubType);
      if (this.postId != null) {
        paramVarArgs.g(37, this.postId);
      }
      if (this.editId != null) {
        paramVarArgs.g(38, this.editId);
      }
      paramVarArgs.bS(39, this.mentionCount);
      paramVarArgs.bS(40, this.clickMentionCount);
      paramVarArgs.bS(41, this.clickSucMentionCount);
      paramVarArgs.bS(42, this.mentionRepeatCount);
      paramVarArgs.bS(43, this.lbsFlag);
      if (this.selectLocation != null)
      {
        paramVarArgs.qD(44, this.selectLocation.computeSize());
        this.selectLocation.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(45, this.remuxType);
      paramVarArgs.bS(46, this.uploadLogicError);
      paramVarArgs.bS(47, this.postStage);
      paramVarArgs.bS(48, this.cgiErrorCode);
      paramVarArgs.bS(49, this.cgiErrorType);
      if (this.clickId != null) {
        paramVarArgs.g(50, this.clickId);
      }
      paramVarArgs.bS(51, this.soundTrackType);
      if (this.followSoundTrackId != null) {
        paramVarArgs.g(52, this.followSoundTrackId);
      }
      paramVarArgs.bS(53, this.megaCgiErrorCode);
      paramVarArgs.bS(54, this.megaCgiErrorType);
      paramVarArgs.bS(55, this.musicType);
      paramVarArgs.bS(56, this.longVideoSizeInvalid);
      paramVarArgs.bS(57, this.mediaProcessCost);
      paramVarArgs.bS(58, this.uploadCost);
      paramVarArgs.bv(59, this.uploadMediaTotalSize);
      paramVarArgs.bS(60, this.postTaskCost);
      paramVarArgs.bS(61, this.clickRepostCount);
      paramVarArgs.bS(62, this.dumpCgiErrorCode);
      paramVarArgs.bS(63, this.dumpCgiErrorType);
      paramVarArgs.bS(64, this.sdkShareType);
      if (this.forwardingAppId != null) {
        paramVarArgs.g(65, this.forwardingAppId);
      }
      if (this.topicActivityId != null) {
        paramVarArgs.g(66, this.topicActivityId);
      }
      paramVarArgs.bS(67, this.topicActivityType);
      paramVarArgs.bS(68, this.draftType);
      if (this.musicFeedId != null) {
        paramVarArgs.g(69, this.musicFeedId);
      }
      paramVarArgs.bS(70, this.draftId);
      paramVarArgs.bS(71, this.fromDraft);
      if (this.flowId != null) {
        paramVarArgs.g(72, this.flowId);
      }
      paramVarArgs.bS(73, this.mpError);
      paramVarArgs.bS(74, this.waitingPostCount);
      if (this.originColorSpace != null) {
        paramVarArgs.g(75, this.originColorSpace);
      }
      if (this.activeInfo != null) {
        paramVarArgs.g(76, this.activeInfo);
      }
      AppMethodBeat.o(168957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label3926;
      }
    }
    label3926:
    for (paramInt = i.a.a.b.b.a.h(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.enterScene) + i.a.a.b.b.a.cJ(3, this.exitPageId) + i.a.a.b.b.a.q(4, this.enterTakePhotoTime) + i.a.a.b.b.a.q(5, this.enterVideoEditTime) + i.a.a.b.b.a.q(6, this.sendOrExitButtonTime) + i.a.a.b.b.a.q(7, this.videoRecordTime) + i.a.a.b.b.a.cJ(8, this.videoSource) + i.a.a.b.b.a.cJ(9, this.videoEmojiCount) + i.a.a.b.b.a.cJ(10, this.videoWordingCount);
      paramInt = i;
      if (this.videoMusicId != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.videoMusicId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.videoMusicIndex) + i.a.a.b.b.a.cJ(13, this.videoMusicSearch) + i.a.a.b.b.a.cJ(14, this.videoPostType);
      paramInt = i;
      if (this.videoMediaInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.videoMediaInfo);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.existDesc) + i.a.a.b.b.a.cJ(17, this.descCount) + i.a.a.b.b.a.cJ(18, this.descEmojiCount);
      paramInt = i;
      if (this.actionTrace != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.actionTrace);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.existLocation);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.link);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.draft) + i.a.a.b.b.a.q(23, this.cdnEndTime) + i.a.a.b.b.a.q(24, this.remuxEndTime) + i.a.a.a.c(25, 8, this.mediaList) + i.a.a.b.b.a.cJ(26, this.retryCount) + i.a.a.b.b.a.cJ(27, this.isBeauty) + i.a.a.b.b.a.cJ(28, this.isDurationCut);
      paramInt = i;
      if (this.beforeCutMediaPath != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.beforeCutMediaPath);
      }
      i = paramInt + i.a.a.b.b.a.cJ(30, this.isMultiShot) + i.a.a.b.b.a.cJ(31, this.multiShotChangeCnt) + i.a.a.b.b.a.cJ(32, this.multiShotClickCnt) + i.a.a.b.b.a.cJ(33, this.multiShotSuccessCnt) + i.a.a.b.b.a.cJ(35, this.multiShotVideoCnt) + i.a.a.b.b.a.cJ(36, this.videoSubType);
      paramInt = i;
      if (this.postId != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.postId);
      }
      i = paramInt;
      if (this.editId != null) {
        i = paramInt + i.a.a.b.b.a.h(38, this.editId);
      }
      i = i + i.a.a.b.b.a.cJ(39, this.mentionCount) + i.a.a.b.b.a.cJ(40, this.clickMentionCount) + i.a.a.b.b.a.cJ(41, this.clickSucMentionCount) + i.a.a.b.b.a.cJ(42, this.mentionRepeatCount) + i.a.a.b.b.a.cJ(43, this.lbsFlag);
      paramInt = i;
      if (this.selectLocation != null) {
        paramInt = i + i.a.a.a.qC(44, this.selectLocation.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(45, this.remuxType) + i.a.a.b.b.a.cJ(46, this.uploadLogicError) + i.a.a.b.b.a.cJ(47, this.postStage) + i.a.a.b.b.a.cJ(48, this.cgiErrorCode) + i.a.a.b.b.a.cJ(49, this.cgiErrorType);
      paramInt = i;
      if (this.clickId != null) {
        paramInt = i + i.a.a.b.b.a.h(50, this.clickId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(51, this.soundTrackType);
      paramInt = i;
      if (this.followSoundTrackId != null) {
        paramInt = i + i.a.a.b.b.a.h(52, this.followSoundTrackId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(53, this.megaCgiErrorCode) + i.a.a.b.b.a.cJ(54, this.megaCgiErrorType) + i.a.a.b.b.a.cJ(55, this.musicType) + i.a.a.b.b.a.cJ(56, this.longVideoSizeInvalid) + i.a.a.b.b.a.cJ(57, this.mediaProcessCost) + i.a.a.b.b.a.cJ(58, this.uploadCost) + i.a.a.b.b.a.q(59, this.uploadMediaTotalSize) + i.a.a.b.b.a.cJ(60, this.postTaskCost) + i.a.a.b.b.a.cJ(61, this.clickRepostCount) + i.a.a.b.b.a.cJ(62, this.dumpCgiErrorCode) + i.a.a.b.b.a.cJ(63, this.dumpCgiErrorType) + i.a.a.b.b.a.cJ(64, this.sdkShareType);
      paramInt = i;
      if (this.forwardingAppId != null) {
        paramInt = i + i.a.a.b.b.a.h(65, this.forwardingAppId);
      }
      i = paramInt;
      if (this.topicActivityId != null) {
        i = paramInt + i.a.a.b.b.a.h(66, this.topicActivityId);
      }
      i = i + i.a.a.b.b.a.cJ(67, this.topicActivityType) + i.a.a.b.b.a.cJ(68, this.draftType);
      paramInt = i;
      if (this.musicFeedId != null) {
        paramInt = i + i.a.a.b.b.a.h(69, this.musicFeedId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(70, this.draftId) + i.a.a.b.b.a.cJ(71, this.fromDraft);
      paramInt = i;
      if (this.flowId != null) {
        paramInt = i + i.a.a.b.b.a.h(72, this.flowId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(73, this.mpError) + i.a.a.b.b.a.cJ(74, this.waitingPostCount);
      paramInt = i;
      if (this.originColorSpace != null) {
        paramInt = i + i.a.a.b.b.a.h(75, this.originColorSpace);
      }
      i = paramInt;
      if (this.activeInfo != null) {
        i = paramInt + i.a.a.b.b.a.h(76, this.activeInfo);
      }
      AppMethodBeat.o(168957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderFeedReportObject localFinderFeedReportObject = (FinderFeedReportObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 34: 
        default: 
          AppMethodBeat.o(168957);
          return -1;
        case 1: 
          localFinderFeedReportObject.sessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 2: 
          localFinderFeedReportObject.enterScene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 3: 
          localFinderFeedReportObject.exitPageId = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 4: 
          localFinderFeedReportObject.enterTakePhotoTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 5: 
          localFinderFeedReportObject.enterVideoEditTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 6: 
          localFinderFeedReportObject.sendOrExitButtonTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 7: 
          localFinderFeedReportObject.videoRecordTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 8: 
          localFinderFeedReportObject.videoSource = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 9: 
          localFinderFeedReportObject.videoEmojiCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 10: 
          localFinderFeedReportObject.videoWordingCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 11: 
          localFinderFeedReportObject.videoMusicId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 12: 
          localFinderFeedReportObject.videoMusicIndex = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 13: 
          localFinderFeedReportObject.videoMusicSearch = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 14: 
          localFinderFeedReportObject.videoPostType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 15: 
          localFinderFeedReportObject.videoMediaInfo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 16: 
          localFinderFeedReportObject.existDesc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 17: 
          localFinderFeedReportObject.descCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 18: 
          localFinderFeedReportObject.descEmojiCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 19: 
          localFinderFeedReportObject.actionTrace = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 20: 
          localFinderFeedReportObject.existLocation = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 21: 
          localFinderFeedReportObject.link = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 22: 
          localFinderFeedReportObject.draft = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 23: 
          localFinderFeedReportObject.cdnEndTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 24: 
          localFinderFeedReportObject.remuxEndTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderMediaReportObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderMediaReportObject)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderFeedReportObject.mediaList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 26: 
          localFinderFeedReportObject.retryCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 27: 
          localFinderFeedReportObject.isBeauty = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 28: 
          localFinderFeedReportObject.isDurationCut = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 29: 
          localFinderFeedReportObject.beforeCutMediaPath = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 30: 
          localFinderFeedReportObject.isMultiShot = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 31: 
          localFinderFeedReportObject.multiShotChangeCnt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 32: 
          localFinderFeedReportObject.multiShotClickCnt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 33: 
          localFinderFeedReportObject.multiShotSuccessCnt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 35: 
          localFinderFeedReportObject.multiShotVideoCnt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 36: 
          localFinderFeedReportObject.videoSubType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 37: 
          localFinderFeedReportObject.postId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 38: 
          localFinderFeedReportObject.editId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 39: 
          localFinderFeedReportObject.mentionCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 40: 
          localFinderFeedReportObject.clickMentionCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 41: 
          localFinderFeedReportObject.clickSucMentionCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 42: 
          localFinderFeedReportObject.mentionRepeatCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 43: 
          localFinderFeedReportObject.lbsFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 44: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boi)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderFeedReportObject.selectLocation = ((boi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 45: 
          localFinderFeedReportObject.remuxType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 46: 
          localFinderFeedReportObject.uploadLogicError = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 47: 
          localFinderFeedReportObject.postStage = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 48: 
          localFinderFeedReportObject.cgiErrorCode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 49: 
          localFinderFeedReportObject.cgiErrorType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 50: 
          localFinderFeedReportObject.clickId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 51: 
          localFinderFeedReportObject.soundTrackType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 52: 
          localFinderFeedReportObject.followSoundTrackId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 53: 
          localFinderFeedReportObject.megaCgiErrorCode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 54: 
          localFinderFeedReportObject.megaCgiErrorType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 55: 
          localFinderFeedReportObject.musicType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 56: 
          localFinderFeedReportObject.longVideoSizeInvalid = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 57: 
          localFinderFeedReportObject.mediaProcessCost = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 58: 
          localFinderFeedReportObject.uploadCost = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 59: 
          localFinderFeedReportObject.uploadMediaTotalSize = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168957);
          return 0;
        case 60: 
          localFinderFeedReportObject.postTaskCost = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 61: 
          localFinderFeedReportObject.clickRepostCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 62: 
          localFinderFeedReportObject.dumpCgiErrorCode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 63: 
          localFinderFeedReportObject.dumpCgiErrorType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 64: 
          localFinderFeedReportObject.sdkShareType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 65: 
          localFinderFeedReportObject.forwardingAppId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 66: 
          localFinderFeedReportObject.topicActivityId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 67: 
          localFinderFeedReportObject.topicActivityType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 68: 
          localFinderFeedReportObject.draftType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 69: 
          localFinderFeedReportObject.musicFeedId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 70: 
          localFinderFeedReportObject.draftId = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 71: 
          localFinderFeedReportObject.fromDraft = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 72: 
          localFinderFeedReportObject.flowId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 73: 
          localFinderFeedReportObject.mpError = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 74: 
          localFinderFeedReportObject.waitingPostCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168957);
          return 0;
        case 75: 
          localFinderFeedReportObject.originColorSpace = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168957);
          return 0;
        }
        localFinderFeedReportObject.activeInfo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(168957);
        return 0;
      }
      AppMethodBeat.o(168957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderFeedReportObject
 * JD-Core Version:    0.7.0.1
 */