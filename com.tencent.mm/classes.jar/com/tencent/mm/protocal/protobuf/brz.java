package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brz
  extends cpx
{
  public bru Fhg;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(10, this.djj);
      }
      if (this.Fhg != null)
      {
        paramVarArgs.ln(20, this.Fhg.computeSize());
        this.Fhg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.djj);
      }
      i = paramInt;
      if (this.Fhg != null) {
        i = paramInt + f.a.a.a.lm(20, this.Fhg.computeSize());
      }
      AppMethodBeat.o(82455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brz localbrz = (brz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82455);
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
            localbrz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82455);
          return 0;
        case 10: 
          localbrz.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82455);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bru();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrz.Fhg = ((bru)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82455);
        return 0;
      }
      AppMethodBeat.o(82455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brz
 * JD-Core Version:    0.7.0.1
 */