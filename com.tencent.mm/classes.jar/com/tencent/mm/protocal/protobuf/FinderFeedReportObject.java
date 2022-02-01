package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderFeedReportObject
  extends com.tencent.mm.cd.a
{
  public String actionTrace;
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
  public String followSoundTrackId;
  public String forwardingAppId;
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
  public int multiShotChangeCnt;
  public int multiShotClickCnt;
  public int multiShotSuccessCnt;
  public int multiShotVideoCnt;
  public String musicFeedId;
  public int musicType;
  public String postId;
  public int postStage;
  public int postTaskCost;
  public long remuxEndTime;
  public int remuxType;
  public int retryCount;
  public int sdkShareType;
  public bdm selectLocation;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      paramVarArgs.aY(2, this.enterScene);
      paramVarArgs.aY(3, this.exitPageId);
      paramVarArgs.bm(4, this.enterTakePhotoTime);
      paramVarArgs.bm(5, this.enterVideoEditTime);
      paramVarArgs.bm(6, this.sendOrExitButtonTime);
      paramVarArgs.bm(7, this.videoRecordTime);
      paramVarArgs.aY(8, this.videoSource);
      paramVarArgs.aY(9, this.videoEmojiCount);
      paramVarArgs.aY(10, this.videoWordingCount);
      if (this.videoMusicId != null) {
        paramVarArgs.f(11, this.videoMusicId);
      }
      paramVarArgs.aY(12, this.videoMusicIndex);
      paramVarArgs.aY(13, this.videoMusicSearch);
      paramVarArgs.aY(14, this.videoPostType);
      if (this.videoMediaInfo != null) {
        paramVarArgs.f(15, this.videoMediaInfo);
      }
      paramVarArgs.aY(16, this.existDesc);
      paramVarArgs.aY(17, this.descCount);
      paramVarArgs.aY(18, this.descEmojiCount);
      if (this.actionTrace != null) {
        paramVarArgs.f(19, this.actionTrace);
      }
      paramVarArgs.aY(20, this.existLocation);
      if (this.link != null) {
        paramVarArgs.f(21, this.link);
      }
      paramVarArgs.aY(22, this.draft);
      paramVarArgs.bm(23, this.cdnEndTime);
      paramVarArgs.bm(24, this.remuxEndTime);
      paramVarArgs.e(25, 8, this.mediaList);
      paramVarArgs.aY(26, this.retryCount);
      paramVarArgs.aY(27, this.isBeauty);
      paramVarArgs.aY(28, this.isDurationCut);
      if (this.beforeCutMediaPath != null) {
        paramVarArgs.f(29, this.beforeCutMediaPath);
      }
      paramVarArgs.aY(30, this.isMultiShot);
      paramVarArgs.aY(31, this.multiShotChangeCnt);
      paramVarArgs.aY(32, this.multiShotClickCnt);
      paramVarArgs.aY(33, this.multiShotSuccessCnt);
      paramVarArgs.aY(35, this.multiShotVideoCnt);
      paramVarArgs.aY(36, this.videoSubType);
      if (this.postId != null) {
        paramVarArgs.f(37, this.postId);
      }
      if (this.editId != null) {
        paramVarArgs.f(38, this.editId);
      }
      paramVarArgs.aY(39, this.mentionCount);
      paramVarArgs.aY(40, this.clickMentionCount);
      paramVarArgs.aY(41, this.clickSucMentionCount);
      paramVarArgs.aY(42, this.mentionRepeatCount);
      paramVarArgs.aY(43, this.lbsFlag);
      if (this.selectLocation != null)
      {
        paramVarArgs.oE(44, this.selectLocation.computeSize());
        this.selectLocation.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(45, this.remuxType);
      paramVarArgs.aY(46, this.uploadLogicError);
      paramVarArgs.aY(47, this.postStage);
      paramVarArgs.aY(48, this.cgiErrorCode);
      paramVarArgs.aY(49, this.cgiErrorType);
      if (this.clickId != null) {
        paramVarArgs.f(50, this.clickId);
      }
      paramVarArgs.aY(51, this.soundTrackType);
      if (this.followSoundTrackId != null) {
        paramVarArgs.f(52, this.followSoundTrackId);
      }
      paramVarArgs.aY(53, this.megaCgiErrorCode);
      paramVarArgs.aY(54, this.megaCgiErrorType);
      paramVarArgs.aY(55, this.musicType);
      paramVarArgs.aY(56, this.longVideoSizeInvalid);
      paramVarArgs.aY(57, this.mediaProcessCost);
      paramVarArgs.aY(58, this.uploadCost);
      paramVarArgs.bm(59, this.uploadMediaTotalSize);
      paramVarArgs.aY(60, this.postTaskCost);
      paramVarArgs.aY(61, this.clickRepostCount);
      paramVarArgs.aY(62, this.dumpCgiErrorCode);
      paramVarArgs.aY(63, this.dumpCgiErrorType);
      paramVarArgs.aY(64, this.sdkShareType);
      if (this.forwardingAppId != null) {
        paramVarArgs.f(65, this.forwardingAppId);
      }
      if (this.topicActivityId != null) {
        paramVarArgs.f(66, this.topicActivityId);
      }
      paramVarArgs.aY(67, this.topicActivityType);
      paramVarArgs.aY(68, this.draftType);
      if (this.musicFeedId != null) {
        paramVarArgs.f(69, this.musicFeedId);
      }
      AppMethodBeat.o(168957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label3562;
      }
    }
    label3562:
    for (paramInt = g.a.a.b.b.a.g(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.enterScene) + g.a.a.b.b.a.bM(3, this.exitPageId) + g.a.a.b.b.a.p(4, this.enterTakePhotoTime) + g.a.a.b.b.a.p(5, this.enterVideoEditTime) + g.a.a.b.b.a.p(6, this.sendOrExitButtonTime) + g.a.a.b.b.a.p(7, this.videoRecordTime) + g.a.a.b.b.a.bM(8, this.videoSource) + g.a.a.b.b.a.bM(9, this.videoEmojiCount) + g.a.a.b.b.a.bM(10, this.videoWordingCount);
      paramInt = i;
      if (this.videoMusicId != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.videoMusicId);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.videoMusicIndex) + g.a.a.b.b.a.bM(13, this.videoMusicSearch) + g.a.a.b.b.a.bM(14, this.videoPostType);
      paramInt = i;
      if (this.videoMediaInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.videoMediaInfo);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.existDesc) + g.a.a.b.b.a.bM(17, this.descCount) + g.a.a.b.b.a.bM(18, this.descEmojiCount);
      paramInt = i;
      if (this.actionTrace != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.actionTrace);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.existLocation);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.link);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.draft) + g.a.a.b.b.a.p(23, this.cdnEndTime) + g.a.a.b.b.a.p(24, this.remuxEndTime) + g.a.a.a.c(25, 8, this.mediaList) + g.a.a.b.b.a.bM(26, this.retryCount) + g.a.a.b.b.a.bM(27, this.isBeauty) + g.a.a.b.b.a.bM(28, this.isDurationCut);
      paramInt = i;
      if (this.beforeCutMediaPath != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.beforeCutMediaPath);
      }
      i = paramInt + g.a.a.b.b.a.bM(30, this.isMultiShot) + g.a.a.b.b.a.bM(31, this.multiShotChangeCnt) + g.a.a.b.b.a.bM(32, this.multiShotClickCnt) + g.a.a.b.b.a.bM(33, this.multiShotSuccessCnt) + g.a.a.b.b.a.bM(35, this.multiShotVideoCnt) + g.a.a.b.b.a.bM(36, this.videoSubType);
      paramInt = i;
      if (this.postId != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.postId);
      }
      i = paramInt;
      if (this.editId != null) {
        i = paramInt + g.a.a.b.b.a.g(38, this.editId);
      }
      i = i + g.a.a.b.b.a.bM(39, this.mentionCount) + g.a.a.b.b.a.bM(40, this.clickMentionCount) + g.a.a.b.b.a.bM(41, this.clickSucMentionCount) + g.a.a.b.b.a.bM(42, this.mentionRepeatCount) + g.a.a.b.b.a.bM(43, this.lbsFlag);
      paramInt = i;
      if (this.selectLocation != null) {
        paramInt = i + g.a.a.a.oD(44, this.selectLocation.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(45, this.remuxType) + g.a.a.b.b.a.bM(46, this.uploadLogicError) + g.a.a.b.b.a.bM(47, this.postStage) + g.a.a.b.b.a.bM(48, this.cgiErrorCode) + g.a.a.b.b.a.bM(49, this.cgiErrorType);
      paramInt = i;
      if (this.clickId != null) {
        paramInt = i + g.a.a.b.b.a.g(50, this.clickId);
      }
      i = paramInt + g.a.a.b.b.a.bM(51, this.soundTrackType);
      paramInt = i;
      if (this.followSoundTrackId != null) {
        paramInt = i + g.a.a.b.b.a.g(52, this.followSoundTrackId);
      }
      i = paramInt + g.a.a.b.b.a.bM(53, this.megaCgiErrorCode) + g.a.a.b.b.a.bM(54, this.megaCgiErrorType) + g.a.a.b.b.a.bM(55, this.musicType) + g.a.a.b.b.a.bM(56, this.longVideoSizeInvalid) + g.a.a.b.b.a.bM(57, this.mediaProcessCost) + g.a.a.b.b.a.bM(58, this.uploadCost) + g.a.a.b.b.a.p(59, this.uploadMediaTotalSize) + g.a.a.b.b.a.bM(60, this.postTaskCost) + g.a.a.b.b.a.bM(61, this.clickRepostCount) + g.a.a.b.b.a.bM(62, this.dumpCgiErrorCode) + g.a.a.b.b.a.bM(63, this.dumpCgiErrorType) + g.a.a.b.b.a.bM(64, this.sdkShareType);
      paramInt = i;
      if (this.forwardingAppId != null) {
        paramInt = i + g.a.a.b.b.a.g(65, this.forwardingAppId);
      }
      i = paramInt;
      if (this.topicActivityId != null) {
        i = paramInt + g.a.a.b.b.a.g(66, this.topicActivityId);
      }
      i = i + g.a.a.b.b.a.bM(67, this.topicActivityType) + g.a.a.b.b.a.bM(68, this.draftType);
      paramInt = i;
      if (this.musicFeedId != null) {
        paramInt = i + g.a.a.b.b.a.g(69, this.musicFeedId);
      }
      AppMethodBeat.o(168957);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          localFinderFeedReportObject.sessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 2: 
          localFinderFeedReportObject.enterScene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 3: 
          localFinderFeedReportObject.exitPageId = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 4: 
          localFinderFeedReportObject.enterTakePhotoTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 5: 
          localFinderFeedReportObject.enterVideoEditTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 6: 
          localFinderFeedReportObject.sendOrExitButtonTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 7: 
          localFinderFeedReportObject.videoRecordTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 8: 
          localFinderFeedReportObject.videoSource = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 9: 
          localFinderFeedReportObject.videoEmojiCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 10: 
          localFinderFeedReportObject.videoWordingCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 11: 
          localFinderFeedReportObject.videoMusicId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 12: 
          localFinderFeedReportObject.videoMusicIndex = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 13: 
          localFinderFeedReportObject.videoMusicSearch = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 14: 
          localFinderFeedReportObject.videoPostType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 15: 
          localFinderFeedReportObject.videoMediaInfo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 16: 
          localFinderFeedReportObject.existDesc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 17: 
          localFinderFeedReportObject.descCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 18: 
          localFinderFeedReportObject.descEmojiCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 19: 
          localFinderFeedReportObject.actionTrace = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 20: 
          localFinderFeedReportObject.existLocation = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 21: 
          localFinderFeedReportObject.link = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 22: 
          localFinderFeedReportObject.draft = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 23: 
          localFinderFeedReportObject.cdnEndTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 24: 
          localFinderFeedReportObject.remuxEndTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          localFinderFeedReportObject.retryCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 27: 
          localFinderFeedReportObject.isBeauty = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 28: 
          localFinderFeedReportObject.isDurationCut = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 29: 
          localFinderFeedReportObject.beforeCutMediaPath = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 30: 
          localFinderFeedReportObject.isMultiShot = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 31: 
          localFinderFeedReportObject.multiShotChangeCnt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 32: 
          localFinderFeedReportObject.multiShotClickCnt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 33: 
          localFinderFeedReportObject.multiShotSuccessCnt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 35: 
          localFinderFeedReportObject.multiShotVideoCnt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 36: 
          localFinderFeedReportObject.videoSubType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 37: 
          localFinderFeedReportObject.postId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 38: 
          localFinderFeedReportObject.editId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 39: 
          localFinderFeedReportObject.mentionCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 40: 
          localFinderFeedReportObject.clickMentionCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 41: 
          localFinderFeedReportObject.clickSucMentionCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 42: 
          localFinderFeedReportObject.mentionRepeatCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 43: 
          localFinderFeedReportObject.lbsFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderFeedReportObject.selectLocation = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 45: 
          localFinderFeedReportObject.remuxType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 46: 
          localFinderFeedReportObject.uploadLogicError = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 47: 
          localFinderFeedReportObject.postStage = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 48: 
          localFinderFeedReportObject.cgiErrorCode = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 49: 
          localFinderFeedReportObject.cgiErrorType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 50: 
          localFinderFeedReportObject.clickId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 51: 
          localFinderFeedReportObject.soundTrackType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 52: 
          localFinderFeedReportObject.followSoundTrackId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 53: 
          localFinderFeedReportObject.megaCgiErrorCode = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 54: 
          localFinderFeedReportObject.megaCgiErrorType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 55: 
          localFinderFeedReportObject.musicType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 56: 
          localFinderFeedReportObject.longVideoSizeInvalid = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 57: 
          localFinderFeedReportObject.mediaProcessCost = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 58: 
          localFinderFeedReportObject.uploadCost = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 59: 
          localFinderFeedReportObject.uploadMediaTotalSize = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168957);
          return 0;
        case 60: 
          localFinderFeedReportObject.postTaskCost = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 61: 
          localFinderFeedReportObject.clickRepostCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 62: 
          localFinderFeedReportObject.dumpCgiErrorCode = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 63: 
          localFinderFeedReportObject.dumpCgiErrorType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 64: 
          localFinderFeedReportObject.sdkShareType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 65: 
          localFinderFeedReportObject.forwardingAppId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 66: 
          localFinderFeedReportObject.topicActivityId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 67: 
          localFinderFeedReportObject.topicActivityType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        case 68: 
          localFinderFeedReportObject.draftType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168957);
          return 0;
        }
        localFinderFeedReportObject.musicFeedId = ((g.a.a.a.a)localObject1).abFh.readString();
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