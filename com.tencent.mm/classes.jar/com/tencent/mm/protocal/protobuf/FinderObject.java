package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderObject
  extends com.tencent.mm.bw.a
{
  public int commentClose;
  public int commentCount;
  public LinkedList<FinderCommentInfo> commentList;
  public FinderContact contact;
  public int createtime;
  public int deletetime;
  public long displayId;
  public String displayidDiscarded;
  public int favCount;
  public int favFlag;
  public int foldedFlag;
  public ajz foldedLayout;
  public int forwardCount;
  public int forward_style;
  public int friendLikeCount;
  public long id;
  public int likeCount;
  public int likeFlag;
  public LinkedList<FinderCommentInfo> likeList;
  public als liveInfo;
  public LinkedList<FinderContact> mentionedUserContact;
  public String nickname;
  public FinderObjectDesc objectDesc;
  public String objectNonceId;
  public int objectStatus;
  public int orgRecommendType;
  public int originalFlag;
  public String posTriggerConfig;
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
      paramVarArgs.aO(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.ln(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.createtime);
      paramVarArgs.aR(6, this.likeFlag);
      paramVarArgs.e(7, 8, this.likeList);
      paramVarArgs.e(8, 8, this.commentList);
      paramVarArgs.aR(9, this.forwardCount);
      if (this.contact != null)
      {
        paramVarArgs.ln(10, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.d(11, this.displayidDiscarded);
      }
      paramVarArgs.e(12, 1, this.recommenderList);
      paramVarArgs.aO(13, this.displayId);
      paramVarArgs.aR(14, this.likeCount);
      paramVarArgs.aR(15, this.commentCount);
      if (this.recommendReason != null) {
        paramVarArgs.d(16, this.recommendReason);
      }
      paramVarArgs.aR(17, this.readCount);
      paramVarArgs.aR(18, this.deletetime);
      paramVarArgs.aR(19, this.commentClose);
      paramVarArgs.aO(20, this.refObjectFlag);
      paramVarArgs.aO(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.ln(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(23, this.recommendType);
      paramVarArgs.aR(24, this.friendLikeCount);
      if (this.objectNonceId != null) {
        paramVarArgs.d(25, this.objectNonceId);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(26, this.refObjectNonceId);
      }
      paramVarArgs.aR(27, this.objectStatus);
      if (this.sendShareFavWording != null) {
        paramVarArgs.d(28, this.sendShareFavWording);
      }
      paramVarArgs.aR(29, this.originalFlag);
      paramVarArgs.aR(30, this.secondaryShowFlag);
      if (this.tipsWording != null) {
        paramVarArgs.d(31, this.tipsWording);
      }
      paramVarArgs.aR(32, this.orgRecommendType);
      paramVarArgs.e(33, 8, this.mentionedUserContact);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(34, this.sessionBuffer);
      }
      paramVarArgs.aR(35, this.warnFlag);
      if (this.warnWording != null) {
        paramVarArgs.d(36, this.warnWording);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.ln(37, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(38, this.favCount);
      paramVarArgs.aR(39, this.favFlag);
      paramVarArgs.aR(40, this.foldedFlag);
      if (this.foldedLayout != null)
      {
        paramVarArgs.ln(41, this.foldedLayout.computeSize());
        this.foldedLayout.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(42, this.recommendReasonType);
      paramVarArgs.aR(43, this.urlValidDuration);
      paramVarArgs.aR(44, this.forward_style);
      if (this.posTriggerConfig != null) {
        paramVarArgs.d(45, this.posTriggerConfig);
      }
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
        paramInt = i + f.a.a.a.lm(4, this.objectDesc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.createtime) + f.a.a.b.b.a.bx(6, this.likeFlag) + f.a.a.a.c(7, 8, this.likeList) + f.a.a.a.c(8, 8, this.commentList) + f.a.a.b.b.a.bx(9, this.forwardCount);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + f.a.a.a.lm(10, this.contact.computeSize());
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.displayidDiscarded);
      }
      i = i + f.a.a.a.c(12, 1, this.recommenderList) + f.a.a.b.b.a.p(13, this.displayId) + f.a.a.b.b.a.bx(14, this.likeCount) + f.a.a.b.b.a.bx(15, this.commentCount);
      paramInt = i;
      if (this.recommendReason != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.recommendReason);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.readCount) + f.a.a.b.b.a.bx(18, this.deletetime) + f.a.a.b.b.a.bx(19, this.commentClose) + f.a.a.b.b.a.p(20, this.refObjectFlag) + f.a.a.b.b.a.p(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + f.a.a.a.lm(22, this.refObjectContact.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(23, this.recommendType) + f.a.a.b.b.a.bx(24, this.friendLikeCount);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.objectNonceId);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.refObjectNonceId);
      }
      i += f.a.a.b.b.a.bx(27, this.objectStatus);
      paramInt = i;
      if (this.sendShareFavWording != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.sendShareFavWording);
      }
      i = paramInt + f.a.a.b.b.a.bx(29, this.originalFlag) + f.a.a.b.b.a.bx(30, this.secondaryShowFlag);
      paramInt = i;
      if (this.tipsWording != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.tipsWording);
      }
      i = paramInt + f.a.a.b.b.a.bx(32, this.orgRecommendType) + f.a.a.a.c(33, 8, this.mentionedUserContact);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.sessionBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bx(35, this.warnFlag);
      paramInt = i;
      if (this.warnWording != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.warnWording);
      }
      i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + f.a.a.a.lm(37, this.liveInfo.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(38, this.favCount) + f.a.a.b.b.a.bx(39, this.favFlag) + f.a.a.b.b.a.bx(40, this.foldedFlag);
      paramInt = i;
      if (this.foldedLayout != null) {
        paramInt = i + f.a.a.a.lm(41, this.foldedLayout.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(42, this.recommendReasonType) + f.a.a.b.b.a.bx(43, this.urlValidDuration) + f.a.a.b.b.a.bx(44, this.forward_style);
      paramInt = i;
      if (this.posTriggerConfig != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.posTriggerConfig);
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
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
      default: 
        AppMethodBeat.o(169022);
        return -1;
      case 1: 
        localFinderObject.id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169022);
        return 0;
      case 2: 
        localFinderObject.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 3: 
        localFinderObject.username = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        localFinderObject.createtime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 6: 
        localFinderObject.likeFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        localFinderObject.forwardCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        localFinderObject.displayidDiscarded = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 12: 
        localFinderObject.recommenderList.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(169022);
        return 0;
      case 13: 
        localFinderObject.displayId = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169022);
        return 0;
      case 14: 
        localFinderObject.likeCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 15: 
        localFinderObject.commentCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 16: 
        localFinderObject.recommendReason = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 17: 
        localFinderObject.readCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 18: 
        localFinderObject.deletetime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 19: 
        localFinderObject.commentClose = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 20: 
        localFinderObject.refObjectFlag = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169022);
        return 0;
      case 21: 
        localFinderObject.refObjectId = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169022);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        localFinderObject.recommendType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 24: 
        localFinderObject.friendLikeCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 25: 
        localFinderObject.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 26: 
        localFinderObject.refObjectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 27: 
        localFinderObject.objectStatus = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 28: 
        localFinderObject.sendShareFavWording = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 29: 
        localFinderObject.originalFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 30: 
        localFinderObject.secondaryShowFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 31: 
        localFinderObject.tipsWording = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 32: 
        localFinderObject.orgRecommendType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
        localFinderObject.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 35: 
        localFinderObject.warnFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 36: 
        localFinderObject.warnWording = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169022);
        return 0;
      case 37: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new als();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((als)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.liveInfo = ((als)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 38: 
        localFinderObject.favCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 39: 
        localFinderObject.favFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 40: 
        localFinderObject.foldedFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 41: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ajz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObject.foldedLayout = ((ajz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169022);
        return 0;
      case 42: 
        localFinderObject.recommendReasonType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 43: 
        localFinderObject.urlValidDuration = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      case 44: 
        localFinderObject.forward_style = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169022);
        return 0;
      }
      localFinderObject.posTriggerConfig = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(169022);
      return 0;
    }
    AppMethodBeat.o(169022);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderObject
 * JD-Core Version:    0.7.0.1
 */