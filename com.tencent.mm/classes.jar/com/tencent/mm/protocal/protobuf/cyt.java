package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyt
  extends com.tencent.mm.bx.a
{
  public LinkedList<cmf> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public int EqI;
  public int EqK;
  public SKBuiltinBuffer_t EqL;
  public LinkedList<cxy> EqM;
  public int EqN;
  public LinkedList<cxy> EqO;
  public int EqP;
  public int EqQ;
  public int EqR;
  public LinkedList<cxy> EqS;
  public LinkedList<cmf> GroupUser;
  public int GroupUserCount;
  public long Id;
  public String mAQ;
  public String mBV;
  
  public cyt()
  {
    AppMethodBeat.i(118461);
    this.EqM = new LinkedList();
    this.EqO = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.EqS = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.Id);
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.EqK);
      if (this.EqL != null)
      {
        paramVarArgs.kX(6, this.EqL.computeSize());
        this.EqL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.EqM);
      paramVarArgs.aR(9, this.EqN);
      paramVarArgs.e(10, 8, this.EqO);
      paramVarArgs.aR(11, this.DeleteFlag);
      paramVarArgs.aR(12, this.EqP);
      paramVarArgs.aR(13, this.EqI);
      paramVarArgs.aR(14, this.EqQ);
      paramVarArgs.aR(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aR(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aR(19, this.EqR);
      paramVarArgs.e(20, 8, this.EqS);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      i = i + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(5, this.EqK);
      paramInt = i;
      if (this.EqL != null) {
        paramInt = i + f.a.a.a.kW(6, this.EqL.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.CommentCount);
      int j = f.a.a.a.c(8, 8, this.EqM);
      int k = f.a.a.b.b.a.bA(9, this.EqN);
      int m = f.a.a.a.c(10, 8, this.EqO);
      int n = f.a.a.b.b.a.bA(11, this.DeleteFlag);
      int i1 = f.a.a.b.b.a.bA(12, this.EqP);
      int i2 = f.a.a.b.b.a.bA(13, this.EqI);
      int i3 = f.a.a.b.b.a.bA(14, this.EqQ);
      int i4 = f.a.a.b.b.a.bA(15, this.BlackListCount);
      int i5 = f.a.a.a.c(16, 8, this.BlackList);
      int i6 = f.a.a.b.b.a.bA(17, this.GroupUserCount);
      int i7 = f.a.a.a.c(18, 8, this.GroupUser);
      int i8 = f.a.a.b.b.a.bA(19, this.EqR);
      int i9 = f.a.a.a.c(20, 8, this.EqS);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EqM.clear();
      this.EqO.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.EqS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.EqL == null)
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
      cyt localcyt = (cyt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localcyt.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localcyt.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localcyt.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localcyt.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localcyt.EqK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyt.EqL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localcyt.CommentCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyt.EqM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localcyt.EqN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyt.EqO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localcyt.DeleteFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localcyt.EqP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localcyt.EqI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localcyt.EqQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localcyt.BlackListCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyt.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localcyt.GroupUserCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyt.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localcyt.EqR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcyt.EqS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    AppMethodBeat.o(118462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyt
 * JD-Core Version:    0.7.0.1
 */