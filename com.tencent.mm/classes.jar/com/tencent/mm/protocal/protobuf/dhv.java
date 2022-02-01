package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhv
  extends cwj
{
  public LinkedList<SnsObject> FUY;
  public int HNB;
  public int HNC;
  public dhk HND;
  public SKBuiltinBuffer_t HNa;
  public String HNx;
  public int HOS;
  public int HOT;
  public LinkedList<dj> HOU;
  public int HOV;
  public LinkedList<cse> HOW;
  public int HOX;
  public LinkedList<acw> HOY;
  public int HOZ;
  public LinkedList<Long> HPa;
  public LinkedList<Integer> HPb;
  public int Hor;
  
  public dhv()
  {
    AppMethodBeat.i(125828);
    this.FUY = new LinkedList();
    this.HOU = new LinkedList();
    this.HOW = new LinkedList();
    this.HOY = new LinkedList();
    this.HPa = new LinkedList();
    this.HPb = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      paramVarArgs.aS(3, this.Hor);
      paramVarArgs.e(4, 8, this.FUY);
      paramVarArgs.aS(5, this.HOS);
      paramVarArgs.aS(6, this.HNB);
      paramVarArgs.aS(7, this.HNC);
      if (this.HND != null)
      {
        paramVarArgs.lJ(8, this.HND.computeSize());
        this.HND.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.HOT);
      paramVarArgs.e(10, 8, this.HOU);
      if (this.HNa != null)
      {
        paramVarArgs.lJ(11, this.HNa.computeSize());
        this.HNa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.HOV);
      paramVarArgs.e(13, 8, this.HOW);
      paramVarArgs.aS(14, this.HOX);
      paramVarArgs.e(15, 8, this.HOY);
      paramVarArgs.aS(16, this.HOZ);
      paramVarArgs.f(17, 3, this.HPa);
      paramVarArgs.f(18, 2, this.HPb);
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1808;
      }
    }
    label1808:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Hor) + f.a.a.a.c(4, 8, this.FUY) + f.a.a.b.b.a.bz(5, this.HOS) + f.a.a.b.b.a.bz(6, this.HNB) + f.a.a.b.b.a.bz(7, this.HNC);
      paramInt = i;
      if (this.HND != null) {
        paramInt = i + f.a.a.a.lI(8, this.HND.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HOT) + f.a.a.a.c(10, 8, this.HOU);
      paramInt = i;
      if (this.HNa != null) {
        paramInt = i + f.a.a.a.lI(11, this.HNa.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.HOV);
      int j = f.a.a.a.c(13, 8, this.HOW);
      int k = f.a.a.b.b.a.bz(14, this.HOX);
      int m = f.a.a.a.c(15, 8, this.HOY);
      int n = f.a.a.b.b.a.bz(16, this.HOZ);
      int i1 = f.a.a.a.d(17, 3, this.HPa);
      int i2 = f.a.a.a.d(18, 2, this.HPb);
      AppMethodBeat.o(125829);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUY.clear();
        this.HOU.clear();
        this.HOW.clear();
        this.HOY.clear();
        this.HPa.clear();
        this.HPb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        dhv localdhv = (dhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localdhv.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localdhv.Hor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.FUY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localdhv.HOS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localdhv.HNB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localdhv.HNC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.HND = ((dhk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localdhv.HOT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.HOU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.HNa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localdhv.HOV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.HOW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localdhv.HOX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhv.HOY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localdhv.HOZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localdhv.HPa = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCj();
          AppMethodBeat.o(125829);
          return 0;
        }
        localdhv.HPb = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhv
 * JD-Core Version:    0.7.0.1
 */