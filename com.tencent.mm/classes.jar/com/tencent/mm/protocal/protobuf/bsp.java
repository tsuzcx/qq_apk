package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsp
  extends dpc
{
  public String Desc;
  public LinkedList<EmotionSummary> EmotionList;
  public String HeadUrl;
  public String KOR;
  public LinkedList<ait> KOp;
  public String LZs;
  public String Name;
  public SKBuiltinBuffer_t ReqBuf;
  
  public bsp()
  {
    AppMethodBeat.i(104811);
    this.EmotionList = new LinkedList();
    this.KOp = new LinkedList();
    AppMethodBeat.o(104811);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.LZs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.HeadUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.KOR == null)
      {
        paramVarArgs = new b("Not all required fields were included: BizName");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LZs != null) {
        paramVarArgs.e(2, this.LZs);
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
      if (this.KOR != null) {
        paramVarArgs.e(6, this.KOR);
      }
      paramVarArgs.e(7, 8, this.EmotionList);
      if (this.ReqBuf != null)
      {
        paramVarArgs.ni(8, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.KOp);
      AppMethodBeat.o(104812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1390;
      }
    }
    label1390:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LZs != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LZs);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HeadUrl);
      }
      paramInt = i;
      if (this.KOR != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KOR);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.EmotionList);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + g.a.a.a.nh(8, this.ReqBuf.computeSize());
      }
      i = g.a.a.a.c(9, 8, this.KOp);
      AppMethodBeat.o(104812);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        this.KOp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.LZs == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.HeadUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.KOR == null)
        {
          paramVarArgs = new b("Not all required fields were included: BizName");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsp localbsp = (bsp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104812);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbsp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 2: 
          localbsp.LZs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 3: 
          localbsp.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 4: 
          localbsp.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 5: 
          localbsp.HeadUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 6: 
          localbsp.KOR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbsp.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbsp.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ait();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ait)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbsp.KOp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      AppMethodBeat.o(104812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */