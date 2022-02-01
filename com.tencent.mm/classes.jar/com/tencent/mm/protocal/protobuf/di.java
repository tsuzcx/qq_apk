package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class di
  extends com.tencent.mm.bw.a
{
  public czp DQo;
  public crm DQp;
  public int DQq;
  public cob DQr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQo == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.DQo != null)
      {
        paramVarArgs.ln(1, this.DQo.computeSize());
        this.DQo.writeFields(paramVarArgs);
      }
      if (this.DQp != null)
      {
        paramVarArgs.ln(2, this.DQp.computeSize());
        this.DQp.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DQq);
      if (this.DQr != null)
      {
        paramVarArgs.ln(4, this.DQr.computeSize());
        this.DQr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQo == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lm(1, this.DQo.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DQp != null) {
        i = paramInt + f.a.a.a.lm(2, this.DQp.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.DQq);
      paramInt = i;
      if (this.DQr != null) {
        paramInt = i + f.a.a.a.lm(4, this.DQr.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DQo == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdi.DQo = ((czp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdi.DQp = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localdi.DQq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdi.DQr = ((cob)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.di
 * JD-Core Version:    0.7.0.1
 */