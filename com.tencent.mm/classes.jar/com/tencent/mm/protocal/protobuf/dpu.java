package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpu
  extends com.tencent.mm.bw.a
{
  public int FWX;
  public sf FWY;
  public sf FWZ;
  public int FXa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FWX);
      if (this.FWY != null)
      {
        paramVarArgs.ln(4, this.FWY.computeSize());
        this.FWY.writeFields(paramVarArgs);
      }
      if (this.FWZ != null)
      {
        paramVarArgs.ln(5, this.FWZ.computeSize());
        this.FWZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FXa);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FWX) + 0;
      paramInt = i;
      if (this.FWY != null) {
        paramInt = i + f.a.a.a.lm(4, this.FWY.computeSize());
      }
      i = paramInt;
      if (this.FWZ != null) {
        i = paramInt + f.a.a.a.lm(5, this.FWZ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(6, this.FXa);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpu localdpu = (dpu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localdpu.FWX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpu.FWY = ((sf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpu.FWZ = ((sf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localdpu.FXa = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpu
 * JD-Core Version:    0.7.0.1
 */