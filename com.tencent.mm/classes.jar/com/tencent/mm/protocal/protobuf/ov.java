package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ov
  extends com.tencent.mm.bw.a
{
  public String KQV;
  public int KTf;
  public LinkedList<ou> KVw;
  public pf KVx;
  
  public ov()
  {
    AppMethodBeat.i(124435);
    this.KVw = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KVw);
      paramVarArgs.aM(3, this.KTf);
      if (this.KQV != null) {
        paramVarArgs.e(4, this.KQV);
      }
      if (this.KVx != null)
      {
        paramVarArgs.ni(5, this.KVx.computeSize());
        this.KVx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.KVw) + 0 + g.a.a.b.b.a.bu(3, this.KTf);
      paramInt = i;
      if (this.KQV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KQV);
      }
      i = paramInt;
      if (this.KVx != null) {
        i = paramInt + g.a.a.a.nh(5, this.KVx.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KVw.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ov localov = (ov)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ou();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localov.KVw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localov.KTf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localov.KQV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pf();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localov.KVx = ((pf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ov
 * JD-Core Version:    0.7.0.1
 */