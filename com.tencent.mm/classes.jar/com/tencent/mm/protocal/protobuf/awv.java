package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awv
  extends cqk
{
  public com.tencent.mm.bw.b EOE;
  public int EOG;
  public com.tencent.mm.bw.b EOH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152569);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EOG);
      if (this.EOH != null) {
        paramVarArgs.c(4, this.EOH);
      }
      if (this.EOE != null) {
        paramVarArgs.c(5, this.EOE);
      }
      AppMethodBeat.o(152569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(3, this.EOG);
      paramInt = i;
      if (this.EOH != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EOH);
      }
      i = paramInt;
      if (this.EOE != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.EOE);
      }
      AppMethodBeat.o(152569);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awv localawv = (awv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(152569);
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
            localawv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152569);
          return 0;
        case 3: 
          localawv.EOG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152569);
          return 0;
        case 4: 
          localawv.EOH = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(152569);
          return 0;
        }
        localawv.EOE = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(152569);
        return 0;
      }
      AppMethodBeat.o(152569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awv
 * JD-Core Version:    0.7.0.1
 */