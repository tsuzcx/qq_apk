package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class FinderObject
  extends com.tencent.mm.cd.a
{
  public int adFlag;
  public bfq adInfo;
  public apx attachmentList;
  public bfu client_local_buffer;
  public int commentClose;
  public int commentCount;
  public LinkedList<FinderCommentInfo> commentList;
  public FinderContact contact;
  public int createtime;
  public String debugMessage;
  public int deletetime;
  public long displayId;
  public String displayidDiscarded;
  public int event_status_flag;
  public int favCount;
  public int favFlag;
  public int foldedFlag;
  public asz foldedLayout;
  public int follow_feed_count;
  public int forwardCount;
  public int forward_style;
  public LinkedList<FinderCommentInfo> friendCommentList;
  public int friendLikeCount;
  public bgc hotTopics;
  public bgd hotWordInfo;
  public long id;
  public int incFriendLikeCount;
  public int is_poi_same_city;
  public b likeBuffer;
  public int likeCount;
  public int likeFlag;
  public LinkedList<FinderCommentInfo> likeList;
  public bac liveInfo;
  public b live_related_last_buffer;
  public int mentionedListSelected;
  public LinkedList<FinderContact> mentionedUserContact;
  public int msgEventFlag;
  public String msgId;
  public String nickname;
  public FinderObjectDesc objectDesc;
  public String objectNonceId;
  public int objectStatus;
  public int objectType;
  public int orgRecommendType;
  public int originalFlag;
  public int permissionFlag;
  public String posTriggerConfig;
  public int privateFlag;
  public bhl publisher_info;
  public int readCount;
  public String recommendReason;
  public int recommendReasonType;
  public int recommendType;
  public LinkedList<String> recommenderList;
  public FinderContact refObjectContact;
  public long refObjectFlag;
  public long refObjectId;
  public String refObjectNonceId;
  public int secondaryShowFlag;
  public String sendShareFavWording;
  public String sessionBuffer;
  public bjl snsShareInfo;
  public int stickyTime;
  public String tipsWording;
  public bkm tips_info;
  public int urlValidDuration;
  public String username;
  public String verify_info_buf;
  public int warnFlag;
  public String warnWording;
  public int wxStatusPermissionFlag;
  public int wx_status_ref_count;
  
  public FinderObject()
  {
    AppMethodBeat.i(169021);
    this.likeList = new LinkedList();
    this.commentList = new LinkedList();
    this.recommenderList = new LinkedList();
    this.mentionedUserContact = new LinkedList();
    this.friendCommentList = new LinkedList();
    AppMethodBeat.o(169021);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169022);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.f(3, this.username);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.oE(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.createtime);
      paramVarArgs.aY(6, this.likeFlag);
      paramVarArgs.e(7, 8, this.likeList);
      paramVarArgs.e(8, 8, this.commentList);
      paramVarArgs.aY(9, this.forwardCount);
      if (this.contact != null)
      {
        paramVarArgs.oE(10, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.f(11, this.displayidDiscarded);
      }
      paramVarArgs.e(12, 1, this.recommenderList);
      paramVarArgs.bm(13, this.displayId);
      paramVarArgs.aY(14, this.likeCount);
      paramVarArgs.aY(15, this.commentCount);
      if (this.recommendReason != null) {
        paramVarArgs.f(16, this.recommendReason);
      }
      paramVarArgs.aY(17, this.readCount);
      paramVarArgs.aY(18, this.deletetime);
      paramVarArgs.aY(19, this.commentClose);
      paramVarArgs.bm(20, this.refObjectFlag);
      paramVarArgs.bm(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.oE(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(23, this.recommendType);
      paramVarArgs.aY(24, this.friendLikeCount);
      if (this.objectNonceId != null) {
        paramVarArgs.f(25, this.objectNonceId);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.f(26, this.refObjectNonceId);
      }
      paramVarArgs.aY(27, this.objectStatus);
      if (this.sendShareFavWording != null) {
        paramVarArgs.f(28, this.sendShareFavWording);
      }
      paramVarArgs.aY(29, this.originalFlag);
      paramVarArgs.aY(30, this.secondaryShowFlag);
      if (this.tipsWording != null) {
        paramVarArgs.f(31, this.tipsWording);
      }
      paramVarArgs.aY(32, this.orgRecommendType);
      paramVarArgs.e(33, 8, this.mentionedUserContact);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(34, this.sessionBuffer);
      }
      paramVarArgs.aY(35, this.warnFlag);
      if (this.warnWording != null) {
        paramVarArgs.f(36, this.warnWording);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.oE(37, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(38, this.favCount);
      paramVarArgs.aY(39, this.favFlag);
      paramVarArgs.aY(40, this.foldedFlag);
      if (this.foldedLayout != null)
      {
        paramVarArgs.oE(41, this.foldedLayout.computeSize());
        this.foldedLayout.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(42, this.recommendReasonType);
      paramVarArgs.aY(43, this.urlValidDuration);
      paramVarArgs.aY(44, this.forward_style);
      if (this.posTriggerConfig != null) {
        paramVarArgs.f(45, this.posTriggerConfig);
      }
      paramVarArgs.aY(46, this.privateFlag);
      paramVarArgs.aY(47, this.msgEventFlag);
      if (this.msgId != null) {
        paramVarArgs.f(48, this.msgId);
      }
      paramVarArgs.aY(49, this.incFriendLikeCount);
      if (this.debugMessage != null) {
        paramVarArgs.f(50, this.debugMessage);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.c(51, this.likeBuffer);
      }
      paramVarArgs.aY(52, this.permissionFlag);
      paramVarArgs.aY(54, this.stickyTime);
      if (this.hotTopics != null)
      {
        paramVarArgs.oE(55, this.hotTopics.computeSize());
        this.hotTopics.writeFields(paramVarArgs);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.oE(56, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(57, this.objectType);
      if (this.snsShareInfo != null)
      {
        paramVarArgs.oE(58, this.snsShareInfo.computeSize());
        this.snsShareInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(60, this.follow_feed_count);
      paramVarArgs.aY(61, this.event_status_flag);
      paramVarArgs.aY(62, this.is_poi_same_city);
      paramVarArgs.aY(63, this.mentionedListSelected);
      if (this.verify_info_buf != null) {
        paramVarArgs.f(64, this.verify_info_buf);
      }
      paramVarArgs.aY(65, this.wx_status_ref_count);
      paramVarArgs.aY(66, this.wxStatusPermissionFlag);
      if (this.adInfo != null)
      {
        paramVarArgs.oE(67, this.adInfo.computeSize());
        this.adInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(68, 8, this.friendCommentList);
      if (this.hotWordInfo != null)
      {
        paramVarArgs.oE(69, this.hotWordInfo.computeSize());
        this.hotWordInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(70, this.adFlag);
      if (this.tips_info != null)
      {
        paramVarArgs.oE(71, this.tips_info.computeSize());
        this.tips_info.writeFields(paramVarArgs);
      }
      if (this.client_local_buffer != null)
      {
        paramVarArgs.oE(72, this.client_local_buffer.computeSize());
        this.client_local_buffer.writeFields(paramVarArgs);
      }
      if (this.publisher_info != null)
      {
        paramVarArgs.oE(73, this.publisher_info.computeSize());
        this.publisher_info.writeFields(paramVarArgs);
      }
      if (this.live_related_last_buffer != null) {
        paramVarArgs.c(74, this.live_related_last_buffer);
      }
      AppMethodBeat.o(169022);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.username);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + g.a.a.a.oD(4, this.objectDesc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.createtime) + g.a.a.b.b.a.bM(6, this.likeFlag) + g.a.a.a.c(7, 8, this.likeList) + g.a.a.a.c(8, 8, this.commentList) + g.a.a.b.b.a.bM(9, this.forwardCount);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.oD(10, this.contact.computeSize());
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.displayidDiscarded);
      }
      i = i + g.a.a.a.c(12, 1, this.recommenderList) + g.a.a.b.b.a.p(13, this.displayId) + g.a.a.b.b.a.bM(14, this.likeCount) + g.a.a.b.b.a.bM(15, this.commentCount);
      paramInt = i;
      if (this.recommendReason != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.recommendReason);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.readCount) + g.a.a.b.b.a.bM(18, this.deletetime) + g.a.a.b.b.a.bM(19, this.commentClose) + g.a.a.b.b.a.p(20, this.refObjectFlag) + g.a.a.b.b.a.p(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + g.a.a.a.oD(22, this.refObjectContact.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.recommendType) + g.a.a.b.b.a.bM(24, this.friendLikeCount);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.objectNonceId);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.refObjectNonceId);
      }
      i += g.a.a.b.b.a.bM(27, this.objectStatus);
      paramInt = i;
      if (this.sendShareFavWording != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.sendShareFavWording);
      }
      i = paramInt + g.a.a.b.b.a.bM(29, this.originalFlag) + g.a.a.b.b.a.bM(30, this.secondaryShowFlag);
      paramInt = i;
      if (this.tipsWording != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.tipsWording);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.orgRecommendType) + g.a.a.a.c(33, 8, this.mentionedUserContact);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(35, this.warnFlag);
      paramInt = i;
      if (this.warnWording != null) {
        paramInt = i + g.a.a.b.b.a.g(36, this.warnWording);
      }
      i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + g.a.a.a.oD(37, this.liveInfo.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(38, this.favCount) + g.a.a.b.b.a.bM(39, this.favFlag) + g.a.a.b.b.a.bM(40, this.foldedFlag);
      paramInt = i;
      if (this.foldedLayout != null) {
        paramInt = i + g.a.a.a.oD(41, this.foldedLayout.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(42, this.recommendReasonType) + g.a.a.b.b.a.bM(43, this.urlValidDuration) + g.a.a.b.b.a.bM(44, this.forward_style);
      paramInt = i;
      if (this.posTriggerConfig != null) {
        paramInt = i + g.a.a.b.b.a.g(45, this.posTriggerConfig);
      }
      i = paramInt + g.a.a.b.b.a.bM(46, this.privateFlag) + g.a.a.b.b.a.bM(47, this.msgEventFlag);
      paramInt = i;
      if (this.msgId != null) {
        paramInt = i + g.a.a.b.b.a.g(48, this.msgId);
      }
      i = paramInt + g.a.a.b.b.a.bM(49, this.incFriendLikeCount);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + g.a.a.b.b.a.g(50, this.debugMessage);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(51, this.likeBuffer);
      }
      i = i + g.a.a.b.b.a.bM(52, this.permissionFlag) + g.a.a.b.b.a.bM(54, this.stickyTime);
      paramInt = i;
      if (this.hotTopics != null) {
        paramInt = i + g.a.a.a.oD(55, this.hotTopics.computeSize());
      }
      i = paramInt;
      if (this.attachmentList != null) {
        i = paramInt + g.a.a.a.oD(56, this.attachmentList.computeSize());
      }
      i += g.a.a.b.b.a.bM(57, this.objectType);
      paramInt = i;
      if (this.snsShareInfo != null) {
        paramInt = i + g.a.a.a.oD(58, this.snsShareInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(60, this.follow_feed_count) + g.a.a.b.b.a.bM(61, this.event_status_flag) + g.a.a.b.b.a.bM(62, this.is_poi_same_city) + g.a.a.b.b.a.bM(63, this.mentionedListSelected);
      paramInt = i;
      if (this.verify_info_buf != null) {
        paramInt = i + g.a.a.b.b.a.g(64, this.verify_info_buf);
      }
      i = paramInt + g.a.a.b.b.a.bM(65, this.wx_status_ref_count) + g.a.a.b.b.a.bM(66, this.wxStatusPermissionFlag);
      paramInt = i;
      if (this.adInfo != null) {
        paramInt = i + g.a.a.a.oD(67, this.adInfo.computeSize());
      }
      i = paramInt + g.a.a.a.c(68, 8, this.friendCommentList);
      paramInt = i;
      if (this.hotWordInfo != null) {
        paramInt = i + g.a.a.a.oD(69, this.hotWordInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(70, this.adFlag);
      paramInt = i;
      if (this.tips_info != null) {
        paramInt = i + g.a.a.a.oD(71, this.tips_info.computeSize());
      }
      i = paramInt;
      if (this.client_local_buffer != null) {
        i = paramInt + g.a.a.a.oD(72, this.client_local_buffer.computeSize());
      }
      paramInt = i;
      if (this.publisher_info != null) {
        paramInt = i + g.a.a.a.oD(73, this.publisher_info.computeSize());
      }
      i = paramInt;
      if (this.live_related_last_buffer != null) {
        i = paramInt + g.a.a.b.b.a.b(74, this.live_related_last_buffer);
      }
      AppMethodBeat.o(169022);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.likeList.clear();
      this.commentList.clear();
      this.recommenderList.clear();
      this.mentionedUserContact.clear();
      this.friendCommentList.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169022);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      FinderObject localFinderObject = (FinderObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 53: 
      case 59: 
      default: 
        AppMethodBeat.o(169022);
        return -1;
      case 1: 
        localFinderObject.id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169022);
        return 0;
      case 2: 
        localFinderObject.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 3: 
        localFinderObject.username = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObjectDesc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.objectDesc = ((FinderObjectDesc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 5: 
        localFinderObject.createtime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 6: 
        localFinderObject.likeFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.likeList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.commentList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 9: 
        localFinderObject.forwardCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 10: 
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
          localFinderObject.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 11: 
        localFinderObject.displayidDiscarded = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 12: 
        localFinderObject.recommenderList.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(169022);
        return 0;
      case 13: 
        localFinderObject.displayId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169022);
        return 0;
      case 14: 
        localFinderObject.likeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 15: 
        localFinderObject.commentCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 16: 
        localFinderObject.recommendReason = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 17: 
        localFinderObject.readCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 18: 
        localFinderObject.deletetime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 19: 
        localFinderObject.commentClose = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 20: 
        localFinderObject.refObjectFlag = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169022);
        return 0;
      case 21: 
        localFinderObject.refObjectId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169022);
        return 0;
      case 22: 
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
          localFinderObject.refObjectContact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 23: 
        localFinderObject.recommendType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 24: 
        localFinderObject.friendLikeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 25: 
        localFinderObject.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 26: 
        localFinderObject.refObjectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 27: 
        localFinderObject.objectStatus = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 28: 
        localFinderObject.sendShareFavWording = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 29: 
        localFinderObject.originalFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 30: 
        localFinderObject.secondaryShowFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 31: 
        localFinderObject.tipsWording = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 32: 
        localFinderObject.orgRecommendType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 33: 
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
          localFinderObject.mentionedUserContact.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 34: 
        localFinderObject.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 35: 
        localFinderObject.warnFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 36: 
        localFinderObject.warnWording = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 37: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bac();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bac)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.liveInfo = ((bac)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 38: 
        localFinderObject.favCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 39: 
        localFinderObject.favFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 40: 
        localFinderObject.foldedFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 41: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asz)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.foldedLayout = ((asz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 42: 
        localFinderObject.recommendReasonType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 43: 
        localFinderObject.urlValidDuration = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 44: 
        localFinderObject.forward_style = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 45: 
        localFinderObject.posTriggerConfig = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 46: 
        localFinderObject.privateFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 47: 
        localFinderObject.msgEventFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 48: 
        localFinderObject.msgId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 49: 
        localFinderObject.incFriendLikeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 50: 
        localFinderObject.debugMessage = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 51: 
        localFinderObject.likeBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(169022);
        return 0;
      case 52: 
        localFinderObject.permissionFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 54: 
        localFinderObject.stickyTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 55: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgc)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.hotTopics = ((bgc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 56: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new apx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((apx)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.attachmentList = ((apx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 57: 
        localFinderObject.objectType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 58: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjl)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.snsShareInfo = ((bjl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 60: 
        localFinderObject.follow_feed_count = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 61: 
        localFinderObject.event_status_flag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 62: 
        localFinderObject.is_poi_same_city = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 63: 
        localFinderObject.mentionedListSelected = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 64: 
        localFinderObject.verify_info_buf = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 65: 
        localFinderObject.wx_status_ref_count = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 66: 
        localFinderObject.wxStatusPermissionFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 67: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfq)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.adInfo = ((bfq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 68: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.friendCommentList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 69: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgd)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.hotWordInfo = ((bgd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 70: 
        localFinderObject.adFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169022);
        return 0;
      case 71: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkm)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.tips_info = ((bkm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 72: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfu)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.client_local_buffer = ((bfu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 73: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bhl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bhl)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.publisher_info = ((bhl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      }
      localFinderObject.live_related_last_buffer = ((g.a.a.a.a)localObject1).abFh.iUw();
      AppMethodBeat.o(169022);
      return 0;
    }
    AppMethodBeat.o(169022);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderObject
 * JD-Core Version:    0.7.0.1
 */