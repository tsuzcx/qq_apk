package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkr
  extends cvw
{
  public LinkedList<cxn> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t FSi;
  public LinkedList<cxn> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t HSj;
  public int HSn;
  public String hFO;
  
  public dkr()
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
      if (this.HSj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118469);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HSj != null)
      {
        paramVarArgs.lJ(2, this.HSj.computeSize());
        this.HSj.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(3, this.hFO);
      }
      if (this.FSi != null)
      {
        paramVarArgs.lJ(4, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HSn);
      paramVarArgs.aS(6, this.BlackListCount);
      paramVarArgs.e(7, 8, this.BlackList);
      paramVarArgs.aS(8, this.GroupUserCount);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HSj != null) {
        paramInt = i + f.a.a.a.lI(2, this.HSj.computeSize());
      }
      i = paramInt;
      if (this.hFO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFO);
      }
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(4, this.FSi.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HSn);
      int j = f.a.a.b.b.a.bz(6, this.BlackListCount);
      int k = f.a.a.a.c(7, 8, this.BlackList);
      int m = f.a.a.b.b.a.bz(8, this.GroupUserCount);
      int n = f.a.a.a.c(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BlackList.clear();
        this.GroupUser.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HSj == null)
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
        dkr localdkr = (dkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkr.HSj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 3: 
          localdkr.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118469);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkr.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 5: 
          localdkr.HSn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118469);
          return 0;
        case 6: 
          localdkr.BlackListCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkr.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 8: 
          localdkr.GroupUserCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118469);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkr.GroupUser.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkr
 * JD-Core Version:    0.7.0.1
 */