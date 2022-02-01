package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwc
  extends cld
{
  public LinkedList<SnsObject> CEH;
  public int DOR;
  public SKBuiltinBuffer_t ElQ;
  public String Emn;
  public int Emr;
  public int Ems;
  public cvr Emt;
  public int EnI;
  public int EnJ;
  public LinkedList<dg> EnK;
  public int EnL;
  public LinkedList<chg> EnM;
  public int EnN;
  public LinkedList<zo> EnO;
  public int EnP;
  public LinkedList<Long> EnQ;
  public LinkedList<Integer> EnR;
  
  public cwc()
  {
    AppMethodBeat.i(125828);
    this.CEH = new LinkedList();
    this.EnK = new LinkedList();
    this.EnM = new LinkedList();
    this.EnO = new LinkedList();
    this.EnQ = new LinkedList();
    this.EnR = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      paramVarArgs.aR(3, this.DOR);
      paramVarArgs.e(4, 8, this.CEH);
      paramVarArgs.aR(5, this.EnI);
      paramVarArgs.aR(6, this.Emr);
      paramVarArgs.aR(7, this.Ems);
      if (this.Emt != null)
      {
        paramVarArgs.kX(8, this.Emt.computeSize());
        this.Emt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.EnJ);
      paramVarArgs.e(10, 8, this.EnK);
      if (this.ElQ != null)
      {
        paramVarArgs.kX(11, this.ElQ.computeSize());
        this.ElQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.EnL);
      paramVarArgs.e(13, 8, this.EnM);
      paramVarArgs.aR(14, this.EnN);
      paramVarArgs.e(15, 8, this.EnO);
      paramVarArgs.aR(16, this.EnP);
      paramVarArgs.f(17, 3, this.EnQ);
      paramVarArgs.f(18, 2, this.EnR);
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1808;
      }
    }
    label1808:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DOR) + f.a.a.a.c(4, 8, this.CEH) + f.a.a.b.b.a.bA(5, this.EnI) + f.a.a.b.b.a.bA(6, this.Emr) + f.a.a.b.b.a.bA(7, this.Ems);
      paramInt = i;
      if (this.Emt != null) {
        paramInt = i + f.a.a.a.kW(8, this.Emt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.EnJ) + f.a.a.a.c(10, 8, this.EnK);
      paramInt = i;
      if (this.ElQ != null) {
        paramInt = i + f.a.a.a.kW(11, this.ElQ.computeSize());
      }
      i = f.a.a.b.b.a.bA(12, this.EnL);
      int j = f.a.a.a.c(13, 8, this.EnM);
      int k = f.a.a.b.b.a.bA(14, this.EnN);
      int m = f.a.a.a.c(15, 8, this.EnO);
      int n = f.a.a.b.b.a.bA(16, this.EnP);
      int i1 = f.a.a.a.d(17, 3, this.EnQ);
      int i2 = f.a.a.a.d(18, 2, this.EnR);
      AppMethodBeat.o(125829);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CEH.clear();
        this.EnK.clear();
        this.EnM.clear();
        this.EnO.clear();
        this.EnQ.clear();
        this.EnR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        cwc localcwc = (cwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localcwc.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localcwc.DOR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.CEH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localcwc.EnI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localcwc.Emr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localcwc.Ems = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.Emt = ((cvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localcwc.EnJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.EnK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.ElQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localcwc.EnL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.EnM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localcwc.EnN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwc.EnO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localcwc.EnP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localcwc.EnQ = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMt();
          AppMethodBeat.o(125829);
          return 0;
        }
        localcwc.EnR = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwc
 * JD-Core Version:    0.7.0.1
 */