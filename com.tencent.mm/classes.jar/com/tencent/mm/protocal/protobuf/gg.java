package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gg
  extends com.tencent.mm.bx.a
{
  public gh Fyo;
  public gi Fyt;
  public com.tencent.mm.bx.b Fyu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fyt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.Fyo == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.Fyu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.Fyt != null)
      {
        paramVarArgs.lC(1, this.Fyt.computeSize());
        this.Fyt.writeFields(paramVarArgs);
      }
      if (this.Fyo != null)
      {
        paramVarArgs.lC(2, this.Fyo.computeSize());
        this.Fyo.writeFields(paramVarArgs);
      }
      if (this.Fyu != null) {
        paramVarArgs.c(3, this.Fyu);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fyt == null) {
        break label683;
      }
    }
    label683:
    for (int i = f.a.a.a.lB(1, this.Fyt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fyo != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fyo.computeSize());
      }
      i = paramInt;
      if (this.Fyu != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Fyu);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fyt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.Fyo == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.Fyu == null)
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
        gg localgg = (gg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32124);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgg.Fyt = ((gi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgg.Fyo = ((gh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localgg.Fyu = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(32124);
        return 0;
      }
      AppMethodBeat.o(32124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */