package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agm
  extends com.tencent.mm.bw.a
{
  public ehb GwL;
  public String GwM;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GwL != null)
      {
        paramVarArgs.lJ(1, this.GwL.computeSize());
        this.GwL.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.begin_time);
      paramVarArgs.aZ(3, this.duration);
      if (this.GwM != null) {
        paramVarArgs.d(4, this.GwM);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GwL == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lI(1, this.GwL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.GwM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GwM);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agm localagm = (agm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ehb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagm.GwL = ((ehb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localagm.begin_time = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localagm.duration = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110893);
          return 0;
        }
        localagm.GwM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agm
 * JD-Core Version:    0.7.0.1
 */