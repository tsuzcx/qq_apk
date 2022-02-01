package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfc
  extends cqk
{
  public SKBuiltinBuffer_t EZQ;
  public int EZR;
  public String EZS;
  public int EZT;
  public int Ftx;
  public String Fty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91611);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91611);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EZQ != null)
      {
        paramVarArgs.ln(2, this.EZQ.computeSize());
        this.EZQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EZR);
      if (this.EZS != null) {
        paramVarArgs.d(4, this.EZS);
      }
      paramVarArgs.aR(5, this.EZT);
      paramVarArgs.aR(6, this.Ftx);
      if (this.Fty != null) {
        paramVarArgs.d(7, this.Fty);
      }
      AppMethodBeat.o(91611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EZQ != null) {
        i = paramInt + f.a.a.a.lm(2, this.EZQ.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.EZR);
      paramInt = i;
      if (this.EZS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EZS);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EZT) + f.a.a.b.b.a.bx(6, this.Ftx);
      paramInt = i;
      if (this.Fty != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fty);
      }
      AppMethodBeat.o(91611);
      return paramInt;
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
          AppMethodBeat.o(91611);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfc localcfc = (cfc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91611);
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
            localcfc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
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
            localcfc.EZQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 3: 
          localcfc.EZR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91611);
          return 0;
        case 4: 
          localcfc.EZS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91611);
          return 0;
        case 5: 
          localcfc.EZT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91611);
          return 0;
        case 6: 
          localcfc.Ftx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91611);
          return 0;
        }
        localcfc.Fty = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91611);
        return 0;
      }
      AppMethodBeat.o(91611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfc
 * JD-Core Version:    0.7.0.1
 */