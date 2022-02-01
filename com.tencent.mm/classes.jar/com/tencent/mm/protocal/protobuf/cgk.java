package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgk
  extends cpx
{
  public int DMq;
  public String DMr;
  public String DMs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114054);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DMq);
      if (this.DMr != null) {
        paramVarArgs.d(3, this.DMr);
      }
      if (this.DMs != null) {
        paramVarArgs.d(4, this.DMs);
      }
      AppMethodBeat.o(114054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DMq);
      paramInt = i;
      if (this.DMr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DMr);
      }
      i = paramInt;
      if (this.DMs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DMs);
      }
      AppMethodBeat.o(114054);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgk localcgk = (cgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114054);
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
            localcgk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114054);
          return 0;
        case 2: 
          localcgk.DMq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114054);
          return 0;
        case 3: 
          localcgk.DMr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114054);
          return 0;
        }
        localcgk.DMs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114054);
        return 0;
      }
      AppMethodBeat.o(114054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgk
 * JD-Core Version:    0.7.0.1
 */