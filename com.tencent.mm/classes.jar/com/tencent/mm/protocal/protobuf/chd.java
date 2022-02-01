package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chd
  extends cqk
{
  public String Fvo;
  public String Fvp;
  public String Fvq;
  public String Fvr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91631);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91631);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fvo != null) {
        paramVarArgs.d(2, this.Fvo);
      }
      if (this.Fvp != null) {
        paramVarArgs.d(3, this.Fvp);
      }
      if (this.Fvq != null) {
        paramVarArgs.d(4, this.Fvq);
      }
      if (this.Fvr != null) {
        paramVarArgs.d(5, this.Fvr);
      }
      AppMethodBeat.o(91631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fvo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fvo);
      }
      i = paramInt;
      if (this.Fvp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fvp);
      }
      paramInt = i;
      if (this.Fvq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fvq);
      }
      i = paramInt;
      if (this.Fvr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fvr);
      }
      AppMethodBeat.o(91631);
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
          AppMethodBeat.o(91631);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91631);
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
            localchd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91631);
          return 0;
        case 2: 
          localchd.Fvo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 3: 
          localchd.Fvp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 4: 
          localchd.Fvq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91631);
          return 0;
        }
        localchd.Fvr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91631);
        return 0;
      }
      AppMethodBeat.o(91631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chd
 * JD-Core Version:    0.7.0.1
 */