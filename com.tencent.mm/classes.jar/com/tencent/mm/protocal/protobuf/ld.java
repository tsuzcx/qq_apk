package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ld
  extends cld
{
  public SKBuiltinBuffer_t CBe;
  public SKBuiltinBuffer_t CBk;
  public String CGA;
  public String CGB;
  public cmi CGl;
  public String CGt;
  public cmf CGw;
  public SKBuiltinBuffer_t CGx;
  public int CGz;
  public int CuL;
  public int CuO;
  public SKBuiltinBuffer_t CxB;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CGt != null) {
        paramVarArgs.d(2, this.CGt);
      }
      if (this.CxB != null)
      {
        paramVarArgs.kX(3, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CuO);
      paramVarArgs.aR(5, this.CGz);
      if (this.CGA != null) {
        paramVarArgs.d(6, this.CGA);
      }
      paramVarArgs.aR(7, this.mBi);
      if (this.CGB != null) {
        paramVarArgs.d(8, this.CGB);
      }
      if (this.CGw != null)
      {
        paramVarArgs.kX(9, this.CGw.computeSize());
        this.CGw.writeFields(paramVarArgs);
      }
      if (this.CBk != null)
      {
        paramVarArgs.kX(10, this.CBk.computeSize());
        this.CBk.writeFields(paramVarArgs);
      }
      if (this.CGx != null)
      {
        paramVarArgs.kX(11, this.CGx.computeSize());
        this.CGx.writeFields(paramVarArgs);
      }
      if (this.CGl != null)
      {
        paramVarArgs.kX(12, this.CGl.computeSize());
        this.CGl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.CuL);
      if (this.CBe != null)
      {
        paramVarArgs.kX(14, this.CBe.computeSize());
        this.CBe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CGt);
      }
      i = paramInt;
      if (this.CxB != null) {
        i = paramInt + f.a.a.a.kW(3, this.CxB.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(4, this.CuO) + f.a.a.b.b.a.bA(5, this.CGz);
      paramInt = i;
      if (this.CGA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CGA);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.mBi);
      paramInt = i;
      if (this.CGB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CGB);
      }
      i = paramInt;
      if (this.CGw != null) {
        i = paramInt + f.a.a.a.kW(9, this.CGw.computeSize());
      }
      paramInt = i;
      if (this.CBk != null) {
        paramInt = i + f.a.a.a.kW(10, this.CBk.computeSize());
      }
      i = paramInt;
      if (this.CGx != null) {
        i = paramInt + f.a.a.a.kW(11, this.CGx.computeSize());
      }
      paramInt = i;
      if (this.CGl != null) {
        paramInt = i + f.a.a.a.kW(12, this.CGl.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.CuL);
      paramInt = i;
      if (this.CBe != null) {
        paramInt = i + f.a.a.a.kW(14, this.CBe.computeSize());
      }
      AppMethodBeat.o(155397);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ld localld = (ld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            localld.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          localld.CGt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localld.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          localld.CuO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          localld.CGz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          localld.CGA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          localld.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          localld.CGB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localld.CGw = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localld.CBk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
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
            localld.CGx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localld.CGl = ((cmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          localld.CuL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155397);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localld.CBe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ld
 * JD-Core Version:    0.7.0.1
 */