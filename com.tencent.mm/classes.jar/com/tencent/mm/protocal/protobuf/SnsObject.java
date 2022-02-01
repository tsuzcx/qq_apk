package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.bx.a
{
  public LinkedList<etl> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<fdv> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int FlowerFlag;
  public LinkedList<fdv> FlowerUserList;
  public int FlowerUserListCount;
  public int GroupCount;
  public LinkedList<fee> GroupList;
  public LinkedList<etl> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<fdv> LikeUserList;
  public int LikeUserListCount;
  public LinkedList<fdv> NewWithTaList;
  public int NewWithTaListCount;
  public String Nickname;
  public int NoChange;
  public gol ObjectDesc;
  public gol ObjectOperations;
  public egb PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public fez SnsRedEnvelops;
  public String Username;
  public fdr WeAppInfo;
  public int WithChatroomListCount;
  public int WithTaHasOther;
  public LinkedList<etl> WithTaList;
  public int WithTaListCount;
  public int WithUserCount;
  public LinkedList<fdv> WithUserList;
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
    this.WithTaList = new LinkedList();
    this.FlowerUserList = new LinkedList();
    this.NewWithTaList = new LinkedList();
    AppMethodBeat.o(125791);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125792);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125792);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.g(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.g(3, this.Nickname);
      }
      paramVarArgs.bS(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.qD(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.LikeFlag);
      paramVarArgs.bS(7, this.LikeCount);
      paramVarArgs.bS(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.bS(10, this.CommentCount);
      paramVarArgs.bS(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.bS(13, this.WithUserCount);
      paramVarArgs.bS(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.bS(16, this.ExtFlag);
      paramVarArgs.bS(17, this.NoChange);
      paramVarArgs.bS(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.bS(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.g(21, this.ReferUsername);
      }
      paramVarArgs.bv(22, this.ReferId);
      paramVarArgs.bS(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.bS(25, this.DeleteFlag);
      paramVarArgs.bS(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.qD(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.qD(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.qD(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.qD(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(32, this.WithChatroomListCount);
      paramVarArgs.bS(34, this.WithTaListCount);
      paramVarArgs.e(35, 8, this.WithTaList);
      paramVarArgs.bS(36, this.WithTaHasOther);
      paramVarArgs.bS(37, this.FlowerUserListCount);
      paramVarArgs.e(38, 8, this.FlowerUserList);
      paramVarArgs.bS(39, this.FlowerFlag);
      paramVarArgs.e(40, 8, this.NewWithTaList);
      paramVarArgs.bS(41, this.NewWithTaListCount);
      AppMethodBeat.o(125792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Nickname);
      }
      i += i.a.a.b.b.a.cJ(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + i.a.a.a.qC(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.LikeFlag) + i.a.a.b.b.a.cJ(7, this.LikeCount) + i.a.a.b.b.a.cJ(8, this.LikeUserListCount) + i.a.a.a.c(9, 8, this.LikeUserList) + i.a.a.b.b.a.cJ(10, this.CommentCount) + i.a.a.b.b.a.cJ(11, this.CommentUserListCount) + i.a.a.a.c(12, 8, this.CommentUserList) + i.a.a.b.b.a.cJ(13, this.WithUserCount) + i.a.a.b.b.a.cJ(14, this.WithUserListCount) + i.a.a.a.c(15, 8, this.WithUserList) + i.a.a.b.b.a.cJ(16, this.ExtFlag) + i.a.a.b.b.a.cJ(17, this.NoChange) + i.a.a.b.b.a.cJ(18, this.GroupCount) + i.a.a.a.c(19, 8, this.GroupList) + i.a.a.b.b.a.cJ(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.ReferUsername);
      }
      i = paramInt + i.a.a.b.b.a.q(22, this.ReferId) + i.a.a.b.b.a.cJ(23, this.BlackListCount) + i.a.a.a.c(24, 8, this.BlackList) + i.a.a.b.b.a.cJ(25, this.DeleteFlag) + i.a.a.b.b.a.cJ(26, this.GroupUserCount) + i.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + i.a.a.a.qC(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + i.a.a.a.qC(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + i.a.a.a.qC(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + i.a.a.a.qC(31, this.WeAppInfo.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(32, this.WithChatroomListCount);
      int j = i.a.a.b.b.a.cJ(34, this.WithTaListCount);
      int k = i.a.a.a.c(35, 8, this.WithTaList);
      int m = i.a.a.b.b.a.cJ(36, this.WithTaHasOther);
      int n = i.a.a.b.b.a.cJ(37, this.FlowerUserListCount);
      int i1 = i.a.a.a.c(38, 8, this.FlowerUserList);
      int i2 = i.a.a.b.b.a.cJ(39, this.FlowerFlag);
      int i3 = i.a.a.a.c(40, 8, this.NewWithTaList);
      int i4 = i.a.a.b.b.a.cJ(41, this.NewWithTaListCount);
      AppMethodBeat.o(125792);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
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
      this.WithTaList.clear();
      this.FlowerUserList.clear();
      this.NewWithTaList.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
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
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      SnsObject localSnsObject = (SnsObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 33: 
      default: 
        AppMethodBeat.o(125792);
        return -1;
      case 1: 
        localSnsObject.Id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(125792);
        return 0;
      case 2: 
        localSnsObject.Username = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localSnsObject.ObjectDesc = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 6: 
        localSnsObject.LikeFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdv)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.LikeUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdv)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.CommentUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdv)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.WithUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fee();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fee)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.GroupList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(125792);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localSnsObject.BlackList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 27: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localSnsObject.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 28: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localSnsObject.ObjectOperations = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 29: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fez)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.SnsRedEnvelops = ((fez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 30: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new egb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((egb)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.PreDownloadInfo = ((egb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 31: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdr)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.WeAppInfo = ((fdr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 32: 
        localSnsObject.WithChatroomListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 34: 
        localSnsObject.WithTaListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 35: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localSnsObject.WithTaList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 36: 
        localSnsObject.WithTaHasOther = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 37: 
        localSnsObject.FlowerUserListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 38: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdv)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.FlowerUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 39: 
        localSnsObject.FlowerFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125792);
        return 0;
      case 40: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdv)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.NewWithTaList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      }
      localSnsObject.NewWithTaListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(125792);
      return 0;
    }
    AppMethodBeat.o(125792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SnsObject
 * JD-Core Version:    0.7.0.1
 */