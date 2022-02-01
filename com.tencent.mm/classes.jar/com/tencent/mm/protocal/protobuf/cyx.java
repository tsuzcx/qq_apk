package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyx
  extends ckq
{
  public LinkedList<cmf> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t EqL;
  public int EqP;
  public LinkedList<cmf> GroupUser;
  public int GroupUserCount;
  public String gKn;
  
  public cyx()
  {
    AppMethodBeat.i(118468);
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    AppMethodBeat.o(118468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118469);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EqL != null)
      {
        paramVarArgs.kX(2, this.EqL.computeSize());
        this.EqL.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(3, this.gKn);
      }
      if (this.CBT != null)
      {
        paramVarArgs.kX(4, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EqP);
      paramVarArgs.aR(6, this.BlackListCount);
      paramVarArgs.e(7, 8, this.BlackList);
      paramVarArgs.aR(8, this.GroupUserCount);
      paramVarArgs.e(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1154;
      }
    }
    label1154:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EqL != null) {
        paramInt = i + f.a.a.a.kW(2, this.EqL.computeSize());
      }
      i = paramInt;
      if (this.gKn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKn);
      }
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(4, this.CBT.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.EqP);
      int j = f.a.a.b.b.a.bA(6, this.BlackListCount);
      int k = f.a.a.a.c(7, 8, this.BlackList);
      int m = f.a.a.b.b.a.bA(8, this.GroupUserCount);
      int n = f.a.a.a.c(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BlackList.clear();
        this.GroupUser.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjDesc");
          AppMethodBeat.o(118469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyx localcyx = (cyx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyx.EqL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 3: 
          localcyx.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118469);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyx.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 5: 
          localcyx.EqP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118469);
          return 0;
        case 6: 
          localcyx.BlackListCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyx.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 8: 
          localcyx.GroupUserCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118469);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyx.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      AppMethodBeat.o(118469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyx
 * JD-Core Version:    0.7.0.1
 */