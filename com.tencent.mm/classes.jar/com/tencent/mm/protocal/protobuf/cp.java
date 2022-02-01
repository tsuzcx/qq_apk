package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cp
  extends com.tencent.mm.bw.a
{
  public de KGK;
  public String KGL;
  public b KGM;
  public boolean KGN;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226003);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGK != null)
      {
        paramVarArgs.ni(1, this.KGK.computeSize());
        this.KGK.writeFields(paramVarArgs);
      }
      if (this.KGL != null) {
        paramVarArgs.e(2, this.KGL);
      }
      paramVarArgs.bb(3, this.seq);
      if (this.KGM != null) {
        paramVarArgs.c(4, this.KGM);
      }
      paramVarArgs.cc(5, this.KGN);
      AppMethodBeat.o(226003);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGK == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.nh(1, this.KGK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KGL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KGL);
      }
      i += g.a.a.b.b.a.r(3, this.seq);
      paramInt = i;
      if (this.KGM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.KGM);
      }
      i = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(226003);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(226003);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cp localcp = (cp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(226003);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcp.KGK = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(226003);
          return 0;
        case 2: 
          localcp.KGL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(226003);
          return 0;
        case 3: 
          localcp.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(226003);
          return 0;
        case 4: 
          localcp.KGM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(226003);
          return 0;
        }
        localcp.KGN = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(226003);
        return 0;
      }
      AppMethodBeat.o(226003);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cp
 * JD-Core Version:    0.7.0.1
 */