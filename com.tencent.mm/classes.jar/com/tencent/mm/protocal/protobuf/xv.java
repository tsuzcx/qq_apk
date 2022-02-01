package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class xv
  extends com.tencent.mm.bw.a
{
  public int ErL;
  public SKBuiltinBuffer_t ErM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ErM == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(133166);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ErL);
      if (this.ErM != null)
      {
        paramVarArgs.ln(2, this.ErM.computeSize());
        this.ErM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ErL) + 0;
      paramInt = i;
      if (this.ErM != null) {
        paramInt = i + f.a.a.a.lm(2, this.ErM.computeSize());
      }
      AppMethodBeat.o(133166);
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
      if (this.ErM == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(133166);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xv localxv = (xv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133166);
        return -1;
      case 1: 
        localxv.ErL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133166);
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
        localxv.ErM = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    AppMethodBeat.o(133166);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xv
 * JD-Core Version:    0.7.0.1
 */