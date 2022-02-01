package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbn
  extends cqk
{
  public String ERZ;
  public int ESa;
  public int ESb;
  public int EwS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ERZ != null) {
        paramVarArgs.d(2, this.ERZ);
      }
      paramVarArgs.aR(3, this.ESa);
      paramVarArgs.aR(4, this.EwS);
      paramVarArgs.aR(5, this.ESb);
      AppMethodBeat.o(91496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ERZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ERZ);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.ESa);
      int j = f.a.a.b.b.a.bx(4, this.EwS);
      int k = f.a.a.b.b.a.bx(5, this.ESb);
      AppMethodBeat.o(91496);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(91496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbn localbbn = (bbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91496);
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
            localbbn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91496);
          return 0;
        case 2: 
          localbbn.ERZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91496);
          return 0;
        case 3: 
          localbbn.ESa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91496);
          return 0;
        case 4: 
          localbbn.EwS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91496);
          return 0;
        }
        localbbn.ESb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91496);
        return 0;
      }
      AppMethodBeat.o(91496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */