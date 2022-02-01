package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dul
  extends com.tencent.mm.bw.a
{
  public dtg GbW;
  public int Gcj;
  public int Gck;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbW == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147817);
        throw paramVarArgs;
      }
      if (this.GbW != null)
      {
        paramVarArgs.ln(1, this.GbW.computeSize());
        this.GbW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Gcj);
      paramVarArgs.aR(3, this.Gck);
      AppMethodBeat.o(147817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbW == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lm(1, this.GbW.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Gcj);
      int j = f.a.a.b.b.a.bx(3, this.Gck);
      AppMethodBeat.o(147817);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.GbW == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147817);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dul localdul = (dul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147817);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dtg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdul.GbW = ((dtg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147817);
          return 0;
        case 2: 
          localdul.Gcj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147817);
          return 0;
        }
        localdul.Gck = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147817);
        return 0;
      }
      AppMethodBeat.o(147817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dul
 * JD-Core Version:    0.7.0.1
 */