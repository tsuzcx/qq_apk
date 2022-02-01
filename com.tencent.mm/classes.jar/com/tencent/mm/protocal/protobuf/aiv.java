package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aiv
  extends com.tencent.mm.bw.a
{
  public fbr Lsr;
  public String Lss;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lsr != null)
      {
        paramVarArgs.ni(1, this.Lsr.computeSize());
        this.Lsr.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.begin_time);
      paramVarArgs.bb(3, this.duration);
      if (this.Lss != null) {
        paramVarArgs.e(4, this.Lss);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lsr == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.a.nh(1, this.Lsr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.duration);
      paramInt = i;
      if (this.Lss != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lss);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aiv localaiv = (aiv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fbr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaiv.Lsr = ((fbr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localaiv.begin_time = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localaiv.duration = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110893);
          return 0;
        }
        localaiv.Lss = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiv
 * JD-Core Version:    0.7.0.1
 */