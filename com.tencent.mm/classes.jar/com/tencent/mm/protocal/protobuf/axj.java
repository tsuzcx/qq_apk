package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axj
  extends cqk
{
  public long DPO;
  public int EPj;
  public int EPk;
  public int EPl;
  public long ndi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.DPO);
      paramVarArgs.aO(3, this.ndi);
      paramVarArgs.aR(4, this.EPj);
      paramVarArgs.aR(5, this.EPk);
      paramVarArgs.aR(6, this.EPl);
      AppMethodBeat.o(127496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.DPO);
      int j = f.a.a.b.b.a.p(3, this.ndi);
      int k = f.a.a.b.b.a.bx(4, this.EPj);
      int m = f.a.a.b.b.a.bx(5, this.EPk);
      int n = f.a.a.b.b.a.bx(6, this.EPl);
      AppMethodBeat.o(127496);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(127496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axj localaxj = (axj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127496);
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
            localaxj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127496);
          return 0;
        case 2: 
          localaxj.DPO = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(127496);
          return 0;
        case 3: 
          localaxj.ndi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(127496);
          return 0;
        case 4: 
          localaxj.EPj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127496);
          return 0;
        case 5: 
          localaxj.EPk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127496);
          return 0;
        }
        localaxj.EPl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127496);
        return 0;
      }
      AppMethodBeat.o(127496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axj
 * JD-Core Version:    0.7.0.1
 */