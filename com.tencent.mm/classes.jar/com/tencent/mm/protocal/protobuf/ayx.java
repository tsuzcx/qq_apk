package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayx
  extends cpx
{
  public String Ewy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ewy == null)
      {
        paramVarArgs = new b("Not all required fields were included: LensId");
        AppMethodBeat.o(104805);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ewy != null) {
        paramVarArgs.d(2, this.Ewy);
      }
      AppMethodBeat.o(104805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ewy != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ewy);
      }
      AppMethodBeat.o(104805);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ewy == null)
        {
          paramVarArgs = new b("Not all required fields were included: LensId");
          AppMethodBeat.o(104805);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104805);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayx localayx = (ayx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104805);
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
            localayx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104805);
          return 0;
        }
        localayx.Ewy = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104805);
        return 0;
      }
      AppMethodBeat.o(104805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayx
 * JD-Core Version:    0.7.0.1
 */