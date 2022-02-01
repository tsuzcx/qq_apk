package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcf
  extends cqk
{
  public int DWU;
  public String DWV;
  public String ESp;
  public String ESq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91505);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ESp != null) {
        paramVarArgs.d(2, this.ESp);
      }
      paramVarArgs.aR(3, this.DWU);
      if (this.DWV != null) {
        paramVarArgs.d(4, this.DWV);
      }
      if (this.ESq != null) {
        paramVarArgs.d(5, this.ESq);
      }
      AppMethodBeat.o(91505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ESp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ESp);
      }
      i += f.a.a.b.b.a.bx(3, this.DWU);
      paramInt = i;
      if (this.DWV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DWV);
      }
      i = paramInt;
      if (this.ESq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ESq);
      }
      AppMethodBeat.o(91505);
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
          AppMethodBeat.o(91505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcf localbcf = (bcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91505);
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
            localbcf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91505);
          return 0;
        case 2: 
          localbcf.ESp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91505);
          return 0;
        case 3: 
          localbcf.DWU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91505);
          return 0;
        case 4: 
          localbcf.DWV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91505);
          return 0;
        }
        localbcf.ESq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91505);
        return 0;
      }
      AppMethodBeat.o(91505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */