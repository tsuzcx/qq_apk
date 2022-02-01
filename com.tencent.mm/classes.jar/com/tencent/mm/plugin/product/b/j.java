package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public g MRB;
  public int eQp;
  public String ttL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91276);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.eQp);
      if (this.MRB != null)
      {
        paramVarArgs.qD(2, this.MRB.computeSize());
        this.MRB.writeFields(paramVarArgs);
      }
      if (this.ttL != null) {
        paramVarArgs.g(3, this.ttL);
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.eQp) + 0;
      paramInt = i;
      if (this.MRB != null) {
        paramInt = i + i.a.a.a.qC(2, this.MRB.computeSize());
      }
      i = paramInt;
      if (this.ttL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ttL);
      }
      AppMethodBeat.o(91276);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91276);
        return -1;
      case 1: 
        localj.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91276);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          g localg = new g();
          if ((localObject != null) && (localObject.length > 0)) {
            localg.parseFrom((byte[])localObject);
          }
          localj.MRB = localg;
          paramInt += 1;
        }
        AppMethodBeat.o(91276);
        return 0;
      }
      localj.ttL = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91276);
      return 0;
    }
    AppMethodBeat.o(91276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */