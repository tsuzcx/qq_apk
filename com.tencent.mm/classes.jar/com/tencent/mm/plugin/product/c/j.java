package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public int drx;
  public String lze;
  public g vFE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.drx);
      if (this.vFE != null)
      {
        paramVarArgs.ln(2, this.vFE.computeSize());
        this.vFE.writeFields(paramVarArgs);
      }
      if (this.lze != null) {
        paramVarArgs.d(3, this.lze);
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.drx) + 0;
      paramInt = i;
      if (this.vFE != null) {
        paramInt = i + f.a.a.a.lm(2, this.vFE.computeSize());
      }
      i = paramInt;
      if (this.lze != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.lze);
      }
      AppMethodBeat.o(91276);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91276);
        return -1;
      case 1: 
        localj.drx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91276);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.vFE = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91276);
        return 0;
      }
      localj.lze = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91276);
      return 0;
    }
    AppMethodBeat.o(91276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.j
 * JD-Core Version:    0.7.0.1
 */