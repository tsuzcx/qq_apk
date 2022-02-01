package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adx
  extends cqk
{
  public boolean EwF;
  public String EwG;
  public String EwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104762);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104762);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.EwF);
      if (this.EwG != null) {
        paramVarArgs.d(3, this.EwG);
      }
      if (this.EwH != null) {
        paramVarArgs.d(4, this.EwH);
      }
      AppMethodBeat.o(104762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.EwG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EwG);
      }
      i = paramInt;
      if (this.EwH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EwH);
      }
      AppMethodBeat.o(104762);
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
          AppMethodBeat.o(104762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adx localadx = (adx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104762);
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
            localadx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104762);
          return 0;
        case 2: 
          localadx.EwF = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(104762);
          return 0;
        case 3: 
          localadx.EwG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104762);
          return 0;
        }
        localadx.EwH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104762);
        return 0;
      }
      AppMethodBeat.o(104762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adx
 * JD-Core Version:    0.7.0.1
 */