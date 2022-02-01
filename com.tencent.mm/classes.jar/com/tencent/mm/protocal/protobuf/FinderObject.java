package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class FinderObject
  extends com.tencent.mm.bx.a
{
  public int adFlag;
  public bqx adInfo;
  public atr attachmentList;
  public brb client_local_buffer;
  public int commentClose;
  public int commentCount;
  public LinkedList<FinderCommentInfo> commentList;
  public FinderContact contact;
  public b cookie;
  public int createtime;
  public String debugMessage;
  public int deletetime;
  public long displayId;
  public String displayidDiscarded;
  public int event_status_flag;
  public int favCount;
  public int favFlag;
  public int foldedFlag;
  public axn foldedLayout;
  public int followCount;
  public int follow_feed_count;
  public int forwardCount;
  public int forward_style;
  public LinkedList<FinderCommentInfo> friendCommentList;
  public int friendLikeCount;
  public int friend_fav_count;
  public int func_flag;
  public brn hotTopics;
  public bro hotWordInfo;
  public long id;
  public int incFriendLikeCount;
  public String internal_feedback_url;
  public int is_poi_same_city;
  public b likeBuffer;
  public int likeCount;
  public int likeFlag;
  public LinkedList<FinderCommentInfo> likeList;
  public bip liveInfo;
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
  public brp place_holder_info;
  public String posTriggerConfig;
  public int preview_flag;
  public int privateFlag;
  public btj publisher_info;
  public int readCount;
  public String recommendReason;
  public int recommendReasonType;
  public int recommendType;
  public LinkedList<String> recommenderList;
  public FinderContact refObjectContact;
  public long refObjectFlag;
  public long refObjectId;
  public String refObjectNonceId;
  public int ringtone_count;
  public int secondaryShowFlag;
  public String sendShareFavWording;
  public String sessionBuffer;
  public bvv snsShareInfo;
  public int stickyTime;
  public String tipsWording;
  public bxp tips_info;
  public int urlValidDuration;
  public String username;
  public String verify_info_buf;
  public int warnFlag;
  public String warnWording;
  public int wxStatusPermissionFlag;
  public String wx_status_icon_id;
  public int wx_status_ref_count;
  public String wxa_game_export_id;
  
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.qD(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.createtime);
      paramVarArgs.bS(6, this.likeFlag);
      paramVarArgs.e(7, 8, this.likeList);
      paramVarArgs.e(8, 8, this.commentList);
      paramVarArgs.bS(9, this.forwardCount);
      if (this.contact != null)
      {
        paramVarArgs.qD(10, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.g(11, this.displayidDiscarded);
      }
      paramVarArgs.e(12, 1, this.recommenderList);
      paramVarArgs.bv(13, this.displayId);
      paramVarArgs.bS(14, this.likeCount);
      paramVarArgs.bS(15, this.commentCount);
      if (this.recommendReason != null) {
        paramVarArgs.g(16, this.recommendReason);
      }
      paramVarArgs.bS(17, this.readCount);
      paramVarArgs.bS(18, this.deletetime);
      paramVarArgs.bS(19, this.commentClose);
      paramVarArgs.bv(20, this.refObjectFlag);
      paramVarArgs.bv(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.qD(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.recommendType);
      paramVarArgs.bS(24, this.friendLikeCount);
      if (this.objectNonceId != null) {
        paramVarArgs.g(25, this.objectNonceId);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.g(26, this.refObjectNonceId);
      }
      paramVarArgs.bS(27, this.objectStatus);
      if (this.sendShareFavWording != null) {
        paramVarArgs.g(28, this.sendShareFavWording);
      }
      paramVarArgs.bS(29, this.originalFlag);
      paramVarArgs.bS(30, this.secondaryShowFlag);
      if (this.tipsWording != null) {
        paramVarArgs.g(31, this.tipsWording);
      }
      paramVarArgs.bS(32, this.orgRecommendType);
      paramVarArgs.e(33, 8, this.mentionedUserContact);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(34, this.sessionBuffer);
      }
      paramVarArgs.bS(35, this.warnFlag);
      if (this.warnWording != null) {
        paramVarArgs.g(36, this.warnWording);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.qD(37, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(38, this.favCount);
      paramVarArgs.bS(39, this.favFlag);
      paramVarArgs.bS(40, this.foldedFlag);
      if (this.foldedLayout != null)
      {
        paramVarArgs.qD(41, this.foldedLayout.computeSize());
        this.foldedLayout.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(42, this.recommendReasonType);
      paramVarArgs.bS(43, this.urlValidDuration);
      paramVarArgs.bS(44, this.forward_style);
      if (this.posTriggerConfig != null) {
        paramVarArgs.g(45, this.posTriggerConfig);
      }
      paramVarArgs.bS(46, this.privateFlag);
      paramVarArgs.bS(47, this.msgEventFlag);
      if (this.msgId != null) {
        paramVarArgs.g(48, this.msgId);
      }
      paramVarArgs.bS(49, this.incFriendLikeCount);
      if (this.debugMessage != null) {
        paramVarArgs.g(50, this.debugMessage);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.d(51, this.likeBuffer);
      }
      paramVarArgs.bS(52, this.permissionFlag);
      paramVarArgs.bS(54, this.stickyTime);
      if (this.hotTopics != null)
      {
        paramVarArgs.qD(55, this.hotTopics.computeSize());
        this.hotTopics.writeFields(paramVarArgs);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.qD(56, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(57, this.objectType);
      if (this.snsShareInfo != null)
      {
        paramVarArgs.qD(58, this.snsShareInfo.computeSize());
        this.snsShareInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(60, this.follow_feed_count);
      paramVarArgs.bS(61, this.event_status_flag);
      paramVarArgs.bS(62, this.is_poi_same_city);
      paramVarArgs.bS(63, this.mentionedListSelected);
      if (this.verify_info_buf != null) {
        paramVarArgs.g(64, this.verify_info_buf);
      }
      paramVarArgs.bS(65, this.wx_status_ref_count);
      paramVarArgs.bS(66, this.wxStatusPermissionFlag);
      if (this.adInfo != null)
      {
        paramVarArgs.qD(67, this.adInfo.computeSize());
        this.adInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(68, 8, this.friendCommentList);
      if (this.hotWordInfo != null)
      {
        paramVarArgs.qD(69, this.hotWordInfo.computeSize());
        this.hotWordInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(70, this.adFlag);
      if (this.tips_info != null)
      {
        paramVarArgs.qD(71, this.tips_info.computeSize());
        this.tips_info.writeFields(paramVarArgs);
      }
      if (this.client_local_buffer != null)
      {
        paramVarArgs.qD(72, this.client_local_buffer.computeSize());
        this.client_local_buffer.writeFields(paramVarArgs);
      }
      if (this.publisher_info != null)
      {
        paramVarArgs.qD(73, this.publisher_info.computeSize());
        this.publisher_info.writeFields(paramVarArgs);
      }
      if (this.live_related_last_buffer != null) {
        paramVarArgs.d(74, this.live_related_last_buffer);
      }
      paramVarArgs.bS(75, this.followCount);
      if (this.cookie != null) {
        paramVarArgs.d(76, this.cookie);
      }
      paramVarArgs.bS(77, this.preview_flag);
      if (this.internal_feedback_url != null) {
        paramVarArgs.g(78, this.internal_feedback_url);
      }
      if (this.wxa_game_export_id != null) {
        paramVarArgs.g(79, this.wxa_game_export_id);
      }
      paramVarArgs.bS(80, this.ringtone_count);
      if (this.wx_status_icon_id != null) {
        paramVarArgs.g(81, this.wx_status_icon_id);
      }
      paramVarArgs.bS(82, this.friend_fav_count);
      paramVarArgs.bS(83, this.func_flag);
      if (this.place_holder_info != null)
      {
        paramVarArgs.qD(85, this.place_holder_info.computeSize());
        this.place_holder_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169022);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + i.a.a.a.qC(4, this.objectDesc.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.createtime) + i.a.a.b.b.a.cJ(6, this.likeFlag) + i.a.a.a.c(7, 8, this.likeList) + i.a.a.a.c(8, 8, this.commentList) + i.a.a.b.b.a.cJ(9, this.forwardCount);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + i.a.a.a.qC(10, this.contact.computeSize());
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.displayidDiscarded);
      }
      i = i + i.a.a.a.c(12, 1, this.recommenderList) + i.a.a.b.b.a.q(13, this.displayId) + i.a.a.b.b.a.cJ(14, this.likeCount) + i.a.a.b.b.a.cJ(15, this.commentCount);
      paramInt = i;
      if (this.recommendReason != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.recommendReason);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.readCount) + i.a.a.b.b.a.cJ(18, this.deletetime) + i.a.a.b.b.a.cJ(19, this.commentClose) + i.a.a.b.b.a.q(20, this.refObjectFlag) + i.a.a.b.b.a.q(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + i.a.a.a.qC(22, this.refObjectContact.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.recommendType) + i.a.a.b.b.a.cJ(24, this.friendLikeCount);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.objectNonceId);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.refObjectNonceId);
      }
      i += i.a.a.b.b.a.cJ(27, this.objectStatus);
      paramInt = i;
      if (this.sendShareFavWording != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.sendShareFavWording);
      }
      i = paramInt + i.a.a.b.b.a.cJ(29, this.originalFlag) + i.a.a.b.b.a.cJ(30, this.secondaryShowFlag);
      paramInt = i;
      if (this.tipsWording != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.tipsWording);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.orgRecommendType) + i.a.a.a.c(33, 8, this.mentionedUserContact);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.sessionBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(35, this.warnFlag);
      paramInt = i;
      if (this.warnWording != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.warnWording);
      }
      i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + i.a.a.a.qC(37, this.liveInfo.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(38, this.favCount) + i.a.a.b.b.a.cJ(39, this.favFlag) + i.a.a.b.b.a.cJ(40, this.foldedFlag);
      paramInt = i;
      if (this.foldedLayout != null) {
        paramInt = i + i.a.a.a.qC(41, this.foldedLayout.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(42, this.recommendReasonType) + i.a.a.b.b.a.cJ(43, this.urlValidDuration) + i.a.a.b.b.a.cJ(44, this.forward_style);
      paramInt = i;
      if (this.posTriggerConfig != null) {
        paramInt = i + i.a.a.b.b.a.h(45, this.posTriggerConfig);
      }
      i = paramInt + i.a.a.b.b.a.cJ(46, this.privateFlag) + i.a.a.b.b.a.cJ(47, this.msgEventFlag);
      paramInt = i;
      if (this.msgId != null) {
        paramInt = i + i.a.a.b.b.a.h(48, this.msgId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(49, this.incFriendLikeCount);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + i.a.a.b.b.a.h(50, this.debugMessage);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(51, this.likeBuffer);
      }
      i = i + i.a.a.b.b.a.cJ(52, this.permissionFlag) + i.a.a.b.b.a.cJ(54, this.stickyTime);
      paramInt = i;
      if (this.hotTopics != null) {
        paramInt = i + i.a.a.a.qC(55, this.hotTopics.computeSize());
      }
      i = paramInt;
      if (this.attachmentList != null) {
        i = paramInt + i.a.a.a.qC(56, this.attachmentList.computeSize());
      }
      i += i.a.a.b.b.a.cJ(57, this.objectType);
      paramInt = i;
      if (this.snsShareInfo != null) {
        paramInt = i + i.a.a.a.qC(58, this.snsShareInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(60, this.follow_feed_count) + i.a.a.b.b.a.cJ(61, this.event_status_flag) + i.a.a.b.b.a.cJ(62, this.is_poi_same_city) + i.a.a.b.b.a.cJ(63, this.mentionedListSelected);
      paramInt = i;
      if (this.verify_info_buf != null) {
        paramInt = i + i.a.a.b.b.a.h(64, this.verify_info_buf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(65, this.wx_status_ref_count) + i.a.a.b.b.a.cJ(66, this.wxStatusPermissionFlag);
      paramInt = i;
      if (this.adInfo != null) {
        paramInt = i + i.a.a.a.qC(67, this.adInfo.computeSize());
      }
      i = paramInt + i.a.a.a.c(68, 8, this.friendCommentList);
      paramInt = i;
      if (this.hotWordInfo != null) {
        paramInt = i + i.a.a.a.qC(69, this.hotWordInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(70, this.adFlag);
      paramInt = i;
      if (this.tips_info != null) {
        paramInt = i + i.a.a.a.qC(71, this.tips_info.computeSize());
      }
      i = paramInt;
      if (this.client_local_buffer != null) {
        i = paramInt + i.a.a.a.qC(72, this.client_local_buffer.computeSize());
      }
      paramInt = i;
      if (this.publisher_info != null) {
        paramInt = i + i.a.a.a.qC(73, this.publisher_info.computeSize());
      }
      i = paramInt;
      if (this.live_related_last_buffer != null) {
        i = paramInt + i.a.a.b.b.a.c(74, this.live_related_last_buffer);
      }
      i += i.a.a.b.b.a.cJ(75, this.followCount);
      paramInt = i;
      if (this.cookie != null) {
        paramInt = i + i.a.a.b.b.a.c(76, this.cookie);
      }
      i = paramInt + i.a.a.b.b.a.cJ(77, this.preview_flag);
      paramInt = i;
      if (this.internal_feedback_url != null) {
        paramInt = i + i.a.a.b.b.a.h(78, this.internal_feedback_url);
      }
      i = paramInt;
      if (this.wxa_game_export_id != null) {
        i = paramInt + i.a.a.b.b.a.h(79, this.wxa_game_export_id);
      }
      i += i.a.a.b.b.a.cJ(80, this.ringtone_count);
      paramInt = i;
      if (this.wx_status_icon_id != null) {
        paramInt = i + i.a.a.b.b.a.h(81, this.wx_status_icon_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(82, this.friend_fav_count) + i.a.a.b.b.a.cJ(83, this.func_flag);
      paramInt = i;
      if (this.place_holder_info != null) {
        paramInt = i + i.a.a.a.qC(85, this.place_holder_info.computeSize());
      }
      AppMethodBeat.o(169022);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.likeList.clear();
      this.commentList.clear();
      this.recommenderList.clear();
      this.mentionedUserContact.clear();
      this.friendCommentList.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169022);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      FinderObject localFinderObject = (FinderObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 53: 
      case 59: 
      case 84: 
      default: 
        AppMethodBeat.o(169022);
        return -1;
      case 1: 
        localFinderObject.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169022);
        return 0;
      case 2: 
        localFinderObject.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 3: 
        localFinderObject.username = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        localFinderObject.createtime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 6: 
        localFinderObject.likeFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        localFinderObject.forwardCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 10: 
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
          localFinderObject.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 11: 
        localFinderObject.displayidDiscarded = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 12: 
        localFinderObject.recommenderList.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(169022);
        return 0;
      case 13: 
        localFinderObject.displayId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169022);
        return 0;
      case 14: 
        localFinderObject.likeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 15: 
        localFinderObject.commentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 16: 
        localFinderObject.recommendReason = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 17: 
        localFinderObject.readCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 18: 
        localFinderObject.deletetime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 19: 
        localFinderObject.commentClose = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 20: 
        localFinderObject.refObjectFlag = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169022);
        return 0;
      case 21: 
        localFinderObject.refObjectId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169022);
        return 0;
      case 22: 
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
          localFinderObject.refObjectContact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 23: 
        localFinderObject.recommendType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 24: 
        localFinderObject.friendLikeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 25: 
        localFinderObject.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 26: 
        localFinderObject.refObjectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 27: 
        localFinderObject.objectStatus = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 28: 
        localFinderObject.sendShareFavWording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 29: 
        localFinderObject.originalFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 30: 
        localFinderObject.secondaryShowFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 31: 
        localFinderObject.tipsWording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 32: 
        localFinderObject.orgRecommendType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 33: 
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
          localFinderObject.mentionedUserContact.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 34: 
        localFinderObject.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 35: 
        localFinderObject.warnFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 36: 
        localFinderObject.warnWording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 37: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bip();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bip)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.liveInfo = ((bip)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 38: 
        localFinderObject.favCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 39: 
        localFinderObject.favFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 40: 
        localFinderObject.foldedFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 41: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new axn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((axn)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.foldedLayout = ((axn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 42: 
        localFinderObject.recommendReasonType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 43: 
        localFinderObject.urlValidDuration = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 44: 
        localFinderObject.forward_style = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 45: 
        localFinderObject.posTriggerConfig = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 46: 
        localFinderObject.privateFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 47: 
        localFinderObject.msgEventFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 48: 
        localFinderObject.msgId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 49: 
        localFinderObject.incFriendLikeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 50: 
        localFinderObject.debugMessage = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 51: 
        localFinderObject.likeBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(169022);
        return 0;
      case 52: 
        localFinderObject.permissionFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 54: 
        localFinderObject.stickyTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 55: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brn)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.hotTopics = ((brn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 56: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new atr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((atr)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.attachmentList = ((atr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 57: 
        localFinderObject.objectType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 58: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bvv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bvv)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.snsShareInfo = ((bvv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 60: 
        localFinderObject.follow_feed_count = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 61: 
        localFinderObject.event_status_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 62: 
        localFinderObject.is_poi_same_city = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 63: 
        localFinderObject.mentionedListSelected = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 64: 
        localFinderObject.verify_info_buf = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 65: 
        localFinderObject.wx_status_ref_count = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 66: 
        localFinderObject.wxStatusPermissionFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 67: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqx)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.adInfo = ((bqx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 68: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bro();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bro)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.hotWordInfo = ((bro)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 70: 
        localFinderObject.adFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 71: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bxp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bxp)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.tips_info = ((bxp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 72: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brb)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.client_local_buffer = ((brb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 73: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btj)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObject.publisher_info = ((btj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 74: 
        localFinderObject.live_related_last_buffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(169022);
        return 0;
      case 75: 
        localFinderObject.followCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 76: 
        localFinderObject.cookie = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(169022);
        return 0;
      case 77: 
        localFinderObject.preview_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 78: 
        localFinderObject.internal_feedback_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 79: 
        localFinderObject.wxa_game_export_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 80: 
        localFinderObject.ringtone_count = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 81: 
        localFinderObject.wx_status_icon_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 82: 
        localFinderObject.friend_fav_count = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      case 83: 
        localFinderObject.func_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169022);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new brp();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((brp)localObject2).parseFrom((byte[])localObject1);
        }
        localFinderObject.place_holder_info = ((brp)localObject2);
        paramInt += 1;
      }
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