package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.bw.a
{
  public LinkedList<dqi> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<dzo> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int GroupCount;
  public LinkedList<dzw> GroupList;
  public LinkedList<dqi> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<dzo> LikeUserList;
  public int LikeUserListCount;
  public String Nickname;
  public int NoChange;
  public SKBuiltinBuffer_t ObjectDesc;
  public SKBuiltinBuffer_t ObjectOperations;
  public ddw PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public ear SnsRedEnvelops;
  public String Username;
  public dzk WeAppInfo;
  public int WithUserCount;
  public LinkedList<dzo> WithUserList;
  public int WithUserListCount;
  
  public SnsObject()
  {
    AppMethodBeat.i(125791);
    this.LikeUserList = new LinkedList();
    this.CommentUserList = new LinkedList();
    this.WithUserList = new LinkedList();
    this.GroupList = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    AppMethodBeat.o(125791);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125792);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(3, this.Nickname);
      }
      paramVarArgs.aM(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.ni(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.LikeFlag);
      paramVarArgs.aM(7, this.LikeCount);
      paramVarArgs.aM(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.aM(10, this.CommentCount);
      paramVarArgs.aM(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.aM(13, this.WithUserCount);
      paramVarArgs.aM(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.aM(16, this.ExtFlag);
      paramVarArgs.aM(17, this.NoChange);
      paramVarArgs.aM(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.aM(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.e(21, this.ReferUsername);
      }
      paramVarArgs.bb(22, this.ReferId);
      paramVarArgs.aM(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.aM(25, this.DeleteFlag);
      paramVarArgs.aM(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.ni(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.ni(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.ni(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.ni(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nickname);
      }
      i += g.a.a.b.b.a.bu(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + g.a.a.a.nh(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.LikeFlag) + g.a.a.b.b.a.bu(7, this.LikeCount) + g.a.a.b.b.a.bu(8, this.LikeUserListCount) + g.a.a.a.c(9, 8, this.LikeUserList) + g.a.a.b.b.a.bu(10, this.CommentCount) + g.a.a.b.b.a.bu(11, this.CommentUserListCount) + g.a.a.a.c(12, 8, this.CommentUserList) + g.a.a.b.b.a.bu(13, this.WithUserCount) + g.a.a.b.b.a.bu(14, this.WithUserListCount) + g.a.a.a.c(15, 8, this.WithUserList) + g.a.a.b.b.a.bu(16, this.ExtFlag) + g.a.a.b.b.a.bu(17, this.NoChange) + g.a.a.b.b.a.bu(18, this.GroupCount) + g.a.a.a.c(19, 8, this.GroupList) + g.a.a.b.b.a.bu(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.ReferUsername);
      }
      i = paramInt + g.a.a.b.b.a.r(22, this.ReferId) + g.a.a.b.b.a.bu(23, this.BlackListCount) + g.a.a.a.c(24, 8, this.BlackList) + g.a.a.b.b.a.bu(25, this.DeleteFlag) + g.a.a.b.b.a.bu(26, this.GroupUserCount) + g.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + g.a.a.a.nh(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + g.a.a.a.nh(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + g.a.a.a.nh(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + g.a.a.a.nh(31, this.WeAppInfo.computeSize());
      }
      AppMethodBeat.o(125792);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LikeUserList.clear();
      this.CommentUserList.clear();
      this.WithUserList.clear();
      this.GroupList.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125792);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      SnsObject localSnsObject = (SnsObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125792);
        return -1;
      case 1: 
        localSnsObject.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125792);
        return 0;
      case 2: 
        localSnsObject.Username = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 6: 
        localSnsObject.LikeFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.LikeUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.CommentUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.WithUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.GroupList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125792);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125792);
        return 0;
      case 27: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 28: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectOperations = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 29: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ear();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ear)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.SnsRedEnvelops = ((ear)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 30: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localSnsObject.PreDownloadInfo = ((ddw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dzk();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dzk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localSnsObject.WeAppInfo = ((dzk)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    AppMethodBeat.o(125792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SnsObject
 * JD-Core Version:    0.7.0.1
 */