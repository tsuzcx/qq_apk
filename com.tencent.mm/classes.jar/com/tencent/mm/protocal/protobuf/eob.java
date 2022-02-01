package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eob
  extends com.tencent.mm.cd.a
{
  public LinkedList<eaf> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public LinkedList<eaf> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int UqI;
  public int UqK;
  public eae UqL;
  public LinkedList<eng> UqM;
  public int UqN;
  public LinkedList<eng> UqO;
  public int UqP;
  public int UqQ;
  public int UqR;
  public LinkedList<eng> UqS;
  public String UserName;
  public String rWI;
  
  public eob()
  {
    AppMethodBeat.i(118461);
    this.UqM = new LinkedList();
    this.UqO = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.UqS = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.Id);
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(5, this.UqK);
      if (this.UqL != null)
      {
        paramVarArgs.oE(6, this.UqL.computeSize());
        this.UqL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.UqM);
      paramVarArgs.aY(9, this.UqN);
      paramVarArgs.e(10, 8, this.UqO);
      paramVarArgs.aY(11, this.DeleteFlag);
      paramVarArgs.aY(12, this.UqP);
      paramVarArgs.aY(13, this.UqI);
      paramVarArgs.aY(14, this.UqQ);
      paramVarArgs.aY(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aY(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aY(19, this.UqR);
      paramVarArgs.e(20, 8, this.UqS);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      i = i + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(5, this.UqK);
      paramInt = i;
      if (this.UqL != null) {
        paramInt = i + g.a.a.a.oD(6, this.UqL.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.CommentCount);
      int j = g.a.a.a.c(8, 8, this.UqM);
      int k = g.a.a.b.b.a.bM(9, this.UqN);
      int m = g.a.a.a.c(10, 8, this.UqO);
      int n = g.a.a.b.b.a.bM(11, this.DeleteFlag);
      int i1 = g.a.a.b.b.a.bM(12, this.UqP);
      int i2 = g.a.a.b.b.a.bM(13, this.UqI);
      int i3 = g.a.a.b.b.a.bM(14, this.UqQ);
      int i4 = g.a.a.b.b.a.bM(15, this.BlackListCount);
      int i5 = g.a.a.a.c(16, 8, this.BlackList);
      int i6 = g.a.a.b.b.a.bM(17, this.GroupUserCount);
      int i7 = g.a.a.a.c(18, 8, this.GroupUser);
      int i8 = g.a.a.b.b.a.bM(19, this.UqR);
      int i9 = g.a.a.a.c(20, 8, this.UqS);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UqM.clear();
      this.UqO.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.UqS.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.UqL == null)
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eob localeob = (eob)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localeob.Id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localeob.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localeob.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localeob.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localeob.UqK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
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
          localeob.UqL = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localeob.CommentCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eng();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eng)localObject2).parseFrom((byte[])localObject1);
          }
          localeob.UqM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localeob.UqN = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eng();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eng)localObject2).parseFrom((byte[])localObject1);
          }
          localeob.UqO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localeob.DeleteFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localeob.UqP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localeob.UqI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localeob.UqQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localeob.BlackListCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
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
          localeob.BlackList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localeob.GroupUserCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
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
          localeob.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localeob.UqR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eng();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eng)localObject2).parseFrom((byte[])localObject1);
        }
        localeob.UqS.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eob
 * JD-Core Version:    0.7.0.1
 */