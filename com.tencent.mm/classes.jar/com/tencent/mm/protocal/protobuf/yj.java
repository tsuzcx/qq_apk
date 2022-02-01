package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yj
  extends com.tencent.mm.bw.a
{
  public LinkedList<amr> Ljx;
  public ane Ljy;
  public int Scene;
  
  public yj()
  {
    AppMethodBeat.i(127449);
    this.Ljx = new LinkedList();
    AppMethodBeat.o(127449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ljx);
      paramVarArgs.aM(2, this.Scene);
      if (this.Ljy != null)
      {
        paramVarArgs.ni(3, this.Ljy.computeSize());
        this.Ljy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Ljx) + 0 + g.a.a.b.b.a.bu(2, this.Scene);
      paramInt = i;
      if (this.Ljy != null) {
        paramInt = i + g.a.a.a.nh(3, this.Ljy.computeSize());
      }
      AppMethodBeat.o(127450);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ljx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      yj localyj = (yj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127450);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localyj.Ljx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127450);
        return 0;
      case 2: 
        localyj.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127450);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ane();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ane)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localyj.Ljy = ((ane)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    AppMethodBeat.o(127450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */