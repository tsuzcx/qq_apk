package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ks
  extends com.tencent.mm.cd.a
{
  public LinkedList<kr> RPR;
  public kq RPS;
  public int RPT;
  
  public ks()
  {
    AppMethodBeat.i(82389);
    this.RPR = new LinkedList();
    AppMethodBeat.o(82389);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RPR);
      if (this.RPS != null)
      {
        paramVarArgs.oE(2, this.RPS.computeSize());
        this.RPS.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.RPT);
      AppMethodBeat.o(82390);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RPR) + 0;
      paramInt = i;
      if (this.RPS != null) {
        paramInt = i + g.a.a.a.oD(2, this.RPS.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.RPT);
      AppMethodBeat.o(82390);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RPR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(82390);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ks localks = (ks)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82390);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new kr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((kr)localObject2).parseFrom((byte[])localObject1);
          }
          localks.RPR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new kq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((kq)localObject2).parseFrom((byte[])localObject1);
          }
          localks.RPS = ((kq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      }
      localks.RPT = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(82390);
      return 0;
    }
    AppMethodBeat.o(82390);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ks
 * JD-Core Version:    0.7.0.1
 */