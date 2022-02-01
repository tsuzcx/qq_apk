package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpo
  extends cpx
{
  public String EVw;
  public int FAV;
  public int FAX;
  public dqq FWU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32494);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWU != null)
      {
        paramVarArgs.ln(2, this.FWU.computeSize());
        this.FWU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FAV);
      paramVarArgs.aR(4, this.FAX);
      if (this.EVw != null) {
        paramVarArgs.d(5, this.EVw);
      }
      AppMethodBeat.o(32494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label673;
      }
    }
    label673:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWU != null) {
        i = paramInt + f.a.a.a.lm(2, this.FWU.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.FAV) + f.a.a.b.b.a.bx(4, this.FAX);
      paramInt = i;
      if (this.EVw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EVw);
      }
      AppMethodBeat.o(32494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FWU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpo localdpo = (dpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32494);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpo.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
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
            for (bool = true; bool; bool = ((dqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpo.FWU = ((dqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
          return 0;
        case 3: 
          localdpo.FAV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32494);
          return 0;
        case 4: 
          localdpo.FAX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32494);
          return 0;
        }
        localdpo.EVw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32494);
        return 0;
      }
      AppMethodBeat.o(32494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */