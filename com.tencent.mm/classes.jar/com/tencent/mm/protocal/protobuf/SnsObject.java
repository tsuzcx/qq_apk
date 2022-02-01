package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.bx.a
{
  public LinkedList<cmf> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<cuo> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int GroupCount;
  public LinkedList<cuw> GroupList;
  public LinkedList<cmf> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<cuo> LikeUserList;
  public int LikeUserListCount;
  public String Nickname;
  public int NoChange;
  public SKBuiltinBuffer_t ObjectDesc;
  public SKBuiltinBuffer_t ObjectOperations;
  public cbo PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public cvp SnsRedEnvelops;
  public String Username;
  public cuk WeAppInfo;
  public int WithUserCount;
  public LinkedList<cuo> WithUserList;
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
      paramVarArgs.aG(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.kX(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.LikeFlag);
      paramVarArgs.aR(7, this.LikeCount);
      paramVarArgs.aR(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.aR(10, this.CommentCount);
      paramVarArgs.aR(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.aR(13, this.WithUserCount);
      paramVarArgs.aR(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.aR(16, this.ExtFlag);
      paramVarArgs.aR(17, this.NoChange);
      paramVarArgs.aR(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.aR(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.d(21, this.ReferUsername);
      }
      paramVarArgs.aG(22, this.ReferId);
      paramVarArgs.aR(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.aR(25, this.DeleteFlag);
      paramVarArgs.aR(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.kX(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.kX(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.kX(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.kX(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      i += f.a.a.b.b.a.bA(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + f.a.a.a.kW(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.LikeFlag) + f.a.a.b.b.a.bA(7, this.LikeCount) + f.a.a.b.b.a.bA(8, this.LikeUserListCount) + f.a.a.a.c(9, 8, this.LikeUserList) + f.a.a.b.b.a.bA(10, this.CommentCount) + f.a.a.b.b.a.bA(11, this.CommentUserListCount) + f.a.a.a.c(12, 8, this.CommentUserList) + f.a.a.b.b.a.bA(13, this.WithUserCount) + f.a.a.b.b.a.bA(14, this.WithUserListCount) + f.a.a.a.c(15, 8, this.WithUserList) + f.a.a.b.b.a.bA(16, this.ExtFlag) + f.a.a.b.b.a.bA(17, this.NoChange) + f.a.a.b.b.a.bA(18, this.GroupCount) + f.a.a.a.c(19, 8, this.GroupList) + f.a.a.b.b.a.bA(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ReferUsername);
      }
      i = paramInt + f.a.a.b.b.a.q(22, this.ReferId) + f.a.a.b.b.a.bA(23, this.BlackListCount) + f.a.a.a.c(24, 8, this.BlackList) + f.a.a.b.b.a.bA(25, this.DeleteFlag) + f.a.a.b.b.a.bA(26, this.GroupUserCount) + f.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + f.a.a.a.kW(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + f.a.a.a.kW(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + f.a.a.a.kW(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + f.a.a.a.kW(31, this.WeAppInfo.computeSize());
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
          paramVarArgs.fMq();
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
        localSnsObject.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125792);
        return 0;
      case 2: 
        localSnsObject.Username = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
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
        localSnsObject.LikeFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.LikeUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.CommentUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.WithUserList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.GroupList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125792);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125792);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
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
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.SnsRedEnvelops = ((cvp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 30: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localSnsObject.PreDownloadInfo = ((cbo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cuk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cuk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localSnsObject.WeAppInfo = ((cuk)localObject1);
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