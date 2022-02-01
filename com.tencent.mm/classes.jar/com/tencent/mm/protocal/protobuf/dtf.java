package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtf
  extends cqk
{
  public int EfS;
  public SKBuiltinBuffer_t Eki;
  public int Exf;
  public long Exg;
  public drv Gbw;
  
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
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.Gbw == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Exf);
      if (this.Eki != null)
      {
        paramVarArgs.ln(4, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      if (this.Gbw != null)
      {
        paramVarArgs.ln(5, this.Gbw.computeSize());
        this.Gbw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.EfS);
      paramVarArgs.aO(8, this.Exg);
      AppMethodBeat.o(115926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(3, this.Exf);
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eki.computeSize());
      }
      i = paramInt;
      if (this.Gbw != null) {
        i = paramInt + f.a.a.a.lm(5, this.Gbw.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(7, this.EfS);
      int j = f.a.a.b.b.a.p(8, this.Exg);
      AppMethodBeat.o(115926);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.Eki == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.Gbw == null)
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
        dtf localdtf = (dtf)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 3: 
          localdtf.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115926);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtf.Eki = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtf.Gbw = ((drv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 7: 
          localdtf.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115926);
          return 0;
        }
        localdtf.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(115926);
        return 0;
      }
      AppMethodBeat.o(115926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtf
 * JD-Core Version:    0.7.0.1
 */