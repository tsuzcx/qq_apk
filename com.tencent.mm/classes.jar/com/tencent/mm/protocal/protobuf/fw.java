package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fw
  extends com.tencent.mm.bw.a
{
  public int DSP;
  public int DSQ;
  public int DSX;
  public fx DSY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DSP);
      paramVarArgs.aR(2, this.DSQ);
      paramVarArgs.aR(3, this.DSX);
      if (this.DSY != null)
      {
        paramVarArgs.ln(4, this.DSY.computeSize());
        this.DSY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.DSP) + 0 + f.a.a.b.b.a.bx(2, this.DSQ) + f.a.a.b.b.a.bx(3, this.DSX);
      paramInt = i;
      if (this.DSY != null) {
        paramInt = i + f.a.a.a.lm(4, this.DSY.computeSize());
      }
      AppMethodBeat.o(32120);
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
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      fw localfw = (fw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localfw.DSP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localfw.DSQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localfw.DSX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((fx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localfw.DSY = ((fx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */