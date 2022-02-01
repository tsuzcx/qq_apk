package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class FinderCommentInfo
  extends com.tencent.mm.bx.a
{
  public FinderContact author_contact;
  public int blacklist_flag;
  public String client_id;
  public long commentId;
  public String content;
  public int continueFlag;
  public long createtime;
  public int deleteFlag;
  public int displayFlag;
  public long displayid;
  public String displayidDiscarded;
  public int expandCommentCount;
  public int extFlag;
  public String headUrl;
  public b lastBuffer;
  public LinkedList<FinderCommentInfo> levelTwoComment;
  public int likeCount;
  public int likeFlag;
  public avo msgInfo;
  public String nickname;
  public int replyBlacklistFlag;
  public long replyCommentId;
  public String replyNickname;
  public FinderContact reply_contact;
  public String reply_content;
  public String reply_username;
  public int unreadFlag;
  public int upContinueFlag;
  public String username;
  
  public FinderCommentInfo()
  {
    AppMethodBeat.i(168940);
    this.levelTwoComment = new LinkedList();
    AppMethodBeat.o(168940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      paramVarArgs.bv(4, this.commentId);
      paramVarArgs.bv(5, this.replyCommentId);
      paramVarArgs.bS(6, this.deleteFlag);
      if (this.headUrl != null) {
        paramVarArgs.g(7, this.headUrl);
      }
      paramVarArgs.e(8, 8, this.levelTwoComment);
      paramVarArgs.bv(9, this.createtime);
      if (this.replyNickname != null) {
        paramVarArgs.g(10, this.replyNickname);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.g(11, this.displayidDiscarded);
      }
      paramVarArgs.bS(12, this.likeFlag);
      paramVarArgs.bS(13, this.likeCount);
      paramVarArgs.bv(14, this.displayid);
      paramVarArgs.bS(15, this.expandCommentCount);
      if (this.lastBuffer != null) {
        paramVarArgs.d(16, this.lastBuffer);
      }
      paramVarArgs.bS(17, this.continueFlag);
      paramVarArgs.bS(18, this.displayFlag);
      paramVarArgs.bS(19, this.blacklist_flag);
      if (this.reply_content != null) {
        paramVarArgs.g(20, this.reply_content);
      }
      if (this.reply_username != null) {
        paramVarArgs.g(21, this.reply_username);
      }
      if (this.client_id != null) {
        paramVarArgs.g(22, this.client_id);
      }
      paramVarArgs.bS(23, this.upContinueFlag);
      paramVarArgs.bS(24, this.replyBlacklistFlag);
      paramVarArgs.bS(25, this.extFlag);
      paramVarArgs.bS(26, this.unreadFlag);
      if (this.msgInfo != null)
      {
        paramVarArgs.qD(27, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      if (this.author_contact != null)
      {
        paramVarArgs.qD(28, this.author_contact.computeSize());
        this.author_contact.writeFields(paramVarArgs);
      }
      if (this.reply_contact != null)
      {
        paramVarArgs.qD(29, this.reply_contact.computeSize());
        this.reply_contact.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168941);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1954;
      }
    }
    label1954:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.content);
      }
      i = i + i.a.a.b.b.a.q(4, this.commentId) + i.a.a.b.b.a.q(5, this.replyCommentId) + i.a.a.b.b.a.cJ(6, this.deleteFlag);
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.headUrl);
      }
      i = paramInt + i.a.a.a.c(8, 8, this.levelTwoComment) + i.a.a.b.b.a.q(9, this.createtime);
      paramInt = i;
      if (this.replyNickname != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.replyNickname);
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.displayidDiscarded);
      }
      i = i + i.a.a.b.b.a.cJ(12, this.likeFlag) + i.a.a.b.b.a.cJ(13, this.likeCount) + i.a.a.b.b.a.q(14, this.displayid) + i.a.a.b.b.a.cJ(15, this.expandCommentCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.continueFlag) + i.a.a.b.b.a.cJ(18, this.displayFlag) + i.a.a.b.b.a.cJ(19, this.blacklist_flag);
      paramInt = i;
      if (this.reply_content != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.reply_content);
      }
      i = paramInt;
      if (this.reply_username != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.reply_username);
      }
      paramInt = i;
      if (this.client_id != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.client_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.upContinueFlag) + i.a.a.b.b.a.cJ(24, this.replyBlacklistFlag) + i.a.a.b.b.a.cJ(25, this.extFlag) + i.a.a.b.b.a.cJ(26, this.unreadFlag);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + i.a.a.a.qC(27, this.msgInfo.computeSize());
      }
      i = paramInt;
      if (this.author_contact != null) {
        i = paramInt + i.a.a.a.qC(28, this.author_contact.computeSize());
      }
      paramInt = i;
      if (this.reply_contact != null) {
        paramInt = i + i.a.a.a.qC(29, this.reply_contact.computeSize());
      }
      AppMethodBeat.o(168941);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.levelTwoComment.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168941);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168941);
          return -1;
        case 1: 
          localFinderCommentInfo.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 2: 
          localFinderCommentInfo.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 3: 
          localFinderCommentInfo.content = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 4: 
          localFinderCommentInfo.commentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168941);
          return 0;
        case 5: 
          localFinderCommentInfo.replyCommentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168941);
          return 0;
        case 6: 
          localFinderCommentInfo.deleteFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 7: 
          localFinderCommentInfo.headUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
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
            localFinderCommentInfo.levelTwoComment.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168941);
          return 0;
        case 9: 
          localFinderCommentInfo.createtime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168941);
          return 0;
        case 10: 
          localFinderCommentInfo.replyNickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 11: 
          localFinderCommentInfo.displayidDiscarded = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 12: 
          localFinderCommentInfo.likeFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 13: 
          localFinderCommentInfo.likeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 14: 
          localFinderCommentInfo.displayid = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168941);
          return 0;
        case 15: 
          localFinderCommentInfo.expandCommentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 16: 
          localFinderCommentInfo.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168941);
          return 0;
        case 17: 
          localFinderCommentInfo.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 18: 
          localFinderCommentInfo.displayFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 19: 
          localFinderCommentInfo.blacklist_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 20: 
          localFinderCommentInfo.reply_content = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 21: 
          localFinderCommentInfo.reply_username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 22: 
          localFinderCommentInfo.client_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 23: 
          localFinderCommentInfo.upContinueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 24: 
          localFinderCommentInfo.replyBlacklistFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 25: 
          localFinderCommentInfo.extFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 26: 
          localFinderCommentInfo.unreadFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168941);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avo)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderCommentInfo.msgInfo = ((avo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168941);
          return 0;
        case 28: 
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
            localFinderCommentInfo.author_contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168941);
          return 0;
        }
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
          localFinderCommentInfo.reply_contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168941);
        return 0;
      }
      AppMethodBeat.o(168941);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderCommentInfo
 * JD-Core Version:    0.7.0.1
 */