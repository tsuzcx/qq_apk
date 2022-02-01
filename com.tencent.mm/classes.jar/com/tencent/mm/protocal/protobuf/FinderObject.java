package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public class FinderObject
  extends com.tencent.mm.bw.a
{
  public aoq attachmentList;
  public int commentClose;
  public int commentCount;
  public LinkedList<FinderCommentInfo> commentList;
  public FinderContact contact;
  public int createtime;
  public String debugMessage;
  public int deletetime;
  public long displayId;
  public String displayidDiscarded;
  public int favCount;
  public int favFlag;
  public int foldedFlag;
  public ard foldedLayout;
  public int follow_feed_count;
  public int forwardCount;
  public int forward_style;
  public int friendLikeCount;
  public azx hotTopics;
  public long id;
  public int incFriendLikeCount;
  public b likeBuffer;
  public int likeCount;
  public int likeFlag;
  public LinkedList<FinderCommentInfo> likeList;
  public awe liveInfo;
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
  public bcq snsShareInfo;
  public int stickyTime;
  public String tipsWording;
  public int urlValidDuration;
  public String username;
  public int warnFlag;
  public String warnWording;
  
  public FinderObject()
  {
    AppMethodBeat.i(169021);
    this.likeList = new LinkedList();
    this.commentList = new LinkedList();
    this.recommenderList = new LinkedList();
    this.mentionedUserContact = new LinkedList();
    AppMethodBeat.o(169021);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169022);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.e(3, this.username);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.ni(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.createtime);
      paramVarArgs.aM(6, this.likeFlag);
      paramVarArgs.e(7, 8, this.likeList);
      paramVarArgs.e(8, 8, this.commentList);
      paramVarArgs.aM(9, this.forwardCount);
      if (this.contact != null)
      {
        paramVarArgs.ni(10, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.e(11, this.displayidDiscarded);
      }
      paramVarArgs.e(12, 1, this.recommenderList);
      paramVarArgs.bb(13, this.displayId);
      paramVarArgs.aM(14, this.likeCount);
      paramVarArgs.aM(15, this.commentCount);
      if (this.recommendReason != null) {
        paramVarArgs.e(16, this.recommendReason);
      }
      paramVarArgs.aM(17, this.readCount);
      paramVarArgs.aM(18, this.deletetime);
      paramVarArgs.aM(19, this.commentClose);
      paramVarArgs.bb(20, this.refObjectFlag);
      paramVarArgs.bb(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.ni(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(23, this.recommendType);
      paramVarArgs.aM(24, this.friendLikeCount);
      if (this.objectNonceId != null) {
        paramVarArgs.e(25, this.objectNonceId);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(26, this.refObjectNonceId);
      }
      paramVarArgs.aM(27, this.objectStatus);
      if (this.sendShareFavWording != null) {
        paramVarArgs.e(28, this.sendShareFavWording);
      }
      paramVarArgs.aM(29, this.originalFlag);
      paramVarArgs.aM(30, this.secondaryShowFlag);
      if (this.tipsWording != null) {
        paramVarArgs.e(31, this.tipsWording);
      }
      paramVarArgs.aM(32, this.orgRecommendType);
      paramVarArgs.e(33, 8, this.mentionedUserContact);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(34, this.sessionBuffer);
      }
      paramVarArgs.aM(35, this.warnFlag);
      if (this.warnWording != null) {
        paramVarArgs.e(36, this.warnWording);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.ni(37, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(38, this.favCount);
      paramVarArgs.aM(39, this.favFlag);
      paramVarArgs.aM(40, this.foldedFlag);
      if (this.foldedLayout != null)
      {
        paramVarArgs.ni(41, this.foldedLayout.computeSize());
        this.foldedLayout.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(42, this.recommendReasonType);
      paramVarArgs.aM(43, this.urlValidDuration);
      paramVarArgs.aM(44, this.forward_style);
      if (this.posTriggerConfig != null) {
        paramVarArgs.e(45, this.posTriggerConfig);
      }
      paramVarArgs.aM(46, this.privateFlag);
      paramVarArgs.aM(47, this.msgEventFlag);
      if (this.msgId != null) {
        paramVarArgs.e(48, this.msgId);
      }
      paramVarArgs.aM(49, this.incFriendLikeCount);
      if (this.debugMessage != null) {
        paramVarArgs.e(50, this.debugMessage);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.c(51, this.likeBuffer);
      }
      paramVarArgs.aM(52, this.permissionFlag);
      paramVarArgs.aM(54, this.stickyTime);
      if (this.hotTopics != null)
      {
        paramVarArgs.ni(55, this.hotTopics.computeSize());
        this.hotTopics.writeFields(paramVarArgs);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.ni(56, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(57, this.objectType);
      if (this.snsShareInfo != null)
      {
        paramVarArgs.ni(58, this.snsShareInfo.computeSize());
        this.snsShareInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(60, this.follow_feed_count);
      AppMethodBeat.o(169022);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.username);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + g.a.a.a.nh(4, this.objectDesc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.createtime) + g.a.a.b.b.a.bu(6, this.likeFlag) + g.a.a.a.c(7, 8, this.likeList) + g.a.a.a.c(8, 8, this.commentList) + g.a.a.b.b.a.bu(9, this.forwardCount);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.nh(10, this.contact.computeSize());
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.displayidDiscarded);
      }
      i = i + g.a.a.a.c(12, 1, this.recommenderList) + g.a.a.b.b.a.r(13, this.displayId) + g.a.a.b.b.a.bu(14, this.likeCount) + g.a.a.b.b.a.bu(15, this.commentCount);
      paramInt = i;
      if (this.recommendReason != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.recommendReason);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.readCount) + g.a.a.b.b.a.bu(18, this.deletetime) + g.a.a.b.b.a.bu(19, this.commentClose) + g.a.a.b.b.a.r(20, this.refObjectFlag) + g.a.a.b.b.a.r(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + g.a.a.a.nh(22, this.refObjectContact.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.recommendType) + g.a.a.b.b.a.bu(24, this.friendLikeCount);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.objectNonceId);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(26, this.refObjectNonceId);
      }
      i += g.a.a.b.b.a.bu(27, this.objectStatus);
      paramInt = i;
      if (this.sendShareFavWording != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.sendShareFavWording);
      }
      i = paramInt + g.a.a.b.b.a.bu(29, this.originalFlag) + g.a.a.b.b.a.bu(30, this.secondaryShowFlag);
      paramInt = i;
      if (this.tipsWording != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.tipsWording);
      }
      i = paramInt + g.a.a.b.b.a.bu(32, this.orgRecommendType) + g.a.a.a.c(33, 8, this.mentionedUserContact);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(34, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(35, this.warnFlag);
      paramInt = i;
      if (this.warnWording != null) {
        paramInt = i + g.a.a.b.b.a.f(36, this.warnWording);
      }
      i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + g.a.a.a.nh(37, this.liveInfo.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(38, this.favCount) + g.a.a.b.b.a.bu(39, this.favFlag) + g.a.a.b.b.a.bu(40, this.foldedFlag);
      paramInt = i;
      if (this.foldedLayout != null) {
        paramInt = i + g.a.a.a.nh(41, this.foldedLayout.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(42, this.recommendReasonType) + g.a.a.b.b.a.bu(43, this.urlValidDuration) + g.a.a.b.b.a.bu(44, this.forward_style);
      paramInt = i;
      if (this.posTriggerConfig != null) {
        paramInt = i + g.a.a.b.b.a.f(45, this.posTriggerConfig);
      }
      i = paramInt + g.a.a.b.b.a.bu(46, this.privateFlag) + g.a.a.b.b.a.bu(47, this.msgEventFlag);
      paramInt = i;
      if (this.msgId != null) {
        paramInt = i + g.a.a.b.b.a.f(48, this.msgId);
      }
      i = paramInt + g.a.a.b.b.a.bu(49, this.incFriendLikeCount);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + g.a.a.b.b.a.f(50, this.debugMessage);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(51, this.likeBuffer);
      }
      i = i + g.a.a.b.b.a.bu(52, this.permissionFlag) + g.a.a.b.b.a.bu(54, this.stickyTime);
      paramInt = i;
      if (this.hotTopics != null) {
        paramInt = i + g.a.a.a.nh(55, this.hotTopics.computeSize());
      }
      i = paramInt;
      if (this.attachmentList != null) {
        i = paramInt + g.a.a.a.nh(56, this.attachmentList.computeSize());
      }
      i += g.a.a.b.b.a.bu(57, this.objectType);
      paramInt = i;
      if (this.snsShareInfo != null) {
        paramInt = i + g.a.a.a.nh(58, this.snsShareInfo.computeSize());
      }
      i = g.a.a.b.b.a.bu(60, this.follow_feed_count);
      AppMethodBeat.o(169022);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.likeList.clear();
      this.commentList.clear();
      this.recommenderList.clear();
      this.mentionedUserContact.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
      boolean bool;
      switch (paramInt)
      {
      case 53: 
      case 59: 
      default: 
        AppMethodBeat.o(169022);
        return -1;
      case 1: 
        localFinderObject.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169022);
        return 0;
      case 2: 
        localFinderObject.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 3: 
        localFinderObject.username = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObjectDesc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.objectDesc = ((FinderObjectDesc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 5: 
        localFinderObject.createtime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 6: 
        localFinderObject.likeFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.likeList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.commentList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 9: 
        localFinderObject.forwardCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.contact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 11: 
        localFinderObject.displayidDiscarded = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 12: 
        localFinderObject.recommenderList.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(169022);
        return 0;
      case 13: 
        localFinderObject.displayId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169022);
        return 0;
      case 14: 
        localFinderObject.likeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 15: 
        localFinderObject.commentCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 16: 
        localFinderObject.recommendReason = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 17: 
        localFinderObject.readCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 18: 
        localFinderObject.deletetime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 19: 
        localFinderObject.commentClose = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 20: 
        localFinderObject.refObjectFlag = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169022);
        return 0;
      case 21: 
        localFinderObject.refObjectId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169022);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.refObjectContact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 23: 
        localFinderObject.recommendType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 24: 
        localFinderObject.friendLikeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 25: 
        localFinderObject.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 26: 
        localFinderObject.refObjectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 27: 
        localFinderObject.objectStatus = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 28: 
        localFinderObject.sendShareFavWording = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 29: 
        localFinderObject.originalFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 30: 
        localFinderObject.secondaryShowFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 31: 
        localFinderObject.tipsWording = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 32: 
        localFinderObject.orgRecommendType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 33: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.mentionedUserContact.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 34: 
        localFinderObject.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 35: 
        localFinderObject.warnFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 36: 
        localFinderObject.warnWording = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 37: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.liveInfo = ((awe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 38: 
        localFinderObject.favCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 39: 
        localFinderObject.favFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 40: 
        localFinderObject.foldedFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 41: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ard();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ard)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.foldedLayout = ((ard)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 42: 
        localFinderObject.recommendReasonType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 43: 
        localFinderObject.urlValidDuration = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 44: 
        localFinderObject.forward_style = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 45: 
        localFinderObject.posTriggerConfig = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 46: 
        localFinderObject.privateFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 47: 
        localFinderObject.msgEventFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 48: 
        localFinderObject.msgId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 49: 
        localFinderObject.incFriendLikeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 50: 
        localFinderObject.debugMessage = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 51: 
        localFinderObject.likeBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(169022);
        return 0;
      case 52: 
        localFinderObject.permissionFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 54: 
        localFinderObject.stickyTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 55: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.hotTopics = ((azx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 56: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.attachmentList = ((aoq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 57: 
        localFinderObject.objectType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169022);
        return 0;
      case 58: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderObject.snsShareInfo = ((bcq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      }
      localFinderObject.follow_feed_count = ((g.a.a.a.a)localObject1).UbS.zi();
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