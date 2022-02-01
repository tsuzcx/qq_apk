package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bry
  extends cqk
{
  public String CpB;
  public int CpC;
  public String oGg;
  public String oGh;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82454);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CpB != null) {
        paramVarArgs.d(2, this.CpB);
      }
      if (this.oGg != null) {
        paramVarArgs.d(3, this.oGg);
      }
      if (this.oGh != null) {
        paramVarArgs.d(4, this.oGh);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      paramVarArgs.aR(6, this.CpC);
      AppMethodBeat.o(82454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CpB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CpB);
      }
      i = paramInt;
      if (this.oGg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGg);
      }
      paramInt = i;
      if (this.oGh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGh);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sign);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.CpC);
      AppMethodBeat.o(82454);
      return i + paramInt;
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
          AppMethodBeat.o(82454);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bry localbry = (bry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82454);
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
            localbry.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82454);
          return 0;
        case 2: 
          localbry.CpB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 3: 
          localbry.oGg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 4: 
          localbry.oGh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 5: 
          localbry.sign = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82454);
          return 0;
        }
        localbry.CpC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82454);
        return 0;
      }
      AppMethodBeat.o(82454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bry
 * JD-Core Version:    0.7.0.1
 */