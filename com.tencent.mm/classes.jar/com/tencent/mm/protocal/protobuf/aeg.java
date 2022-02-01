package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aeg
  extends com.tencent.mm.bw.a
{
  public aeh Exc;
  public aef Exd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Exc == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Exd == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Exc != null)
      {
        paramVarArgs.ln(1, this.Exc.computeSize());
        this.Exc.writeFields(paramVarArgs);
      }
      if (this.Exd != null)
      {
        paramVarArgs.ln(2, this.Exd.computeSize());
        this.Exd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Exc == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.Exc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Exd != null) {
        i = paramInt + f.a.a.a.lm(2, this.Exd.computeSize());
      }
      AppMethodBeat.o(152539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Exc == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        if (this.Exd == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aeg localaeg = (aeg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaeg.Exc = ((aeh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152539);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aef();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaeg.Exd = ((aef)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      AppMethodBeat.o(152539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeg
 * JD-Core Version:    0.7.0.1
 */