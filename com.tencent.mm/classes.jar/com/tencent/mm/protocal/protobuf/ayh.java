package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayh
  extends cld
{
  public String CEP;
  public LinkedList<act> CEq;
  public String Desc;
  public String DwN;
  public LinkedList<EmotionSummary> EmotionList;
  public String HeadUrl;
  public String Name;
  public SKBuiltinBuffer_t ReqBuf;
  
  public ayh()
  {
    AppMethodBeat.i(104811);
    this.EmotionList = new LinkedList();
    this.CEq = new LinkedList();
    AppMethodBeat.o(104811);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.DwN == null)
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
      if (this.CEP == null)
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DwN != null) {
        paramVarArgs.d(2, this.DwN);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.HeadUrl != null) {
        paramVarArgs.d(5, this.HeadUrl);
      }
      if (this.CEP != null) {
        paramVarArgs.d(6, this.CEP);
      }
      paramVarArgs.e(7, 8, this.EmotionList);
      if (this.ReqBuf != null)
      {
        paramVarArgs.kX(8, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.CEq);
      AppMethodBeat.o(104812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1390;
      }
    }
    label1390:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DwN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DwN);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HeadUrl);
      }
      paramInt = i;
      if (this.CEP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CEP);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.EmotionList);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + f.a.a.a.kW(8, this.ReqBuf.computeSize());
      }
      i = f.a.a.a.c(9, 8, this.CEq);
      AppMethodBeat.o(104812);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        this.CEq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.DwN == null)
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
        if (this.CEP == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayh localayh = (ayh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104812);
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
            localayh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 2: 
          localayh.DwN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 3: 
          localayh.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 4: 
          localayh.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 5: 
          localayh.HeadUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 6: 
          localayh.CEP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayh.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayh.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new act();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((act)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayh.CEq.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayh
 * JD-Core Version:    0.7.0.1
 */