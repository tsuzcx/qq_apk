package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpr
  extends cqk
{
  public int Epu;
  public int FAV;
  public dqq FBa;
  public String FWV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.FBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FBa != null)
      {
        paramVarArgs.ln(2, this.FBa.computeSize());
        this.FBa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Epu);
      paramVarArgs.aR(4, this.FAV);
      if (this.FWV != null) {
        paramVarArgs.d(5, this.FWV);
      }
      AppMethodBeat.o(32497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FBa != null) {
        i = paramInt + f.a.a.a.lm(2, this.FBa.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.Epu) + f.a.a.b.b.a.bx(4, this.FAV);
      paramInt = i;
      if (this.FWV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FWV);
      }
      AppMethodBeat.o(32497);
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
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        if (this.FBa == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpr localdpr = (dpr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32497);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpr.FBa = ((dqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 3: 
          localdpr.Epu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32497);
          return 0;
        case 4: 
          localdpr.FAV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32497);
          return 0;
        }
        localdpr.FWV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32497);
        return 0;
      }
      AppMethodBeat.o(32497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpr
 * JD-Core Version:    0.7.0.1
 */