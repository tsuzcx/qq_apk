package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adu
  extends com.tencent.mm.bw.a
{
  public dzi EwB;
  public String EwC;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EwB != null)
      {
        paramVarArgs.ln(1, this.EwB.computeSize());
        this.EwB.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.begin_time);
      paramVarArgs.aO(3, this.duration);
      if (this.EwC != null) {
        paramVarArgs.d(4, this.EwC);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EwB == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lm(1, this.EwB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.EwC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EwC);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadu.EwB = ((dzi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localadu.begin_time = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localadu.duration = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110893);
          return 0;
        }
        localadu.EwC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */