package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderContact
  extends com.tencent.mm.bw.a
{
  public FinderAuthInfo authInfo;
  public String coverImgUrl;
  public int extFlag;
  public app extInfo;
  public int followFlag;
  public int followTime;
  public int foreign_user_flag;
  public int friend_follow_count;
  public String headUrl;
  public String liveCoverImgUrl;
  public int liveStatus;
  public apr live_info;
  public awt live_notice_info;
  public String loggingout_wording;
  public aps msgInfo;
  public String nickname;
  public int originalEntranceFlag;
  public int originalFlag;
  public bac originalInfo;
  public long seq;
  public String signature;
  public int spamStatus;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168945);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.e(3, this.headUrl);
      }
      paramVarArgs.bb(4, this.seq);
      if (this.signature != null) {
        paramVarArgs.e(5, this.signature);
      }
      paramVarArgs.aM(6, this.followFlag);
      paramVarArgs.aM(7, this.followTime);
      if (this.authInfo != null)
      {
        paramVarArgs.ni(8, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.e(9, this.coverImgUrl);
      }
      paramVarArgs.aM(10, this.spamStatus);
      paramVarArgs.aM(11, this.extFlag);
      if (this.extInfo != null)
      {
        paramVarArgs.ni(12, this.extInfo.computeSize());
        this.extInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.originalFlag);
      if (this.originalInfo != null)
      {
        paramVarArgs.ni(14, this.originalInfo.computeSize());
        this.originalInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.liveStatus);
      if (this.msgInfo != null)
      {
        paramVarArgs.ni(16, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(17, this.originalEntranceFlag);
      if (this.liveCoverImgUrl != null) {
        paramVarArgs.e(18, this.liveCoverImgUrl);
      }
      paramVarArgs.aM(19, this.foreign_user_flag);
      if (this.live_notice_info != null)
      {
        paramVarArgs.ni(20, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      if (this.loggingout_wording != null) {
        paramVarArgs.e(21, this.loggingout_wording);
      }
      if (this.live_info != null)
      {
        paramVarArgs.ni(22, this.live_info.computeSize());
        this.live_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(23, this.friend_follow_count);
      AppMethodBeat.o(168945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1974;
      }
    }
    label1974:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.headUrl);
      }
      i += g.a.a.b.b.a.r(4, this.seq);
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.signature);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.followFlag) + g.a.a.b.b.a.bu(7, this.followTime);
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + g.a.a.a.nh(8, this.authInfo.computeSize());
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.coverImgUrl);
      }
      i = i + g.a.a.b.b.a.bu(10, this.spamStatus) + g.a.a.b.b.a.bu(11, this.extFlag);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.a.nh(12, this.extInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.originalFlag);
      paramInt = i;
      if (this.originalInfo != null) {
        paramInt = i + g.a.a.a.nh(14, this.originalInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.liveStatus);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + g.a.a.a.nh(16, this.msgInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.originalEntranceFlag);
      paramInt = i;
      if (this.liveCoverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.liveCoverImgUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.foreign_user_flag);
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + g.a.a.a.nh(20, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.loggingout_wording != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.loggingout_wording);
      }
      paramInt = i;
      if (this.live_info != null) {
        paramInt = i + g.a.a.a.nh(22, this.live_info.computeSize());
      }
      i = g.a.a.b.b.a.bu(23, this.friend_follow_count);
      AppMethodBeat.o(168945);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168945);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderContact localFinderContact = (FinderContact)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168945);
          return -1;
        case 1: 
          localFinderContact.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 2: 
          localFinderContact.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 3: 
          localFinderContact.headUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 4: 
          localFinderContact.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168945);
          return 0;
        case 5: 
          localFinderContact.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 6: 
          localFinderContact.followFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 7: 
          localFinderContact.followTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 9: 
          localFinderContact.coverImgUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 10: 
          localFinderContact.spamStatus = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 11: 
          localFinderContact.extFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new app();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((app)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.extInfo = ((app)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 13: 
          localFinderContact.originalFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bac();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bac)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.originalInfo = ((bac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 15: 
          localFinderContact.liveStatus = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aps();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aps)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.msgInfo = ((aps)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 17: 
          localFinderContact.originalEntranceFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 18: 
          localFinderContact.liveCoverImgUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 19: 
          localFinderContact.foreign_user_flag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168945);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.live_notice_info = ((awt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 21: 
          localFinderContact.loggingout_wording = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderContact.live_info = ((apr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        }
        localFinderContact.friend_follow_count = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168945);
        return 0;
      }
      AppMethodBeat.o(168945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderContact
 * JD-Core Version:    0.7.0.1
 */