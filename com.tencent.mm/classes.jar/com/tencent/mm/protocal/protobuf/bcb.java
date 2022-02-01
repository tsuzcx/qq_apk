package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcb
  extends cqk
{
  public int ESl;
  public String ESm;
  public int EnO;
  public String wYr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wYr != null) {
        paramVarArgs.d(2, this.wYr);
      }
      paramVarArgs.aR(3, this.ESl);
      if (this.ESm != null) {
        paramVarArgs.d(4, this.ESm);
      }
      paramVarArgs.aR(5, this.EnO);
      AppMethodBeat.o(116455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wYr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wYr);
      }
      i += f.a.a.b.b.a.bx(3, this.ESl);
      paramInt = i;
      if (this.ESm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ESm);
      }
      i = f.a.a.b.b.a.bx(5, this.EnO);
      AppMethodBeat.o(116455);
      return paramInt + i;
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
          AppMethodBeat.o(116455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcb localbcb = (bcb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116455);
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
            localbcb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116455);
          return 0;
        case 2: 
          localbcb.wYr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116455);
          return 0;
        case 3: 
          localbcb.ESl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116455);
          return 0;
        case 4: 
          localbcb.ESm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116455);
          return 0;
        }
        localbcb.EnO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116455);
        return 0;
      }
      AppMethodBeat.o(116455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcb
 * JD-Core Version:    0.7.0.1
 */