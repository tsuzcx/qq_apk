package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amq
  extends com.tencent.mm.bx.a
{
  public gjc ZtE;
  public String ZtF;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZtE != null)
      {
        paramVarArgs.qD(1, this.ZtE.computeSize());
        this.ZtE.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.begin_time);
      paramVarArgs.bv(3, this.duration);
      if (this.ZtF != null) {
        paramVarArgs.g(4, this.ZtF);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZtE == null) {
        break label432;
      }
    }
    label432:
    for (paramInt = i.a.a.a.qC(1, this.ZtE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.begin_time) + i.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.ZtF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZtF);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        amq localamq = (amq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gjc localgjc = new gjc();
            if ((localObject != null) && (localObject.length > 0)) {
              localgjc.parseFrom((byte[])localObject);
            }
            localamq.ZtE = localgjc;
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localamq.begin_time = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localamq.duration = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110893);
          return 0;
        }
        localamq.ZtF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */