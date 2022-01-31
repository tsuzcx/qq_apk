package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.bv.a
{
  public LinkedList<bwc> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<cds> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int GroupCount;
  public LinkedList<cdz> GroupList;
  public LinkedList<bwc> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<cds> LikeUserList;
  public int LikeUserListCount;
  public String Nickname;
  public int NoChange;
  public SKBuiltinBuffer_t ObjectDesc;
  public SKBuiltinBuffer_t ObjectOperations;
  public bng PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public ces SnsRedEnvelops;
  public String Username;
  public cdo WeAppInfo;
  public int WithUserCount;
  public LinkedList<cds> WithUserList;
  public int WithUserListCount;
  
  public SnsObject()
  {
    AppMethodBeat.i(94581);
    this.LikeUserList = new LinkedList();
    this.CommentUserList = new LinkedList();
    this.WithUserList = new LinkedList();
    this.GroupList = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    AppMethodBeat.o(94581);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94582);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(94582);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(3, this.Nickname);
      }
      paramVarArgs.aO(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.iQ(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.LikeFlag);
      paramVarArgs.aO(7, this.LikeCount);
      paramVarArgs.aO(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.aO(10, this.CommentCount);
      paramVarArgs.aO(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.aO(13, this.WithUserCount);
      paramVarArgs.aO(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.aO(16, this.ExtFlag);
      paramVarArgs.aO(17, this.NoChange);
      paramVarArgs.aO(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.aO(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.e(21, this.ReferUsername);
      }
      paramVarArgs.am(22, this.ReferId);
      paramVarArgs.aO(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.aO(25, this.DeleteFlag);
      paramVarArgs.aO(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.iQ(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.iQ(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.iQ(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.iQ(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94582);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Nickname);
      }
      i += e.a.a.b.b.a.bl(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + e.a.a.a.iP(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.LikeFlag) + e.a.a.b.b.a.bl(7, this.LikeCount) + e.a.a.b.b.a.bl(8, this.LikeUserListCount) + e.a.a.a.c(9, 8, this.LikeUserList) + e.a.a.b.b.a.bl(10, this.CommentCount) + e.a.a.b.b.a.bl(11, this.CommentUserListCount) + e.a.a.a.c(12, 8, this.CommentUserList) + e.a.a.b.b.a.bl(13, this.WithUserCount) + e.a.a.b.b.a.bl(14, this.WithUserListCount) + e.a.a.a.c(15, 8, this.WithUserList) + e.a.a.b.b.a.bl(16, this.ExtFlag) + e.a.a.b.b.a.bl(17, this.NoChange) + e.a.a.b.b.a.bl(18, this.GroupCount) + e.a.a.a.c(19, 8, this.GroupList) + e.a.a.b.b.a.bl(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.ReferUsername);
      }
      i = paramInt + e.a.a.b.b.a.p(22, this.ReferId) + e.a.a.b.b.a.bl(23, this.BlackListCount) + e.a.a.a.c(24, 8, this.BlackList) + e.a.a.b.b.a.bl(25, this.DeleteFlag) + e.a.a.b.b.a.bl(26, this.GroupUserCount) + e.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + e.a.a.a.iP(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + e.a.a.a.iP(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + e.a.a.a.iP(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + e.a.a.a.iP(31, this.WeAppInfo.computeSize());
      }
      AppMethodBeat.o(94582);
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
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(94582);
        throw paramVarArgs;
      }
      AppMethodBeat.o(94582);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      SnsObject localSnsObject = (SnsObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94582);
        return -1;
      case 1: 
        localSnsObject.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94582);
        return 0;
      case 2: 
        localSnsObject.Username = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94582);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94582);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 6: 
        localSnsObject.LikeFlag = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cds();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.LikeUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 12: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cds();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.CommentUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cds();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.WithUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 19: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.GroupList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94582);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94582);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 24: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94582);
        return 0;
      case 27: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 28: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectOperations = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 29: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ces();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ces)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.SnsRedEnvelops = ((ces)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      case 30: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bng();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bng)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localSnsObject.PreDownloadInfo = ((bng)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94582);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdo();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cdo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localSnsObject.WeAppInfo = ((cdo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94582);
      return 0;
    }
    AppMethodBeat.o(94582);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SnsObject
 * JD-Core Version:    0.7.0.1
 */