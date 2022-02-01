package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class att
  extends cpx
{
  public int EMA;
  public int EMB;
  public String Ebs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebs == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124504);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ebs != null) {
        paramVarArgs.d(2, this.Ebs);
      }
      paramVarArgs.aR(3, this.EMA);
      paramVarArgs.aR(4, this.EMB);
      AppMethodBeat.o(124504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ebs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ebs);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.EMA);
      int j = f.a.a.b.b.a.bx(4, this.EMB);
      AppMethodBeat.o(124504);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ebs == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124504);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        att localatt = (att)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124504);
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
            localatt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124504);
          return 0;
        case 2: 
          localatt.Ebs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124504);
          return 0;
        case 3: 
          localatt.EMA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124504);
          return 0;
        }
        localatt.EMB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124504);
        return 0;
      }
      AppMethodBeat.o(124504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.att
 * JD-Core Version:    0.7.0.1
 */