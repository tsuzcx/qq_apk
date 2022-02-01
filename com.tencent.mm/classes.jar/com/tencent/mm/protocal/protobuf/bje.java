package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bje
  extends cqk
{
  public SKBuiltinBuffer_t DTz;
  public SKBuiltinBuffer_t EYm;
  public SKBuiltinBuffer_t EYn;
  public int EYo;
  public int EYp;
  public int EYq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.DTz == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.EYm == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.EYn == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DTz != null)
      {
        paramVarArgs.ln(2, this.DTz.computeSize());
        this.DTz.writeFields(paramVarArgs);
      }
      if (this.EYm != null)
      {
        paramVarArgs.ln(3, this.EYm.computeSize());
        this.EYm.writeFields(paramVarArgs);
      }
      if (this.EYn != null)
      {
        paramVarArgs.ln(4, this.EYn.computeSize());
        this.EYn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EYo);
      paramVarArgs.aR(6, this.EYp);
      paramVarArgs.aR(7, this.EYq);
      AppMethodBeat.o(32319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1127;
      }
    }
    label1127:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTz != null) {
        paramInt = i + f.a.a.a.lm(2, this.DTz.computeSize());
      }
      i = paramInt;
      if (this.EYm != null) {
        i = paramInt + f.a.a.a.lm(3, this.EYm.computeSize());
      }
      paramInt = i;
      if (this.EYn != null) {
        paramInt = i + f.a.a.a.lm(4, this.EYn.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.EYo);
      int j = f.a.a.b.b.a.bx(6, this.EYp);
      int k = f.a.a.b.b.a.bx(7, this.EYq);
      AppMethodBeat.o(32319);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.DTz == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.EYm == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.EYn == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bje localbje = (bje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32319);
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
            localbje.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbje.DTz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbje.EYm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            localbje.EYn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 5: 
          localbje.EYo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32319);
          return 0;
        case 6: 
          localbje.EYp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32319);
          return 0;
        }
        localbje.EYq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32319);
        return 0;
      }
      AppMethodBeat.o(32319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bje
 * JD-Core Version:    0.7.0.1
 */