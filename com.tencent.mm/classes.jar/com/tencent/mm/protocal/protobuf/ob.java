package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ob
  extends com.tencent.mm.bw.a
{
  public String FXj;
  public int FZk;
  public LinkedList<oa> Gby;
  public oi Gbz;
  
  public ob()
  {
    AppMethodBeat.i(124435);
    this.Gby = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Gby);
      paramVarArgs.aS(3, this.FZk);
      if (this.FXj != null) {
        paramVarArgs.d(4, this.FXj);
      }
      if (this.Gbz != null)
      {
        paramVarArgs.lJ(5, this.Gbz.computeSize());
        this.Gbz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Gby) + 0 + f.a.a.b.b.a.bz(3, this.FZk);
      paramInt = i;
      if (this.FXj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FXj);
      }
      i = paramInt;
      if (this.Gbz != null) {
        i = paramInt + f.a.a.a.lI(5, this.Gbz.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gby.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ob localob = (ob)paramVarArgs[1];
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
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((oa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localob.Gby.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localob.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localob.FXj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new oi();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localob.Gbz = ((oi)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ob
 * JD-Core Version:    0.7.0.1
 */