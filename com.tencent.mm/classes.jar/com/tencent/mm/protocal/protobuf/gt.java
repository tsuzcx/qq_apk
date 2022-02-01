package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gt
  extends com.tencent.mm.bw.a
{
  public gu KKt;
  public gv KKy;
  public com.tencent.mm.bw.b KKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32124);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.KKt == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.KKz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32124);
        throw paramVarArgs;
      }
      if (this.KKy != null)
      {
        paramVarArgs.ni(1, this.KKy.computeSize());
        this.KKy.writeFields(paramVarArgs);
      }
      if (this.KKt != null)
      {
        paramVarArgs.ni(2, this.KKt.computeSize());
        this.KKt.writeFields(paramVarArgs);
      }
      if (this.KKz != null) {
        paramVarArgs.c(3, this.KKz);
      }
      AppMethodBeat.o(32124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KKy == null) {
        break label683;
      }
    }
    label683:
    for (int i = g.a.a.a.nh(1, this.KKy.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KKt != null) {
        paramInt = i + g.a.a.a.nh(2, this.KKt.computeSize());
      }
      i = paramInt;
      if (this.KKz != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.KKz);
      }
      AppMethodBeat.o(32124);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKy == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.KKt == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32124);
          throw paramVarArgs;
        }
        if (this.KKz == null)
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
        gt localgt = (gt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32124);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localgt.KKy = ((gv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localgt.KKt = ((gu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32124);
          return 0;
        }
        localgt.KKz = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(32124);
        return 0;
      }
      AppMethodBeat.o(32124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gt
 * JD-Core Version:    0.7.0.1
 */