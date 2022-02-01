package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gh
  extends com.tencent.mm.cd.a
{
  public gi RLl;
  public gj RLq;
  public com.tencent.mm.cd.b RLr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLq == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.RLl == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.RLr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.RLq != null)
      {
        paramVarArgs.oE(1, this.RLq.computeSize());
        this.RLq.writeFields(paramVarArgs);
      }
      if (this.RLl != null)
      {
        paramVarArgs.oE(2, this.RLl.computeSize());
        this.RLl.writeFields(paramVarArgs);
      }
      if (this.RLr != null) {
        paramVarArgs.c(3, this.RLr);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RLq == null) {
        break label639;
      }
    }
    label639:
    for (int i = g.a.a.a.oD(1, this.RLq.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLl != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLl.computeSize());
      }
      i = paramInt;
      if (this.RLr != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.RLr);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLq == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.RLl == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.RLr == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32124);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gh localgh = (gh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32124);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gj)localObject2).parseFrom((byte[])localObject1);
            }
            localgh.RLq = ((gj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gi)localObject2).parseFrom((byte[])localObject1);
            }
            localgh.RLl = ((gi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localgh.RLr = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(32124);
        return 0;
      }
      AppMethodBeat.o(32124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gh
 * JD-Core Version:    0.7.0.1
 */