package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqq
  extends com.tencent.mm.bw.a
{
  public int FXV;
  public int FXW;
  public SKBuiltinBuffer_t FXX;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FXX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.vTI);
      paramVarArgs.aR(2, this.FXV);
      paramVarArgs.aR(3, this.FXW);
      if (this.FXX != null)
      {
        paramVarArgs.ln(4, this.FXX.computeSize());
        this.FXX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vTI) + 0 + f.a.a.b.b.a.bx(2, this.FXV) + f.a.a.b.b.a.bx(3, this.FXW);
      paramInt = i;
      if (this.FXX != null) {
        paramInt = i + f.a.a.a.lm(4, this.FXX.computeSize());
      }
      AppMethodBeat.o(32499);
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
      if (this.FXX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqq localdqq = (dqq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localdqq.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localdqq.FXV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localdqq.FXW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32499);
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
        localdqq.FXX = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    AppMethodBeat.o(32499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqq
 * JD-Core Version:    0.7.0.1
 */