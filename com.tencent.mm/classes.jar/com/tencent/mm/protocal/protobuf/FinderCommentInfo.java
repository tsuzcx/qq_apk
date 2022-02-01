package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class FinderCommentInfo
  extends com.tencent.mm.cd.a
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
  public arg msgInfo;
  public String nickname;
  public int replyBlacklistFlag;
  public long replyCommentId;
  public String replyNickname;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      paramVarArgs.bm(4, this.commentId);
      paramVarArgs.bm(5, this.replyCommentId);
      paramVarArgs.aY(6, this.deleteFlag);
      if (this.headUrl != null) {
        paramVarArgs.f(7, this.headUrl);
      }
      paramVarArgs.e(8, 8, this.levelTwoComment);
      paramVarArgs.bm(9, this.createtime);
      if (this.replyNickname != null) {
        paramVarArgs.f(10, this.replyNickname);
      }
      if (this.displayidDiscarded != null) {
        paramVarArgs.f(11, this.displayidDiscarded);
      }
      paramVarArgs.aY(12, this.likeFlag);
      paramVarArgs.aY(13, this.likeCount);
      paramVarArgs.bm(14, this.displayid);
      paramVarArgs.aY(15, this.expandCommentCount);
      if (this.lastBuffer != null) {
        paramVarArgs.c(16, this.lastBuffer);
      }
      paramVarArgs.aY(17, this.continueFlag);
      paramVarArgs.aY(18, this.displayFlag);
      paramVarArgs.aY(19, this.blacklist_flag);
      if (this.reply_content != null) {
        paramVarArgs.f(20, this.reply_content);
      }
      if (this.reply_username != null) {
        paramVarArgs.f(21, this.reply_username);
      }
      if (this.client_id != null) {
        paramVarArgs.f(22, this.client_id);
      }
      paramVarArgs.aY(23, this.upContinueFlag);
      paramVarArgs.aY(24, this.replyBlacklistFlag);
      paramVarArgs.aY(25, this.extFlag);
      paramVarArgs.aY(26, this.unreadFlag);
      if (this.msgInfo != null)
      {
        paramVarArgs.oE(27, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168941);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1690;
      }
    }
    label1690:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.content);
      }
      i = i + g.a.a.b.b.a.p(4, this.commentId) + g.a.a.b.b.a.p(5, this.replyCommentId) + g.a.a.b.b.a.bM(6, this.deleteFlag);
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.headUrl);
      }
      i = paramInt + g.a.a.a.c(8, 8, this.levelTwoComment) + g.a.a.b.b.a.p(9, this.createtime);
      paramInt = i;
      if (this.replyNickname != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.replyNickname);
      }
      i = paramInt;
      if (this.displayidDiscarded != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.displayidDiscarded);
      }
      i = i + g.a.a.b.b.a.bM(12, this.likeFlag) + g.a.a.b.b.a.bM(13, this.likeCount) + g.a.a.b.b.a.p(14, this.displayid) + g.a.a.b.b.a.bM(15, this.expandCommentCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.continueFlag) + g.a.a.b.b.a.bM(18, this.displayFlag) + g.a.a.b.b.a.bM(19, this.blacklist_flag);
      paramInt = i;
      if (this.reply_content != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.reply_content);
      }
      i = paramInt;
      if (this.reply_username != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.reply_username);
      }
      paramInt = i;
      if (this.client_id != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.client_id);
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.upContinueFlag) + g.a.a.b.b.a.bM(24, this.replyBlacklistFlag) + g.a.a.b.b.a.bM(25, this.extFlag) + g.a.a.b.b.a.bM(26, this.unreadFlag);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + g.a.a.a.oD(27, this.msgInfo.computeSize());
      }
      AppMethodBeat.o(168941);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.levelTwoComment.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168941);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168941);
          return -1;
        case 1: 
          localFinderCommentInfo.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 2: 
          localFinderCommentInfo.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 3: 
          localFinderCommentInfo.content = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 4: 
          localFinderCommentInfo.commentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168941);
          return 0;
        case 5: 
          localFinderCommentInfo.replyCommentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168941);
          return 0;
        case 6: 
          localFinderCommentInfo.deleteFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 7: 
          localFinderCommentInfo.headUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
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
            localFinderCommentInfo.levelTwoComment.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168941);
          return 0;
        case 9: 
          localFinderCommentInfo.createtime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168941);
          return 0;
        case 10: 
          localFinderCommentInfo.replyNickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 11: 
          localFinderCommentInfo.displayidDiscarded = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 12: 
          localFinderCommentInfo.likeFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 13: 
          localFinderCommentInfo.likeCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 14: 
          localFinderCommentInfo.displayid = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168941);
          return 0;
        case 15: 
          localFinderCommentInfo.expandCommentCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 16: 
          localFinderCommentInfo.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168941);
          return 0;
        case 17: 
          localFinderCommentInfo.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 18: 
          localFinderCommentInfo.displayFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 19: 
          localFinderCommentInfo.blacklist_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 20: 
          localFinderCommentInfo.reply_content = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 21: 
          localFinderCommentInfo.reply_username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 22: 
          localFinderCommentInfo.client_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168941);
          return 0;
        case 23: 
          localFinderCommentInfo.upContinueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 24: 
          localFinderCommentInfo.replyBlacklistFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 25: 
          localFinderCommentInfo.extFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        case 26: 
          localFinderCommentInfo.unreadFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168941);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new arg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((arg)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderCommentInfo.msgInfo = ((arg)localObject2);
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