package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ff
  extends com.tencent.mm.bv.a
{
  public fg wrl;
  public fh wrq;
  public com.tencent.mm.bv.b wrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28320);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrq == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(28320);
        throw paramVarArgs;
      }
      if (this.wrl == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(28320);
        throw paramVarArgs;
      }
      if (this.wrr == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(28320);
        throw paramVarArgs;
      }
      if (this.wrq != null)
      {
        paramVarArgs.iQ(1, this.wrq.computeSize());
        this.wrq.writeFields(paramVarArgs);
      }
      if (this.wrl != null)
      {
        paramVarArgs.iQ(2, this.wrl.computeSize());
        this.wrl.writeFields(paramVarArgs);
      }
      if (this.wrr != null) {
        paramVarArgs.c(3, this.wrr);
      }
      AppMethodBeat.o(28320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wrq == null) {
        break label683;
      }
    }
    label683:
    for (int i = e.a.a.a.iP(1, this.wrq.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrl != null) {
        paramInt = i + e.a.a.a.iP(2, this.wrl.computeSize());
      }
      i = paramInt;
      if (this.wrr != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.wrr);
      }
      AppMethodBeat.o(28320);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wrq == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(28320);
          throw paramVarArgs;
        }
        if (this.wrl == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(28320);
          throw paramVarArgs;
        }
        if (this.wrr == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(28320);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28320);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ff localff = (ff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28320);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localff.wrq = ((fh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28320);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localff.wrl = ((fg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28320);
          return 0;
        }
        localff.wrr = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(28320);
        return 0;
      }
      AppMethodBeat.o(28320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ff
 * JD-Core Version:    0.7.0.1
 */