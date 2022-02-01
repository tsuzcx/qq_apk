package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fiz
  extends com.tencent.mm.bx.a
{
  public LinkedList<etl> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public LinkedList<etl> GroupUser;
  public int GroupUserCount;
  public long Id;
  public String UserName;
  public int abJH;
  public int abJJ;
  public gol abJK;
  public LinkedList<fie> abJL;
  public int abJM;
  public LinkedList<fie> abJN;
  public int abJO;
  public int abJP;
  public int abJQ;
  public LinkedList<fie> abJR;
  public String vhX;
  
  public fiz()
  {
    AppMethodBeat.i(118461);
    this.abJL = new LinkedList();
    this.abJN = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.abJR = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abJK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.Id);
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(5, this.abJJ);
      if (this.abJK != null)
      {
        paramVarArgs.qD(6, this.abJK.computeSize());
        this.abJK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.abJL);
      paramVarArgs.bS(9, this.abJM);
      paramVarArgs.e(10, 8, this.abJN);
      paramVarArgs.bS(11, this.DeleteFlag);
      paramVarArgs.bS(12, this.abJO);
      paramVarArgs.bS(13, this.abJH);
      paramVarArgs.bS(14, this.abJP);
      paramVarArgs.bS(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.bS(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.bS(19, this.abJQ);
      paramVarArgs.e(20, 8, this.abJR);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(5, this.abJJ);
      paramInt = i;
      if (this.abJK != null) {
        paramInt = i + i.a.a.a.qC(6, this.abJK.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.CommentCount);
      int j = i.a.a.a.c(8, 8, this.abJL);
      int k = i.a.a.b.b.a.cJ(9, this.abJM);
      int m = i.a.a.a.c(10, 8, this.abJN);
      int n = i.a.a.b.b.a.cJ(11, this.DeleteFlag);
      int i1 = i.a.a.b.b.a.cJ(12, this.abJO);
      int i2 = i.a.a.b.b.a.cJ(13, this.abJH);
      int i3 = i.a.a.b.b.a.cJ(14, this.abJP);
      int i4 = i.a.a.b.b.a.cJ(15, this.BlackListCount);
      int i5 = i.a.a.a.c(16, 8, this.BlackList);
      int i6 = i.a.a.b.b.a.cJ(17, this.GroupUserCount);
      int i7 = i.a.a.a.c(18, 8, this.GroupUser);
      int i8 = i.a.a.b.b.a.cJ(19, this.abJQ);
      int i9 = i.a.a.a.c(20, 8, this.abJR);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abJL.clear();
      this.abJN.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.abJR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abJK == null)
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
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fiz localfiz = (fiz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localfiz.Id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localfiz.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localfiz.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localfiz.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localfiz.abJJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
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
          localfiz.abJK = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localfiz.CommentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fie();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fie)localObject2).parseFrom((byte[])localObject1);
          }
          localfiz.abJL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localfiz.abJM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fie();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fie)localObject2).parseFrom((byte[])localObject1);
          }
          localfiz.abJN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localfiz.DeleteFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localfiz.abJO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localfiz.abJH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localfiz.abJP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localfiz.BlackListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
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
          localfiz.BlackList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localfiz.GroupUserCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
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
          localfiz.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localfiz.abJQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fie();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fie)localObject2).parseFrom((byte[])localObject1);
        }
        localfiz.abJR.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fiz
 * JD-Core Version:    0.7.0.1
 */