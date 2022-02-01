package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bji
  extends dpc
{
  public com.tencent.mm.bw.b LTa;
  public long LTb;
  public com.tencent.mm.bw.b LTc;
  public ctc LTd;
  public mo LTe;
  public float LTf = 0.5F;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104368);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104368);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LTb);
      if (this.LTc != null) {
        paramVarArgs.c(3, this.LTc);
      }
      if (this.LTd != null)
      {
        paramVarArgs.ni(4, this.LTd.computeSize());
        this.LTd.writeFields(paramVarArgs);
      }
      if (this.LTe != null)
      {
        paramVarArgs.ni(5, this.LTe.computeSize());
        this.LTe.writeFields(paramVarArgs);
      }
      if (this.LTa != null) {
        paramVarArgs.c(6, this.LTa);
      }
      paramVarArgs.E(7, this.LTf);
      AppMethodBeat.o(104368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label881;
      }
    }
    label881:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LTb);
      paramInt = i;
      if (this.LTc != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LTc);
      }
      i = paramInt;
      if (this.LTd != null) {
        i = paramInt + g.a.a.a.nh(4, this.LTd.computeSize());
      }
      paramInt = i;
      if (this.LTe != null) {
        paramInt = i + g.a.a.a.nh(5, this.LTe.computeSize());
      }
      i = paramInt;
      if (this.LTa != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.LTa);
      }
      paramInt = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(104368);
      return i + (paramInt + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bji localbji = (bji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104368);
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
            localbji.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 2: 
          localbji.LTb = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(104368);
          return 0;
        case 3: 
          localbji.LTc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(104368);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbji.LTd = ((ctc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbji.LTe = ((mo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 6: 
          localbji.LTa = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(104368);
          return 0;
        }
        localbji.LTf = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(104368);
        return 0;
      }
      AppMethodBeat.o(104368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bji
 * JD-Core Version:    0.7.0.1
 */