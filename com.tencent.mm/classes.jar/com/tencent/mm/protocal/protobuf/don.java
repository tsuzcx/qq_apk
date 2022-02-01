package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class don
  extends com.tencent.mm.bw.a
{
  public dqm FWi;
  public int aNa;
  public int aNb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWi == null)
      {
        paramVarArgs = new b("Not all required fields were included: materialResp");
        AppMethodBeat.o(110915);
        throw paramVarArgs;
      }
      if (this.FWi != null)
      {
        paramVarArgs.ln(1, this.FWi.computeSize());
        this.FWi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.aNa);
      paramVarArgs.aR(3, this.aNb);
      AppMethodBeat.o(110915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWi == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lm(1, this.FWi.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.aNa);
      int j = f.a.a.b.b.a.bx(3, this.aNb);
      AppMethodBeat.o(110915);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FWi == null)
        {
          paramVarArgs = new b("Not all required fields were included: materialResp");
          AppMethodBeat.o(110915);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        don localdon = (don)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110915);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdon.FWi = ((dqm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110915);
          return 0;
        case 2: 
          localdon.aNa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(110915);
          return 0;
        }
        localdon.aNb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(110915);
        return 0;
      }
      AppMethodBeat.o(110915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.don
 * JD-Core Version:    0.7.0.1
 */