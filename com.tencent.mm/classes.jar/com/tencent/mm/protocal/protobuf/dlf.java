package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlf
  extends cpx
{
  public mk EIW;
  public String Ebs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebs == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124572);
        throw paramVarArgs;
      }
      if (this.EIW == null)
      {
        paramVarArgs = new b("Not all required fields were included: chat");
        AppMethodBeat.o(124572);
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
      if (this.EIW != null)
      {
        paramVarArgs.ln(3, this.EIW.computeSize());
        this.EIW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ebs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ebs);
      }
      i = paramInt;
      if (this.EIW != null) {
        i = paramInt + f.a.a.a.lm(3, this.EIW.computeSize());
      }
      AppMethodBeat.o(124572);
      return i;
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
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        if (this.EIW == null)
        {
          paramVarArgs = new b("Not all required fields were included: chat");
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlf localdlf = (dlf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124572);
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
            localdlf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124572);
          return 0;
        case 2: 
          localdlf.Ebs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124572);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlf.EIW = ((mk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      AppMethodBeat.o(124572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlf
 * JD-Core Version:    0.7.0.1
 */