package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhi
  extends com.tencent.mm.cd.a
{
  public fhj UHp;
  public fhk UHq;
  public int yAT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.yAT);
      if (this.UHp != null)
      {
        paramVarArgs.oE(2, this.UHp.computeSize());
        this.UHp.writeFields(paramVarArgs);
      }
      if (this.UHq != null)
      {
        paramVarArgs.oE(3, this.UHq.computeSize());
        this.UHq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207792);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.yAT) + 0;
      paramInt = i;
      if (this.UHp != null) {
        paramInt = i + g.a.a.a.oD(2, this.UHp.computeSize());
      }
      i = paramInt;
      if (this.UHq != null) {
        i = paramInt + g.a.a.a.oD(3, this.UHq.computeSize());
      }
      AppMethodBeat.o(207792);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207792);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fhi localfhi = (fhi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207792);
        return -1;
      case 1: 
        localfhi.yAT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207792);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhj)localObject2).parseFrom((byte[])localObject1);
          }
          localfhi.UHp = ((fhj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207792);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fhk();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fhk)localObject2).parseFrom((byte[])localObject1);
        }
        localfhi.UHq = ((fhk)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(207792);
      return 0;
    }
    AppMethodBeat.o(207792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhi
 * JD-Core Version:    0.7.0.1
 */