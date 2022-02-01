package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public j vFC;
  public String vFD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91272);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vFC != null)
      {
        paramVarArgs.ln(1, this.vFC.computeSize());
        this.vFC.writeFields(paramVarArgs);
      }
      if (this.vFD != null) {
        paramVarArgs.d(2, this.vFD);
      }
      AppMethodBeat.o(91272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFC == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.lm(1, this.vFC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vFD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vFD);
      }
      AppMethodBeat.o(91272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91272);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.vFC = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91272);
          return 0;
        }
        localf.vFD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91272);
        return 0;
      }
      AppMethodBeat.o(91272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.f
 * JD-Core Version:    0.7.0.1
 */