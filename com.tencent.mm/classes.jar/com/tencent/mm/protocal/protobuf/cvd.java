package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvd
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t DUf;
  public long Id;
  public int fVE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Id);
      paramVarArgs.aR(2, this.fVE);
      if (this.DUf != null)
      {
        paramVarArgs.kX(3, this.DUf.computeSize());
        this.DUf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0 + f.a.a.b.b.a.bA(2, this.fVE);
      paramInt = i;
      if (this.DUf != null) {
        paramInt = i + f.a.a.a.kW(3, this.DUf.computeSize());
      }
      AppMethodBeat.o(125795);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvd localcvd = (cvd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125795);
        return -1;
      case 1: 
        localcvd.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125795);
        return 0;
      case 2: 
        localcvd.fVE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125795);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcvd.DUf = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    AppMethodBeat.o(125795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvd
 * JD-Core Version:    0.7.0.1
 */