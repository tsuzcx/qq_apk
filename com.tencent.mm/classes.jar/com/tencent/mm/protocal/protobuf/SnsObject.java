package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.bx.a
{
  public LinkedList<cwt> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<dfn> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int GroupCount;
  public LinkedList<dfv> GroupList;
  public LinkedList<cwt> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<dfn> LikeUserList;
  public int LikeUserListCount;
  public String Nickname;
  public int NoChange;
  public SKBuiltinBuffer_t ObjectDesc;
  public SKBuiltinBuffer_t ObjectOperations;
  public clp PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public dgo SnsRedEnvelops;
  public String Username;
  public dfj WeAppInfo;
  public int WithUserCount;
  public LinkedList<dfn> WithUserList;
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125792);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.lC(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.LikeFlag);
      paramVarArgs.aS(7, this.LikeCount);
      paramVarArgs.aS(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.aS(10, this.CommentCount);
      paramVarArgs.aS(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.aS(13, this.WithUserCount);
      paramVarArgs.aS(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.aS(16, this.ExtFlag);
      paramVarArgs.aS(17, this.NoChange);
      paramVarArgs.aS(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.aS(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.d(21, this.ReferUsername);
      }
      paramVarArgs.aY(22, this.ReferId);
      paramVarArgs.aS(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.aS(25, this.DeleteFlag);
      paramVarArgs.aS(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.lC(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.lC(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.lC(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.lC(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      i += f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + f.a.a.a.lB(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.LikeFlag) + f.a.a.b.b.a.bz(7, this.LikeCount) + f.a.a.b.b.a.bz(8, this.LikeUserListCount) + f.a.a.a.c(9, 8, this.LikeUserList) + f.a.a.b.b.a.bz(10, this.CommentCount) + f.a.a.b.b.a.bz(11, this.CommentUserListCount) + f.a.a.a.c(12, 8, this.CommentUserList) + f.a.a.b.b.a.bz(13, this.WithUserCount) + f.a.a.b.b.a.bz(14, this.WithUserListCount) + f.a.a.a.c(15, 8, this.WithUserList) + f.a.a.b.b.a.bz(16, this.ExtFlag) + f.a.a.b.b.a.bz(17, this.NoChange) + f.a.a.b.b.a.bz(18, this.GroupCount) + f.a.a.a.c(19, 8, this.GroupList) + f.a.a.b.b.a.bz(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ReferUsername);
      }
      i = paramInt + f.a.a.b.b.a.p(22, this.ReferId) + f.a.a.b.b.a.bz(23, this.BlackListCount) + f.a.a.a.c(24, 8, this.BlackList) + f.a.a.b.b.a.bz(25, this.DeleteFlag) + f.a.a.b.b.a.bz(26, this.GroupUserCount) + f.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + f.a.a.a.lB(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + f.a.a.a.lB(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + f.a.a.a.lB(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + f.a.a.a.lB(31, this.WeAppInfo.computeSize());
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
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
        localSnsObject.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125792);
        return 0;
      case 2: 
        localSnsObject.Username = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 6: 
        localSnsObject.LikeFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.LikeUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.CommentUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.WithUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.GroupList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125792);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125792);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.ObjectOperations = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 29: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.SnsRedEnvelops = ((dgo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 30: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.PreDownloadInfo = ((clp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dfj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localSnsObject.WeAppInfo = ((dfj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    AppMethodBeat.o(125792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SnsObject
 * JD-Core Version:    0.7.0.1
 */