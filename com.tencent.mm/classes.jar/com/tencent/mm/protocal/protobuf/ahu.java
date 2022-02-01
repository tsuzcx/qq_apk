package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ahu
  extends com.tencent.mm.bw.a
{
  public int Ekh;
  public SKBuiltinBuffer_t Eki;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ekh);
      if (this.Eki != null)
      {
        paramVarArgs.ln(3, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ekh) + 0;
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.lm(3, this.Eki.computeSize());
      }
      AppMethodBeat.o(127482);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahu localahu = (ahu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(127482);
        return -1;
      case 1: 
        localahu.Ekh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127482);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localahu.Eki = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    AppMethodBeat.o(127482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahu
 * JD-Core Version:    0.7.0.1
 */