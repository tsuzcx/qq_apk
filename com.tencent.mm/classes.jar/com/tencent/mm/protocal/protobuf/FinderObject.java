package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public class FinderObject
  extends com.tencent.mm.bw.a
{
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
  public ank foldedLayout;
  public int forwardCount;
  public int forward_style;
  public int friendLikeCount;
  public long id;
  public int incFriendLikeCount;
  public b likeBuffer;
  public int likeCount;
  public int likeFlag;
  public LinkedList<FinderCommentInfo> likeList;
  public apk liveInfo;
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.lJ(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.createtime);
      paramVarArgs.aS(6, this.likeFlag);
      paramVarArgs.e(7, 8, this.likeList);
      paramVarArgs.e(8, 8, this.commentList);
      paramVarArgs.aS(9, this.forwardCount);
      if (this.contact != null)
      {
        paramVarArgs.lJ(10, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.d(11, this.displayidDiscarded);
      }
      paramVarArgs.e(12, 1, this.recommenderList);
      paramVarArgs.aZ(13, this.displayId);
      paramVarArgs.aS(14, this.likeCount);
      paramVarArgs.aS(15, this.commentCount);
      if (this.recommendReason != null) {
        paramVarArgs.d(16, this.recommendReason);
      }
      paramVarArgs.aS(17, this.readCount);
      paramVarArgs.aS(18, this.deletetime);
      paramVarArgs.aS(19, this.commentClose);
      paramVarArgs.aZ(20, this.refObjectFlag);
      paramVarArgs.aZ(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.lJ(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.recommendType);
      paramVarArgs.aS(24, this.friendLikeCount);
      if (this.objectNonceId != null) {
        paramVarArgs.d(25, this.objectNonceId);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(26, this.refObjectNonceId);
      }
      paramVarArgs.aS(27, this.objectStatus);
      if (this.sendShareFavWording != null) {
        paramVarArgs.d(28, this.sendShareFavWording);
      }
      paramVarArgs.aS(29, this.originalFlag);
      paramVarArgs.aS(30, this.secondaryShowFlag);
      if (this.tipsWording != null) {
        paramVarArgs.d(31, this.tipsWording);
      }
      paramVarArgs.aS(32, this.orgRecommendType);
      paramVarArgs.e(33, 8, this.mentionedUserContact);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(34, this.sessionBuffer);
      }
      paramVarArgs.aS(35, this.warnFlag);
      if (this.warnWording != null) {
        paramVarArgs.d(36, this.warnWording);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.lJ(37, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(38, this.favCount);
      paramVarArgs.aS(39, this.favFlag);
      paramVarArgs.aS(40, this.foldedFlag);
      if (this.foldedLayout != null)
      {
        paramVarArgs.lJ(41, this.foldedLayout.computeSize());
        this.foldedLayout.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(42, this.recommendReasonType);
      paramVarArgs.aS(43, this.urlValidDuration);
      paramVarArgs.aS(44, this.forward_style);
      if (this.posTriggerConfig != null) {
        paramVarArgs.d(45, this.posTriggerConfig);
      }
      paramVarArgs.aS(46, this.privateFlag);
      paramVarArgs.aS(47, this.msgEventFlag);
      if (this.msgId != null) {
        paramVarArgs.d(48, this.msgId);
      }
      paramVarArgs.aS(49, this.incFriendLikeCount);
      if (this.debugMessage != null) {
        paramVarArgs.d(50, this.debugMessage);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.c(51, this.likeBuffer);
      }
      paramVarArgs.aS(52, this.permissionFlag);
      paramVarArgs.aS(57, this.objectType);
      AppMethodBeat.o(169022);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.username);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + f.a.a.a.lI(4, this.objectDesc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.createtime) + f.a.a.b.b.a.bz(6, this.likeFlag) + f.a.a.a.c(7, 8, this.likeList) + f.a.a.a.c(8, 8, this.commentList) + f.a.a.b.b.a.bz(9, this.forwardCount);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + f.a.a.a.lI(10, this.contact.computeSize());
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.displayidDiscarded);
      }
      i = i + f.a.a.a.c(12, 1, this.recommenderList) + f.a.a.b.b.a.p(13, this.displayId) + f.a.a.b.b.a.bz(14, this.likeCount) + f.a.a.b.b.a.bz(15, this.commentCount);
      paramInt = i;
      if (this.recommendReason != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.recommendReason);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.readCount) + f.a.a.b.b.a.bz(18, this.deletetime) + f.a.a.b.b.a.bz(19, this.commentClose) + f.a.a.b.b.a.p(20, this.refObjectFlag) + f.a.a.b.b.a.p(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + f.a.a.a.lI(22, this.refObjectContact.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(23, this.recommendType) + f.a.a.b.b.a.bz(24, this.friendLikeCount);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.objectNonceId);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.refObjectNonceId);
      }
      i += f.a.a.b.b.a.bz(27, this.objectStatus);
      paramInt = i;
      if (this.sendShareFavWording != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.sendShareFavWording);
      }
      i = paramInt + f.a.a.b.b.a.bz(29, this.originalFlag) + f.a.a.b.b.a.bz(30, this.secondaryShowFlag);
      paramInt = i;
      if (this.tipsWording != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.tipsWording);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.orgRecommendType) + f.a.a.a.c(33, 8, this.mentionedUserContact);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.sessionBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(35, this.warnFlag);
      paramInt = i;
      if (this.warnWording != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.warnWording);
      }
      i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + f.a.a.a.lI(37, this.liveInfo.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(38, this.favCount) + f.a.a.b.b.a.bz(39, this.favFlag) + f.a.a.b.b.a.bz(40, this.foldedFlag);
      paramInt = i;
      if (this.foldedLayout != null) {
        paramInt = i + f.a.a.a.lI(41, this.foldedLayout.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(42, this.recommendReasonType) + f.a.a.b.b.a.bz(43, this.urlValidDuration) + f.a.a.b.b.a.bz(44, this.forward_style);
      paramInt = i;
      if (this.posTriggerConfig != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.posTriggerConfig);
      }
      i = paramInt + f.a.a.b.b.a.bz(46, this.privateFlag) + f.a.a.b.b.a.bz(47, this.msgEventFlag);
      paramInt = i;
      if (this.msgId != null) {
        paramInt = i + f.a.a.b.b.a.e(48, this.msgId);
      }
      i = paramInt + f.a.a.b.b.a.bz(49, this.incFriendLikeCount);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + f.a.a.b.b.a.e(50, this.debugMessage);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(51, this.likeBuffer);
      }
      paramInt = f.a.a.b.b.a.bz(52, this.permissionFlag);
      int j = f.a.a.b.b.a.bz(57, this.objectType);
      AppMethodBeat.o(169022);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.likeList.clear();
      this.commentList.clear();
      this.recommenderList.clear();
      this.mentionedUserContact.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169022);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      FinderObject localFinderObject = (FinderObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      default: 
        AppMethodBeat.o(169022);
        return -1;
      case 1: 
        localFinderObject.id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169022);
        return 0;
      case 2: 
        localFinderObject.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 3: 
        localFinderObject.username = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObjectDesc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.objectDesc = ((FinderObjectDesc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 5: 
        localFinderObject.createtime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 6: 
        localFinderObject.likeFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.likeList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.commentList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 9: 
        localFinderObject.forwardCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.contact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 11: 
        localFinderObject.displayidDiscarded = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 12: 
        localFinderObject.recommenderList.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(169022);
        return 0;
      case 13: 
        localFinderObject.displayId = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169022);
        return 0;
      case 14: 
        localFinderObject.likeCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 15: 
        localFinderObject.commentCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 16: 
        localFinderObject.recommendReason = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 17: 
        localFinderObject.readCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 18: 
        localFinderObject.deletetime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 19: 
        localFinderObject.commentClose = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 20: 
        localFinderObject.refObjectFlag = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169022);
        return 0;
      case 21: 
        localFinderObject.refObjectId = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169022);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.refObjectContact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 23: 
        localFinderObject.recommendType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 24: 
        localFinderObject.friendLikeCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 25: 
        localFinderObject.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 26: 
        localFinderObject.refObjectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 27: 
        localFinderObject.objectStatus = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 28: 
        localFinderObject.sendShareFavWording = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 29: 
        localFinderObject.originalFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 30: 
        localFinderObject.secondaryShowFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 31: 
        localFinderObject.tipsWording = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 32: 
        localFinderObject.orgRecommendType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.mentionedUserContact.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 34: 
        localFinderObject.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 35: 
        localFinderObject.warnFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 36: 
        localFinderObject.warnWording = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 37: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.liveInfo = ((apk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 38: 
        localFinderObject.favCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 39: 
        localFinderObject.favFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 40: 
        localFinderObject.foldedFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 41: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ank();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ank)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.foldedLayout = ((ank)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 42: 
        localFinderObject.recommendReasonType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 43: 
        localFinderObject.urlValidDuration = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 44: 
        localFinderObject.forward_style = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 45: 
        localFinderObject.posTriggerConfig = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 46: 
        localFinderObject.privateFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 47: 
        localFinderObject.msgEventFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 48: 
        localFinderObject.msgId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 49: 
        localFinderObject.incFriendLikeCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      case 50: 
        localFinderObject.debugMessage = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 51: 
        localFinderObject.likeBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(169022);
        return 0;
      case 52: 
        localFinderObject.permissionFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169022);
        return 0;
      }
      localFinderObject.objectType = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(169022);
      return 0;
    }
    AppMethodBeat.o(169022);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderObject
 * JD-Core Version:    0.7.0.1
 */