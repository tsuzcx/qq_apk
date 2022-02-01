package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uu
  extends cqk
{
  public String EoN;
  public String EoO;
  public String EoP;
  public String tlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EoN != null) {
        paramVarArgs.d(2, this.EoN);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      if (this.EoO != null) {
        paramVarArgs.d(4, this.EoO);
      }
      if (this.EoP != null) {
        paramVarArgs.d(5, this.EoP);
      }
      AppMethodBeat.o(124470);
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
      if (this.EoN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EoN);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlJ);
      }
      paramInt = i;
      if (this.EoO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EoO);
      }
      i = paramInt;
      if (this.EoP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EoP);
      }
      AppMethodBeat.o(124470);
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
          AppMethodBeat.o(124470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uu localuu = (uu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124470);
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
            localuu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124470);
          return 0;
        case 2: 
          localuu.EoN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 3: 
          localuu.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 4: 
          localuu.EoO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124470);
          return 0;
        }
        localuu.EoP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124470);
        return 0;
      }
      AppMethodBeat.o(124470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */