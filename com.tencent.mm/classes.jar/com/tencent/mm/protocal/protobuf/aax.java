package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aax
  extends com.tencent.mm.bw.a
{
  public int Lmf;
  public SKBuiltinBuffer_t Lmg;
  public int Lmh;
  public SKBuiltinBuffer_t Lmi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmg == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lmf);
      if (this.Lmg != null)
      {
        paramVarArgs.ni(2, this.Lmg.computeSize());
        this.Lmg.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Lmh);
      if (this.Lmi != null)
      {
        paramVarArgs.ni(4, this.Lmi.computeSize());
        this.Lmi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lmf) + 0;
      paramInt = i;
      if (this.Lmg != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lmg.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Lmh);
      paramInt = i;
      if (this.Lmi != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lmi.computeSize());
      }
      AppMethodBeat.o(145668);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Lmg == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aax localaax = (aax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localaax.Lmf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaax.Lmg = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localaax.Lmh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localaax.Lmi = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aax
 * JD-Core Version:    0.7.0.1
 */