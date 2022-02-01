package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dej
  extends cpx
{
  public LinkedList<crm> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t FNN;
  public int FNR;
  public LinkedList<crm> GroupUser;
  public int GroupUserCount;
  public String hkN;
  
  public dej()
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
      if (this.FNN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118469);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNN != null)
      {
        paramVarArgs.ln(2, this.FNN.computeSize());
        this.FNN.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(3, this.hkN);
      }
      if (this.DUq != null)
      {
        paramVarArgs.ln(4, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FNR);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNN != null) {
        paramInt = i + f.a.a.a.lm(2, this.FNN.computeSize());
      }
      i = paramInt;
      if (this.hkN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkN);
      }
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(4, this.DUq.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.FNR);
      int j = f.a.a.b.b.a.bx(6, this.BlackListCount);
      int k = f.a.a.a.c(7, 8, this.BlackList);
      int m = f.a.a.b.b.a.bx(8, this.GroupUserCount);
      int n = f.a.a.a.c(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BlackList.clear();
        this.GroupUser.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FNN == null)
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
        dej localdej = (dej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdej.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdej.FNN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 3: 
          localdej.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118469);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdej.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 5: 
          localdej.FNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118469);
          return 0;
        case 6: 
          localdej.BlackListCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdej.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 8: 
          localdej.GroupUserCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118469);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdej.GroupUser.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dej
 * JD-Core Version:    0.7.0.1
 */