package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djs
  extends com.tencent.mm.bx.a
{
  public LinkedList<cwt> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public LinkedList<cwt> GroupUser;
  public int GroupUserCount;
  public int HyA;
  public LinkedList<dix> HyB;
  public int HyC;
  public int HyD;
  public int HyE;
  public LinkedList<dix> HyF;
  public int Hyv;
  public int Hyx;
  public SKBuiltinBuffer_t Hyy;
  public LinkedList<dix> Hyz;
  public long Id;
  public String nDo;
  public String nEt;
  
  public djs()
  {
    AppMethodBeat.i(118461);
    this.Hyz = new LinkedList();
    this.HyB = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.HyF = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hyy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Id);
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.Hyx);
      if (this.Hyy != null)
      {
        paramVarArgs.lC(6, this.Hyy.computeSize());
        this.Hyy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.Hyz);
      paramVarArgs.aS(9, this.HyA);
      paramVarArgs.e(10, 8, this.HyB);
      paramVarArgs.aS(11, this.DeleteFlag);
      paramVarArgs.aS(12, this.HyC);
      paramVarArgs.aS(13, this.Hyv);
      paramVarArgs.aS(14, this.HyD);
      paramVarArgs.aS(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aS(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aS(19, this.HyE);
      paramVarArgs.e(20, 8, this.HyF);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      i = i + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.Hyx);
      paramInt = i;
      if (this.Hyy != null) {
        paramInt = i + f.a.a.a.lB(6, this.Hyy.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.CommentCount);
      int j = f.a.a.a.c(8, 8, this.Hyz);
      int k = f.a.a.b.b.a.bz(9, this.HyA);
      int m = f.a.a.a.c(10, 8, this.HyB);
      int n = f.a.a.b.b.a.bz(11, this.DeleteFlag);
      int i1 = f.a.a.b.b.a.bz(12, this.HyC);
      int i2 = f.a.a.b.b.a.bz(13, this.Hyv);
      int i3 = f.a.a.b.b.a.bz(14, this.HyD);
      int i4 = f.a.a.b.b.a.bz(15, this.BlackListCount);
      int i5 = f.a.a.a.c(16, 8, this.BlackList);
      int i6 = f.a.a.b.b.a.bz(17, this.GroupUserCount);
      int i7 = f.a.a.a.c(18, 8, this.GroupUser);
      int i8 = f.a.a.b.b.a.bz(19, this.HyE);
      int i9 = f.a.a.a.c(20, 8, this.HyF);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hyz.clear();
      this.HyB.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.HyF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Hyy == null)
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
      djs localdjs = (djs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localdjs.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localdjs.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localdjs.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localdjs.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localdjs.Hyx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.Hyy = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localdjs.CommentCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dix();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.Hyz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localdjs.HyA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dix();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.HyB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localdjs.DeleteFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localdjs.HyC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localdjs.Hyv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localdjs.HyD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localdjs.BlackListCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localdjs.GroupUserCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localdjs.HyE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dix();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdjs.HyF.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    AppMethodBeat.o(118462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djs
 * JD-Core Version:    0.7.0.1
 */