package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderFeedReportObject
  extends com.tencent.mm.bw.a
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
  public int musicType;
  public String postId;
  public int postStage;
  public int postTaskCost;
  public long remuxEndTime;
  public int remuxType;
  public int retryCount;
  public int sdkShareType;
  public axt selectLocation;
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
        paramVarArgs.e(1, this.sessionId);
      }
      paramVarArgs.aM(2, this.enterScene);
      paramVarArgs.aM(3, this.exitPageId);
      paramVarArgs.bb(4, this.enterTakePhotoTime);
      paramVarArgs.bb(5, this.enterVideoEditTime);
      paramVarArgs.bb(6, this.sendOrExitButtonTime);
      paramVarArgs.bb(7, this.videoRecordTime);
      paramVarArgs.aM(8, this.videoSource);
      paramVarArgs.aM(9, this.videoEmojiCount);
      paramVarArgs.aM(10, this.videoWordingCount);
      if (this.videoMusicId != null) {
        paramVarArgs.e(11, this.videoMusicId);
      }
      paramVarArgs.aM(12, this.videoMusicIndex);
      paramVarArgs.aM(13, this.videoMusicSearch);
      paramVarArgs.aM(14, this.videoPostType);
      if (this.videoMediaInfo != null) {
        paramVarArgs.e(15, this.videoMediaInfo);
      }
      paramVarArgs.aM(16, this.existDesc);
      paramVarArgs.aM(17, this.descCount);
      paramVarArgs.aM(18, this.descEmojiCount);
      if (this.actionTrace != null) {
        paramVarArgs.e(19, this.actionTrace);
      }
      paramVarArgs.aM(20, this.existLocation);
      if (this.link != null) {
        paramVarArgs.e(21, this.link);
      }
      paramVarArgs.aM(22, this.draft);
      paramVarArgs.bb(23, this.cdnEndTime);
      paramVarArgs.bb(24, this.remuxEndTime);
      paramVarArgs.e(25, 8, this.mediaList);
      paramVarArgs.aM(26, this.retryCount);
      paramVarArgs.aM(27, this.isBeauty);
      paramVarArgs.aM(28, this.isDurationCut);
      if (this.beforeCutMediaPath != null) {
        paramVarArgs.e(29, this.beforeCutMediaPath);
      }
      paramVarArgs.aM(30, this.isMultiShot);
      paramVarArgs.aM(31, this.multiShotChangeCnt);
      paramVarArgs.aM(32, this.multiShotClickCnt);
      paramVarArgs.aM(33, this.multiShotSuccessCnt);
      paramVarArgs.aM(35, this.multiShotVideoCnt);
      paramVarArgs.aM(36, this.videoSubType);
      if (this.postId != null) {
        paramVarArgs.e(37, this.postId);
      }
      if (this.editId != null) {
        paramVarArgs.e(38, this.editId);
      }
      paramVarArgs.aM(39, this.mentionCount);
      paramVarArgs.aM(40, this.clickMentionCount);
      paramVarArgs.aM(41, this.clickSucMentionCount);
      paramVarArgs.aM(42, this.mentionRepeatCount);
      paramVarArgs.aM(43, this.lbsFlag);
      if (this.selectLocation != null)
      {
        paramVarArgs.ni(44, this.selectLocation.computeSize());
        this.selectLocation.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(45, this.remuxType);
      paramVarArgs.aM(46, this.uploadLogicError);
      paramVarArgs.aM(47, this.postStage);
      paramVarArgs.aM(48, this.cgiErrorCode);
      paramVarArgs.aM(49, this.cgiErrorType);
      if (this.clickId != null) {
        paramVarArgs.e(50, this.clickId);
      }
      paramVarArgs.aM(51, this.soundTrackType);
      if (this.followSoundTrackId != null) {
        paramVarArgs.e(52, this.followSoundTrackId);
      }
      paramVarArgs.aM(53, this.megaCgiErrorCode);
      paramVarArgs.aM(54, this.megaCgiErrorType);
      paramVarArgs.aM(55, this.musicType);
      paramVarArgs.aM(56, this.longVideoSizeInvalid);
      paramVarArgs.aM(57, this.mediaProcessCost);
      paramVarArgs.aM(58, this.uploadCost);
      paramVarArgs.bb(59, this.uploadMediaTotalSize);
      paramVarArgs.aM(60, this.postTaskCost);
      paramVarArgs.aM(61, this.clickRepostCount);
      paramVarArgs.aM(62, this.dumpCgiErrorCode);
      paramVarArgs.aM(63, this.dumpCgiErrorType);
      paramVarArgs.aM(64, this.sdkShareType);
      if (this.forwardingAppId != null) {
        paramVarArgs.e(65, this.forwardingAppId);
      }
      if (this.topicActivityId != null) {
        paramVarArgs.e(66, this.topicActivityId);
      }
      paramVarArgs.aM(67, this.topicActivityType);
      paramVarArgs.aM(68, this.draftType);
      AppMethodBeat.o(168957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label3550;
      }
    }
    label3550:
    for (paramInt = g.a.a.b.b.a.f(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.enterScene) + g.a.a.b.b.a.bu(3, this.exitPageId) + g.a.a.b.b.a.r(4, this.enterTakePhotoTime) + g.a.a.b.b.a.r(5, this.enterVideoEditTime) + g.a.a.b.b.a.r(6, this.sendOrExitButtonTime) + g.a.a.b.b.a.r(7, this.videoRecordTime) + g.a.a.b.b.a.bu(8, this.videoSource) + g.a.a.b.b.a.bu(9, this.videoEmojiCount) + g.a.a.b.b.a.bu(10, this.videoWordingCount);
      paramInt = i;
      if (this.videoMusicId != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.videoMusicId);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.videoMusicIndex) + g.a.a.b.b.a.bu(13, this.videoMusicSearch) + g.a.a.b.b.a.bu(14, this.videoPostType);
      paramInt = i;
      if (this.videoMediaInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.videoMediaInfo);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.existDesc) + g.a.a.b.b.a.bu(17, this.descCount) + g.a.a.b.b.a.bu(18, this.descEmojiCount);
      paramInt = i;
      if (this.actionTrace != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.actionTrace);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.existLocation);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.link);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.draft) + g.a.a.b.b.a.r(23, this.cdnEndTime) + g.a.a.b.b.a.r(24, this.remuxEndTime) + g.a.a.a.c(25, 8, this.mediaList) + g.a.a.b.b.a.bu(26, this.retryCount) + g.a.a.b.b.a.bu(27, this.isBeauty) + g.a.a.b.b.a.bu(28, this.isDurationCut);
      paramInt = i;
      if (this.beforeCutMediaPath != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.beforeCutMediaPath);
      }
      i = paramInt + g.a.a.b.b.a.bu(30, this.isMultiShot) + g.a.a.b.b.a.bu(31, this.multiShotChangeCnt) + g.a.a.b.b.a.bu(32, this.multiShotClickCnt) + g.a.a.b.b.a.bu(33, this.multiShotSuccessCnt) + g.a.a.b.b.a.bu(35, this.multiShotVideoCnt) + g.a.a.b.b.a.bu(36, this.videoSubType);
      paramInt = i;
      if (this.postId != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.postId);
      }
      i = paramInt;
      if (this.editId != null) {
        i = paramInt + g.a.a.b.b.a.f(38, this.editId);
      }
      i = i + g.a.a.b.b.a.bu(39, this.mentionCount) + g.a.a.b.b.a.bu(40, this.clickMentionCount) + g.a.a.b.b.a.bu(41, this.clickSucMentionCount) + g.a.a.b.b.a.bu(42, this.mentionRepeatCount) + g.a.a.b.b.a.bu(43, this.lbsFlag);
      paramInt = i;
      if (this.selectLocation != null) {
        paramInt = i + g.a.a.a.nh(44, this.selectLocation.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(45, this.remuxType) + g.a.a.b.b.a.bu(46, this.uploadLogicError) + g.a.a.b.b.a.bu(47, this.postStage) + g.a.a.b.b.a.bu(48, this.cgiErrorCode) + g.a.a.b.b.a.bu(49, this.cgiErrorType);
      paramInt = i;
      if (this.clickId != null) {
        paramInt = i + g.a.a.b.b.a.f(50, this.clickId);
      }
      i = paramInt + g.a.a.b.b.a.bu(51, this.soundTrackType);
      paramInt = i;
      if (this.followSoundTrackId != null) {
        paramInt = i + g.a.a.b.b.a.f(52, this.followSoundTrackId);
      }
      i = paramInt + g.a.a.b.b.a.bu(53, this.megaCgiErrorCode) + g.a.a.b.b.a.bu(54, this.megaCgiErrorType) + g.a.a.b.b.a.bu(55, this.musicType) + g.a.a.b.b.a.bu(56, this.longVideoSizeInvalid) + g.a.a.b.b.a.bu(57, this.mediaProcessCost) + g.a.a.b.b.a.bu(58, this.uploadCost) + g.a.a.b.b.a.r(59, this.uploadMediaTotalSize) + g.a.a.b.b.a.bu(60, this.postTaskCost) + g.a.a.b.b.a.bu(61, this.clickRepostCount) + g.a.a.b.b.a.bu(62, this.dumpCgiErrorCode) + g.a.a.b.b.a.bu(63, this.dumpCgiErrorType) + g.a.a.b.b.a.bu(64, this.sdkShareType);
      paramInt = i;
      if (this.forwardingAppId != null) {
        paramInt = i + g.a.a.b.b.a.f(65, this.forwardingAppId);
      }
      i = paramInt;
      if (this.topicActivityId != null) {
        i = paramInt + g.a.a.b.b.a.f(66, this.topicActivityId);
      }
      paramInt = g.a.a.b.b.a.bu(67, this.topicActivityType);
      int j = g.a.a.b.b.a.bu(68, this.draftType);
      AppMethodBeat.o(168957);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        case 34: 
        default: 
          AppMethodBeat.o(168957);
          return -1;
        case 1: 
          localFinderFeedReportObject.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 2: 
          localFinderFeedReportObject.enterScene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 3: 
          localFinderFeedReportObject.exitPageId = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 4: 
          localFinderFeedReportObject.enterTakePhotoTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 5: 
          localFinderFeedReportObject.enterVideoEditTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 6: 
          localFinderFeedReportObject.sendOrExitButtonTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 7: 
          localFinderFeedReportObject.videoRecordTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 8: 
          localFinderFeedReportObject.videoSource = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 9: 
          localFinderFeedReportObject.videoEmojiCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 10: 
          localFinderFeedReportObject.videoWordingCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 11: 
          localFinderFeedReportObject.videoMusicId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 12: 
          localFinderFeedReportObject.videoMusicIndex = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 13: 
          localFinderFeedReportObject.videoMusicSearch = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 14: 
          localFinderFeedReportObject.videoPostType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 15: 
          localFinderFeedReportObject.videoMediaInfo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 16: 
          localFinderFeedReportObject.existDesc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 17: 
          localFinderFeedReportObject.descCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 18: 
          localFinderFeedReportObject.descEmojiCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 19: 
          localFinderFeedReportObject.actionTrace = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 20: 
          localFinderFeedReportObject.existLocation = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 21: 
          localFinderFeedReportObject.link = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 22: 
          localFinderFeedReportObject.draft = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 23: 
          localFinderFeedReportObject.cdnEndTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 24: 
          localFinderFeedReportObject.remuxEndTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMediaReportObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderFeedReportObject.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 26: 
          localFinderFeedReportObject.retryCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 27: 
          localFinderFeedReportObject.isBeauty = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 28: 
          localFinderFeedReportObject.isDurationCut = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 29: 
          localFinderFeedReportObject.beforeCutMediaPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 30: 
          localFinderFeedReportObject.isMultiShot = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 31: 
          localFinderFeedReportObject.multiShotChangeCnt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 32: 
          localFinderFeedReportObject.multiShotClickCnt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 33: 
          localFinderFeedReportObject.multiShotSuccessCnt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 35: 
          localFinderFeedReportObject.multiShotVideoCnt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 36: 
          localFinderFeedReportObject.videoSubType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 37: 
          localFinderFeedReportObject.postId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 38: 
          localFinderFeedReportObject.editId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 39: 
          localFinderFeedReportObject.mentionCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 40: 
          localFinderFeedReportObject.clickMentionCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 41: 
          localFinderFeedReportObject.clickSucMentionCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 42: 
          localFinderFeedReportObject.mentionRepeatCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 43: 
          localFinderFeedReportObject.lbsFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderFeedReportObject.selectLocation = ((axt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 45: 
          localFinderFeedReportObject.remuxType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 46: 
          localFinderFeedReportObject.uploadLogicError = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 47: 
          localFinderFeedReportObject.postStage = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 48: 
          localFinderFeedReportObject.cgiErrorCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 49: 
          localFinderFeedReportObject.cgiErrorType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 50: 
          localFinderFeedReportObject.clickId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 51: 
          localFinderFeedReportObject.soundTrackType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 52: 
          localFinderFeedReportObject.followSoundTrackId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 53: 
          localFinderFeedReportObject.megaCgiErrorCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 54: 
          localFinderFeedReportObject.megaCgiErrorType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 55: 
          localFinderFeedReportObject.musicType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 56: 
          localFinderFeedReportObject.longVideoSizeInvalid = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 57: 
          localFinderFeedReportObject.mediaProcessCost = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 58: 
          localFinderFeedReportObject.uploadCost = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 59: 
          localFinderFeedReportObject.uploadMediaTotalSize = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168957);
          return 0;
        case 60: 
          localFinderFeedReportObject.postTaskCost = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 61: 
          localFinderFeedReportObject.clickRepostCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 62: 
          localFinderFeedReportObject.dumpCgiErrorCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 63: 
          localFinderFeedReportObject.dumpCgiErrorType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 64: 
          localFinderFeedReportObject.sdkShareType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        case 65: 
          localFinderFeedReportObject.forwardingAppId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 66: 
          localFinderFeedReportObject.topicActivityId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 67: 
          localFinderFeedReportObject.topicActivityType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168957);
          return 0;
        }
        localFinderFeedReportObject.draftType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168957);
        return 0;
      }
      AppMethodBeat.o(168957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderFeedReportObject
 * JD-Core Version:    0.7.0.1
 */