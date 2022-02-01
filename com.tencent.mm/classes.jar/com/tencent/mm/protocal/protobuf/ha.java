package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ha
  extends com.tencent.mm.bx.a
{
  public hc YIC;
  public com.tencent.mm.bx.b YID;
  public hb YIx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIC == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.YIx == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.YID == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.YIC != null)
      {
        paramVarArgs.qD(1, this.YIC.computeSize());
        this.YIC.writeFields(paramVarArgs);
      }
      if (this.YIx != null)
      {
        paramVarArgs.qD(2, this.YIx.computeSize());
        this.YIx.writeFields(paramVarArgs);
      }
      if (this.YID != null) {
        paramVarArgs.d(3, this.YID);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIC == null) {
        break label635;
      }
    }
    label635:
    for (int i = i.a.a.a.qC(1, this.YIC.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIx != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIx.computeSize());
      }
      i = paramInt;
      if (this.YID != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YID);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YIC == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.YIx == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.YID == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32124);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ha localha = (ha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32124);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hc)localObject2).parseFrom((byte[])localObject1);
            }
            localha.YIC = ((hc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hb)localObject2).parseFrom((byte[])localObject1);
            }
            localha.YIx = ((hb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localha.YID = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(32124);
        return 0;
      }
      AppMethodBeat.o(32124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */