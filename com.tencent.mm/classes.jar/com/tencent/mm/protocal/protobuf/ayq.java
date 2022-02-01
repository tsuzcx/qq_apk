package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayq
  extends cpx
{
  public dh EPW;
  public String Egf;
  public String EhR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EPW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Address");
        AppMethodBeat.o(91486);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Egf != null) {
        paramVarArgs.d(2, this.Egf);
      }
      if (this.EhR != null) {
        paramVarArgs.d(3, this.EhR);
      }
      if (this.EPW != null)
      {
        paramVarArgs.ln(4, this.EPW.computeSize());
        this.EPW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Egf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Egf);
      }
      i = paramInt;
      if (this.EhR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EhR);
      }
      paramInt = i;
      if (this.EPW != null) {
        paramInt = i + f.a.a.a.lm(4, this.EPW.computeSize());
      }
      AppMethodBeat.o(91486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EPW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Address");
          AppMethodBeat.o(91486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayq localayq = (ayq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91486);
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
            localayq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91486);
          return 0;
        case 2: 
          localayq.Egf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91486);
          return 0;
        case 3: 
          localayq.EhR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91486);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayq.EPW = ((dh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      AppMethodBeat.o(91486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayq
 * JD-Core Version:    0.7.0.1
 */