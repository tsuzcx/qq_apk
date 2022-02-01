package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public int dtM;
  public String kXu;
  public g uwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dtM);
      if (this.uwL != null)
      {
        paramVarArgs.kX(2, this.uwL.computeSize());
        this.uwL.writeFields(paramVarArgs);
      }
      if (this.kXu != null) {
        paramVarArgs.d(3, this.kXu);
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.dtM) + 0;
      paramInt = i;
      if (this.uwL != null) {
        paramInt = i + f.a.a.a.kW(2, this.uwL.computeSize());
      }
      i = paramInt;
      if (this.kXu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kXu);
      }
      AppMethodBeat.o(91276);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localj.dtM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91276);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.uwL = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91276);
        return 0;
      }
      localj.kXu = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91276);
      return 0;
    }
    AppMethodBeat.o(91276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.j
 * JD-Core Version:    0.7.0.1
 */