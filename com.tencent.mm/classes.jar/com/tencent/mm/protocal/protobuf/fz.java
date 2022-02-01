package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fz
  extends com.tencent.mm.bw.a
{
  public ga DSV;
  public gb DTa;
  public com.tencent.mm.bw.b DTb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.DSV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.DTb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.DTa != null)
      {
        paramVarArgs.ln(1, this.DTa.computeSize());
        this.DTa.writeFields(paramVarArgs);
      }
      if (this.DSV != null)
      {
        paramVarArgs.ln(2, this.DSV.computeSize());
        this.DSV.writeFields(paramVarArgs);
      }
      if (this.DTb != null) {
        paramVarArgs.c(3, this.DTb);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DTa == null) {
        break label683;
      }
    }
    label683:
    for (int i = f.a.a.a.lm(1, this.DTa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DSV != null) {
        paramInt = i + f.a.a.a.lm(2, this.DSV.computeSize());
      }
      i = paramInt;
      if (this.DTb != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.DTb);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DTa == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.DSV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.DTb == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32124);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fz localfz = (fz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32124);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfz.DTa = ((gb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ga();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfz.DSV = ((ga)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localfz.DTb = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(32124);
        return 0;
      }
      AppMethodBeat.o(32124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fz
 * JD-Core Version:    0.7.0.1
 */