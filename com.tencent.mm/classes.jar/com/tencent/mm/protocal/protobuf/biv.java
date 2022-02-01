package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class biv
  extends cpx
{
  public String hOf;
  public String iKc;
  public String tju;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.tju == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.tju != null) {
        paramVarArgs.d(3, this.tju);
      }
      if (this.iKc != null) {
        paramVarArgs.d(4, this.iKc);
      }
      AppMethodBeat.o(89660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.tju != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tju);
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iKc);
      }
      AppMethodBeat.o(89660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        if (this.tju == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        biv localbiv = (biv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89660);
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
            localbiv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89660);
          return 0;
        case 2: 
          localbiv.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(89660);
          return 0;
        case 3: 
          localbiv.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(89660);
          return 0;
        }
        localbiv.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(89660);
        return 0;
      }
      AppMethodBeat.o(89660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biv
 * JD-Core Version:    0.7.0.1
 */