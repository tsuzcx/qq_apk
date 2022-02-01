package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axy
  extends com.tencent.mm.bw.a
{
  public bjb DXx;
  public int EPB;
  public int EPC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DXx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EPB);
      paramVarArgs.aR(2, this.EPC);
      if (this.DXx != null)
      {
        paramVarArgs.ln(3, this.DXx.computeSize());
        this.DXx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EPB) + 0 + f.a.a.b.b.a.bx(2, this.EPC);
      paramInt = i;
      if (this.DXx != null) {
        paramInt = i + f.a.a.a.lm(3, this.DXx.computeSize());
      }
      AppMethodBeat.o(82410);
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
      if (this.DXx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      axy localaxy = (axy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82410);
        return -1;
      case 1: 
        localaxy.EPB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82410);
        return 0;
      case 2: 
        localaxy.EPC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82410);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaxy.DXx = ((bjb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    AppMethodBeat.o(82410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axy
 * JD-Core Version:    0.7.0.1
 */