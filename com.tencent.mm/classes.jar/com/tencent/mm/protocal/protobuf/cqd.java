package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cqd
  extends bvk
{
  public String wQf;
  public SKBuiltinBuffer_t woT;
  public SKBuiltinBuffer_t wrN;
  public String wrS;
  public SKBuiltinBuffer_t wrT;
  public bwc wwn;
  public SKBuiltinBuffer_t wwo;
  public bwc xgV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60073);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(60073);
        throw paramVarArgs;
      }
      if (this.xgV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(60073);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(60073);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xgV != null)
      {
        paramVarArgs.iQ(2, this.xgV.computeSize());
        this.xgV.writeFields(paramVarArgs);
      }
      if (this.woT != null)
      {
        paramVarArgs.iQ(3, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(4, this.wQf);
      }
      if (this.wwn != null)
      {
        paramVarArgs.iQ(5, this.wwn.computeSize());
        this.wwn.writeFields(paramVarArgs);
      }
      if (this.wrT != null)
      {
        paramVarArgs.iQ(6, this.wrT.computeSize());
        this.wrT.writeFields(paramVarArgs);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(7, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      if (this.wrS != null) {
        paramVarArgs.e(8, this.wrS);
      }
      if (this.wrN != null)
      {
        paramVarArgs.iQ(9, this.wrN.computeSize());
        this.wrN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xgV != null) {
        paramInt = i + e.a.a.a.iP(2, this.xgV.computeSize());
      }
      i = paramInt;
      if (this.woT != null) {
        i = paramInt + e.a.a.a.iP(3, this.woT.computeSize());
      }
      paramInt = i;
      if (this.wQf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wQf);
      }
      i = paramInt;
      if (this.wwn != null) {
        i = paramInt + e.a.a.a.iP(5, this.wwn.computeSize());
      }
      paramInt = i;
      if (this.wrT != null) {
        paramInt = i + e.a.a.a.iP(6, this.wrT.computeSize());
      }
      i = paramInt;
      if (this.wwo != null) {
        i = paramInt + e.a.a.a.iP(7, this.wwo.computeSize());
      }
      paramInt = i;
      if (this.wrS != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wrS);
      }
      i = paramInt;
      if (this.wrN != null) {
        i = paramInt + e.a.a.a.iP(9, this.wrN.computeSize());
      }
      AppMethodBeat.o(60073);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(60073);
          throw paramVarArgs;
        }
        if (this.xgV == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(60073);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(60073);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60073);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqd localcqd = (cqd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60073);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.xgV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 4: 
          localcqd.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60073);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.wwn = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.wrT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqd.wwo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60073);
          return 0;
        case 8: 
          localcqd.wrS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60073);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcqd.wrN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60073);
        return 0;
      }
      AppMethodBeat.o(60073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqd
 * JD-Core Version:    0.7.0.1
 */