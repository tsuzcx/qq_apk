package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bto
  extends cqk
{
  public String nUe;
  public int nUf;
  public String nUg;
  public String nWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114045);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114045);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nUe != null) {
        paramVarArgs.d(2, this.nUe);
      }
      paramVarArgs.aR(3, this.nUf);
      if (this.nUg != null) {
        paramVarArgs.d(4, this.nUg);
      }
      if (this.nWw != null) {
        paramVarArgs.d(5, this.nWw);
      }
      AppMethodBeat.o(114045);
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
      if (this.nUe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nUe);
      }
      i += f.a.a.b.b.a.bx(3, this.nUf);
      paramInt = i;
      if (this.nUg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nUg);
      }
      i = paramInt;
      if (this.nWw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nWw);
      }
      AppMethodBeat.o(114045);
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
          AppMethodBeat.o(114045);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bto localbto = (bto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114045);
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
            localbto.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114045);
          return 0;
        case 2: 
          localbto.nUe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114045);
          return 0;
        case 3: 
          localbto.nUf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114045);
          return 0;
        case 4: 
          localbto.nUg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114045);
          return 0;
        }
        localbto.nWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114045);
        return 0;
      }
      AppMethodBeat.o(114045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bto
 * JD-Core Version:    0.7.0.1
 */