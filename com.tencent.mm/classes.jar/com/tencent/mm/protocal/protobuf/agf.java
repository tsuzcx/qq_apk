package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class agf
  extends cpx
{
  public b Eym;
  public b Eyn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eym != null) {
        paramVarArgs.c(2, this.Eym);
      }
      if (this.Eyn != null) {
        paramVarArgs.c(3, this.Eyn);
      }
      AppMethodBeat.o(149126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eym != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Eym);
      }
      i = paramInt;
      if (this.Eyn != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Eyn);
      }
      AppMethodBeat.o(149126);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(149126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agf localagf = (agf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(149126);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149126);
          return 0;
        case 2: 
          localagf.Eym = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(149126);
          return 0;
        }
        localagf.Eyn = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(149126);
        return 0;
      }
      AppMethodBeat.o(149126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agf
 * JD-Core Version:    0.7.0.1
 */