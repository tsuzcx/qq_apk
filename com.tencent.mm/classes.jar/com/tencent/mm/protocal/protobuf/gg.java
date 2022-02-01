package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gg
  extends com.tencent.mm.bw.a
{
  public gh FQM;
  public gi FQR;
  public com.tencent.mm.bw.b FQS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.FQM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.FQS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.FQR != null)
      {
        paramVarArgs.lJ(1, this.FQR.computeSize());
        this.FQR.writeFields(paramVarArgs);
      }
      if (this.FQM != null)
      {
        paramVarArgs.lJ(2, this.FQM.computeSize());
        this.FQM.writeFields(paramVarArgs);
      }
      if (this.FQS != null) {
        paramVarArgs.c(3, this.FQS);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQR == null) {
        break label683;
      }
    }
    label683:
    for (int i = f.a.a.a.lI(1, this.FQR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FQM != null) {
        paramInt = i + f.a.a.a.lI(2, this.FQM.computeSize());
      }
      i = paramInt;
      if (this.FQS != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FQS);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FQR == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.FQM == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.FQS == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgg.FQR = ((gi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgg.FQM = ((gh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localgg.FQS = ((f.a.a.a.a)localObject1).OmT.gCk();
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