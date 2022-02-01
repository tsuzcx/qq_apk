package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class boe
  extends cwj
{
  public SKBuiltinBuffer_t FRr;
  public SKBuiltinBuffer_t Hbk;
  public SKBuiltinBuffer_t Hbl;
  public int Hbm;
  public int Hbn;
  public int Hbo;
  
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
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.Hbk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.Hbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FRr != null)
      {
        paramVarArgs.lJ(2, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      if (this.Hbk != null)
      {
        paramVarArgs.lJ(3, this.Hbk.computeSize());
        this.Hbk.writeFields(paramVarArgs);
      }
      if (this.Hbl != null)
      {
        paramVarArgs.lJ(4, this.Hbl.computeSize());
        this.Hbl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hbm);
      paramVarArgs.aS(6, this.Hbn);
      paramVarArgs.aS(7, this.Hbo);
      AppMethodBeat.o(32319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1127;
      }
    }
    label1127:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRr != null) {
        paramInt = i + f.a.a.a.lI(2, this.FRr.computeSize());
      }
      i = paramInt;
      if (this.Hbk != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hbk.computeSize());
      }
      paramInt = i;
      if (this.Hbl != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hbl.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.Hbm);
      int j = f.a.a.b.b.a.bz(6, this.Hbn);
      int k = f.a.a.b.b.a.bz(7, this.Hbo);
      AppMethodBeat.o(32319);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.FRr == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.Hbk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.Hbl == null)
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
        boe localboe = (boe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32319);
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
            localboe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboe.FRr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboe.Hbk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            localboe.Hbl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 5: 
          localboe.Hbm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32319);
          return 0;
        case 6: 
          localboe.Hbn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32319);
          return 0;
        }
        localboe.Hbo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32319);
        return 0;
      }
      AppMethodBeat.o(32319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boe
 * JD-Core Version:    0.7.0.1
 */