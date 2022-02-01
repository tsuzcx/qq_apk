package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apc
  extends com.tencent.mm.bw.a
{
  public bju EHZ;
  public int EIa = -1;
  public int EIb = -1;
  public boolean EIc = false;
  public int EId = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.EHZ != null)
      {
        paramVarArgs.ln(2, this.EHZ.computeSize());
        this.EHZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EIa);
      paramVarArgs.aR(4, this.EIb);
      paramVarArgs.bl(5, this.EIc);
      paramVarArgs.aR(6, this.EId);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.EHZ != null) {
        paramInt = i + f.a.a.a.lm(2, this.EHZ.computeSize());
      }
      i = f.a.a.b.b.a.bx(3, this.EIa);
      int j = f.a.a.b.b.a.bx(4, this.EIb);
      int k = f.a.a.b.b.a.fK(5);
      int m = f.a.a.b.b.a.bx(6, this.EId);
      AppMethodBeat.o(122490);
      return paramInt + i + j + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      apc localapc = (apc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localapc.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bju();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapc.EHZ = ((bju)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localapc.EIa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localapc.EIb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localapc.EIc = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122490);
        return 0;
      }
      localapc.EId = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apc
 * JD-Core Version:    0.7.0.1
 */