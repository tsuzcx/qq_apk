package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class FinderCommentInfo
  extends com.tencent.mm.bx.a
{
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
  public String nickname;
  public int replyBlacklistFlag;
  public long replyCommentId;
  public String replyNickname;
  public String reply_content;
  public String reply_username;
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.content != null) {
        paramVarArgs.d(3, this.content);
      }
      paramVarArgs.aG(4, this.commentId);
      paramVarArgs.aG(5, this.replyCommentId);
      paramVarArgs.aR(6, this.deleteFlag);
      if (this.headUrl != null) {
        paramVarArgs.d(7, this.headUrl);
      }
      paramVarArgs.e(8, 8, this.levelTwoComment);
      paramVarArgs.aG(9, this.createtime);
      if (this.replyNickname != null) {
        paramVarArgs.d(10, this.replyNickname);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.d(11, this.displayidDiscarded);
      }
      paramVarArgs.aR(12, this.likeFlag);
      paramVarArgs.aR(13, this.likeCount);
      paramVarArgs.aG(14, this.displayid);
      paramVarArgs.aR(15, this.expandCommentCount);
      if (this.lastBuffer != null) {
        paramVarArgs.c(16, this.lastBuffer);
      }
      paramVarArgs.aR(17, this.continueFlag);
      paramVarArgs.aR(18, this.displayFlag);
      paramVarArgs.aR(19, this.blacklist_flag);
      if (this.reply_content != null) {
        paramVarArgs.d(20, this.reply_content);
      }
      if (this.reply_username != null) {
        paramVarArgs.d(21, this.reply_username);
      }
      if (this.client_id != null) {
        paramVarArgs.d(22, this.client_id);
      }
      paramVarArgs.aR(23, this.upContinueFlag);
      paramVarArgs.aR(24, this.replyBlacklistFlag);
      paramVarArgs.aR(25, this.extFlag);
      AppMethodBeat.o(168941);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1542;
      }
    }
    label1542:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.content);
      }
      i = i + f.a.a.b.b.a.q(4, this.commentId) + f.a.a.b.b.a.q(5, this.replyCommentId) + f.a.a.b.b.a.bA(6, this.deleteFlag);
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.headUrl);
      }
      i = paramInt + f.a.a.a.c(8, 8, this.levelTwoComment) + f.a.a.b.b.a.q(9, this.createtime);
      paramInt = i;
      if (this.replyNickname != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.replyNickname);
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.displayidDiscarded);
      }
      i = i + f.a.a.b.b.a.bA(12, this.likeFlag) + f.a.a.b.b.a.bA(13, this.likeCount) + f.a.a.b.b.a.q(14, this.displayid) + f.a.a.b.b.a.bA(15, this.expandCommentCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.continueFlag) + f.a.a.b.b.a.bA(18, this.displayFlag) + f.a.a.b.b.a.bA(19, this.blacklist_flag);
      paramInt = i;
      if (this.reply_content != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.reply_content);
      }
      i = paramInt;
      if (this.reply_username != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.reply_username);
      }
      paramInt = i;
      if (this.client_id != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.client_id);
      }
      i = f.a.a.b.b.a.bA(23, this.upContinueFlag);
      int j = f.a.a.b.b.a.bA(24, this.replyBlacklistFlag);
      int k = f.a.a.b.b.a.bA(25, this.extFlag);
      AppMethodBeat.o(168941);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.levelTwoComment.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168941);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168941);
          return -1;
        case 1: 
          localFinderCommentInfo.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 2: 
          localFinderCommentInfo.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 3: 
          localFinderCommentInfo.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 4: 
          localFinderCommentInfo.commentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168941);
          return 0;
        case 5: 
          localFinderCommentInfo.replyCommentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168941);
          return 0;
        case 6: 
          localFinderCommentInfo.deleteFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 7: 
          localFinderCommentInfo.headUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderCommentInfo.levelTwoComment.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168941);
          return 0;
        case 9: 
          localFinderCommentInfo.createtime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168941);
          return 0;
        case 10: 
          localFinderCommentInfo.replyNickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 11: 
          localFinderCommentInfo.displayidDiscarded = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 12: 
          localFinderCommentInfo.likeFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 13: 
          localFinderCommentInfo.likeCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 14: 
          localFinderCommentInfo.displayid = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168941);
          return 0;
        case 15: 
          localFinderCommentInfo.expandCommentCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 16: 
          localFinderCommentInfo.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168941);
          return 0;
        case 17: 
          localFinderCommentInfo.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 18: 
          localFinderCommentInfo.displayFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 19: 
          localFinderCommentInfo.blacklist_flag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 20: 
          localFinderCommentInfo.reply_content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 21: 
          localFinderCommentInfo.reply_username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 22: 
          localFinderCommentInfo.client_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 23: 
          localFinderCommentInfo.upContinueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        case 24: 
          localFinderCommentInfo.replyBlacklistFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168941);
          return 0;
        }
        localFinderCommentInfo.extFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168941);
        return 0;
      }
      AppMethodBeat.o(168941);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderCommentInfo
 * JD-Core Version:    0.7.0.1
 */