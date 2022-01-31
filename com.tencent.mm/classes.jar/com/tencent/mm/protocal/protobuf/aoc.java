package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aoc
  extends bvk
{
  public String Desc;
  public LinkedList<EmotionSummary> EmotionList;
  public String HeadUrl;
  public String Name;
  public SKBuiltinBuffer_t ReqBuf;
  public String wuS;
  public LinkedList<zg> wuz;
  public String xeb;
  
  public aoc()
  {
    AppMethodBeat.i(62570);
    this.EmotionList = new LinkedList();
    this.wuz = new LinkedList();
    AppMethodBeat.o(62570);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62571);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.xeb == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerUrl");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.HeadUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.wuS == null)
      {
        paramVarArgs = new b("Not all required fields were included: BizName");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(62571);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xeb != null) {
        paramVarArgs.e(2, this.xeb);
      }
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.HeadUrl != null) {
        paramVarArgs.e(5, this.HeadUrl);
      }
      if (this.wuS != null) {
        paramVarArgs.e(6, this.wuS);
      }
      paramVarArgs.e(7, 8, this.EmotionList);
      if (this.ReqBuf != null)
      {
        paramVarArgs.iQ(8, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.wuz);
      AppMethodBeat.o(62571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1390;
      }
    }
    label1390:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xeb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xeb);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.HeadUrl);
      }
      paramInt = i;
      if (this.wuS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wuS);
      }
      i = paramInt + e.a.a.a.c(7, 8, this.EmotionList);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + e.a.a.a.iP(8, this.ReqBuf.computeSize());
      }
      i = e.a.a.a.c(9, 8, this.wuz);
      AppMethodBeat.o(62571);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        this.wuz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.xeb == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerUrl");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.HeadUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.wuS == null)
        {
          paramVarArgs = new b("Not all required fields were included: BizName");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(62571);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aoc localaoc = (aoc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62571);
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
            localaoc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62571);
          return 0;
        case 2: 
          localaoc.xeb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62571);
          return 0;
        case 3: 
          localaoc.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62571);
          return 0;
        case 4: 
          localaoc.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62571);
          return 0;
        case 5: 
          localaoc.HeadUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62571);
          return 0;
        case 6: 
          localaoc.wuS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62571);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaoc.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62571);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaoc.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62571);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaoc.wuz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(62571);
        return 0;
      }
      AppMethodBeat.o(62571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */