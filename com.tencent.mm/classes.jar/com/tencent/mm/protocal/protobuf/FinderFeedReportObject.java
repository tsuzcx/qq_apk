package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderFeedReportObject
  extends com.tencent.mm.bw.a
{
  public String actionTrace;
  public String beforeCutMediaPath;
  public long cdnEndTime;
  public int clickMentionCount;
  public int clickSucMentionCount;
  public int descCount;
  public int descEmojiCount;
  public int draft;
  public String editId;
  public int enterScene;
  public long enterTakePhotoTime;
  public long enterVideoEditTime;
  public int existDesc;
  public int existLocation;
  public int exitPageId;
  public int isBeauty;
  public int isDurationCut;
  public int isMultiShot;
  public int lbsFlag;
  public String link;
  public LinkedList<FinderMediaReportObject> mediaList;
  public int mentionCount;
  public int mentionRepeatCount;
  public int multiShotChangeCnt;
  public int multiShotClickCnt;
  public int multiShotSuccessCnt;
  public int multiShotVideoCnt;
  public String postId;
  public long remuxEndTime;
  public int remuxType;
  public int retryCount;
  public alt selectLocation;
  public long sendOrExitButtonTime;
  public String sessionId;
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      paramVarArgs.aR(2, this.enterScene);
      paramVarArgs.aR(3, this.exitPageId);
      paramVarArgs.aO(4, this.enterTakePhotoTime);
      paramVarArgs.aO(5, this.enterVideoEditTime);
      paramVarArgs.aO(6, this.sendOrExitButtonTime);
      paramVarArgs.aO(7, this.videoRecordTime);
      paramVarArgs.aR(8, this.videoSource);
      paramVarArgs.aR(9, this.videoEmojiCount);
      paramVarArgs.aR(10, this.videoWordingCount);
      if (this.videoMusicId != null) {
        paramVarArgs.d(11, this.videoMusicId);
      }
      paramVarArgs.aR(12, this.videoMusicIndex);
      paramVarArgs.aR(13, this.videoMusicSearch);
      paramVarArgs.aR(14, this.videoPostType);
      if (this.videoMediaInfo != null) {
        paramVarArgs.d(15, this.videoMediaInfo);
      }
      paramVarArgs.aR(16, this.existDesc);
      paramVarArgs.aR(17, this.descCount);
      paramVarArgs.aR(18, this.descEmojiCount);
      if (this.actionTrace != null) {
        paramVarArgs.d(19, this.actionTrace);
      }
      paramVarArgs.aR(20, this.existLocation);
      if (this.link != null) {
        paramVarArgs.d(21, this.link);
      }
      paramVarArgs.aR(22, this.draft);
      paramVarArgs.aO(23, this.cdnEndTime);
      paramVarArgs.aO(24, this.remuxEndTime);
      paramVarArgs.e(25, 8, this.mediaList);
      paramVarArgs.aR(26, this.retryCount);
      paramVarArgs.aR(27, this.isBeauty);
      paramVarArgs.aR(28, this.isDurationCut);
      if (this.beforeCutMediaPath != null) {
        paramVarArgs.d(29, this.beforeCutMediaPath);
      }
      paramVarArgs.aR(30, this.isMultiShot);
      paramVarArgs.aR(31, this.multiShotChangeCnt);
      paramVarArgs.aR(32, this.multiShotClickCnt);
      paramVarArgs.aR(33, this.multiShotSuccessCnt);
      paramVarArgs.aR(35, this.multiShotVideoCnt);
      paramVarArgs.aR(36, this.videoSubType);
      if (this.postId != null) {
        paramVarArgs.d(37, this.postId);
      }
      if (this.editId != null) {
        paramVarArgs.d(38, this.editId);
      }
      paramVarArgs.aR(39, this.mentionCount);
      paramVarArgs.aR(40, this.clickMentionCount);
      paramVarArgs.aR(41, this.clickSucMentionCount);
      paramVarArgs.aR(42, this.mentionRepeatCount);
      paramVarArgs.aR(43, this.lbsFlag);
      if (this.selectLocation != null)
      {
        paramVarArgs.ln(44, this.selectLocation.computeSize());
        this.selectLocation.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(45, this.remuxType);
      AppMethodBeat.o(168957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label2454;
      }
    }
    label2454:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.enterScene) + f.a.a.b.b.a.bx(3, this.exitPageId) + f.a.a.b.b.a.p(4, this.enterTakePhotoTime) + f.a.a.b.b.a.p(5, this.enterVideoEditTime) + f.a.a.b.b.a.p(6, this.sendOrExitButtonTime) + f.a.a.b.b.a.p(7, this.videoRecordTime) + f.a.a.b.b.a.bx(8, this.videoSource) + f.a.a.b.b.a.bx(9, this.videoEmojiCount) + f.a.a.b.b.a.bx(10, this.videoWordingCount);
      paramInt = i;
      if (this.videoMusicId != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.videoMusicId);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.videoMusicIndex) + f.a.a.b.b.a.bx(13, this.videoMusicSearch) + f.a.a.b.b.a.bx(14, this.videoPostType);
      paramInt = i;
      if (this.videoMediaInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.videoMediaInfo);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.existDesc) + f.a.a.b.b.a.bx(17, this.descCount) + f.a.a.b.b.a.bx(18, this.descEmojiCount);
      paramInt = i;
      if (this.actionTrace != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.actionTrace);
      }
      i = paramInt + f.a.a.b.b.a.bx(20, this.existLocation);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.link);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.draft) + f.a.a.b.b.a.p(23, this.cdnEndTime) + f.a.a.b.b.a.p(24, this.remuxEndTime) + f.a.a.a.c(25, 8, this.mediaList) + f.a.a.b.b.a.bx(26, this.retryCount) + f.a.a.b.b.a.bx(27, this.isBeauty) + f.a.a.b.b.a.bx(28, this.isDurationCut);
      paramInt = i;
      if (this.beforeCutMediaPath != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.beforeCutMediaPath);
      }
      i = paramInt + f.a.a.b.b.a.bx(30, this.isMultiShot) + f.a.a.b.b.a.bx(31, this.multiShotChangeCnt) + f.a.a.b.b.a.bx(32, this.multiShotClickCnt) + f.a.a.b.b.a.bx(33, this.multiShotSuccessCnt) + f.a.a.b.b.a.bx(35, this.multiShotVideoCnt) + f.a.a.b.b.a.bx(36, this.videoSubType);
      paramInt = i;
      if (this.postId != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.postId);
      }
      i = paramInt;
      if (this.editId != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.editId);
      }
      i = i + f.a.a.b.b.a.bx(39, this.mentionCount) + f.a.a.b.b.a.bx(40, this.clickMentionCount) + f.a.a.b.b.a.bx(41, this.clickSucMentionCount) + f.a.a.b.b.a.bx(42, this.mentionRepeatCount) + f.a.a.b.b.a.bx(43, this.lbsFlag);
      paramInt = i;
      if (this.selectLocation != null) {
        paramInt = i + f.a.a.a.lm(44, this.selectLocation.computeSize());
      }
      i = f.a.a.b.b.a.bx(45, this.remuxType);
      AppMethodBeat.o(168957);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          localFinderFeedReportObject.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 2: 
          localFinderFeedReportObject.enterScene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 3: 
          localFinderFeedReportObject.exitPageId = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 4: 
          localFinderFeedReportObject.enterTakePhotoTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 5: 
          localFinderFeedReportObject.enterVideoEditTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 6: 
          localFinderFeedReportObject.sendOrExitButtonTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 7: 
          localFinderFeedReportObject.videoRecordTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 8: 
          localFinderFeedReportObject.videoSource = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 9: 
          localFinderFeedReportObject.videoEmojiCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 10: 
          localFinderFeedReportObject.videoWordingCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 11: 
          localFinderFeedReportObject.videoMusicId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 12: 
          localFinderFeedReportObject.videoMusicIndex = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 13: 
          localFinderFeedReportObject.videoMusicSearch = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 14: 
          localFinderFeedReportObject.videoPostType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 15: 
          localFinderFeedReportObject.videoMediaInfo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 16: 
          localFinderFeedReportObject.existDesc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 17: 
          localFinderFeedReportObject.descCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 18: 
          localFinderFeedReportObject.descEmojiCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 19: 
          localFinderFeedReportObject.actionTrace = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 20: 
          localFinderFeedReportObject.existLocation = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 21: 
          localFinderFeedReportObject.link = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 22: 
          localFinderFeedReportObject.draft = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 23: 
          localFinderFeedReportObject.cdnEndTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 24: 
          localFinderFeedReportObject.remuxEndTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168957);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMediaReportObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderFeedReportObject.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        case 26: 
          localFinderFeedReportObject.retryCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 27: 
          localFinderFeedReportObject.isBeauty = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 28: 
          localFinderFeedReportObject.isDurationCut = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 29: 
          localFinderFeedReportObject.beforeCutMediaPath = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 30: 
          localFinderFeedReportObject.isMultiShot = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 31: 
          localFinderFeedReportObject.multiShotChangeCnt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 32: 
          localFinderFeedReportObject.multiShotClickCnt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 33: 
          localFinderFeedReportObject.multiShotSuccessCnt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 35: 
          localFinderFeedReportObject.multiShotVideoCnt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 36: 
          localFinderFeedReportObject.videoSubType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 37: 
          localFinderFeedReportObject.postId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 38: 
          localFinderFeedReportObject.editId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168957);
          return 0;
        case 39: 
          localFinderFeedReportObject.mentionCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 40: 
          localFinderFeedReportObject.clickMentionCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 41: 
          localFinderFeedReportObject.clickSucMentionCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 42: 
          localFinderFeedReportObject.mentionRepeatCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 43: 
          localFinderFeedReportObject.lbsFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168957);
          return 0;
        case 44: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderFeedReportObject.selectLocation = ((alt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168957);
          return 0;
        }
        localFinderFeedReportObject.remuxType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168957);
        return 0;
      }
      AppMethodBeat.o(168957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderFeedReportObject
 * JD-Core Version:    0.7.0.1
 */