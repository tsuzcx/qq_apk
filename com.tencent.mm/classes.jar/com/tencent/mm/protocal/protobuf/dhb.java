package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhb
  extends cvp
{
  public LinkedList<SnsObject> FCD;
  public int GUQ;
  public String HtU;
  public int HtY;
  public int HtZ;
  public SKBuiltinBuffer_t Htx;
  public dgq Hua;
  public int Hvp;
  public int Hvq;
  public LinkedList<dj> Hvr;
  public int Hvs;
  public LinkedList<crk> Hvt;
  public int Hvu;
  public LinkedList<acn> Hvv;
  public int Hvw;
  public LinkedList<Long> Hvx;
  public LinkedList<Integer> Hvy;
  
  public dhb()
  {
    AppMethodBeat.i(125828);
    this.FCD = new LinkedList();
    this.Hvr = new LinkedList();
    this.Hvt = new LinkedList();
    this.Hvv = new LinkedList();
    this.Hvx = new LinkedList();
    this.Hvy = new LinkedList();
    AppMethodBeat.o(125828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125829);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aS(3, this.GUQ);
      paramVarArgs.e(4, 8, this.FCD);
      paramVarArgs.aS(5, this.Hvp);
      paramVarArgs.aS(6, this.HtY);
      paramVarArgs.aS(7, this.HtZ);
      if (this.Hua != null)
      {
        paramVarArgs.lC(8, this.Hua.computeSize());
        this.Hua.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.Hvq);
      paramVarArgs.e(10, 8, this.Hvr);
      if (this.Htx != null)
      {
        paramVarArgs.lC(11, this.Htx.computeSize());
        this.Htx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.Hvs);
      paramVarArgs.e(13, 8, this.Hvt);
      paramVarArgs.aS(14, this.Hvu);
      paramVarArgs.e(15, 8, this.Hvv);
      paramVarArgs.aS(16, this.Hvw);
      paramVarArgs.f(17, 3, this.Hvx);
      paramVarArgs.f(18, 2, this.Hvy);
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1808;
      }
    }
    label1808:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GUQ) + f.a.a.a.c(4, 8, this.FCD) + f.a.a.b.b.a.bz(5, this.Hvp) + f.a.a.b.b.a.bz(6, this.HtY) + f.a.a.b.b.a.bz(7, this.HtZ);
      paramInt = i;
      if (this.Hua != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hua.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Hvq) + f.a.a.a.c(10, 8, this.Hvr);
      paramInt = i;
      if (this.Htx != null) {
        paramInt = i + f.a.a.a.lB(11, this.Htx.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.Hvs);
      int j = f.a.a.a.c(13, 8, this.Hvt);
      int k = f.a.a.b.b.a.bz(14, this.Hvu);
      int m = f.a.a.a.c(15, 8, this.Hvv);
      int n = f.a.a.b.b.a.bz(16, this.Hvw);
      int i1 = f.a.a.a.d(17, 3, this.Hvx);
      int i2 = f.a.a.a.d(18, 2, this.Hvy);
      AppMethodBeat.o(125829);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FCD.clear();
        this.Hvr.clear();
        this.Hvt.clear();
        this.Hvv.clear();
        this.Hvx.clear();
        this.Hvy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhb localdhb = (dhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localdhb.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localdhb.GUQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.FCD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localdhb.Hvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localdhb.HtY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localdhb.HtZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Hua = ((dgq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localdhb.Hvq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Hvr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Htx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localdhb.Hvs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Hvt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localdhb.Hvu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Hvv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localdhb.Hvw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localdhb.Hvx = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxH();
          AppMethodBeat.o(125829);
          return 0;
        }
        localdhb.Hvy = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */