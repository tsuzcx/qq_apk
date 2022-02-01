package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqb
  extends cqk
{
  public int FDa;
  public int FDb;
  public String FpH;
  public String Fpu;
  public int Fpw;
  public String skK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.skK != null) {
        paramVarArgs.d(2, this.skK);
      }
      if (this.Fpu != null) {
        paramVarArgs.d(3, this.Fpu);
      }
      paramVarArgs.aR(4, this.FDa);
      paramVarArgs.aR(5, this.FDb);
      paramVarArgs.aR(6, this.Fpw);
      if (this.FpH != null) {
        paramVarArgs.d(7, this.FpH);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.skK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.skK);
      }
      i = paramInt;
      if (this.Fpu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fpu);
      }
      i = i + f.a.a.b.b.a.bx(4, this.FDa) + f.a.a.b.b.a.bx(5, this.FDb) + f.a.a.b.b.a.bx(6, this.Fpw);
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FpH);
      }
      AppMethodBeat.o(91672);
      return paramInt;
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
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqb localcqb = (cqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
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
            localcqb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localcqb.skK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localcqb.Fpu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localcqb.FDa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localcqb.FDb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localcqb.Fpw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91672);
          return 0;
        }
        localcqb.FpH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqb
 * JD-Core Version:    0.7.0.1
 */