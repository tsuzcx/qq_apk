package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkn
  extends com.tencent.mm.bw.a
{
  public LinkedList<cxn> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public LinkedList<cxn> GroupUser;
  public int GroupUserCount;
  public int HSg;
  public int HSi;
  public SKBuiltinBuffer_t HSj;
  public LinkedList<djs> HSk;
  public int HSl;
  public LinkedList<djs> HSm;
  public int HSn;
  public int HSo;
  public int HSp;
  public LinkedList<djs> HSq;
  public long Id;
  public String nIJ;
  public String nJO;
  
  public dkn()
  {
    AppMethodBeat.i(118461);
    this.HSk = new LinkedList();
    this.HSm = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.HSq = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.Id);
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.HSi);
      if (this.HSj != null)
      {
        paramVarArgs.lJ(6, this.HSj.computeSize());
        this.HSj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.HSk);
      paramVarArgs.aS(9, this.HSl);
      paramVarArgs.e(10, 8, this.HSm);
      paramVarArgs.aS(11, this.DeleteFlag);
      paramVarArgs.aS(12, this.HSn);
      paramVarArgs.aS(13, this.HSg);
      paramVarArgs.aS(14, this.HSo);
      paramVarArgs.aS(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aS(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aS(19, this.HSp);
      paramVarArgs.e(20, 8, this.HSq);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      i = i + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.HSi);
      paramInt = i;
      if (this.HSj != null) {
        paramInt = i + f.a.a.a.lI(6, this.HSj.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.CommentCount);
      int j = f.a.a.a.c(8, 8, this.HSk);
      int k = f.a.a.b.b.a.bz(9, this.HSl);
      int m = f.a.a.a.c(10, 8, this.HSm);
      int n = f.a.a.b.b.a.bz(11, this.DeleteFlag);
      int i1 = f.a.a.b.b.a.bz(12, this.HSn);
      int i2 = f.a.a.b.b.a.bz(13, this.HSg);
      int i3 = f.a.a.b.b.a.bz(14, this.HSo);
      int i4 = f.a.a.b.b.a.bz(15, this.BlackListCount);
      int i5 = f.a.a.a.c(16, 8, this.BlackList);
      int i6 = f.a.a.b.b.a.bz(17, this.GroupUserCount);
      int i7 = f.a.a.a.c(18, 8, this.GroupUser);
      int i8 = f.a.a.b.b.a.bz(19, this.HSp);
      int i9 = f.a.a.a.c(20, 8, this.HSq);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HSk.clear();
      this.HSm.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.HSq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HSj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkn localdkn = (dkn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localdkn.Id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localdkn.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localdkn.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localdkn.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localdkn.HSi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkn.HSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localdkn.CommentCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkn.HSk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localdkn.HSl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkn.HSm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localdkn.DeleteFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localdkn.HSn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localdkn.HSg = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localdkn.HSo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localdkn.BlackListCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkn.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localdkn.GroupUserCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkn.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localdkn.HSp = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new djs();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkn.HSq.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    AppMethodBeat.o(118462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkn
 * JD-Core Version:    0.7.0.1
 */