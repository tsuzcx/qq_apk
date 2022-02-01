package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class def
  extends com.tencent.mm.bw.a
{
  public LinkedList<crm> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public int FNK;
  public int FNM;
  public SKBuiltinBuffer_t FNN;
  public LinkedList<ddk> FNO;
  public int FNP;
  public LinkedList<ddk> FNQ;
  public int FNR;
  public int FNS;
  public int FNT;
  public LinkedList<ddk> FNU;
  public LinkedList<crm> GroupUser;
  public int GroupUserCount;
  public long Id;
  public String ncR;
  public String ndW;
  
  public def()
  {
    AppMethodBeat.i(118461);
    this.FNO = new LinkedList();
    this.FNQ = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.FNU = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Id);
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.FNM);
      if (this.FNN != null)
      {
        paramVarArgs.ln(6, this.FNN.computeSize());
        this.FNN.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.FNO);
      paramVarArgs.aR(9, this.FNP);
      paramVarArgs.e(10, 8, this.FNQ);
      paramVarArgs.aR(11, this.DeleteFlag);
      paramVarArgs.aR(12, this.FNR);
      paramVarArgs.aR(13, this.FNK);
      paramVarArgs.aR(14, this.FNS);
      paramVarArgs.aR(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aR(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aR(19, this.FNT);
      paramVarArgs.e(20, 8, this.FNU);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      i = i + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(5, this.FNM);
      paramInt = i;
      if (this.FNN != null) {
        paramInt = i + f.a.a.a.lm(6, this.FNN.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.CommentCount);
      int j = f.a.a.a.c(8, 8, this.FNO);
      int k = f.a.a.b.b.a.bx(9, this.FNP);
      int m = f.a.a.a.c(10, 8, this.FNQ);
      int n = f.a.a.b.b.a.bx(11, this.DeleteFlag);
      int i1 = f.a.a.b.b.a.bx(12, this.FNR);
      int i2 = f.a.a.b.b.a.bx(13, this.FNK);
      int i3 = f.a.a.b.b.a.bx(14, this.FNS);
      int i4 = f.a.a.b.b.a.bx(15, this.BlackListCount);
      int i5 = f.a.a.a.c(16, 8, this.BlackList);
      int i6 = f.a.a.b.b.a.bx(17, this.GroupUserCount);
      int i7 = f.a.a.a.c(18, 8, this.GroupUser);
      int i8 = f.a.a.b.b.a.bx(19, this.FNT);
      int i9 = f.a.a.a.c(20, 8, this.FNU);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FNO.clear();
      this.FNQ.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.FNU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FNN == null)
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
      def localdef = (def)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localdef.Id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localdef.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localdef.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localdef.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localdef.FNM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdef.FNN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localdef.CommentCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdef.FNO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localdef.FNP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdef.FNQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localdef.DeleteFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localdef.FNR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localdef.FNK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localdef.FNS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localdef.BlackListCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdef.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localdef.GroupUserCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdef.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localdef.FNT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ddk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdef.FNU.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */