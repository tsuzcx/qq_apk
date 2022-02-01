package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class op
  extends com.tencent.mm.cd.a
{
  public String RRT;
  public int RUc;
  public LinkedList<oo> RWC;
  public pb RWD;
  
  public op()
  {
    AppMethodBeat.i(124435);
    this.RWC = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RWC);
      paramVarArgs.aY(3, this.RUc);
      if (this.RRT != null) {
        paramVarArgs.f(4, this.RRT);
      }
      if (this.RWD != null)
      {
        paramVarArgs.oE(5, this.RWD.computeSize());
        this.RWD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RWC) + 0 + g.a.a.b.b.a.bM(3, this.RUc);
      paramInt = i;
      if (this.RRT != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RRT);
      }
      i = paramInt;
      if (this.RWD != null) {
        i = paramInt + g.a.a.a.oD(5, this.RWD.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RWC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      op localop = (op)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new oo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((oo)localObject2).parseFrom((byte[])localObject1);
          }
          localop.RWC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localop.RUc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localop.RRT = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new pb();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((pb)localObject2).parseFrom((byte[])localObject1);
        }
        localop.RWD = ((pb)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.op
 * JD-Core Version:    0.7.0.1
 */