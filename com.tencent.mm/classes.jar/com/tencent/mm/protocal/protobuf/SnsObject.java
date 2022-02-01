package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class SnsObject
  extends com.tencent.mm.cd.a
{
  public LinkedList<eaf> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public LinkedList<ejo> CommentUserList;
  public int CommentUserListCount;
  public int CreateTime;
  public int DeleteFlag;
  public int ExtFlag;
  public int GroupCount;
  public LinkedList<ejw> GroupList;
  public LinkedList<eaf> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int IsNotRichText;
  public int LikeCount;
  public int LikeFlag;
  public LinkedList<ejo> LikeUserList;
  public int LikeUserListCount;
  public String Nickname;
  public int NoChange;
  public eae ObjectDesc;
  public eae ObjectOperations;
  public dnm PreDownloadInfo;
  public long ReferId;
  public String ReferUsername;
  public ekr SnsRedEnvelops;
  public String Username;
  public ejk WeAppInfo;
  public int WithUserCount;
  public LinkedList<ejo> WithUserList;
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
      paramVarArgs.bm(1, this.Id);
      if (this.Username != null) {
        paramVarArgs.f(2, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.f(3, this.Nickname);
      }
      paramVarArgs.aY(4, this.CreateTime);
      if (this.ObjectDesc != null)
      {
        paramVarArgs.oE(5, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.LikeFlag);
      paramVarArgs.aY(7, this.LikeCount);
      paramVarArgs.aY(8, this.LikeUserListCount);
      paramVarArgs.e(9, 8, this.LikeUserList);
      paramVarArgs.aY(10, this.CommentCount);
      paramVarArgs.aY(11, this.CommentUserListCount);
      paramVarArgs.e(12, 8, this.CommentUserList);
      paramVarArgs.aY(13, this.WithUserCount);
      paramVarArgs.aY(14, this.WithUserListCount);
      paramVarArgs.e(15, 8, this.WithUserList);
      paramVarArgs.aY(16, this.ExtFlag);
      paramVarArgs.aY(17, this.NoChange);
      paramVarArgs.aY(18, this.GroupCount);
      paramVarArgs.e(19, 8, this.GroupList);
      paramVarArgs.aY(20, this.IsNotRichText);
      if (this.ReferUsername != null) {
        paramVarArgs.f(21, this.ReferUsername);
      }
      paramVarArgs.bm(22, this.ReferId);
      paramVarArgs.aY(23, this.BlackListCount);
      paramVarArgs.e(24, 8, this.BlackList);
      paramVarArgs.aY(25, this.DeleteFlag);
      paramVarArgs.aY(26, this.GroupUserCount);
      paramVarArgs.e(27, 8, this.GroupUser);
      if (this.ObjectOperations != null)
      {
        paramVarArgs.oE(28, this.ObjectOperations.computeSize());
        this.ObjectOperations.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.oE(29, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.PreDownloadInfo != null)
      {
        paramVarArgs.oE(30, this.PreDownloadInfo.computeSize());
        this.PreDownloadInfo.writeFields(paramVarArgs);
      }
      if (this.WeAppInfo != null)
      {
        paramVarArgs.oE(31, this.WeAppInfo.computeSize());
        this.WeAppInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Username);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Nickname);
      }
      i += g.a.a.b.b.a.bM(4, this.CreateTime);
      paramInt = i;
      if (this.ObjectDesc != null) {
        paramInt = i + g.a.a.a.oD(5, this.ObjectDesc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.LikeFlag) + g.a.a.b.b.a.bM(7, this.LikeCount) + g.a.a.b.b.a.bM(8, this.LikeUserListCount) + g.a.a.a.c(9, 8, this.LikeUserList) + g.a.a.b.b.a.bM(10, this.CommentCount) + g.a.a.b.b.a.bM(11, this.CommentUserListCount) + g.a.a.a.c(12, 8, this.CommentUserList) + g.a.a.b.b.a.bM(13, this.WithUserCount) + g.a.a.b.b.a.bM(14, this.WithUserListCount) + g.a.a.a.c(15, 8, this.WithUserList) + g.a.a.b.b.a.bM(16, this.ExtFlag) + g.a.a.b.b.a.bM(17, this.NoChange) + g.a.a.b.b.a.bM(18, this.GroupCount) + g.a.a.a.c(19, 8, this.GroupList) + g.a.a.b.b.a.bM(20, this.IsNotRichText);
      paramInt = i;
      if (this.ReferUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.ReferUsername);
      }
      i = paramInt + g.a.a.b.b.a.p(22, this.ReferId) + g.a.a.b.b.a.bM(23, this.BlackListCount) + g.a.a.a.c(24, 8, this.BlackList) + g.a.a.b.b.a.bM(25, this.DeleteFlag) + g.a.a.b.b.a.bM(26, this.GroupUserCount) + g.a.a.a.c(27, 8, this.GroupUser);
      paramInt = i;
      if (this.ObjectOperations != null) {
        paramInt = i + g.a.a.a.oD(28, this.ObjectOperations.computeSize());
      }
      i = paramInt;
      if (this.SnsRedEnvelops != null) {
        i = paramInt + g.a.a.a.oD(29, this.SnsRedEnvelops.computeSize());
      }
      paramInt = i;
      if (this.PreDownloadInfo != null) {
        paramInt = i + g.a.a.a.oD(30, this.PreDownloadInfo.computeSize());
      }
      i = paramInt;
      if (this.WeAppInfo != null) {
        i = paramInt + g.a.a.a.oD(31, this.WeAppInfo.computeSize());
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
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125792);
        return -1;
      case 1: 
        localSnsObject.Id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(125792);
        return 0;
      case 2: 
        localSnsObject.Username = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 3: 
        localSnsObject.Nickname = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 4: 
        localSnsObject.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localSnsObject.ObjectDesc = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 6: 
        localSnsObject.LikeFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 7: 
        localSnsObject.LikeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 8: 
        localSnsObject.LikeUserListCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejo)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.LikeUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 10: 
        localSnsObject.CommentCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 11: 
        localSnsObject.CommentUserListCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejo)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.CommentUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 13: 
        localSnsObject.WithUserCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 14: 
        localSnsObject.WithUserListCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejo)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.WithUserList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 16: 
        localSnsObject.ExtFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 17: 
        localSnsObject.NoChange = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 18: 
        localSnsObject.GroupCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejw)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.GroupList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 20: 
        localSnsObject.IsNotRichText = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 21: 
        localSnsObject.ReferUsername = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125792);
        return 0;
      case 22: 
        localSnsObject.ReferId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(125792);
        return 0;
      case 23: 
        localSnsObject.BlackListCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localSnsObject.BlackList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 25: 
        localSnsObject.DeleteFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 26: 
        localSnsObject.GroupUserCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125792);
        return 0;
      case 27: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localSnsObject.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 28: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localSnsObject.ObjectOperations = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 29: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ekr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ekr)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.SnsRedEnvelops = ((ekr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      case 30: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dnm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dnm)localObject2).parseFrom((byte[])localObject1);
          }
          localSnsObject.PreDownloadInfo = ((dnm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125792);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ejk();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ejk)localObject2).parseFrom((byte[])localObject1);
        }
        localSnsObject.WeAppInfo = ((ejk)localObject2);
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