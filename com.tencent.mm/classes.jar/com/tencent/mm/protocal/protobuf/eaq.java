package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eaq
  extends cwj
{
  public int GeQ;
  public SKBuiltinBuffer_t GjQ;
  public int Gxq;
  public long Gxr;
  public dzg IgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.IgA == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Gxq);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(4, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      if (this.IgA != null)
      {
        paramVarArgs.lJ(5, this.IgA.computeSize());
        this.IgA.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GeQ);
      paramVarArgs.aZ(8, this.Gxr);
      AppMethodBeat.o(115926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.Gxq);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GjQ.computeSize());
      }
      i = paramInt;
      if (this.IgA != null) {
        i = paramInt + f.a.a.a.lI(5, this.IgA.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.GeQ);
      int j = f.a.a.b.b.a.p(8, this.Gxr);
      AppMethodBeat.o(115926);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.GjQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.IgA == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eaq localeaq = (eaq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        default: 
          AppMethodBeat.o(115926);
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
            localeaq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 3: 
          localeaq.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115926);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeaq.GjQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeaq.IgA = ((dzg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 7: 
          localeaq.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115926);
          return 0;
        }
        localeaq.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(115926);
        return 0;
      }
      AppMethodBeat.o(115926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaq
 * JD-Core Version:    0.7.0.1
 */