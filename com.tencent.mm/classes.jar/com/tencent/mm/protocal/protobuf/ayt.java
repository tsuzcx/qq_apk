package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayt
  extends cqk
{
  public int EIm;
  public String EIn;
  public String EIo;
  public int EIp;
  public String EIq;
  public String EQa;
  public String EQb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EQa != null) {
        paramVarArgs.d(2, this.EQa);
      }
      paramVarArgs.aR(3, this.EIm);
      if (this.EIn != null) {
        paramVarArgs.d(4, this.EIn);
      }
      if (this.EIo != null) {
        paramVarArgs.d(5, this.EIo);
      }
      paramVarArgs.aR(6, this.EIp);
      if (this.EIq != null) {
        paramVarArgs.d(7, this.EIq);
      }
      if (this.EQb != null) {
        paramVarArgs.d(8, this.EQb);
      }
      AppMethodBeat.o(91490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EQa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EQa);
      }
      i += f.a.a.b.b.a.bx(3, this.EIm);
      paramInt = i;
      if (this.EIn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIn);
      }
      i = paramInt;
      if (this.EIo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EIo);
      }
      i += f.a.a.b.b.a.bx(6, this.EIp);
      paramInt = i;
      if (this.EIq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EIq);
      }
      i = paramInt;
      if (this.EQb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EQb);
      }
      AppMethodBeat.o(91490);
      return i;
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
          AppMethodBeat.o(91490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayt localayt = (ayt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91490);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91490);
          return 0;
        case 2: 
          localayt.EQa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 3: 
          localayt.EIm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91490);
          return 0;
        case 4: 
          localayt.EIn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 5: 
          localayt.EIo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 6: 
          localayt.EIp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91490);
          return 0;
        case 7: 
          localayt.EIq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91490);
          return 0;
        }
        localayt.EQb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91490);
        return 0;
      }
      AppMethodBeat.o(91490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayt
 * JD-Core Version:    0.7.0.1
 */