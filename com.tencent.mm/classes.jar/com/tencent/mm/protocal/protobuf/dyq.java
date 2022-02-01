package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyq
  extends cqk
{
  public int EfV;
  public int FCh;
  public String FhN;
  public int GeA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FhN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117956);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.GeA);
      paramVarArgs.aR(3, this.EfV);
      if (this.FhN != null) {
        paramVarArgs.d(4, this.FhN);
      }
      paramVarArgs.aR(5, this.FCh);
      AppMethodBeat.o(117956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.GeA) + f.a.a.b.b.a.bx(3, this.EfV);
      paramInt = i;
      if (this.FhN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FhN);
      }
      i = f.a.a.b.b.a.bx(5, this.FCh);
      AppMethodBeat.o(117956);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FhN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyq localdyq = (dyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117956);
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
            localdyq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117956);
          return 0;
        case 2: 
          localdyq.GeA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117956);
          return 0;
        case 3: 
          localdyq.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117956);
          return 0;
        case 4: 
          localdyq.FhN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117956);
          return 0;
        }
        localdyq.FCh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117956);
        return 0;
      }
      AppMethodBeat.o(117956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyq
 * JD-Core Version:    0.7.0.1
 */