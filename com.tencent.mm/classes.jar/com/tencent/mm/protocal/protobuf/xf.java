package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class xf
  extends com.tencent.mm.bw.a
{
  public int ErA;
  public SKBuiltinBuffer_t ErB;
  public int Ery;
  public SKBuiltinBuffer_t Erz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Erz == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ery);
      if (this.Erz != null)
      {
        paramVarArgs.ln(2, this.Erz.computeSize());
        this.Erz.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.ErA);
      if (this.ErB != null)
      {
        paramVarArgs.ln(4, this.ErB.computeSize());
        this.ErB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ery) + 0;
      paramInt = i;
      if (this.Erz != null) {
        paramInt = i + f.a.a.a.lm(2, this.Erz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.ErA);
      paramInt = i;
      if (this.ErB != null) {
        paramInt = i + f.a.a.a.lm(4, this.ErB.computeSize());
      }
      AppMethodBeat.o(145668);
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
      if (this.Erz == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xf localxf = (xf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localxf.Ery = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxf.Erz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localxf.ErA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localxf.ErB = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xf
 * JD-Core Version:    0.7.0.1
 */